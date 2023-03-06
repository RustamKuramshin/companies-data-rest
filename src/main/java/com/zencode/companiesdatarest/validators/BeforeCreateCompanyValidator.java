package com.zencode.companiesdatarest.validators;

import com.zencode.companiesdatarest.entities.Company;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Slf4j
@RequiredArgsConstructor
@Component
public class BeforeCreateCompanyValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return Company.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {

        Company company = (Company) target;

        if (company.getInn().length() > 10) {

            log.error("Длина значение ИНН = {}, превышает 10 чисел", company.getInn());

            errors.rejectValue("inn", "company.field.inn.error",
                    "ИНН должен состоять из 10 чисел!");
        }

    }
}
