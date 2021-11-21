package StrategyPattern;

import FactoryPattern.Laptop;
import FactoryPattern.ProductTypes.Laptops;

import javax.xml.crypto.Data;

public abstract class BuyProduct {

    PaymentMethod paymentMethod;

    public BuyProduct(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public int getCashBack(int cost) {

        int cashback = paymentMethod.getCashback(cost);
        return cashback;
    }
}