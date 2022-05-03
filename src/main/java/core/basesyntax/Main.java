package core.basesyntax;

import core.basesyntax.config.Configuration;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ParserService;
import core.basesyntax.service.ReaderService;
import core.basesyntax.service.ReportService;
import core.basesyntax.service.TransactionHandler;
import core.basesyntax.service.ValidationService;
import core.basesyntax.service.WriterService;
import core.basesyntax.service.impl.CsvParserImpl;
import core.basesyntax.service.impl.CsvValidatorService;
import core.basesyntax.service.impl.FileReaderImpl;
import core.basesyntax.service.impl.FileWriterImpl;
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
        ReaderService reader = new FileReaderImpl();
        ValidationService csvValidator = new CsvValidatorService();
        ParserService parser = new CsvParserImpl(csvValidator);
        OperationStrategy operationStrategy = new OperationStrategyImpl(storageDao);
        TransactionHandler fruitTransactionHandler = new FruitTransactionHandler(operationStrategy);
        ReportService reportService = new StorageDailyReport();
        WriterService writer = new FileWriterImpl();

        List<String> lines = reader.read(Configuration.READ_PATH);
        List<FruitTransaction> transactionList = parser.parse(lines);
        fruitTransactionHandler.execute(transactionList);
        writer.write(Configuration.WRITE_PATH, reportService.makeReport(storageDao.getAll()));
    }
}
