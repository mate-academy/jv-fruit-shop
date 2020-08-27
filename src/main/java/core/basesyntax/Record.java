package core.basesyntax;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Record {
    private RecordType type;
    private String productName;
    private int count;
    private LocalDate date;

    public Record(String inputType, String inputProduct, String inputCount, String inputDate) {
        setType(inputType);
        productName = inputProduct;
        setCount(Integer.parseInt(inputCount));
        setDate(LocalDate.parse(inputDate, DateTimeFormatter.ISO_LOCAL_DATE));
    }

    public RecordType getType() {
        return type;
    }

    public void setType(String stringType) {
        switch (stringType) {
            case "s":
                type = RecordType.s;
                break;
            case "b":
                type = RecordType.b;
                break;
            case "r":
                type = RecordType.r;
                break;
            default: {
                throw new RuntimeException("Unsupported record type: [" + stringType + "]");
            }
        }
    }

    public String getProductName() {
        return productName;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
