package core.basesyntax.service;

import core.basesyntax.db.Storage;
import java.io.BufferedWriter;
import java.io.IOException;

public class FileWriteImpl implements FileWrite {
    @Override
    public void writeDataToFile(String data, String fileFrom) {
        CsvReportCreatorImpl csvReport = new CsvReportCreatorImpl();
        try (BufferedWriter bufferedWriter = new BufferedWriter(new java.io.FileWriter(fileFrom))) {
            bufferedWriter.write(csvReport.createReport(Storage.getStorage()));
        } catch (IOException e) {
            throw new RuntimeException("File can not be written");
        }
    }
}
