package com.example.aviv.project1;

import android.graphics.Bitmap;

/**
 * Created by Aviv on 16/12/2017.
 */

public class Player  extends Person{

    private int number;
    private Bitmap Photo;
    private double height;
    private String posation;

    public Player(String firstName, String lastName, int number, Bitmap photo, double height, String posation) {
        super(firstName, lastName);

        this.number = number;
        Photo = photo;
        this.height = height;
        this.posation = posation;
    }


    public int getNumber() {
        return number;
    }

    public Bitmap getPhoto() {
        return Photo;
    }

    public double getHeight() {
        return height;
    }

    public String getPosation() {
        return posation;
    }


    public void setNumber(int number) {
        this.number = number;
    }

    public void setPhoto(Bitmap photo) {
        Photo = photo;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public void setPosation(String posation) {
        this.posation = posation;
    }


}
