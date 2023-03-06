package com.zencode.companiesdatarest.eventhandlers;

import com.zencode.companiesdatarest.entities.Company;
import com.zencode.companiesdatarest.entities.Department;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.rest.core.annotation.HandleAfterCreate;
import org.springframework.data.rest.core.annotation.HandleAfterDelete;
import org.springframework.data.rest.core.annotation.HandleAfterLinkDelete;
import org.springframework.data.rest.core.annotation.HandleAfterLinkSave;
import org.springframework.data.rest.core.annotation.HandleAfterSave;
import org.springframework.data.rest.core.annotation.HandleBeforeCreate;
import org.springframework.data.rest.core.annotation.HandleBeforeDelete;
import org.springframework.data.rest.core.annotation.HandleBeforeLinkDelete;
import org.springframework.data.rest.core.annotation.HandleBeforeLinkSave;
import org.springframework.data.rest.core.annotation.HandleBeforeSave;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Slf4j
@RequiredArgsConstructor
@RepositoryEventHandler
@Component
public class CompanyEventHandler {

    @PersistenceContext
    private final EntityManager em;

    @HandleBeforeCreate // POST /companies
    public void handleBeforeCreate(Company company) {
        log.info("handleBeforeCreate");
    }

    @HandleAfterCreate // POST /companies
    public void handleAfterCreate(Company company) {
        log.info("handleAfterCreate");
    }

    @HandleBeforeSave // PUT, PATCH /companies
    public void handleBeforeSave(Company company) {
//        em.detach(company);
        log.info("handleBeforeSave");
    }

    @HandleAfterSave // PUT, PATCH /companies
    public void handleAfterSave(Company company) {
        log.info("handleAfterSave");
    }

    @HandleBeforeDelete // DELETE /companies
    public void handleBeforeDelete(Company company) {
        log.info("handleBeforeDelete");
    }

    @HandleAfterDelete // DELETE /companies
    public void handleAfterDelete(Company company) {
        log.info("handleAfterDelete");
    }

    @HandleBeforeLinkSave // PUT Content-Type: text/uri-list
    public void handleBeforeLinkSave(Company company, Department department) {
        log.info("handleBeforeLinkSave");
    }

    @HandleAfterLinkSave // PUT Content-Type: text/uri-list
    public void handleAfterLinkSave(Company company, Department department) {
        log.info("handleAfterLinkSave");
    }


    @HandleBeforeLinkDelete // PUT Content-Type: text/uri-list
    public void handleBeforeLinkDelete(Company company, Department department) {
        log.info("handleBeforeLinkDelete");
    }

    @HandleAfterLinkDelete // PUT Content-Type: text/uri-list
    public void handleAfterLinkDelete(Company company, Department department) {
        log.info("handleAfterLinkDelete");
    }
}
