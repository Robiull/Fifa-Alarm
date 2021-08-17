package offline_1.sdlab.com.fifaalarm;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import offline_1.sdlab.com.fifaalarm.AllGroups.GroupA;
import offline_1.sdlab.com.fifaalarm.AllGroups.GroupB;
import offline_1.sdlab.com.fifaalarm.AllGroups.GroupC;
import offline_1.sdlab.com.fifaalarm.AllGroups.GroupD;
import offline_1.sdlab.com.fifaalarm.AllGroups.GroupE;
import offline_1.sdlab.com.fifaalarm.AllGroups.GroupF;
import offline_1.sdlab.com.fifaalarm.AllGroups.GroupG;
import offline_1.sdlab.com.fifaalarm.AllGroups.GroupH;



public class groupActivity extends AppCompatActivity {

    Button groupa,groupb,groupc,groupd,groupe,groupf,groupg,grouph;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group);
        groupa=(Button) findViewById(R.id.buttonGroupA);
        groupb=(Button) findViewById(R.id.buttonGroupB);
        groupc=(Button) findViewById(R.id.buttonGroupC);
        groupd=(Button) findViewById(R.id.buttonGroupD);
        groupe=(Button) findViewById(R.id.buttonGroupE);
        groupf=(Button) findViewById(R.id.buttonGroupF);
        groupg=(Button) findViewById(R.id.buttonGroupG);
        grouph=(Button) findViewById(R.id.buttonGroupH);

        groupa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"robi",Toast.LENGTH_LONG).show();
                Intent GroupA = new Intent(groupActivity.this, GroupA.class);
                startActivity(GroupA);
            }
        });
        groupb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"robi",Toast.LENGTH_LONG).show();
                Intent GroupB = new Intent(groupActivity.this, GroupB.class);
                startActivity(GroupB);
            }
        });
        groupc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"robi",Toast.LENGTH_LONG).show();
                Intent GroupC = new Intent(groupActivity.this, GroupC.class);
                startActivity(GroupC);
            }
        });
        groupd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"robi",Toast.LENGTH_LONG).show();
                Intent GroupD = new Intent(groupActivity.this, GroupD.class);
                startActivity(GroupD);
            }
        });
        groupe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"robi",Toast.LENGTH_LONG).show();
                Intent GroupE = new Intent(groupActivity.this, GroupE.class);
                startActivity(GroupE);
            }
        });
        groupf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"robi",Toast.LENGTH_LONG).show();
                Intent GroupF = new Intent(groupActivity.this, GroupF.class);
                startActivity(GroupF);
            }
        });
        groupg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"robi",Toast.LENGTH_LONG).show();
                Intent GroupG = new Intent(groupActivity.this, GroupG.class);
                startActivity(GroupG);
            }
        });
        grouph.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"robi",Toast.LENGTH_LONG).show();
                Intent GroupH = new Intent(groupActivity.this, GroupH.class);
                startActivity(GroupH);
            }
        });

    }
}
