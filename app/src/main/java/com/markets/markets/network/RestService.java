package com.markets.markets.network;

import com.markets.markets.network.model.MarketListResponse;

import io.reactivex.Observable;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by kamkalet on 30.12.2017.
 */

public interface RestService {

    String ENDPOINT = "https://api.ig.com/";

    @GET("deal/samples/markets/ANDROID_PHONE/{locale}/{country_code}")
    Observable<Response<MarketListResponse>> getMarkets(@Path("locale") String locale,
                                                        @Path("country_code") String countyCode);

}
