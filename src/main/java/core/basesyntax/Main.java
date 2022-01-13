package core.basesyntax;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitOperation;
import core.basesyntax.model.TypeActivity;
import core.basesyntax.service.FileParser;
import core.basesyntax.service.FileReader;
import core.basesyntax.service.FileReport;
import core.basesyntax.service.FileWriter;
import core.basesyntax.service.impl.FileParserImpl;
import core.basesyntax.service.impl.FileReaderImpl;
import core.basesyntax.service.impl.FileReportImpl;
import core.basesyntax.service.impl.FileWriterImpl;
import core.basesyntax.strategy.ActivitiesShop;
import core.basesyntax.strategy.ActivitiesStrategy;
import core.basesyntax.strategy.impl.ActivitiesStrategyImpl;
import core.basesyntax.strategy.impl.BalanceActivitiesShop;
import core.basesyntax.strategy.impl.PurchaseActivitiesShop;
import core.basesyntax.strategy.impl.SupplyActivitiesShop;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static final String INPUT_FILE = "src/main/resources/StoreInformation.csv";
    public static final String OUTPUT_FILE = "src/main/resources/StoreReport.csv";

    public static void main(String[] args) {

        Map<TypeActivity, ActivitiesShop> operationsShopMap = new HashMap<>();
        operationsShopMap.put(TypeActivity.BALANCE, new BalanceActivitiesShop());
        operationsShopMap.put(TypeActivity.PURCHASE, new PurchaseActivitiesShop());
        operationsShopMap.put(TypeActivity.SUPPLY, new SupplyActivitiesShop());
        operationsShopMap.put(TypeActivity.RETURN, new SupplyActivitiesShop());

        FileReader readFiles = new FileReaderImpl();
        List<String> strings = readFiles.readDataFromFile(INPUT_FILE);

        FileParser completeFiles = new FileParserImpl();
        List<FruitOperation> fruitsList = completeFiles.parse(strings);

        ActivitiesStrategy activitiesStrategy = new ActivitiesStrategyImpl(operationsShopMap);
        activitiesStrategy.operation(fruitsList);

        FileReport fileReport = new FileReportImpl();
        List<String> report = fileReport.getReport(Storage.fruits);

        FileWriter fileWriter = new FileWriterImpl();
        fileWriter.writeReportToFile(report, OUTPUT_FILE);
    }
}
