package fruite.store;

import fruite.store.dao.ReadDateDao;
import fruite.store.dao.ReadDateFromFileDaoImpl;
import fruite.store.dao.WriteDateDao;
import fruite.store.dao.WriteDateToFileDaoImpl;
import fruite.store.service.FruitService;
import fruite.store.service.FruitServiceImpl;
import fruite.store.service.strategy.StrategyType;

public class Main {
    public static void main(String[] args) {
        String fromFilePath = "src/main/resources/activities-by-day.csv";
        String toFilePath = "src/main/resources/report-by-day.csv";
        StrategyType strategyType = new StrategyType();
        ReadDateDao readDateDao = new ReadDateFromFileDaoImpl();
        WriteDateDao writeDateDao = new WriteDateToFileDaoImpl();
        FruitService fruitService = new FruitServiceImpl(strategyType, readDateDao, writeDateDao);
        fruitService.makeReportByDay(fromFilePath, toFilePath);
    }
}
