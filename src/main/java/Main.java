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
        if (args.length < 2) {
            throw new IllegalArgumentException("Please provide input and output file"
                    + "paths as arguments.");
        }

        String inputFilePath = args[0];

        CsvFileReaderService readerService = new CsvFileReaderServiceImpl();
        FruitTransactionParser parser = new FruitTransactionParserImpl();

        Map<FruitTransaction.Operation, OperationHandler> operationHandlers = new HashMap<>();
        operationHandlers.put(FruitTransaction.Operation.BALANCE, new BalanceHandler());
        operationHandlers.put(FruitTransaction.Operation.SUPPLY, new SupplyHandler());
        operationHandlers.put(FruitTransaction.Operation.PURCHASE, new PurchaseHandler());
        operationHandlers.put(FruitTransaction.Operation.RETURN, new ReturnHandler());

        FruitService fruitService = new FruitServiceImpl(operationHandlers);

        List<String> lines = readerService.readFromFile(inputFilePath);
        List<FruitTransaction> transactions = lines.stream()
                .map(parser::parse)
                .toList();

        for (FruitTransaction transaction : transactions) {
            fruitService.applyTransaction(transaction);
        }

        Map<String, Integer> reportData = fruitService.getReportData();
        List<String> report = reportData.entrySet().stream()
                .map(entry -> entry.getKey() + "," + entry.getValue())
                .collect(Collectors.toList());
        report.add(0, "fruit,quantity"); // add header line

        String outputFilePath = args[1];
        CsvFileWriterService writerService = new CsvFileWriterServiceImpl();
        writerService.writeToFile(outputFilePath, report);
    }
}
