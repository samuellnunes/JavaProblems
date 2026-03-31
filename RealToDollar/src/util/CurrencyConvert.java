package util;

public class CurrencyConvert {

    public static double IOF = 0.06;

    public static double valuePaid(double dollarPrice, double dollarBought) {
        return dollarBought * dollarPrice * (1 + IOF);
    }

}
