package core.basesyntax;

import core.basesyntax.dao.ConverterDataToObjImpl;
import core.basesyntax.dao.ReaderDataFromFile;
import core.basesyntax.dao.ReaderDataFromFileImpl;
import core.basesyntax.db.DataBase;
import core.basesyntax.service.ReportWriterToFileImpl;
import core.basesyntax.service.TransactionStrategy;

public class Main {
    private static final String FILE_PATH = "src/main/resources/data.csv";
    private static final String REPORT_PATH = "src/main/resources/report.csv";

    public static void main(String[] args) {
        ReaderDataFromFile readerDataFromFile = new ReaderDataFromFileImpl();
        ConverterDataToObjImpl converterDataToObj = new ConverterDataToObjImpl();
        TransactionStrategy transactionStrategy = new TransactionStrategy();
        ReportWriterToFileImpl reportWriterToFile = new ReportWriterToFileImpl();
        DataBase dataBase = new DataBase();

        converterDataToObj.convertData(FILE_PATH, readerDataFromFile.readFromFile(FILE_PATH))
                .forEach(fruit ->
                        transactionStrategy.getShopService(fruit).operationHandler(fruit));
        reportWriterToFile.getReport(REPORT_PATH, dataBase);
    }
}
