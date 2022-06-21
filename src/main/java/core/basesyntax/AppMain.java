package core.basesyntax;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.impl.FruitReport;
import core.basesyntax.service.impl.ReadFromCsv;
import core.basesyntax.service.impl.ServiceStrategy;
import core.basesyntax.service.impl.WriteToCsv;
import java.util.List;

public class AppMain {
    public static void main(String[] args) {
        List<FruitTransaction> transactions =
                new ReadFromCsv().readFile("src/main/resources/input.csv");
        System.out.println("Fruit transactions: "
                + System.lineSeparator() + transactions);

        ServiceStrategy serviceStrategy = new ServiceStrategy();
        for (FruitTransaction transaction : transactions) {
            serviceStrategy
                    .getServiceStrategy(transaction)
                    .toProcess(transaction);
        }
        String report = new FruitReport().get();
        System.out.println("Report: "
                + System.lineSeparator()
                + report);

        new WriteToCsv().writeFile("src/main/resources/report.csv", report);
    }
}
