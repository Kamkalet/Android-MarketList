package com.markets.MVP;

import com.markets.marketList.recyclerViewContent.MarketItem;

import java.util.List;

/**
 * Created by kamkalet on 28.11.2017
 */

public class MVPContract {

    public interface View {
        void showNetworkErrorMessage();
        void setItemsToAdapter(List<MarketItem> items);
        void setCountry(int spinnerPosition);
    }

    public interface Presenter {
        void attach(MVPContract.View view);
        void detach();
        void getData(int id);
    }

}
