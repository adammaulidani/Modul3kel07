package com.example.notebook.modul1kel07.ui.detailCar;

import com.example.notebook.modul1kel07.data.model.DataCar;

import java.util.List;

public interface DetailView {
    void showErrorCarById(String message);

    void showSuccessCarById(List<DataCar> dataCar);
}
