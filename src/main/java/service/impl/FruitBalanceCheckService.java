package service.impl;

public class FruitBalanceCheckService {
    public void checkNegativeBalance(int balance, String fruit) {
        if (balance < 0) {
            throw new RuntimeException("The balance of "
                    + fruit + " is negative: "
                    + balance);
        }
    }
}
