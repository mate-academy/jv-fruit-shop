package core.basesyntax.service.impl;

import core.basesyntax.service.ReportWriterToFileService;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class ReportWriterToFileServiceToCsvImpl implements ReportWriterToFileService {
    private static final String FILE_FORMAT = ".csv";
    private final String pathFile;

    public ReportWriterToFileServiceToCsvImpl(String filePath) {
        this.pathFile = filePath;
    }

    @Override
    public void writeToFile(List<String> lines) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(pathFile))) {
            if (!pathFile.endsWith(FILE_FORMAT)) {
                throw new RuntimeException("Wrong extension of file: "
                        + pathFile + ", must be '" + FILE_FORMAT + "' file");
            }
            for (String line : lines) {
                writer.write(line + '\n');
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't write file to file: " + pathFile, e);
        }
    }
}
