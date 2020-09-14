package com.hanoi;

import java.awt.*;
import java.util.Random;

public class Disk {
    private Random rand = new Random();
    public static final int height = 30;
    public int weight,x,y,value;
    public Color color;

    public Disk(int index) {
        float r = rand.nextFloat();
        float g = rand.nextFloat() / 2f;
        float b = rand.nextFloat() / 2f;

        this.value = index;
        this.weight = index*10 + 90;
        this.color = new Color(r,g,b);
        this.x = 80 - this.weight/2;
        this.y = 0;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
