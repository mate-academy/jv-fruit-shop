package core.basesyntax;

import java.io.File;
import java.io.IOException;

public class FileCreator {

    public static final String REPORT_FILE_PATH = "src/main/resources/reportToRead.csv";

    public static void createFile(String content) {
        File file = new File(REPORT_FILE_PATH);
        try {
            if (file.createNewFile()) {
                System.out.println("File created: " + file.getName());
            } else {
                System.out.println("File already exists.");
            }

            FileWriter fileWriter = new FileWriterImpl();
            fileWriter.write(content, REPORT_FILE_PATH);
            System.out.println("Successfully wrote to the file.");

        } catch (IOException e) {
            throw new RuntimeException("File operation error" + REPORT_FILE_PATH, e);
        }
    }

    public static String getReportFilePath() {
        return REPORT_FILE_PATH;
    }
}
