package id.co.imastudio.santri.belajarfragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;



public class FragmentKeempat extends Fragment {



    private Button buttonSatu;
    public FragmentKeempat() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_keempat, container, false);
        ((MainActivity) getActivity()).getSupportActionBar().setTitle("Fragment Keempat");
        ((MainActivity) getActivity()).getSupportActionBar().setSubtitle("(fragment_keempat.xml)");
        ((MainActivity)getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        buttonSatu = (Button) view.findViewById(R.id.button1);
        setHasOptionsMenu(true);

        // Inflate the layout for this fragment
        return view;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId()== android.R.id.home) {
            getFragmentManager().popBackStack();
        }
        return super.onOptionsItemSelected(item);
    }
}

