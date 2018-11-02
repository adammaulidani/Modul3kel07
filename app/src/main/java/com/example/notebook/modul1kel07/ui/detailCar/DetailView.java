package com.example.notebook.modul1kel07.ui.detailCar;

import com.example.notebook.modul1kel07.data.model.DataCar;

public interface DetailView {
    void showErrorCarById(String message);

    void showSuccessCarById(DataCar dataCar);
}
