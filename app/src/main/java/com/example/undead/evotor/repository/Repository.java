package com.example.undead.evotor.repository;

import com.example.undead.evotor.model.Item;

import java.util.List;

import io.reactivex.Observable;

public class Repository implements DataSource {
    private CloudDataSource mCloudDataSource;

    public Repository() {
        mCloudDataSource = new CloudDataSource();
    }

    @Override
    public Observable<List<Item>> getSection1() {
        return mCloudDataSource.getSection1();
    }

    @Override
    public Observable<List<Item>> getSection2() {
        return mCloudDataSource.getSection2();
    }

    @Override
    public Observable<List<Item>> getSection3() {
        return mCloudDataSource.getSection3();
    }
}