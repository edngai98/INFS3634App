package com.example.infs3634app;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Restaurants {
    //private int mImageResource;
    private String name;
    private String cuisine;
    private String location;
    private float myRating;
    private float averageRating;
    private int averageCost;
    private String address;
    private int image;



    public Restaurants() {

    }

    public Restaurants(String name, String cuisine, String location, float myRating, float averageRating, int averageCost, String address, int image) {
        this.name = name;
        this.cuisine = cuisine;
        this.location = location;
        this.myRating = myRating;
        this.averageRating = averageRating;
        this.averageCost = averageCost;
        this.address = address;
        this.image = image;
    }

    public String getName() { return name;}

    public void setName(String name) { this.name = name; }

    public String getCuisine() { return cuisine;}

    public void setCuisine(String cuisine) { this.cuisine = cuisine; }

    public String getLocation() { return location;}

    public void setLocation(String location) { this.location = location; }

    public int getAverageCost() { return averageCost;}

    public void setAverageCost(int averageCost) { this.averageCost = averageCost; }

    public float getMyRating() { return myRating;}

    public void setMyRating(float myRating) { this.myRating = myRating; }

    public float getAverageRating() { return averageRating;}

    public void setAverageRating(float averageRating) { this.averageRating = averageRating; }

    public String getAddress() { return address;}

    public void setAddress(String address) { this.address = address; }

    public int getImage() { return image;}

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
        restaurants.add(new Restaurants("El Jannahs", "Fast Food", "Kogarah",  4.50f, 4.30f, 20, "123 Smith Street", R.mipmap.ejs));
        restaurants.add(new Restaurants("McDonalds", "Fast Food", "Auburn",  4.00f, 4.20f, 15, "23 Homer Street", R.mipmap.maccas));
        restaurants.add(new Restaurants("EasyWay", "Drinks", "Randwick",  3.50f, 4.00f, 8, "11 First Avenue", R.mipmap.easyway));
        restaurants.add(new Restaurants("Chatime", "Drinks", "Eastwood",  2.50f, 3.50f, 8, "22 Second Avenue", R.mipmap.chatime));
        restaurants.add(new Restaurants("Tetsuya", "Japanese", "Sydney CBD",  4.50f, 5.00f, 300, "34 Third Avenue", R.mipmap.tetsuya));
        restaurants.add(new Restaurants("Miyazaki", "Japanese", "Sydney CBD",  4.00f, 4.50f, 200, "55 Fourth Avenue", R.mipmap.miyazaki));
        restaurants.add(new Restaurants("Golden Dragon", "Chinese", "Kogarah",  3.70f, 3.20f, 20, "66 Sixth Avenue", R.mipmap.goldendragon));
        restaurants.add(new Restaurants("Fortune Cookie", "Chinese", "Hurstville",  4.60f, 4.00f, 15, "77 Seventh Avenue", R.mipmap.fortunecookie));
        restaurants.add(new Restaurants("Boganville", "Australian", "Punchbowl",  4.20f, 3.50f, 10, "88 Eight Avenue", R.mipmap.holden));
        restaurants.add(new Restaurants("YallahEats", "Lebanese", "Kensington",  4.90f, 4.50f, 10, "99 Ninth Avenue", R.mipmap.yallaheats));

        //Collections.sort(restaurants, myRating);

        return restaurants;
    }




}
