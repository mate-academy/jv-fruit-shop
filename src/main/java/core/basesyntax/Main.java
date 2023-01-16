package core.basesyntax;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import service.FileService;
import service.FileServiceImpl;
import service.StoreService;
import service.StoreServiceImpl;
import service.TransactionParser;
import service.TransactionParserImpl;
import strategy.transactionhandler.BalanceTransactionHandler;
import strategy.transactionhandler.PurchaseTransactionHandler;
import strategy.transactionhandler.ReturnSupplyTransactionHandler;
import strategy.transactionhandler.TransactionHandler;

public class Main {
    private static final String INPUT_PATH = "src/main/resources/input.csv";
    private static final String OUTPUT_PATH = "src/main/resources/output.csv";

    public static void main(String[] args) {
        Map<String, TransactionHandler> transactionStrategyMap = new HashMap<>();
        transactionStrategyMap.put("b", new BalanceTransactionHandler());
        transactionStrategyMap.put("s", new ReturnSupplyTransactionHandler());
        transactionStrategyMap.put("p", new PurchaseTransactionHandler());
        transactionStrategyMap.put("r", new ReturnSupplyTransactionHandler());

        FileService file = new FileServiceImpl();
        List<String> valueFromFile = file.readFromFile(INPUT_PATH);
        TransactionParser validate = new TransactionParserImpl();

        valueFromFile.stream()
                .map(validate::parse)
                .forEach(t -> transactionStrategyMap.get(t.getTransactionName()).operate(t));

        StoreService fruitReport = new StoreServiceImpl();
        String report = fruitReport.getService();

        file.writeToFile(OUTPUT_PATH, report);
    }
}
