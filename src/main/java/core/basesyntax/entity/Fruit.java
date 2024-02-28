package core.basesyntax.entity;

public class Fruit {

    private String name;
    private Batch batch;

    public Fruit(String name, Batch batch) {
        this.name = name;
        this.batch = batch;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Batch getBatch() {
        return batch;
    }

    public void setBatch(Batch batch) {
        this.batch = batch;
    }
}
