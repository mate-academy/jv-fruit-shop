package core.basesyntax;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.*;
import core.basesyntax.service.impl.*;

import java.util.List;

public class Main {
    private static final String PATH_TO_INPUT_FILE = "src/main/resources/input.csv";
    private static final String PATH_TO_REPORT_FILE = "src/main/resources/report.csv";
    private static final ReaderService reader = new ReaderServiceImpl();
    private static final ParserService parser = new ParseServiceImpl();
    private static final FruitShopService fruitShopService = new FruitShopServiceImpl();
    private static final ReportMakerService reportMakerService = new ReportMakerServiceImpl();
    private static final WriterService writer = new WriterServiceImpl();

    public static void main(String[] args) {
        List<String> stringsFromFile = reader.readFromFile(PATH_TO_INPUT_FILE);
        List<FruitTransaction> transactions = parser.parse(stringsFromFile);
        fruitShopService.processData(transactions);
        String report = reportMakerService.report();
        writer.writeToFile(PATH_TO_REPORT_FILE, report);
    }
}
