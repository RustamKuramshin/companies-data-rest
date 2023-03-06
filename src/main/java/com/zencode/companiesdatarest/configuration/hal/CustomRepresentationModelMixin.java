package com.zencode.companiesdatarest.configuration.hal;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.springframework.hateoas.Links;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.mediatype.hal.Jackson2HalModule;

@JsonIgnoreProperties(value = {"_links"})
public abstract class CustomRepresentationModelMixin extends RepresentationModel<CustomRepresentationModelMixin> {

    @Override
    @JsonIgnore
    @JsonInclude(Include.NON_EMPTY)
    @JsonSerialize(using = Jackson2HalModule.HalLinkListSerializer.class)
    @JsonDeserialize(using = Jackson2HalModule.HalLinkListDeserializer.class)
    public abstract Links getLinks();

}
