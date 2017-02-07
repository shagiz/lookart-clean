package ru.shagi.lookart_clean.presenter;


import javax.inject.Inject;

import rx.Subscription;

public class BasePresenter<V extends BaseView> {

    @Inject
    protected V view;

    protected Subscription subscription;

    protected V getView() {
        return view;
    }

    public void unsubscribe() {
        if (subscription != null) {
            subscription.unsubscribe();
            subscription = null;
        }
    }
}
