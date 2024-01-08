package core.basesyntax;

import core.basesyntax.service.impl.DataParserImpl;
import core.basesyntax.service.impl.FileReaderImpl;
import core.basesyntax.service.impl.FruitOperationStrategy;
import core.basesyntax.service.impl.ReportServiceImpl;

public class Main {

    public static void main(String[] args) {
        FileReaderImpl readerService = new FileReaderImpl();
        DataParserImpl parserService = new DataParserImpl();
        FruitOperationStrategy strategy = new FruitOperationStrategy();
        ReportServiceImpl reportService = new ReportServiceImpl();

        parserService.parse(readerService.read("fruits.csv"))
                .forEach(t -> strategy.getOperationService(t).processOperation(t));

        reportService.createReport();
    }
}
