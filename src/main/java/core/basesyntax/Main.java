package core.basesyntax;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.dao.impl.StorageDaoImpl;
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
import java.util.List;
import java.util.Map;

public class Main {
    private static final String OUTPUT_FILE_PATH
            = "src/main/java/core/basesyntax/resources/outputfile.csv";
    private static final String INPUT_FILE_PATH
            = "src/main/java/core/basesyntax/resources/inputfile.csv";
    private static final StorageDao STORAGE_DAO = new StorageDaoImpl();
    private static Map<FruitTransaction.Operation, TransactionHandler> transactionHandlerMap
            = Map.of(FruitTransaction.Operation.BALANCE, new BalanceHandler(STORAGE_DAO),
            FruitTransaction.Operation.PURCHASE, new PurchaseHandler(STORAGE_DAO),
            FruitTransaction.Operation.RETURN, new ReturnHandler(STORAGE_DAO),
            FruitTransaction.Operation.SUPPLY, new SupplyHandler(STORAGE_DAO));
    private static TransactionStrategy strategy
            = new TransactionStrategyImpl(transactionHandlerMap);
    private static FileReader fileReader = new FileReaderImpl();
    private static DataConverter converter = new DataConverterImpl();
    private static DataHandler handler = new DataHandlerImpl(strategy);
    private static ReportCreator reportCreator = new ReportCreatorImpl(STORAGE_DAO);
    private static FileWriter fileWriter = new FileWriterImpl();

    public static void main(String[] args) {
        List<String> dataFromFile = fileReader.readFromFile(INPUT_FILE_PATH);
        List<FruitTransaction> fruitTransactions = converter.convertData(dataFromFile);
        handler.processTransaction(fruitTransactions);
        String report = reportCreator.createReport();
        fileWriter.writeToFile(OUTPUT_FILE_PATH, report);
    }
}
