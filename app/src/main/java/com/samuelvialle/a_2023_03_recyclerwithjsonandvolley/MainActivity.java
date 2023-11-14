package com.samuelvialle.a_2023_03_recyclerwithjsonandvolley;

import static com.samuelvialle.a_2023_03_recyclerwithjsonandvolley.Nodes.*;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterRecycler.MyOnItemClickListener {

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

        JsonObjectRequest request = new JsonObjectRequest(
                Request.Method.GET,
                urlJSONFile,
                null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray jsonArray = response.getJSONArray(JSON_ARRAY);

                            for(int i=0; i<jsonArray.length(); i++){
                                JSONObject hit = jsonArray.getJSONObject(i);
                                String imageUrl = hit.getString(JSON_IMAGE_URL);
                                String creator = hit.getString(JSON_USER);
                                int likes = hit.getInt(JSON_LIKES);

                                arrayList.add(new ModelItem(imageUrl, creator, likes));
                            }
                            adapter = new AdapterRecycler(MainActivity.this, arrayList);
                            recyclerView.setAdapter(adapter);
                            adapter.setMyOnItemClickListener(MainActivity.this);
                        } catch (JSONException e){
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        error.printStackTrace();
                    }
                });
                requestQueue.add(request);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initUI();

        parseJSON();

    }

    @Override
    public void onItemClick(int position) {
        Toast.makeText(MainActivity.this, "TOTO", Toast.LENGTH_SHORT).show();
    }
}