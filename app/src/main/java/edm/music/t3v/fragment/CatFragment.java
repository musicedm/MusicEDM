package edm.music.t3v.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import edm.music.t3v.R;
import edm.music.t3v.activity.DividerItemDecoration;
import edm.music.t3v.adapter.CatAdapter;
import edm.music.t3v.model.Category;


/**
 * Created by Hoàng Thông on 7/11/2017.
 */
public class CatFragment extends Fragment {


    private List<Category> catList = new ArrayList<>();
    private RecyclerView recyclerView;
    private CatAdapter mAdapter;
    private String url = "";


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final View rootView = inflater.inflate(R.layout.playlist_layout, container, false);
        recyclerView = (RecyclerView) rootView.findViewById(R.id.recycler_view2);
        mAdapter = new CatAdapter(catList);
        final LinearLayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new DividerItemDecoration(getContext(), LinearLayoutManager.VERTICAL));
        //recyclerView.setAdapter(mAdapter);

        return rootView;
    }

}
