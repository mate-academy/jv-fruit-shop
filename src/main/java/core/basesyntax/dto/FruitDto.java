package core.basesyntax.dto;

import java.time.LocalDate;
import java.util.Objects;

public class FruitDto {
    private String command;
    private String name;
    private int quantity;
    private LocalDate shelfLife;

    public FruitDto(String command, String name, int quantity, LocalDate shelfLife) {
        this.command = command;
        this.name = name;
        this.quantity = quantity;
        this.shelfLife = shelfLife;
    }

    public String getCommand() {
        return command;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public LocalDate getShelfLife() {
        return shelfLife;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        FruitDto fruitDto = (FruitDto) o;
        return quantity == fruitDto.quantity
                && Objects.equals(command, fruitDto.command)
                && Objects.equals(name, fruitDto.name)
                && Objects.equals(shelfLife, fruitDto.shelfLife);
    }

    @Override
    public int hashCode() {
        return Objects.hash(command, name, quantity, shelfLife);
    }
}
