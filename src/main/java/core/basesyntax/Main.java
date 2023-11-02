package core.basesyntax;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImp;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.Parsing;
import core.basesyntax.service.Producer;
import core.basesyntax.service.Reader;
import core.basesyntax.service.Writer;
import core.basesyntax.service.impl.ParsingStringToFruitTransactionService;
import core.basesyntax.service.impl.ProduceMapReportService;
import core.basesyntax.service.impl.ReadFromCsvService;
import core.basesyntax.service.impl.WriteCsvService;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.OperationStrategyImp;
import core.basesyntax.strategy.handler.BalanceOperationHandler;
import core.basesyntax.strategy.handler.OperationHandler;
import core.basesyntax.strategy.handler.PurchaseOperationHandler;
import core.basesyntax.strategy.handler.ReturnOperationHandler;
import core.basesyntax.strategy.handler.SupplyOperationHandler;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    private static final String FILE_FROM = "src/main/resources/csvFile.csv";
    private static final String FILE_TO = "src/main/resources/Report.csv";

    public static void main(String[] args) {
        Map<FruitTransaction.Operation, OperationHandler> operationHandlerMap = new HashMap<>();
        List<FruitTransaction> fruits = new ArrayList<>();
        Reader reader = new ReadFromCsvService();
        Parsing parser = new ParsingStringToFruitTransactionService();
        operationHandlerMap.put(FruitTransaction.Operation.BALANCE,new BalanceOperationHandler());
        operationHandlerMap.put(FruitTransaction.Operation.PURCHASE,new PurchaseOperationHandler());
        operationHandlerMap.put(FruitTransaction.Operation.RETURN,new ReturnOperationHandler());
        operationHandlerMap.put(FruitTransaction.Operation.SUPPLY,new SupplyOperationHandler());
        OperationStrategy operationStrategy = new OperationStrategyImp(operationHandlerMap);
        List<String> fileData = reader.read(FILE_FROM);
        for (String data : fileData) {
            fruits.add(parser.parse(data));
        }
        FruitDao dataBase = new FruitDaoImp();
        dataBase.add(fruits);
        for (FruitTransaction fruit : fruits) {
            operationStrategy.get(fruit.getOperation()).doOperation(fruit);
        }
        Writer writer = new WriteCsvService();
        Producer producer = new ProduceMapReportService();
        writer.write(producer.producReport(dataBase.getStorage()), FILE_TO);
    }

}
