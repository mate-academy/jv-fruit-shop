package core.basesyntax;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.CsvFileReaderService;
import core.basesyntax.service.CsvFileWriterService;
import core.basesyntax.service.FruitShopService;
import core.basesyntax.service.ReportMakerService;
import core.basesyntax.service.TransactionParserService;
import java.util.List;

public class Main {
    private static final String READ_FILE_NAME = "source.csv";
    private static final String WRITE_FILE_NAME = "report.csv";

    public static void main(String[] args) {
        CsvFileReaderService csvFileReaderService = new CsvFileReaderService();
        List<String> linesFromFile = csvFileReaderService.readFile(READ_FILE_NAME);

        TransactionParserService fruitTransaction = new TransactionParserService();
        List<FruitTransaction> listFruitTransaction =
                fruitTransaction.parseFruitTransaction(linesFromFile);

        FruitShopService fruitShopService = new FruitShopService();
        fruitShopService.processFruitTransaction(listFruitTransaction);

        ReportMakerService reportMakerService = new ReportMakerService();
        String report = reportMakerService.createReport();

        CsvFileWriterService csvFileWriterService = new CsvFileWriterService();
        csvFileWriterService.writeFile(WRITE_FILE_NAME, report);
    }
}
