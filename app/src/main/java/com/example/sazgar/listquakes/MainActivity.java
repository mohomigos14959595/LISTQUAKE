package com.example.sazgar.listquakes;

import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {


    public static final String EVENT_URL = "https://earthquake.usgs.gov/fdsnws/event/1/query?format=geojson&starttime=2016-01-01&endtime=2016-05-02&minfelt=50&minmagnitude=5";
    public ProgressBar progress;
    private ListView listquakes;
//    private ListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

      //  Event event = NetworkUtils.fetchData("https://earthquake.usgs.gov/fdsnws/event/1/query?format=geojson&starttime=2016-01-01&endtime=2016-05-02&minfelt=50&minmagnitude=5");
        //   

        progress = (ProgressBar) findViewById(R.id.progressbar);
        listquakes = (ListView) findViewById(R.id.listviewquakes);

//        TextView tx_mag = (TextView) findViewById(R.id.textmag);
//        TextView tx_felt = (TextView) findViewById(R.id.textfelt);
         
        new EventAsyncTask().execute("https://earthquake.usgs.gov/fdsnws/event/1/query?format=geojson&starttime=2016-01-01&endtime=2016-05-02&minfelt=50&minmagnitude=5");

    }
//        visit.setOnClickListener(new View.OnClickListener() {
//
//            @Override
//
//            public void onClick(View view) {
//
//                openWebPage(eventvalue.getSiteURL());
//
//            }
//
//        });
//
//
//    }
//
//
//    public void openWebPage(String url) {
//
//        Uri webpage = Uri.parse(url);
//
//        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
//
//        if (intent.resolveActivity(getPackageManager()) != null) {
//
//            startActivity(intent);
//
//        }


    public class EventAsyncTask extends AsyncTask<String, Void, List<Event>> {
        @Override
        protected void onPreExecute() {
            progress.setVisibility(View.VISIBLE);
        }

        @Override
        protected List<Event> doInBackground(String... urls) {
            String url = urls[0];
            return NetworkUtils.fetchData(url);
        }


        @Override
        protected void onPostExecute(List<Event> events) {
            listquakes = (ListView) findViewById(R.id.listviewquakes);

            progress.setVisibility(View.INVISIBLE);
            ListAdapter adapter = new ListAdapter(MainActivity.this, events);
            listquakes.setAdapter(adapter);
        }

    }
}



