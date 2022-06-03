package service;

public class AmountHandlerSupply implements AmountHandler {
    @Override
    public Double getAmount(Double productAmount) {
        return Double.valueOf(productAmount);
    }
}
