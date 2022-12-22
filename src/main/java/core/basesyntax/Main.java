package core.basesyntax;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitTransactionParser;
import core.basesyntax.service.OperationHandler;
import core.basesyntax.service.ReaderService;
import core.basesyntax.service.impl.FruitTransactionParserImpl;
import core.basesyntax.service.impl.ReaderServiceImpl;
import core.basesyntax.service.impl.handlers.BalanceOperationHandlerImpl;
import core.basesyntax.service.impl.handlers.PurchaseOperationHandlerImpl;
import core.basesyntax.service.impl.handlers.ReturnOperationHandlerImpl;
import core.basesyntax.service.impl.handlers.SupplyOperationHandlerImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String inputCsvPath = "src/main/resources/input.csv";
    private static final String reportCsvPath = "src/main/resources/report.csv";

    public static void main(String[] args) {
        //Create
        ReaderService readerService = new ReaderServiceImpl();
        List<String> dataFromInputCsv = readerService.readFromFile(inputCsvPath);
        System.out.println(dataFromInputCsv);
        FruitTransactionParser parser = new FruitTransactionParserImpl();
        List<FruitTransaction> fruitTransactionsList
                = parser.getFruitTransactionsList(dataFromInputCsv);
        System.out.println(fruitTransactionsList);
        //Filling   Map<FruitTransaction.Operation, OperationHandler> strategies
        Map<FruitTransaction.Operation, OperationHandler> strategies = new HashMap<>();
        strategies.put(FruitTransaction.Operation.BALANCE, new BalanceOperationHandlerImpl());
        strategies.put(FruitTransaction.Operation.SUPPLY, new SupplyOperationHandlerImpl());
        strategies.put(FruitTransaction.Operation.PURCHASE, new PurchaseOperationHandlerImpl());
        strategies.put(FruitTransaction.Operation.RETURN, new ReturnOperationHandlerImpl());
    }
}
