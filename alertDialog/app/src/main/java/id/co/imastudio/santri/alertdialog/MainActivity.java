package id.co.imastudio.santri.alertdialog;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Context context = this;
    Button btnKlik, alert2, alert3;
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
        btnKlik = (Button)findViewById(R.id.btnKlikDisini);
        btnKlik.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//
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
        alert2 = (Button)findViewById(R.id.btnAlert2);
        alert2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alert2 = new
                        AlertDialog.Builder(context);
                alert2.setTitle("Warning");
                alert2.setMessage("are you sure?");
                alert2.setPositiveButton("Yes", new
                        DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int
                                    which) {
                            }
                        });
                alert2.setNegativeButton("No", new
                        DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int
                                    which) {
                            }
                        });
                alert2.show();
            }
        });
        alert3 = (Button)findViewById(R.id.btnAlert3);
        alert3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alert3 = new
                        AlertDialog.Builder(context);
                alert3.setTitle("Warning");
                alert3.setMessage("are u sure?");
                alert3.setPositiveButton("Yes", new
                        DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int
                                    which) {
                            }
                        });
                alert3.setNegativeButton("No", new
                        DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int
                                    which) {
                            }
                        });
                alert3.setNeutralButton("Cancel", new
                        DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int
                                    which) {
                            }
                        });
                alert3.show();
            }
        });
    }
}