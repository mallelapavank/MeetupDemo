package com.android.meetupdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvStudentsInfo;
    private ArrayList<StudentsModel> arrayList = new ArrayList<>();
    private StudentsAdapter studentsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rvStudentsInfo = (RecyclerView) findViewById(R.id.rv_students_info);
        studentsAdapter = new StudentsAdapter(arrayList);
        rvStudentsInfo.setLayoutManager(new LinearLayoutManager(this));
        rvStudentsInfo.setAdapter(studentsAdapter);

        getStudentsInformation();
    }

    private void getStudentsInformation() {
        String url = "http://35.163.92.178:8000/get_student_data/";
        RequestQueue queue = Volley.newRequestQueue(this);
        JsonObjectRequest jsObjRequest = new JsonObjectRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {

                        try {
                            JSONArray jsonArray = response.optJSONArray("student_details");
                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject jsonObject = jsonArray.getJSONObject(i);
                                StudentsModel studentsModel = new StudentsModel();
                                studentsModel.roll_no = (jsonObject.getString("roll_no"));
                                studentsModel.stud_name = (jsonObject.getString("stud_name"));
                                studentsModel.stud_avg = (jsonObject.getString("stud_avg"));
                                studentsModel.stud_sub1 = (jsonObject.getString("stud_sub1"));
                                studentsModel.stud_sub2 = (jsonObject.getString("stud_sub2"));
                                studentsModel.stud_sub3 = (jsonObject.getString("stud_sub3"));
                                studentsModel.stud_sub4 = (jsonObject.getString("stud_sub4"));
                                studentsModel.stud_sub5 = (jsonObject.getString("stud_sub5"));
                                arrayList.add(studentsModel);
                                studentsAdapter.notifyDataSetChanged();
                            }


                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // TODO Auto-generated method stub

                    }
                });
        queue.add(jsObjRequest);
    }
}
