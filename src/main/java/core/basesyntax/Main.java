package core.basesyntax;

import core.basesyntax.db.Storage;
import core.basesyntax.service.FileReader;
import core.basesyntax.service.FileWriter;
import core.basesyntax.service.ReportCreator;
import core.basesyntax.service.TransactionParser;
import core.basesyntax.service.TransactionProcessor;
import java.util.ArrayList;

/**
 * Feel free to remove this class and create your own.
 */
public class Main {

    private static final String FILENAME = "src/main/resources/input.csv";

    public static void main(String[] args) {
        ReportCreator reportCreator = new ReportCreator();
        FileWriter fileWriter = new FileWriter();
        Storage storage = new Storage();
        TransactionProcessor transactionProcessor = new TransactionProcessor(storage);
        TransactionParser transactionParser = new TransactionParser();
        FileReader inputReader = new FileReader();
        ArrayList<String> linesFromFile = inputReader.read(FILENAME);
        for (String line : linesFromFile) {
            transactionProcessor.processTransaction(transactionParser.parseTransaction(line));
        }
        fileWriter.write(reportCreator.createReport(storage));
    }
}
