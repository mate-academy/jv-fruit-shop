package core.basesyntax;

import core.basesyntax.service.CalculateBalance;
import core.basesyntax.service.FileReader;
import core.basesyntax.service.ReportGenerator;
import core.basesyntax.service.TransactionParser;
import core.basesyntax.service.WriterFile;
import core.basesyntax.service.impl.CalculateBalanceImpl;
import core.basesyntax.service.impl.FileReaderImpl;
import core.basesyntax.service.impl.ReportGeneratorImpl;
import core.basesyntax.service.impl.TransactionParserImpl;
import core.basesyntax.service.impl.WriterFileImpl;

public class Main {

    public static void main(String[] args) {
        FileReader fileReader = new FileReaderImpl();
        WriterFile fileWriter = new WriterFileImpl();
        CalculateBalance calculateBalance = new CalculateBalanceImpl();
        TransactionParser transactionParser = new TransactionParserImpl();
        ReportGenerator reportGenerator = new ReportGeneratorImpl();
        calculateBalance.calculateBalance(transactionParser.parseTransaction(
                fileReader.readFile()));
        fileWriter.writeToFile(reportGenerator.makeReport());
    }
}


