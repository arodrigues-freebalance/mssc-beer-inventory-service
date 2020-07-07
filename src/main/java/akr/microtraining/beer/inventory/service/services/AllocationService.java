package akr.microtraining.beer.inventory.service.services;

import akr.microtraining.brewery.model.BeerOrderDto;

public interface AllocationService {

    Boolean allocateOrder(BeerOrderDto beerOrderDto);
}