package core.basesyntax;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.Parser;
import core.basesyntax.service.ParserImpl;
import core.basesyntax.service.Reader;
import core.basesyntax.service.ReaderCsvImpl;
import core.basesyntax.service.ReportCreator;
import core.basesyntax.service.ReportCreatorImpl;
import core.basesyntax.service.TransactionHandler;
import core.basesyntax.service.TransactionHandlerImpl;
import core.basesyntax.service.Writer;
import core.basesyntax.service.WriterCsvImpl;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Reader reader = new ReaderCsvImpl();
        List<String> stringsTransactions = reader.readFromFile("src/main/resources/file.csv");
        Parser parser = new ParserImpl();
        List<FruitTransaction> fruitTransactions = parser.parse(stringsTransactions);
        TransactionHandler transactionHandler = new TransactionHandlerImpl();
        transactionHandler.handle(fruitTransactions);
        ReportCreator reportCreator = new ReportCreatorImpl();
        List<String> report = reportCreator.createReport(Storage.fruits);
        Writer writer = new WriterCsvImpl();
        writer.writeToFile(report, "src/main/resources/report5.csv");
    }
}
