package iammert.com.adsample;

import android.arch.lifecycle.LifecycleRegistry;
import android.arch.lifecycle.LifecycleRegistryOwner;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import iammert.com.adsample.ads.AdType;
import iammert.com.adsample.ads.RewardedAd;
import iammert.com.adsample.ads.RewardedAdFactory;
import iammert.com.adsample.ads.RewardedVideoListener;

public class MainActivity extends AppCompatActivity implements LifecycleRegistryOwner, RewardedVideoListener {

    LifecycleRegistry lifecycleRegistry = new LifecycleRegistry(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final RewardedAd rewardedAd = RewardedAdFactory.getRewardedAd(this, AdType.ADMOB, this);
        if (rewardedAd != null)
            lifecycleRegistry.addObserver(rewardedAd.getObserver());

        findViewById(R.id.test).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rewardedAd.showAd();
            }
        });
    }

    @Override
    public LifecycleRegistry getLifecycle() {
        return lifecycleRegistry;
    }

    @Override
    public void onVideoCompleted() {
        Log.v("TEST", "Video completed.");
    }

    @Override
    public void onVideoLoadFailed() {
        Log.v("TEST", "Video failed.");
    }

    @Override
    public void onVideoStarted() {
        Log.v("TEST", "Video started.");
    }
}
