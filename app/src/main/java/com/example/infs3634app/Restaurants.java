package com.example.infs3634app;

import java.util.ArrayList;

public class Restaurants {
    private String name;
    private String cuisine;
    private String location;
    private double myRating;
    private double averageRating;
    private int averageCost;
    private String address;



    public Restaurants() {

    }

    public Restaurants(String name, String cuisine, String location, double myRating, double averageRating, int averageCost, String address) {
        this.name = name;
        this.cuisine = cuisine;
        this.location = location;
        this.myRating = myRating;
        this.averageRating = averageRating;
        this.averageCost = averageCost;
        this.address = address;
    }

    public String getName() { return name;}

    public void setName(String name) { this.name = name; }

    public String getCuisine() { return cuisine;}

    public void setCuisine(String cuisine) { this.cuisine = cuisine; }

    public String getLocation() { return location;}

    public void setLocation(String location) { this.location = location; }

    public int getAverageCost() { return averageCost;}

    public void setAverageCost(int averageCost) { this.averageCost = averageCost; }

    public double getMyRating() { return myRating;}

    public void setMyRating(double myRating) { this.myRating = myRating; }

    public double getAverageRating() { return averageRating;}

    public void setAverageRating(double averageRating) { this.averageRating = averageRating; }

    public String getAddress() { return address;}

    public void setAddress(String address) { this.address = address; }

    public static Restaurants getRestaurant(String id) {
        for (Restaurants rest : getRestaurants()) {
            if(rest.getName().equals(id)) {
                return rest;
            }
        }
        return null;
    }

    //@Override
    //public String toString() { return symbol; }

    public static ArrayList<Restaurants> getRestaurants() {

        ArrayList<Restaurants> restaurants = new ArrayList<>();
        restaurants.add(new Restaurants("El Jannahs", "Fast Food", "Kogarah",  4.50, 4.30, 20, "123 Smith Street"));
        restaurants.add(new Restaurants("McDonalds", "Fast Food", "Auburn",  4.00, 4.20, 15, "23 Homer Street"));
        restaurants.add(new Restaurants("EasyWay", "Drinks", "Randwick",  3.50, 4.00, 8, "11 First Avenue"));
        restaurants.add(new Restaurants("Chatime", "Drinks", "Eastwood",  2.50, 3.50, 8, "22 Second Avenue"));
        restaurants.add(new Restaurants("Tetsuya", "Japanese", "Sydney CBD",  4.50, 5.00, 300, "34 Third Avenue"));
        restaurants.add(new Restaurants("Miyazaki", "Japanese", "Sydney CBD",  4.00, 4.50, 200, "55 Fourth Avenue"));
        restaurants.add(new Restaurants("Golden Dragon", "Chinese", "Kogarah",  3.70, 3.20, 20, "66 Sixth Avenue"));
        restaurants.add(new Restaurants("Fortune Cookie", "Chinese", "Hurstville",  4.60, 4.00, 15, "77 Seventh Avenue"));
        restaurants.add(new Restaurants("Boganville", "Australian", "Punchbowl",  4.20, 3.50, 10, "88 Eight Avenue"));
        restaurants.add(new Restaurants("YallahEats", "Lebanese", "Kensington",  4.90, 4.50, 10, "99 Ninth Avenue"));

        return restaurants;
    }

}
