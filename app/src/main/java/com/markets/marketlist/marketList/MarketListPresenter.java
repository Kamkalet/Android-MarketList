package com.markets.marketlist.marketList;

import android.util.Log;

import com.markets.marketlist.MVP.MVPContract;
import com.markets.marketlist.network.RestService;
import com.markets.marketlist.network.RetrofitProvider;
import com.markets.marketlist.network.model.Market;
import com.markets.marketlist.network.model.MarketListResponse;

import java.util.List;

import io.reactivex.Scheduler;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Response;

import static android.content.ContentValues.TAG;

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
    public void detach() {
        this.view = null;
    }

    @Override
    public void getData() {
        restService.getMarkets("en_GB", "igi")
                .map(Response::body)
                .map(MarketListResponse::getMarkets)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(v -> {
                    Log.d(TAG, v.toString());}, err -> {Log.d(TAG, err.toString());});

    }
}
