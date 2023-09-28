package core.basesyntax.service.fileservices;

import java.io.File;

public class ParseFile {
    public String parseFileWithData(String filePath) {
        File parsedFile = new File(filePath);
        if (!parsedFile.exists()) {
            throw new RuntimeException("File doesn't exist " + filePath);
        }
        if (!parsedFile.isFile()) {
            throw new RuntimeException("The specified path doesn't lead to a file " + filePath);
        }
        return parsedFile.getPath();
    }
}

