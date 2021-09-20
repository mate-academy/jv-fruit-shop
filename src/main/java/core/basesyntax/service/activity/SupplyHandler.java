package core.basesyntax.service.activity;

public class SupplyHandler implements ActivityHandler {
    @Override
    public boolean doActivity(String[] fruits) {
        return fruitsDao.add(fruits);
    }
}
