package core.basesyntax;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ParserService;
import core.basesyntax.service.ReaderService;
import core.basesyntax.service.ReporterService;
import core.basesyntax.service.StoreService;
import core.basesyntax.service.WriterService;
import core.basesyntax.service.impl.ParserServiceImpl;
import core.basesyntax.service.impl.ReaderServiceImpl;
import core.basesyntax.service.impl.ReporterServiceImpl;
import core.basesyntax.service.impl.StoreServiceImpl;
import core.basesyntax.service.impl.WriterServiceImpl;
import java.util.List;

public class Application {
    private static final String PATH_TO_INPUT_FILE = "src/main/resources/input.csv";
    private static final String PATH_TO_REPORT_FILE = "src/main/resources/report.csv";
    private static final ReaderService reader = new ReaderServiceImpl();
    private static final ParserService parser = new ParserServiceImpl();
    private static final StoreService fruitShopService = new StoreServiceImpl();
    private static final ReporterService reportMakerService = new ReporterServiceImpl();
    private static final WriterService writer = new WriterServiceImpl();

    public static void main(String[] args) {
        List<String> stringsFromFile = reader.readFromFile(PATH_TO_INPUT_FILE);
        List<FruitTransaction> transactions = parser.parse(stringsFromFile);
        fruitShopService.dataProcess(transactions);
        String report = reportMakerService.report();
        writer.writeToFile(PATH_TO_REPORT_FILE, report);
    }
}
