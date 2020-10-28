package com.mugowanjogu.bb.api;

import com.backbase.location.rest.spec.v1.locations.LocationsApi;
import com.backbase.location.rest.spec.v1.locations.LocationsGetResponseBody;
import com.mugowanjogu.bb.services.AtmLocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
public class AtmLocationsController implements LocationsApi {
    private AtmLocationService atmLocationService;

    @Autowired
    public AtmLocationsController(AtmLocationService atmLocationService) {
        this.atmLocationService = atmLocationService;
    }

    @Override
    public LocationsGetResponseBody getLocations(
            HttpServletRequest httpServletRequest,
            HttpServletResponse httpServletResponse
    ) {
        return atmLocationService.getATMLocations();
    }
}
