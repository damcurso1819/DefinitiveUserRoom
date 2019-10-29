package org.izv.ad.definitiveuserroom.view;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import org.izv.ad.definitiveuserroom.entity.User;
import org.izv.ad.definitiveuserroom.model.Repository;

import java.util.List;

public class MainViewModel extends AndroidViewModel {

    private Repository repository;

    private LiveData<List<User>> users;

    public MainViewModel(@NonNull Application application) {
        super(application);
        repository = new Repository(application);
        users = repository.getUsersLive();
    }

    public LiveData<List<User>> getUsers() {
        return users;
    }

    public void insert(User user) {
        repository.insertUser(user);
    }
}
