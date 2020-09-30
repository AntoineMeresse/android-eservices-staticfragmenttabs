package android.eservices.staticfragmenttabs;

import android.content.res.Resources;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

public class MainActivity extends AppCompatActivity implements FragmentOne.fragmentOneInterface, FragmentTwo.fragmentTwoInterface {

    private ViewPager viewPager;
    private int currentCounter;
    private TextView counterTextView;

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
        ViewPager viewpager = (ViewPager) findViewById(R.id.tab_viewpager);
        //TODO we want two fragments with layouts : fragment_one, fragment_two.
        final FragmentOne fragmentOne = new FragmentOne();
        final FragmentTwo fragmentTwo = new FragmentTwo();

        //TODO set adapter to viewpager and handle fragment change inside
        viewpager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                Fragment fragment = null;
                switch (position) {
                    case 0:
                        fragment = fragmentOne;
                        break;
                    case 1:
                        fragment = fragmentTwo;
                        break;
                }
                return fragment;
            }

            @Override
            public int getCount() {
                return 2;
            }

            @Nullable
            @Override
            public CharSequence getPageTitle(int position) {
                if (position == 0) return fragmentOne.TAB_NAME;
                else return fragmentTwo.TAB_NAME;
            }
        });
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
