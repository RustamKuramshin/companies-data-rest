package com.zencode.companiesdatarest.entities;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@Entity(name = "company")
public class Company extends BaseEntity {

    @NotNull
    @Column(name = "name")
    private String name;

    @Column(name = "inn")
    private String inn;

    @Column(name = "kpp")
    private String kpp;
}
