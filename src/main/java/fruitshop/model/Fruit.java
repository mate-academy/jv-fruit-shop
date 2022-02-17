package fruitshop.model;

public class Fruit {
    private String nameFruit;

    public Fruit(String nameFruit) {
        this.nameFruit = nameFruit;
    }

    public String getNameFruit() {
        return nameFruit;
    }

    public void setNameFruit(String nameFruit) {
        this.nameFruit = nameFruit;
    }

    @Override
    public boolean equals(Object check) {
        if (check == null) {
            return false;
        }

        if (check == this) {
            return true;
        }

        if (check.getClass() != this.getClass()) {
            return false;
        }

        Fruit castObject = (Fruit) check;
        return (this.nameFruit == castObject.nameFruit
                || castObject.nameFruit != null && this.nameFruit.equals(castObject.nameFruit));
    }

    @Override
    public int hashCode() {
        int prime = 17;
        return (prime * 31 + (nameFruit == null ? 0 : nameFruit.hashCode()));
    }
}
