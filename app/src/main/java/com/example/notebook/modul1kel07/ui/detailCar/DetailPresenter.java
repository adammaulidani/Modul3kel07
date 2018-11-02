package com.example.notebook.modul1kel07.ui.detailCar;

import android.util.Log;

import com.example.notebook.modul1kel07.data.model.DataCar;
import com.example.notebook.modul1kel07.data.network.RetrofitClient;
import com.example.notebook.modul1kel07.ui.detailCar.DetailView;
import com.example.notebook.modul1kel07.ui.detailCar.DetailActivity;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailPresenter {
    private final DetailView mView ;
    private DataCar dataCar;
    final String tag = "Detail-GetCarById";

    public  DetailPresenter(DetailView detailView){ mView =detailView;}

    public void getCarById(DataCar dataCar) {
        RetrofitClient.getInstance()
                .getApi()
                .GetCarById(dataCar.getId())
                .enqueue(new Callback<JsonObject>() {
                    @Override
                    public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                        if (response.isSuccessful()) {
                            JsonObject body = response.body();
                            JsonObject data = body.get("data").getAsJsonObject();
                            DataCar dataRespon = new Gson().fromJson(data, DataCar.class);
                            mView.showSuccessCarById(dataRespon);
                            Log.e(tag, response.body().toString());
                        } else {
                            Log.e("DATA", "ERROR");
                            mView.showErrorCarById("ERROR");
                        }
                    }
                    @Override
                    public void onFailure(Call<JsonObject> call, Throwable t) {
                        Log.e("DATA", t.getMessage());
                        mView.showErrorCarById(t.getMessage());
                    }
                });
        }
    }
