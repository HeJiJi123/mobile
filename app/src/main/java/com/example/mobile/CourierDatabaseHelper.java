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
    public static final String COLUMN_NAME_ADRESS = "adress_name";

    public CourierDatabaseHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    public CourierDatabaseHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("Create table "+TABLE_2+" (" +
                ""+COLUMN_ID_ORDER+" integer primary key autoincrement," +
                ""+COLUMN_ORDER_TYPE+" text)" +
                ""+COLUMN_NUMBER_ORDER+"text");
        db.execSQL("Create table "+TABLE_3+" (" +
                ""+COLUMN_ID_COL+" integer primary key autoincrement," +
                ""+COLUMN_NAME_FIO+" text)" +
                ""+COLUMN_ORDER_COM+" text");
        db.execSQL("Create table "+TABLE_4+" (" +
                ""+COLUMN_ID_TYPE+" integer primary key autoincrement," +
                ""+COLUMN_NAME_TYPE+" text)");
        db.execSQL("Create table "+TABLE_1+" (" +
                ""+COLUMN_ID_DESPETCHER+" integer primary key autoincrement," +
                ""+COLUMN_NAME_FIRST+" text)" +
                ""+COLUMN_NAME_NAME+" text)" +
                ""+COLUMN_FATHER_NAME+"text");
        db.execSQL("Create table "+TABLE_5+" (" +
                ""+COLUMN_ID_POIN+" integer primary key autoincrement," +
                ""+COLUMN_ID_COLL+" integer," +
                ""+COLUMN_ID_DES+" integer," +
                ""+COLUMN_ID_ORDER+" integer," +
                ""+COLUMN_NAME_POIN+" text)" +
                ""+COLUMN_NAME_ADRESS+" text)"+
                "Foreign key("+COLUMN_ID_DESPETCHER+") references "+TABLE_2+"("+COLUMN_ID_DESPETCHER+")," +
                "Foreign key("+COLUMN_ID_COL+") references "+TABLE_5+"("+COLUMN_ID_COL+")," +
                "Foreign key("+COLUMN_ID_ORDER+") references "+TABLE_3+"("+COLUMN_ID_ORDER+"))");
        db.execSQL("INSERT INTO "+TABLE_2+" ("+COLUMN_ORDER_TYPE+") VALUES ('одежда');");
        db.execSQL("INSERT INTO "+TABLE_2+" ("+COLUMN_NUMBER_ORDER+") VALUES ('1024');");
        db.execSQL("INSERT INTO "+TABLE_1+" ("+COLUMN_NAME_FIRST+") VALUES ('Бекирова');");
        db.execSQL("INSERT INTO "+TABLE_1+" ("+COLUMN_NAME_NAME+") VALUES ('Нелли');");
        db.execSQL("INSERT INTO "+TABLE_1+" ("+COLUMN_FATHER_NAME+") VALUES ('Рифатовна');");
        db.execSQL("INSERT INTO "+TABLE_3+" ("+COLUMN_NAME_FIO+") VALUES ('Волков Виталий Борисович');");
        db.execSQL("INSERT INTO "+TABLE_3+" ("+COLUMN_ORDER_COM+") VALUES ('Платье летнее');");
        db.execSQL("INSERT INTO "+TABLE_5+" ("+COLUMN_ID_POIN+", "+COLUMN_ID_COLL+", "+COLUMN_ID_DES+"," +
                " "+COLUMN_ID_ORDER+", "+COLUMN_NAME_POIN+", "+COLUMN_NAME_ADRESS+") VALUES (15234,1,123,56,'wildberries','Авиастроитель'), (15624,1,123,'ozone',Баумана);");
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion,  int newVersion) {
        if(newVersion>0){
            db.execSQL("Create table "+TABLE_2+" (" +
                    ""+COLUMN_ID_ORDER+" integer primary key autoincrement," +
                    ""+COLUMN_ORDER_TYPE+" text)" +
                    ""+COLUMN_NUMBER_ORDER+"text");
            db.execSQL("Create table "+TABLE_3+" (" +
                    ""+COLUMN_ID_COL+" integer primary key autoincrement," +
                    ""+COLUMN_NAME_FIO+" text)" +
                    ""+COLUMN_ORDER_COM+" text");
            db.execSQL("Create table "+TABLE_4+" (" +
                    ""+COLUMN_ID_TYPE+" integer primary key autoincrement," +
                    ""+COLUMN_NAME_TYPE+" text)");
            db.execSQL("Create table "+TABLE_1+" (" +
                    ""+COLUMN_ID_DESPETCHER+" integer primary key autoincrement," +
                    ""+COLUMN_NAME_FIRST+" text)" +
                    ""+COLUMN_NAME_NAME+" text)" +
                    ""+COLUMN_FATHER_NAME+"text");
            db.execSQL("Create table "+TABLE_5+" (" +
                    ""+COLUMN_ID_POIN+" integer primary key autoincrement," +
                    ""+COLUMN_ID_COLL+" integer," +
                    ""+COLUMN_ID_DES+" integer," +
                    ""+COLUMN_ID_ORDER+" integer," +
                    ""+COLUMN_NAME_POIN+" text)" +
                    ""+COLUMN_NAME_ADRESS+" text)"+
                    "Foreign key("+COLUMN_ID_DESPETCHER+") references "+TABLE_2+"("+COLUMN_ID_DESPETCHER+")," +
                    "Foreign key("+COLUMN_ID_COL+") references "+TABLE_5+"("+COLUMN_ID_COL+")," +
                    "Foreign key("+COLUMN_ID_ORDER+") references "+TABLE_3+"("+COLUMN_ID_ORDER+"))");
        }
        onCreate(db);
    }
    public void insertPOIN_OF_ISSUE(String despetcher, long order, String collector, String poin){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(COLUMN_ID_DES,despetcher);
        values.put(COLUMN_ID_ORDER,order);
        values.put(COLUMN_ID_COLL,collector);
        values.put(COLUMN_NAME_POIN,poin);
        String adress;
        values.put(COLUMN_NAME_ADRESS,adress);

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
        values.put(COLUMN_NAME_ADRESS,adress);

        db.update(TABLE_5,values,COLUMN_ID_POIN+ "=" + id, null);
    }
}


