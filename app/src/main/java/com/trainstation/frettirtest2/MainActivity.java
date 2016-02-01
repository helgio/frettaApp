package com.trainstation.frettirtest2;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.trainstation.frettirtest2.responses.NewsResponse;
import com.trainstation.frettirtest2.service.NewsService;

import retrofit.RestAdapter;
import rx.Observable;

public class MainActivity extends AppCompatActivity {

    private ViewPager pager;
    private ViewPageAdapter adapter;
    private DrawerLayout mDrawerLayout;
    private ListView mDrawerList;
    private String[] mPlanetTitles;

    private NewsService newsService;

    public Observable<NewsResponse> getNewsResponse()
    {
        RestAdapter restAdapter = new RestAdapter.Builder().setEndpoint("https://itunes.apple.com").build();

        newsService = restAdapter.create(NewsService.class);
        return newsService.getNewsData("beyonce", "musicVideo");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pager = (ViewPager) findViewById(R.id.pager);
        adapter = new ViewPageAdapter(getSupportFragmentManager());

        pager.setAdapter(adapter);

        pager.addOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {

            @Override
            public void onPageSelected(int position) {
                changeToolbarTitle(position);
            }

        });
    }

    public void changeToolbarTitle (int position){
        switch (position)
        {
            case 0:
                setActionBarTitle("NEWS#");
                return;
            case 1:
            default:
                setActionBarTitle("Sport newS");
                return;
        }
    }

    public void setActionBarTitle(String title) {
        getSupportActionBar().setTitle(title);
    }
}