package service.activities;

public class PurchaseHandler implements ActivitiesHandler {
    @Override
    public Integer operation(int quantity) {
        return -quantity;
    }
}
