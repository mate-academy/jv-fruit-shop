package core.basesyntax.files;

public interface FileService {
    String readeDataFromFileSource(String absolutePath);

    void writeReportToFile(String listOfFruits, String absoluteFilePath);
}
