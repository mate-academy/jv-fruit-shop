package core.basesyntax;

import core.basesyntax.database.DataBase;
import core.basesyntax.database.FruitActivity;
import core.basesyntax.impl.CalculateFruitsImpl;
import core.basesyntax.impl.FileReaderImpl;
import core.basesyntax.impl.FileWriterImpl;
import core.basesyntax.service.CalculateFruits;
import core.basesyntax.service.FileReaderInterface;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        FileWriterImpl write = new FileWriterImpl();
        FileReaderInterface read = new FileReaderImpl();
        CalculateFruits calculateFruits = new CalculateFruitsImpl();
        DataBase dataBase = new DataBase();
        List<FruitActivity> fruitActivities = read.readDataFromFile(dataBase.getDataFilePath());
        Map<String, Integer> calculate = calculateFruits.calculate(fruitActivities);
        write.writeReport(dataBase.getReportFilePath(), calculate);
    }
}
