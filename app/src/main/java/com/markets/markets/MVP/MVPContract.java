package com.markets.markets.MVP;

import com.markets.markets.marketList.recyclerViewContent.MarketItem;

import java.util.List;

/**
 * Created by kamkalet on 28.11.2017
 */

public class MVPContract {

    public interface View {
        void showMessage(String message);
        void setItemsToAdapter(List<MarketItem> items);
    }

    public interface Presenter {
        void attach(MVPContract.View view);
        void detach();
        void getData(int id);
    }

}
