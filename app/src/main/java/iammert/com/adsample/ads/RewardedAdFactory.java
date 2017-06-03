package iammert.com.adsample.ads;

import android.app.Activity;

import iammert.com.adsample.ads.AdType;
import iammert.com.adsample.ads.RewardedAd;
import iammert.com.adsample.ads.RewardedVideoListener;
import iammert.com.adsample.ads.admob.AdmobHandler;
import iammert.com.adsample.ads.chartboost.ChartBoostHandler;
import iammert.com.adsample.ads.startapp.StartAppHandler;

/**
 * Created by mertsimsek on 31/05/2017.
 */

public class RewardedAdFactory {

    public static RewardedAd getRewardedAd(Activity activity, AdType adNetwork, RewardedVideoListener listener) {
        RewardedAd rewardedAd = null;
        switch (adNetwork) {
            case ADMOB:
                rewardedAd = new AdmobHandler(activity, listener);
                break;
            case CHARTBOOST:
                rewardedAd = new ChartBoostHandler(activity, listener);
                break;
            case STARTAPP:
                rewardedAd = new StartAppHandler(activity, listener);
                break;
            default:
                break;
        }
        return rewardedAd;
    }
}
