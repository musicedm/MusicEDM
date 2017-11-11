package edm.music.t3v.fragment;

/**
 * Created by Hoàng Thông on 7/11/2017.
 */

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import edm.music.t3v.R;


public class TaiveFragment extends Fragment {

    public TaiveFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.servicetest, container, false);
        return rootView;
    }
}