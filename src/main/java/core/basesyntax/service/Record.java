package core.basesyntax.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Record {
    private TypeOfOperation type;
    private String name;
    private int quantity;
    private LocalDate date;

    public Record(String inputType, String inputName, String inputQuantity, String inputDate) {
        setType(inputType);
        name = inputName;
        setQuantity(Integer.parseInt(inputQuantity));
        setDate(LocalDate.parse(inputDate, DateTimeFormatter.ISO_LOCAL_DATE));
    }

    public TypeOfOperation getType() {
        return type;
    }

    public void setType(String stringType) {
        type = TypeOfOperation.valueOf(stringType);
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
