package core.basesyntax;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FormatParserService;
import core.basesyntax.service.ReadFromFileService;
import core.basesyntax.service.ReportService;
import core.basesyntax.service.WriteToFileService;
import core.basesyntax.service.impl.FormatParserServiceImpl;
import core.basesyntax.service.impl.ReadFromFileServiceImpl;
import core.basesyntax.service.impl.ReportServiceImpl;
import core.basesyntax.service.impl.WriteToFileImpl;
import core.basesyntax.strategy.StrategyOperation;
import core.basesyntax.strategy.impl.StrategyOperationImpl;
import java.util.List;

public class Main {
    private static final String FROM_FILE_NAME = "src/main/java/data.csv";
    private static final String REPORT_FILE_NAME = "src/main/java/fruitReport.csv";

    public static void main(String[] args) {
        ReadFromFileService readFromFileService = new ReadFromFileServiceImpl();
        String inputData = readFromFileService.readFromFile(FROM_FILE_NAME);

        FormatParserService csvFormatParserService = new FormatParserServiceImpl();
        List<FruitTransaction> fruitTransactions = csvFormatParserService.parseData(inputData);

        StrategyOperation strategyOperation = new StrategyOperationImpl();

        for (FruitTransaction fruitTransaction : fruitTransactions) {
            strategyOperation.handle(fruitTransaction);
        }

        ReportService reportService = new ReportServiceImpl();
        String report = reportService.createReport(Storage.getAll());

        WriteToFileService writeToFileService = new WriteToFileImpl();
        writeToFileService.writeDataToFile(REPORT_FILE_NAME, report);

    }
}
