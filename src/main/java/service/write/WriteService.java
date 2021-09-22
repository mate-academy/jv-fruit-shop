package service.write;

public interface WriteService {
    void write(String resultString, String pathToWrite);

    String prepareToWrite();
}
