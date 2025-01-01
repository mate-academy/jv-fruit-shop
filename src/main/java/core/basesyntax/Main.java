package core.basesyntax;

import core.basesyntax.model.Fruit;
import core.basesyntax.services.DataProcessing;
import core.basesyntax.services.FileDataReader;
import core.basesyntax.services.FileDataWriter;
import core.basesyntax.services.impl.DataProcessingImpl;
import core.basesyntax.services.impl.FileDataReaderImpl;
import core.basesyntax.services.impl.FileDataWriterImpl;
import core.basesyntax.strategy.FruitStrategy;
import core.basesyntax.strategy.FruitStrategyImpl;
import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Path inputPath = Paths.get("src/main/java/core/basesyntax/resources/input.csv");

        FileDataReader fileDataReader = new FileDataReaderImpl(
                new java.io.FileReader(String.valueOf(inputPath)));
        FileDataWriter fileDataWriter = new FileDataWriterImpl("src/main/java/core/basesyntax"
                + "/resources/output.csv");

        Fruit fruit = new Fruit();

        FruitStrategy fruitStrategy = new FruitStrategyImpl(fruit);

        DataProcessing dataProcessing = new DataProcessingImpl((FruitStrategyImpl) fruitStrategy);

        List<String> inputData = fileDataReader.readData(inputPath);

        List<String> processedData = dataProcessing.processData(inputData);

        File outputFile = fileDataWriter.writeData(processedData);

        System.out.println("Data processing complete. Output file: "
                + outputFile.getAbsolutePath());
    }
}
