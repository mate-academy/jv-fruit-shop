package core.basesyntax;

import core.basesyntax.dao.ProductDao;
import core.basesyntax.dao.ProjectDaoImpl;
import core.basesyntax.impl.FruitServiceImpl;
import core.basesyntax.impl.ParseDataFromServiceImpl;
import core.basesyntax.impl.ReadFromCsvSercieImpl;
import core.basesyntax.impl.ReportServiceImpl;
import core.basesyntax.impl.WriteToCsvServiceImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitService;
import core.basesyntax.service.ParseDataFromFileService;
import core.basesyntax.service.ReadFromCsvService;
import core.basesyntax.service.ReportService;
import core.basesyntax.service.WriteToCsvService;
import core.basesyntax.strategy.OperationStrategy;
import java.util.List;

public class Main {
    private static final String INPUT_FILE = "src/StoreInformation.csv";
    private static final String WRITE_FILE = "src/Report.csv";

    public static void main(String[] args) {
        ReadFromCsvService readFromCsvService = new ReadFromCsvSercieImpl();
        List<String> linesFromFile = readFromCsvService.readLines(INPUT_FILE);

        ParseDataFromFileService parseDataFromFile = new ParseDataFromServiceImpl();
        List<FruitTransaction> fruitTransactions = parseDataFromFile.parseData(linesFromFile);

        ProductDao productDao = new ProjectDaoImpl();
        OperationStrategy operationStrategy = new OperationStrategy(productDao);

        FruitService fruitService = new FruitServiceImpl(operationStrategy);
        fruitService.processTransaction(fruitTransactions);

        ReportService reportService = new ReportServiceImpl();
        WriteToCsvService writeToCsvService = new WriteToCsvServiceImpl();
        writeToCsvService.writeToFile(WRITE_FILE, reportService.createReport(productDao.getAll()));
    }
}
