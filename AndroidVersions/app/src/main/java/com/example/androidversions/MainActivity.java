package com.example.androidversions;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rv = findViewById(R.id.recycler);
        int images[] = {R.drawable.alpha,R.drawable.beta,R.drawable.cupcake,R.drawable.donut,R.drawable.eclair,R.drawable.froyo,R.drawable.gingerbread,R.drawable.honeycomb,R.drawable.icecreamsandwich,R.drawable.jellybean,R.drawable.kitkat,R.drawable.lollipop,R.drawable.marshmallow,R.drawable.nougat,R.drawable.oreo,R.drawable.pie,R.drawable.q,R.drawable.r};
        String codename[] = {"Alpha","Beta","Cupcake","Donut","Eclair","Froyo","Gingerbread","Honeycomb","Ice Cream Sandwich","Jelly Bean","KitKat","Lollipop","Marshmallow","Nougat","Oreo","Pie","Q or Android 10","R"};
        String version[] = {"1.0","1.1","1.5","1.6","2.0 - 2.1","2.2 - 2.2.3","2.3 - 2.3.7","3.0 - 3.2.6","4.0 - 4.0.4","4.1 - 4.3.1","4.4 - 4.4.4","5.0 - 5.1.1","6.0 - 6.0.1","7.0 - 7.1.2","8.0 - 8.1","9.0","10.0","11.0"};
        String apilevels[] = {"1","2","3","4","5 - 7","8","9 - 10","11 - 13","14 - 15","16 - 18","19 - 20","21 - 22","23","24 - 25","26 - 27","28","29","30"};
        String releasedate[] = {"23,September,2008","9,February,2009","27,April,2009","15,September,2009","26,October,2009","20,May,2010","6,December,2010","22,February,2011","18,October,2011","9,July,2012","31,October,2013","12,November,2014","5,October,2015","22,August,2016","21,August,2017","6,August,2018","3,September,2019","Launching Soon"};

        rv.setLayoutManager(new LinearLayoutManager(this));

        Adap adapter = new Adap(this,images,codename,version,apilevels,releasedate);
        rv.setAdapter(adapter);


    }
}