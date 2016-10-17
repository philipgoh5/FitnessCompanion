package my.com.taruc.fitnesscompanion.VirtualRacer;

import android.app.Activity;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.provider.ContactsContract;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;

import butterknife.BindView;
import butterknife.ButterKnife;
import my.com.taruc.fitnesscompanion.R;

public class VirtualRacerMainActivity extends Activity implements View.OnClickListener {


    //Distance
    MyLocationListener myLocationListener = new MyLocationListener();
    Intent intentDistance;
    boolean isChoice = false;
    Location location;
    protected LocationManager locationManager;
    private static final long MINIMUM_TIME_BETWEEN_UPDATES = 30000;
    private static final long MINIMUM_DISTANCE_CHANGE_FOR_UPDATES = 1; //in Meters
    double plat, plon, clat, clon, dis, initial_dis = 0, total_dis = 0;
    boolean isGPSEnable = false;
    boolean isNetworkEnable = false;

    @BindView(R.id.btnSetTarget)
    ImageButton btnSetTarget;
    @BindView(R.id.btnSetChallenge)
    ImageButton btnSetChallenge;
    @BindView(R.id.btnViewPastRecord)
    ImageButton btnViewPastRecord;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_virtual_racer_main);
        ButterKnife.bind(this);

        btnSetTarget.setOnClickListener(this);
        btnSetChallenge.setOnClickListener(this);
        btnViewPastRecord.setOnClickListener(this);
    }

    @Override
    public void onClick(View v){
        Intent intent;
        switch(v.getId()){
            case R.id.btnSetTarget:
                intent = new Intent(this, SetTarget.class);
                startActivity(intent);
                break;
            case R.id.btnSetChallenge:
                intent = new Intent(this, SetChallenge.class);
                startActivity(intent);
                break;
            case R.id.btnViewPastRecord:
                intent = new Intent(this, ViewPastRecord.class);
                startActivity(intent);
                break;
        }
    }

    private class MyLocationListener implements LocationListener {

        public void onLocationChanged(Location location) {
            String message = String.format("New Location \n Longitude: %1$s \n Latitude: %2$s",
                    location.getLongitude(), location.getLatitude()
            );
            Log.i("Virtual Racer-Location", message);
        }

        public void onStatusChanged(String s, int i, Bundle b) {
            Log.i("Virtual Racer-Location", "Provider status changed");
        }

        public void onProviderDisabled(String s) {
            Log.i("Virtual Racer-Location", "Provider disabled by the user. GPS turned off");
        }

        public void onProviderEnabled(String s) {
            Log.i("Virtual Racer-Location", "Provider enabled by the user. GPS turned on");
        }

    }
}
