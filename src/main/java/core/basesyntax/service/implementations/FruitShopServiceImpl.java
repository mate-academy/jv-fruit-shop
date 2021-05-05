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
    public void saveData(List<TransactionDto> data) {
        for (TransactionDto fruit : data) {
            OperationHandler handler = handlers.get(fruit.getOperationType());
            int amount = handler.apply(fruit.getQuantity(), fruit.getFruit());
            fruitDao.add(fruit.getFruit(), amount);
        }
    }

    @Override
    public String createReport() {
        StringBuilder buildReport = new StringBuilder();
        buildReport.append(TITLE).append(System.lineSeparator());
        for (Map.Entry<Fruit, Integer> entry : fruitDao.getAll().entrySet()) {
            buildReport.append(entry.getKey().getName())
                    .append(SEPARATOR)
                    .append(entry.getValue())
                    .append(System.lineSeparator());
        }
        return buildReport.toString();
    }
}
