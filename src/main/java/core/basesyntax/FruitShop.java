package core.basesyntax;

import core.basesyntax.dto.Transaction;
import core.basesyntax.services.FileReaderService;
import core.basesyntax.services.FileWriterService;
import core.basesyntax.services.ReportFruitService;
import core.basesyntax.services.impl.FileReaderServiceImpl;
import core.basesyntax.services.impl.FileWriterServiceImpl;
import core.basesyntax.services.impl.ReportFruitServiceImpl;
import core.basesyntax.strategy.BalanceOperation;
import core.basesyntax.strategy.Operation;
import core.basesyntax.strategy.PurchaseOperation;
import core.basesyntax.strategy.SupplyOperation;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FruitShop {
    private static final String INPUT_FILEPATH
            = "src/main/java/core/basesyntax/resources/input.csv";
    private static final String OUTPUT_FILEPATH
            = "src/main/java/core/basesyntax/resources/output.csv";
    private static final int removeIndex = 0;
    private static final String COMMA = ",";

    public static void main(String[] args) {
        Map<Transaction.Operation, Operation> operationMap = new HashMap<>();
        operationMap.put(Transaction.Operation.RETURN, new SupplyOperation());
        operationMap.put(Transaction.Operation.SUPPLY, new SupplyOperation());
        operationMap.put(Transaction.Operation.BALANCE, new BalanceOperation());
        operationMap.put(Transaction.Operation.PURCHASE, new PurchaseOperation());

        FileReaderService fileReader = new FileReaderServiceImpl();
        List<String> listData = fileReader.readFromFile(INPUT_FILEPATH);
        listData.remove(removeIndex);
        ReportFruitService reportFruit = new ReportFruitServiceImpl();
        FileWriterService fileWriter = new FileWriterServiceImpl();
        fileWriter.writeToFile(OUTPUT_FILEPATH, reportFruit.createReport(listData, operationMap)
                + System.lineSeparator());
    }
}
