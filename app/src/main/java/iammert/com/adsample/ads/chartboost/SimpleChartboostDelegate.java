package iammert.com.adsample.ads.chartboost;

import com.chartboost.sdk.ChartboostDelegate;
import com.chartboost.sdk.Model.CBError;

/**
 * Created by mertsimsek on 31/05/2017.
 */

public abstract class SimpleChartboostDelegate extends ChartboostDelegate {

    @Override
    public boolean shouldRequestInterstitial(String location) {
        return super.shouldRequestInterstitial(location);
    }

    @Override
    public boolean shouldDisplayInterstitial(String location) {
        return super.shouldDisplayInterstitial(location);
    }

    @Override
    public void didCacheInterstitial(String location) {
        super.didCacheInterstitial(location);
    }

    @Override
    public void didFailToLoadInterstitial(String location, CBError.CBImpressionError error) {
        super.didFailToLoadInterstitial(location, error);
    }

    @Override
    public void didDismissInterstitial(String location) {
        super.didDismissInterstitial(location);
    }

    @Override
    public void didCloseInterstitial(String location) {
        super.didCloseInterstitial(location);
    }

    @Override
    public void didClickInterstitial(String location) {
        super.didClickInterstitial(location);
    }

    @Override
    public void didDisplayInterstitial(String location) {
        super.didDisplayInterstitial(location);
    }

    @Override
    public boolean shouldRequestMoreApps(String location) {
        return super.shouldRequestMoreApps(location);
    }

    @Override
    public void didCacheMoreApps(String location) {
        super.didCacheMoreApps(location);
    }

    @Override
    public boolean shouldDisplayMoreApps(String location) {
        return super.shouldDisplayMoreApps(location);
    }

    @Override
    public void didFailToLoadMoreApps(String location, CBError.CBImpressionError error) {
        super.didFailToLoadMoreApps(location, error);
    }

    @Override
    public void didDismissMoreApps(String location) {
        super.didDismissMoreApps(location);
    }

    @Override
    public void didCloseMoreApps(String location) {
        super.didCloseMoreApps(location);
    }

    @Override
    public void didClickMoreApps(String location) {
        super.didClickMoreApps(location);
    }

    @Override
    public void didDisplayMoreApps(String location) {
        super.didDisplayMoreApps(location);
    }

    @Override
    public void didFailToRecordClick(String uri, CBError.CBClickError error) {
        super.didFailToRecordClick(uri, error);
    }

    @Override
    public boolean shouldDisplayRewardedVideo(String location) {
        return super.shouldDisplayRewardedVideo(location);
    }

    @Override
    public void didCacheRewardedVideo(String location) {
        super.didCacheRewardedVideo(location);
    }

    @Override
    public void didDismissRewardedVideo(String location) {
        super.didDismissRewardedVideo(location);
    }

    @Override
    public void didCloseRewardedVideo(String location) {
        super.didCloseRewardedVideo(location);
    }

    @Override
    public void didClickRewardedVideo(String location) {
        super.didClickRewardedVideo(location);
    }

    @Override
    public void didDisplayRewardedVideo(String location) {
        super.didDisplayRewardedVideo(location);
    }

    @Override
    public void willDisplayVideo(String location) {
        super.willDisplayVideo(location);
    }

    @Override
    public void didCacheInPlay(String location) {
        super.didCacheInPlay(location);
    }

    @Override
    public void didFailToLoadInPlay(String location, CBError.CBImpressionError error) {
        super.didFailToLoadInPlay(location, error);
    }

    @Override
    public void didInitialize() {
        super.didInitialize();
    }
}
