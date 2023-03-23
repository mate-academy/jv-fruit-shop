package core.basesyntax;

import core.basesyntax.dao.TransactionDao;
import core.basesyntax.dao.TransactionDaoImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.filereader.FileParser;
import core.basesyntax.service.filereader.FileParserImpl;
import core.basesyntax.service.filereader.FileReader;
import core.basesyntax.service.filereader.FileReaderImpl;
import core.basesyntax.service.filewriter.FileWriter;
import core.basesyntax.service.filewriter.FileWriterImpl;
import core.basesyntax.service.interfaces.strategy.TransactionHandler;
import core.basesyntax.service.interfaces.strategy.TransactionStrategy;
import core.basesyntax.service.transactions.PurchaseTransactionHandler;
import core.basesyntax.service.transactions.ReturnTransactionHandler;
import core.basesyntax.service.transactions.SupplyTransactionHandler;
import core.basesyntax.service.transactions.TransactionStrategyImpl;
import core.basesyntax.service.transactions.BalanceTransactionHandler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String INPUT_FILE = "src/main/resources/input.csv";
    private static final String REPORT_FILE = "src/main/resources/report.csv";
    private static final FileReader fileReader = new FileReaderImpl();
    private static final FileWriter fileWriter =
            new FileWriterImpl(new TransactionDaoImpl());
    private static final FileParser fileParser = new FileParserImpl();
    private static final TransactionDao transactionDao =
            new TransactionDaoImpl(new TransactionStrategyImpl(createOperationsMap()));

    public static void main(String[] args) {
        TransactionStrategy transactionStrategy = new TransactionStrategyImpl(createOperationsMap());
        TransactionDao transactionDao1 = new TransactionDaoImpl(transactionStrategy);
        FileWriter fileWriter1 = new FileWriterImpl(transactionDao1);
        List<String> dataFromFile = fileReader.dataFromFile(INPUT_FILE);
        List<FruitTransaction> parsedDataFromFile =
                fileParser.parsedFruitTransactions(dataFromFile);
        transactionDao.addAll(parsedDataFromFile);
        fileWriter.writeToFile(REPORT_FILE);
    }

    public static Map<FruitTransaction.Operation, TransactionHandler> createOperationsMap() {
        Map<FruitTransaction.Operation, TransactionHandler> operationsMap = new HashMap<>();
        operationsMap.put(FruitTransaction.Operation.BALANCE, new BalanceTransactionHandler());
        operationsMap.put(FruitTransaction.Operation.RETURN, new ReturnTransactionHandler());
        operationsMap.put(FruitTransaction.Operation.PURCHASE, new PurchaseTransactionHandler());
        operationsMap.put(FruitTransaction.Operation.SUPPLY, new SupplyTransactionHandler());
        return operationsMap;
    }
}
