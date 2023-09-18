package core.basesyntax.service.workwithfile;

import java.io.File;
import java.io.IOException;

public class CreateFile {

    public String createFile() {
        String filePath = "src/main/java/core/basesyntax/resources/reportFiles/report.csv";
        File reportFile = new File(filePath);
        try {
            reportFile.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException("Can't create file " + e);
        }
        return reportFile.getPath();
    }
}



