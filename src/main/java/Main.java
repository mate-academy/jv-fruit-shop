import core.basesyntax.service.CsvFileReaderService;
import core.basesyntax.service.CsvFileReaderServiceImpl;
import core.basesyntax.service.CsvFileWriterService;
import core.basesyntax.service.CsvFileWriterServiceImpl;
import core.basesyntax.service.FruitTransaction;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.OperationStrategyImpl;
import core.basesyntax.strategy.operation.BalanceOperationHandler;
import core.basesyntax.strategy.operation.OperationHandler;
import core.basesyntax.strategy.operation.PurchaseOperationHandler;
import core.basesyntax.strategy.operation.ReturnOperationHandler;
import core.basesyntax.strategy.operation.SupplyOperationHandler;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String DIRECTORY_PATH = "src/main/resources";
    private static final String INPUT_FILE_PATH = "src/main/resources/inputFile.csv";
    private static final String OUTPUT_FILE_PATH = "src/main/resources/outputFile.csv";

    public static void main(String[] args) {
        createTransactionReport();

        //OperationStrategy map used to store Handlers for each operation type
        Map<FruitTransaction.Operation, OperationHandler> operationHandlerMap = new HashMap<>();
        operationHandlerMap.put(FruitTransaction.Operation.BALANCE,
                new BalanceOperationHandler());
        operationHandlerMap.put(FruitTransaction.Operation.SUPPLY,
                new SupplyOperationHandler());
        operationHandlerMap.put(FruitTransaction.Operation.PURCHASE,
                new PurchaseOperationHandler());
        operationHandlerMap.put(FruitTransaction.Operation.RETURN,
                new ReturnOperationHandler());

        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlerMap);

        //Creating object of CsvFileReaderService in order to receive data to FruitStorage
        CsvFileReaderService readerService = new CsvFileReaderServiceImpl();
        List<FruitTransaction> fruitTransactions = readerService.readFromFile(INPUT_FILE_PATH);

        fruitTransactions
                .forEach(transaction -> operationStrategy
                        .get(transaction.getOperation())
                        .doTransaction(transaction));

        //Creating object of CsvFileWriterService
        //in order to place data from FruitStorage to outputFile
        CsvFileWriterService writerService = new CsvFileWriterServiceImpl();
        writerService.writeToFile(OUTPUT_FILE_PATH);
    }

    private static void createTransactionReport() {
        File inputFile = new File(INPUT_FILE_PATH);
        String[] fruitShopData = new String[]{"type,fruit,quantity",
                "b,banana,20",
                "b,apple,100",
                "s,banana,100",
                "p,banana,13",
                "r,apple,10",
                "p,apple,20",
                "p,banana,5",
                "s,banana,50"};
        File folder = new File(DIRECTORY_PATH);
        folder.mkdir();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(inputFile))) {
            for (String data: fruitShopData) {
                writer.write(data);
                writer.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't create new file", e);
        }
    }
}

