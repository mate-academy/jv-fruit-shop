package core.basesyntax.service.impl;

import core.basesyntax.service.ReadWriteOperations;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;
import java.util.List;

public class ReadWriteOperationsImpl implements ReadWriteOperations {
    @Override
    public List<String> readInfoFromFile(File inputFile) {
        List<String> inputData;
        try {
            inputData = Files.readAllLines(inputFile.toPath());
        } catch (IOException e) {
            throw new RuntimeException("Can't read the file " + inputFile);
        }
        return inputData;
    }

    @Override
    public File writeReport(String data) {
        String nameFile = "Report " + LocalDate.now();
        File reportFile = new File(nameFile);
        try {
            reportFile.createNewFile();
            Files.write(reportFile.toPath(), data.getBytes(), StandardOpenOption.APPEND);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return reportFile;
    }
}
