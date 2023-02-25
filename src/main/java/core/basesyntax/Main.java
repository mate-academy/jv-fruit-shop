package core.basesyntax;

import core.basesyntax.service.imp.BalanceService;
import core.basesyntax.service.imp.CsvFileReaderService;
import core.basesyntax.service.imp.CsvFileWriterService;
import core.basesyntax.service.imp.PurchaseService;
import core.basesyntax.service.imp.ReturnService;
import core.basesyntax.service.imp.SupplyService;
import java.util.List;

public class Main {
    private static final String READ_FILE_NAME = "source.csv";
    private static final String WRITE_FILE_NAME = "report.csv";

    public static void main(String[] args) {
        FruitTransaction fruitTransaction = new FruitTransaction();
        fruitTransaction.getStrategy().put(FruitTransaction.Operation.BALANCE.getCode(),
                new BalanceService());
        fruitTransaction.getStrategy().put(FruitTransaction.Operation.PURCHASE.getCode(),
                new PurchaseService());
        fruitTransaction.getStrategy().put(FruitTransaction.Operation.RETURN.getCode(),
                new ReturnService());
        fruitTransaction.getStrategy().put(FruitTransaction.Operation.SUPPLY.getCode(),
                new SupplyService());

        CsvFileReaderService csvFileReaderService = new CsvFileReaderService();
        List<String> linesFromFile = csvFileReaderService.readFile(READ_FILE_NAME);

        fruitTransaction.chooseStrategy(linesFromFile);

        CsvFileWriterService csvFileWriterService = new CsvFileWriterService();
        csvFileWriterService.writeFile(WRITE_FILE_NAME);
    }
}
