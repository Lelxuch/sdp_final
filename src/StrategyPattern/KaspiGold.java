package StrategyPattern;

public class KaspiGold implements PaymentMethod{

    int cashback = 10;

    @Override
    public int getCashback(int cost) {
        return (cost / 100) * cashback;
    }
}
