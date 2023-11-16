package service;

public interface CommissionStrategy {
    CommissionHandler getCommissionHandler(Account.Type type);
}
