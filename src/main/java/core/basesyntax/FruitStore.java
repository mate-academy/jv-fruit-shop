package core.basesyntax;

import core.basesyntax.interfaces.FruitOperation;
import core.basesyntax.interfaces.FruitOperationImpl;
import core.basesyntax.interfaces.ReadFromFile;
import core.basesyntax.interfaces.ReadFromFileImpl;
import core.basesyntax.interfaces.ReportGenerator;
import core.basesyntax.interfaces.ReportGeneratorImpl;
import core.basesyntax.interfaces.WriteToFile;
import core.basesyntax.interfaces.WriteToFileImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Feel free to remove this class and create your own.
 */
public class FruitStore {

    public static void main(String[] args) {
        String inputFile = "input.csv";
        String outputFile = "output.csv";
        Map<String, Integer> stock = new HashMap<>();

        ReadFromFile reader = new ReadFromFileImpl();
        List<FruitRecord> records = reader.read(inputFile);

        FruitOperation fruitOperation = new FruitOperationImpl();
        for (FruitRecord record : records) {
            fruitOperation.process(record, stock);
        }

        ReportGenerator reportGenerator = new ReportGeneratorImpl();
        List<String> report = reportGenerator.generate(stock);

        WriteToFile writer = new WriteToFileImpl();
        writer.write(outputFile, report);
    }
}
