package com.example.livecovidcasesapp;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import javax.net.ssl.HttpsURLConnection;

public class MyThread extends AsyncTask<Void,Void,String>
{

    String url = "https://api.covid19api.com/country/India";
    Context c;
    ProgressDialog pd;
    RecyclerView mrv;


    public MyThread(MainActivity mainActivity, RecyclerView rv)
    {
        c = mainActivity;
        mrv = rv;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        pd = new ProgressDialog(c);
        pd.setMessage("Loading Please wait...");
        pd.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        pd.show();
    }

    @Override
    protected String doInBackground(Void... voids) {

        try{
            URL u = new URL(url);
            HttpsURLConnection connection = (HttpsURLConnection) u.openConnection();
            InputStream is = connection.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            String line = "";
            StringBuilder builder = new StringBuilder();
            while ((line=reader.readLine())!=null)
            {
                builder.append(line);
            }
            return builder.toString();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);

        pd.dismiss();
        List<Stats> statsList = new ArrayList<>();
        StringBuilder stringBuilder = new StringBuilder();
        try
        {
            JSONArray rootJsonArray = new JSONArray(s);
            for(int i=rootJsonArray.length()-1; i>=0; i--)
            {
                JSONObject indexObject = rootJsonArray.getJSONObject(i);
                String date = indexObject.getString("Date").substring(0,10);
                String active = indexObject.getString("Active");
                String recovery = indexObject.getString("Recovered");
                String deaths = indexObject.getString("Deaths");
                Stats st = new Stats(date,active,recovery,deaths);
                statsList.add(st);
            }
            mrv.setLayoutManager(new LinearLayoutManager(c));
            mrv.setAdapter(new StatsAdapter(c,statsList));
        }

        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
