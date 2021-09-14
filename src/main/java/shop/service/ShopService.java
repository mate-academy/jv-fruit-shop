package shop.service;

public interface ShopService {
    void saveToStorage(String[] linesFromFile);

    void printReport();
}
