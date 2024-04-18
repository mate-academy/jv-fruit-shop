package core.basesyntax;

import core.basesyntax.dao.ConverterDataToObjImpl;
import core.basesyntax.dao.ReaderDataFromFile;
import core.basesyntax.dao.ReaderDataFromFileImpl;
import core.basesyntax.db.DataBase;
import core.basesyntax.service.ReportCreator;
import core.basesyntax.service.ReportWriterToFileImpl;
import core.basesyntax.service.TransactionStrategy;

public class Main {
    private static final String INPUT_FILE_PATH = "src/main/resources/data.csv";
    private static final String REPORT_PATH = "src/main/resources/report.csv";

    public static void main(String[] args) {
        ReaderDataFromFile readerDataFromFile = new ReaderDataFromFileImpl();
        ConverterDataToObjImpl converterDataToObj = new ConverterDataToObjImpl();
        TransactionStrategy transactionStrategy = new TransactionStrategy();
        ReportWriterToFileImpl reportWriterToFile = new ReportWriterToFileImpl();
        ReportCreator reportCreator = new ReportCreator();

        converterDataToObj.dataConverter(readerDataFromFile.readFromFile(INPUT_FILE_PATH))
                .forEach(fruit ->
                        transactionStrategy.getOperationHandler(
                                fruit.getOperation()).operationHandler(fruit));

        reportWriterToFile.createReport(REPORT_PATH,
                reportCreator.createReport(DataBase.FRUIT_DATABASE));
    }
}
