package StrategyPattern;

public class PayPal implements PaymentMethod{

    private int cashback = 5;

    @Override
    public int getCashback(int cost) {
        return (cost / 100) * cashback;
    }
}