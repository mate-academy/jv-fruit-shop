package service;

public interface ParseDataService {
    String getOperation();

    String getTypeOfFruit();

    int getQuantityOfFruit();

    void parseString(String s);

    void clear();
}
