package core.basesyntax.model;

import java.util.Objects;

public class ShopItem {
    private final String name;

    public ShopItem(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShopItem shopItem = (ShopItem) o;
        return Objects.equals(name, shopItem.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
