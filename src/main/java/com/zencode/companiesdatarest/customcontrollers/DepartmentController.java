package com.zencode.companiesdatarest.customcontrollers;

import com.zencode.companiesdatarest.entities.Company;
import com.zencode.companiesdatarest.entities.Department;
import com.zencode.companiesdatarest.repositories.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.rest.webmvc.BasePathAwareController;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.data.rest.webmvc.support.RepositoryEntityLinks;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.ExposesResourceFor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.config.Task;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Objects;

import static org.springframework.hateoas.server.core.WebHandler.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Slf4j
@RequiredArgsConstructor
@RepositoryRestController
public class DepartmentController {

    private final DepartmentRepository departmentRepository;

    private final RepositoryEntityLinks entityLinks;

    @RequestMapping(method = RequestMethod.POST, value = "/departments")
    public @ResponseBody ResponseEntity<EntityModel<Department>> createCompany(
            @RequestBody EntityModel<Department> companyEntityModel) {

        Department department = departmentRepository.save(Objects.requireNonNull(companyEntityModel.getContent()));

        log.info("Департамент создан через кастомный контроллер");

        EntityModel<Department> departmentEntityModel = EntityModel.of(department);

        Link link = entityLinks.linkToItemResource(Department.class, department.getUuid()).withRel("self");

        departmentEntityModel.add(link);

        return ResponseEntity.ok(departmentEntityModel);
    }
}
