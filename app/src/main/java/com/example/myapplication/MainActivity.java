package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    String urlGetData  = "http://192.168.1.5/android/getdata.php";

    ListView listViewStudent;
    ArrayList<Student> studentArrayList;
    StudentAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listViewStudent = (ListView) findViewById(R.id.listviewSinhVien);
        studentArrayList = new ArrayList<>();
        adapter = new StudentAdapter(this, R.layout.student_line, studentArrayList);
        listViewStudent.setAdapter(adapter);

        GetData(urlGetData);
    }
    private void GetData(String url){
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for (int i = 0; i < response.length(); i++){
                    try {
                        JSONObject object = response.getJSONObject(i);
                        studentArrayList.add(new Student(
                                object.getInt("ID"),
                                object.getString("Name"),
                                object.getInt("Year"),
                                object.getString("Address")
                        ));
                    } catch (JSONException e) {
                        throw new RuntimeException(e);
                    }
                    adapter.notifyDataSetChanged();
                }
            }
        },
                new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this, error.toString(), Toast.LENGTH_SHORT).show();
            }
        }
        );
        requestQueue.add(jsonArrayRequest);
    }
}