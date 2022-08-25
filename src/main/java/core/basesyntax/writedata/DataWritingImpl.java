package core.basesyntax.writedata;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class DataWritingImpl implements DataWriting {

    @Override
    public void writeData(String fileReport, String dataReports) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileReport, true))) {
            writer.write(dataReports);
        } catch (IOException e) {
            throw new RuntimeException("Can't write data to file"
                    + fileReport, e);
        }
    }
}
