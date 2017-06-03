# rewarded-ads-sample
Sample project to show rewarded ads on your android app 

# Usage

```java
public class MainActivity extends AppCompatActivity implements RewardedVideoListener{
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ...
        RewardedAd rewardedAd = RewardedAdFactory.getRewardedAd(this, AdType.ADMOB, this);
        rewardedAd.showAd();
        ...
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
```

3 ad network types are supported. PR's are welcome for other ad networks.
``` java 
AdType.ADMOB
AdType.CHARTBOOST
AdType.STARTAPP
```

# Handling Lifecycle
LifeCycleRegistry is used to handle lifecycle in Ad instances.
```java
LifecycleRegistry lifecycleRegistry = new LifecycleRegistry(this);
lifecycleRegistry.addObserver(rewardedAd.getObserver());
```

# Replace Keys
```xml
    <!-- Chartboost -->
    <string name="chartboost_app_id">[REPLACE_CHARTBOOST_APP_ID]</string>
    <string name="chartboost_app_signature">[REPLACE_CHARTBOOST_APP_SIGNATURE]</string>

    <!-- Admob -->
    <string name="admob_unit_id">[REPLACE_ADMOB_AD_UNIT_ID]</string>

    <!-- Startapp -->
    <string name="startapp_app_id">[REPLACE_STARTAPP_APP_ID]</string>
```
