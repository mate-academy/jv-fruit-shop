package fruite.store;

import fruite.store.service.FileReaderService;
import fruite.store.service.FileWriterService;
import fruite.store.service.FruitService;
import fruite.store.service.impl.FileReaderServiceImpl;
import fruite.store.service.impl.FileWriterServiceImpl;
import fruite.store.service.impl.FruitServiceImpl;
import fruite.store.service.strategy.StrategyHandler;

public class Main {
    public static void main(String[] args) {
        String fromFilePath = "src/main/resources/activities-by-day.csv";
        String toFilePath = "src/main/resources/report-by-day.csv";
        StrategyHandler strategyType = new StrategyHandler();
        FileReaderService readDateDao = new FileReaderServiceImpl();
        FileWriterService writeDateDao = new FileWriterServiceImpl();
        FruitService fruitService = new FruitServiceImpl(strategyType, readDateDao, writeDateDao);
        fruitService.makeReportByDay(fromFilePath, toFilePath);
    }
}
