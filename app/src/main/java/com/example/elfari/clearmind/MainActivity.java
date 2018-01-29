package com.example.elfari.clearmind;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.elfari.clearmind.Adapter.MySoundAdapter;
import com.example.elfari.clearmind.Models.MySound;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    private RecyclerView.Adapter mAdapter;
    private List<MySound> mySounds = new ArrayList<>();
    private MySound sound;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = (RecyclerView) findViewById(R.id.recycleview);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        sound = new MySound(R.raw.ocean_main, "Ocean", R.raw.ocean_seagulls, R.drawable.bg_beach, R.drawable.circle_ocean);
        mySounds.add(sound);

        sound = new MySound(R.raw.forest_main, "Forest", R.raw.forest_creek, R.drawable.bg_forest, R.drawable.circle_forest);
        mySounds.add(sound);

        sound = new MySound(R.raw.waterfall_main, "Waterfall", R.raw.waterfall_birds, R.drawable.bg_waterfall, R.drawable.circle_waterfall);
        mySounds.add(sound);

        sound = new MySound(R.raw.moutains_wind, "Mountain", R.raw.fire_wolf, R.drawable.bg_mountains, R.drawable.circle_mountains);
        mySounds.add(sound);

        sound = new MySound(R.raw.lake_main, "Lake", R.raw.lake_frogs, R.drawable.bg_lake, R.drawable.circle_lake);
        mySounds.add(sound);

        sound = new MySound(R.raw.rain_on_grass, "Rain On Grass", R.raw.wind_chimes, R.drawable.bg_grass, R.drawable.circle_grass);
        mySounds.add(sound);

        sound = new MySound(R.raw.perfect_rain_thunders, "Perfect Rain", R.raw.lake_frogs, R.drawable.bg_perfect_rain, R.drawable.circle_perfect_rain);
        mySounds.add(sound);

        sound = new MySound(R.raw.rain_on_window_main, "Rain  On Window", R.raw.lake_frogs, R.drawable.bg_rain_on_window, R.drawable.circle_rain_on_window);
        mySounds.add(sound);

        sound = new MySound(R.raw.thunderstorm_main, "Thunderstorm", R.raw.fire_owls, R.drawable.bg_thunderstorm, R.drawable.circle_thunderstorm);
        mySounds.add(sound);

        sound = new MySound(R.raw.night_main, "Calm Night", R.raw.fire_owls, R.drawable.bg_night, R.drawable.circle_night);
        mySounds.add(sound);

        sound = new MySound(R.raw.fire_main, "Camp Fire", R.raw.fire_owls, R.drawable.bg_camp_fire, R.drawable.circle_camp_fire);
        mySounds.add(sound);

        mAdapter = new MySoundAdapter(mySounds);
        mRecyclerView.setAdapter(mAdapter);

    }
}
