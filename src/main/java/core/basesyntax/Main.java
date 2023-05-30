package core.basesyntax;

import core.basesyntax.dao.ProductDao;
import core.basesyntax.dao.ProjectDaoImpl;
import core.basesyntax.impl.CsvFileReaderServiceImpl;
import core.basesyntax.impl.CsvFileWriterServiceImpl;
import core.basesyntax.impl.FruitServiceImpl;
import core.basesyntax.impl.ParserServiceImpl;
import core.basesyntax.impl.ReportServiceImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.CsvFileReaderService;
import core.basesyntax.service.CsvFileWriterService;
import core.basesyntax.service.FruitService;
import core.basesyntax.service.ParserService;
import core.basesyntax.service.ReportService;
import core.basesyntax.strategy.OperationStrategy;
import java.util.List;

public class Main {
    private static final String INPUT_FILE = "src/StoreInformation.csv";
    private static final String WRITE_FILE = "src/Report.csv";

    public static void main(String[] args) {
        CsvFileReaderService readFromCsvService = new CsvFileReaderServiceImpl();
        List<String> linesFromFile = readFromCsvService.readLines(INPUT_FILE);

        ParserService parseDataFromFile = new ParserServiceImpl();
        List<FruitTransaction> fruitTransactions = parseDataFromFile.parseData(linesFromFile);

        ProductDao productDao = new ProjectDaoImpl();
        OperationStrategy operationStrategy = new OperationStrategy(productDao);

        FruitService fruitService = new FruitServiceImpl(operationStrategy);
        fruitService.processTransaction(fruitTransactions);

        ReportService reportService = new ReportServiceImpl();
        CsvFileWriterService writeToCsvService = new CsvFileWriterServiceImpl();
        writeToCsvService.writeToFile(WRITE_FILE, reportService.createReport(productDao.getAll()));
    }
}
