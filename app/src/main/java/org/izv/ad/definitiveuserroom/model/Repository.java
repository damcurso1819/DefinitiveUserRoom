package org.izv.ad.definitiveuserroom.model;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import androidx.lifecycle.LiveData;

import org.izv.ad.definitiveuserroom.dao.UserDAO;
import org.izv.ad.definitiveuserroom.database.UserDatabase;
import org.izv.ad.definitiveuserroom.entity.User;

import java.util.List;

public class Repository {

    private UserDAO userDAO;
    private LiveData<List<User>> usersLive;

    public Repository(Context contexto) {
        UserDatabase db = UserDatabase.getDatabase(contexto);
        userDAO = db.getUserDAO();
        usersLive = userDAO.getAllLive();
    }

    private void populateDb() {
        for (int i = 0; i < 100; i++) {
            User user = new User();
            user.setApellidos("Pérez " + i);
            user.setNombre("Paco " + i);
            insertUser(user);
        }
    }

    public LiveData<List<User>> getUsersLive() {
        return usersLive;
    }

    public void insertUser(User user) {
        new InsertThread().execute(user);
    }

    private class InsertThread extends AsyncTask<User, Void, Void> {

        @Override
        protected Void doInBackground(User... users) {
            userDAO.insert(users[0]);
            Log.v("xyz", users[0].toString());
            return null;
        }
    }

}