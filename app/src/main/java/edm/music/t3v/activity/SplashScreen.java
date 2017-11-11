package edm.music.t3v.activity;

/**
 * Created by Hoàng Thông on 7/11/2017.
 */

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import edm.music.t3v.R;
import edm.music.t3v.app.ConnectionDetector;

public class SplashScreen extends Activity {
    TextView txtconect;
    Boolean isInternetPresent = false;

    // Connection detector class
    ConnectionDetector cd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splashscreen);
//		getActionBar().hide();
        //kiểm tra kết nối internet
        txtconect = (TextView) findViewById(R.id.txtconect);
        cd = new ConnectionDetector(getApplicationContext());



        Thread bamgio=new Thread(){
            public void run(){
                try{
                    sleep(1000);
                }catch(Exception e){

                }finally{

                    // check for Internet status

                    Intent activitymoi=
                            new Intent(SplashScreen.this,MainActivity.class);
                    startActivity(activitymoi);
                    overridePendingTransition(R.anim.push_right_in, R.anim.push_right_out);




                }
            }
        };
        isInternetPresent = cd.isConnectingToInternet();
        if (isInternetPresent) {
            bamgio.start();
        }else if(isInternetPresent==false){
            Toast toast=Toast.makeText(getApplicationContext(), "Vui lòng kết nối inernet",   Toast.LENGTH_SHORT);
            toast.show();
            txtconect.setText("Không có kết nối internet!");
        }
    }

    @Override
    protected void onPause() {
        // TODO Auto-generated method stub
        super.onPause();
        finish();
    }

}
