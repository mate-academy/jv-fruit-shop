package core.basesyntax.service.impl;

import core.basesyntax.dao.GoodsDao;
import core.basesyntax.model.Accountable;
import core.basesyntax.service.ShopService;
import core.basesyntax.strategy.AccountHandler;
import core.basesyntax.strategy.AccountStrategy;
import core.basesyntax.strategy.AccountType;
import java.util.List;
import java.util.stream.Collectors;

public class ShopServiceImpl implements ShopService {
    private static final int ACCOUNT_HANDLER_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int AMOUNT_INDEX = 2;

    private final GoodsDao fruitDao;
    private final AccountStrategy accountStrategy;

    public ShopServiceImpl(GoodsDao fruitDao, AccountStrategy accountStrategy) {
        this.fruitDao = fruitDao;
        this.accountStrategy = accountStrategy;
    }

    @Override
    public List<String[]> process(List<String[]> transactions) {
        for (String[] transaction : transactions) {
            AccountHandler handler = accountStrategy.get(
                    AccountType.fromCode(transaction[ACCOUNT_HANDLER_INDEX])
            );

            boolean isExist = fruitDao.isExist(transaction[FRUIT_INDEX]);

            Accountable fruit = isExist
                    ? fruitDao.get(transaction[FRUIT_INDEX])
                    : fruitDao.create(transaction[FRUIT_INDEX]);
            handler.account(fruit, Integer.parseInt(transaction[AMOUNT_INDEX]));
        }

        return fruitDao.getAll().stream()
                .map(fruit -> new String[]{
                        fruit.getName(),
                        String.valueOf(fruit.getAmount())
                })
                .collect(Collectors.toList());
    }
}
