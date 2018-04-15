package com.markets.marketlist.MVP;

import com.markets.marketlist.marketList.dummy.MarketItem;

import java.util.List;

/**
 * Created by kamkalet on 28.11.2017
 */

public class MVPContract {

    public interface View {

        void showMessage(String message);
        void setItemsToAdapter(List<MarketItem> v);
    }

    public interface Presenter {

        void attach(MVPContract.View view);
        void detach();
        void getData(int id);
    }

}
