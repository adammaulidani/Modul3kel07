package com.example.notebook.modul1kel07.ui.home;

import com.example.notebook.modul1kel07.data.model.DataCar;

import java.util.List;

public interface HomeView {
    void successShowCar(List<DataCar> dataCars);
    void failedShowCar(String message);

}
