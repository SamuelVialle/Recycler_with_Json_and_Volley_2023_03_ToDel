package com.samuelvialle.a_2023_03_recyclerwithjsonandvolley;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    /** Globals VARS **/
    private RecyclerView recyclerView;
    private EditText etSearch;
    private Button btnSearch;
    private ArrayList<ModelItem> arrayList; // ArrayList basé.e sur note model
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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initUI();
    }
}