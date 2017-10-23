package id.co.imastudio.santri.datakaryawan;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button tmb, lht;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tmb = (Button) findViewById(R.id.tambah);
        lht = (Button) findViewById(R.id.lihatData);
        lht.setOnClickListener((View.OnClickListener) this);
        tmb.setOnClickListener((View.OnClickListener) this);


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.tambah:
                Intent i = new Intent(MainActivity.this, CreateDate.class);
                startActivity(i);
                break;
            case R.id.lihatData:
                Intent i2 = new Intent(MainActivity.this, Lihat.class);
                startActivity(i2);
                Toast.makeText(this,"Pindah ke",  Toast.LENGTH_LONG).show();
                break;
        }
    }
}