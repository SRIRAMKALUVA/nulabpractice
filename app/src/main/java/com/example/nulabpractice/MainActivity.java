package com.example.nulabpractice;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<Member> memberList;
    private ListView memberListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        memberListView = findViewById(R.id.memberListView);
        memberList = new ArrayList<>();

        // Read JSON data from the assets folder
        String jsonData = Utils.readJsonFromAssets(this, "members.json");

        // Parse JSON data
        try {
            JSONArray jsonArray = new JSONArray(jsonData);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                String name = jsonObject.getString("name");
                String email = jsonObject.getString("email");
                String phone = jsonObject.getString("phone");
                int age = jsonObject.getInt("age");

                memberList.add(new Member(name, email, age, phone));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        // Set up the adapter
        MemberAdapter adapter = new MemberAdapter(this, memberList);
        memberListView.setAdapter(adapter);
    }
}