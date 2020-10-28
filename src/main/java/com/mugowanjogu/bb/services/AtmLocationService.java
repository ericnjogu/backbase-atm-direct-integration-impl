package com.mugowanjogu.bb.services;

import com.backbase.location.rest.spec.v1.locations.Location;
import com.backbase.location.rest.spec.v1.locations.LocationsGetResponseBody;
import com.mugowanjogu.bb.mappers.AtmLocationMapper;
import com.openbankproject.api.invoker.ApiException;
import com.openbankproject.api.model.InlineResponse200;
import com.openbankproject.api.spec.ATMApi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.stream.Collectors;

public class AtmLocationService {
    private static final Logger LOG = LoggerFactory.getLogger(AtmLocationService.class);
    private ATMApi atmApi;
    private AtmLocationMapper atmLocationMapper;

    public AtmLocationService(ATMApi atmApi, AtmLocationMapper atmLocationMapper) {
        this.atmApi = atmApi;
        this.atmLocationMapper = atmLocationMapper;
    }

    public LocationsGetResponseBody getATMLocations() {
        try {
            final InlineResponse200 inlineResponse200 = atmApi.atmsGet(null, null);
            final List<Location> locations = inlineResponse200.getData()
                    .stream()
                    .flatMap(a -> a.getBrand().stream())
                    .flatMap(b -> b.getATM().stream())
                    .map(atmLocationMapper::mapAtmToLocation).collect(Collectors.toList());
            return new LocationsGetResponseBody().withLocations(locations);
        } catch (ApiException e) {
            LOG.error(e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
