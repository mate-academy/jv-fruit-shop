package core.basesyntax;

import core.basesyntax.dao.Dao;
import core.basesyntax.dao.DaoFromFileStorage;
import core.basesyntax.model.Fruit;
import core.basesyntax.servce.Calculations;
import core.basesyntax.storage.filestorage.FileStorage;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Dao dao = new DaoFromFileStorage(FileStorage.getInstance());
        Calculations calculations = new Calculations(dao);
        Map<Fruit, Integer> report = calculations.generateReport();
        dao.saveResults(report);
    }
}
