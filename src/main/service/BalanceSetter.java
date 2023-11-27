package main.service;

import main.dao.ReportDao;
import main.model.Product;

import java.util.List;

public interface BalanceSetter {
    void setBalance(List<Product> products);
}
