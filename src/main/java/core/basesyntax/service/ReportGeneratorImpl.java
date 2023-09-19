package core.basesyntax.service;

import core.basesyntax.db.Storage;

public class ReportGeneratorImpl implements ReportGenerator {
    private String report = "";
    private FileReader fileReader = new FileReaderImpl();
    private FileWriter fileWriter = new FileWriterImpl();
    private CalculateBalance calculateBalance = new CalculateBalanceImpl();

    @Override
    public void makeReport() {
        calculateBalance.calculateBalance(fileReader.readFromFileToArray());

        for (String element: Storage.result.keySet()) {
            report += (element + ", " + Storage.result.get(element) + System.lineSeparator());
        }
        fileWriter.writeToFile(report);
    }
}
