package akr.microtraining.brewery.model.events;

import akr.microtraining.brewery.model.BeerDto;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class NewInventoryEvent extends BeerEvent{

	private static final long serialVersionUID = -870119210138969042L;

	public NewInventoryEvent(BeerDto beerDto) {
		super(beerDto);			
	}


}
