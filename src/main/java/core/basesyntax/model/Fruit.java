package core.basesyntax.model;

import java.util.Objects;

public class Fruit {
    private String type;

    public Fruit(String type){
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj)  {
            return true;
        }
        if(obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Fruit fruit = (Fruit) obj;
        return Objects.equals(type, fruit.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type);
    }
}
