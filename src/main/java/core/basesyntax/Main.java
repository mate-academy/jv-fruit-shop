package core.basesyntax;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ReaderService;
import core.basesyntax.service.ReportMakerService;
import core.basesyntax.service.TransactionParserService;
import core.basesyntax.service.WriterService;
import core.basesyntax.service.impl.CalculationFruitsImpl;
import core.basesyntax.service.impl.ReaderServiceImpl;
import core.basesyntax.service.impl.ReportMakerServiceImpl;
import core.basesyntax.service.impl.TransactionParserServiceImpl;
import core.basesyntax.service.impl.WriterServiceImpl;
import java.io.File;
import java.util.List;

public class Main {
    private static final String FILE_NAME = "input.csv";

    public static void main(String[] args) {
        ReaderService readerService = new ReaderServiceImpl();
        ReportMakerService reportMakerService = new ReportMakerServiceImpl();
        TransactionParserService parser = new TransactionParserServiceImpl();
        WriterService writerService = new WriterServiceImpl();
        CalculationFruitsImpl calculationFruits = new CalculationFruitsImpl();
        File dataFile = new File(FILE_NAME);
        List<String> listOfData = readerService.readInfoFromFile(dataFile);
        List<FruitTransaction> parsedData = parser.parseData(listOfData);
        calculationFruits.calculation(parsedData);
        String textOfReport = reportMakerService.formingReport(Storage.STORAGE);
        writerService.writeReport(textOfReport);
    }
}
