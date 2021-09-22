package core.basesyntax.servises;

import java.util.ArrayList;
import java.util.List;

public class Mapper {
    private static final int TYPE = 0;
    private static final int NAME = 1;
    private static final int QUANTITY = 2;
    private static final String SEPARATOR = ",";

    public List<TransferDto> apply(List<String> list) {
        List<TransferDto> data = new ArrayList<>();
        for (int i = 1; i < list.size(); i++) {
            String[] rows = list.get(i).split(SEPARATOR);
            if (rows.length != 3) {
                throw new RuntimeException("Data is incorrect");
            }
            if (!"bprs".contains(rows[TYPE])) {
                throw new RuntimeException("OperationType isn't valid");
            }
            if ((Integer.parseInt(rows[QUANTITY]) < 0)) {
                throw new RuntimeException("Quantity is incorrect");
            }
            TransferDto dto = new TransferDto(OperationType.fromString(rows[0]),
                        rows[NAME], Integer.parseInt(rows[QUANTITY]));
            data.add(dto);
        }
        return data;
    }
}
