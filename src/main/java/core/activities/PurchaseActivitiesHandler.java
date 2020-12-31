package core.activities;

public class PurchaseActivitiesHandler implements ActivitiesHandler {
    @Override
    public int getAmountOfFruits(int fruitsInShop, int fruitsInCirculation) {
        if (fruitsInCirculation < 0 || fruitsInCirculation > fruitsInShop) {
            throw new RuntimeException("Buyers can't buy this amount of fruits: "
                    + fruitsInCirculation);
        }
        return fruitsInShop - fruitsInCirculation;
    }
}
