package core.basesyntax;

import core.basesyntax.dao.FruitStorageDaoImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.services.FruitTransactionParser;
import core.basesyntax.services.ReportService;
import core.basesyntax.services.impl.FileReaderImpl;
import core.basesyntax.services.impl.FileWriterImpl;
import core.basesyntax.services.impl.FruitTransactionParserImpl;
import core.basesyntax.services.impl.ReportServiceImpl;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.impl.BalanceOperationHandler;
import core.basesyntax.strategy.impl.OperationStrategyImpl;
import core.basesyntax.strategy.impl.PurchaseOperationHandler;
import core.basesyntax.strategy.impl.ReturnOperationHandler;
import core.basesyntax.strategy.impl.SupplyOperationHandler;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String INPUT_FILE = "src/resources/data.txt";
    private static final String OUTPUT_FILE = "src/resources/report.txt";

    public static void main(String[] args) {
        Map<String, OperationHandler> map = new HashMap<>();
        initializeMap(map);
        OperationStrategyImpl strategy = new OperationStrategyImpl(map);
        FruitTransactionParser fruitTransactionParser = new FruitTransactionParserImpl();
        ReportService reportService = new ReportServiceImpl(new FruitStorageDaoImpl());
        FileWriterImpl fileWriterImpl = new FileWriterImpl();

        List<String> dataList = new FileReaderImpl().readFromFile(INPUT_FILE);
        List<FruitTransaction> fruitTransactionList = fruitTransactionParser
                .getTransaction(dataList);
        for (FruitTransaction fruitTransaction: fruitTransactionList) {
            OperationHandler handler = strategy.getByOperation(fruitTransaction.getOperation());
            handler.handle(fruitTransaction);
        }
        String report = reportService.createReport();
        fileWriterImpl.writeToFile(OUTPUT_FILE, report);
    }

    private static void initializeMap(Map<String, OperationHandler> map) {
        map.put("b", new BalanceOperationHandler(new FruitStorageDaoImpl()));
        map.put("s", new SupplyOperationHandler(new FruitStorageDaoImpl()));
        map.put("p", new PurchaseOperationHandler(new FruitStorageDaoImpl()));
        map.put("r", new ReturnOperationHandler(new FruitStorageDaoImpl()));
    }
}
