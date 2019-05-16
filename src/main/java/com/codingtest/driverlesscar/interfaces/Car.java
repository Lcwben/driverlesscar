package com.codingtest.driverlesscar.interfaces;

public interface Car {
    void move(String command);
    int getPositionX();
    int getPositionY();
    String getOrientation();
}
