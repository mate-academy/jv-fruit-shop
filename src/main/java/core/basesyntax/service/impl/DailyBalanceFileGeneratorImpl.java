package core.basesyntax.service.impl;

import core.basesyntax.dao.DaoGetFruitTransaction;
import core.basesyntax.dao.impl.DaoGetFruitTransactionImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.DailyBalanceFileGenerator;
import core.basesyntax.service.WriterToFileService;
import java.util.List;
import java.util.stream.Collectors;

public class DailyBalanceFileGeneratorImpl implements DailyBalanceFileGenerator {
    private static final String CSV_REPORT_TITLE = "fruit,quantity";
    private static final int TITLE_INDEX = 0;
    private static final String FRUIT_TRANSACTION_SEPARATOR = ",";

    @Override
    public void apply(String filename) {
        DaoGetFruitTransaction getFruitTransactionFromDb
                = new DaoGetFruitTransactionImpl();
        List<FruitTransaction> dailyBalanceInTransaction
                = getFruitTransactionFromDb.apply();
        List<String> dailyReportList = dailyBalanceInTransaction.stream()
                .map(fruitTransaction -> fruitTransaction.getFruit()
                        + FRUIT_TRANSACTION_SEPARATOR
                        + fruitTransaction.getQuantity())
                .collect(Collectors.toList());
        dailyReportList.add(TITLE_INDEX, CSV_REPORT_TITLE);
        WriterToFileService writerService = new WriterToFileServiceImpl();
        writerService.writeToFile(dailyReportList, filename);
    }
}
