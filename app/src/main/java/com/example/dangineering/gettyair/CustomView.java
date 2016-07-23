package com.example.dangineering.gettyair;

import com.example.dangineering.gettyair.network.respmodel.Image;

import java.util.List;

public interface CustomView {

    void add(List<Image> imageList);

    void showError(String msg);
}
