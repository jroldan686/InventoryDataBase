package jrl.deint.inventoryDataBase.data.db.dao;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.Observable;
import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;

import java.util.ArrayList;

import jrl.deint.inventoryDataBase.data.db.InventoryContract;
import jrl.deint.inventoryDataBase.data.db.model.Dependency;
import jrl.deint.inventoryDataBase.data.db.model.InventoryOpenHelper;

/**
 * Created by usuario on 22/01/18.
 */

public class DependencyDao {

    /**
     * Método que devuelve un cursor con todas las dependencias de la base de datos
     * @return Cursor
     */
    public Observable<ArrayList<Dependency>> loadAll() {
        ArrayList<Dependency> dependencies = new ArrayList<>();

        SQLiteDatabase sqLiteDatabase = InventoryOpenHelper.getInstance().openDatabase();
        Cursor cursor = sqLiteDatabase.query(InventoryContract.DependencyEntry.TABLE_NAME,
                InventoryContract.DependencyEntry.ALL_COLUMN,
                            null,
                            null,
                            null,
                            null,
                             InventoryContract.DependencyEntry.DEFAULT_SORT,
                            null);
        dependencies.clear();
        InventoryOpenHelper.getInstance().closeDatabase();
        return cursor;
    }

    public long save(Dependency dependency) {
        InventoryOpenHelper.getInstance().openDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(InventoryContract.DependencyEntry.COLUMN_NAME, dependency.getName());
        contentValues.put(InventoryContract.DependencyEntry.COLUMN_SHORTNAME, dependency.getShortname());
        contentValues.put(InventoryContract.DependencyEntry.COLUMN_DESCRIPTION, dependency.getDescription());
        contentValues.put(InventoryContract.DependencyEntry.COLUMN_IMAGENAME, dependency.getImageName());

        // Null representa las columnas que podrían ser nulas
        long id = sqLiteDatabase.insert(InventoryContract.DependencyEntry.TABLE_NAME, null, contentValues);

        InventoryOpenHelper.getInstance().closeDatabase();

        return id;
    }

    public boolean exists(Dependency dependency) {

    }

    public void update(Dependency dependency) {
        SQLiteDatabase sqLiteDatabase = InventoryOpenHelper.getInstance().openDatabase();
        String whereClause = BaseColumns._ID + "=?";
        String[] whereArgs = new String[]{""+dependency.get_ID()};
        //String[] whereArgs = new String[]{String.valueOf(dependency.get_ID())};       // Otra forma
        sqLiteDatabase.update(InventoryContract.DependencyEntry.TABLE_NAME, createContent(dependency), whereClause, whereArgs);

        InventoryOpenHelper.getInstance().closeDatabase();
    }

    public void delete(Dependency dependency) {

    }

    public ContentValues createContent(Dependency dependency) {

    }
}
