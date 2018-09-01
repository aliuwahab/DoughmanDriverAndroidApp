package gbeilaaliuwahab.doughmandriverapp;

import android.app.ListFragment;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import gbeilaaliuwahab.doughmandriverapp.data.Order;

import java.util.ArrayList;

/**
 * A fragment representing a list of Items.
 * <p/>
 * Activities containing this fragment MUST implement the {@link OnListFragmentInteractionListener}
 * interface.
 */
public class OrderFragment extends Fragment {

    private RecyclerView orderRecyclerView;
    private RecyclerView.Adapter orderAdapter;
    private RecyclerView.LayoutManager orderLayoutManager;

    public ArrayList<Order> orderArrayList = new ArrayList<>();

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public OrderFragment() {

    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_order_list, container, false);

        sampleOrderList();

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
            if (mColumnCount <= 1) {
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
            } else {
                recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
            }
            recyclerView.setAdapter(new MyOrderRecyclerViewAdapter(orderArrayList, mListener));
        }

        return view;

    }


    public void sampleOrderList(){

        orderArrayList.add(new Order(R.drawable.order_icon,"Order One Title","23","Order One Description"));
        orderArrayList.add(new Order(R.drawable.order_icon,"Order Two Title","25","Order Two Description"));
        orderArrayList.add(new Order(R.drawable.order_icon,"Order Three Title","27","Order Three Description"));
        orderArrayList.add(new Order(R.drawable.order_icon,"Order Four Title","27","Order Three Description"));
        orderArrayList.add(new Order(R.drawable.order_icon,"Order Four Title","27","Order Three Description"));
        orderArrayList.add(new Order(R.drawable.order_icon,"Order Four Title","27","Order Three Description"));
        orderArrayList.add(new Order(R.drawable.order_icon,"Order Four Title","27","Order Three Description"));
        orderArrayList.add(new Order(R.drawable.order_icon,"Order Four Title","27","Order Three Description"));
        orderArrayList.add(new Order(R.drawable.order_icon,"Order Four Title","27","Order Three Description"));
        orderArrayList.add(new Order(R.drawable.order_icon,"Order Four Title","27","Order Three Description"));
        orderArrayList.add(new Order(R.drawable.order_icon,"Order Four Title","27","Order Three Description"));
        orderArrayList.add(new Order(R.drawable.order_icon,"Order Four Title","27","Order Three Description"));
        orderArrayList.add(new Order(R.drawable.order_icon,"Order Four Title","27","Order Three Description"));

    }


    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnListFragmentInteractionListener {
        void onListFragmentInteraction(Order order);
    }


    // TODO: Customize parameters
    private int mColumnCount = 1;
    private OnListFragmentInteractionListener mListener;


    @Override
    public void onAttach(Context context) {

        super.onAttach(context);
        if (context instanceof OnListFragmentInteractionListener) {
            mListener = (OnListFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnListFragmentInteractionListener");
        }

    }




    @Override
    public void onDetach() {

        super.onDetach();
        mListener = null;

    }










}
