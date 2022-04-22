package core.basesyntax;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.operation.OperationService;
import core.basesyntax.service.operation.OperationServiceImpl;
import core.basesyntax.service.parse.ParserService;
import core.basesyntax.service.parse.ParserServiceImpl;
import core.basesyntax.service.read.ReaderService;
import core.basesyntax.service.read.ReaderServiceImpl;
import core.basesyntax.service.report.ReportService;
import core.basesyntax.service.report.ReportServiceImpl;
import core.basesyntax.service.write.WriterService;
import core.basesyntax.service.write.WriterServiceImpl;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        new WriterServiceImpl().write("input.csv","type,fruit,quantity\n"
                + "b,banana,18\n"
                + "b,apple,100\n"
                + "s,banana,14\n"
                + "p,banana,15\n"
                + "r,apple,10\n"
                + "p,apple,50\n"
                + "p,banana,5\n"
                + "s,banana,544");
        doTask("input.csv", "report.csv");
    }

    private static void doTask(String fromFile, String toFile) {
        ReaderService readerService = new ReaderServiceImpl();
        ParserService parserService = new ParserServiceImpl();
        OperationService operationService = new OperationServiceImpl();
        ReportService reportService = new ReportServiceImpl();
        WriterService writerService = new WriterServiceImpl();

        List<String> data = readerService.readFile(fromFile);
        List<FruitTransaction> transactions = parserService.parse(data);
        operationService.process(transactions);
        String report = reportService.createReport();
        writerService.write(toFile, report);
    }

}
