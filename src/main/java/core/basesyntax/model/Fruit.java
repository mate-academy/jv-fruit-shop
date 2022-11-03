package core.basesyntax.model;

import java.util.Objects;

public class Fruit {
    private String name;
    private int amountInShop;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAmountInShop() {
        return amountInShop;
    }

    public void setAmountInShop(int amountInShop) {
        this.amountInShop = amountInShop;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Fruit fruit = (Fruit) obj;
        return amountInShop == fruit.amountInShop && Objects.equals(name, fruit.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, amountInShop);
    }

    @Override
    public String toString() {
        return "Fruit name: " + name + ", amountInShop: " + amountInShop + "\n";
    }
}
