package iammert.com.adsample.ads.admob;

import android.app.Activity;
import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.OnLifecycleEvent;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.reward.RewardItem;
import com.google.android.gms.ads.reward.RewardedVideoAd;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;

import iammert.com.adsample.R;
import iammert.com.adsample.ads.RewardedAd;
import iammert.com.adsample.ads.RewardedVideoListener;

/**
 * Created by mertsimsek on 31/05/2017.
 */

public class AdmobHandler implements RewardedVideoAdListener, LifecycleObserver, RewardedAd {

    private static final String TEST_DEVICE = "EC2FB0171EDE0861B75EA2E98B5BDFFC";

    private RewardedVideoAd mAd;
    private RewardedVideoListener rewardedVideoListener;
    private Activity activity;

    public AdmobHandler(Activity activity, RewardedVideoListener rewardedVideoListener) {
        this.rewardedVideoListener = rewardedVideoListener;
        this.activity = activity;
        mAd = MobileAds.getRewardedVideoAdInstance(activity);
        mAd.setRewardedVideoAdListener(this);
        mAd.loadAd(activity.getString(R.string.admob_unit_id), buildAdRequest());
    }

    @Override
    public void showAd() {
        if (mAd != null && mAd.isLoaded())
            mAd.show();
    }

    @Override
    public LifecycleObserver getObserver() {
        return this;
    }

    private AdRequest buildAdRequest() {
        return new AdRequest.Builder().addTestDevice(TEST_DEVICE).build();
    }

    @Override
    public void onRewardedVideoAdLoaded() {
    }

    @Override
    public void onRewardedVideoAdOpened() {

    }

    @Override
    public void onRewardedVideoStarted() {
        if (rewardedVideoListener != null)
            rewardedVideoListener.onVideoStarted();
    }

    @Override
    public void onRewardedVideoAdClosed() {
        if (mAd != null)
            mAd.loadAd(activity.getString(R.string.admob_unit_id), buildAdRequest());
    }

    @Override
    public void onRewarded(RewardItem rewardItem) {
        if (rewardedVideoListener != null)
            rewardedVideoListener.onVideoCompleted();
    }

    @Override
    public void onRewardedVideoAdLeftApplication() {

    }

    @Override
    public void onRewardedVideoAdFailedToLoad(int i) {
        if (rewardedVideoListener != null)
            rewardedVideoListener.onVideoLoadFailed();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void onDestroy() {
        rewardedVideoListener = null;
        mAd = null;
        activity = null;
    }

}
