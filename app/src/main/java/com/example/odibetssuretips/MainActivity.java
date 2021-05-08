package com.example.odibetssuretips;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.utils.widget.MotionTelltales;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.RetryPolicy;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

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

//    ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        ProgressDialog dialog = new ProgressDialog(this);//initialization; progressDialog.setContentView(R.layout.progress_layout);

       JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("app_package","com.sportytips");
            jsonObject.put("gamedate","2020-05-06");
            jsonObject.put("match_start_time", "2021-04-28 20:00:00" );
            jsonObject.put("home_team",  "manchester");
            jsonObject.put("away_team","Manchester City");
            jsonObject.put("home_strength", "1.1813520541");
            jsonObject.put( "away_strength", "1.7368890657");
            jsonObject.put("prediction", "2");
            jsonObject.put("odds", "0.499");
            postLogin(jsonObject);



        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    private void postLogin(JSONObject payload) {

//        progressDialog.show();
        JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.POST, "https://www.suretips.co.ke/bettips_api//tips/all/v2", payload, new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {
//                progressDialog.dismiss();
                Log.d("Tips", response.toString());
                try {

                    //put your code here
                    JSONObject data = response.getJSONObject("data");
                    JSONArray matches = data.getJSONArray("matches");

                    for (int i = 0; i < matches.length(); i++) {
                        JSONObject name = response.getJSONObject(String.valueOf(i));
                        time.setText(name.getInt("time"));
                        tips.setText(name.getInt("prediction"));
                        marchOne.setText(name.getInt("home_team"));
                        marchTwo.setText(name.getInt("away_team"));
                        odds.setText(name.getInt("odds"));





                    }

                }

                catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, volleyError -> {
//            progressDialog.dismiss();
            NetworkResponse response = volleyError.networkResponse;

            MotionTelltales lblMessageBox = null;
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
            RetryPolicy policy = new DefaultRetryPolicy(30000, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
                jsonObjReq.setRetryPolicy(policy);
            // Adding request to request queue
                RequestSingletone.getInstance(getApplicationContext()).addToRequestQueue(jsonObjReq, "matches");
    }
}






