package edm.music.t3v.activity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import edm.music.t3v.R;
import edm.music.t3v.adapter.BlogAdapter;
import edm.music.t3v.model.BlogRadio;

/**
 * Created by Hoàng Thông on 7/11/2017.
 */
public class ListPost extends AppCompatActivity {
    private String url, titlecat;
    private List<BlogRadio> radioList = new ArrayList<>();
    private RecyclerView recyclerView;
    private BlogAdapter mAdapter;
    private int current_page = 1;
    private Toolbar mToolbar;
    int pastVisiblesItems, visibleItemCount, totalItemCount;
    private boolean loading = true;
    private ProgressDialog pDialog;

    @Override
    protected void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        setContentView(R.layout.listpost);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);

        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);


        getSupportActionBar().setTitle(titlecat);
        mToolbar.setNavigationIcon ( R.drawable.back);

        mToolbar.setNavigationOnClickListener ( new  View.OnClickListener ()  {
            @Override
            public  void onClick ( View v )  {
               onBackPressed();
            }
        });
    }
}
