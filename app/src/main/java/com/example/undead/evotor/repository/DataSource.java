package com.example.undead.evotor.repository;

import com.example.undead.evotor.model.Item;

import java.util.List;

import io.reactivex.Observable;

public interface DataSource {
    Observable<List<Item>> getSection1();
    Observable<List<Item>> getSection2();
    Observable<List<Item>> getSection3();
}
