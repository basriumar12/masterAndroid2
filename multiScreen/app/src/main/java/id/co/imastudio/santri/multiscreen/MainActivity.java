package id.co.imastudio.santri.multiscreen;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    //deklarasi varibel button
    Button btn2;
    Button btn3;
    Button btn4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //inisialiasi id dari button
     btn2 = (Button) findViewById(R.id.btnHal2);
        btn2.setOnClickListener(new View.OnClickListener(){

            @Override
            //metho onlcki dari button
            public void onClick(View view) {
                Intent i = null;
                //fungsi dari intent
                i = new Intent(getApplicationContext(),activityHalaman1.class);
                //mulai aktiv intent
                startActivity(i);
            }
        });

        btn3 = (Button) findViewById(R.id.btn3);
        btn3.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent i = null;
                i = new Intent(getApplicationContext(),activityHalaman1.class);
                startActivity(i);
            }
        });

        btn4 = (Button) findViewById(R.id.btn4);
        btn4.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent i = null;
                i = new Intent(getApplicationContext(),activityHalaman1.class);
                startActivity(i);
            }
        });


    }

}
