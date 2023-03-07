package core.basesyntax.service.operator;

import core.basesyntax.dao.FruitShopDao;
import core.basesyntax.dao.FruitShopDaoImpl;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.Transaction;
import core.basesyntax.service.fileoperations.FileService;
import core.basesyntax.service.fileoperations.FileServiceImpl;
import core.basesyntax.service.transactions.strategy.TransactionStrategy;
import core.basesyntax.service.transactions.strategy.TransactionStrategyImpl;
import java.util.List;
import java.util.stream.Collectors;

public class OperatorImpl implements Operator {
    private static final String CSV_SEPARATOR = ",";
    private static final String LINE_SEPARATOR = System.lineSeparator();
    private final TransactionStrategy transactionStrategy = new TransactionStrategyImpl();
    private final FileService fileService = new FileServiceImpl();
    private final FruitShopDao dao = new FruitShopDaoImpl();

    public OperatorImpl() {
    }

    @Override
    public int openShift() {
        List<String> dataList = fileService.readData();
        dataList.remove(0);
        if (dataList.size() > 0) {
            dataList.stream()
                    .map(s -> s.split(CSV_SEPARATOR))
                    .filter(s -> Integer.parseInt(s[2]) > 0)
                    .map(s -> new Transaction(Transaction.TransactionType.getAsConstant(s[0]),
                            new Fruit(Fruit.FruitType.getAsConstant(s[1])),
                            Integer.parseInt(s[2])))
                    .collect(Collectors.toList())
                    .forEach(this::newTransaction);
        }
        return dao.getDbSize();
    }

    @Override
    public int closeShift() {
        StringBuilder builder = new StringBuilder();
        builder.append("fruit,quantity").append(LINE_SEPARATOR);
        dao.getRecords().entrySet().stream()
                .filter(e -> e.getValue() > 0)
                .map(e -> builder.append(e.getKey().getFruitType().getAsString())
                        .append(CSV_SEPARATOR)
                        .append(e.getValue())
                        .append(LINE_SEPARATOR)
                        .toString())
                .forEach(fileService::writeData);
        return dao.getDbSize();
    }

    @Override
    public void newTransaction(Transaction transaction) {
        transactionStrategy.getTransactionHandler(transaction.getTransactionType())
                .processTransaction(transaction);
    }
}
