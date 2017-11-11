package edm.music.t3v.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import edm.music.t3v.R;
import edm.music.t3v.fragment.CatFragment;
import edm.music.t3v.fragment.HomeFragment;

/**
 * Created by Hoàng Thông on 7/11/2017.
 */

public class MainActivity extends AppCompatActivity implements FragmentDrawer.FragmentDrawerListener {

    private Toolbar mToolbar;
    private FragmentDrawer drawerFragment;
    //View
    private TextView tvTitle, tvCat;
    private ImageView imgDianhac, imgPlay;
    private Intent serviceIntent;
    private RelativeLayout layoutplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mToolbar = (Toolbar) findViewById(R.id.toolbar);

        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        drawerFragment = (FragmentDrawer)
                getSupportFragmentManager().findFragmentById(R.id.fragment_navigation_drawer);
        drawerFragment.setUp(R.id.fragment_navigation_drawer, (DrawerLayout) findViewById(R.id.drawer_layout), mToolbar);
        drawerFragment.setDrawerListener(this);
        displayView(0);
        //player view
        initView();
    }
    @Override
    protected void onStart(){
        super.onStart();
    }

    private void initView() {
        tvTitle = (TextView) findViewById(R.id.tvTitle);
        tvCat = (TextView)findViewById(R.id.tvCat);
        imgPlay = (ImageView)findViewById(R.id.imgplay);
        layoutplay = (RelativeLayout)findViewById(R.id.layoutplay);
        imgDianhac = (ImageView)findViewById(R.id.imgdianhac);
        imgDianhac.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotate_indefinitely) );


    }

    @Override
    protected void onResume() {
        super.onResume();
    }


    @Override
    public void onDrawerItemSelected(View view, int position) {
        displayView(position);
    }

    private void displayView(int position) {
        Fragment fragment = null;
        String title = getString(R.string.app_name);
        switch (position) {
            case 0:
                fragment = new HomeFragment();
                title = getString(R.string.title_home);
                break;
            case 1:
                fragment = new HomeFragment();
                title = getString(R.string.title_trends);
                break;
            case 2:
                fragment = new HomeFragment();
                title = getString(R.string.title_fav);
                break;
            case 3:
                fragment = new HomeFragment();
                title = getString(R.string.title_yeuthich);
                break;
            case 4:
                fragment = new CatFragment();
                title = getString(R.string.title_cat);
                break;
            default:
                break;
        }

        if (fragment != null) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.container_body, fragment);
            fragmentTransaction.commit();

            // set the toolbar title
            getSupportActionBar().setTitle(title);
        }
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();

    }
}
