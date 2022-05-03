package core.basesyntax;

import core.basesyntax.config.Configuration;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ParserService;
import core.basesyntax.service.ReaderService;
import core.basesyntax.service.ReportService;
import core.basesyntax.service.TransactionHandler;
import core.basesyntax.service.ValidatorService;
import core.basesyntax.service.WriterService;
import core.basesyntax.service.impl.OperationHandlerImpl;
import core.basesyntax.service.impl.ParserServiceImpl;
import core.basesyntax.service.impl.ReaderServiceImpl;
import core.basesyntax.service.impl.StorageDailyReport;
import core.basesyntax.service.impl.ValidatorServiceImpl;
import core.basesyntax.service.impl.WriterServiceImpl;
import core.basesyntax.storage.StorageDao;
import core.basesyntax.storage.StorageDaoImpl;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.OperationStrategyImpl;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        StorageDao storageDao = new StorageDaoImpl();
        ReaderService reader = new ReaderServiceImpl();
        ValidatorService validatorService = new ValidatorServiceImpl();
        ParserService parser = new ParserServiceImpl(validatorService);
        OperationStrategy operationStrategy = new OperationStrategyImpl(storageDao);
        TransactionHandler fruitTransactionHandler = new OperationHandlerImpl(operationStrategy);
        ReportService reportService = new StorageDailyReport();
        WriterService writer = new WriterServiceImpl();

        List<String> lines = reader.read(Configuration.READ_PATH);
        List<FruitTransaction> transactionList = parser.parse(lines);
        fruitTransactionHandler.execute(transactionList);
        writer.write(Configuration.WRITE_PATH, reportService.makeReport(storageDao.getAll()));
    }
}
