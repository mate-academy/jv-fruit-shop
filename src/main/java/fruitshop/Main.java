package fruitshop;
import fruitshop.db.Storage;
import fruitshop.model.FruitTransaction;
import fruitshop.service.*;
import fruitshop.util.FileReader;
import fruitshop.util.FileReaderImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        FileReader fileReader = new FileReaderImpl();
        List<String> inputLines = fileReader.read("reportToRead.csv");

        DataConverter dataConverter = new DataConverterImpl();
        List<FruitTransaction> transactions = dataConverter.convertToTransaction(inputLines);

        Map<FruitTransaction.Operation, OperationHandler> handlers = new HashMap<>();
        handlers.put(FruitTransaction.Operation.BALANCE, new BalanceOperation());
        handlers.put(FruitTransaction.Operation.SUPPLY, new SupplyOperation());
        handlers.put(FruitTransaction.Operation.PURCHASE, new PurchaseOperation());
        handlers.put(FruitTransaction.Operation.RETURN, new ReturnOperation());

        OperationStrategy strategy = new OperationStrategy(handlers);

        ShopService shopService = new ShopService(strategy);
        shopService.processTransactions(transactions);

        Storage.getAll().forEach((fruit, quantity) ->
                System.out.println(fruit + " : " + quantity));
    }
}