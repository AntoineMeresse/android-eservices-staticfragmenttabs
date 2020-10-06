package android.eservices.staticfragmenttabs;

import android.content.res.Resources;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class MainActivity extends AppCompatActivity implements FragmentOne.fragmentOneInterface, FragmentTwo.fragmentTwoInterface {

    private ViewPager2 viewpager;
    private int currentCounter;
    private TextView counterTextView;
    private TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.counterTextView = (TextView) findViewById(R.id.counter_textview);
        updateText();

        setupViewPagerAndTabs();
    }

    //TODO fill the method to get view references and initialize viewpager to display our fragments
    private void setupViewPagerAndTabs() {
        viewpager = findViewById(R.id.tab_viewpager);
        tabLayout = findViewById(R.id.tablayout);
        //TODO we want two fragments with layouts : fragment_one, fragment_two.
        final FragmentOne fragmentOne = FragmentOne.newInstance();
        final FragmentTwo fragmentTwo = FragmentTwo.newInstance();

        viewpager.setAdapter(new FragmentStateAdapter(this) {
            @NonNull
            @Override
            public Fragment createFragment(int position) {
                if (position == 0) return fragmentOne;
                else return fragmentTwo;
            }

            @Override
            public int getItemCount() {
                return 2;
            }


        });

        TabLayoutMediator tabLayoutMediator = new TabLayoutMediator(tabLayout, viewpager, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                if (position == 0) tab.setText(FragmentOne.TAB_NAME);
                else tab.setText(FragmentTwo.TAB_NAME);
            }
        });
        tabLayoutMediator.attach();

    }

    public void updateText(){
        Resources res = getResources();
        String text = String.format(res.getString(R.string.counter_text), this.currentCounter);
        this.counterTextView.setText(text);
    }

    //TODO : increment and decrement counter, use the already provided String ressource (see strings.xml)
    @Override
    public void add() {
        this.currentCounter+=1;
        System.out.println(this.currentCounter);
        updateText();
    }

    @Override
    public void sub() {
        this.currentCounter-=1;
        System.out.println(this.currentCounter);
        updateText();
    }
}
