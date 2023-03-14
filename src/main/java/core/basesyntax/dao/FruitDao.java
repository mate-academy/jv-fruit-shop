package core.basesyntax.dao;

import java.util.List;

public interface FruitDao {

    void put(String fruit, int amount);

    int get(String fruit);

    boolean isContains(String fruit);

    List<FruitDto> getFruits();

    final class FruitDto {
        private final String fruit;
        private final int amount;

        public FruitDto(String fruit, int amount) {
            this.fruit = fruit;
            this.amount = amount;
        }

        public String getFruit() {
            return fruit;
        }

        public int getAmount() {
            return amount;
        }
    }
}
