package com.zencode.companiesdatarest.configuration;

import com.zencode.companiesdatarest.entities.Company;
import com.zencode.companiesdatarest.validators.BeforeCreateCompanyValidator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.core.event.ValidatingRepositoryEventListener;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

@Configuration
public class CommonConfiguration {

    @Bean
    public RepositoryRestConfigurer repositoryRestConfigurer(BeforeCreateCompanyValidator beforeCreateCompanyValidator) {

        return new RepositoryRestConfigurer() {

            @Override
            public void configureRepositoryRestConfiguration(RepositoryRestConfiguration restConfig, CorsRegistry cors) {
                restConfig.exposeIdsFor(Company.class);
            }

            @Override
            public void configureValidatingRepositoryEventListener(ValidatingRepositoryEventListener validatingListener) {
                validatingListener.addValidator("beforeCreate", beforeCreateCompanyValidator);
            }
        };
    }
}
