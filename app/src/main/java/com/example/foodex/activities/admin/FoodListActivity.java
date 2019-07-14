package com.example.foodex.activities.admin;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodex.R;
import com.example.foodex.adapters.AdminFoodListAdapter;
import com.example.foodex.api.Url;
import com.example.foodex.response.FoodResponse;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FoodListActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private FloatingActionButton fabAddFood;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_list);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));

        fabAddFood = findViewById(R.id.fabAddFood);
        fabAddFood.setOnClickListener(view -> {
            startActivity(new Intent(this, AddFoodActivity.class));
        });

        getFoodList();
    }

    private void getFoodList() {
        Url.getEndPoints().getFood().enqueue(new Callback<FoodResponse>() {
            @Override
            public void onResponse(Call<FoodResponse> call, Response<FoodResponse> response) {
                if (response.body().isStatus()) {
                    AdminFoodListAdapter adapter = new AdminFoodListAdapter(FoodListActivity.this, response.body().getData());
                    recyclerView.setAdapter(adapter);
                } else {
                    Toast.makeText(FoodListActivity.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<FoodResponse> call, Throwable t) {
                Toast.makeText(FoodListActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void goBack(View view) {
        super.onBackPressed();
    }
}
