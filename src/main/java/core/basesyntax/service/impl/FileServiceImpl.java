package core.basesyntax.service.impl;

import core.basesyntax.service.FileService;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

public class FileServiceImpl implements FileService {
    @Override
    public List<String[]> read(String incomeFile) {
        List<String> reader;
        try {
            reader = Files.readAllLines(Path.of(incomeFile));
        } catch (IOException e) {
            throw new RuntimeException("Can`t read data from file" + Path.of(incomeFile), e);
        }
        return reader.stream()
                .skip(1)
                .map(s -> s.replaceAll(" ", ""))
                .map(string -> string.split(","))
                .collect(Collectors.toList());
    }

    @Override
    public void write(String fileName, String reportData) {
        File reportFile;
        try {
            reportFile = new File(fileName);
            Files.write(reportFile.toPath(), reportData.getBytes());
        } catch (IOException e) {
            throw new RuntimeException("Can't write data to file" + fileName, e);
        }
    }
}
