package core.basesyntax;

import core.basesyntax.db.Storage;
import core.basesyntax.service.InputReader;
import core.basesyntax.service.ReportCreator;
import core.basesyntax.service.TransactionProcessor;

/**
 * Feel free to remove this class and create your own.
 */
public class Main {
    // HINT: In the `public static void main(String[] args)`
    // it is better to create instances of your classes,
    // and call their methods, but do not write any business logic in the `main` method!
    public static void main(String[] args) {
        String fileName = "src/main/resources/input.csv";
        Storage storage = Storage.of();
        TransactionProcessor transactionProcessor = TransactionProcessor.of(storage);
        InputReader inputReader = InputReader.of(transactionProcessor);
        inputReader.read(fileName);
        System.out.println(ReportCreator.createReport(storage));
    }
}
