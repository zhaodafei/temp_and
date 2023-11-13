package com.fei.myfei.utils;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.fei.myfei.entity.UserFei;

public class UserDBHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "zzz_fei_SQLite01.db";
    private static final String TABLE_NAME = "user_info";
    private static final int DB_VERSION = 1;
    private static UserDBHelper myHelper = null;
    private SQLiteDatabase myRDB = null; // 数据库:读连接
    private SQLiteDatabase myWDB = null; // 数据库:写连接

    private UserDBHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    // 利用单例模式获取数据库帮助器的唯一实例
    public static UserDBHelper getInstance(Context context) {
        if (myHelper == null) {
            myHelper = new UserDBHelper(context);
        }

        return myHelper;
    }

    // 打开数据库读连接
    public SQLiteDatabase openReadLink() {
        if (myRDB == null || !myRDB.isOpen()) {
            myRDB = myHelper.getReadableDatabase();
        }
        return myRDB;
    }

    // 打开数据库写连接
    public SQLiteDatabase openWriteLink() {
        if (myWDB == null || !myWDB.isOpen()) {
            myWDB = myHelper.getWritableDatabase();
        }
        return myWDB;
    }

    // 关闭数据连接
    public void closeLink() {
        if (myRDB !=null && myRDB.isOpen()) {
            myRDB.close();
            myRDB = null;
        }

        if (myWDB !=null && myWDB.isOpen()) {
            myWDB.close();
            myWDB = null;
        }
    }

    // 创建数据库,执行SQL
    @Override
    public void onCreate(SQLiteDatabase db) {
        // String SQL = "CREATE TABLE person(personid INTEGER PRIMARY KEY AUTOINCREMENT,name VARCHAR(20))";
            String SQL = " CREATE TABLE user_info  ( " +
                "  id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "  name VARCHAR(20)" +
                ")";

        db.execSQL(SQL);
    }

    //
    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        // db.execSQL("ALTER TABLE person ADD phone VARCHAR(12)");
    }

    public long insert(UserFei userFei) {
        ContentValues values = new ContentValues();
        values.put("name", userFei.name);

        return myWDB.insert(TABLE_NAME, null, values);
    }
}
