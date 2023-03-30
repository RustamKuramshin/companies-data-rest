package com.zencode.companiesdatarest.configuration.hal;

import org.springframework.context.annotation.Bean;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.mediatype.hal.Jackson2HalModule;

//@Configuration
public class SpringDataRestHalConfiguration {

    @Bean
    public Jackson2HalModule replacementInHalModuleModelClassOnModelMixinClass() {
        Jackson2HalModule halModule = new Jackson2HalModule();
        halModule.setMixInAnnotation(RepresentationModel.class, CustomRepresentationModelMixin.class);
        halModule.setMixInAnnotation(CollectionModel.class, CustomCollectionModelMixin.class);

        return halModule;
    }

}
