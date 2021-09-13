package core.basesyntax;

import core.basesyntax.dto.Transaction;
import core.basesyntax.service.FileReaderImpl;
import core.basesyntax.service.FileWriter;
import core.basesyntax.service.FileWriterImpl;
import core.basesyntax.service.FruitParser;
import core.basesyntax.service.ReportFruitImpl;
import core.basesyntax.service.ValidatorImpl;
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

    public static void main(String[] args) {
        Map<String, Operation> operationsMap = new HashMap<>();
        operationsMap.put("b", new BalanceOperation());
        operationsMap.put("s", new SupplyOperation());
        operationsMap.put("p", new PurchaseOperation());
        operationsMap.put("r", new SupplyOperation());
        FileReaderImpl fileReader = new FileReaderImpl();
        List<String> listData = fileReader.readFromFile(INPUT_FILEPATH);
        listData.remove(0);
        ValidatorImpl validator = new ValidatorImpl();
        FruitParser parser = new FruitParser();
        for (String line : listData) {
            validator.checkInputData(line.split(","));
            Transaction transaction = parser.parseData(line);
            operationsMap.get(transaction.getOperation()).apply(transaction);
        }
        ReportFruitImpl fruitReport = new ReportFruitImpl();
        FileWriter writer = new FileWriterImpl();
        writer.writeToFile(OUTPUT_FILEPATH, fruitReport.getReport());
    }
}
