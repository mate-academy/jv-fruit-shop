package service;

public interface ShopService {
    boolean execProductTransaction(String productname,
                                   Double productAmount,
                                   String operationString);
}
