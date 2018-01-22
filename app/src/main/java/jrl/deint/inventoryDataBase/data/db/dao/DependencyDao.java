package jrl.deint.inventoryDataBase.data.db.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import jrl.deint.inventoryDataBase.data.db.InventoryContract;
import jrl.deint.inventoryDataBase.data.db.model.InventoryOpenHelper;

/**
 * Created by usuario on 22/01/18.
 */

public class DependencyDao {

    /**
     * Método que devuelve un cursor con todas las dependencias de la base de datos
     * @return Cursor
     */
    public Cursor loadAll() {
        SQLiteDatabase sqLiteDatabase = InventoryOpenHelper.getInstance().openDatabase();
        sqLiteDatabase.query(InventoryContract.DependencyEntry.TABLE_NAME,
                             InventoryContract.DependencyEntry.ALL_COLUMN,
                            null,
                            null,
                            null,
                            null,
                             InventoryContract.DependencyEntry.DEFAULT_SORT,
                            null);
        InventoryOpenHelper.getInstance().closeDatabase();
        return cursor;
    }


}
