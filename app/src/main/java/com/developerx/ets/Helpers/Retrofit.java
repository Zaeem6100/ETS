package com.developerx.ets.Helpers;


import android.content.Context;
import android.util.Log;
import android.widget.ImageView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.developerx.ets.Model.QuestionModel;
import com.android.volley.toolbox.Volley;
import com.developerx.ets.Model.Student;

import org.json.JSONException;
import java.util.ArrayList;

public class Retrofit {
//    Todo ADD URL
    public  static  final String URL = "http://:8080/api/v1/questions";
    private static final String TAG = "Retrofit Class";
    private  Context context;
    private ArrayList<QuestionModel> questionModelArrayList;

    public  Retrofit(Context context){
        this.context = context;
    }
    public void getQuestion(){
        RequestQueue requestQueue = Volley.newRequestQueue(context);
        JsonArrayRequest  jsonArrayRequest = new JsonArrayRequest(Request.Method.GET,URL,null,
                response -> {
                    questionModelArrayList = new ArrayList<>();
                    for (int i = 0; i < response.length(); i++) {
                        QuestionModel questionModel = new QuestionModel();
                        try {
                            questionModel.setQuestion(response.getJSONObject(i).getString("question"));
                            questionModel.setOption1(response.getJSONObject(i).getString("option1"));
                            questionModel.setOption2(response.getJSONObject(i).getString("option2"));
                            questionModel.setOption3(response.getJSONObject(i).getString("option3"));
                            questionModel.setOption4(response.getJSONObject(i).getString("option4"));
                            questionModel.setAnswer(response.getJSONObject(i).getString("answer"));
                            questionModelArrayList.add(questionModel);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                },
                error -> {
                    Log.d(TAG, "Error in Get Data : ");
                    error.printStackTrace();
                });
        requestQueue.add(jsonArrayRequest);
    }
    public  void  PostData(ArrayList<QuestionModel> questionModelArrayList){

    }
    public  void CancelAllRequests(){

    }
    public void getUSerData(String CNIC){
         String uri = String.format(URL + "/%s", CNIC);
        RequestQueue requestQueue = Volley.newRequestQueue(context);
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET,uri,null,
                response -> {
                    try {
                        Student studentModel = new Student (
                                response.getString("CNIC"),
                                response.getString("Name"),
                                response.getString("Password"),
                                response.getString("Image"));
                        Log.d(TAG, "getUserData: " + response.getString("CNIC"));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                },
                error -> {
                    Log.d(TAG, "Error in Get Data : ");
                    error.printStackTrace();
                });
    }
    public  void  LoadImage(String uri){
        ImageRequest img = new ImageRequest(uri , response -> {
            Log.d(TAG, "LoadImage: ");
        }, 0,0, ImageView.ScaleType.CENTER_INSIDE,null, error -> {
            Log.d(TAG, "Error in Load Image : ");
            Toast.makeText(context, "Error", Toast.LENGTH_SHORT).show();
        });
    }
    public ArrayList<QuestionModel> getQuestionModelArrayList() {
        return questionModelArrayList;
    }


}
