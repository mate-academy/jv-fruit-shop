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
    private static final String INPUT_PATH  = "src/main/java/core/basesyntax/resources/input.csv";
    private static final String outputPath = "src/main/java/core/basesyntax"
            + "/resources/output.csv";

    public static void main(String[] args) {
        FileDataReader fileDataReader = null;
        try {
            fileDataReader = new FileDataReaderImpl(new FileReader(INPUT_PATH));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        List<String> inputData = fileDataReader.readData(Path.of(INPUT_PATH));
        FileDataWriter fileDataWriter = new FileDataWriterImpl(Path.of(outputPath));

        FruitStrategy fruitStrategy = new FruitStrategyImpl();

        DataProcessing dataProcessing = new DataProcessingImpl((FruitStrategyImpl) fruitStrategy);

        List<String> processedData = dataProcessing.processData(inputData);

        File outputFile = fileDataWriter.writeData(processedData);

        System.out.println("Data processing complete. Output file: "
                + outputFile.getAbsolutePath());
    }
}
