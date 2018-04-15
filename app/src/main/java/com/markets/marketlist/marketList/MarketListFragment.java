package com.markets.marketlist.marketList;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.markets.marketlist.MVP.MVPContract;
import com.markets.marketlist.R;

import butterknife.BindView;


public class MarketListFragment extends Fragment
        implements MVPContract.View {

    MVPContract.Presenter presenter;

    @BindView(R.id.market_list)
    RecyclerView recyclerView;

    public MarketListFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        presenter = new MarketListPresenter();
        presenter.attach(this);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_item_list, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        presenter.getData();
    }

    public void setAdapter() {
//        Context context = view.getContext();
//        RecyclerView recyclerView = (RecyclerView) view;
//
//        recyclerView.setLayoutManager(new LinearLayoutManager(context));
//
//        // recyclerView.setAdapter(new MyItemRecyclerViewAdapter());
    }

    @Override
    public void showMessage(String message) {

    }

    @Override
    public void showError(Throwable throwable) {

    }
}
