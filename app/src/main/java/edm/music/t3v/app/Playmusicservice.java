package edm.music.t3v.app;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Handler;
import android.os.IBinder;
import android.support.annotation.Nullable;

import android.util.Log;
import android.widget.Toast;

import java.io.IOException;

/**
 * Cr
 * eated by hoangmobi on 5/16/2016.
 */
public class Playmusicservice extends Service implements MediaPlayer.OnCompletionListener, MediaPlayer.OnPreparedListener, MediaPlayer.OnErrorListener, MediaPlayer.OnSeekCompleteListener, MediaPlayer.OnBufferingUpdateListener, MediaPlayer.OnInfoListener {
    private MediaPlayer mediaplayer = new MediaPlayer();
    private String sntAudioLink;
    //var for seekbar
    String sntSeekPos;
    int mediaPosition;
    int mediaMax;
    private final Handler handler = new Handler();
    private static int songEnded;
    public static final  String BROADCAST_ACTION = "radioblog.mhstudio.seekprogress";
    Intent seekIntent;
    private static String LOG_TAG = "maiMusicService";
    public static final String CMDPAUSE = "pause";


    @Override
    public void onCreate() {
        //setup intent for broadcast seekbar
        seekIntent = new Intent(BROADCAST_ACTION);
        mediaplayer.setOnCompletionListener(this);
        mediaplayer.setOnErrorListener(this);
        mediaplayer.setOnPreparedListener(this);
        mediaplayer.setOnBufferingUpdateListener(this);
        mediaplayer.setOnSeekCompleteListener(this);
        mediaplayer.setOnInfoListener(this);
        mediaplayer.reset();


    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        sntAudioLink = intent.getExtras().getString("sentAudioLink");
       // String sntAudioLink2 = intent.getExtras().getString("sentTest");
        //Toast.makeText(getBaseContext(),sntAudioLink2, Toast.LENGTH_SHORT).show();
        mediaplayer.reset();
        if (!mediaplayer.isPlaying()) {
            try {
                mediaplayer.setDataSource("http://stream2.r11s129.vcdn.vn/fsfsdfdsfdserwrwq3/c5ec9f21007a07c82e1065c6a5aec162/573b3b15/2013/07/24/4/5/4507250237deabc3c2e51db5b23703d7.mp3");
                mediaplayer.prepareAsync();
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            } catch (IllegalStateException e) {
                e.printStackTrace();
            } catch (IOException e) {
            }
        }
        //setup seekbar handler
        setupHandler();
        return START_STICKY;
    }

    private void setupHandler() {

        handler.removeCallbacks(sendUpdatetoUI);
        handler.postDelayed(sendUpdatetoUI,1000);
    }
    private Runnable sendUpdatetoUI = new Runnable(){

        @Override
        public void run() {
            LogMediaPosition();
            handler.postDelayed(this,1000);
        }
    };
            private void LogMediaPosition(){
               if(mediaplayer.isPlaying()){
                   mediaPosition = mediaplayer.getCurrentPosition();
                   mediaMax = mediaplayer.getDuration();

                   seekIntent.putExtra("counter", String.valueOf(mediaPosition));
                   seekIntent.putExtra("mediamax",String.valueOf(mediaMax));
                   seekIntent.putExtra("song_ended",String.valueOf(songEnded));
                   sendBroadcast(seekIntent);

               }

            }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mediaplayer != null) {
            if (mediaplayer.isPlaying()) {
                mediaplayer.stop();
            }
            mediaplayer.release();
        }
        handler.removeCallbacks(sendUpdatetoUI);
    }

    @Override
    public void onBufferingUpdate(MediaPlayer mp, int percent) {

    }

    @Override
    public void onCompletion(MediaPlayer mp) {
        stopMedia();
        stopSelf();
    }


    @Override
    public boolean onInfo(MediaPlayer mp, int what, int extra) {
        return false;
    }

    @Override
    public void onPrepared(MediaPlayer mp) {
        playMedia();
    }

    public void playMedia() {
        if (!mediaplayer.isPlaying()) {
            mediaplayer.start();
        }
    }

    public void stopMedia() {
        if (mediaplayer.isPlaying()) {
            mediaplayer.stop();
        }
    }

    @Override
    public void onSeekComplete(MediaPlayer mp) {

    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
    @Override
    public void onRebind(Intent intent) {
        Log.i(LOG_TAG, "onRebind");
        super.onRebind(intent);
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.i(LOG_TAG, "onUnbind");
        return true;
    }

    @Override
    public boolean onError(MediaPlayer mp, int what, int extra) {
        switch (what) {
            case MediaPlayer.MEDIA_ERROR_NOT_VALID_FOR_PROGRESSIVE_PLAYBACK:
                Toast.makeText(this, "File khong hop le!", Toast.LENGTH_SHORT).show();
                break;
            case MediaPlayer.MEDIA_ERROR_SERVER_DIED:
                Toast.makeText(this, "Khong tim thay file!", Toast.LENGTH_SHORT).show();
                break;
            case MediaPlayer.MEDIA_ERROR_UNKNOWN:
                Toast.makeText(this, "Co loi xay ra!", Toast.LENGTH_SHORT).show();
                break;
        }
        return false;
    }
    private BroadcastReceiver mIntentReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            String cmd = intent.getStringExtra("command");
            if (CMDPAUSE.equals(cmd) || CMDPAUSE.equals(action)) {
                Toast.makeText(getBaseContext(),"action",Toast.LENGTH_SHORT);
            }
        }
    };


}
