import db.Storage;
import model.FruitTransaction;
import service.ParseService;
import service.ReaderService;
import service.TransactionProcessorService;
import service.impl.ParseServiceImpl;
import service.impl.ReaderServiceImpl;
import service.impl.TransactionProcessorServiceImpl;
import strategy.*;
import strategy.handlers.StrategyHandler;
import strategy.handlers.StrategyHandlerImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        String inputFilePath = "src/main/resources/fruitList.csv";
        String outputFilePath = "src/main/resources/output.csv";

        ReaderService readerService = new ReaderServiceImpl();

        Storage storage = new Storage();

        TransactionProcessorService processorService =
                new TransactionProcessorServiceImpl(buildStrategyMap());

        List<String> transactions =
                readerService.readFromFilesContents(inputFilePath);
        ParseServiceImpl fruitTransaction = new ParseServiceImpl();
//        FruitTransaction parseFromString = fruitTransaction.parseFromString(String.valueOf(transactions));
        List<FruitTransaction> parseFromString = new ArrayList<>();
        for (String transaction : transactions) {
            storage.addTransaction(fruitTransaction.parseFromString(transaction));
            parseFromString.add(fruitTransaction.parseFromString(transaction));
            processorService.processTransaction(parseFromString);
        }

    }

    private static Map<FruitTransaction.Operation, OperationStrategy> buildStrategyMap() {
        Map<FruitTransaction.Operation, OperationStrategy> operationStrategies = new HashMap<>();
        operationStrategies.put(FruitTransaction.Operation.BALANCE, new BalanceStrategy());
//        operationStrategies.put(FruitTransaction.Operation.SUPPLY, new SupplyStrategy());
//        operationStrategies.put(FruitTransaction.Operation.PURCHASE, new PurchaseStrategy());
//        operationStrategies.put(FruitTransaction.Operation.RETURN, new ReturnStrategy());
        return operationStrategies;
    }


//        String filePath = "src/main/resources/fruitList.csv";
//
//        ReaderService readerServiceImpl = new ReaderServiceImpl();
//        List<String> list = readerServiceImpl.readFromFilesContents(filePath);
//
//        Storage storage = new Storage();
//        ParseService parseService = new ParseServiceImpl();
//        for (String transaction : list) {
//            FruitTransaction fruitTransaction = parseService.parseFromString(transaction);
//            storage.addTransaction(fruitTransaction);
//        }
//
//        List<FruitTransaction> transactions = storage.getTransactions();
//
//
//        Map<List<FruitTransaction>, FruitStrategy> activities = new HashMap<>();

        // Print the transactions from the storage for checking, if the transactions are added to the storage
//        storage.getTransactions().forEach(transaction -> System.out.println(transaction));
    }

