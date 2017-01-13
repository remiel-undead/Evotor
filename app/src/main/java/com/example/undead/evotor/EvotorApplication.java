package com.example.undead.evotor;

import android.app.Application;

import com.example.undead.evotor.repository.Repository;

public class EvotorApplication extends Application {
    private Repository mRepository = new Repository();

    private static EvotorApplication sInstance;

    public static EvotorApplication getInstance() {
        return sInstance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        sInstance = this;
    }

    public Repository getRepository() {
        return mRepository;
    }
}