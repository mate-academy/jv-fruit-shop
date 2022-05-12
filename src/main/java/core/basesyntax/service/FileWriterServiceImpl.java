package core.basesyntax.service;

import com.opencsv.CSVWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;

public class FileWriterServiceImpl implements FileWriterService {
    @Override
    public void write(String pathToFile, String report) {
        try {
            File file = new File(pathToFile);
            FileWriter outputfile = new FileWriter(file);
            CSVWriter writer = new CSVWriter(outputfile,',', '\0', '\0');
            String[] header = {"fruit, quantity"};
            String[] data = {report};
            writer.writeNext(header);
            writer.writeAll(Collections.singleton(data));
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException("Can't write the data to the file");
        }
    }
}
