package core.basesyntax;

import core.basesyntax.dao.ProductDao;
import core.basesyntax.dao.impl.ProductDaoImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.CsvFileReaderService;
import core.basesyntax.service.CsvFileWriterService;
import core.basesyntax.service.FruitService;
import core.basesyntax.service.ParserService;
import core.basesyntax.service.ReportService;
import core.basesyntax.service.impl.CsvFileReaderServiceImpl;
import core.basesyntax.service.impl.CsvFileWriterServiceImpl;
import core.basesyntax.service.impl.FruitServiceImpl;
import core.basesyntax.service.impl.ParserServiceImpl;
import core.basesyntax.service.impl.ReportServiceImpl;
import core.basesyntax.strategy.OperationService;
import core.basesyntax.strategy.impl.OperationStrategyImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String VALID_SOURCE_PATH = "src//main//resources//Information.csv";
    private static final String INVALID_SOURCE_PATH = "src//main//resources//InvalidData.csv";
    private static final String NEGATIVE_OPERATION_SOURCE_PATH =
            "src//main//resources//ExceptionData.csv";
    private static final String WRITE_TO_FILE_PATH = "src//main//resources//Report.csv";
    private static final String EMPTY = "src//main//resources//Empty.csv";

    public static void main(String[] args) {
        CsvFileReaderService fileReaderService = new CsvFileReaderServiceImpl();
        List<String> linesFromFile = fileReaderService.readLines(EMPTY);

        Map<FruitTransaction.Operation, OperationService> strategies = new HashMap<>();
        ProductDao productDao = new ProductDaoImpl();
        final Map<FruitTransaction.Operation, OperationService> operationHandlerMap =
                new HashMap<>();
        final OperationStrategyImpl operationStrategyImpl =
                new OperationStrategyImpl(operationHandlerMap);

        ParserService parserService = new ParserServiceImpl();
        List<FruitTransaction> fruitTransactions
                = parserService.parseTransaction(linesFromFile);

        FruitService fruitService =
                new FruitServiceImpl(operationStrategyImpl);
        fruitService.process(fruitTransactions);

        ReportService reportService = new ReportServiceImpl();
        CsvFileWriterService csvFileWriterService = new CsvFileWriterServiceImpl();
        csvFileWriterService.writeToFile(WRITE_TO_FILE_PATH,
                reportService.createReport(productDao.getAll()));

    }
}
