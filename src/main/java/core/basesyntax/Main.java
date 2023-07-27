package core.basesyntax;

import core.basesyntax.dao.Dao;
import core.basesyntax.dao.impl.DaoImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.DataConverter;
import core.basesyntax.service.DataHandler;
import core.basesyntax.service.FileReader;
import core.basesyntax.service.FileWriter;
import core.basesyntax.service.ReportCreator;
import core.basesyntax.service.impl.DataConverterImpl;
import core.basesyntax.service.impl.DataHandlerImpl;
import core.basesyntax.service.impl.FileReaderImpl;
import core.basesyntax.service.impl.FileWriterImpl;
import core.basesyntax.service.impl.ReportCreatorImpl;
import core.basesyntax.strategy.TransactionStrategy;
import core.basesyntax.strategy.impl.TransactionStrategyImpl;
import core.basesyntax.transactionhandler.TransactionHandler;
import core.basesyntax.transactionhandler.impl.BalanceHandler;
import core.basesyntax.transactionhandler.impl.PurchaseHandler;
import core.basesyntax.transactionhandler.impl.ReturnHandler;
import core.basesyntax.transactionhandler.impl.SupplyHandler;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static final String OUTPUT_FILE_PATH = "src/main/java/core/basesyntax/outputfile.csv";
    public static final String INPUT_FILE_PATH = "src/main/java/core/basesyntax/inputfile.csv";
    private static final Dao dao = new DaoImpl();
    private final static Map<FruitTransaction.Operation, TransactionHandler> transactionHandlerMap

            = new HashMap<>();
    private final static TransactionStrategy strategy
            = new TransactionStrategyImpl(transactionHandlerMap);
    private final static FileReader fileReader = new FileReaderImpl();
    private final static DataConverter converter = new DataConverterImpl();
    private final static DataHandler handler = new DataHandlerImpl(strategy);
    private final static ReportCreator reportCreator = new ReportCreatorImpl(dao);
    private final static FileWriter fileWriter = new FileWriterImpl();

    public static void main(String[] args) {
        transactionHandlerMap.put(FruitTransaction.Operation.BALANCE, new BalanceHandler(dao));
        transactionHandlerMap.put(FruitTransaction.Operation.PURCHASE, new PurchaseHandler(dao));
        transactionHandlerMap.put(FruitTransaction.Operation.RETURN, new ReturnHandler(dao));
        transactionHandlerMap.put(FruitTransaction.Operation.SUPPLY, new SupplyHandler(dao));
        List<String> dataFromFile = fileReader.readFromFile(INPUT_FILE_PATH);
        List<FruitTransaction> fruitTransactions = converter.convertData(dataFromFile);
        handler.processTransaction(fruitTransactions);
        String report = reportCreator.createReport();
        fileWriter.writeToFile(OUTPUT_FILE_PATH, report);
    }
}
