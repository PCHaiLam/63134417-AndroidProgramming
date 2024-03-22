package com.example.listview;

public class Food {
    private String foodName;
    private String foodImage;
    private double foodPrice;
    public Food(String foodName, String foodImage, double foodPrice) {
        this.foodName = foodName;
        this.foodImage = foodImage;
        this.foodPrice = foodPrice;
    }
    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public String getFoodImage() {
        return foodImage;
    }

    public void setFoodImage(String foodImage) {
        this.foodImage = foodImage;
    }

    public double getFoodPrice() {
        return foodPrice;
    }

    public void setFoodPrice(double foodPrice) {
        this.foodPrice = foodPrice;
    }
}
