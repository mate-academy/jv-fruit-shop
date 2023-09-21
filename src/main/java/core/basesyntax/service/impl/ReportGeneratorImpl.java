package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.service.CalculateBalance;
import core.basesyntax.service.FileReader;
import core.basesyntax.service.ReportGenerator;
import core.basesyntax.service.TransactionParser;
import core.basesyntax.service.WriterFile;

public class ReportGeneratorImpl implements ReportGenerator {
    private String report = "";
    private FileReader fileReader = new FileReaderImpl();
    private WriterFile fileWriter = new WriterFileImpl();
    private CalculateBalance calculateBalance = new CalculateBalanceImpl();
    private TransactionParser transactionParser = new TransactionParserImpl();

    @Override
    public String makeReport() {

        for (String element: Storage.result.keySet()) {
            report += (element + ", " + Storage.result.get(element) + System.lineSeparator());
        }
        return report;

    }
}
