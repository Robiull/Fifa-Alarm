package offline_1.sdlab.com.fifaalarm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;



public class Historyactivity extends AppCompatActivity {
    Button buttonyear2018,buttonyear2014,buttonyear2010,buttonyear2006,buttonyear2002,buttonyear1998,buttonyear1994,buttonyear1990,buttonyear1986;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.history);
        buttonyear2018=(Button) findViewById(R.id.buttonHistiry2018);
        buttonyear2014=(Button) findViewById(R.id.buttonHistiry2014);
        buttonyear2010=(Button) findViewById(R.id.buttonHistiry2010);
        buttonyear2006=(Button) findViewById(R.id.buttonHistiry2006);
        buttonyear2002=(Button) findViewById(R.id.buttonHistiry2002);
        buttonyear1998=(Button) findViewById(R.id.buttonHistiry1998);
        buttonyear1994=(Button) findViewById(R.id.buttonHistiry1994);
        buttonyear1990=(Button) findViewById(R.id.buttonHistiry1990);
        buttonyear1986=(Button) findViewById(R.id.buttonHistiry1986);

        buttonyear2018.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"robi",Toast.LENGTH_LONG).show();
                Intent year2018 = new Intent(Historyactivity.this, offline_1.sdlab.com.fifaalarm.Allyear.year2018.class);
                startActivity(year2018);
            }
        });

        buttonyear2014.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"robi",Toast.LENGTH_LONG).show();
                Intent year2014 = new Intent(Historyactivity.this, offline_1.sdlab.com.fifaalarm.Allyear.year2014.class);
                startActivity(year2014);
            }
        });


        buttonyear2010.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"robi",Toast.LENGTH_LONG).show();
                Intent year2010 = new Intent(Historyactivity.this, offline_1.sdlab.com.fifaalarm.Allyear.year2010.class);
                startActivity(year2010);
            }
        });


        buttonyear2006.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"robi",Toast.LENGTH_LONG).show();
                Intent year2006 = new Intent(Historyactivity.this, offline_1.sdlab.com.fifaalarm.Allyear.year2006.class);
                startActivity(year2006);
            }
        });


        buttonyear2002.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"robi",Toast.LENGTH_LONG).show();
                Intent year2002 = new Intent(Historyactivity.this, offline_1.sdlab.com.fifaalarm.Allyear.year2002.class);
                startActivity(year2002);
            }
        });

        buttonyear1998.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"robi",Toast.LENGTH_LONG).show();
                Intent year1998 = new Intent(Historyactivity.this, offline_1.sdlab.com.fifaalarm.Allyear.year1998.class);
                startActivity(year1998);
            }
        });

        buttonyear1994.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"robi",Toast.LENGTH_LONG).show();
                Intent year1994 = new Intent(Historyactivity.this, offline_1.sdlab.com.fifaalarm.Allyear.year1994.class);
                startActivity(year1994);
            }
        });

        buttonyear1990.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"robi",Toast.LENGTH_LONG).show();
                Intent year1990 = new Intent(Historyactivity.this, offline_1.sdlab.com.fifaalarm.Allyear.year1990.class);
                startActivity(year1990);
            }
        });

    }
}
