package core.basesyntax;

import core.basesyntax.database.DataBase;
import core.basesyntax.impl.CreateReportImpl;
import core.basesyntax.impl.FileReaderImpl;
import core.basesyntax.impl.FileWriterImpl;
import core.basesyntax.impl.FruitsCalculatorImpl;
import core.basesyntax.service.FileReader;
import core.basesyntax.service.FruitsCalculator;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        FileWriterImpl writer = new FileWriterImpl();
        FileReader reader = new FileReaderImpl();
        CreateReportImpl createReport = new CreateReportImpl();
        FruitsCalculator calculateFruits = new FruitsCalculatorImpl();
        DataBase dataBase = new DataBase();
        List<String> strings = reader.readDataFromFile(dataBase.getDataFilePath());
        Map<String, Integer> map = calculateFruits.parseAndCalculate(strings);
        String report = createReport.createReport(map);
        writer.write(dataBase.getReportFilePath(), report);
    }
}
