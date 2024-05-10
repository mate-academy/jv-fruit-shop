package core.basesyntax.services;

import core.basesyntax.dao.FruitsDao;
import core.basesyntax.transactions.FruitsTransaction;
import java.util.List;
import java.util.stream.Collectors;

public class FruitsServiceImpl implements FruitsService {
    private static final String LINE_SEPARATOR = System.lineSeparator();
    private final FruitsDao fruitsDao;

    public FruitsServiceImpl(FruitsDao fruitsDao) {
        this.fruitsDao = fruitsDao;
    }

    @Override
    public void processTransactions(List<FruitsTransaction> transactions) {
        transactions.stream().forEach(transaction -> {
            switch (transaction.getOperation()) {
                case BALANCE -> fruitsDao.balance(transaction.getFruit(),
                        transaction.getQuantity());
                case SUPPLY -> fruitsDao.supply(transaction.getFruit(),
                        transaction.getQuantity());
                case PURCHASE -> fruitsDao.purchase(transaction.getFruit(),
                        transaction.getQuantity());
                case RETURN -> fruitsDao.returnFruits(transaction.getFruit(),
                        transaction.getQuantity());
                default -> throw new IllegalArgumentException("Unknown operation"
                        + transaction.getOperation());
            }
        });
    }

    @Override
    public String createReport() {
        String header = "fruit,quantity" + LINE_SEPARATOR;
        String body = fruitsDao.getInventory().entrySet()
                .stream()
                .map(entry -> entry.getKey() + "," + entry.getValue())
                .collect(Collectors.joining(LINE_SEPARATOR));
        return header + body + LINE_SEPARATOR;
    }
}
