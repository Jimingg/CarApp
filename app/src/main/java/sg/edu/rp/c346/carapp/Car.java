package sg.edu.rp.c346.carapp;

public class Car {
    private int id;
    private String brand;
    private double litre;

    public int getId() {
        return id;
    }

    public String getBrand() {
        return brand;
    }

    public double getLitre() {
        return litre;
    }

    public Car(int id, String brand, double litre) {
        this.id = id;
        this.brand = brand;
        this.litre = litre;
    }
}
