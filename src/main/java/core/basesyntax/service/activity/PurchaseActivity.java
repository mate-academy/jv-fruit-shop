package core.basesyntax.service.activity;

public class PurchaseActivity implements Activity {
    @Override
    public int getActivity(int amount) {
        return -amount;
    }
}
