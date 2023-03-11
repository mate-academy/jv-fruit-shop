package core.basesyntax;

import core.basesyntax.db.Storage;
import core.basesyntax.model.StorageTransaction;
import core.basesyntax.service.CalculateService;
import core.basesyntax.service.DataParserService;
import core.basesyntax.service.ReadService;
import core.basesyntax.service.ReportMakerService;
import core.basesyntax.service.WriteService;
import core.basesyntax.service.impl.CalculateServiceImpl;
import core.basesyntax.service.impl.DataParserServiceImpl;
import core.basesyntax.service.impl.ReadServiceImpl;
import core.basesyntax.service.impl.ReportMakerServiceImpl;
import core.basesyntax.service.impl.WriteServiceImpl;
import java.util.List;

public class Application {
    private static final String inputPath = "src/main/java/core/basesyntax/resource/input.cvs";
    private static final String outputPath = "src/main/java/core/basesyntax/resource/output.cvs";

    public static void main(String[] args) {
        ReadService readService = new ReadServiceImpl();
        DataParserService parserService = new DataParserServiceImpl();
        CalculateService calculateService = new CalculateServiceImpl();
        ReportMakerService reportMakerService = new ReportMakerServiceImpl();
        WriteService writeService = new WriteServiceImpl();

        List<String> data = readService.readData(inputPath);
        List<StorageTransaction> transactions = parserService.parse(data);
        calculateService.calculate(transactions);
        String report = reportMakerService.makeReport(Storage.storage);
        writeService.writeData(report, outputPath);
    }
}
