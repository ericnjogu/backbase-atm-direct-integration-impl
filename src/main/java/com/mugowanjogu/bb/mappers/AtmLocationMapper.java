package com.mugowanjogu.bb.mappers;

import com.backbase.location.rest.spec.v1.locations.Location;
import com.openbankproject.api.model.InlineResponse200ATM;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper
public interface AtmLocationMapper {
    @Mappings({
            @Mapping(source = "identification", target = "id"),
            @Mapping(source = "location.site.name", target = "name"),
            @Mapping(constant = "ATM", target = "type"),
            @Mapping(source = "location.postalAddress.buildingNumber", target = "address.nameOrNumber"),
            @Mapping(source = "location.postalAddress.streetName", target = "address.street"),
            @Mapping(source = "location.postalAddress.townName", target = "address.town"),
            @Mapping(source = "location.postalAddress.country", target = "address.country"),
            @Mapping(source = "location.postalAddress.postCode", target = "address.postcode"),
            @Mapping(source = "location.postalAddress.geoLocation.geographicCoordinates.latitude", target = "coordinates.latitude"),
            @Mapping(source = "location.postalAddress.geoLocation.geographicCoordinates.longitude", target = "coordinates.longitude")
    })
    Location mapAtmToLocation(InlineResponse200ATM atm);
}
