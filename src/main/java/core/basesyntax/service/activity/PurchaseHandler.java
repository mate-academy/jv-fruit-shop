package core.basesyntax.service.activity;

public class PurchaseHandler implements ActivityHandler {
    @Override
    public boolean doActivity(String[] fruits) {
        return fruitsDao.remove(fruits);
    }
}
