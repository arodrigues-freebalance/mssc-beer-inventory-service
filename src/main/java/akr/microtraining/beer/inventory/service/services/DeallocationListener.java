package akr.microtraining.beer.inventory.service.services;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import akr.microtraining.beer.inventory.service.config.JmsConfig;
import akr.microtraining.brewery.model.events.DeallocateOrderRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Component
public class DeallocationListener {

    private final AllocationService allocationService;

    @JmsListener(destination = JmsConfig.DEALLOCATE_ORDER_QUEUE)
    public void listen(DeallocateOrderRequest request){
        allocationService.deallocateOrder(request.getBeerOrderDto());
    }
}