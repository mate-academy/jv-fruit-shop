package core.basesyntax;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ConvertFromDataStringToList;
import core.basesyntax.service.CsvFileReader;
import core.basesyntax.service.CsvFileWriter;
import core.basesyntax.service.ReportCreator;
import core.basesyntax.service.impl.ConvertFromDataStringToListImpl;
import core.basesyntax.service.impl.CsvFileReaderImpl;
import core.basesyntax.service.impl.CsvFileWriterImpl;
import core.basesyntax.service.impl.ReportCreatorImpl;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        CsvFileWriter csvFileWriter = new CsvFileWriterImpl();
        CsvFileReader csvFileReader = new CsvFileReaderImpl();
        ConvertFromDataStringToList transactionFromString =
                new ConvertFromDataStringToListImpl();
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
