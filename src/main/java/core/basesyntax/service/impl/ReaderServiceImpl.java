package core.basesyntax.service.impl;

import core.basesyntax.service.ReaderService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class ReaderServiceImpl implements ReaderService {

    @Override
    public List<String> getInformationFromCvsFile(String fileName) {
        if (fileName == null) {
            throw new RuntimeException("Please enter a file name!");
        }
        List<String> fileInformation;
        try {
            fileInformation = Files.readAllLines(Path.of(fileName));
        } catch (IOException e) {
            throw new RuntimeException("Can't find file by path: " + fileName, e);
        }
        return fileInformation;
    }
}
