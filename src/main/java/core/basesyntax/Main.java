package core.basesyntax;

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
import java.io.FileReader;
import java.nio.file.Path;
import java.util.List;

public class Main {
    private static final String inputPath = "src/main/java/core/basesyntax/resources/input.csv";
    private static final String outputPath = "src/main/java/core/basesyntax"
            + "/resources/output.csv";

    public static void main(String[] args) {
        Path inPath = Path.of(inputPath);

        FileDataReader fileDataReader = null;
        try {
            fileDataReader = new FileDataReaderImpl(
                    new FileReader(String.valueOf(inPath)));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        FileDataWriter fileDataWriter = new FileDataWriterImpl(Path.of(outputPath));

        FruitStrategy fruitStrategy = new FruitStrategyImpl();

        DataProcessing dataProcessing = new DataProcessingImpl((FruitStrategyImpl) fruitStrategy);

        List<String> inputData = fileDataReader.readData(inPath);

        List<String> processedData = dataProcessing.processData(inputData);

        File outputFile = fileDataWriter.writeData(processedData);

        System.out.println("Data processing complete. Output file: "
                + outputFile.getAbsolutePath());
    }
}
