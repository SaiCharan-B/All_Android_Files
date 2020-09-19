package com.example.livecovidcasesretrofit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class MainActivity extends AppCompatActivity {

    RecyclerView rv;
    Retrofit retrofit;
    ProgressDialog pd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pd = new ProgressDialog(this);
        pd.setMessage("Loading please wait...");
        pd.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        rv = findViewById(R.id.recycler);

        retrofit = new Retrofit.Builder().baseUrl("https://api.covid19api.com/").addConverterFactory(ScalarsConverterFactory.create()).build();
        CovidService service = retrofit.create(CovidService.class);
        Call<String> response = service.getStats();
        response.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                pd.dismiss();
                List<Stats> statsList = new ArrayList<>();
                StringBuilder stringBuilder = new StringBuilder();
                try {
                    JSONArray rootJsonArray = new JSONArray(response.body());
                    for(int i=rootJsonArray.length()-1;i>=0;i--)
                    {
                        JSONObject indexObj = rootJsonArray.getJSONObject(i);
                        String date = "Date:  "+indexObj.getString("Date").substring(0,10);
                        String active = indexObj.getString("Active");
                        String recovery = indexObj.getString("Recovered");
                        String deaths = indexObj.getString("Deaths");
                        Stats st = new Stats(date,active,recovery,deaths);
                        statsList.add(st);
                    }
                    rv.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                    rv.setAdapter(new StatsAdapter(MainActivity.this,statsList));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {

            }
        });

    }
}