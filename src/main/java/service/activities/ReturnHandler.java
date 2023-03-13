package service.activities;

public class ReturnHandler implements ActivitiesHandler {
    @Override
    public Integer operation(int quantity) {
        return quantity;
    }
}
