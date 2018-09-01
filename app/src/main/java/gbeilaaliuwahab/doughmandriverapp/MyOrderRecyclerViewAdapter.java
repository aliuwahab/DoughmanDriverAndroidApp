package gbeilaaliuwahab.doughmandriverapp;

import android.app.FragmentManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import gbeilaaliuwahab.doughmandriverapp.OrderFragment.OnListFragmentInteractionListener;
import gbeilaaliuwahab.doughmandriverapp.data.Order;

import java.util.ArrayList;
import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link } and makes a call to the
 * specified {@link OnListFragmentInteractionListener}.
 * TODO: Replace the implementation with code for your data type.
 */
public class MyOrderRecyclerViewAdapter extends RecyclerView.Adapter<MyOrderRecyclerViewAdapter.orderViewHolder> {

    private final ArrayList<Order> orders;

    private final OnListFragmentInteractionListener mListener;

    public class orderViewHolder extends RecyclerView.ViewHolder {
        public ImageView orderImage;
        public TextView orderTitle;
        public TextView orderAmount;
        public TextView orderDescription;

        public orderViewHolder(View view) {
            super(view);
            orderImage = view.findViewById(R.id.order_product_image);
            orderTitle = view.findViewById(R.id.order_title);
            orderAmount=  view.findViewById(R.id.order_total_amount);
            orderDescription= view.findViewById(R.id.order_description);

        }



    }



    public MyOrderRecyclerViewAdapter(ArrayList<Order> orderArrayList, OnListFragmentInteractionListener listener) {
        orders = orderArrayList;
        mListener = listener;
    }


    @Override
    public orderViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_order, parent, false);
        return new orderViewHolder(view);
    }


    @Override
    public void onBindViewHolder(final orderViewHolder holder, int position) {
        Order currentOrder = orders.get(position);
        holder.orderImage.setImageResource(currentOrder.getOrderImage());
        holder.orderTitle.setText(currentOrder.getOrderTitle());
        holder.orderAmount.setText(currentOrder.getOrderAmount());
        holder.orderDescription.setText(currentOrder.getOrderDescription());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    int position = holder.getAdapterPosition();
                    if (position != RecyclerView.NO_POSITION) {
                        mListener.onListFragmentInteraction(orders.get(position));
                    }
                }
            }
        });

    }




    @Override
    public int getItemCount() {
        return orders.size();
    }






}
