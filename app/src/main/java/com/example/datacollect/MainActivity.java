package com.example.datacollect;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.logging.Handler;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private String[] countryNames;
    private int[] flags = {R.drawable.afganistan_icon, R.drawable.armenia_icon, R.drawable.azerbijan_icon,
    R.drawable.bahrain_icon, R.drawable.bangladesh_icon2, R.drawable.bhutan_icon,
    R.drawable.bolivia_icon, R.drawable.china_icon,R.drawable.croatia_icon,R.drawable.denmark_icon,
    R.drawable.finland_icon,R.drawable.greenland_icon,R.drawable.india_icon,R.drawable.pakistan_icon,
    R.drawable.nepal_icon,R.drawable.england_icon,R.drawable.malaysia_icon};
    private String[] countryDetails;
    private int[] countriImages = {R.drawable.afganistan, R.drawable.armenia, R.drawable.azerbijan,
            R.drawable.bahrain, R.drawable.bangladesh, R.drawable.bhutan,
            R.drawable.bolivia, R.drawable.china,R.drawable.croatia,R.drawable.denmark,
            R.drawable.finland,R.drawable.greenland,R.drawable.tajmahal,R.drawable.pakistan,
            R.drawable.nepal,R.drawable.england,R.drawable.malaysia};


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        countryNames = getResources().getStringArray(R.array.country_names);
        countryDetails = getResources().getStringArray(R.array.country_details);

        listView = (ListView) findViewById(R.id.listViewId);

        CustomAdapter adapter = new CustomAdapter(this,countryNames,flags,countryDetails);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getApplicationContext(),countryNames[i]+" is clicked",Toast.LENGTH_LONG).show();

                Intent intent = new Intent(MainActivity.this,MainActivity2.class);
                intent.putExtra("name",countryDetails[i]);
                intent.putExtra("images",countriImages[i]);
                startActivity(intent);
            }
        });


    }

}