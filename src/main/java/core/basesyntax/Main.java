package core.basesyntax;

import core.basesyntax.config.Configuration;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.OperationIstrategy;
import core.basesyntax.service.ParserService;
import core.basesyntax.service.ReaderService;
import core.basesyntax.service.ReportService;
import core.basesyntax.service.TransactionHandler;
import core.basesyntax.service.ValidationService;
import core.basesyntax.service.WriterService;
import core.basesyntax.service.impl.CsvParser;
import core.basesyntax.service.impl.CsvValidator;
import core.basesyntax.service.impl.FileReader;
import core.basesyntax.service.impl.FileWriter;
import core.basesyntax.service.impl.FruitTransactionHandler;
import core.basesyntax.service.impl.StorageDailyReport;
import core.basesyntax.storage.StorageDao;
import core.basesyntax.storage.StorageDaoImpl;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.OperationStrategyImpl;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        StorageDao storageDao = new StorageDaoImpl();
        ReaderService reader = new FileReader();
        ValidationService csvValidator = new CsvValidator();
        ParserService parser = new CsvParser(csvValidator);
        OperationIstrategy operationIStrategy = new OperationIstrategy(storageDao);
        OperationStrategy operationStrategy = new OperationStrategyImpl(operationIStrategy);
        TransactionHandler fruitTransactionHandler = new FruitTransactionHandler(operationStrategy);
        ReportService reportService = new StorageDailyReport();
        WriterService writer = new FileWriter();

        List<String> lines = reader.read(Configuration.READ_PATH);
        List<FruitTransaction> transactionList = parser.parse(lines);
        fruitTransactionHandler.execute(transactionList);
        writer.write(Configuration.WRITE_PATH, reportService.makeReport(storageDao.getAll()));
    }
}
