package iammert.com.adsample.ads;

import android.arch.lifecycle.LifecycleObserver;

/**
 * Created by mertsimsek on 31/05/2017.
 */

public interface RewardedAd {

    void showAd();

    LifecycleObserver getObserver();
}
