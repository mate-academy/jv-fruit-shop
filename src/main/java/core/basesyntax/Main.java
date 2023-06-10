package core.basesyntax;

import core.basesyntax.db.FruitShopStorage;
import core.basesyntax.handler.BalanceOperationHandler;
import core.basesyntax.handler.OperationHandler;
import core.basesyntax.handler.PurchaseOperationHandler;
import core.basesyntax.handler.ReturnOperationHandler;
import core.basesyntax.handler.SupplyOperationHandler;
import core.basesyntax.impl.OperationStrategyImpl;
import core.basesyntax.impl.ParserReaderServiceImpl;
import core.basesyntax.impl.ProcessFruitShopStorageImpl;
import core.basesyntax.impl.ReaderServiceImpl;
import core.basesyntax.impl.ReportGeneratorServiceImpl;
import core.basesyntax.impl.WriterServiceImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ProcessFruitShopStorage;
import core.basesyntax.service.WriterService;
import core.basesyntax.util.Operation;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static final String PATH_INPUT_FILE = "src/main/resources/input.csv";
    private static final String PATH_OUTPUT_FILE = "src/main/resources/report.csv";

    public static void main(String[] args) {
        Map<Operation, OperationHandler> operationTypeMap = new HashMap<>();
        operationTypeMap.put(Operation.BALANCE, new BalanceOperationHandler());
        operationTypeMap.put(Operation.SUPPLY, new SupplyOperationHandler());
        operationTypeMap.put(Operation.RETURN, new ReturnOperationHandler());
        operationTypeMap.put(Operation.PURCHASE, new PurchaseOperationHandler());
        List<String> values = new ReaderServiceImpl()
                .readFile(PATH_INPUT_FILE);
        List<FruitTransaction> fruitTransactionList = new ParserReaderServiceImpl()
                .parse(values);
        FruitShopStorage fruitShopStorage = new FruitShopStorage();
        ProcessFruitShopStorage processFruitShopStorage = new ProcessFruitShopStorageImpl(
                new OperationStrategyImpl(operationTypeMap),
                fruitShopStorage);
        processFruitShopStorage.fillFruitShopStorage(fruitTransactionList);
        WriterService writerService = new WriterServiceImpl();
        String valuesToWrite = new ReportGeneratorServiceImpl()
                .generateReport(fruitShopStorage);
        writerService.writeValueToFile(PATH_OUTPUT_FILE, valuesToWrite);
    }
}
