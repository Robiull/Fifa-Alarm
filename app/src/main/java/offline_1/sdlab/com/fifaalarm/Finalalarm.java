package offline_1.sdlab.com.fifaalarm;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.Switch;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import offline_1.sdlab.com.fifaalarm.Database.DatabaseHandler;

public class Finalalarm extends AppCompatActivity {
    private PendingIntent pendingIntent;
    private ImageButton SettingsBackButton;
    private Switch switch11, switch22;
    public static int indexnum=1;
    public static int counts=1;

    final  DatabaseHandler db=new DatabaseHandler(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_final_alarm);
        Intent alarmIntent = new Intent(Finalalarm.this, AlarmReceiverClass.class);
        // pendingIntent = PendingIntent.getBroadcast(Finalalarm.this, 0, alarmIntent, PendingIntent.FLAG_UPDATE_CURRENT);
        // ImageButton SettingsBackButton=(ImageButton)findViewById(R.id.Back_buttonSetting);

        switch11 = (Switch) findViewById(R.id.switch1);
        switch22 = (Switch) findViewById(R.id.switch2);
        if(switch11!=null){

            switch11.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView,boolean isChecked) {
                    if (isChecked == true) {

                        // startAt12();
                        setAllAlarm();

                    } else {
                        //cancel();
                        cancelAlarms();

                    }
                }
            });
        }
        if(switch22!=null){

            switch22.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (isChecked == true) {
                        Intent intent = new Intent(Finalalarm.this, InsertTime.class);
                        startActivity(intent);

                    } else {
                        cancel();
                    }
                }
            });
        }

    }

    public void cancel() {
        AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        alarmManager.cancel(pendingIntent);
        // indexnum=1;
        Toast.makeText(this, "Alarm Canceled", Toast.LENGTH_SHORT).show();
    }

    public void startAt12() {
        Time myTime=db.getTime(indexnum);
        int s1=Integer.parseInt(myTime.getHour());
        int s2=Integer.parseInt(myTime.getMinute());
        AlarmManager manager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        /* Set the alarm to start at 04:30 PM */
        Calendar calendar = Calendar.getInstance();
        Intent alarmIntent = new Intent(Finalalarm.this, AlarmReceiverClass.class);
        calendar.setTimeInMillis(System.currentTimeMillis());

        Toast.makeText(this, "finalalarm  hour="+s1, Toast.LENGTH_SHORT).show();

        Toast.makeText(this, "finalalarm  min="+s2, Toast.LENGTH_SHORT).show();
        calendar.set(Calendar.HOUR_OF_DAY, s1);
        calendar.set(Calendar.MINUTE, s2);


        manager.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), AlarmManager.INTERVAL_DAY, pendingIntent);

        Toast.makeText(this, "Alarm ding donng", Toast.LENGTH_SHORT).show();
        ;//this is optional just to show that this is working .
        //You can do whatever in this, it will only works when the day is friday

    }


    List<PendingIntent> intentArray;
    AlarmManager[] alarmManager;
    public void setAllAlarm() {
        List<Time> allTimes=db.getAllTime();

        alarmManager=new AlarmManager[allTimes.size()];
        intentArray = new ArrayList<PendingIntent>();
//        AlarmManager manager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);

        int index =0;
        for(Time myTime : allTimes)
        {
            int s1=Integer.parseInt(myTime.getHour());
            int s2=Integer.parseInt(myTime.getMinute());

            /* Set the alarm to start at 04:30 PM */
            Calendar calendar = Calendar.getInstance();
            Intent alarmIntent = new Intent(Finalalarm.this, AlarmReceiverClass.class);
            calendar.setTimeInMillis(System.currentTimeMillis());
            Toast.makeText(this, "finalalarm  hour="+s1, Toast.LENGTH_SHORT).show();
            Toast.makeText(this, "finalalarm  min="+s2, Toast.LENGTH_SHORT).show();
            calendar.set(Calendar.HOUR_OF_DAY, s1);
            calendar.set(Calendar.MINUTE, s2);
            calendar.set(Calendar.SECOND, 0);

            PendingIntent  pendingIntent = PendingIntent.getBroadcast(Finalalarm.this, index, alarmIntent, PendingIntent.FLAG_ONE_SHOT);

            alarmManager[index] = (AlarmManager) getSystemService(ALARM_SERVICE);
            alarmManager[index].set(AlarmManager.RTC_WAKEUP,calendar.getTimeInMillis() ,pendingIntent);
            intentArray.add(pendingIntent);
            index++;
            // manager.set(AlarmManager.ELAPSED_REALTIME_WAKEUP, calendar.getTimeInMillis(), pendingIntent);

            Toast.makeText(this, "Alarm ding donng", Toast.LENGTH_SHORT).show();
            ;//this is optional just to show that this is working .
            //You can do whatever in this, it will only works when the day is friday
        }
    }

    private void cancelAlarms() {
        if (intentArray.size() > 0) {
            for (int i = 0; i < intentArray.size(); i++) {
                alarmManager[i].cancel(intentArray.get(i));
            }
            intentArray.clear();
        }
    }
}
