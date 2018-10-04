package com.example.sina.assign6;

import android.app.LoaderManager;
import android.content.Intent;
import android.content.Loader;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class List extends AppCompatActivity implements LoaderManager.LoaderCallbacks<java.util.List<Earthquake>>{

    private static final int EARTHQUAKE_LOADER_ID = 1;
    ArrayList<Earthquake> earthquakes = new ArrayList<>();
    Adaprot mAdapter;
    ListView earthquakeListView;
    TextView mEmptyState;
    ProgressBar mProgressBar;

    public static final String LOG_TAG = MainActivity.class.getName();
//    private static final String USGS_REQUEST_URL =
//            "https://earthquake.usgs.gov/fdsnws/event/1/query?format=geojson&orderby=time&starttime=2018-03-01&minmagnitude=6&limit=20";
    String USGS_REQUEST_URL ="";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

//        Intent get = getIntent();
//
//        String number = get.getStringExtra("number");
//        String by = get.getStringExtra("by");
//        String date = get.getStringExtra("time");
//
//         USGS_REQUEST_URL =
//            "https://earthquake.usgs.gov/fdsnws/event/1/query?format=geojson&orderby="+by+"&starttime="+date+"&minmagnitude=7&limit="+number;


//        Toast.makeText(List.this, number + by + date,
//        Toast.LENGTH_LONG).show();

        ConnectivityManager manager = (ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = manager.getActiveNetworkInfo();

        if(networkInfo != null && networkInfo.isConnected()) {
            LoaderManager loaderManager  = getLoaderManager();
            loaderManager.initLoader(EARTHQUAKE_LOADER_ID, null, this);

        }

        earthquakeListView = (ListView) findViewById(R.id.MyList);

        earthquakeListView.setEmptyView(mEmptyState);

        mAdapter = new Adaprot(this, earthquakes);
        earthquakeListView.setAdapter(mAdapter);

        earthquakeListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//
//                        Toast.makeText(List.this, earthquakes.get(i).GETlatitude() + earthquakes.get(i).GETlongitude(),
//        Toast.LENGTH_LONG).show();
                //String url = earthquakes.get(i).getUrl();
                String URL = "https://www.openstreetmap.org/?mlat="+earthquakes.get(i).GETlatitude()+"&mlon="+earthquakes.get(i).GETlongitude()+"#map=5/"+
                        earthquakes.get(i).GETlatitude()+"/" + earthquakes.get(i).GETlongitude();

                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(URL));
                startActivity(intent);
            }
        });
        // Create a new {@link ArrayAdapter} of earthquakes

    }
    @Override
    public Loader<java.util.List<Earthquake>> onCreateLoader(int i, Bundle bundle) {
        Intent get = getIntent();

        String number = get.getStringExtra("number");
        String by = get.getStringExtra("by");
        String date = get.getStringExtra("time");

        USGS_REQUEST_URL =
                "https://earthquake.usgs.gov/fdsnws/event/1/query?format=geojson&orderby="+by+"&starttime="+date+"&minmagnitude=7&limit="+number;
        return new EarthquakeLoader(this, USGS_REQUEST_URL);
    }

    @Override
    public void onLoadFinished(Loader<java.util.List<Earthquake>> loader, java.util.List<Earthquake> earthquakes) {
        mAdapter.clear();
        if(earthquakes == null) {
            return;
        }
        mAdapter.addAll(earthquakes);

    }

    @Override
    public void onLoaderReset(Loader<java.util.List<Earthquake>> loader) {
        mAdapter.clear();
    }



}
