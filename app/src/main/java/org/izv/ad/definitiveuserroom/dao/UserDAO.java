package org.izv.ad.definitiveuserroom.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import org.izv.ad.definitiveuserroom.entity.User;

import java.util.List;

@Dao
public interface UserDAO {

    @Delete
    int delete(User usuario);

    @Update
    int edit(User usuario);

    @Insert
    long insert(User usuario);

    @Query("select * from user where id = :id")
    User get(int id);

    @Query("select * from user order by apellidos, nombre, id desc")
    List<User> getAll();

    @Query("select * from user order by apellidos, nombre, id desc")
    LiveData<List<User>> getAllLive();
}
