package com.example.odibetssuretips;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;
import android.widget.ToggleButton;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.RetryPolicy;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.android.volley.toolbox.JsonArrayRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    private RecyclerView mList;
    private LinearLayoutManager linearLayoutManager;
    private DividerItemDecoration dividerItemDecoration;
    private List<MyListData> matchList;
    private RecyclerView.Adapter adapter;
/*
    private TextView time;
    private TextView border;
    private  TextView marchOne;
    private TextView marchTwo;
    private TextView scoreOne;
    private TextView scoreTwo;
    private TextView border1;
    private TextView tips;
    private TextView border2;
    private TextView odds;

 */



//    ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        ProgressDialog dialog = new ProgressDialog(this);//initialization; progressDialog.setContentView(R.layout.progress_layout);
//        ToggleButton = (2021-)

        //Declaring the variables
        mList = findViewById(R.id.main_list);

        matchList = new ArrayList<>();
        adapter = new MyListAdapter(getApplicationContext(),matchList);

        linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        dividerItemDecoration = new DividerItemDecoration(mList.getContext(), linearLayoutManager.getOrientation());
        mList.setHasFixedSize(true);
        mList.setLayoutManager(linearLayoutManager);
        mList.addItemDecoration(dividerItemDecoration);
        mList.setAdapter(adapter);

       JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("app_package","com.sportytips");
            jsonObject.put("game", "currentDate");
//            jsonObject.put("match_start_time", "2021-04-28 20:00:00" );
//            jsonObject.put("home_team",  "manchester");
//            jsonObject.put("away_team","Manchester City");
//            jsonObject.put("home_strength", "1.1813520541");
//            jsonObject.put( "away_strength", "1.7368890657");
//            jsonObject.put("prediction", "2");
//            jsonObject.put("odds", "0.499");
            postLogin(jsonObject);

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
    private void postLogin(JSONObject payload) {
//  progressDialog.show();
        JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.POST, "https://www.suretips.co.ke/bettips_api//tips/all/v2", payload, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
              // progressDialog.dismiss();
                        Log.d("Tips", response.toString());
                        try {

                            //put your code here
                            JSONObject data = response.getJSONObject("data");
                            JSONArray leagues = data.getJSONArray("matches");


                            for (int i = 0; i < leagues.length(); i++) {

                                JSONObject league = leagues.getJSONObject( i );
                                JSONArray matches = league.getJSONArray( "matches");
                                Log.d("matches", matches.toString());

                                for(int j=0;j<matches.length();j++){
                                    JSONObject jsonObject = matches.getJSONObject( j );
                                    Log.d(" jsonObject",  jsonObject.toString() );
                                    MyListData myListData = new MyListData();
                                    myListData.setTime(jsonObject.getString("match_start_time"));
                                    myListData.setHome_team(jsonObject.optString("home_team"));
                                    myListData.setAway_team(jsonObject.optString("away_team"));
                                    myListData.setPrediction(jsonObject.optString("tips"));
                                    myListData.setOdds(jsonObject.optString("odds"));
                                    matchList.add(myListData);

                                }

                                //Log.d("jsonObject",jsonObject.toString() );
                                //JSONObject jsonObject = response.getJSONObject(String.valueOf(i));

//                        myListData.setTime(matches.getString(Integer.parseInt(String.valueOf(Integer.parseInt("match_start_time")))));
//                        myListData.setHome_team(matches.getString(Integer.parseInt("home_team")));
//                        myListData.setAway_team(matches.getString(Integer.parseInt("away_team")));
//                        myListData.setPrediction(matches.getString(Integer.parseInt("tips")));

//                        time.setText(name.getString("time"));
//                        tips.setText(name.getInt("prediction"));
//                        marchOne.setText(name.getString("home_team"));
//                        marchTwo.setText(name.getString("away_team"));
//                        odds.setText(name.getInt("odds"));

                            }
                            adapter.notifyDataSetChanged();

                        }

                        catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                },
                volleyError -> {
//            progressDialog.dismiss();
                    NetworkResponse response = volleyError.networkResponse;

                    // MotionTelltales lblMessageBox = null;
                    if (response != null && response.data != null) {
                        String json = new String(response.data);
                        Log.d("Error", json);

                        try {
                            JSONObject obj = new JSONObject(json);
                            json = obj.getString("statusDescription");
                            if (!obj.isNull("data")) {
                                JSONObject data = obj.getJSONObject("data");
                                Toast.makeText(getApplicationContext(), data.getString("message"), Toast.LENGTH_SHORT).show();
                            } else {

                                Toast.makeText(getApplicationContext(), json, Toast.LENGTH_SHORT).show();
                            }

                        } catch (JSONException e) {

                            Toast.makeText(getApplicationContext(), "Server error", Toast.LENGTH_LONG).show();
                            e.printStackTrace();
                        }
                    } else {
                        Toast.makeText(getApplicationContext(), "Server error", Toast.LENGTH_LONG).show();

                    }

                });
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(jsonObjReq);
            RetryPolicy policy = new DefaultRetryPolicy(30000, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
                jsonObjReq.setRetryPolicy(policy);
            // Adding request to request queue
                RequestSingletone.getInstance(getApplicationContext()).addToRequestQueue(jsonObjReq, "matches");
    }
}
