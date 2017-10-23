package id.co.imastudio.santri.belajarfragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentPertama extends Fragment {

    private Button buttonSatu;

    public FragmentPertama() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fragment_pertama, container, false);
        ((MainActivity) getActivity()).getSupportActionBar().setSubtitle("fragment  pertama");
        ((MainActivity) getActivity()).getSupportActionBar().setSubtitle("(fragment_pertama.xml)");
        ((MainActivity)getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        buttonSatu = (Button) view.findViewById(R.id.button1);


        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        buttonSatu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentKedua fragmentKedua = new FragmentKedua();
                getFragmentManager().beginTransaction().replace(R.id.frame_content, fragmentKedua)
                .addToBackStack(null)
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).commit();

            }
        });
    }
}
