package core.basesyntax;

import core.basesyntax.database.DataBase;
import core.basesyntax.database.FruitTransaction;
import core.basesyntax.impl.CreateReportImpl;
import core.basesyntax.impl.FileReaderImpl;
import core.basesyntax.impl.FileWriterServiceImpl;
import core.basesyntax.impl.FruitsCalculatorImpl;
import core.basesyntax.service.FileReader;
import core.basesyntax.service.FruitsCalculator;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        FileWriterServiceImpl writer = new FileWriterServiceImpl();
        FileReader reader = new FileReaderImpl();
        CreateReportImpl createReport = new CreateReportImpl();
        FruitsCalculator calculateFruits = new FruitsCalculatorImpl();
        DataBase dataBase = new DataBase();
        List<String> strings = reader.readDataFromFile(dataBase.getDataFilePath());
        List<FruitTransaction> fruitTransactions = calculateFruits.parseData(strings);
        Map<String, Integer> map = calculateFruits.applyQuantity(fruitTransactions);
        String report = createReport.createReport(map);
        writer.write(dataBase.getReportFilePath(), report);

    }
}
