package com.markets.marketlist.network;

import com.markets.marketlist.network.model.MarketListResponse;

import io.reactivex.Single;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by kamkalet on 30.12.2017.
 */

public interface RestService {

    String ENDPOINT = "https://api.ig.com/";

    @GET("deal/samples/markets/ANDROID_PHONE/{locale}/{country_code}")
    Single<Response<MarketListResponse>> getMarkets(@Path("locale") String locale,
                                                    @Path("country_code") String countyCode);

}
