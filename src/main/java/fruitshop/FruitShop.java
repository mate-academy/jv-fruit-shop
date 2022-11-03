package fruitshop;

import fruitshop.dao.FruitShopStorageDaoImpl;
import fruitshop.model.Operation;
import fruitshop.service.files.impl.CsvFileReaderServiceImpl;
import fruitshop.service.files.impl.CsvFileWriterServiceImpl;
import fruitshop.service.impl.ReportGeneratorServiceImpl;
import fruitshop.service.impl.TransactionsCalculatorServiceImpl;
import fruitshop.service.parsers.impl.CsvParserImpl;
import fruitshop.service.parsers.impl.TransactionRowParserImpl;
import fruitshop.strategy.operation.OperationHandler;
import fruitshop.strategy.operation.handlers.impl.BalanceOperation;
import fruitshop.strategy.operation.handlers.impl.PurchaseOperation;
import fruitshop.strategy.operation.handlers.impl.ReturnOperation;
import fruitshop.strategy.operation.handlers.impl.SupplyOperation;
import fruitshop.strategy.operation.impl.OperationStrategyImpl;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

public class FruitShop {
    private static final String RESOURCES_DIRECTORY = "src/main/resources";
    private static final Path INPUT_CSV_FILE = Path.of(RESOURCES_DIRECTORY, "/input_basic.csv");
    private static final Path OUTPUT_CSV_FILE = Path.of(RESOURCES_DIRECTORY, "/report.csv");

    public static void main(String[] args) {
        FruitShopStorageDaoImpl storageDao = new FruitShopStorageDaoImpl();
        new TransactionRowParserImpl(storageDao)
                .parse(new CsvParserImpl()
                        .parse(new CsvFileReaderServiceImpl()
                                .readFromFile(INPUT_CSV_FILE)
                )
        );
        Map<Operation, ? super OperationHandler> handlers = new HashMap<>();
        handlers.put(Operation.BALANCE, new BalanceOperation());
        handlers.put(Operation.PURCHASE, new PurchaseOperation());
        handlers.put(Operation.RETURN, new ReturnOperation());
        handlers.put(Operation.SUPPLY, new SupplyOperation());
        OperationStrategyImpl operationStrategy = new OperationStrategyImpl(handlers);
        new CsvFileWriterServiceImpl()
                .writeToFile(OUTPUT_CSV_FILE, new ReportGeneratorServiceImpl()
                        .generate(
                                new TransactionsCalculatorServiceImpl(
                                        operationStrategy, storageDao
                                ).calculate()));
    }
}
