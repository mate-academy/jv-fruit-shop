package core.basesyntax.service.impls;

import core.basesyntax.service.FileService;


import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class FileServiceImpl implements FileService {
    @Override
    public List<String> readFile(String inputDataFile) {
        Path filePath = Paths.get(inputDataFile);
        try {
            return Files.lines(filePath)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException("Can't read data from file " + inputDataFile, e);
        }
    }

    @Override
    public void writeToFile(String report, String outputDataFile) {
        Path path = Paths.get(outputDataFile);
        try {
            Files.write(path,report.getBytes());
        } catch (IOException e) {
            throw new RuntimeException("Can't write data to file " + outputDataFile, e);
        }
    }
}
