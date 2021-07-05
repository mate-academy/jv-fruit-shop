package core.basesyntax.service.implementations;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.model.Fruit;
import core.basesyntax.service.FruitShopService;
import core.basesyntax.service.OperationStrategy;
import core.basesyntax.service.dto.TransactionDto;
import core.basesyntax.service.operations.OperationHandler;
import java.util.List;
import java.util.Map;

public class FruitShopServiceImpl implements FruitShopService {
    private static final String TITLE = "fruit, quantity";
    private static final String SEPARATOR = ",";
    private final OperationStrategy handlers;
    private final FruitDao fruitDao;

    public FruitShopServiceImpl(OperationStrategy handlers, FruitDao fruitDao) {
        this.handlers = handlers;
        this.fruitDao = fruitDao;
    }

    @Override
    public void saveData(List<TransactionDto> transactionsList) {
        for (TransactionDto transaction : transactionsList) {
            OperationHandler handler = handlers.get(transaction.getOperationType());
            int quantity = handler.apply(transaction.getQuantity(), transaction.getFruit());
            fruitDao.add(transaction.getFruit(), quantity);
        }
    }

    @Override
    public String createReport() {
        StringBuilder report = new StringBuilder();
        report.append(TITLE).append(System.lineSeparator());
        for (Map.Entry<Fruit, Integer> entry : fruitDao.getAll().entrySet()) {
            report.append(entry.getKey().getName())
                    .append(SEPARATOR)
                    .append(entry.getValue())
                    .append(System.lineSeparator());
        }
        return report.toString();
    }
}
