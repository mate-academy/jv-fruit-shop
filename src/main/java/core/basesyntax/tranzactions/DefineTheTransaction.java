package core.basesyntax.tranzactions;

public class DefineTheTransaction {
    public void definition(String k,String fruit,Integer value) {
        if (k.equals("b")) {
            new BalanceTransaction().makeTransaction(fruit, value);
        }
        if (k.equals("s")) {
            new SupplyTransaction().makeTransaction(fruit, value);
        }
        if (k.equals("p")) {
            new PurchaseTransaction().makeTransaction(fruit, value);
        }
        if (k.equals("r")) {
            new ReturnTransaction().makeTransaction(fruit, value);
        }
    }
}
