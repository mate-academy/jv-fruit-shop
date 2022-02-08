package fruite.store;

import fruite.store.service.FruitService;
import fruite.store.service.FruitServiceImpl;

public class Main {
    public static void main(String[] args) {
        String fromFilePath = "src/main/java/fruite/store/db/activities-by-day.csv";
        String toFilePath = "src/main/java/fruite/store/db/report-by-day.csv";
        FruitService fruitService = new FruitServiceImpl();
        fruitService.makeReportByDay(fromFilePath, toFilePath);
    }
}
