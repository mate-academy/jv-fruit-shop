package service;

public class AmountHandlerReturn implements AmountHandler {
    @Override
    public Double getAmount(Double productAmount) {
        return Double.valueOf(-productAmount);
    }
}
