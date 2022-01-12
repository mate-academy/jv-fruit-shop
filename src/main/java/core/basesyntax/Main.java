package core.basesyntax;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitOperation;
import core.basesyntax.model.TypeActivity;
import core.basesyntax.service.FileParsering;
import core.basesyntax.service.FileReadering;
import core.basesyntax.service.FileReporting;
import core.basesyntax.service.FileWritering;
import core.basesyntax.service.impl.FileParseringImpl;
import core.basesyntax.service.impl.FileReaderingImpl;
import core.basesyntax.service.impl.FileReportingImpl;
import core.basesyntax.service.impl.FileWriteringImpl;
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

        FileReadering readFiles = new FileReaderingImpl();
        List<String> strings = readFiles.readDataFromFile(INPUT_FILE);

        FileParsering completeFiles = new FileParseringImpl();
        List<FruitOperation> fruitsList = completeFiles.fileParser(strings);

        ActivitiesStrategy activitiesStrategy = new ActivitiesStrategyImpl(operationsShopMap);
        activitiesStrategy.operation(fruitsList);

        FileReporting fileReporting = new FileReportingImpl();
        List<String> report = fileReporting.getReport(Storage.fruits);

        FileWritering fileWritering = new FileWriteringImpl();
        fileWritering.writeReportToFile(report, OUTPUT_FILE);
    }
}
