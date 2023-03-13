package strategy.activities;

public class SupplyHandler implements ActivitiesHandler {
    @Override
    public Integer operation(int quantity) {
        return quantity;
    }
}
