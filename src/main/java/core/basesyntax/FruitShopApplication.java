package core.basesyntax;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.DailyReportFileReader;
import core.basesyntax.service.DailyReportFileWriter;
import core.basesyntax.service.StorageParser;
import core.basesyntax.service.SurplusCalculator;
import core.basesyntax.service.impl.DailyReportFileReaderImpl;
import core.basesyntax.service.impl.DailyReportFileWriterImpl;
import core.basesyntax.service.impl.StorageParserImpl;
import core.basesyntax.service.impl.SurplusCalculatorImpl;
import core.basesyntax.storage.TemporaryStorage;
import java.nio.file.Path;
import java.util.List;

public class FruitShopApplication {
    private static final Path FILE_FOR_READ_PATH =
            Path.of("src/main/resources/operationsByDay.csv");
    private static final Path FILE_FOR_WRITE_PATH =
            Path.of("src/main/resources/dailyStatistic.csv");

    public static void main(String[] args) {
        DailyReportFileReader dailyReportFileReader = new DailyReportFileReaderImpl();
        List<FruitTransaction> dailyOperations =
                dailyReportFileReader.readDailyReport(FILE_FOR_READ_PATH);

        SurplusCalculator surplusCalculator = new SurplusCalculatorImpl();
        surplusCalculator.calculateData(dailyOperations);

        StorageParser storageParser = new StorageParserImpl();
        String data = storageParser.parseStorage(TemporaryStorage.temporaryStorage);

        DailyReportFileWriter dailyReportFileWriter = new DailyReportFileWriterImpl();
        dailyReportFileWriter.writeDailyStatistic(FILE_FOR_WRITE_PATH, data);
    }
}
