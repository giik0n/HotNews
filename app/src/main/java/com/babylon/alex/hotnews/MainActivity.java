package com.babylon.alex.hotnews;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.babylon.alex.hotnews.Fragments.MyNewsFragment;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private TabsPageAdapter tabsPageAdapter;
    private ViewPager mViewPager;
    private  Toolbar toolbar;
    private Button burgerButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabsPageAdapter = new TabsPageAdapter(getSupportFragmentManager());
        mViewPager = findViewById(R.id.container);
        setViewPager(mViewPager);

        TabLayout tabLayout = findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        burgerButton = findViewById(R.id.burgerButton);
        burgerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SearchDialog dialog = new SearchDialog(MainActivity.this);
                dialog.show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return  true;
    }

    final public void setPage(int i){
        mViewPager.setCurrentItem(i);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            Toast.makeText(this, "Settings", Toast.LENGTH_SHORT).show();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void setViewPager(ViewPager viewPager){
        TabsPageAdapter adapter = new TabsPageAdapter(getSupportFragmentManager());
        adapter.addFragment(new MyNewsFragment(),"Top stories");
        adapter.addFragment(new MyNewsFragment(),"My News");
        adapter.addFragment(new MyNewsFragment(),"Popular");
        adapter.addFragment(new MyNewsFragment(),"Video");
        viewPager.setAdapter(adapter);
    }
}
