package core.basesyntax.service.serviceimpl;

import core.basesyntax.service.CsvWriterService;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class CsvWriterServiceImpl implements CsvWriterService {

    @Override
    public void writeToFile(String resultData, String toFileName) {
        File file = new File("src/main/resources/" + toFileName);

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file, true))) {
            bufferedWriter.write(resultData);
        } catch (IOException e) {
            throw new RuntimeException("Can't write data to file: " + toFileName, e);
        }
    }
}
