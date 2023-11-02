package core.basesyntax.service;

public interface ParseDailyDataFromFileService {

    char getType(String line);

    String getFruitName(String line);

    int getQuantity(String line);
}
