package org.bryan95.taekyulee;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.net.HttpURLConnection;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;


public class MainActivity extends AppCompatActivity {
    RecyclerView mRecyclerView;
    RecyclerView.LayoutManager mLayoutManager;

    EditText searchMo;
    Button searchBu;

    private String clientId = "bVJbuTdoQXghVoq82fFl";//애플리케이션 클라이언트 아이디값";
    private String clientSecret = "aYw8uFX0k3";
    public String keywordd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = findViewById(R.id.recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        searchMo = (EditText) findViewById(R.id.searchM);
        searchBu = (Button) findViewById(R.id.searchB);
        getGlobalString();


        final ArrayList<FoodInfo> foodInfoArrayList = new ArrayList<>();

        searchBu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                keywordd=searchMo.getText().toString();

                NetworkThread thread=new NetworkThread(keywordd,foodInfoArrayList);
                thread.start();

                MyAdapter myAdapter = new MyAdapter(foodInfoArrayList);
                mRecyclerView.setAdapter(myAdapter);
            }
        });






    }

    public String getGlobalString () {
            return keywordd;
        }

    public String getClientId() {
        return clientId;
    }

    public String getClientSecret() {
        return clientSecret;
    }


}


/*
    public void get(String globalString, String clientid, String clientsecret,ArrayList<FoodInfo> foodInfoArrayList ) {

        String keyword = this.keywordd = globalString;
        String clientId = "bVJbuTdoQXghVoq82fFl";//애플리케이션 클라이언트 아이디값";
        String clientSecret = "aYw8uFX0k3";//애플리케이션 클라이언트 시크릿값";
        int display;
*/

