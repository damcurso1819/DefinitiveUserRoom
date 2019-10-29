package org.izv.ad.definitiveuserroom.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import org.izv.ad.definitiveuserroom.dao.UserDAO;
import org.izv.ad.definitiveuserroom.entity.User;


@Database(entities = {User.class}, version = 1, exportSchema = false)
public abstract class UserDatabase extends RoomDatabase {

    public abstract UserDAO getUserDAO();

    private static volatile UserDatabase INSTANCIA;

    public static UserDatabase getDatabase(final Context context) {
        if (INSTANCIA == null) {
            synchronized (UserDatabase.class) {
                if (INSTANCIA == null) {
                    INSTANCIA = Room.databaseBuilder(context.getApplicationContext(),
                            UserDatabase.class, "user.sqlite")
                            .build();
                }
            }
        }
        return INSTANCIA;
    }
}
