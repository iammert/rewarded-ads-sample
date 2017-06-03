package iammert.com.adsample.ads.chartboost;

import android.app.Activity;
import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.OnLifecycleEvent;

import com.chartboost.sdk.CBLocation;
import com.chartboost.sdk.Chartboost;
import com.chartboost.sdk.Model.CBError;

import iammert.com.adsample.R;
import iammert.com.adsample.ads.RewardedAd;
import iammert.com.adsample.ads.RewardedVideoListener;

/**
 * Created by mertsimsek on 31/05/2017.
 */

public class ChartBoostHandler implements LifecycleObserver, RewardedAd {

    private Activity activity;
    private RewardedVideoListener rewardedVideoListener;

    public ChartBoostHandler(Activity activity, RewardedVideoListener rewardedVideoListener) {
        this.activity = activity;
        this.rewardedVideoListener = rewardedVideoListener;
        Chartboost.startWithAppId(activity,
                activity.getString(R.string.chartboost_app_id),
                activity.getString(R.string.chartboost_app_signature));
        Chartboost.onCreate(activity);
        Chartboost.setDelegate(chartboostDelegate);
    }

    @Override
    public void showAd() {
        Chartboost.showRewardedVideo(CBLocation.LOCATION_GAMEOVER);
        Chartboost.cacheRewardedVideo(CBLocation.LOCATION_GAMEOVER);
    }

    @Override
    public LifecycleObserver getObserver() {
        return this;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    public void onStart() {
        Chartboost.onStart(activity);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public void onResume() {
        Chartboost.onResume(activity);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public void onPause() {
        Chartboost.onPause(activity);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public void onStop() {
        Chartboost.onStop(activity);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void onDestroy() {
        Chartboost.onDestroy(activity);
        rewardedVideoListener = null;
        activity = null;
    }

    private final SimpleChartboostDelegate chartboostDelegate = new SimpleChartboostDelegate() {
        @Override
        public void didCompleteRewardedVideo(String location, int reward) {
            super.didCompleteRewardedVideo(location, reward);
            if (rewardedVideoListener != null)
                rewardedVideoListener.onVideoCompleted();
        }

        @Override
        public void didFailToLoadRewardedVideo(String location, CBError.CBImpressionError error) {
            super.didFailToLoadRewardedVideo(location, error);
            if (rewardedVideoListener != null)
                rewardedVideoListener.onVideoLoadFailed();
        }

        @Override
        public void didCacheRewardedVideo(String location) {
            super.didCacheRewardedVideo(location);
            if (rewardedVideoListener != null)
                rewardedVideoListener.onVideoStarted();
        }
    };
}
