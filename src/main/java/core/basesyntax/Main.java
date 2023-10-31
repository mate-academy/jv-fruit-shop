package core.basesyntax;

import core.basesyntax.service.DataHandlerService;
import core.basesyntax.service.FileReaderService;
import core.basesyntax.service.ReportGeneratorService;
import core.basesyntax.service.impl.DataHandlerServiceImpl;
import core.basesyntax.service.impl.FileReaderServiceImpl;
import core.basesyntax.service.impl.ReportGeneratorServiceImpl;

public class Main {
    public static void main(String[] args) {
        FileReaderService fileReaderService = new FileReaderServiceImpl();
        DataHandlerService dataHandlerService = new DataHandlerServiceImpl();
        ReportGeneratorService reportGeneratorService = new ReportGeneratorServiceImpl();
        String report = dataHandlerService.calculateInputData(fileReaderService.readInputData());
        reportGeneratorService.generateReport(report);
    }
}
