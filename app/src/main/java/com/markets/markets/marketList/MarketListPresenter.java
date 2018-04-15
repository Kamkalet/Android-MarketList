package com.markets.markets.marketList;

import android.util.Log;

import com.markets.markets.MVP.MVPContract;
import com.markets.markets.marketList.recyclerViewContent.MarketItem;
import com.markets.markets.network.RestService;
import com.markets.markets.network.RetrofitProvider;
import com.markets.markets.network.model.Market;
import com.markets.markets.network.model.MarketListResponse;

import java.util.ArrayList;
import java.util.Collections;
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

    private Country currentCountry = Country.UK;

    @Override
    public void attach(MVPContract.View view) {
        this.view = view;
    }

    @Override
    public void getData(int spinnerPosition) {
        Country country = Country.get(spinnerPosition);
        restService.getMarkets(country.getLocale(), country.getCountryCode())
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.computation())
                .map(Response::body)
                .map(MarketListResponse::getMarkets)
                .map(this::convertToRecyclerItems)
                .map(this::sort)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(items -> {
                            view.setItemsToAdapter(items);
                            currentCountry = country;
                        },
                        err -> {
                            Log.e(TAG, err.toString());
                            view.showMessage(err.getMessage());
                            view.setCountry(currentCountry.getId());
                        });

    }

    private List<MarketItem> sort(List<MarketItem> items) {
        List<MarketItem> sortedList = new ArrayList<>(items);
        Collections.sort(sortedList,
                (m1, m2) -> m1.getInstrumentName().compareTo(m2.getInstrumentName()));
        return sortedList;
    }

    private List<MarketItem> convertToRecyclerItems(List<Market> markets) {
        List<MarketItem> marketsItems = new ArrayList<>();
        for (Market market : markets) {
            marketsItems.add(new MarketItem(market.getDisplayOffer(), market.getInstrumentName()));
        }
        return marketsItems;
    }

    @Override
    public void detach() {
        this.view = null;
    }
}
