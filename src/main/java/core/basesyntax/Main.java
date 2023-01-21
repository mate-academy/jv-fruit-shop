package core.basesyntax;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.CsvFileReaderService;
import core.basesyntax.service.CsvFileWriterService;
import core.basesyntax.service.FruitDaoService;
import core.basesyntax.service.FruitService;
import core.basesyntax.service.ParseLineService;
import core.basesyntax.service.operation.BalanceHandler;
import core.basesyntax.service.operation.OperationHandler;
import core.basesyntax.service.operation.PurchaseHandler;
import core.basesyntax.service.operation.ReturnHandler;
import core.basesyntax.service.operation.SupplierHandler;
import core.basesyntax.serviceimpl.CsvFileReaderServiceImpl;
import core.basesyntax.serviceimpl.CsvFileWriterServiceImpl;
import core.basesyntax.serviceimpl.FruitDaoServiceImpl;
import core.basesyntax.serviceimpl.FruitServiceImpl;
import core.basesyntax.serviceimpl.OperationStrategyImpl;
import core.basesyntax.serviceimpl.ParseLineImpl;
import core.basesyntax.strategy.OperationStrategy;
import java.util.HashMap;
import java.util.Map;

/**
 * Feel free to remove this class and create your own.
 */
public class Main {
    public static final String FILE_INPUT = "src/main/resources/input.csv";
    public static final String FILE_REPORT = "src/main/resources/report.csv";

    public static void main(String[] args) {
        // create and fill the strategy map
        Map<FruitTransaction.Operation, OperationHandler> operationHandlerMap = new HashMap<>();
        operationHandlerMap.put(FruitTransaction.Operation.SUPPLY, new SupplierHandler());
        operationHandlerMap.put(FruitTransaction.Operation.PURCHASE, new PurchaseHandler());
        operationHandlerMap.put(FruitTransaction.Operation.RETURN, new ReturnHandler());
        operationHandlerMap.put(FruitTransaction.Operation.BALANCE, new BalanceHandler());
        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlerMap);
        FruitDaoService fruitDaoService = new FruitDaoServiceImpl();
        ParseLineService parseLine = new ParseLineImpl();
        FruitService fruitService = new FruitServiceImpl(operationStrategy);
        CsvFileReaderService csvFileReaderService = new CsvFileReaderServiceImpl();
        fruitDaoService.add(parseLine.getFruitTransaction(csvFileReaderService
                .readDatFromFileCsv(FILE_INPUT)));
        CsvFileWriterService csvFileWriteService = new CsvFileWriterServiceImpl();
        csvFileWriteService.writeDataToFileCsv(fruitService.calculateBalance(fruitDaoService.get()),
                FILE_REPORT);
    }
}
