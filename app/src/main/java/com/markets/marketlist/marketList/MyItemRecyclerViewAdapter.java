package com.markets.marketlist.marketList;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewDebug;
import android.view.ViewGroup;
import android.widget.TextView;


import com.markets.marketlist.R;
import com.markets.marketlist.marketList.dummy.MarketItem;
import com.markets.marketlist.network.model.Market;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MyItemRecyclerViewAdapter extends RecyclerView.Adapter<MyItemRecyclerViewAdapter.ViewHolder> {

    private List<MarketItem> mValues;

    public MyItemRecyclerViewAdapter(List<MarketItem> items) {
        mValues = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.mDisplayOffer.setText(mValues.get(position).getDisplayOffer());
        holder.mInstrumentName.setText(mValues.get(position).getInstrumentName());
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public void setItems(List<MarketItem> items){
        mValues = items;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.instrument_name)
        public TextView mInstrumentName;
        @BindView(R.id.display_offer)
        public TextView mDisplayOffer;

        public MarketItem mItem;

        public ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }


    }
}
