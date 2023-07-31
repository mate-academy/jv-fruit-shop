package core.basesyntax;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.CsvFileReader;
import core.basesyntax.service.CsvFileWriter;
import core.basesyntax.service.DataConvertor;
import core.basesyntax.service.ReportCreator;
import core.basesyntax.service.impl.CsvFileReaderImpl;
import core.basesyntax.service.impl.CsvFileWriterImpl;
import core.basesyntax.service.impl.DataConvertorImpl;
import core.basesyntax.service.impl.ReportCreatorImpl;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        CsvFileWriter csvFileWriter = new CsvFileWriterImpl();
        CsvFileReader csvFileReader = new CsvFileReaderImpl();
        DataConvertor transactionFromString =
                new DataConvertorImpl();
        ReportCreator reportCreator = new ReportCreatorImpl();
        String filePath = "src/main/resources/input.csv";

        String transaction = csvFileReader.read(filePath);
        List<FruitTransaction> fruitTransactions = transactionFromString.convert(transaction);

        String report = reportCreator.createReport(Storage.storage, fruitTransactions);
        csvFileWriter.write("src/main/resources/report.csv", report);

        System.out.println("Report:\n" + report);
    }
}
