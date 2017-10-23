package com.example.server.linearlayout;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Context context = this;
    Button btnKlik;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnToast = (Button)findViewById(R.id.btnToast);
        btnToast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Ini Toast",
                        Toast.LENGTH_LONG).show();
            }
        });
        btnKlik = (Button) findViewById(R.id.btnKlikDisini);
        btnKlik.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder builder = new
                        AlertDialog.Builder(context);
                builder.setTitle("Ini judul");
                builder.setMessage("Ini pesan");
                builder.setNeutralButton("Close", new
                        DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface
                                                        dialog, int which) {
                            }
                        }).show();
            }
        });
    }}
