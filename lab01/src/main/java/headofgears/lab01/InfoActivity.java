package headofgears.lab01;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

public class InfoActivity extends Activity {

    private static final String TAG = "myLog";
    private static final String activityName = "InfoActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
    }

    @Override
    protected  void onStart() {
        super.onStart();
        Log.d(TAG, "ACTIVITY::STATE::onStart()" + outputActivityName());
    }

    @Override
    protected  void onResume() {
        super.onResume();
        Log.d(TAG, "ACTIVITY::STATE::onResume()" + outputActivityName());
    }

    @Override
    protected  void onPause() {
        super.onPause();
        Log.d(TAG, "ACTIVITY::STATE::onPause()" + outputActivityName());
    }

    @Override
    protected  void onStop() {
        super.onStop();
        Log.d(TAG, "ACTIVITY::STATE::onStop()" + outputActivityName());
    }

    @Override
    protected  void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "ACTIVITY::STATE::onDestroy()" + outputActivityName());
    }

    public String outputActivityName() {
        return " [ " + activityName + " ]";
    }

}
