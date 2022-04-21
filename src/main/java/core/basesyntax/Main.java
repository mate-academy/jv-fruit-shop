package core.basesyntax;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.operation.OperationService;
import core.basesyntax.service.operation.OperationServiceImpl;
import core.basesyntax.service.parse.ParseService;
import core.basesyntax.service.parse.ParseServiceImpl;
import core.basesyntax.service.read.ReadService;
import core.basesyntax.service.read.ReadServiceImpl;
import core.basesyntax.service.report.ReportService;
import core.basesyntax.service.report.ReportServiceImpl;
import core.basesyntax.service.write.WriteService;
import core.basesyntax.service.write.WriteServiceImpl;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        new WriteServiceImpl().write("input.csv","type,fruit,quantity\n"
                + "b,banana,18\n"
                + "b,apple,100\n"
                + "s,banana,14\n"
                + "p,banana,15\n"
                + "r,apple,10\n"
                + "p,apple,20\n"
                + "p,banana,5\n"
                + "s,banana,544");
        doTask("input.csv", "report.csv");
    }

    private static void doTask(String fromFile, String toFile) {
        ReadService readService = new ReadServiceImpl();
        ParseService parseService = new ParseServiceImpl();
        OperationService operationService = new OperationServiceImpl();
        ReportService reportService = new ReportServiceImpl();
        WriteService writeService = new WriteServiceImpl();

        List<String> readedStrings = readService.readFile(fromFile);
        List<FruitTransaction> parsedStrings = parseService.parse(readedStrings);
        operationService.justDoIt(parsedStrings);
        String report = reportService.createReport();
        writeService.write(toFile, report);
    }

}
