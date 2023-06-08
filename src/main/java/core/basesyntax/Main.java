package core.basesyntax;

public class Main {
    private static final String FROM_THIS_FILE = "input.csv";
    private static final String TO_THIS_FILE = "report.csv";

    public static void main(String[] args) {
        FruitStoreManager storeManager = new FruitStoreManager(new CsvFileReaderService(),
                new CsvFileWriterService());
        storeManager.processTransactionsAndGenerateReport(FROM_THIS_FILE,
                TO_THIS_FILE);
    }
}
