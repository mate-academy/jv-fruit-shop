package core.basesyntax;

import core.basesyntax.dao.ConverterDataToObjImpl;
import core.basesyntax.service.ReportWriterToFileImpl;
import core.basesyntax.service.TransactionStrategy;

/**
 * Feel free to remove this class and create your own.
 */
public class Main {

    public static void main(String[] args) {
        ConverterDataToObjImpl converterDataToObj = new ConverterDataToObjImpl();
        TransactionStrategy transactionStrategy = new TransactionStrategy();
        ReportWriterToFileImpl reportWriterToFile = new ReportWriterToFileImpl();

        converterDataToObj.convertData("src/main/resources/data.CSV");
        transactionStrategy.getShopService();
        reportWriterToFile.getReport();
    }
}

