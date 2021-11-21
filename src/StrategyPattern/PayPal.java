package StrategyPattern;

public class PayPal implements PaymentMethod{

    private int cashback = 10;

    @Override
    public int getCashback(int cost) {
        return 0;
    }
}