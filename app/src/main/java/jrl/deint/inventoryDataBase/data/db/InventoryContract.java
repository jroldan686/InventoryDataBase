package jrl.deint.inventoryDataBase.data.db;

import android.provider.BaseColumns;

/**
 * Created by usuario on 19/01/18.
 */

public final class InventoryContract {

    // La clase no se puede instanciar
    private InventoryContract() {

    }

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "Inventory.db";

    // Por cada tabla se crea una clase que implementa la interfaz
    // BaseColumns

    public static class DependencyEntry implements BaseColumns {
        public static final String TABLE_NAME = "dependency";
        public static final String COLUMN_NAME = "name";
        public static final String COLUMN_SHORTNAME = "shortname";
        public static final String COLUMN_DESCRIPTION = "description";
        public static final String COLUMN_IMAGENAME = "imageName";
        public static final String[] ALL_COLUMN = new String[] {
                BaseColumns._ID, COLUMN_NAME, COLUMN_SHORTNAME, COLUMN_DESCRIPTION, COLUMN_IMAGENAME);
        public static final String DEFAULT_SORT = COLUMN_NAME;
        public static final String SQL_CREATE_ENTRIES = String.format("CREATE TABLE %s (%s INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "%s TEXT NOT NULL" +
                "%s TEXT NOT NULL" +
                "%s TEXT NOT NULL" +
                "%s TEXT NOT NULL)",
                TABLE_NAME,
                BaseColumns._ID,
                COLUMN_NAME,
                COLUMN_SHORTNAME,
                COLUMN_DESCRIPTION,
                COLUMN_IMAGENAME
        );

        public static final String SQL_DELETE_ENTRIES = String.format("DROP TABLE IF EXISTS " +
                "%s", TABLE_NAME
        );

        public static final String SQL_INSERT_ENTRIES = String.format("INSERT INTO %s (%s, %s, %s, %s) VALUES ('%s', '%s', '%s', '%s'),", TABLE_NAME,
                COLUMN_NAME,
                COLUMN_SHORTNAME,
                COLUMN_DESCRIPTION,
                COLUMN_IMAGENAME,
                "Aula de 2CFGS",
                "2CFGS",
                "Aula de los resopladores de 2CFGS",
                "No tengo imagen") +
                String.format("('%s', '%s', '%s', '%s'),","Aula de 1CFGS", "1CFGS", "Aula de los pardillos de 1CFGS", "No tengo imagen"
        );

        public static final String WHERE_NAME_AND_SHORTNAME = String.format(
                "%s = ? AND %s = ?",
                COLUMN_NAME,
                COLUMN_SHORTNAME
        );

        public static final String WHERE_ID = String.format(
                "%s = ?",
                BaseColumns._ID
        );
    }

    public static class ProductInnerEntry implements BaseColumns
    {
        public static final String TABLE_NAME = "product";
        public static final String COLUMN_SERIAL = "serial";
        public static final String COLUMN_MODELCODE = "modelcode";
        public static final String COLUMN_SHORTNAME = "shortname";
        public static final String COLUMN_DESCRIPTION = "description";
        public static final String COLUMN_CATEGORYID = "categoryName";
        //public static final String COLUMN_SUBCATEGORYID = "subcategoryId";
        public static final String COLUMN_PRODUCTCLASSID = "productclassId";
        public static final String COLUMN_PRODUCTCLASSDESCRIPTION = "productclassDescription";

    }
}
