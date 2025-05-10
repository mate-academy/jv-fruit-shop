package core.basesyntax;

import core.basesyntax.dao.ConverterDataToObjImpl;
import core.basesyntax.dao.FileDataReader;
import core.basesyntax.dao.FileDataReaderImpl;
import core.basesyntax.db.Database;
import core.basesyntax.service.ReportCreator;
import core.basesyntax.service.ReportWriterToFileImpl;
import core.basesyntax.service.TransactionStrategy;

public class Main {
    private static final String INPUT_FILE_PATH = "src/main/resources/data.csv";
    private static final String REPORT_PATH = "src/main/resources/report.csv";

    public static void main(String[] args) {
        FileDataReader readerDataFromFile = new FileDataReaderImpl();
        ConverterDataToObjImpl converterDataToObj = new ConverterDataToObjImpl();
        TransactionStrategy transactionStrategy = new TransactionStrategy();
        ReportWriterToFileImpl reportWriterToFile = new ReportWriterToFileImpl();
        ReportCreator reportCreator = new ReportCreator();

        converterDataToObj.convertAll(readerDataFromFile.readFromFile(INPUT_FILE_PATH))
                .forEach(fruit ->
                        transactionStrategy.getOperationHandler(
                                fruit.getOperation()).processTransaction(fruit));

        reportWriterToFile.writeToFile(REPORT_PATH,
                reportCreator.createReport(Database.database));
    }
}
