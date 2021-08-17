package offline_1.sdlab.com.fifaalarm;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toolbar;
import android.widget.Button;
import android.widget.TimePicker;

import java.util.Calendar;

import offline_1.sdlab.com.fifaalarm.R;

public class AlaramcodeActivity extends AppCompatActivity {
    AlarmManager alarm_manager;
    TimePicker alarm_Timepicker;
    TextView setAlarm;
    Context context;
    private static int timeHour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
    private static int timeMinute = Calendar.getInstance().get(Calendar.MINUTE);
    TextView textView1;
    private static TextView textView2;
    public static TextView getTextView2() {
        return textView2;
    }
    private PendingIntent pendingIntent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        textView1 = (TextView)findViewById(R.id.msg1);
        textView1.setText(timeHour + ":" + timeMinute);
        textView2 = (TextView)findViewById(R.id.msg2);
        setContentView(R.layout.activity_alaramcode);
        this.context=this;
        alarm_manager=(AlarmManager)getSystemService(ALARM_SERVICE);
        alarm_Timepicker=(TimePicker)findViewById(R.id.timePicker);
        setAlarm=(TextView) findViewById(R.id.setAlarm);
        Calendar calendar=Calendar.getInstance();
        Button alarm_on=(Button)findViewById(R.id.turnonAlarm);
        alarm_on.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               set_alarm_text("Alarm on");
            }
        });


        Button alarm_off=(Button)findViewById(R.id.turnOffAlarm);
        alarm_off.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                set_alarm_text("Alarm off!");
            }
        });

    }

    private void set_alarm_text(String output) {
        setAlarm.setText(output);
    }

}
