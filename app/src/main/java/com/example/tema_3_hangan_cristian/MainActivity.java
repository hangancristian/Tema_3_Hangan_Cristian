package com.example.tema_3_hangan_cristian;


import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    String url = "https://my-json-server.typicode.com/MoldovanG/JsonServer/users?fbclid=IwAR0EqNsBdpzsuZY852kOGk0xtl2e_3cHCrBiXlsjYHl-HsCg13sFGSUvaHg";

    RecyclerView recyclerView;
    ProgressBar progressBar;

    UserAdapter adapter;

    ArrayList<User> arrayList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.list_rv);
        progressBar = findViewById(R.id.progress_circular);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        getDataFromServer();


    }

    private void getDataFromServer() {
        StringRequest stringRequest = new StringRequest(
                Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                progressBar.setVisibility(View.GONE);
                if (response != null) {
                    Log.e(TAG, "onResponse: " + response);
                    try {
                        JSONArray jsonArray = new JSONArray(response);
                        for (int i = 0; i < jsonArray.length(); i++) {
                            JSONObject data = jsonArray.getJSONObject(i);
                            arrayList.add(new User(data.getString("id"),data.getString("name"), data.getString("username"),data.getString("email")));
                        }
                        setAdapter();

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        progressBar.setVisibility(View.GONE);
                        Log.e(TAG, "onErrorResponse: " + error);
                    }
                });
        Volley.newRequestQueue(this).add(stringRequest);

    }

    private void setAdapter() {
        Log.e(TAG, "setAdapter: " + arrayList.size());
        adapter = new UserAdapter(arrayList);
        recyclerView.setAdapter(adapter);

    }
}

