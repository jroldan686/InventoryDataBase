package jrl.deint.inventoryDataBase.data.db;

import android.provider.BaseColumns;

import static jrl.deint.inventoryDataBase.data.db.InventoryContract.ProductEntry.COLUMN_CATEGORY_ID;
import static jrl.deint.inventoryDataBase.data.db.InventoryContract.ProductEntry.COLUMN_PRODUCT_CLASS_ID;
import static jrl.deint.inventoryDataBase.data.db.InventoryContract.ProductEntry.COLUMN_SECTOR_ID;

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
        public static final String COLUMN_SECTORID = "sectorId";
        //public static final String COLUMN_STATISID = "statusId";
        public static final String COLUMN_QUANTITY = "quantity";
        public static final String  COLUMN_VALUE = "value";
        public static final String  COLUMN_VENDOR = "vendor";
        public static final String COLUMN_BITMAP = "bitmap";
        public static final String COLUMN_IMAGENAME = "imageName";
        public static final String COLUMN_URL = "url";
        public static final String COLUMN_DATEPURCHASE = "datePurchase";
        public static final String COLUMN_NOTES = "notes";
        public static final String[] ALL_COLUMN = new String[]{
                BaseColumns._ID,
                COLUMN_SERIAL,
                COLUMN_MODELCODE,
                COLUMN_SHORTNAME,
                COLUMN_DESCRIPTION,
                COLUMN_CATEGORYID,
                COLUMN_PRODUCTCLASSID,
                COLUMN_PRODUCTCLASSDESCRIPTION,
                COLUMN_SECTORID,
                COLUMN_QUANTITY,
                COLUMN_VALUE,
                COLUMN_VENDOR,
                COLUMN_BITMAP,
                COLUMN_IMAGENAME,
                COLUMN_URL,
                COLUMN_DATEPURCHASE,
                COLUMN_NOTES
        };
    }

    public static final String SELECT = String.format("" +
                    "SELECT * FROM %s",
            ProductEntry.TABLE_NAME
    );

    public static final String PRODUCT_VIEW = String.format(
            "%s " +
                    "INNER JOIN %s ON %s = %s.%s " +
                    "INNER JOIN %s ON %s = %s.%s " +
                    "INNER JOIN %s ON %s = %s.%s ",
            ProductEntry.TABLE_NAME,
            COLUMN_CATEGORY_ID, CategoryEntry.TABLE_NAME, BaseColumns._ID,
            COLUMN_PRODUCT_CLASS_ID, ProductClassEntry.TABLE_NAME, BaseColumns._ID,
            COLUMN_SECTOR_ID, SectorEntry.TABLE_NAME, BaseColumns._ID
    );

    public static class ProductEntry implements BaseColumns {

        public static final String TABLE_NAME = "product";
        public static final String COLUMN_DEPENDENCY_ID = "dependencyId";
        public static final String COLUMN_SERIAL = "serial";
        public static final String COLUMN_MODEL_CODE = "modelCode";
        public static final String COLUMN_SHORTNAME = "shortname";
        public static final String COLUMN_DESCRIPTION = "description";
        public static final String COLUMN_CATEGORY_ID = "category";
        public static final String COLUMN_PRODUCT_CLASS_ID = "productClass";
        public static final String COLUMN_SECTOR_ID = "sectorId";
        public static final String COLUMN_QUANTITY = "quantity";
        public static final String COLUMN_VALUE = "value";
        public static final String COLUMN_VENDOR = "vendor";
        public static final String COLUMN_BITMAP = "bitmap";
        public static final String COLUMN_IMAGENAME = "imageName";
        public static final String COLUMN_URL = "url";
        public static final String COLUMN_DATE_PURCHASE = "datePurchase";
        public static final String COLUMN_NOTES = "notes";

        public static final String REFERENCES_CATEGORY_ID = String.format(
                "FOREIGN KEY (%s) REFERENCES %s(%s) ON UPDATE CASCADE ON DELETE RESTRICT",
                COLUMN_CATEGORY_ID, CategoryEntry.TABLE_NAME, BaseColumns._ID
        );

        public static class CategoryEntry implements BaseColumns {
            public static final String TABLE_NAME = "category";
            public static final String COLUMN_NAME = "name";
            public static final String COLUMN_SHORTNAME = "shortname";
            public static final String COLUMN_DESCRIPTION = "description";

            //En el mismo orden que las declaramos
            public static final String[] ALL_COLUMNS = new String[]{
                    BaseColumns._ID,
                    COLUMN_NAME,
                    COLUMN_SHORTNAME,
                    COLUMN_DESCRIPTION
            };
        }
    }
}
