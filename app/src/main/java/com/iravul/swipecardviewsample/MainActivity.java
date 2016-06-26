package com.iravul.swipecardviewsample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.iravul.swipecardview.RecyclerViewClickListener;
import com.iravul.swipecardview.SwipeCardAdapter;
import com.iravul.swipecardview.SwipeCardModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements RecyclerViewClickListener {
    RecyclerView recyclerView;
    List<SwipeCardModel> swipeCardModels;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        swipeCardModels = new ArrayList<>();

        //dummydata
        for(int i=0;i<=10;i++){
            SwipeCardModel swipeCardModel = new SwipeCardModel();
            swipeCardModel.setId("ID-"+i);
            swipeCardModel.setTitle("Product-"+i);
            swipeCardModel.setDescription("ProductDesc-"+i);
            swipeCardModel.setPrice(i*10+" Euro");
            swipeCardModel.setPhotoUrl("https://s-media-cache-ak0.pinimg.com/736x/a3/99/24/a39924a3fcb7266ff7360af8a6ba2e98.jpg");
            swipeCardModels.add(swipeCardModel);
        }

        SwipeCardAdapter swipeCardAdapter = new SwipeCardAdapter(this,swipeCardModels,this);
        LinearLayoutManager layoutManager
                = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(swipeCardAdapter);

    }

    @Override
    public void recyclerViewListClicked(View v, int position) {
        //onclick events.
    }
}
