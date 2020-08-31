package core.basesyntax.fileservice;

import core.basesyntax.storage.Storage;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.FileSystems;

public class LocalFileWriterImpl implements LocalFileWriter {
    private static final String OUTPUT_HEADER = "fruit, quantity\n";

    @Override
    public void writeToFile(String[] fileInfo, Storage storage) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileInfo[0]
                + FileSystems.getDefault().getSeparator()
                + "report_" + fileInfo[1]))) {
            writer.write(OUTPUT_HEADER);
            writer.write(storage.outputProducts());
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
