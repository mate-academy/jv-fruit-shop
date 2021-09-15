package service.activities;

public class ReturnActivity implements Activities {

    @Override
    public int apply(int quantity) {
        return quantity;
    }
}
