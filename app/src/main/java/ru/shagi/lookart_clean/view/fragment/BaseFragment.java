package ru.shagi.lookart_clean.view.fragment;

import android.os.Bundle;
import android.support.annotation.CallSuper;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import ru.shagi.lookart_clean.App;
import ru.shagi.lookart_clean.di.component.AppComponent;


public abstract class BaseFragment extends Fragment {
    private Unbinder viewBinder;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        resolveDependency();
    }

    protected void resolveDependency() {
    }

    @Override
    @CallSuper
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewBinder = ButterKnife.bind(this, view);
    }

    @Override
    @CallSuper
    public void onDestroyView() {
        if (viewBinder != null) {
            viewBinder.unbind();
        }
        super.onDestroyView();
    }

    protected AppComponent getApplicationComponent() {
        return ((App) getActivity().getApplication()).getAppComponent();
    }
}
