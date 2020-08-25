package core.basesyntax.processing;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import core.basesyntax.controller.ControllerDao;
import core.basesyntax.controller.ControllerDaoImpl;
import core.basesyntax.model.Fruit;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CsvUtils {
    private CsvStrategy<Fruit> csvStrategy = new CsvStrategyImpl();

    public boolean processFile(String csvInputFile) {
        try (CSVReader reader = new CSVReader(new FileReader(csvInputFile))) {
            String[] line;
            while ((line = reader.readNext()) != null) {
                csvStrategy.chooseOperation(line);
            }
        } catch (IOException e) {
            throw new RuntimeException("No such file for input");
        }
        return true;
    }

    public boolean createReport(String csvOutputFile) {
        ControllerDao<Fruit> controllerDao = new ControllerDaoImpl();
        try (CSVWriter writer = new CSVWriter(new FileWriter(csvOutputFile))) {
            List<String[]> outputLines = new ArrayList<>();
            for (Fruit fruit : controllerDao.getAll()) {
                if (!csvStrategy.countFruit(fruit)) {
                    return false;
                }
            }
            writer.writeAll(csvStrategy.reportStrategy());
            return true;
        } catch (IOException e) {
            throw new RuntimeException("No such file for output");
        }
    }
}
