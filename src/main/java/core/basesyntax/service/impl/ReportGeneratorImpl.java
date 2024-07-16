package core.basesyntax.service.impl;

import core.basesyntax.db.FruitTransaction;
import core.basesyntax.service.ReportGenerator;
import java.util.List;

public class ReportGeneratorImpl implements ReportGenerator {
    @Override
    public List<FruitTransaction> generateReport(List<FruitTransaction> listOfBalance,
                                                 List<FruitTransaction> listOfSupply,
                                                 List<FruitTransaction> listOfPurchase,
                                                 List<FruitTransaction> listOfReturn) {
        for (FruitTransaction balanceFruit : listOfBalance) {
            for (FruitTransaction supplyFruit : listOfSupply) {
                if (supplyFruit.getFruit().equals(balanceFruit.getFruit())) {
                    int balanceQuantity = balanceFruit.getQuantity();
                    int supplyQuantity = supplyFruit.getQuantity();
                    balanceFruit.setQuantity(balanceQuantity + supplyQuantity);
                }
            }
        }
        for (FruitTransaction balanceFruit : listOfBalance) {
            for (FruitTransaction returnFruit : listOfReturn) {
                if (returnFruit.getFruit().equals(balanceFruit.getFruit())) {
                    int balanceQuantity = balanceFruit.getQuantity();
                    int returnQuantity = returnFruit.getQuantity();
                    balanceFruit.setQuantity(balanceQuantity + returnQuantity);
                }
            }
        }
        for (FruitTransaction balanceFruit : listOfBalance) {
            for (FruitTransaction purchaseFruit : listOfPurchase) {
                if (purchaseFruit.getFruit().equals(balanceFruit.getFruit())) {
                    int balanceQuantity = balanceFruit.getQuantity();
                    int purchaseQuantity = purchaseFruit.getQuantity();
                    balanceFruit.setQuantity(balanceQuantity - purchaseQuantity);
                }
            }
        }
        return listOfBalance;
    }
}
