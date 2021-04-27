package com.example.odibetssuretips;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        MyListData[] myListData = new MyListData[] {
                new MyListData(2000,"Leeds" + "Manchester United",0 + 0,2,1.851),
                new MyListData(2000,"Leeds" + "Manchester United",0 + 0,2,1.851),
                new MyListData(2000,"Leeds" + "Manchester United",0 + 0,2,1.851),
                new MyListData(2000,"Leeds" + "Manchester United",0 + 0,2,1.851),
                new MyListData(2000,"Leeds" + "Manchester United",0 + 0,2,1.851),
                new MyListData(2000,"Leeds" + "Manchester United",0 + 0,2,1.851),
                new MyListData(2000,"Leeds" + "Manchester United",0 + 0,2,1.851),
                new MyListData(2000,"Leeds" + "Manchester United",0 + 0,2,1.851),
                new MyListData(2000,"Leeds" + "Manchester United",0 + 0,2,1.851),
                new MyListData(2000,"Leeds" + "Manchester United",0 + 0,2,1.851),
                new MyListData(2000,"Leeds" + "Manchester United",0 + 0,2,1.851),
                new MyListData(2000,"Leeds" + "Manchester United",0 + 0,2,1.851),
        };

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        MyListAdapter adapter = new MyListAdapter(myListData);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }
}


