package core.basesyntax;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.dao.StorageDaoImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.parse.Parser;
import core.basesyntax.service.parse.ParserImpl;
import core.basesyntax.service.read.ReaderService;
import core.basesyntax.service.read.ReaderServiceImpl;
import core.basesyntax.service.report.ReportServiceImpl;
import core.basesyntax.service.validator.Validator;
import core.basesyntax.service.validator.ValidatorImpl;
import core.basesyntax.service.write.WriterServiceImpl;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.Strategy;
import java.util.List;

public class Main {
    private static final String SOURCE_FILE_PATH = "src/main/java/resources/input.csv";
    private static final String RESULT_FILE_PATH = "src/main/java/resources/output.csv";

    public static void main(String[] args) {
        Validator validator = new ValidatorImpl();
        ReaderService readerService = new ReaderServiceImpl();
        List<String> data = readerService.read(SOURCE_FILE_PATH);
        validator.validate(data);
        Parser parser = new ParserImpl();
        StorageDao fruitStorageDao = new StorageDaoImpl();
        Strategy strategy = new Strategy(fruitStorageDao);
        List<FruitTransaction> fruitTransactions = parser.parse(data);
        for (FruitTransaction fruitTransaction : fruitTransactions) {
            String operation = fruitTransaction.getOperation();
            OperationHandler operationHandler = strategy.get(operation);
            operationHandler.apply(fruitTransaction.getFruit(), fruitTransaction.getQuantity());
        }
        String report = new ReportServiceImpl().createReport(fruitStorageDao.getAll());
        new WriterServiceImpl().write(RESULT_FILE_PATH, report);
    }
}

