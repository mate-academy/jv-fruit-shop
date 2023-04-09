package core.basesyntax;

import core.basesyntax.dao.DaoGetFruitTransaction;
import core.basesyntax.dao.DaoSetFruitTransaction;
import core.basesyntax.dao.DaoSetList;
import core.basesyntax.dao.impl.DaoGetFruitTransactionImpl;
import core.basesyntax.dao.impl.DaoSetFruitTransactionImpl;
import core.basesyntax.dao.impl.DaoSetListImpl;
import core.basesyntax.function.impl.DailyBalanceToFruitTransactionList;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.CheckDailyBalance;
import core.basesyntax.service.DailyBalanceFileGenerator;
import core.basesyntax.service.ReaderFromFileService;
import core.basesyntax.service.impl.CheckDailyBalanceImpl;
import core.basesyntax.service.impl.DailyBalanceCalculatorImpl;
import core.basesyntax.service.impl.DailyBalanceFileGeneratorImpl;
import core.basesyntax.service.impl.ReaderFromFileServiceImpl;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String INPUT_FILE = "src/main/resources/input.csv";
    private static final String REPORT_FILE = "src/main/resources/report.csv";

    public static void main(String[] args) {
        ReaderFromFileService readerService = new ReaderFromFileServiceImpl();
        List<String> linesFromFile = readerService.readFromFile(INPUT_FILE);
        DaoSetList setListStringToDB = new DaoSetListImpl();
        setListStringToDB.apply(linesFromFile);
        DailyBalanceCalculatorImpl reportGenerator = new DailyBalanceCalculatorImpl();
        DaoGetFruitTransaction getFruitTransactionFromDb = new DaoGetFruitTransactionImpl();
        Map<String, Integer> dailyBalance
                = reportGenerator.calculateBalance(getFruitTransactionFromDb.apply());
        CheckDailyBalance checkBalance = new CheckDailyBalanceImpl();
        checkBalance.isOk(dailyBalance);
        DaoSetFruitTransaction setFruitTransactionToDb = new DaoSetFruitTransactionImpl();
        DailyBalanceToFruitTransactionList dailyBalanceToFruitTransactionList
                = new DailyBalanceToFruitTransactionList();
        List<FruitTransaction> dailyBalanceList
                = dailyBalanceToFruitTransactionList.apply(dailyBalance);
        setFruitTransactionToDb.apply(dailyBalanceList);
        DailyBalanceFileGenerator dailyBalanceFileGenerator = new DailyBalanceFileGeneratorImpl();
        dailyBalanceFileGenerator.apply(REPORT_FILE);
    }
}
