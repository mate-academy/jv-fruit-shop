package service;

public interface FileService {
    void getReport(String fromFileName, String toFileName);
    void writeData(String toFileName, String data);
}
