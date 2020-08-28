package core.basesyntax;

import core.basesyntax.services.FileReaderService;
import core.basesyntax.services.FileWriterService;
import core.basesyntax.services.ProductCalculatorService;
import core.basesyntax.services.RecordParserService;
import core.basesyntax.services.ReportMakerService;
import java.util.List;

public class FruitShopApplication {
    public static void main(String[] args) {
        FileReaderService fileReaderService = new FileReaderService();
        List<String> stringList = fileReaderService.readLinesFromFile("inputRecords.txt");

        RecordParserService recordParserService = new RecordParserService();
        List<Record> recordList = recordParserService.parseRecords(stringList);

        Storage storage = new Storage();

        ProductCalculatorService productCalculatorService = new ProductCalculatorService(storage);
        productCalculatorService.calculateBalance(recordList);

        ReportMakerService reportMakerService = new ReportMakerService(storage);
        String report = reportMakerService.makeReport();

        FileWriterService fileWriterService = new FileWriterService();
        fileWriterService.writeLinesToFile("report.csv", report);
    }
}
