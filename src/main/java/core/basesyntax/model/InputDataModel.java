package core.basesyntax.model;

import java.time.LocalDate;
import java.util.Objects;

public class InputDataModel extends Model {
    private String name;
    private LocalDate date;

    public InputDataModel(String name, LocalDate expirationDate) {
        this.name = name;
        this.date = expirationDate;
    }

    public String getName() {
        return name;
    }

    public LocalDate getDate() {
        return date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        InputDataModel that = (InputDataModel) o;
        return Objects.equals(name, that.name)
                && Objects.equals(date, that.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, date);
    }
}
