package core.basesyntax;

import core.basesyntax.models.FruitTransition;
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
        Map<FruitTransition.Operation, ShopActivities> shopActivitiesMap = new HashMap<>();
        shopActivitiesMap.put(FruitTransition.Operation.BALANCE, new ShopBalance());
        shopActivitiesMap.put(FruitTransition.Operation.SUPPLY, new ShopSupply());
        shopActivitiesMap.put(FruitTransition.Operation.PURCHASE, new ShopPurchase());
        shopActivitiesMap.put(FruitTransition.Operation.RETURN, new ShopReturn());

        FileReader<String> fileReader = new CsvFileReader();
        List<String> inputData = fileReader.parseDataFrom(DATA_FILE_LOCATION);

        FruitDistributionStrategy distributionStrategy
                = new FruitDistributionStrategyImpl(shopActivitiesMap);

        FruitDistributionService<String> distributionService
                = new FruitDistributionServiceImpl(distributionStrategy);
        distributionService.countFruitDistribution(inputData);

        ReportCreator reportCreator = new ReportCreatorImpl();
        String report = reportCreator.ctreateRoport();

        File reportFile = new File(REPORT_FILE_LOCATION);
        FileWriter fileWriter = new CsvFileWriter();
        fileWriter.writeDataToFile(report, REPORT_FILE_LOCATION);

    }
}
