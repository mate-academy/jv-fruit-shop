package core.basesyntax.service.csvfileservice;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriterService {
    private static final String FILE_NAME = "jv-fruit-shop/src/main/resources/output_data.csv";

    public void writeDataToCsv(String writeData) {
        File file = new File(FILE_NAME);
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file, true))) {
            bufferedWriter.write(writeData);
        } catch (IOException e) {
            throw new RuntimeException("Can't write data to the file " + FILE_NAME, e);
        }
    }
}
