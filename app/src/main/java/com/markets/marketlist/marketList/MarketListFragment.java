package com.markets.marketlist.marketList;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.markets.marketlist.MVP.MVPContract;
import com.markets.marketlist.R;
import com.markets.marketlist.marketList.dummy.MarketItem;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;


public class MarketListFragment extends Fragment
        implements MVPContract.View {

    MVPContract.Presenter presenter;

    @BindView(R.id.market_list)
    RecyclerView recyclerView;
    private Unbinder unbinder;

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
        View inflate = inflater.inflate(R.layout.fragment_item_list, container, false);
        unbinder = ButterKnife.bind(this, inflate);
        return inflate;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        presenter.getData();
    }


    @Override
    public void showMessage(String message) {

    }

    @Override
    public void showError(Throwable throwable) {

    }

    @Override
    public void setAdapter(List<MarketItem> v) {
        Context context = this.getContext();
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setAdapter(new MyItemRecyclerViewAdapter(v));
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        presenter.detach();
    }
}
