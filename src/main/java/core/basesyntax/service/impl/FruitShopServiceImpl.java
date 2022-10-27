package core.basesyntax.service.impl;

import core.basesyntax.service.FruitShopService;
import core.basesyntax.service.ReadFromFileService;
import core.basesyntax.service.WriteInFileService;
import core.basesyntax.strategy.FruitShopTransaction;
import core.basesyntax.strategy.GetFruitShopActivities;
import core.basesyntax.strategy.impl.FruitShopTransactionImpl;
import core.basesyntax.strategy.impl.GetFruitShopActivitiesImpl;
import java.util.Map;
import java.util.stream.Collectors;

public class FruitShopServiceImpl implements FruitShopService {
    private static final String END_LINE = System.lineSeparator();
    private static final String WORDS_SPLITERATOR = ",";
    private static final String PATH_FROM = "dataFrom.csv";
    private static final String PATH_TO = "dataTo.csv";
    private final ReadFromFileService readFromFileService;
    private final FruitShopTransaction fruitShopTransaction;
    private final WriteInFileService writeInFileService;
    private final GetFruitShopActivities getFruitShopActivities;

    public FruitShopServiceImpl() {
        readFromFileService = new ReadFromFileServiceImpl();
        fruitShopTransaction = new FruitShopTransactionImpl();
        writeInFileService = new WriteInFileServiceImpl();
        getFruitShopActivities = new GetFruitShopActivitiesImpl();
    }

    @Override
    public String getReportAfterWorkingDay() {
        String dataFromFile = readFromFileService.readFromFile(PATH_FROM);
        String[] activities = getFruitShopActivities.getActivities(dataFromFile);
        Map<String, Integer> dataForReport = fruitShopTransaction.fruitTransaction(activities);
        return dataForReport.keySet().stream()
                .map(key -> key + WORDS_SPLITERATOR + dataForReport.get(key)
                        + END_LINE)
                .collect(Collectors.joining());
    }

    @Override
    public void writeReportInFile() {
        String dataToWrite = getReportAfterWorkingDay();
        writeInFileService.writeInFile(dataToWrite, PATH_TO);
    }
}
