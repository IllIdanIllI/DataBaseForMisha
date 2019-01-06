package instance;

import java.util.Objects;

public class Car {
    private int id;
    private String nameCar;
    private int yearCar;
    private String colorCar;

    public Car() {
    }

    public Car(int id, String nameCar, int yearCar, String colorCar) {
        this.id = id;
        this.nameCar = nameCar;
        this.yearCar = yearCar;
        this.colorCar = colorCar;
    }

    public Car(String nameCar, int yearCar, String colorCar) {
        this.nameCar = nameCar;
        this.yearCar = yearCar;
        this.colorCar = colorCar;
    }

    public int getId() {
        return id;
    }

    public String getNameCar() {
        return nameCar;
    }

    public int getYearCar() {
        return yearCar;
    }

    public String getColorCar() {
        return colorCar;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNameCar(String nameCar) {
        this.nameCar = nameCar;
    }

    public void setYearCar(int yearCar) {
        this.yearCar = yearCar;
    }

    public void setColorCar(String colorCar) {
        this.colorCar = colorCar;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", nameCar='" + nameCar + '\'' +
                ", yearCar=" + yearCar +
                ", colorCar='" + colorCar + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return id == car.id &&
                yearCar == car.yearCar &&
                Objects.equals(nameCar, car.nameCar) &&
                Objects.equals(colorCar, car.colorCar);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nameCar, yearCar, colorCar);
    }
}

