package com.example.mobile;

import android.content.ContentValues;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase;
import android.content.Context;

import androidx.annotation.Nullable;

public class CourierDatabaseHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "courier.db";
    private static final int DB_VERSION = 1;

    static final String TABLE_1 = "Despetcher";

    public static final String COLUMN_ID_DESPETCHER = "_id";
    public static final String COLUMN_NAME_FIRST = "first_name";
    public static final String COLUMN_NAME_NAME = "name_name";
    public static final String COLUMN_FATHER_NAME = "father_name";

    static final String TABLE_2 = "Order";

    public static final String COLUMN_ID_ORDER = "_id";
    public static final String COLUMN_ID_DES = "despetcher_id";
    public static final String COLUMN_ORDER_TYPE = "order_type";
    public static final String COLUMN_NUMBER_ORDER = "number_order";


    static final String TABLE_3 = "ORDER_COLLECTOR";
    public static final String COLUMN_ID_COL = "collector_id";
    public static final String COLUMN_NAME_FIO = "fio_name";
    public static final String COLUMN_ORDER_COM = "order_composition";

    static final String TABLE_4 = "ORDER_TYPE";
    public static final String COLUMN_ID_TYPE = "_id";
    public static final String COLUMN_NAME_TYPE = "name_type";

    static final String TABLE_5 = "POIN_OF_ISSUE";
    public static final String COLUMN_ID_POIN = "_id";
    public static final String COLUMN_ID_COLL = "collector_id";
    public static final String COLUMN_ID_DESPE = "despetcher_id";
    public static final String COLUMN_NAME_POIN = "name_poin";
    public static final String COLUMN_NAME_ADDRESS = "address_name";

    public CourierDatabaseHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    public CourierDatabaseHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(String.format("Create table %s (%s integer primary key autoincrement,%s text)%stext", TABLE_2, COLUMN_ID_ORDER, COLUMN_ORDER_TYPE, COLUMN_NUMBER_ORDER));
        db.execSQL(String.format("Create table %s (%s integer primary key autoincrement,%s text)%s text", TABLE_3, COLUMN_ID_COL, COLUMN_NAME_FIO, COLUMN_ORDER_COM));
        db.execSQL(String.format("Create table %s (%s integer primary key autoincrement,%s text)", TABLE_4, COLUMN_ID_TYPE, COLUMN_NAME_TYPE));
        db.execSQL(String.format("Create table %s (%s integer primary key autoincrement,%s text)%s text)%stext", TABLE_1, COLUMN_ID_DESPETCHER, COLUMN_NAME_FIRST, COLUMN_NAME_NAME, COLUMN_FATHER_NAME));
        db.execSQL(String.format("Create table %s (%s integer primary key autoincrement,%s integer,%s integer,%s integer,%s text)%s text)Foreign key(%s) references %s(%s),Foreign key(%s) references %s(%s),Foreign key(%s) references %s(%s))", TABLE_5, COLUMN_ID_POIN, COLUMN_ID_COLL, COLUMN_ID_DES, COLUMN_ID_ORDER, COLUMN_NAME_POIN, COLUMN_NAME_ADDRESS, COLUMN_ID_DESPETCHER, TABLE_2, COLUMN_ID_DESPETCHER, COLUMN_ID_COL, TABLE_5, COLUMN_ID_COL, COLUMN_ID_ORDER, TABLE_3, COLUMN_ID_ORDER));
        db.execSQL(String.format("INSERT INTO %s (%s) VALUES ('одежда');", TABLE_2, COLUMN_ORDER_TYPE));
        db.execSQL(String.format("INSERT INTO %s (%s) VALUES ('1024');", TABLE_2, COLUMN_NUMBER_ORDER));
        db.execSQL(String.format("INSERT INTO %s (%s) VALUES ('Бекирова');", TABLE_1, COLUMN_NAME_FIRST));
        db.execSQL(String.format("INSERT INTO %s (%s) VALUES ('Нелли');", TABLE_1, COLUMN_NAME_NAME));
        db.execSQL(String.format("INSERT INTO %s (%s) VALUES ('Рифатовна');", TABLE_1, COLUMN_FATHER_NAME));
        db.execSQL(String.format("INSERT INTO %s (%s) VALUES ('Волков Виталий Борисович');", TABLE_3, COLUMN_NAME_FIO));
        db.execSQL(String.format("INSERT INTO %s (%s) VALUES ('Платье летнее');", TABLE_3, COLUMN_ORDER_COM));
        db.execSQL(String.format("INSERT INTO %s (%s, %s, %s, %s, %s, %s) VALUES (15234,1,123,56,'wildberries','Авиастроитель'), (15624,1,123,'ozone',Баумана);", TABLE_5, COLUMN_ID_POIN, COLUMN_ID_COLL, COLUMN_ID_DES, COLUMN_ID_ORDER, COLUMN_NAME_POIN, COLUMN_NAME_ADDRESS));
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion,  int newVersion) {
        if(newVersion>0){
            db.execSQL(String.format("Create table %s (%s integer primary key autoincrement,%s text)%stext", TABLE_2, COLUMN_ID_ORDER, COLUMN_ORDER_TYPE, COLUMN_NUMBER_ORDER));
            db.execSQL(String.format("Create table %s (%s integer primary key autoincrement,%s text,%s text)", TABLE_3, COLUMN_ID_COL, COLUMN_NAME_FIO, COLUMN_ORDER_COM));
            db.execSQL(String.format("Create table %s (%s integer primary key autoincrement,%s text)", TABLE_4, COLUMN_ID_TYPE, COLUMN_NAME_TYPE));
            db.execSQL(String.format("Create table %s (%s integer primary key autoincrement,%s text,%s text,%s text)", TABLE_1, COLUMN_ID_DESPETCHER, COLUMN_NAME_FIRST, COLUMN_NAME_NAME, COLUMN_FATHER_NAME));
            db.execSQL(String.format("Create table %s (%s integer primary key autoincrement,%s integer,%s integer,%s integer,%s text)%s text)Foreign key(%s) references %s(%s),Foreign key(%s) references %s(%s),Foreign key(%s) references %s(%s))", TABLE_5, COLUMN_ID_POIN, COLUMN_ID_COLL, COLUMN_ID_DES, COLUMN_ID_ORDER, COLUMN_NAME_POIN, COLUMN_NAME_ADDRESS, COLUMN_ID_DESPETCHER, TABLE_2, COLUMN_ID_DESPETCHER, COLUMN_ID_COL, TABLE_5, COLUMN_ID_COL, COLUMN_ID_ORDER, TABLE_3, COLUMN_ID_ORDER));
        }
        onCreate(db);
    }
    public void insertPOIN_OF_ISSUE(String despetcher, long order, String collector, String poin, String address){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(COLUMN_ID_DES,despetcher);
        values.put(COLUMN_ID_ORDER,order);
        values.put(COLUMN_ID_COLL,collector);
        values.put(COLUMN_NAME_POIN,poin);
        values.put(COLUMN_NAME_ADDRESS, address);

        db.insert(TABLE_1, null, values);
    }

    public void insertDespetcher(String despetcher){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(COLUMN_ID_DES,despetcher);

        db.insert(TABLE_1, null, values);
    }

    public void insertPoin_of_issue(String poin, String adress){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(COLUMN_ID_POIN,poin);

        db.insert(TABLE_5, null, values);
    }

    public void insertORDER_COLLECTOR(String collector){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(COLUMN_ID_DES,collector);

        db.insert(TABLE_3, null, values);
    }

    public void insertOrder(String order){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(COLUMN_ID_ORDER,order);

        db.insert(TABLE_2, null, values);
    }

    public void updatePOIN_OF_ISSUE(long id, long name, long adress){

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(COLUMN_NAME_POIN,name);
        values.put(COLUMN_NAME_ADDRESS,adress);

        db.update(TABLE_5,values,COLUMN_ID_POIN+ "=" + id, null);
    }
}


