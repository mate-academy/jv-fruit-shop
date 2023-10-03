package core.basesyntax.dao;

public interface FileService {
    String readData(String fileName);

    void makeReport(String report, String fileName);
}
