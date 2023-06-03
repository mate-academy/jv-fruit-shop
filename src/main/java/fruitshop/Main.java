package fruitshop;

import fruitshop.dao.FruitDao;
import fruitshop.dao.FruitDaoImpl;
import fruitshop.model.FruitTransaction;
import fruitshop.service.CreateReportText;
import fruitshop.service.impl.CreateReportTextImpl;
import fruitshop.service.ParseText;
import fruitshop.service.impl.ParseTextImpl;
import fruitshop.service.ReadReport;
import fruitshop.service.impl.ReadReportImpl;
import fruitshop.service.WriteReportToFile;
import fruitshop.service.impl.WriteReportToFileImpl;
import fruitshop.strategy.impl.BalanceOperationStrategy;
import fruitshop.strategy.HandleStrategy;
import fruitshop.strategy.HandleStrategyImpl;
import fruitshop.strategy.impl.OperationStrategy;
import fruitshop.strategy.impl.PurchaseOperationStrategy;
import fruitshop.strategy.impl.ReturnOperationStrategy;
import fruitshop.strategy.impl.SupplyOperationStrategy;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final File file = new File("src/main/resources/file.csv");
    private static final File toFile = new File("src/main/resources/report.txt");

    public static void main(String[] args) {
        ReadReport report = new ReadReportImpl(file);
        ParseText parseText = new ParseTextImpl();
        Map<FruitTransaction.Operation, OperationStrategy>
                operationOperationStrategyMap = new HashMap<>();
        operationOperationStrategyMap.put(FruitTransaction.Operation.BALANCE,
                new BalanceOperationStrategy());
        operationOperationStrategyMap.put(FruitTransaction.Operation.PURCHASE,
                new PurchaseOperationStrategy());
        operationOperationStrategyMap.put(FruitTransaction.Operation.RETURN,
                new ReturnOperationStrategy());
        operationOperationStrategyMap.put(FruitTransaction.Operation.SUPPLY,
                new SupplyOperationStrategy());
        HandleStrategy strategy = new HandleStrategyImpl(operationOperationStrategyMap);
        FruitDao dao = new FruitDaoImpl();
        List<FruitTransaction> fruitTransactions = parseText.parseReport(report);
        for (FruitTransaction fruitTransaction : fruitTransactions) {
            dao.add(fruitTransaction,
                    strategy.getStrategy(fruitTransaction.getOperation()));
        }
        CreateReportText createReportText = new CreateReportTextImpl();
        Map<String, Integer> reportText = createReportText.createReportText();
        WriteReportToFile writeReportToFile = new WriteReportToFileImpl();
        writeReportToFile.writeReportToFile(reportText, toFile);
    }
}
