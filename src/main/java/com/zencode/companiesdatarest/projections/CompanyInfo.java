package com.zencode.companiesdatarest.projections;


import com.zencode.companiesdatarest.entities.Company;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "companyInfo", types = {Company.class})
public interface CompanyInfo extends BaseProjection {

    String getName();

    @Value("#{target.inn} #{target.kpp}")
    String getTaxData();
}
