package core.basesyntax.service;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.model.Fruit;
import core.basesyntax.service.operation.Operation;
import core.basesyntax.service.operation.OperationStrategy;
import core.basesyntax.service.work.with.file.ReadFromCsvFile;
import core.basesyntax.service.work.with.file.ReadFromCsvFileImpl;

public class ShopServiceImpl implements ShopService {
    private static final int OPERATION = 0;
    private static final int FRUIT_NAME = 1;
    private static final int AMOUNT = 2;
    private FruitDao fruitDao;
    private OperationStrategy operationStrategy;

    public ShopServiceImpl(FruitDao fruitDao, OperationStrategy operationStrategy) {
        this.fruitDao = fruitDao;
        this.operationStrategy = operationStrategy;
    }

    @Override
    public void doOperation(Fruit fruit, String fromFileName) {
        ReadFromCsvFile readFromCsvFile = new ReadFromCsvFileImpl(fruitDao, fromFileName);
        Operation operation = new Operation();
        for (int i = 0; i < readFromCsvFile.readInformationFromFile().size(); i++) {
            int amountAfterOperation = 0;
            operation.setOperation(Operation.Type.valueOf(readFromCsvFile.readInformationFromFile()
                    .get(i)[OPERATION].toUpperCase()));
            if ((readFromCsvFile.readInformationFromFile().get(i))[FRUIT_NAME]
                    .equals(fruit.getFruitName())) {
                if (Integer.parseInt(readFromCsvFile.readInformationFromFile()
                        .get(i)[AMOUNT]) < 0) {
                    throw new ArithmeticException("Amount cannot be below than zero");
                }
                amountAfterOperation = operationStrategy.get(operation.getOperation())
                        .getOperation(Integer.parseInt(readFromCsvFile.readInformationFromFile()
                                .get(i)[AMOUNT]));
            }
            fruit.setAmount(fruit.getAmount() + amountAfterOperation);
            if (fruit.getAmount() < 0) {
                throw new RuntimeException("Amount cannot be below than zero");
            }
            fruitDao.update(fruit);
        }
    }
}

