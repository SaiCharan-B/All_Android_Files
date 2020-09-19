package com.example.retrofitexample;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    RecyclerView rv;
    Retrofit retrofit;
    ProgressDialog pd;
    EditText et;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pd = new ProgressDialog(this);
        pd.setMessage("Loading Please wait...");
        pd.setProgressStyle(ProgressDialog.STYLE_SPINNER);

        rv = findViewById(R.id.recycler);
        et = findViewById(R.id.uname);

    }

    public void getresponse(View view)
    {
        pd.show();
        String input = et.getText().toString();

        Gson gson = new GsonBuilder().setLenient().create();
       retrofit = new Retrofit.Builder().baseUrl("https://api.github.com/").addConverterFactory(GsonConverterFactory.create(gson)).build();
       GitHubService service = retrofit.create(GitHubService.class);
        Call<List<Repo>> response = service.getRepos(input);
        response.enqueue(new Callback<List<Repo>>() {
            @Override
            public void onResponse(Call<List<Repo>> call, Response<List<Repo>> response) {
                List<Repo> list = response.body();
                StringBuilder builder = new StringBuilder();
                for(int i=0;i<list.size();i++)
                {
                    //builder.append(list.get(i).getName()+"\n"+list.get(i).getFullname()+"\n\n");
                    Repo rp = new Repo(list.get(i).getName(),list.get(i).getFullname());
                    list.add(rp);

                }
                rv.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                rv.setAdapter(new GitAdapter(MainActivity.this,list));
                //tv.setText(builder.toString());
            }

            @Override
            public void onFailure(Call<List<Repo>> call, Throwable t) {

            }
        });
    }
}