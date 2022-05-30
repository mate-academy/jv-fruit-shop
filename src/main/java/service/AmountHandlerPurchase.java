package service;

public class AmountHandlerPurchase implements AmountHandler {
    @Override
    public Double getAmount(Double productAmount) {
        return Double.valueOf(productAmount);
    }
}
