package com.mi.www.material.bean;

/**
 * Created by wm on 2017/12/1.
 */

public class Fruit {
    private int fuitId;
    private String fruitName;

    public Fruit(int fuitId, String fruitName) {
        this.fuitId = fuitId;
        this.fruitName = fruitName;
    }

    public int getFuitId() {
        return fuitId;
    }

    public void setFuitId(int fuitId) {
        this.fuitId = fuitId;
    }

    public String getFruitName() {
        return fruitName;
    }

    public void setFruitName(String fruitName) {
        this.fruitName = fruitName;
    }
}
