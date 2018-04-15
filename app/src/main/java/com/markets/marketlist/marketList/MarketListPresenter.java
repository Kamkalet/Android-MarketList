package com.markets.marketlist.marketList;

import android.util.Log;

import com.markets.marketlist.MVP.MVPContract;
import com.markets.marketlist.marketList.dummy.MarketItem;
import com.markets.marketlist.network.RestService;
import com.markets.marketlist.network.RetrofitProvider;
import com.markets.marketlist.network.model.Market;
import com.markets.marketlist.network.model.MarketListResponse;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Response;

/**
 * Created by kamkalet on 14.04.2018.
 */

public class MarketListPresenter implements MVPContract.Presenter {

    private final String TAG = MarketListPresenter.class.toString();

    private MVPContract.View view;

    private final RestService restService =
            RetrofitProvider.getRetrofit().create(RestService.class);


    @Override
    public void attach(MVPContract.View view) {
        this.view = view;
    }

    @Override
    public void getData() {
        restService.getMarkets("en_GB", "igi")
                .map(Response::body)
                .map(MarketListResponse::getMarkets)
                .map(this::convertToRecyclerItems)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(v -> {
                    view.setAdapter(v);}, err -> {Log.d(TAG, err.toString());});

    }

    private List<MarketItem> convertToRecyclerItems(List<Market> markets) {
        List<MarketItem> marketsItems = new ArrayList<>();
        for(Market market : markets){
            marketsItems.add(new MarketItem(market.getDisplayOffer(), market.getInstrumentName()));
        }
        return marketsItems;
    }

    @Override
    public void detach() {
        this.view = null;
    }
}
