package com.samuelvialle.a_2023_03_recyclerwithjsonandvolley;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    /** Globals VARS **/
    private RecyclerView recyclerView;
    private Button btnSearch;
    private ArrayList<ModelItem> arrayList; // ArrayList basé.e sur note model
    private EditText etSearch;
    private String search; // String de la recherche dans l'editText
    private AdapterRecycler adapter; // Gestion de notre Adapter
    private RequestQueue requestQueue; // Gestion de Volley

    /** Initialisation des composants graphiques et autres composants **/
    private void initUI(){
       recyclerView = findViewById(R.id.recycler);
       recyclerView.setHasFixedSize(true);
       recyclerView.setLayoutManager(new LinearLayoutManager(this));

       etSearch = findViewById(R.id.et_search);
       btnSearch = findViewById(R.id.btn_search);

       arrayList = new ArrayList<>();

       requestQueue = Volley.newRequestQueue(this);
    }

    private void parseJSON(){
        String pixabayKey = "24175925-f2016e765d25a20f1cb0a6989";
        String urlJSONFile = "https://pixabay.com/api/"
                + "?key="
                + pixabayKey
                + "&q="
                + "beach" // ici la recherche
                + "&image_type=photo"
                + "&orientation=horizontal"
                + "&per_page=30"
                + "&pretty=true";

        Log.i("TAG", "parseJSON: " + urlJSONFile);


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initUI();

        parseJSON();

    }
}