package core.basesyntax;

import core.basesyntax.dao.FruitShopDao;
import core.basesyntax.dao.FruitShopDaoImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.operation.BalanceOperation;
import core.basesyntax.operation.Operation;
import core.basesyntax.operation.PurchaseOperation;
import core.basesyntax.operation.ReturnOperation;
import core.basesyntax.operation.SupplyOperation;
import core.basesyntax.service.FileReader;
import core.basesyntax.service.FileWriter;
import core.basesyntax.service.FruitParser;
import core.basesyntax.service.ReportCreator;
import core.basesyntax.service.impl.FileReaderImpl;
import core.basesyntax.service.impl.FileWriterImpl;
import core.basesyntax.service.impl.FruitParserImpl;
import core.basesyntax.service.impl.ReportCreatorImpl;
import core.basesyntax.strategy.FruitStrategy;
import core.basesyntax.strategy.FruitStrategyImpl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<FruitTransaction.Operation, Operation> operationHashMap = new HashMap<>();
        operationHashMap.put(FruitTransaction.Operation.BALANCE, new BalanceOperation());
        operationHashMap.put(FruitTransaction.Operation.PURCHASE, new PurchaseOperation());
        operationHashMap.put(FruitTransaction.Operation.RETURN, new ReturnOperation());
        operationHashMap.put(FruitTransaction.Operation.SUPPLY, new SupplyOperation());
        FileReader fileReader = new FileReaderImpl();
        FruitParser fruitParser = new FruitParserImpl();
        List<String> stringList = fileReader.read("src/main/resources/input.csv");
        for (String string : stringList) {
            List<FruitTransaction> fruitTransactionList = new ArrayList<>();
            FruitTransaction fruitTransaction = fruitParser.parse(string);
            fruitTransactionList.add(fruitTransaction);
            for (FruitTransaction transaction : fruitTransactionList) {
                FruitStrategy fruitStrategy = new FruitStrategyImpl(operationHashMap);
                fruitStrategy.proceed(transaction);
            }
        }
        FruitShopDao fruitShopDao = new FruitShopDaoImpl();
        List<FruitTransaction> fruitTransactionList = fruitShopDao.getAll();
        ReportCreator reportCreator = new ReportCreatorImpl();
        String report = reportCreator.createReport(fruitTransactionList);
        FileWriter fileWriter = new FileWriterImpl();
        fileWriter.write(report, "src/main/resources/output.csv");
    }
}
