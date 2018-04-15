package com.markets.marketlist.MVP;

/**
 * Created by kamkalet on 28.11.2017
 */

public class MVPContract {

    public interface View {

        public void showMessage(String message);
        public void showError(Throwable throwable);

    }

    public interface Presenter {

        public void attach(MVPContract.View view);
        public void detach();

        void getData();
    }

}
