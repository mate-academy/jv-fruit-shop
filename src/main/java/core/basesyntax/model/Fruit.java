package core.basesyntax.model;

public class Fruit {
    private String name;
    private Integer quantity;
    private Operation operation;


    public Fruit(String name, Integer quantity, Operation operation) {
        this.name = name;
        this.quantity = quantity;
        this.operation = operation;
    }

    public String getName() {
        return name;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public Operation getOperation() {
        return operation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null) {
            return false;
        }
        if (o.getClass().equals(Fruit.class)) {
         Fruit fruit = (Fruit) o;
         return (this.name == fruit.name)
                 || (this.name != null && this.name.equals(fruit.name))
                 && (this.quantity == fruit.quantity)
                 || (this.quantity != null && this.quantity.equals(fruit.quantity))
                 && this.operation == fruit.operation;
        }
        return false;
    }

    @Override
    public int hashCode() {
        int hash = 17;
        hash = 31 * hash + (name == null ? 0 : name.hashCode());
        hash = 31 * hash + (quantity == null ? 0 : quantity.hashCode());
        hash = 31 * hash + (operation == null ? 0 : operation.hashCode());
        return hash;
    }
}
