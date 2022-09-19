package service.writereadcsv;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class FruitServiceWriterCsvImpl implements FruitServiceWriterCsv {

    @Override
    public void writeToFileCsv(String report, String fileToPath) {
        File file = new File(fileToPath);
        try {
            Files.write(file.toPath(), report.getBytes());
        } catch (IOException e) {
            throw new RuntimeException("Can't write data to the file " + file.getPath(), e);
        }
    }
}
