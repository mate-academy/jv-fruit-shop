package core.basesyntax;

import core.basesyntax.dao.FileDataReaderImpl;
import core.basesyntax.dao.FileDataWriterImpl;
import core.basesyntax.model.Fruit;
import core.basesyntax.strategy.FruitStrategyImpl;
import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Path inputPath = Paths.get("C:\\Users\\yarik\\IdeaProjects" +
                "\\jv-fruit-shop\\src\\main\\java\\core\\basesyntax\\input.csv");

        FileDataReaderImpl fileDataReader = new FileDataReaderImpl(
                new java.io.FileReader(String.valueOf(inputPath)));
        FileDataWriterImpl fileDataWriter = new FileDataWriterImpl("output.csv");

        Fruit fruit = new Fruit();

        FruitStrategyImpl fruitStrategy = new FruitStrategyImpl(fruit);

        DataProcessingImpl dataProcessing = new DataProcessingImpl(fruitStrategy);

        List<String> inputData = fileDataReader.readData(inputPath);

        List<String> processedData = dataProcessing.processData(inputData);

        File outputFile = fileDataWriter.writeData(processedData);

        System.out.println("Data processing complete. Output file: "
                + outputFile.getAbsolutePath());
    }
}
