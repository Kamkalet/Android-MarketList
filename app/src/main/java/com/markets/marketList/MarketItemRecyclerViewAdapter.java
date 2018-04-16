package com.markets.marketList;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.markets.R;
import com.markets.marketList.recyclerViewContent.MarketItem;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MarketItemRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<MarketItem> marketItems;

    MarketItemRecyclerViewAdapter() {
        marketItems = new ArrayList<>();
        notifyDataSetChanged();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(viewType, parent, false);
        if (viewType == R.layout.market_item)
            return new MarketItemViewHolder(view);
        else return new NoContentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, int position) {

        if (holder instanceof MarketItemViewHolder) {
            MarketItemViewHolder marketItemViewHolder = (MarketItemViewHolder) holder;
            marketItemViewHolder.mItem = marketItems.get(position);
            marketItemViewHolder.mDisplayOffer.setText(marketItems.get(position).getDisplayOffer());
            marketItemViewHolder.mInstrumentName.setText(marketItems.get(position).getInstrumentName());
        }

    }

    @Override
    public int getItemCount() {
        if (marketItems.size() == 0) return 1; // to inflate empty view
        else return marketItems.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (marketItems.size() == 0) return R.layout.no_content_view;
        else return R.layout.market_item;
    }

    void setItems(List<MarketItem> items) {
        marketItems = items;
        notifyDataSetChanged();
    }

    class MarketItemViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.instrument_name)
        TextView mInstrumentName;
        @BindView(R.id.display_offer)
        TextView mDisplayOffer;

        MarketItem mItem;

        MarketItemViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }

    }

    class NoContentViewHolder extends RecyclerView.ViewHolder {
        NoContentViewHolder(View itemView) {
            super(itemView);
        }
    }

}
