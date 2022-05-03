package service.implementations;

import java.util.List;
import java.util.stream.Collectors;
import model.FruitTransferDto;
import service.inerfaces.TransferService;

public class TransferServiceImpl implements TransferService {
    @Override
    public List<FruitTransferDto> parse(List<String> listOfProducts) {
        return listOfProducts.stream()
            .skip(1)
            .map(s -> new FruitTransferDto(s.split(",")))
            .collect(Collectors.toList());
    }
}
