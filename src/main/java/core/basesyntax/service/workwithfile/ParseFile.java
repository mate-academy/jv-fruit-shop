package core.basesyntax.service.workwithfile;

import java.io.File;

public class ParseFile {
    private final String filePath = "src/main/java/core/basesyntax/resources/FruitFiles.csv";

    public String parseFileWithData() {
        File parsedFile = new File(filePath);
        if (!parsedFile.exists()) {
            throw new RuntimeException("File doesn't exist " + filePath);
        }
        if (!parsedFile.isFile()) {
            throw new RuntimeException("The specified path does not lead to a file " + filePath);
        }
        return parsedFile.getPath();
    }
}

