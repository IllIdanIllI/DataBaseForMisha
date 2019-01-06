package database;


import instance.Car;

import java.util.List;

public interface PerentDBO {
    void showAllInfo();
    void insertInfo(String name, int year, String color);
    void deleteInfo(String name);
    Car findByName(String name);
    Car findByColor(String name);
}
