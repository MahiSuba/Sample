package com.example.mahendranm.sampletrue.Activity;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.mahendranm.sampletrue.Adapter.HomeMenuAdapter;
import com.example.mahendranm.sampletrue.AsyncCall.AsyncService;
import com.example.mahendranm.sampletrue.BO.Data;
import com.example.mahendranm.sampletrue.BO.NCustLiab;
import com.example.mahendranm.sampletrue.BO.NRevenue;
import com.example.mahendranm.sampletrue.BO.NTPV;
import com.example.mahendranm.sampletrue.BO.NTakeRate;
import com.example.mahendranm.sampletrue.BO.NegativeBal;
import com.example.mahendranm.sampletrue.BO.WatchBO;
import com.example.mahendranm.sampletrue.R;
import com.google.gson.Gson;
import com.highsoft.highcharts.Common.HIChartsClasses.HIChart;
import com.highsoft.highcharts.Common.HIChartsClasses.HIColumn;
import com.highsoft.highcharts.Common.HIChartsClasses.HICredits;
import com.highsoft.highcharts.Common.HIChartsClasses.HIDataLabels;
import com.highsoft.highcharts.Common.HIChartsClasses.HIEvents;
import com.highsoft.highcharts.Common.HIChartsClasses.HIExporting;
import com.highsoft.highcharts.Common.HIChartsClasses.HIItemStyle;
import com.highsoft.highcharts.Common.HIChartsClasses.HILabels;
import com.highsoft.highcharts.Common.HIChartsClasses.HILegend;
import com.highsoft.highcharts.Common.HIChartsClasses.HILine;
import com.highsoft.highcharts.Common.HIChartsClasses.HIMarker;
import com.highsoft.highcharts.Common.HIChartsClasses.HIOptions;
import com.highsoft.highcharts.Common.HIChartsClasses.HIPlotLines;
import com.highsoft.highcharts.Common.HIChartsClasses.HIPlotOptions;
import com.highsoft.highcharts.Common.HIChartsClasses.HIPoint;
import com.highsoft.highcharts.Common.HIChartsClasses.HISeries;
import com.highsoft.highcharts.Common.HIChartsClasses.HIStyle;
import com.highsoft.highcharts.Common.HIChartsClasses.HITitle;
import com.highsoft.highcharts.Common.HIChartsClasses.HITooltip;
import com.highsoft.highcharts.Common.HIChartsClasses.HIXAxis;
import com.highsoft.highcharts.Common.HIChartsClasses.HIYAxis;
import com.highsoft.highcharts.Common.HIColor;
import com.highsoft.highcharts.Core.HIChartView;
import com.highsoft.highcharts.Core.HIFunction;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, BottomNavigationView.OnNavigationItemSelectedListener  {

    android.support.v7.widget.Toolbar toolbar;
    DrawerLayout drawerLayout1;
    BottomNavigationView bottomNavigationView;

    LinearLayout linearLayout1,  linearLayout3, linearLayout4, linearLayout5, linearLayout6;
    HIOptions millionOption;
    HIChartView metricsChartView;
    Number[] series1_data1, series1_data2, series1_data3, series1_data4;

    WatchBO watchBO;
    AsyncService asyncService;

    //menu List
    ArrayList<String> _menuList = new ArrayList<>();
    RecyclerView recyclerView;
    HomeMenuAdapter homeMenuAdapter;

    AppCompatTextView txt_Day7, txt_Day14, txt_Day21;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = findViewById(R.id.ToolTip);
        setSupportActionBar(toolbar);

        txt_Day7 = findViewById(R.id.Day7);
        txt_Day7.setOnClickListener(this);
        txt_Day14 = findViewById(R.id.Day14);
        txt_Day14.setOnClickListener(this);
        txt_Day21 = findViewById(R.id.Day21);
        txt_Day21.setOnClickListener(this);

        txt_Day7.setBackgroundResource(R.color.buttonColor);
        txt_Day7.setTextColor(getResources().getColor(R.color.lineOrange));
        txt_Day14.setTextColor(getResources().getColor(R.color.buttonColor));
        txt_Day14.setBackgroundResource(R.color.colorPrimaryDark);
        txt_Day21.setTextColor(getResources().getColor(R.color.lineOrange));
        txt_Day21.setBackgroundResource(R.color.buttonColor);

        linearLayout1 = findViewById(R.id.Nav_Menu1);
        linearLayout3 = findViewById(R.id.homeMenu2);
        linearLayout4 = findViewById(R.id.homeMenu3);
        linearLayout5 = findViewById(R.id.homeMenu4);
        linearLayout6 = findViewById(R.id.homeMenu5);

        drawerLayout1 = findViewById(R.id.NavigationDrawer1);

        bottomNavigationView = findViewById(R.id.bottomnavigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        // for drawer open
        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout1, toolbar, R.string.nav_open, R.string.nav_close);
        actionBarDrawerToggle.setDrawerIndicatorEnabled(false);
        actionBarDrawerToggle.setDrawerSlideAnimationEnabled(true);
        drawerLayout1.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();




        metricsChartView = (HIChartView) findViewById(R.id.hc);
        millionOption = new HIOptions();

        HIChart millionChart = new HIChart();
        millionChart.setType("line");
        millionChart.getAnimation();
        millionChart.setMargin(new ArrayList<>(Arrays.asList(30, 0, 50, 0)));

        HITooltip millionTooltip = new HITooltip();
        millionTooltip.setEnabled(false);
        millionOption.setTooltip(millionTooltip);
        millionOption.setChart(millionChart);

        HIExporting Exporting = new HIExporting();
        Exporting.setEnabled(false);
        millionOption.setExporting(Exporting);

        HICredits Credits = new HICredits();
        Credits.setEnabled(false);
        millionOption.setCredits(Credits);

        HIStyle ChartTitleStyle = new HIStyle();
        ChartTitleStyle.setColor("navy");
        ChartTitleStyle.setFontSize("12px");
        ChartTitleStyle.setFontFamily("Arial");
        ChartTitleStyle.setFontWeight("bold");

        HITitle millionChartTitle = new HITitle();
        millionChartTitle.setText("$ nTPV (million)");
        millionChartTitle.setStyle(ChartTitleStyle);
        millionOption.setTitle(millionChartTitle);


        String categories[] = new String[0];
        categories = new String[]{"Wed, 0", "Thu, 1", "Fri, 2", "Sat, 3", "Sun, 4", "Mon, 5", "Tue, 6", "Wed, 7", "Thu, 8"};

        HIMarker lineMarker = new HIMarker();
        lineMarker.setEnabled(false);

        final HIPlotLines plotlines = new HIPlotLines();
        plotlines.setDashStyle("ShortDash");
        plotlines.setWidth(1);
        plotlines.setValue(0);
        plotlines.setColor(HIColor.initWithHexValue("c5c8cc"));

        final HIXAxis chartXaxis = new HIXAxis();
        chartXaxis.setLabels(new HILabels());
        chartXaxis.setTickmarkPlacement("on");
        HIStyle xaxisStyle = new HIStyle();
        xaxisStyle.setFontSize("9px");
        xaxisStyle.setFontFamily("Arial");
        xaxisStyle.setColor("black");
        xaxisStyle.setFontWeight("bold");
        chartXaxis.getLabels().setStyle(xaxisStyle);
        chartXaxis.getLabels().setY(3);
        chartXaxis.getLabels().setStep(2);
        chartXaxis.getLabels().setRotation(270);
//        chartXaxis.setMin(0.5);

        chartXaxis.setCategories(new ArrayList<>(Arrays.asList(categories)));
        millionOption.setXAxis(new ArrayList<HIXAxis>() {{
            add(chartXaxis);
        }});

        final HIYAxis chartYaxis = new HIYAxis();
        chartYaxis.setLineWidth(1);
        chartYaxis.setGridLineWidth(1);
        chartYaxis.setLabels(new HILabels());
        chartYaxis.setMin(0);
        HIStyle yaxisStyle = new HIStyle();
        yaxisStyle.setFontFamily("Arial");
        yaxisStyle.setFontSize("0px");
        chartYaxis.getLabels().setStyle(yaxisStyle);
        chartYaxis.getLabels().setX(-4);
        chartYaxis.setTitle(new HITitle());
        chartYaxis.getTitle().setText("");
        chartYaxis.setGridLineDashStyle("dash");
        chartYaxis.setGridLineWidth(0.5);
        chartYaxis.setLineWidth(0);

        millionOption.setYAxis(new ArrayList<HIYAxis>() {{
            add(chartYaxis);
        }});

        HIStyle dataLableStyle = new HIStyle();
        dataLableStyle.setFontSize("10px");

        HIDataLabels dataLabels = new HIDataLabels();
        dataLabels.setEnabled(true);
        dataLabels.setCrop(false);
        dataLabels.setOverflow(false);
        dataLabels.setStyle(dataLableStyle);

// For chart legend style //

        HIItemStyle itemStyle = new HIItemStyle();
        itemStyle.setFontWeight("1");
        itemStyle.setFontSize("10px");

        HILegend legend = new HILegend();
        legend.setAlign("right");
        legend.setItemDistance(5);
        legend.setPadding(0);
        legend.setItemMarginBottom(-9);
        legend.setItemStyle(itemStyle);

        HILine millionChart_line1 = new HILine();
        millionChart_line1.setName("Current");
        millionChart_line1.setShowInLegend(true);
        millionChart_line1.setLegendIndex(1);

        millionChart_line1.setDataLabels(dataLabels);
        millionChart_line1.setColor(HIColor.initWithRGBA(0, 126, 0, 1));
        millionChart_line1.getDataLabels().setY(-30);
        millionChart_line1.setLineWidth(0.5);

        millionChart_line1.getDataLabels().setColor(HIColor.initWithRGBA(0, 46, 140, 1));
        millionChart_line1.getDataLabels().setRotation(270);
        series1_data1 = new Number[]{43934, 52503, 57177, 69658, 77031, 89931, 97133, 43934};
        millionChart_line1.setData(new ArrayList<>(Arrays.asList(series1_data1)));

        millionChart_line1.setPoint(new HIPoint());
        millionChart_line1.getPoint().setEvents(new HIEvents());
        millionChart_line1.getPoint().getEvents().setClick(new HIFunction(
                f -> {
                    double xVal = (double) f.getProperty("x");
                    int indx = (int) xVal;
                    double rem = xVal - indx;
                    if (rem > 0.5) {
                        indx += 1;
                    }
//                    Log.d("String", " + f.getProperty("x") + ");
                    getIndexOfChartSelcetion(indx);
                },
                new String[]{"x"}
        ));

        HILine millionChart_line2 = new HILine();
        millionChart_line2.setName("7dma");
        millionChart_line2.setMarker(lineMarker);
        millionChart_line2.setLineWidth(1);
        millionChart_line2.setColor(HIColor.initWithRGBA(225, 89, 0, 1));
        series1_data2 = new Number[]{34916, 24064, 39742, 49851, 32490, 20282, 58121, 74340};
        millionChart_line2.setData(new ArrayList<>(Arrays.asList(series1_data2)));
        millionChart_line2.setLegendIndex(2);
        millionChart_line2.setPoint(new HIPoint());
        millionChart_line2.getPoint().setEvents(new HIEvents());
        millionChart_line2.getPoint().getEvents().setClick(new HIFunction(
                f -> {
                    double xVal = (double) f.getProperty("x");
                    int indx = (int) xVal;
                    double rem = xVal - indx;
                    if (rem > 0.5) {
                        indx += 1;
                    }
//                    Log.d("String", " + f.getProperty("x") + ");
                    getIndexOfChartSelcetion(indx);
                },
                new String[]{"x"}
        ));

        HIColumn millionChart_series1 = new HIColumn();
        millionChart_series1.setName("Domestic");
        millionChart_series1.setColor(HIColor.initWithRGBA(0, 157, 228, 1));
        series1_data3 = new Number[]{11744, 17722, 16005, 19771, 20185, 24377, 32147, 39387};
        millionChart_series1.setData(new ArrayList<>(Arrays.asList(series1_data1)));
        millionChart_series1.setLegendIndex(3);
        millionChart_series1.setPointWidth(15);
        millionChart_series1.setGrouping(false);
        millionChart_series1.setPoint(new HIPoint());
        millionChart_series1.getPoint().setEvents(new HIEvents());
        millionChart_series1.getPoint().getEvents().setClick(new HIFunction(
                f -> {
                    double xVal = (double) f.getProperty("x");
                    int indx = (int) xVal;
                    double rem = xVal - indx;
                    if (rem > 0.5) {
                        indx += 1;
                    }
//                    Log.d("String", " + f.getProperty("x") + ");
                    getIndexOfChartSelcetion(indx);
                },
                new String[]{"x"}
        ));

        HIColumn millionChart_series2 = new HIColumn();
        millionChart_series2.setName("xBorder");
        series1_data4 = new Number[]{1744, 7722, 6005, 9771, 1185, 4377, 2147, 9387};
        millionChart_series2.setColor(HIColor.initWithRGBA(204, 204, 204, 1));
        millionChart_series2.setLegendIndex(4);
        millionChart_series2.setData(new ArrayList<>(Arrays.asList(series1_data4)));
        millionChart_series2.setGrouping(false);
        millionChart_series2.setPointWidth(15);
        millionChart_series2.setPoint(new HIPoint());
        millionChart_series2.getPoint().setEvents(new HIEvents());
        millionChart_series2.getPoint().getEvents().setClick(new HIFunction(
                f -> {
                    double xVal = (double) f.getProperty("x");
                    int indx = (int) xVal;
                    double rem = xVal - indx;
                    if (rem > 0.5) {
                        indx += 1;
                    }
//                    Log.d("String", " + f.getProperty("x") + ");
                    getIndexOfChartSelcetion(indx);
                },
                new String[]{"x"}
        ));


        HIPlotOptions plotOptions = new HIPlotOptions();
        HISeries series = new HISeries();
        plotOptions.setSeries(series);

        millionOption.setSeries(new ArrayList<HISeries>(Arrays.asList(millionChart_series1, millionChart_series2, millionChart_line1, millionChart_line2)));
        millionOption.setLegend(legend);

        millionOption.setXAxis(new ArrayList<HIXAxis>(Arrays.asList(chartXaxis)));
        ArrayList<HIXAxis> x_axis = millionOption.getXAxis();
        x_axis.get(0).setPlotLines(new ArrayList(Arrays.asList(plotlines)));

        metricsChartView.setOptions(millionOption);


        try {

            asyncService = (AsyncService) new AsyncService(this, MainActivity.this).execute();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }


    public void getIndexOfChartSelcetion(int s) {

        Number indexOfFlower1 = Arrays.asList(series1_data1).get(s);
        Number indexOfFlower2 = Arrays.asList(series1_data2).get(s);
        Number indexOfFlower3 = Arrays.asList(series1_data3).get(s);
        Number indexOfFlower4 = Arrays.asList(series1_data4).get(s);

    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        int id = menuItem.getItemId();

        switch (id) {
            case R.id.home1:
                linearLayout3.setVisibility(View.VISIBLE);
                linearLayout4.setVisibility(View.GONE);
                linearLayout5.setVisibility(View.GONE);
                linearLayout6.setVisibility(View.GONE);

                if (drawerLayout1.isDrawerOpen(GravityCompat.START)) {
                    drawerLayout1.closeDrawer(GravityCompat.START);
                } else {
                    drawerLayout1.openDrawer(GravityCompat.START);
                    recyclerView = findViewById(R.id.ExpandList);
                    homeMenuAdapter = new HomeMenuAdapter(this, _menuList);
                    RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
                    recyclerView.setLayoutManager(layoutManager);
                    recyclerView.setAdapter(homeMenuAdapter);
                }
                break;
            case R.id.home2:

                linearLayout3.setVisibility(View.GONE);
                linearLayout4.setVisibility(View.VISIBLE);
                linearLayout5.setVisibility(View.GONE);
                linearLayout6.setVisibility(View.GONE);
                if (drawerLayout1.isDrawerOpen(GravityCompat.START)) {
                    drawerLayout1.closeDrawer(GravityCompat.START);
                } else {
                    drawerLayout1.openDrawer(GravityCompat.START);
                }

                break;
            case R.id.home3:
                linearLayout3.setVisibility(View.GONE);
                linearLayout4.setVisibility(View.GONE);
                linearLayout5.setVisibility(View.VISIBLE);
                linearLayout6.setVisibility(View.GONE);
                if (drawerLayout1.isDrawerOpen(GravityCompat.START)) {
                    drawerLayout1.closeDrawer(GravityCompat.START);
                } else {
                    drawerLayout1.openDrawer(GravityCompat.START);
                }

                break;
            case R.id.home4:
                linearLayout3.setVisibility(View.GONE);
                linearLayout4.setVisibility(View.GONE);
                linearLayout5.setVisibility(View.GONE);
                linearLayout6.setVisibility(View.VISIBLE);
                if (drawerLayout1.isDrawerOpen(Gravity.START)) {
                    drawerLayout1.closeDrawer(Gravity.START);
                } else {
                    drawerLayout1.openDrawer(Gravity.START);
                }

                break;
        }

        return true;
    }


    public void sendResponse(String s) {
        try {
            JSONObject jsonObject = new JSONObject(s);

            // here need to convert jsonobject to normal string object
            //convert json object to Gson object
            String result = jsonObject.toString();
            Gson gson = new Gson();
            watchBO = gson.fromJson(result, WatchBO.class);


            // Watch Bo values is been null
            // so we customize the json response to our BO class
            JSONObject jsonObject1 = (JSONObject) jsonObject.get("data");
            JSONObject jsonObject2 = (JSONObject) jsonObject1.get("nTakeRate");
            JSONObject jsonObject3 = (JSONObject) jsonObject1.get("nTPV");
            JSONObject jsonObject4 = (JSONObject) jsonObject1.get("nCustLiab");
            JSONObject jsonObject5 = (JSONObject) jsonObject1.get("nRevenue");
            JSONObject jsonObject6 = (JSONObject) jsonObject1.get("NegativeBal");

            _menuList.add("nTakeRate");
            _menuList.add("nTPV");
            _menuList.add("nCustLiab");
            _menuList.add("nRevenue");
            _menuList.add("NegativeBal");


// ntakeRate
            NTakeRate nTakeRate = new NTakeRate();

            ArrayList<ArrayList<String>> labels21 = new ArrayList<>();
            ArrayList<ArrayList<String>> scores21 = new ArrayList<>();

            JSONArray jsonArray = jsonObject2.getJSONArray("labels");
            JSONArray jsonArray1 = jsonObject2.getJSONArray("scores");
            String name = String.valueOf(((JSONObject) jsonObject1.get("nTakeRate")).get("name"));
            String uom = String.valueOf(((JSONObject) jsonObject1.get("nTakeRate")).get("uom"));
            int i = 0;
            while (i < jsonArray.length()) {
                ArrayList<String> labels = new ArrayList<>();
                ArrayList<String> labels1 = new ArrayList<>();
                String sb = jsonArray.get(i).toString();
                String sb1 = sb.replace("\",\"", "&");
                String sb2 = sb1.replace("[\"", "");
                String sb3 = sb2.replace("\"]", "");
                String[] splits = sb3.split("&");
                int k = 0;
                while (k < splits.length) {
                    labels1.add(splits[k]);
                    k++;
                }

                labels.addAll(labels1);
                labels21.add(labels);
                i++;
            }


            int j = 0;
            while (j < jsonArray1.length()) {
                ArrayList<String> scores = new ArrayList<>();
                ArrayList<String> scores1 = new ArrayList<>();
                String sb = jsonArray1.get(j).toString();
                String sb1 = sb.replace("\"[\"", "");
                String sb2 = sb1.replace("[\"", "");
                String sb3 = sb2.replace("\",", "&");
                String sb4 = sb3.replace("]", "");
                String sb5 = sb4.replace(",", "&");
                String[] splits = sb5.split("&");
                int k = 0;
                while (k < splits.length) {
                    scores1.add(splits[k]);
                    k++;
                }

                scores.addAll(scores1);
                scores21.add(scores);
                j++;
            }

            nTakeRate.setLabels(labels21);
            nTakeRate.setName(name);
            nTakeRate.setUom(uom);
            nTakeRate.setScores(scores21);

// Ntpv
            NTPV ntpv = new NTPV();
            ArrayList<ArrayList<String>> ntpvlabels21 = new ArrayList<>();
            ArrayList<ArrayList<String>> ntpvscores21 = new ArrayList<>();

            JSONArray jsonArray2 = jsonObject3.getJSONArray("labels");
            JSONArray jsonArray3 = jsonObject3.getJSONArray("scores");
            String name1 = String.valueOf(((JSONObject) jsonObject1.get("nTPV")).get("name"));
            String uom1 = String.valueOf(((JSONObject) jsonObject1.get("nTPV")).get("uom"));
            int l = 0;
            while (l < jsonArray2.length()) {
                ArrayList<String> ntpvlabels = new ArrayList<>();
                ArrayList<String> ntpvlabels1 = new ArrayList<>();
                String sb = jsonArray2.get(l).toString();
                String sb1 = sb.replace("\",\"", "&");
                String sb2 = sb1.replace("[\"", "");
                String sb3 = sb2.replace("\"]", "");
                String[] splits = sb3.split("&");
                int k = 0;
                while (k < splits.length) {
                    ntpvlabels1.add(splits[k]);
                    k++;
                }

                ntpvlabels.addAll(ntpvlabels1);
                ntpvlabels21.add(ntpvlabels);
                l++;
            }


            int m = 0;
            while (m < jsonArray3.length()) {
                ArrayList<String> ntpvscores = new ArrayList<>();
                ArrayList<String> ntpvscores1 = new ArrayList<>();
                String sb = jsonArray3.get(m).toString();
                String sb1 = sb.replace("\"[\"", "");
                String sb2 = sb1.replace("[\"", "");
                String sb3 = sb2.replace("\",", "&");
                String sb4 = sb3.replace("]", "");
                String sb5 = sb4.replace(",", "&");
                String[] splits = sb5.split("&");
                int k = 0;
                while (k < splits.length) {
                    ntpvscores1.add(splits[k]);
                    k++;
                }
                ntpvscores.addAll(ntpvscores1);
                ntpvscores21.add(ntpvscores);
                m++;
            }

            ntpv.setLabels(ntpvlabels21);
            ntpv.setName(name1);
            ntpv.setUom(uom1);
            ntpv.setScores(ntpvscores21);

// NRevenue
            NRevenue nRevenue = new NRevenue();

            ArrayList<ArrayList<String>> nRevenuelabels21 = new ArrayList<>();
            ArrayList<ArrayList<String>> nRevenuescores21 = new ArrayList<>();

            JSONArray jsonArray4 = jsonObject5.getJSONArray("labels");
            JSONArray jsonArray5 = jsonObject5.getJSONArray("scores");
            String name2 = String.valueOf(((JSONObject) jsonObject1.get("nRevenue")).get("name"));
            String uom2 = String.valueOf(((JSONObject) jsonObject1.get("nRevenue")).get("uom"));
            int n = 0;
            while (n < jsonArray4.length()) {
                ArrayList<String> nRevenuelabels = new ArrayList<>();
                ArrayList<String> nRevenuelabels1 = new ArrayList<>();
                String sb = jsonArray4.get(n).toString();
                String sb1 = sb.replace("\",\"", "&");
                String sb2 = sb1.replace("[\"", "");
                String sb3 = sb2.replace("\"]", "");
                String[] splits = sb3.split("&");
                int k = 0;
                while (k < splits.length) {
                    nRevenuelabels1.add(splits[k]);
                    k++;
                }

                nRevenuelabels.addAll(nRevenuelabels1);
                nRevenuelabels21.add(nRevenuelabels);
                n++;
            }


            int w = 0;
            while (w < jsonArray5.length()) {
                ArrayList<String> nRevenuescores = new ArrayList<>();
                ArrayList<String> nRevenuescores1 = new ArrayList<>();
                String sb = jsonArray5.get(w).toString();
                String sb1 = sb.replace("\"[\"", "");
                String sb2 = sb1.replace("[\"", "");
                String sb3 = sb2.replace("\",", "&");
                String sb4 = sb3.replace("]", "");
                String sb5 = sb4.replace(",", "&");
                String[] splits = sb5.split("&");
                int k = 0;
                while (k < splits.length) {
                    nRevenuescores1.add(splits[k]);
                    k++;
                }
                nRevenuescores.addAll(nRevenuescores1);
                nRevenuescores21.add(nRevenuescores);
                w++;
            }

            nRevenue.setLabels(nRevenuelabels21);
            nRevenue.setName(name2);
            nRevenue.setUom(uom2);
            nRevenue.setScores(nRevenuescores21);

//NCustLib
            NCustLiab nCustLiab = new NCustLiab();
            ArrayList<ArrayList<String>> nCustliblabels21 = new ArrayList<>();
            ArrayList<ArrayList<String>> nCustlibscores21 = new ArrayList<>();

            JSONArray jsonArray6 = jsonObject4.getJSONArray("labels");
            JSONArray jsonArray7 = jsonObject4.getJSONArray("scores");
            String name3 = String.valueOf(((JSONObject) jsonObject1.get("nCustLiab")).get("name"));
            String uom3 = String.valueOf(((JSONObject) jsonObject1.get("nCustLiab")).get("uom"));
            int q = 0;
            while (q < jsonArray6.length()) {
                ArrayList<String> nCustliblabels = new ArrayList<>();
                ArrayList<String> nCustliblabels1 = new ArrayList<>();
                String sb = jsonArray6.get(q).toString();
                String sb1 = sb.replace("\",\"", "&");
                String sb2 = sb1.replace("[\"", "");
                String sb3 = sb2.replace("\"]", "");
                String[] splits = sb3.split("&");
                int k = 0;
                while (k < splits.length) {
                    nCustliblabels1.add(splits[k]);
                    k++;
                }

                nCustliblabels.addAll(nCustliblabels1);
                nCustliblabels21.add(nCustliblabels);
                q++;
            }


            int r = 0;
            while (r < jsonArray7.length()) {
                ArrayList<String> nCustlibscores = new ArrayList<>();
                ArrayList<String> nCustlibscores1 = new ArrayList<>();
                String sb = jsonArray7.get(r).toString();
                String sb1 = sb.replace("\"[\"", "");
                String sb2 = sb1.replace("[\"", "");
                String sb3 = sb2.replace("\",", "&");
                String sb4 = sb3.replace("]", "");
                String sb5 = sb4.replace(",", "&");
                String[] splits = sb5.split("&");
                int k = 0;
                while (k < splits.length) {
                    nCustlibscores1.add(splits[k]);
                    k++;
                }
                nCustlibscores.addAll(nCustlibscores1);
                nCustlibscores21.add(nCustlibscores);
                r++;
            }

            nCustLiab.setLabels(nCustliblabels21);
            nCustLiab.setName(name3);
            nCustLiab.setUom(uom3);
            nCustLiab.setScores(nCustlibscores21);


//NegativeBal
            NegativeBal negativeBal = new NegativeBal();
            ArrayList<ArrayList<String>> negativeBallabels21 = new ArrayList<>();
            ArrayList<ArrayList<String>> negativeBalscores21 = new ArrayList<>();

            JSONArray jsonArray8 = jsonObject6.getJSONArray("labels");
            JSONArray jsonArray9 = jsonObject6.getJSONArray("scores");
            String name4 = String.valueOf(((JSONObject) jsonObject1.get("NegativeBal")).get("name"));
            String uom4 = String.valueOf(((JSONObject) jsonObject1.get("NegativeBal")).get("uom"));
            int t = 0;
            while (t < jsonArray8.length()) {
                ArrayList<String> negativeBallabels = new ArrayList<>();
                ArrayList<String> negativeBallabels1 = new ArrayList<>();
                String sb = jsonArray8.get(t).toString();
                String sb1 = sb.replace("\",\"", "&");
                String sb2 = sb1.replace("[\"", "");
                String sb3 = sb2.replace("\"]", "");
                String[] splits = sb3.split("&");
                int k = 0;
                while (k < splits.length) {
                    negativeBallabels1.add(splits[k]);
                    k++;
                }

                negativeBallabels.addAll(negativeBallabels1);
                negativeBallabels21.add(negativeBallabels);
                t++;
            }


            int u = 0;
            while (u < jsonArray9.length()) {
                ArrayList<String> negativeBalscores = new ArrayList<>();
                ArrayList<String> negativeBalscores1 = new ArrayList<>();
                String sb = jsonArray9.get(u).toString();
                String sb1 = sb.replace("\"[\"", "");
                String sb2 = sb1.replace("[\"", "");
                String sb3 = sb2.replace("\",", "&");
                String sb4 = sb3.replace("]", "");
                String sb5 = sb4.replace(",", "&");
                String[] splits = sb5.split("&");
                int k = 0;
                while (k < splits.length) {
                    negativeBalscores1.add(splits[k]);
                    k++;
                }
                negativeBalscores.addAll(negativeBalscores1);
                negativeBalscores21.add(negativeBalscores);
                u++;
            }

            negativeBal.setLabels(negativeBallabels21);
            negativeBal.setName(name4);
            negativeBal.setUom(uom4);
            negativeBal.setScores(negativeBalscores21);


            Data data = new Data();
            data.setNTakeRateObject(nTakeRate);
            data.setNTPVObject(ntpv);
            data.setNRevenueObject(nRevenue);
            data.setNCustLiabObject(nCustLiab);
            data.setNegativeBalObject(negativeBal);
            watchBO.setData(data);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id)
        {
            case R.id.Day7:
                Toast.makeText(this, "7 click",Toast.LENGTH_SHORT).show();
                break;

        }
    }
}
