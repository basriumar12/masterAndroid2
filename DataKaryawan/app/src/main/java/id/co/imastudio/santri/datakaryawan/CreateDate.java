package id.co.imastudio.santri.datakaryawan;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Server on 01/08/2017.
 */

class CreateDate extends AppCompatActivity implements View.OnClickListener {
    private Button submitt;
    private EditText edtnama, edtjk, edtumur;
    private DBDataSource dataSource;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_data);


        edtnama= (EditText)findViewById(R.id.namak);
        edtjk= (EditText)findViewById(R.id.jkl);
        edtumur=(EditText) findViewById(R.id.umur);

        dataSource = new DBDataSource(this);
        dataSource.open();

        submitt = (Button) findViewById(R.id.submit);
        submitt.setOnClickListener(this);


    }

        //event tombol
    @Override
    public void onClick(View view) {
    String nama = null;
        String jk = null;
        String umur = null;
        @SuppressWarnings("unused")

        Barang barang = null;
        if (edtnama.getText()!= null && edtjk.getText()!= null && edtumur.getText()!= null)
        {
            nama = edtnama.getText().toString();
            jk = edtjk.getText().toString();
            umur= edtumur.getText().toString();

        }

        switch (view.getId()){
            case R.id.submit:
                //insert data barang baru
                barang = dataSource.createBarang(nama, jk, umur);
                //konfirmasi sukses
                Toast.makeText(this, " masukan barang "+" nama :" + barang.getNama()+
                " jk :" + barang.getJk()+
                "umur :" + barang.getUmur(), Toast.LENGTH_LONG).show();
                break;


        }
    }

}
