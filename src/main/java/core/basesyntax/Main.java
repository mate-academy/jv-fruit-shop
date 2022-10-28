package core.basesyntax;

import core.basesyntax.dao.GetFruitShopActivities;
import core.basesyntax.dao.ParseFruitAction;
import core.basesyntax.dao.impl.GetFruitShopActivitiesImpl;
import core.basesyntax.dao.impl.ParseFruitActionImpl;
import core.basesyntax.service.ReadFromFileService;
import core.basesyntax.service.WriteInFileService;
import core.basesyntax.service.impl.ReadFromFileServiceImpl;
import core.basesyntax.service.impl.WriteInFileServiceImpl;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    private static final String END_LINE = System.lineSeparator();
    private static final String COLUMNS = "fruit,quantity";
    private static final String WORDS_SPLITERATOR = ",";
    private static final String PATH_FROM = "src/main/resources/dataFrom.csv";
    private static final String PATH_TO = "src/main/resources/dataTo.csv";

    public static void main(String[] args) {
        ReadFromFileService readFromFileService = new ReadFromFileServiceImpl();
        ParseFruitAction parseFruitAction = new ParseFruitActionImpl();
        WriteInFileService writeInFileService = new WriteInFileServiceImpl();
        GetFruitShopActivities getFruitShopActivities = new GetFruitShopActivitiesImpl();
        String dataFromFile = readFromFileService.readFromFile(PATH_FROM);
        String[] activities = getFruitShopActivities.getActivities(dataFromFile);
        Map<String, Integer> dataForReport = parseFruitAction.parseFruit(activities);
        String report = COLUMNS + END_LINE;
        report += dataForReport.keySet().stream()
                .map(key -> key + WORDS_SPLITERATOR + dataForReport.get(key) + END_LINE)
                .collect(Collectors.joining());
        writeInFileService.writeInFile(report, PATH_TO);
        System.out.println(readFromFileService.readFromFile(PATH_TO));
    }
}
