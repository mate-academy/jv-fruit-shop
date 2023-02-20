package core.basesyntax;

import core.basesyntax.model.FruitReportGenerator;
import core.basesyntax.service.ReaderService;
import core.basesyntax.service.WriterService;
import core.basesyntax.service.factory.ServiceFactory;
import core.basesyntax.service.impl.WriterServiceImpl;

public class Main {
    public static void main(String[] args) {
        ReaderService readerService = ServiceFactory.createReaderService();
        readerService.readFromFileIntoStorage("src/main/resources/input.txt");
        FruitReportGenerator reportGenerator = new FruitReportGenerator();
        String report = reportGenerator.generateReport();
        WriterService writerService = new WriterServiceImpl();
        writerService.writeTextToFile(report, "src/main/resources/output.txt");
    }
}
