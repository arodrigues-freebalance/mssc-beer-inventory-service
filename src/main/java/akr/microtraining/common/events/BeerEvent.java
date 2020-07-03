package akr.microtraining.common.events;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BeerEvent implements Serializable{

	private static final long serialVersionUID = 4642844020950488476L;
	
	private BeerDto beerDto;
	
}
