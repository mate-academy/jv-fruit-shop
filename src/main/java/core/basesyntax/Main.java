package core.basesyntax;

import core.basesyntax.dao.ConverterDataToObjImpl;
import core.basesyntax.service.ReportWriterToFileImpl;
import core.basesyntax.service.TransactionStrategy;

public class Main {

    public static void main(String[] args) {
        final String filePath = "src/main/resources/data.CSV";
        final String reportPath = "src/main/resources/report.CSV";
        ConverterDataToObjImpl converterDataToObj = new ConverterDataToObjImpl();
        TransactionStrategy transactionStrategy = new TransactionStrategy();
        ReportWriterToFileImpl reportWriterToFile = new ReportWriterToFileImpl();

        converterDataToObj.convertData(filePath);
        transactionStrategy.getShopService();
        reportWriterToFile.getReport(reportPath);
    }
}

