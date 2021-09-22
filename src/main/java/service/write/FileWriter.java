package service.write;

public interface FileWriter {
    void write(String resultString, String pathToWrite);

    String prepareToWrite();
}
