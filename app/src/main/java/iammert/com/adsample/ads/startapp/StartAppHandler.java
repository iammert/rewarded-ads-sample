package iammert.com.adsample.ads.startapp;

import android.app.Activity;
import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.OnLifecycleEvent;

import com.startapp.android.publish.adsCommon.Ad;
import com.startapp.android.publish.adsCommon.StartAppAd;
import com.startapp.android.publish.adsCommon.StartAppSDK;
import com.startapp.android.publish.adsCommon.VideoListener;
import com.startapp.android.publish.adsCommon.adListeners.AdEventListener;

import iammert.com.adsample.R;
import iammert.com.adsample.ads.RewardedAd;
import iammert.com.adsample.ads.RewardedVideoListener;

/**
 * Created by mertsimsek on 03/06/2017.
 */

public class StartAppHandler implements LifecycleObserver, RewardedAd, VideoListener, AdEventListener {


    private StartAppAd startAppAd;
    private RewardedVideoListener rewardedVideoListener;

    public StartAppHandler(Activity activity, RewardedVideoListener rewardedVideoListener) {
        this.rewardedVideoListener = rewardedVideoListener;
        StartAppSDK.init(activity, activity.getString(R.string.startapp_app_id), true);
        startAppAd = new StartAppAd(activity);
        startAppAd.setVideoListener(this);
    }

    @Override
    public void onVideoCompleted() {
        if (rewardedVideoListener != null)
            rewardedVideoListener.onVideoCompleted();
    }

    @Override
    public void showAd() {
        startAppAd.loadAd(StartAppAd.AdMode.REWARDED_VIDEO, this);
    }

    @Override
    public LifecycleObserver getObserver() {
        return this;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public void onResume() {
        startAppAd.onResume();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public void onPause() {
        startAppAd.onPause();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void onDestroy() {
        startAppAd = null;
    }

    @Override
    public void onReceiveAd(Ad ad) {
        startAppAd.showAd();
        if (rewardedVideoListener != null)
            rewardedVideoListener.onVideoStarted();
    }

    @Override
    public void onFailedToReceiveAd(Ad ad) {
        if (rewardedVideoListener != null)
            rewardedVideoListener.onVideoLoadFailed();
    }
}
