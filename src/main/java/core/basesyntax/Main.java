package core.basesyntax;

import core.basesyntax.dao.ProductDao;
import core.basesyntax.dao.ProductDaoImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.CsvFileReaderService;
import core.basesyntax.service.CsvFileWriterService;
import core.basesyntax.service.DataHandlingService;
import core.basesyntax.service.ParserService;
import core.basesyntax.service.impl.CsvFileReaderServiceImpl;
import core.basesyntax.service.impl.CsvFileWriterServiceImpl;
import core.basesyntax.service.impl.DataHandlingServiceImpl;
import core.basesyntax.service.impl.ParserServiceImpl;
import core.basesyntax.strategy.OperationStrategy;
import java.util.List;

public class Main {
    private static final String VALID_SOURCE_PATH = "src//main//resources//Information.csv";
    private static final String INVALID_SOURCE_PATH = "src//main//resources//InvalidData.csv";
    private static final String NEGATIVE_OPERATION_SOURCE_PATH =
            "src//main//resources//ExceptionData.csv";
    private static final String WRITE_TO_FILE_PATH = "src//main//resources//Report.csv";

    public static void main(String[] args) {
        CsvFileReaderService fileReaderService = new CsvFileReaderServiceImpl();
        List<String> dataFromFile = fileReaderService.readLines(VALID_SOURCE_PATH);

        ParserService convertService = new ParserServiceImpl();
        List<FruitTransaction> fruitTransactions = convertService.parseTransaction(dataFromFile);

        ProductDao productDaoService = new ProductDaoImpl();
        OperationStrategy operationStrategy =
                new OperationStrategy(productDaoService);

        DataHandlingService dataHandlingService =
                new DataHandlingServiceImpl(operationStrategy);
        dataHandlingService.process(fruitTransactions);

        CsvFileWriterService csvFileWriterService = new CsvFileWriterServiceImpl();
        csvFileWriterService.writeToFile(WRITE_TO_FILE_PATH, productDaoService.getAllData());
    }
}
