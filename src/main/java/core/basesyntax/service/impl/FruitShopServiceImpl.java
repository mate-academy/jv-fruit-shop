package core.basesyntax.service.impl;

import core.basesyntax.dao.GetFruitShopActivities;
import core.basesyntax.dao.ParseFruitAction;
import core.basesyntax.dao.impl.GetFruitShopActivitiesImpl;
import core.basesyntax.dao.impl.ParseFruitActionImpl;
import core.basesyntax.service.FruitShopService;
import core.basesyntax.service.ReadFromFileService;
import core.basesyntax.service.WriteInFileService;
import java.util.Map;
import java.util.stream.Collectors;

public class FruitShopServiceImpl implements FruitShopService {
    private static final String END_LINE = System.lineSeparator();
    private static final String WORDS_SPLITERATOR = ",";
    private static final String PATH_FROM = "dataFrom.csv";
    private static final String PATH_TO = "dataTo.csv";
    private final ReadFromFileService readFromFileService;
    private final ParseFruitAction parseFruitAction;
    private final WriteInFileService writeInFileService;
    private final GetFruitShopActivities getFruitShopActivities;

    public FruitShopServiceImpl() {
        readFromFileService = new ReadFromFileServiceImpl();
        parseFruitAction = new ParseFruitActionImpl();
        writeInFileService = new WriteInFileServiceImpl();
        getFruitShopActivities = new GetFruitShopActivitiesImpl();
    }

    @Override
    public String getReportAfterWorkingDay() {
        String dataFromFile = readFromFileService.readFromFile(PATH_FROM);
        String[] activities = getFruitShopActivities.getActivities(dataFromFile);
        Map<String, Integer> dataForReport = parseFruitAction.parseFruit(activities);
        return dataForReport.keySet().stream()
                .map(key -> key + WORDS_SPLITERATOR + dataForReport.get(key) + END_LINE)
                .collect(Collectors.joining());
    }

    @Override
    public void writeReportInFile() {
        String dataToWrite = getReportAfterWorkingDay();
        writeInFileService.writeInFile(dataToWrite, PATH_TO);
    }
}
