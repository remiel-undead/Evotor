package com.example.undead.evotor.repository;

import com.example.undead.evotor.model.ItemContainer;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ApiInterface {
    @GET("1.json")
    Observable<ItemContainer> getSection1();

    @GET("2.json")
    Observable<ItemContainer> getSection2();

    @GET("3.json")
    Observable<ItemContainer> getSection3();
}