package core.basesyntax;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImp;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.Parser;
import core.basesyntax.service.Producer;
import core.basesyntax.service.Reader;
import core.basesyntax.service.Writer;
import core.basesyntax.service.impl.ParserStringToFruitTransactionService;
import core.basesyntax.service.impl.ProduceMapReportService;
import core.basesyntax.service.impl.ReadFromCsvService;
import core.basesyntax.service.impl.WriteCsvService;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.OperationStrategyImp;
import core.basesyntax.strategy.handler.BalanceHandler;
import core.basesyntax.strategy.handler.OperationHandler;
import core.basesyntax.strategy.handler.PurchaseHandler;
import core.basesyntax.strategy.handler.ReturnHandler;
import core.basesyntax.strategy.handler.SupplyHandler;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    private static final String FILE_FROM = "src/main/resources/csvFile.csv";
    private static final String FILE_TO = "src/main/resources/Report.csv";

    public static void main(String[] args) {
        Map<FruitTransaction.Operation, OperationHandler> operationHandlerMap = new HashMap<>();
        Reader reader = new ReadFromCsvService();
        FruitDao fruitDao = new FruitDaoImp();
        operationHandlerMap.put(FruitTransaction.Operation.BALANCE,new BalanceHandler(fruitDao));
        operationHandlerMap.put(FruitTransaction.Operation.PURCHASE,new PurchaseHandler(fruitDao));
        operationHandlerMap.put(FruitTransaction.Operation.RETURN,new ReturnHandler(fruitDao));
        operationHandlerMap.put(FruitTransaction.Operation.SUPPLY,new SupplyHandler(fruitDao));
        OperationStrategy operationStrategy = new OperationStrategyImp(operationHandlerMap);
        List<String> fileData = reader.read(FILE_FROM);
        List<FruitTransaction> fruitTransactions;
        Parser parser = new ParserStringToFruitTransactionService();
        fruitTransactions = parser.parse(fileData);
        fruitDao.add(fruitTransactions);
        operationStrategy.getOperations(fruitTransactions);
        Writer writer = new WriteCsvService();
        Producer producer = new ProduceMapReportService();
        writer.write(producer.produceReport(fruitDao.getStorage()), FILE_TO);
    }

}
