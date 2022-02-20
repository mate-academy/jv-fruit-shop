package dao;

public interface FileHandler {
    String readData(String absolutePath);

    void writeData(String listOfFruits, String absoluteFilePath);
}
