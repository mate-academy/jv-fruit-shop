package core.basesyntax;

import core.basesyntax.dao.GetFruitShopActivities;
import core.basesyntax.dao.ParseFruitAction;
import core.basesyntax.dao.impl.GetFruitShopActivitiesImpl;
import core.basesyntax.dao.impl.ParseFruitActionImpl;
import core.basesyntax.service.ReadFromFileService;
import core.basesyntax.service.ReportService;
import core.basesyntax.service.WriteInFileService;
import core.basesyntax.service.impl.ReadFromFileServiceImpl;
import core.basesyntax.service.impl.ReportServiceImpl;
import core.basesyntax.service.impl.WriteInFileServiceImpl;

public class Main {
    private static final String PATH_FROM = "src/main/resources/dataFrom.csv";
    private static final String PATH_TO = "src/main/resources/dataTo.csv";

    public static void main(String[] args) {
        ReadFromFileService readFromFileService = new ReadFromFileServiceImpl();
        String dataFromFile = readFromFileService.readFromFile(PATH_FROM);

        GetFruitShopActivities getFruitShopActivities = new GetFruitShopActivitiesImpl();
        String[] activities = getFruitShopActivities.getActivities(dataFromFile);

        ParseFruitAction parseFruitAction = new ParseFruitActionImpl();
        parseFruitAction.parseFruit(activities);

        ReportService reportService = new ReportServiceImpl();
        String report = reportService.getReport();

        WriteInFileService writeInFileService = new WriteInFileServiceImpl();
        writeInFileService.writeInFile(report, PATH_TO);
        System.out.println(readFromFileService.readFromFile(PATH_TO));
    }
}
