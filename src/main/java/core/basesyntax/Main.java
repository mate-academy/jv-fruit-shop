package core.basesyntax;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.operation.OperationServiceImpl;
import core.basesyntax.service.parse.ParseServiceImpl;
import core.basesyntax.service.read.ReadServiceImpl;
import core.basesyntax.service.report.ReportServiceImpl;
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
        List<String> readedStrings = new ReadServiceImpl().readFile(fromFile);
        List<FruitTransaction> parsedStrings = new ParseServiceImpl().parse(readedStrings);
        new OperationServiceImpl().justDoIt(parsedStrings);
        String report = new ReportServiceImpl().createReport();
        new WriteServiceImpl().write(toFile, report);
    }

}
