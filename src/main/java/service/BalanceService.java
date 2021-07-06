package service;

public interface BalanceService<K,V> {
    void updateBalance(K k, V v);

    Integer getBalance(K k);

    String getAll();
}
