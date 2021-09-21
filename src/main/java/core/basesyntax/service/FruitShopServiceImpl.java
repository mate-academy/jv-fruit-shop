package core.basesyntax.service;

import core.basesyntax.fruitdao.FruitShopDaoImpl;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.TransactionDto;
import core.basesyntax.service.operation.ShopOperationHandler;
import java.util.List;
import java.util.Map;

public class FruitShopServiceImpl implements FruitShopService {
    private static final String COLUMNS_TITLE = "fruit,quantity";
    private static final String SEPARATOR = ",";
    private static Map<Fruit, Integer> result;
    private final OperationTypeStrategy operationTypeStrategy;
    private final FruitShopDaoImpl fruitShopDao = new FruitShopDaoImpl();
    private String fileName = "src/main/resources/report.csv";

    public FruitShopServiceImpl(OperationTypeStrategy operationTypeStrategy) {
        this.operationTypeStrategy = operationTypeStrategy;
    }

    @Override
    public void report() {
        StringBuilder report = new StringBuilder(COLUMNS_TITLE)
                .append(System.lineSeparator());
        for (Map.Entry<Fruit, Integer> entry : result.entrySet()) {
            report.append(entry.getKey().getFruitName())
                    .append(SEPARATOR)
                    .append(entry.getValue())
                    .append(System.lineSeparator());
        }
        fruitShopDao.writeToFile(fileName, report.toString());
    }

    @Override
    public void saveInformation(List<TransactionDto> transactionDtoList) {
        for (TransactionDto data : transactionDtoList) {
            ShopOperationHandler shopOperationHandler
                    = operationTypeStrategy.get(data.getOperationType());
            result = shopOperationHandler.getOperationResult(data);
        }
    }
}
