package core.basesyntax;

import core.basesyntax.service.read.ReadServiceImpl;
import core.basesyntax.service.report.ReportSupplierImpl;
import core.basesyntax.service.write.WriteServiceImpl;

public class Main {
    public static void main(String[] args) {
        new WriteServiceImpl().write("input.csv","type,fruit,quantity\n"
                + "b,banana,20\n"
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
        new WriteServiceImpl().write(toFile, new ReportSupplierImpl().getReport(
                new ReadServiceImpl().readFile(fromFile)));
    }

}
