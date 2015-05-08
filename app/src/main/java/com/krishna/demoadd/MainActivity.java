package com.krishna.demoadd;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.appodeal.ads.Appodeal;
import com.appodeal.ads.VideoCallbacks;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String appKey = "5053e829a155074c31d87b9d3a5b1365850c34a764ca5be8";
        Appodeal.initialize(this, appKey);



        Appodeal.setVideoCallbacks(new VideoCallbacks() {
            private Toast mToast;

            @Override
            public void onVideoLoaded() {
                showToast("onVideoLoaded");

                Appodeal.show(MainActivity.this, Appodeal.VIDEO);
            }

            @Override
            public void onVideoFailedToLoad() {
                showToast("onVideoFailedToLoad");
            }

            @Override
            public void onVideoShown() {
                showToast("onVideoShown");
            }

            @Override
            public void onVideoFinished() {
                showToast("onVideoFinished");
            }

            @Override
            public void onVideoClosed() {
                showToast("onVideoClosed");
            }

            void showToast(final String text) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if (mToast == null) {
                            mToast = Toast.makeText(MainActivity.this, text, Toast.LENGTH_SHORT);
                        }
                        mToast.setText(text);
                        mToast.setDuration(Toast.LENGTH_SHORT);
                        mToast.show();
                    }
                });
            }
        });



    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
