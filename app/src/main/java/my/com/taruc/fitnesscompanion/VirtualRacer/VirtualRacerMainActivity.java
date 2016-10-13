package my.com.taruc.fitnesscompanion.VirtualRacer;

import android.app.Activity;
import android.content.Intent;
import android.provider.ContactsContract;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import butterknife.BindView;
import butterknife.ButterKnife;
import my.com.taruc.fitnesscompanion.R;

public class VirtualRacerMainActivity extends Activity implements View.OnClickListener {

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
}
