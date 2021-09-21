package core.basesyntax.fileManager;

import java.util.Set;

public interface FileService {
    String readeDataFromFileSource(String absolutePath);

    void writeReportToFile(String listOfFruits, String absoluteFilePath);
}
