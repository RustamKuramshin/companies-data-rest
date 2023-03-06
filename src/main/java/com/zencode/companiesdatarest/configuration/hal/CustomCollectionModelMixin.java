package com.zencode.companiesdatarest.configuration.hal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.mediatype.hal.Jackson2HalModule;

import java.util.Collection;

@JsonIgnoreProperties(value = {"_links"})
public abstract class CustomCollectionModelMixin<T> extends CollectionModel<T> {

    @Override
    @JsonValue
    @JsonInclude(Include.NON_EMPTY)
    @JsonSerialize(using = Jackson2HalModule.HalResourcesSerializer.class)
    @JsonDeserialize(using = Jackson2HalModule.HalResourcesDeserializer.class)
    public abstract Collection<T> getContent();

}
