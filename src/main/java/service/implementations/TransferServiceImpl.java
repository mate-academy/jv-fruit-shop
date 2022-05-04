package service.implementations;

import java.util.List;
import java.util.stream.Collectors;
import model.Fruit;
import model.FruitTransferDto;
import service.inerfaces.TransferService;

public class TransferServiceImpl implements TransferService {
    @Override
    public List<FruitTransferDto> parse(List<String> listOfProducts) {
        return listOfProducts.stream()
            .skip(1)
            .map(s -> new FruitTransferDto(s.substring(0, s.indexOf(",")),
                    new Fruit(s.substring(s.indexOf(",") + 1, s.lastIndexOf(","))),
                    Integer.parseInt(s.substring(s.lastIndexOf(",") + 1))))
            .collect(Collectors.toList());
    }
}
