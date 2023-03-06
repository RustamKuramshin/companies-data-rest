package com.zencode.companiesdatarest.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.querydsl.core.annotations.QueryEntity;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PostLoad;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@QueryEntity
@Entity(name = "company")
public class Company extends BaseEntity {

    @Transient
    @Getter(value = AccessLevel.PRIVATE)
    private Integer nameLen;

    @NotNull
    @Column(name = "name")
    private String name;

    @Column(name = "inn")
    private String inn;

    @Column(name = "kpp")
    private String kpp;

    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Department> departments = new ArrayList<>();

    @Transient
    @JsonIgnore
    private Company previousState;

    @PostLoad
    private void setPreviousState() {
        previousState = new Company();
        previousState.setName(this.getName());
        previousState.setInn(this.getInn());
        previousState.setKpp(this.getKpp());
    }

}
