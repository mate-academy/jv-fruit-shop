package core.basesyntax;

import core.basesyntax.db.BalanceStorage;
import core.basesyntax.db.impl.InMemoryBalanceStorage;
import core.basesyntax.dto.ActivityDto;
import core.basesyntax.service.ActivitiesFileParser;
import core.basesyntax.service.BalanceUpdater;
import core.basesyntax.service.FileWriter;
import core.basesyntax.service.ReportGenerator;
import core.basesyntax.service.impl.BalanceReportGenerator;
import core.basesyntax.service.impl.BalanceUpdaterImpl;
import core.basesyntax.service.impl.CsvActivitiesFileParser;
import core.basesyntax.service.impl.FileWriterImpl;
import java.util.List;

public class FruitShopApplication {
    private static final String INPUT_PATH = "src/main/resources/input.csv";
    private static final String OUTPUT_PATH = "src/main/resources/output.csv";

    public static void main(String[] args) {
        ActivitiesFileParser reader = new CsvActivitiesFileParser();
        List<ActivityDto> activities = reader.readFrom(INPUT_PATH);

        BalanceStorage balanceStorage = InMemoryBalanceStorage.getInstance();

        BalanceUpdater balanceUpdater = new BalanceUpdaterImpl(balanceStorage);
        balanceUpdater.updateFrom(activities);

        ReportGenerator reportGenerator = new BalanceReportGenerator(balanceStorage);
        List<String> report = reportGenerator.getReport();

        FileWriter writer = new FileWriterImpl();
        writer.writeTo(OUTPUT_PATH, report);
    }
}
