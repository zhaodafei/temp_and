package com.fei.myfei.utils;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.fei.myfei.entity.UserFei;

import java.util.ArrayList;
import java.util.List;

// 这个类会自动创建数据库
public class UserDBHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "zzz_fei_SQLite02_Helper.db"; // 数据库
    private static final String TABLE_NAME = "user_info"; // 表名字
    private static final int DB_VERSION = 1; // 版本
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
        /* String SQL = " CREATE TABLE user_info  ( " +
                "  id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "  name VARCHAR(20)" +
                ")"; */
        /* String SQL = "CREATE TABLE IF NOT EXISTS user_info (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL," +
                "name VARCHAR(50) NOT NULL," +
                "age VARCHAR(50) NOT NULL);"; */

        String SQL = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME +" (" +
                "_id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL," +
                "name VARCHAR NOT NULL," +
                "age INTEGER NOT NULL," +
                "height LONG NOT NULL," +
                "weight FLOAT NOT NULL," +
                "agree INTEGER NOT NULL);";

        db.execSQL(SQL);
    }

    //
    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        // db.execSQL("ALTER TABLE person ADD phone VARCHAR(12)");
    }

    // ======================================== 下面操作数据库 =======================================
    // 添加
    public long insert(UserFei userFei) {
        ContentValues values = new ContentValues();
        values.put("name", userFei.name);
        values.put("age", userFei.age);
        values.put("height", userFei.height);
        values.put("weight", userFei.weight);
        values.put("agree", userFei.agree);

        return myWDB.insert(TABLE_NAME, null, values);
    }

    // 删除
    public long deleteByName(String name) {
        // // 删除所有
        // myWDB.delete(TABLE_NAME,"1=1", null);

        // 按照名字删除
        return myWDB.delete(TABLE_NAME, "name=?", new String[]{name});
    }

    // 更新
    public long update(UserFei userFei) {
        ContentValues values = new ContentValues();
        values.put("name", userFei.name);
        values.put("age", userFei.age);
        values.put("height", userFei.height);
        values.put("weight", userFei.weight);
        values.put("agree", userFei.agree);

        return myWDB.update(TABLE_NAME, values, "name=?", new String[]{userFei.name});
    }

    // 查询
    public List<UserFei> queryByName(String name) {
        List<UserFei> list = new ArrayList<>();
        // 执行记录查询动作，该语句返回结果集的游标
        Cursor cursor = myRDB.query(TABLE_NAME, null, "name=?", new String[]{name}, null, null, null);
        // 循环取出游标指向的每条记录
        while (cursor.moveToNext()) {
            UserFei user = new UserFei();
            user.id = cursor.getInt(0);
            user.name = cursor.getString(1);
            user.age = cursor.getInt(2);
            user.height = cursor.getLong(3);
            user.weight = cursor.getFloat(4);
            // SQLite没有布尔类型，用0表示false，用1表示true
            user.agree = (cursor.getInt(5) == 0) ? false : true;

            list.add(user);
        }
        return list;
    }
}
