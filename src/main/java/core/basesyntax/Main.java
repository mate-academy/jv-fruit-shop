package core.basesyntax;

import core.basesyntax.dao.SaveAllRecords;
import core.basesyntax.dao.impl.SaveAllRecordsImpl;
import core.basesyntax.function.impl.ListStringsToFruitTransactions;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.BalanceListCreator;
import core.basesyntax.service.CalculateBalanceService;
import core.basesyntax.service.CheckPositiveBalanceService;
import core.basesyntax.service.ReaderFromFileService;
import core.basesyntax.service.WriterToFileService;
import core.basesyntax.service.impl.BalanceListCreatorImpl;
import core.basesyntax.service.impl.CalculateBalanceServiceImpl;
import core.basesyntax.service.impl.CheckPositiveBalanceServiceImpl;
import core.basesyntax.service.impl.ReaderFromFileServiceImpl;
import core.basesyntax.service.impl.WriterToFileServiceImpl;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String INPUT_FILE = "src/main/resources/input.csv";
    private static final String REPORT_FILE = "src/main/resources/report.csv";

    public static void main(String[] args) {
        ReaderFromFileService readerService = new ReaderFromFileServiceImpl();
        List<String> listFromFile = readerService.readFromFile(INPUT_FILE);
        ListStringsToFruitTransactions listStringsToFruitTransactions
                = new ListStringsToFruitTransactions();
        List<FruitTransaction> fruitTransactions
                = listStringsToFruitTransactions.apply(listFromFile);
        CalculateBalanceService calculateBalanceService = new CalculateBalanceServiceImpl();
        Map<String, Integer> fruitBalance = calculateBalanceService.calculate(fruitTransactions);
        CheckPositiveBalanceService checkPositiveBalanceService
                = new CheckPositiveBalanceServiceImpl();
        checkPositiveBalanceService.isPositive(fruitBalance);
        SaveAllRecords saveAllRecords = new SaveAllRecordsImpl();
        saveAllRecords.save(fruitBalance);
        BalanceListCreator balanceListCreator = new BalanceListCreatorImpl();
        List<String> reportList = balanceListCreator.create(fruitBalance);
        WriterToFileService writerService = new WriterToFileServiceImpl();
        writerService.writeToFile(reportList, REPORT_FILE);
    }
}
