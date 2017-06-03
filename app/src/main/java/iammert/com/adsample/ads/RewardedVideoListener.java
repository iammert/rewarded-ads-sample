package iammert.com.adsample.ads;

/**
 * Created by mertsimsek on 31/05/2017.
 */

public interface RewardedVideoListener {

    void onVideoCompleted();

    void onVideoLoadFailed();

    void onVideoStarted();
}
