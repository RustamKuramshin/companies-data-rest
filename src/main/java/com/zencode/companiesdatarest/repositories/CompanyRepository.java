package com.zencode.companiesdatarest.repositories;

import com.zencode.companiesdatarest.entities.Company;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.UUID;

@RepositoryRestResource
public interface CompanyRepository extends PagingAndSortingRepository<Company, UUID> {

}
