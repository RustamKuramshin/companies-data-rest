package com.zencode.companiesdatarest.repositories;

import com.zencode.companiesdatarest.entities.Department;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.UUID;

@RepositoryRestResource
public interface DepartmentRepository extends PagingAndSortingRepository<Department, UUID> {
}