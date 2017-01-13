package com.example.undead.evotor.presenter;

import com.example.undead.evotor.EvotorApplication;
import com.example.undead.evotor.model.Item;
import com.example.undead.evotor.repository.Repository;
import com.example.undead.evotor.utils.ObjectUtils;
import com.example.undead.evotor.view_interface.BaseView;
import com.example.undead.evotor.view_interface.ItemListView;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

public class ItemListPresenterImpl implements ItemListPresenter {
    private class ListDisposableObserver extends DisposableObserver<List<Item>> {
        @Override
        public void onNext(List<Item> items) {
            mBaseView.hideProgress();
            if (ObjectUtils.isEmpty(items)) {
                mBaseView.showEmptyMessage();
            } else {
                mBaseView.hideEmptyMessage();
            }
            mItemListView.setRssItemList(items);
        }

        @Override
        public void onError(Throwable e) {
            mBaseView.hideProgress();
            mBaseView.showErrorMessage(e.getMessage());
        }

        @Override
        public void onComplete() {
        }
    }

    private CompositeDisposable mDisposable;
    private ItemListView mItemListView;
    private BaseView mBaseView;
    private Repository mRepository;

    public ItemListPresenterImpl(ItemListView rssListView, BaseView baseView) {
        this.mItemListView = rssListView;
        this.mBaseView = baseView;
        this.mDisposable = new CompositeDisposable();
        this.mRepository = EvotorApplication.getInstance().getRepository();
    }

    @Override
    public void fetchSection1() {
        mBaseView.showProgress();
        mDisposable.add(mRepository
                .getSection1()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new ListDisposableObserver()));
    }

    @Override
    public void fetchSection2() {
        mBaseView.showProgress();
        mDisposable.add(mRepository
                .getSection2()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new ListDisposableObserver()));
    }

    @Override
    public void fetchSection3() {
        mBaseView.showProgress();
        mDisposable.add(mRepository
                .getSection3()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new ListDisposableObserver()));
    }

    @Override
    public void unsubscribe() {
        mDisposable.clear();
    }
}
