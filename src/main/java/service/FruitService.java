package service;

public interface FruitService {
    void put(String name, Integer amount);

    Integer get(String name);

    String getFruitReport();
}
