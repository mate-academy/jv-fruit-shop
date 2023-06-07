package core.basesyntax;

import core.basesyntax.db.FruitShopStorage;
import core.basesyntax.handler.BalanceOperationHandler;
import core.basesyntax.handler.OperationHandler;
import core.basesyntax.handler.PurchaseOperationHandler;
import core.basesyntax.handler.ReturnOperationHandler;
import core.basesyntax.handler.SupplyOperationHandler;
import core.basesyntax.impl.FillFruitShopStorageImpl;
import core.basesyntax.impl.GetOperationStrategyImpl;
import core.basesyntax.impl.ParsingReaderServiceImpl;
import core.basesyntax.impl.ParsingReportServiceImpl;
import core.basesyntax.impl.ReaderServiceImpl;
import core.basesyntax.impl.WriterServiceImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FillFruitShopStorage;
import core.basesyntax.service.GetOperationStrategy;
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
        OperationHandler balanceOperationHandler = new BalanceOperationHandler();
        OperationHandler purchaseOperationHandler = new PurchaseOperationHandler();
        OperationHandler supplyOperationHandler = new SupplyOperationHandler();
        OperationHandler returnOperationHandler = new ReturnOperationHandler();
        operationTypeMap.put(Operation.BALANCE, balanceOperationHandler);
        operationTypeMap.put(Operation.SUPPLY, supplyOperationHandler);
        operationTypeMap.put(Operation.RETURN, returnOperationHandler);
        operationTypeMap.put(Operation.PURCHASE, purchaseOperationHandler);
        List<String> value = new ReaderServiceImpl()
                .getValueFromFile(PATH_INPUT_FILE);
        List<FruitTransaction> fruitTransactionList = new ParsingReaderServiceImpl()
                .getParsingValueFromFile(value);
        FruitShopStorage fruitShopStorage = new FruitShopStorage();
        GetOperationStrategy getOperationStrategy = new GetOperationStrategyImpl(operationTypeMap);
        FillFruitShopStorage fillFruitShopStorage = new FillFruitShopStorageImpl(
                getOperationStrategy,
                fruitShopStorage);
        fillFruitShopStorage.fillFruitShopStorage(fruitTransactionList);
        WriterService writerService = new WriterServiceImpl();
        String valueToWrite = new ParsingReportServiceImpl()
                .getValueToWrite(fruitShopStorage);
        writerService.writeValueToFile(PATH_OUTPUT_FILE, valueToWrite);
    }
}
