package android.eservices.staticfragmenttabs;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

//TODO : fix this fragment so it works :)
//Once it's done, then create a second fragment with the other layout
public class FragmentTwo extends Fragment {

    public static final String TAB_NAME = "SUBSTRACT TO COUNTER";
    private FragmentTwo.fragmentTwoInterface listener;

    public FragmentTwo() {
        //TODO
    }

    public static FragmentTwo newInstance() {
        FragmentTwo fragmentOne = new FragmentTwo();
        /* Si on a des arguments
        Bundle args = new Bundle();
        fragmentOne.setArguments(args);
        */
        return fragmentOne;
    }

    public interface fragmentTwoInterface{
        public void sub();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //TODO
        View view = inflater.inflate(R.layout.fragment_two, container, false);
        final Button b = (Button) view.findViewById(R.id.button_decrement);
        b.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                listener.sub();
            }
        });
        return view;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    //TODO add listener to button and transmit the information to parent Activity
    //TODO read the Android doc, as suggested, to do it the right way

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof FragmentTwo.fragmentTwoInterface) {
            listener = (FragmentTwo.fragmentTwoInterface) context;
        }
        else {
            throw new RuntimeException();
        }
    }
}
