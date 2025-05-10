package core.basesyntax;

import java.nio.file.Files;
import java.nio.file.Paths;

public class HelloWorld {

    private static final String ERROR = "Please provide input and output file names "
            + "as arguments: <inputFile> <outputFile>";
    private static final String EMPTY = "Input and output file "
            + "names cannot be empty";
    private static final String FILE_NOT_FOUND = "Input file does not exist: ";
    private static final int LENGTH = 2;
    private static final int INPUT_INDEX = 0;
    private static final int OUTPUT_INDEX = 1;

    public static void main(String[] args) {
        if (args.length != LENGTH) {
            throw new IllegalArgumentException(ERROR);
        }

        String inputFilePath = args[INPUT_INDEX];
        String outputFilePath = args[OUTPUT_INDEX];

        if (inputFilePath == null || inputFilePath.trim().isEmpty()
                || outputFilePath == null || outputFilePath.trim().isEmpty()) {
            throw new IllegalArgumentException(EMPTY);
        }

        if (!Files.exists(Paths.get(inputFilePath))) {
            throw new IllegalArgumentException(FILE_NOT_FOUND + inputFilePath);
        }

        Application application = new Application();
        application.run(inputFilePath, outputFilePath);
    }
}
