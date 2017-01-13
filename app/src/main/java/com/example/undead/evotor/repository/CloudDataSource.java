package com.example.undead.evotor.repository;

import com.example.undead.evotor.model.Item;
import com.example.undead.evotor.model.ItemContainer;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.functions.Function;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CloudDataSource implements DataSource {

    private static final String BASE_URL = "https://raw.githubusercontent.com/thenixan/test-task/master/";
    private static final String DEFAULT_ERROR_MESSAGE = "Failed to process the request.";

    private ApiInterface mApi;

    public CloudDataSource() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        mApi = retrofit.create(ApiInterface.class);
    }


    @Override
    public Observable<List<Item>> getSection1() {
        return mApi
                .getSection1()
                .flatMap(new Function<ItemContainer, Observable<? extends ItemContainer>>() {
                    @Override
                    public Observable<? extends ItemContainer> apply(ItemContainer itemContainer) throws Exception {
                        if (itemContainer == null || itemContainer.getItems() == null) {
                            return Observable.error(new Exception(DEFAULT_ERROR_MESSAGE));
                        } else {
                            return Observable.just(itemContainer);
                        }
                    }
                })
                .map(new Function<ItemContainer, List<Item>>() {
                    @Override
                    public List<Item> apply(ItemContainer itemContainer) throws Exception {
                        return itemContainer.getItems();
                    }
                });
    }

    @Override
    public Observable<List<Item>> getSection2() {
        return mApi.getSection2()
                .flatMap(new Function<ItemContainer, Observable<? extends ItemContainer>>() {
                    @Override
                    public Observable<? extends ItemContainer> apply(ItemContainer itemContainer) throws Exception {
                        if (itemContainer == null || itemContainer.getItems() == null) {
                            return Observable.error(new Exception(DEFAULT_ERROR_MESSAGE));
                        } else {
                            return Observable.just(itemContainer);
                        }
                    }
                })
                .map(new Function<ItemContainer, List<Item>>() {
                    @Override
                    public List<Item> apply(ItemContainer itemContainer) throws Exception {
                        return itemContainer.getItems();
                    }
                });
    }

    @Override
    public Observable<List<Item>> getSection3() {
        return mApi.getSection3()
                .flatMap(new Function<ItemContainer, Observable<? extends ItemContainer>>() {
                    @Override
                    public Observable<? extends ItemContainer> apply(ItemContainer itemContainer) throws Exception {
                        if (itemContainer == null || itemContainer.getItems() == null) {
                            return Observable.error(new Exception(DEFAULT_ERROR_MESSAGE));
                        } else {
                            return Observable.just(itemContainer);
                        }
                    }
                })
                .map(new Function<ItemContainer, List<Item>>() {
                    @Override
                    public List<Item> apply(ItemContainer itemContainer) throws Exception {
                        return itemContainer.getItems();
                    }
                });
    }
}