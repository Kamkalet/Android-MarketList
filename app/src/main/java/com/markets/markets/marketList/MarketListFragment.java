package com.markets.markets.marketList;

import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.markets.markets.MVP.MVPContract;
import com.markets.markets.R;
import com.markets.markets.marketList.recyclerViewContent.MarketItem;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;


public class MarketListFragment extends Fragment
        implements MVPContract.View {

    MVPContract.Presenter presenter;

    @BindView(R.id.market_list)
    RecyclerView recyclerView;

    @BindView(R.id.country_spinner)
    Spinner countrySpinner;

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
        initializeSpinner();
        initializeRecyclerView();
        presenter.getData(countrySpinner.getId());
        return inflate;
    }

    private void initializeSpinner() {
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this.getContext(),
                R.array.countries, R.layout.spinner_country_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        countrySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                presenter.getData(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                //pass
            }
        });

        countrySpinner.setAdapter(adapter);
        countrySpinner.getBackground().setColorFilter(getResources().getColor(R.color.colorWhite), PorterDuff.Mode.SRC_ATOP);
    }

    private void initializeRecyclerView() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.getContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(),
                linearLayoutManager.getOrientation());
        recyclerView.addItemDecoration(dividerItemDecoration);
        recyclerView.setAdapter(new MarketItemRecyclerViewAdapter(new ArrayList<>()));
    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(this.getContext(), message, Toast.LENGTH_LONG).show();
    }

    @Override
    public void setItemsToAdapter(List<MarketItem> items) {
        ((MarketItemRecyclerViewAdapter) recyclerView.getAdapter()).setItems((items));
    }

    @Override
    public void setCountry(int spinnerPosition) {
        countrySpinner.setSelection(spinnerPosition);
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
