package core.basesyntax;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FileReaderService;
import core.basesyntax.service.FileWriterService;
import core.basesyntax.service.ParserService;
import core.basesyntax.service.ReportBuilder;
import core.basesyntax.service.TransactionManager;
import core.basesyntax.service.impl.CsvFileWriter;
import core.basesyntax.service.impl.FileReaderServiceImpl;
import core.basesyntax.service.impl.FruitTransactionMapper;
import core.basesyntax.service.impl.ReportBuilderImpl;
import core.basesyntax.strategy.BalanceOperationHandler;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.OperationStrategyImpl;
import core.basesyntax.strategy.PurchaseOperationHandler;
import core.basesyntax.strategy.ReturningOperationHandler;
import core.basesyntax.strategy.SupplyOperationHandler;
import java.util.List;

public class Main {
    public static final String VALID_FILE_PATH_READ = "src/main/resources/input.csv";
    public static final String VALID_FILE_PATH_WRITE = "src/main/resources/output.csv";

    public static void main(String[] args) {
        // operation handlers
        OperationHandler balance = new BalanceOperationHandler();
        OperationHandler supply = new SupplyOperationHandler();
        OperationHandler purchase = new PurchaseOperationHandler();
        OperationHandler returning = new ReturningOperationHandler();
        List<OperationHandler> operationList = List.of(balance, supply, purchase, returning);
        // reader
        FileReaderService csvFileReaderService = new FileReaderServiceImpl();
        List<String> lineList = csvFileReaderService.readFromFile(VALID_FILE_PATH_READ);
        // parser
        ParserService<String> parserService = new FruitTransactionMapper();
        List<FruitTransaction> transactionsList = parserService.parse(lineList);
        // transaction manager
        OperationStrategy operationStrategy = new OperationStrategyImpl(operationList);
        TransactionManager transactionManager = new TransactionManager(operationStrategy);
        transactionManager.process(transactionsList);
        // create report
        ReportBuilder reportBuilder = new ReportBuilderImpl();
        String report = reportBuilder.build(Storage.dataBase);
        // write to file
        FileWriterService reportFileWriter = new CsvFileWriter();
        reportFileWriter.write(report, VALID_FILE_PATH_WRITE);
    }
}
