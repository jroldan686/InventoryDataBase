package jrl.deint.inventoryDataBase.data.db.model;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;

import jrl.deint.inventoryDataBase.data.db.InventoryContract;
import jrl.deint.inventoryDataBase.ui.inventory.InventoryApplication;

/**
 * Created by usuario on 19/01/18.
 */

public class InventoryOpenHelper extends SQLiteOpenHelper {

    private static InventoryOpenHelper singleton;
    private SQLiteDatabase sqLiteDatabase;

    public InventoryOpenHelper() {
        // Se le pasa el CONTEXTO de la APLICACIÓN
        // No usamos factory proque no usamos el patrón Factory para varios Contract
        super(InventoryApplication.getContext(), InventoryContract.DATABASE_NAME,
                null, InventoryContract.DATABASE_VERSION);
    }

    public static InventoryOpenHelper getInstance() {
        if(singleton == null)
            singleton = new InventoryOpenHelper();
        return singleton;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        // Si lo hacemos con Transaction, no se va a crear nada si no está perfecto.
        // Nos daremos cuenta del error cuando no se cree algo.
        // Por eso en principio no usaremos atomicidad.
        sqLiteDatabase.execSQL(InventoryContract.DependencyEntry.SQL_CREATE_ENTRIES);
        sqLiteDatabase.execSQL(InventoryContract.DependencyEntry.SQL_INSERT_ENTRIES);

        // Hay que abrir primero la Base de Datos.
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {

    }

    public void openDatabase(SQLiteDatabase db) {
        // Aquí es cuando se crean las llamadas callback y diferentes métodos
        // Se crea y/o abre la Base de Datos.
        sqLiteDatabase = getWritableDatabase();
    }

    @Override
    public void onOpen(SQLiteDatabase db) {
        super.onOpen(db);
        if(!db.isReadOnly()) {
            if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.JELLY_BEAN) {
                db.setForeignKeyConstraintsEnabled(true);
            }
            else
                //db.execSQL("PRAGMA foreign_keys=ON");
                // Android Studio 3.0
                db.execSQL("PRAGMA foreign_keys=1");        // El 1 equivale a ON
        }
    }
}
