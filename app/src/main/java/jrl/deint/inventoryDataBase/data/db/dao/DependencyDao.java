package jrl.deint.inventoryDataBase.data.db.dao;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.Observable;
import android.database.SQLException;
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
    public ArrayList<Dependency> loadAll() {
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
        if(cursor.moveToFirst()) {
            do {
                dependencies.add(new Dependency(
                        cursor.getInt(0),
                        cursor.getString(1), cursor.getString(2),
                        cursor.getString(3), cursor.getString(4))
                );
            } while (cursor.moveToNext());
        }
        dependencies.clear();
        cursor.close();
        InventoryOpenHelper.getInstance().closeDatabase();
        return dependencies;
    }

    public long add(Dependency dependency) {
        SQLiteDatabase sqLiteDatabase = InventoryOpenHelper.getInstance().openDatabase();
        // Null representa las columnas que podrían ser nulas
        long id = sqLiteDatabase.insert(InventoryContract.DependencyEntry.TABLE_NAME, null, createContent(dependency));
        InventoryOpenHelper.getInstance().closeDatabase();
        return id;
    }

    public boolean exists(Dependency dependency) {
        SQLiteDatabase sqLiteDatabase = InventoryOpenHelper.getInstance().openDatabase();
        return DatabaseUtils.queryNumEntries(sqLiteDatabase,
                InventoryContract.DependencyEntry.TABLE_NAME,
                InventoryContract.DependencyEntry.WHERE_NAME_AND_SHORTNAME,
                new String[]{dependency.getName(), dependency.getShortname()}) > 0;
    }

    public void update(Dependency dependency) {
        SQLiteDatabase sqLiteDatabase = InventoryOpenHelper.getInstance().openDatabase();
        String whereClause = BaseColumns._ID + "=?";
        String[] whereArgs = new String[]{""+dependency.get_ID()};
        //String[] whereArgs = new String[]{String.valueOf(dependency.get_ID())};       // Otra forma
        sqLiteDatabase.update(InventoryContract.DependencyEntry.TABLE_NAME, createContent(dependency), whereClause, whereArgs);

        InventoryOpenHelper.getInstance().closeDatabase();
    }

    public int delete(Dependency dependency) {
        int result;
        try {
            SQLiteDatabase sqLiteDatabase = InventoryOpenHelper.getInstance().openDatabase();
            String[] whereArgs = new String[]{dependency.get_ID() + ""};
            result = sqLiteDatabase.delete(
                    InventoryContract.DependencyEntry.TABLE_NAME,
                    InventoryContract.DependencyEntry.WHERE_ID,
                    whereArgs
            );
            return result;
        } catch (SQLException e) {
            return 0;
        }
    }

    public ContentValues createContent(Dependency dependency) {
        //ContentValues funciona como un mapa
        ContentValues contentValues = new ContentValues();
        contentValues.put(InventoryContract.DependencyEntry.COLUMN_NAME, dependency.getName());
        contentValues.put(InventoryContract.DependencyEntry.COLUMN_SHORTNAME, dependency.getShortname());
        contentValues.put(InventoryContract.DependencyEntry.COLUMN_DESCRIPTION, dependency.getDescription());
        contentValues.put(InventoryContract.DependencyEntry.COLUMN_IMAGENAME, dependency.getImageName());
        return contentValues;
    }
}
