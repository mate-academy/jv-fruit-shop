package core.basesyntax.writer;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;

public class FileWriterImpl implements FileWriter {
    @Override
    public void write(String resultingReport, String filePath) {
        try (BufferedWriter bufferedWriter =
                    new BufferedWriter(
                            new java.io.FileWriter(
                                    new File(filePath)
                            )
                    )
        ) {
            bufferedWriter.write(resultingReport);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
