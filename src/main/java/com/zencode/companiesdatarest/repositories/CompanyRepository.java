package com.zencode.companiesdatarest.repositories;

import com.zencode.companiesdatarest.entities.Company;
import com.zencode.companiesdatarest.entities.QCompany;
import com.zencode.companiesdatarest.projections.CompanyInfo;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.UUID;

@RepositoryRestResource(excerptProjection = CompanyInfo.class)
public interface CompanyRepository extends
        PagingAndSortingRepository<Company, UUID>,
        QuerydslPredicateExecutor<Company>,
        QuerydslBinderCustomizer<QCompany> {

    default void customize(QuerydslBindings bindings, QCompany qCompany) {

        bindings.bind(qCompany.nameLen).first((path, value) -> qCompany.name.length().loe(value));
    }
}
