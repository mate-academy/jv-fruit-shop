package service;

public class AmountHandlerBalance implements AmountHandler {
    @Override
    public Double getAmount(Double productAmount) {
        return Double.valueOf(productAmount);
    }
}
