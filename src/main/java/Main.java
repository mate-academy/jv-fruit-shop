import db.Storage;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import model.FruitTransaction;
import service.CsvFileReaderService;
import service.CsvFileWriterService;
import service.FruitService;
import service.FruitTransactionParser;
import service.impl.CsvFileReaderServiceImpl;
import service.impl.CsvFileWriterServiceImpl;
import service.impl.FruitServiceImpl;
import service.impl.FruitTransactionParserImpl;
import strategy.OperationHandler;
import strategy.handlers.BalanceHandler;
import strategy.handlers.PurchaseHandler;
import strategy.handlers.ReturnHandler;
import strategy.handlers.SupplyHandler;

public class Main {
    public static void main(String[] args) {
        CsvFileReaderService readerService = new CsvFileReaderServiceImpl();
        FruitTransactionParser parser = new FruitTransactionParserImpl();

        Map<FruitTransaction.Operation, OperationHandler> operationHandlers = new HashMap<>();
        operationHandlers.put(FruitTransaction.Operation.BALANCE, new BalanceHandler());
        operationHandlers.put(FruitTransaction.Operation.SUPPLY, new SupplyHandler());
        operationHandlers.put(FruitTransaction.Operation.PURCHASE, new PurchaseHandler());
        operationHandlers.put(FruitTransaction.Operation.RETURN, new ReturnHandler());

        FruitService fruitService = new FruitServiceImpl(operationHandlers);

        List<String> lines = readerService.readFromFile("src/input.txt");
        List<FruitTransaction> transactions = lines.stream()
                .skip(1) // skip header line
                .map(parser::parse)
                .collect(Collectors.toList());

        for (FruitTransaction transaction : transactions) {
            fruitService.applyTransaction(transaction);
        }

        List<String> report = Storage.fruitStorage.entrySet().stream()
                .map(entry -> entry.getKey() + "," + entry.getValue())
                .collect(Collectors.toList());
        report.add(0, "fruit,quantity"); // add header line

        CsvFileWriterService writerService = new CsvFileWriterServiceImpl();
        writerService.writeToFile("src/output.txt", report);
    }
}
