package com.mrt.transporter.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mrt.transporter.R;
import com.mrt.transporter.entity.Order;

import java.util.ArrayList;

/**
 * Created by DaoMinhThien on 7/30/17.
 */

public class OrderAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    ArrayList<Order> list;

    public OrderAdapter(ArrayList<Order> list) {
        this.list = list;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_order_view, parent, false);

        return new ItemOrderView(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ItemOrderView itemOrderView = (ItemOrderView) holder;

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ItemOrderView extends RecyclerView.ViewHolder{

        public ItemOrderView(View itemView) {
            super(itemView);
        }
    }
}
