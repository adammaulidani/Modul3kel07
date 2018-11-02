package com.example.notebook.modul1kel07.ui.detailCar;

import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.notebook.modul1kel07.R;
import com.example.notebook.modul1kel07.data.model.DataCar;
import com.example.notebook.modul1kel07.utility.Constant;

public class DetailActivity extends AppCompatActivity implements DetailView {

    private TextView tampilNama,tampilTaun,tampilMerk,tampilModel;
    private DataCar data;
    private DetailPresenter detailPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        initView();
        intentPresenter();
        intentData();
        initData();

    }

    private void intentData() {
        data = getIntent().getParcelableExtra(Constant.Extra.DATA);
        if (data == null) finish();
    }

    private void initData() {
        detailPresenter.getCarById(data);
    }

    private void intentPresenter() {
        detailPresenter = new DetailPresenter(this);
    }

    private void initView() {
        tampilNama  = findViewById(R.id.tvTampil_nama);
        tampilTaun  = findViewById(R.id.tvTampil_Taun);
        tampilMerk  = findViewById(R.id.tvTampil_Merek);
        tampilModel = findViewById(R.id.tvTampil_Model);
    }

    @Override
    public void showErrorCarById(String message) {

    }

    @Override
    public void showSuccessCarById(DataCar dataCar) {

    }
}
