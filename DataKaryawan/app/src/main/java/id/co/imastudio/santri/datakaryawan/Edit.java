package id.co.imastudio.santri.datakaryawan;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Edit extends AppCompatActivity implements View.OnClickListener{

    private DBDataSource dataSource;

    private long id;
    private String jk;
    private String umur;
    private String nama;

    private EditText edNamaaa;
    private EditText edJka;
    private EditText edUma;

    private TextView txIda;

    private Button btnSave;
    private Button btnCancel;

    private Barang barang;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        //inisialisasi variabel
        edNamaaa = (EditText) findViewById(R.id.edtNama1);
        edJka = (EditText) findViewById(R.id.edtJk1);
        edUma = (EditText) findViewById(R.id.edtUmr1);
        txIda = (TextView) findViewById(R.id.textId);
        //buat sambungan baru ke database
        dataSource = new DBDataSource(this);
        dataSource.open();
        // ambil data barang dari extras
        Bundle bun = this.getIntent().getExtras();
        id = bun.getLong("id");
        nama = bun.getString("nama");
        jk = bun.getString("jk");
        umur = bun.getString("umur");
        //masukkan data-data barang tersebut ke field editor
        txIda.append(String.valueOf(id));
        edNamaaa.setText(nama);
        edJka.setText(jk);
        edUma.setText(umur);

        //set listener pada tombol
        btnSave = (Button) findViewById(R.id.btnSave);
        btnSave.setOnClickListener(this);
        btnCancel = (Button) findViewById(R.id.BtnCancel);
        btnCancel.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        // TODO Auto-generated method stub
        switch(v.getId())
        {
            // apabila tombol save diklik (update barang)
            case R.id.btnSave :
                barang = new Barang();
                barang.setNama(edNamaaa.getText().toString());
                barang.setJk(edJka.getText().toString());
                barang.setUmur(edUma.getText().toString());
                barang.setId(id);
                dataSource.updateBarang(barang);
                Intent i = new Intent(this, Lihat.class);
                startActivity(i);
                Edit.this.finish();
                dataSource.close();
                break;
            // apabila tombol cancel diklik, finish activity
            case R.id.BtnCancel :
                finish();
                dataSource.close();
                break;
        }
    }
}