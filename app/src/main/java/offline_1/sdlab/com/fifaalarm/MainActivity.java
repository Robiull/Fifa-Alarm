 package offline_1.sdlab.com.fifaalarm;


import android.app.Fragment;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

import  android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.widget.ImageButton;
import android.widget.Switch;

 public class MainActivity extends AppCompatActivity {
    Button bt1,bt2,bt3,bt4;
    Fragment fragment;


     @Override
    protected void onCreate(Bundle savedInstanceState) {
         Log.d("switch 1","I ccc up here");

         super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.main, menu);



        Button groupbutton = (Button) findViewById(R.id.group);
        Button homebutton = (Button) findViewById(R.id.home);
        Button historybutton = (Button) findViewById(R.id.historybutton);
        Button alarmbutton = (Button) findViewById(R.id.alarmbutton);



        homebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myintent = new Intent(MainActivity.this, groupActivity.class);
                startActivity(myintent);
            }
        });

        historybutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myintent = new Intent(MainActivity.this, Historyactivity.class);
                startActivity(myintent);
            }
        });

        alarmbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myintent = new Intent(MainActivity.this, Finalalarm.class);
                startActivity(myintent);
            }
        });

        return true;


    }



     void ChangeFragment(View view){
         Fragment fragment;
         if(view == findViewById(R.id.home)){


             FragmentManager fm=getFragmentManager();
             FragmentTransaction ft=fm.beginTransaction();
             ft.remove(null /*no fragments in R.id.content*/);
             fragment = new Home();
             ft.add(R.id.fragments_place,fragment);
             ft.commit();
         }

         else if(view == findViewById(R.id.group)){


             FragmentManager fm=getFragmentManager();
             FragmentTransaction ft=fm.beginTransaction();

             ft.remove(fm.findFragmentById(R.id.fragments_place));
             fragment = new groups();
             ft.add(R.id.fragments_place,fragment);

             ft.commit();
         }

        else if(view == findViewById(R.id.historybutton)){


             FragmentManager fm=getFragmentManager();
             FragmentTransaction ft=fm.beginTransaction();
             ft.remove(fm.findFragmentById(R.id.fragments_place));
             fragment = new  historyfrag ();
             ft.add(R.id.fragments_place,fragment);
             ft.commit();
         }


         else if(view == findViewById(R.id.alarmbutton)){


             FragmentManager fm=getFragmentManager();
             FragmentTransaction ft=fm.beginTransaction();
             ft.remove(fm.findFragmentById(R.id.fragments_place));
             fragment = new final_alarm();
             ft.add(R.id.fragments_place,fragment);
             ft.commit();
         }
     }
     public void showMsg(View view){
         Log.d("Button 1","I am here");
     }
}
