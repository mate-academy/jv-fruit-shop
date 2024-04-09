package service.impl;

import java.io.File;
import java.io.IOException;
import service.FileCreator;

public class ReportFileCreatorImpl implements FileCreator {
    private static final String PATH_TO_REPORT_FILE = "src/main/java/resources/Report.csv";

    @Override
    public File createFile() {
        File file = new File(PATH_TO_REPORT_FILE);
        try {
            file.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException("Can't create file " + PATH_TO_REPORT_FILE, e);
        }
        return file;
    }
}
