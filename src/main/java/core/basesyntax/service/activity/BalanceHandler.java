package core.basesyntax.service.activity;

public class BalanceHandler implements ActivityHandler {
    @Override
    public boolean doActivity(String[] fruits) {
        return fruitsDao.add(fruits);
    }
}
