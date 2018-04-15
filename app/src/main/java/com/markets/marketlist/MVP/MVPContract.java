package com.markets.marketlist.MVP;

import com.markets.marketlist.marketList.dummy.MarketItem;

import java.util.List;

/**
 * Created by kamkalet on 28.11.2017
 */

public class MVPContract {

    public interface View {

        public void showMessage(String message);

        public void showError(Throwable throwable);

        void setAdapter(List<MarketItem> v);
    }

    public interface Presenter {

        public void attach(MVPContract.View view);

        public void detach();

        void getData();
    }

}
