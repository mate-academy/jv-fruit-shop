package core.basesyntax;

import core.basesyntax.db.Storage;
import core.basesyntax.service.FileReader;
import core.basesyntax.service.ReportCreator;
import core.basesyntax.service.TransactionProcessor;

/**
 * Feel free to remove this class and create your own.
 */
public class Main {
    private static final String FILENAME = "src/main/resources/input.csv";

    public static void main(String[] args) {
        ReportCreator reportCreator = new ReportCreator();
        Storage storage = Storage.of();
        TransactionProcessor transactionProcessor = TransactionProcessor.of(storage);
        FileReader inputReader = FileReader.of(transactionProcessor);
        inputReader.read(FILENAME);
        System.out.println(reportCreator.createReport(storage));
    }
}
