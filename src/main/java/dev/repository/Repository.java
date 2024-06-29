package dev.repository;

public interface Repository {
    Integer readQuantity(String fruitKey);
    void updateQuantity(String fruitKey, int newQuantity);
}
