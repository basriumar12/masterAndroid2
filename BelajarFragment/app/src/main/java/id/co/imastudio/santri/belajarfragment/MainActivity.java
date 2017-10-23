package id.co.imastudio.santri.belajarfragment;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        //
        FragmentPertama fragmentPertama = new FragmentPertama();
        transaction.add(R.id.frame_content, fragmentPertama);
        transaction.addToBackStack("fragmentPertama");
        transaction.commit();

    }

}
