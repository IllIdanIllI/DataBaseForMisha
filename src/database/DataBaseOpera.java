package database;

import instance.Car;

import java.sql.*;


public class DataBaseOpera implements PerentDBO {
    private static final String ID = "id";
    private static final String NAMECAR = "nameCar";
    private static final String YEARCAR = "yearCar";
    private static final String COLORCAR = "colorCar";

    @Override
    public void showAllInfo() {
        DBConnection dbc = new DBConnection();
        String lineSQL = "select * from carsharing.carsharing";
        try {
            Statement statement = dbc.getConn().createStatement();
            ResultSet resultSet = statement.executeQuery(lineSQL);
            while (resultSet.next()) {
                Car car = new Car();
                car.setId(resultSet.getInt(ID));
                car.setNameCar(resultSet.getString(NAMECAR));
                car.setYearCar(resultSet.getInt(YEARCAR));
                car.setColorCar(resultSet.getString(COLORCAR));
                System.out.println(car);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void insertInfo(String name, int year, String color) {
        DBConnection dbc = new DBConnection();
        String lineSQL = "insert into carsharing.carsharing(nameCar, yearCar, colorCar) values(?,?,?)";
        try {
            PreparedStatement preparedStatement = dbc.getConn().prepareStatement(lineSQL);
            preparedStatement.setString(1, name);
            preparedStatement.setInt(2, year);
            preparedStatement.setString(3, color);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteInfo(String line) {
        DBConnection dbc = new DBConnection();
        String lineSQL = "delete from carsharing.carsharing where id=?";
        try {
            Car car = findByName(line);
            PreparedStatement preparedStatement = dbc.getConn().prepareStatement(lineSQL);
            preparedStatement.setInt(1, car.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Car findByName(String name) {
        String lineSQL = "select * from carsharing.carsharing where nameCar = '"+name+"'";
        return helpFind(lineSQL);
    }
    public Car findByColor(String name) {
        String lineSQL = "select * from carsharing.carsharing where colorCar = '"+name+"'";
        return helpFind(lineSQL);
    }
    private static Car helpFind(String str){
        DBConnection dbc = new DBConnection();
        try {
            Statement statement = dbc.getConn().createStatement();
            ResultSet resultSet = statement.executeQuery(str);
            while (resultSet.next()) {
                Car car = new Car();
                car.setId(resultSet.getInt(ID));
                car.setNameCar(resultSet.getString(NAMECAR));
                car.setYearCar(resultSet.getInt(YEARCAR));
                car.setColorCar(resultSet.getString(COLORCAR));
                return car;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
