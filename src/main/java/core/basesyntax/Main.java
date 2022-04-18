package core.basesyntax;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.dao.StorageDaoImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.CsvValidator;
import core.basesyntax.service.FormatParserService;
import core.basesyntax.service.ReadFromFileService;
import core.basesyntax.service.ReportService;
import core.basesyntax.service.WriteToFileService;
import core.basesyntax.service.impl.CsvValidatorImpl;
import core.basesyntax.service.impl.FormatParserServiceImpl;
import core.basesyntax.service.impl.ReadFromFileServiceImpl;
import core.basesyntax.service.impl.ReportServiceImpl;
import core.basesyntax.service.impl.WriteToFileImpl;
import core.basesyntax.strategy.Strategy;
import core.basesyntax.strategy.impl.StrategyImpl;
import java.util.List;

public class Main {
    private static final String FROM_FILE_NAME = "src/main/java/data.csv";
    private static final String REPORT_FILE_NAME = "src/main/java/fruitReport.csv";

    public static void main(String[] args) {
        ReadFromFileService readFromFileService = new ReadFromFileServiceImpl();
        String inputData = readFromFileService.readFromFile(FROM_FILE_NAME);

        CsvValidator validator = new CsvValidatorImpl();
        validator.validate(inputData);

        FormatParserService csvFormatParserService = new FormatParserServiceImpl();
        List<FruitTransaction> fruitTransactions = csvFormatParserService.parseData(inputData);

        Strategy strategy = new StrategyImpl();

        for (FruitTransaction fruitTransaction : fruitTransactions) {
            strategy.handle(fruitTransaction);
        }

        StorageDao storageDao = new StorageDaoImpl();
        ReportService reportService = new ReportServiceImpl();
        String report = reportService.createReport(storageDao.getAll());

        WriteToFileService writeToFileService = new WriteToFileImpl();
        writeToFileService.writeToFile(REPORT_FILE_NAME, report);

    }
}
