package com.example.undead.evotor.view_interface;

public interface BaseView {
    void showErrorMessage(String errorMsg);
    void showProgress();
    void hideProgress();
    void showEmptyMessage();
    void hideEmptyMessage();
}