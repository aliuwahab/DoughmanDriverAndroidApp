package gbeilaaliuwahab.doughmandriverapp;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import gbeilaaliuwahab.doughmandriverapp.data.Order;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link OrderDetails.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link OrderDetails#newInstance} factory method to
 * create an instance of this fragment.
 */
public class OrderDetails extends Fragment implements OnMapReadyCallback {

    GoogleMap mGoogleMap;
    MapView mMapView;
    View view;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_ORDER_TITLE = "param1";
    private static final String ARG_ORDER_DESCRIPTION = "param2";

    // TODO: Rename and change types of parameters
    private String orderTitle;
    private String orderDescription;

    private OnFragmentInteractionListener mListener;

    public OrderDetails() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment OrderDetails.
     */
    // TODO: Rename and change types and number of parameters
    public static OrderDetails newInstance(Order order) {
        OrderDetails fragment = new OrderDetails();
        Bundle args = new Bundle();
        args.putString(ARG_ORDER_TITLE, order.getOrderTitle());
        args.putString(ARG_ORDER_DESCRIPTION, order.getOrderDescription());
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            orderTitle = getArguments().getString(ARG_ORDER_TITLE);
            orderDescription = getArguments().getString(ARG_ORDER_DESCRIPTION);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_order_details, container, false);
        TextView textViewOrderTitle = view.findViewById(R.id.order_details_title);
        TextView textViewOrderDescription = view.findViewById(R.id.order_details_description);
        textViewOrderTitle.setText(orderTitle);
        textViewOrderDescription.setText(orderDescription);
        return view;
    }


    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mMapView = (MapView) view.findViewById(R.id.map_view_order_location);

        if (mMapView != null) {
            mMapView.onCreate(null);
            mMapView.onResume();
            mMapView.getMapAsync(this);
        }

    }



    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {

        MapsInitializer.initialize(getContext());
        mGoogleMap = googleMap;
        googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        googleMap.addMarker(new MarkerOptions().position(new LatLng(5.644675, -0.151244))
                .title("MEST Incubator")
                .snippet("Meltwater Entreprenuerial School of Technology Incubator, East Legon, Accra-Ghana"));

        CameraPosition mestIncubator = CameraPosition.builder()
                .target(new LatLng(5.644675, -0.151244)).zoom(16).bearing(0).tilt(45).build();

        googleMap.moveCamera(CameraUpdateFactory.newCameraPosition(mestIncubator));
    }


    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }



    public void setViewDetails(){


    }

}
