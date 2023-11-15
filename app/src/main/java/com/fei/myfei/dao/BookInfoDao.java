package com.fei.myfei.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.fei.myfei.entity.BookInfo;

import java.util.List;

@Dao
public interface BookInfoDao {

    @Insert
    void insert(BookInfo... bookInfos);

    @Delete
    void delete(BookInfo... bookInfos);

    @Query("DELETE FROM BOOKINFO")
    void deleteAll();

    @Update
    void update(BookInfo... bookInfos);

    @Query("SELECT * FROM BOOKINFO")
    List<BookInfo> queryAll();

    @Query("SELECT * FROM BOOKINFO WHERE name=:name")
    BookInfo queryByName(String name);

    @Query("SELECT * FROM BOOKINFO WHERE id=:id")
    BookInfo queryById(String id);
}
