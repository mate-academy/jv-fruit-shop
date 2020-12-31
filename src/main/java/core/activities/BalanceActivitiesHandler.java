package core.activities;

public class BalanceActivitiesHandler implements ActivitiesHandler {
    @Override
    public int getAmountOfFruits(int fruitsInShop, int fruitsInCirculation) {
        if (fruitsInCirculation < 0) {
            throw new RuntimeException("Incorrect value of balance in the shop: "
                    + fruitsInCirculation);
        }
        return fruitsInShop + fruitsInCirculation;
    }
}
