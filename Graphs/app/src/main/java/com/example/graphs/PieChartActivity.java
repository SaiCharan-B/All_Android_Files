package com.example.graphs;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class PieChartActivity extends AppCompatActivity {

    PieChart pieChart;
    ArrayList<PieEntry> pieEntries;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pie_chart);
        pieChart = findViewById(R.id.piechart);

        pieEntries = new ArrayList<>();
        pieEntries.add(new PieEntry(300,"2015"));
        pieEntries.add(new PieEntry(300,"2016"));
        pieEntries.add(new PieEntry(300,"2017"));
        pieEntries.add(new PieEntry(300,"2018"));
        pieEntries.add(new PieEntry(300,"2019"));

        PieDataSet dataset = new PieDataSet(pieEntries,"Students");
        dataset.setColors(ColorTemplate.JOYFUL_COLORS);
        dataset.setValueTextColor(Color.WHITE);
        dataset.setValueTextSize(16f);

        PieData pieData = new PieData(dataset);
        pieChart.setData(pieData);
        pieChart.setCenterText("Students");
        pieChart.getDescription().setEnabled(false);
        pieChart.animate();
    }
}