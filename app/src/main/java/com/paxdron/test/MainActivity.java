package com.paxdron.test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ImageView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import java.util.List;

public class MainActivity extends AppCompatActivity implements Response.Listener<String>,Response.ErrorListener{
    public static final String IMAGE="http://static.cinepol.is/img/front/1/201721413363990-prin.jpg";
    public static final String URL="http://api.cinepolis.com.mx/Consumo.svc/json/ObtenerCiudades";
    private RecyclerView mRVCiudades;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private List<Ciudad> ciudades;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView topImage= (ImageView)findViewById(R.id.topImage);
        Picasso.with(this).load(IMAGE).into(topImage);
        mRVCiudades = (RecyclerView) findViewById(R.id.rv_ciudades);

        mLayoutManager = new LinearLayoutManager(this);
        mRVCiudades.setLayoutManager(mLayoutManager);
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        StringRequest jsonObjectRequest = new StringRequest(Request.Method.GET,URL,this,this);
        requestQueue.add(jsonObjectRequest);
    }


    @Override
    public void onErrorResponse(VolleyError error) {

    }

    @Override
    public void onResponse(String response) {
        Gson gson = new Gson();
        ciudades= gson.fromJson(response,CiudadesJson.class);
        Log.i("OnResponse: ",response);
        mAdapter = new AdapterCiudades(ciudades,this);
        mRVCiudades.setAdapter(mAdapter);
    }
}
