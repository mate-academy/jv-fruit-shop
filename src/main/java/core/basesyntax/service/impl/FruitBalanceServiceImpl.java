package core.basesyntax.service.impl;

import core.basesyntax.dao.FruitBalanceDao;
import core.basesyntax.model.FruitBalance;
import core.basesyntax.service.FruitBalanceService;
import java.util.Optional;

public class FruitBalanceServiceImpl implements FruitBalanceService {
    private FruitBalanceDao fruitBalanceDao;

    public FruitBalanceServiceImpl(FruitBalanceDao fruitBalanceDao) {
        this.fruitBalanceDao = fruitBalanceDao;
    }

    @Override
    public void updateFruitBalance(String fruit, int balance) {
        checkBalance(balance);
        Optional<FruitBalance> existingFruit = fruitBalanceDao.get().stream()
                .filter(fruitBalance -> fruitBalance.getFruit().equals(fruit))
                .findFirst();
        if (existingFruit.isPresent()) {
            existingFruit.get().setBalance(balance);
        } else {
            fruitBalanceDao.add(new FruitBalance(fruit, balance));
        }
    }

    private void checkBalance(int balance) {
        if (balance < 0) {
            throw new RuntimeException("Balance value can't be negative: " + balance);
        }
    }
}
