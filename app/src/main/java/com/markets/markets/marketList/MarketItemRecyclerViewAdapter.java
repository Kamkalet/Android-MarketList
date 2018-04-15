package com.markets.markets.marketList;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.markets.markets.R;
import com.markets.markets.marketList.recyclerViewContent.MarketItem;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MarketItemRecyclerViewAdapter extends RecyclerView.Adapter<MarketItemRecyclerViewAdapter.ViewHolder> {

    private List<MarketItem> mValues;

    MarketItemRecyclerViewAdapter(List<MarketItem> items) {
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

    void setItems(List<MarketItem> items) {
        mValues = items;
        notifyDataSetChanged();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.instrument_name)
        TextView mInstrumentName;
        @BindView(R.id.display_offer)
        TextView mDisplayOffer;

        MarketItem mItem;

        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }

    }
}
