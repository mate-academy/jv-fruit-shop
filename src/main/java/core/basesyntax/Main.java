package core.basesyntax;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import service.ReadFromFile;
import service.ReadFromFileImpl;
import service.StoreService;
import service.StoreServiceImpl;
import service.Validator;
import service.ValidatorImpl;
import service.WriteToFile;
import service.WriteToFileImpl;
import strategy.transactionhandler.BalanceTransactionHandler;
import strategy.transactionhandler.PurchaseTransactionHandler;
import strategy.transactionhandler.ReturnSupplyTransactionHandler;
import strategy.transactionhandler.TransactionHandler;

public class Main {
    private static final String INPUT_PATH = "src/main/resources/input.csv";

    public static void main(String[] args) {
        Map<String, TransactionHandler> transactionStrategyMap = new HashMap<>();
        transactionStrategyMap.put("b", new BalanceTransactionHandler());
        transactionStrategyMap.put("s", new ReturnSupplyTransactionHandler());
        transactionStrategyMap.put("p", new PurchaseTransactionHandler());
        transactionStrategyMap.put("r", new ReturnSupplyTransactionHandler());

        ReadFromFile fileReader = new ReadFromFileImpl();
        List<String> valueFromFile = fileReader.readFromFile(INPUT_PATH);
        Validator validate = new ValidatorImpl();
        valueFromFile.remove(0);
        valueFromFile.stream()
                .map(validate::parse)
                .forEach(t -> transactionStrategyMap.get(t.getTransactionName()).operate(t));

        StoreService fruitReport = new StoreServiceImpl();
        String report = fruitReport.getReport();

        WriteToFile writeReport = new WriteToFileImpl();
        writeReport.writeToFile(INPUT_PATH, report);
    }
}
