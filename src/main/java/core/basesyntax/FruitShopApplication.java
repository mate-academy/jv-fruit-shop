package core.basesyntax;

import core.basesyntax.db.BalanceStorageDao;
import core.basesyntax.db.impl.InMemoryBalanceStorageDao;
import core.basesyntax.dto.ActivityDto;
import core.basesyntax.service.ActivityParser;
import core.basesyntax.service.BalanceUpdater;
import core.basesyntax.service.FileReader;
import core.basesyntax.service.FileWriter;
import core.basesyntax.service.ReportGenerator;
import core.basesyntax.service.impl.ActivityParserImpl;
import core.basesyntax.service.impl.BalanceReportGenerator;
import core.basesyntax.service.impl.BalanceUpdaterImpl;
import core.basesyntax.service.impl.FileReaderImpl;
import core.basesyntax.service.impl.FileWriterImpl;
import java.util.List;

public class FruitShopApplication {
    private static final String INPUT_PATH = "src/main/resources/input.csv";
    private static final String OUTPUT_PATH = "src/main/resources/output.csv";

    public static void main(String[] args) {
        FileReader reader = new FileReaderImpl();
        List<String> inputLines = reader.readFrom(INPUT_PATH);

        ActivityParser parser = new ActivityParserImpl();
        List<ActivityDto> activities = parser.parse(inputLines);

        BalanceStorageDao balanceStorage = InMemoryBalanceStorageDao.getInstance();

        BalanceUpdater balanceUpdater = new BalanceUpdaterImpl(balanceStorage);
        balanceUpdater.updateFrom(activities);

        ReportGenerator reportGenerator = new BalanceReportGenerator(balanceStorage);
        List<String> report = reportGenerator.getReport();

        FileWriter writer = new FileWriterImpl();
        writer.writeTo(OUTPUT_PATH, report);
    }
}
