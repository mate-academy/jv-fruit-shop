package service.impl;

import java.io.File;
import java.nio.file.Files;
import java.util.List;
import service.FileWriterService;

public class FileWriterServiceImpl implements FileWriterService {

    @Override
    public File writeToFile(String fruitDataToWrite,String fileToWrite) {
        File output = new File(fileToWrite);
        try {
            Files.write(output.toPath(),List.of(fruitDataToWrite.split(" ")));
        } catch (Exception ex) {
            throw new RuntimeException(
                    String.format("Can't write to file %s", fruitDataToWrite), ex);
        }
        return output;
    }
}
