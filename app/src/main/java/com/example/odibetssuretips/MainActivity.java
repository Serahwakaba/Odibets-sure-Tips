package com.example.odibetssuretips;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.utils.widget.MotionTelltales;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.RetryPolicy;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ProgressDialog dialog = new ProgressDialog(this);//initialization;        progressDialog.setContentView(R.layout.progress_layout);

       JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("app_package","com.sportytips");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        try {
            jsonObject.put("gamedate","2020-05-06");
        } catch (JSONException e) {
            e.printStackTrace();
        }
      postLogin(jsonObject);
    }

    private void postLogin(JSONObject payload) {

        progressDialog.show();
        JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.POST,"https://www.suretips.co.ke/bettips_api//tips/all/v2", payload,
                new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        progressDialog.dismiss();
                        Log.d("Tips",response.toString());

                        //put your code here

                    }
















//    @Override
        public void onErrorResponse(VolleyError volleyError) {
            progressDialog.dismiss();
            NetworkResponse response = volleyError.networkResponse;

        MotionTelltales lblMessageBox = null;
        if(response != null && response.data != null){
                String json = new String(response.data);
                Log.d("Error",json);

                try{
                    JSONObject obj = new JSONObject(json);
                    json = obj.getString("statusDescription");
                    if(!obj.isNull("data")){
                        JSONObject data = obj.getJSONObject("data");
                        lblMessageBox.setVisibility(View.VISIBLE);
                        lblMessageBox.setText(data.getString("message"));

                        // Toast.makeText(getContext(),data.getString("message"),Toast.LENGTH_SHORT).show();
                    }
                    else{
                        lblMessageBox.setText(json);
                        lblMessageBox.setVisibility(View.VISIBLE);
                        Toast.makeText(getContext(),json, Toast.LENGTH_SHORT).show();
                    }

                } catch(JSONException e){
                    lblMessageBox.setVisibility(View.VISIBLE);
                    lblMessageBox.setText(getContext().getResources().getString(R.string.serverError));

                    //Toast.makeText(getContext(),getContext().getResources().getString(R.string.serverError),Toast.LENGTH_LONG).show();
                    e.printStackTrace();
                }
            }
            else{
                lblMessageBox.setVisibility(View.VISIBLE);
                lblMessageBox.setText(getContext().getResources().getString(R.string.serverError));
            }


        }
    })
    {
    };
//    RetryPolicy policy = new DefaultRetryPolicy(Config.SOCKET_TIMEOUT, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
//        jsonObjReq.setRetryPolicy(policy);
    // Adding request to request queue
        RequestSingletone.getInstance(getContext()).addToRequestQueue(jsonObjReq, "SET PIN REQUEST"); }

    private Context getContext() {
        return null;
    }
}






