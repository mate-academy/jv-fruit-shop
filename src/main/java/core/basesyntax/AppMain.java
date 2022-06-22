package core.basesyntax;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.impl.FruitReportGenerator;
import core.basesyntax.service.impl.FruitTransactionMapper;
import core.basesyntax.service.impl.OperationStrategy;
import core.basesyntax.service.impl.ReadFromCsv;
import core.basesyntax.service.impl.WriteToCsv;
import java.util.List;

public class AppMain {
    public static void main(String[] args) {
        List<String> transactionLines =
                new ReadFromCsv().readFile("src/main/resources/input.csv");
        List<FruitTransaction> transactions =
                new FruitTransactionMapper().map(transactionLines);
        System.out.println("Fruit transactions: "
                + System.lineSeparator() + transactions);

        for (FruitTransaction transaction : transactions) {
            OperationStrategy operationStrategy =
                    new OperationStrategy(transaction.getOperation());
            operationStrategy
                    .getHandler()
                    .handler(transaction);
        }
        String report = new FruitReportGenerator().create();
        System.out.println("Report: "
                + System.lineSeparator()
                + report);

        new WriteToCsv().writeFile("src/main/resources/report.csv", report);
    }
}
