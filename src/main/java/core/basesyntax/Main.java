package core.basesyntax;

import core.basesyntax.models.FruitTransaction;
import core.basesyntax.service.FileReader;
import core.basesyntax.service.FileWriter;
import core.basesyntax.service.FruitDistributionService;
import core.basesyntax.service.ReportCreator;
import core.basesyntax.service.impl.CsvFileReader;
import core.basesyntax.service.impl.CsvFileWriter;
import core.basesyntax.service.impl.FruitDistributionServiceImpl;
import core.basesyntax.service.impl.ReportCreatorImpl;
import core.basesyntax.strategy.FruitDistributionStrategy;
import core.basesyntax.strategy.FruitDistributionStrategyImpl;
import core.basesyntax.strategy.ShopActivities;
import core.basesyntax.strategy.ShopBalance;
import core.basesyntax.strategy.ShopPurchase;
import core.basesyntax.strategy.ShopReturn;
import core.basesyntax.strategy.ShopSupply;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String DATA_FILE_LOCATION = "src/main/resources/databaseOfFruits.csv";
    private static final String REPORT_FILE_LOCATION = "src/main/resources/report.csv";

    public static void main(String[] args) {
        Map<FruitTransaction.Operation, ShopActivities> shopActivitiesMap = new HashMap<>();
        shopActivitiesMap.put(FruitTransaction.Operation.BALANCE, new ShopBalance());
        shopActivitiesMap.put(FruitTransaction.Operation.SUPPLY, new ShopSupply());
        shopActivitiesMap.put(FruitTransaction.Operation.PURCHASE, new ShopPurchase());
        shopActivitiesMap.put(FruitTransaction.Operation.RETURN, new ShopReturn());

        FileReader fileReader = new CsvFileReader();
        List<String> inputData = fileReader.readDataFrom(DATA_FILE_LOCATION);

        FruitDistributionStrategy distributionStrategy
                = new FruitDistributionStrategyImpl(shopActivitiesMap);

        FruitDistributionService distributionService
                = new FruitDistributionServiceImpl(distributionStrategy);
        distributionService.countFruitDistribution(inputData);

        ReportCreator reportCreator = new ReportCreatorImpl();
        String report = reportCreator.createReport();

        File reportFile = new File(REPORT_FILE_LOCATION);
        FileWriter fileWriter = new CsvFileWriter();
        fileWriter.writeDataToFile(report, REPORT_FILE_LOCATION);

    }
}
