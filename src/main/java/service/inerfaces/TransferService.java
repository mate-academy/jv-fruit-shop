package service.inerfaces;

import java.util.List;
import model.FruitTransferDto;

public interface TransferService {
    List<FruitTransferDto> parse(List<String> list);
}
