package core.basesyntax;

import core.basesyntax.db.Storage;
import core.basesyntax.impl.CsvFileReaderImpl;
import core.basesyntax.impl.CsvFileWriterImpl;
import core.basesyntax.impl.ListOfFruitTransactionFromStringImpl;
import core.basesyntax.impl.ReportCreatorImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.CsvFileReader;
import core.basesyntax.service.CsvFileWriter;
import core.basesyntax.service.ListOfFruitTransactionFromString;
import core.basesyntax.service.ReportCreator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        CsvFileWriter csvFileWriter = new CsvFileWriterImpl();
        CsvFileReader csvFileReader = new CsvFileReaderImpl();
        ListOfFruitTransactionFromString transactionFromString =
                new ListOfFruitTransactionFromStringImpl();
        ReportCreator reportCreator = new ReportCreatorImpl();

        String filePath = "src/main/resources/input.csv";

        String transaction = csvFileReader.read(filePath);

        List<FruitTransaction> fruitTransactions = transactionFromString.convert(transaction);

        reportCreator.create(fruitTransactions);

        String report = reportCreator.formatReport(Storage.storage);
        csvFileWriter.write("src/main/resources/report.csv", report);

        System.out.println("Report:\n" + report);
    }
}
