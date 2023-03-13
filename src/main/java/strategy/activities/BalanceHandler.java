package strategy.activities;

public class BalanceHandler implements ActivitiesHandler {
    @Override
    public Integer operation(int quantity) {
        return quantity;
    }
}
