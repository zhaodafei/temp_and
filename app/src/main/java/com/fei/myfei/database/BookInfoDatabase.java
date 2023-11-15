package com.fei.myfei.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.fei.myfei.dao.BookInfoDao;
import com.fei.myfei.entity.BookInfo;

// entities 表示数据库有哪些表, version 表示数据库版本号
// exportSchema 表示是否导出数据库信息的JSON串,
@Database(entities = {BookInfo.class}, version = 1, exportSchema = true)
public abstract class BookInfoDatabase extends RoomDatabase {

    // 获取该数据库中某张表的持久化对象
    public abstract BookInfoDao bookInfoDao();
}
