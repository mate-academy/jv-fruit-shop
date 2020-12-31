package core.activities;

public class SupplyActivitiesHandler implements ActivitiesHandler {
    @Override
    public int getAmountOfFruits(int fruitsInShop, int fruitsInCirculation) {
        if (fruitsInCirculation < 0) {
            throw new RuntimeException("Suppliers can't take negative value of fruits!");
        }
        return fruitsInShop + fruitsInCirculation;
    }
}
