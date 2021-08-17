package offline_1.sdlab.com.fifaalarm;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import offline_1.sdlab.com.fifaalarm.Database.DatabaseHandler;

public class InsertTime extends AppCompatActivity {
    public static String USER_NAME= "UserDate";
    Button displayBtn,addNewTime;
    EditText useryear,usermonth,userday,userhour,userminute;
    TextView display;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_time);
        addNewTime=(Button)findViewById(R.id.addNewTimeBtn);
        useryear=(EditText)findViewById(R.id.userYearET);
         usermonth=(EditText)findViewById(R.id.userMonthET);
        userday=(EditText)findViewById(R.id.userDayET);
         userhour=(EditText)findViewById(R.id.userHourET);
          userminute=(EditText)findViewById(R.id.userMinuteET);
        displayBtn=(Button)findViewById(R.id.displayBtn);
        display=(TextView)findViewById(R.id.displayTV);
        display.setMovementMethod(new ScrollingMovementMethod());

        final DatabaseHandler db=new DatabaseHandler(this);
       // db.deleteAll();
        addNewTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String userYearValue=useryear.getText().toString();
                String userMonthvalue=usermonth.getText().toString();
                String userDayvalue=userday.getText().toString();
                String userHourvalue=userhour.getText().toString();
                String userMinutevalue=userminute.getText().toString();
                Toast.makeText(getApplicationContext(),"Button Clicked",Toast.LENGTH_LONG).show();
                if(userYearValue.equals("")||userMonthvalue.equals("")||userDayvalue.equals("")||userHourvalue.equals("")||userMinutevalue.equals("")){
                    Toast.makeText(getApplicationContext(),"Information missing",Toast.LENGTH_LONG).show();
                }
                else{
                    db.addTime(new Time(userYearValue,userMonthvalue,userDayvalue,userHourvalue,userMinutevalue));
                    Toast.makeText(getApplicationContext(),"Added New Time",Toast.LENGTH_LONG).show();
                }
            }
        });
        displayBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                List<Time> myTimeList=db.getAllTime();
                String result = "";
                for(Time mytime : myTimeList)
                {
                    result +="Id: "+ mytime.getId()+" year: "+mytime.getYear()+" month.: "+ mytime.getMonth()+" day.: "+ mytime.getDay()+" hour.: "+ mytime.getHour()+" minute.: "+ mytime.getMinute();
                    result +="\n";
                    Log.d("Result",result);
                }
                if(myTimeList.size()  == 0)
                {
                    result = "No time to display.";
                }
                display.setText(result);

            }
        });
    }
}
