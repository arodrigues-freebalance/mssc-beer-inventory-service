package akr.microtraining.beer.inventory.service.services;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import akr.microtraining.beer.inventory.service.config.JmsConfig;
import akr.microtraining.beer.inventory.service.domain.BeerInventory;
import akr.microtraining.beer.inventory.service.repositories.BeerInventoryRepository;
import akr.microtraining.common.events.NewInventoryEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Component
public class NewInventoryListener {

    private final BeerInventoryRepository beerInventoryRepository;

    @JmsListener(destination = JmsConfig.NEW_INVENTORY_QUEUE)
    public void listen(NewInventoryEvent event){

        log.debug("Got Inventory: " + event.toString());

        beerInventoryRepository.save(BeerInventory.builder()
                .beerId(event.getBeerDto().getId())
                .upc(event.getBeerDto().getUpc())
                .quantityOnHand(event.getBeerDto().getQuantityOnHand())
                .build());
    }

}