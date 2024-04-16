package core.basesyntax;

import core.basesyntax.dao.ConverterDataToObjImpl;
import core.basesyntax.dao.ReaderDataFromFile;
import core.basesyntax.dao.ReaderDataFromFileImpl;
import core.basesyntax.service.ReportCreator;
import core.basesyntax.service.ReportWriterToFileImpl;
import core.basesyntax.service.TransactionStrategy;

public class Main {

    public static void main(String[] args) {
        final String filePath = "src/main/resources/data.CSV";
        final String reportPath = "src/main/resources/report.CSV";

        ReaderDataFromFile readerDataFromFile = new ReaderDataFromFileImpl();
        ConverterDataToObjImpl converterDataToObj = new ConverterDataToObjImpl();
        TransactionStrategy transactionStrategy = new TransactionStrategy();
        ReportWriterToFileImpl reportWriterToFile = new ReportWriterToFileImpl();
        ReportCreator reportCreator = new ReportCreator();
        converterDataToObj.convertData(filePath, readerDataFromFile);
        transactionStrategy.getShopService();
        reportWriterToFile.getReport(reportPath, reportCreator);
    }
}

