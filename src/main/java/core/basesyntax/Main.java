package core.basesyntax;

import core.basesyntax.impl.CsvFileReaderImpl;
import core.basesyntax.impl.CsvFileWriterImpl;
import core.basesyntax.impl.FruitImpl;
import core.basesyntax.impl.ParserImpl;
import core.basesyntax.impl.ProductDaoImpl;
import core.basesyntax.impl.ReportServiceImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.CsvFileReader;
import core.basesyntax.service.CsvFileWriter;
import core.basesyntax.service.Fruit;
import core.basesyntax.service.Parser;
import core.basesyntax.service.ProductDao;
import core.basesyntax.service.ReportService;
import core.basesyntax.strategy.OperationStrategy;
import java.util.List;

public class Main {
    private static final String VALID_SOURCE_PATH = "src//main//testFiles//Correct.csv";
    private static final String INVALID_SOURCE_PATH = "src//main//testFiles//InCorrect.csv";
    private static final String NEGATIVE_OPERATION_SOURCE_PATH =
            "src//main//testFiles//NullParameters.csv";
    private static final String WRITE_TO_FILE_PATH = "src//main//resources//Report.csv";

    public static void main(String[] args) {
        CsvFileReader fileReaderService = new CsvFileReaderImpl();
        List<String> linesFromFile = fileReaderService.readLines(VALID_SOURCE_PATH);

        Parser parserService = new ParserImpl();
        List<FruitTransaction> fruitTransactions = parserService.parseTransaction(linesFromFile);

        ProductDao productDao = new ProductDaoImpl();
        OperationStrategy operationStrategy =
                new OperationStrategy(productDao);

        Fruit fruit =
                new FruitImpl(operationStrategy);
        fruit.process(fruitTransactions);

        ReportService reportService = new ReportServiceImpl();
        CsvFileWriter csvFileWriterService = new CsvFileWriterImpl();
        csvFileWriterService.writeToFile(WRITE_TO_FILE_PATH,
                reportService.createReport(productDao.getAll()));
    }
}
