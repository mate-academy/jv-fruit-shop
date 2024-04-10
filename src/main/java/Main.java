import db.Storage;
import model.FruitTransaction;
import service.ParseService;
import service.ReaderService;
import service.WriterSerivce;
import service.impl.ParseServiceImpl;
import service.impl.ReaderServiceImpl;
import service.impl.TransactionProcessorServiceImpl;
import service.impl.WriterSerivceImpl;
import strategy.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        String inputFilePath = "src/main/resources/fruitList.csv";
        String outputFilePath = "src/main/resources/output.csv";

        ReaderService readerService = new ReaderServiceImpl();
        ParseService parseService = new ParseServiceImpl();
        TransactionProcessorServiceImpl processorService =
                new TransactionProcessorServiceImpl(buildStrategyMap());
        WriterSerivce writerSerivce = new WriterSerivceImpl();

        List<String> transactions =
                readerService.readFromFilesContents(inputFilePath);

        List<FruitTransaction> parsedFromString =
                parseService.parseFromString(transactions);

        Map<String, Integer> fruitCounts = processorService.processTransaction(parsedFromString);

        writerSerivce.writeToFile(outputFilePath, fruitCounts);
    }



    private static Map<FruitTransaction.Operation, OperationStrategy> buildStrategyMap() {
        Map<FruitTransaction.Operation, OperationStrategy> operationStrategies = new HashMap<>();
        operationStrategies.put(FruitTransaction.Operation.BALANCE, new BalanceStrategy());
        operationStrategies.put(FruitTransaction.Operation.SUPPLY, new SupplyStrategy());
        operationStrategies.put(FruitTransaction.Operation.PURCHASE, new PurchaseStrategy());
        operationStrategies.put(FruitTransaction.Operation.RETURN, new ReturnStrategy());
        return operationStrategies;
    }
}