package core.basesyntax;

import core.basesyntax.dto.Transaction;
import core.basesyntax.services.FileReader;
import core.basesyntax.services.FileWriter;
import core.basesyntax.services.FruitReportService;
import core.basesyntax.services.impl.FileReaderImpl;
import core.basesyntax.services.impl.FileWriterImpl;
import core.basesyntax.services.impl.FruitReportServiceImpl;
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

        FileReader fileReader = new FileReaderImpl();
        List<String> listData = fileReader.readFromFile(INPUT_FILEPATH);
        listData.remove(removeIndex);
        FruitReportService reportFruit = new FruitReportServiceImpl();
        FileWriter fileWriter = new FileWriterImpl();
        fileWriter.writeToFile(OUTPUT_FILEPATH, reportFruit.createReport(listData, operationMap)
                + System.lineSeparator());
    }
}
