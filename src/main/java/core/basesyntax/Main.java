package core.basesyntax;

import core.basesyntax.fruittransact.FruitTransaction;
import core.basesyntax.fruittransact.strategy.FruitTransactionStrategyImpl;
import core.basesyntax.reportcreator.ReportGenerator;
import core.basesyntax.reportcreator.ReportGeneratorImpl;
import core.basesyntax.workwithfile.filereader.FileReader;
import core.basesyntax.workwithfile.filereader.FileReaderImpl;
import java.io.File;

public class Main {
    private static final String[] FILE_NAMES =
            new String[]{"input1.csv", "input2.csv", "input3.csv"};

    public static void main(String[] args) {
        FileReader fileReader = new FileReaderImpl();
        FruitTransaction fruitTransaction = new FruitTransaction(
                new FruitTransactionStrategyImpl());
        ReportGenerator reportGenerator = new ReportGeneratorImpl();
        for (String fileName : FILE_NAMES) {
            fruitTransaction.handleAll(fileReader.readFromFile(new File(fileName)));
            System.out.println(reportGenerator.generateReport() + System.lineSeparator());
        }
    }
}
