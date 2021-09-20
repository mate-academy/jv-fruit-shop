package core.basesyntax.service;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FileServiceImpl implements FileService {

    @Override
    public List<String> readFromFile(String fromFileName) {
        File fileToRead = new File(fromFileName);
        List<String> fileLines;
        try {
            fileLines = Files.readAllLines(Path.of(fromFileName));
        } catch (IOException exc) {
            throw new RuntimeException("Wrong file or path" + fromFileName);
        }
        return fileLines;
    }

    @Override
    public void writeToFile(String toWriteFile, String toWriteData) {
        File fileToWrite = new File(toWriteFile);
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileToWrite, false));
            writer.write(toWriteData);
            writer.close();
        } catch (IOException exc) {
            throw new RuntimeException("Can't write to file:" + fileToWrite, exc);
        }
    }
}
