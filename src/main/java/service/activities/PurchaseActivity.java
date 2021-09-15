package service.activities;

public class PurchaseActivity implements Activities {

    @Override
    public int apply(int quantity) {
        return - quantity;
    }
}
