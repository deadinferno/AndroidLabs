package headofgears.lab01;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements View.OnClickListener{

    private static final String TAG = "myLog";
    private static final String activityName = "MainActivity";

    TextView textPhNumbDetails;
    TextView textEmailDetails;
    Button btnCall;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "ACTIVITY::STATE::onCreate()" + outputActivityName());
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textPhNumbDetails = findViewById(R.id.textPhNumbDetails);
        textEmailDetails = findViewById(R.id.textEmailDetails);
        btnCall = findViewById(R.id.btnCall);
        Log.d(TAG, "INFO::SUCCESS::findViewById()" + outputActivityName());

        btnCall.setOnClickListener(this);
        Log.d(TAG, "INFO::SUCCESS::setOnClickListener()" + outputActivityName());
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

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            // НАБРАТЬ СТУДЕНТА
            case R.id.btnCall:
                Log.d(TAG, "CLICK::btnCall" + outputActivityName());

                String phNumber = "" + textPhNumbDetails.getText();
                Toast.makeText(this, "Набираем " + phNumber, Toast.LENGTH_LONG).show();

                Intent callIntent = new Intent(Intent.ACTION_CALL, Uri.fromParts("tel", phNumber, null));
                //Log.d(TAG, "SET::INTENT::callIntent" + outputActivityName());

                startActivity(callIntent);
                //Log.d(TAG, "START::INTENT::callIntent" + outputActivityName());
            break;

            // ACTIVITY LIFE CYCLE INFO
            case R.id.btnGoInfoActivity:
                Log.d(TAG, "CLICK::btnGoInfoActivity" + outputActivityName());
                Intent intentGoInfoActivity = new Intent(this, InfoActivity.class);
                startActivity(intentGoInfoActivity);
                break;

            case R.id.textEmailDetails:
                Log.d(TAG, "CLICK::textEmailDetails" + outputActivityName());

                Intent email = new Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto", (String)textEmailDetails.getText(), ""));
                //Log.d(TAG, "SET::INTENT::email" + outputActivityName());

                startActivity(Intent.createChooser(email, "Отправить письмо"));
                //Log.d(TAG, "START::INTENT::email" + outputActivityName());
                break;

            case R.id.editNumbers:
                Log.d(TAG, "CLICK::editNumbers" + outputActivityName());
                break;

            case R.id.textPhNumbDetails:
                Log.d(TAG, "CLICK::textPhNumberDetails" + outputActivityName());
                break;
        }
    }

    public String outputActivityName() {
        return " [ " + activityName + " ]";
    }
}
