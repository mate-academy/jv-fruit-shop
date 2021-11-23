package core.basesyntax;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.Operation;
import core.basesyntax.model.TransactionDto;
import core.basesyntax.service.Parser;
import core.basesyntax.service.impl.ParserImpl;
import core.basesyntax.service.impl.ReaderServiceImpl;
import core.basesyntax.service.impl.ReportServiceImpl;
import core.basesyntax.service.impl.WriterServiceImpl;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.OperationStrategyImpl;
import core.basesyntax.strategy.operation.BalanceOperationHandler;
import core.basesyntax.strategy.operation.OperationHandler;
import core.basesyntax.strategy.operation.PurchaseOperationHandler;
import core.basesyntax.strategy.operation.ReturnOperationHandler;
import core.basesyntax.strategy.operation.SupplyOperationHandler;
import core.basesyntax.validation.OperationValidatorImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String FROM_FILE_NAME =
            "src/main/resources/ReportDataDuringWorkingShift.csv";
    private static final String TO_FILE_NAME =
            "src/main/resources/ReportInTheEndOfTheShift.csv";

    public static void main(String[] args) {
        Map<Operation, OperationHandler> operationHandlerMap = new HashMap<>();
        operationHandlerMap.put(Operation.PURCHASE, new PurchaseOperationHandler());
        operationHandlerMap.put(Operation.SUPPLY, new SupplyOperationHandler());
        operationHandlerMap.put(Operation.RETURN, new ReturnOperationHandler());
        operationHandlerMap.put(Operation.BALANCE, new BalanceOperationHandler());
        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlerMap);
        FruitDao fruitDao = new FruitDaoImpl();
        Parser parser = new ParserImpl(new OperationValidatorImpl());
        List<String> fruitData = new ReaderServiceImpl().readFile(FROM_FILE_NAME);
        for (int i = 1; i < fruitData.size(); i++) {
            TransactionDto transactionDto = parser.parseLine(fruitData.get(i));
            Fruit fruit = new Fruit(transactionDto.getFruitName());
            fruitDao.update(fruit, operationStrategy.get(transactionDto.getOperation())
                    .getAmountToAdd(transactionDto.getQuantity()));
        }
        String report = new ReportServiceImpl(fruitDao).getReport();
        new WriterServiceImpl().writeFile(TO_FILE_NAME, report);
    }
}
