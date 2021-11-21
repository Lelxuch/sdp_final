package BridgePattern;

import BridgePattern.Colors.Color;

public abstract class Product {

    public Color color;

    public Product(Color color) {
        this.color = color;
    }

    abstract public void info();

    abstract public int getPrice();
}