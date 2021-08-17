package offline_1.sdlab.com.fifaalarm;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import java.util.Calendar;
import java.util.List;

import offline_1.sdlab.com.fifaalarm.Database.DatabaseHandler;
//import offline_1.sdlab.com.fifaalarm.R;

import static android.content.ContentValues.TAG;
import static offline_1.sdlab.com.fifaalarm.Finalalarm.indexnum;

public class AlarmReceiverClass extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        final DatabaseHandler db=new DatabaseHandler(context);
        Toast.makeText(context, "test", Toast.LENGTH_LONG).show();
        Calendar calendar = Calendar.getInstance();
        int hour =calendar.get(Calendar.HOUR_OF_DAY);
        int min =calendar.get(Calendar.MINUTE);

        List<Time> AllTimes=db.getAllTime();
        int index =0;
        for(Time myTime : AllTimes)
        {
            int s1=Integer.parseInt(myTime.getHour());
            int s2=Integer.parseInt(myTime.getMinute());

            /* Set the alarm to start at 04:30 PM */

            Toast.makeText(context, "reciver: gethour="+s1, Toast.LENGTH_LONG).show();

            Toast.makeText(context, "reciver: getmin="+s2, Toast.LENGTH_LONG).show();
            if(hour==s1 && min==s2)
            {
                createNotification(context);
                Toast.makeText(context, "hoche", Toast.LENGTH_LONG).show();

            }
            Toast.makeText(context, "na hoyei hoye gelo", Toast.LENGTH_LONG).show();
            // manager.set(AlarmManager.ELAPSED_REALTIME_WAKEUP, calendar.getTimeInMillis(), pendingIntent);


        }





}
    public void createNotification(Context context) {
        //PendingIntent pendingIntent = PendingIntent.getBroadcast(AlarmReceiverClass.this, 0, dbIntent, PendingIntent.FLAG_UPDATE_CURRENT);
        PendingIntent intent = PendingIntent.getActivity(context, 0, new Intent(context, MainActivity.class), PendingIntent.FLAG_UPDATE_CURRENT);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context)
                .setContentTitle("TEST NOTIFICATION")
                .setContentText("Hi  this is your alarm")
                .setSmallIcon(R.drawable.ic_toys_black_24dp);

        builder.setContentIntent(intent);
        builder.setDefaults(NotificationCompat.DEFAULT_SOUND);
        builder.setDefaults(NotificationCompat.DEFAULT_VIBRATE);

       builder.setAutoCancel(true);

        NotificationManager NotificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        NotificationManager.notify(0, builder.build());
    }
}