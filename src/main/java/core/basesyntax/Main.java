package core.basesyntax;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitShopService;
import core.basesyntax.service.ParserService;
import core.basesyntax.service.ReaderService;
import core.basesyntax.service.ReportMakerService;
import core.basesyntax.service.WriterService;
import core.basesyntax.service.impl.FruitShopServiceImpl;
import core.basesyntax.service.impl.ParseServiceImpl;
import core.basesyntax.service.impl.ReaderServiceImpl;
import core.basesyntax.service.impl.ReportMakerServiceImpl;
import core.basesyntax.service.impl.WriterServiceImpl;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        ReaderService reader = new ReaderServiceImpl();
        ParserService parser = new ParseServiceImpl();
        FruitShopService fruitShopService = new FruitShopServiceImpl();
        ReportMakerService reportMakerService = new ReportMakerServiceImpl();
        WriterService writer = new WriterServiceImpl();

        List<String> stringsFromFile = reader.readFromFile("input.csv");
        List<FruitTransaction> transactions = parser.parse(stringsFromFile);
        fruitShopService.processData(transactions);
        String report = reportMakerService.report();
        System.out.println(report);
        writer.writeToFile("report.csv", report);
    }
}
