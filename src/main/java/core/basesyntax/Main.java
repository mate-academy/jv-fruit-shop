package core.basesyntax;

import core.basesyntax.db.FoodStoreDao;
import core.basesyntax.db.FoodStoreDaoImpl;
import core.basesyntax.db.FoodWriteToStoreDao;
import core.basesyntax.db.FoodWriteToStoreDaoImpl;
import core.basesyntax.service.FoodStoreService;
import core.basesyntax.service.FoodStoreServiceImpl;
import java.nio.file.Path;
import java.util.List;

public class Main {
    private static final Path pathToStartFile = Path.of("src/main/resources/allData.csv");
    private static final Path pathToReportFile = Path.of("src/main/resources/report.csv");
    private static final FoodStoreService foodStoreService = new FoodStoreServiceImpl();

    public static void main(String[] args) {
        FoodStoreDao file = new FoodStoreDaoImpl();
        List<String> dayData = file.read(pathToStartFile);
        FoodWriteToStoreDao writeToStoreDao = new FoodWriteToStoreDaoImpl(pathToReportFile);
        writeToStoreDao.write(foodStoreService.createReport(dayData));
    }
}
