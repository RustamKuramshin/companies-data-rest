package com.zencode.companiesdatarest.repositories;

import com.zencode.companiesdatarest.entities.Company;
import com.zencode.companiesdatarest.projections.CompanyInfo;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.UUID;

@RepositoryRestResource(excerptProjection = CompanyInfo.class)
public interface CompanyRepository extends PagingAndSortingRepository<Company, UUID> {

}
