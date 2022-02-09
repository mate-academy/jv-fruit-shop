package fruite.store;

import fruite.store.service.ReadDateService;
import fruite.store.service.impl.ReadDateFromFileImpl;
import fruite.store.service.WriteDateService;
import fruite.store.service.impl.WriteDateToFileImpl;
import fruite.store.service.FruitService;
import fruite.store.service.impl.FruitServiceImpl;
import fruite.store.service.strategy.StrategyType;

public class Main {
    public static void main(String[] args) {
        String fromFilePath = "src/main/resources/activities-by-day.csv";
        String toFilePath = "src/main/resources/report-by-day.csv";
        StrategyType strategyType = new StrategyType();
        ReadDateService readDateDao = new ReadDateFromFileImpl();
        WriteDateService writeDateDao = new WriteDateToFileImpl();
        FruitService fruitService = new FruitServiceImpl(strategyType, readDateDao, writeDateDao);
        fruitService.makeReportByDay(fromFilePath, toFilePath);
    }
}
