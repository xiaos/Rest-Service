package com.csz.rest.model;

import com.csz.rest.validation.EnumString;
import com.csz.rest.validation.ValidGroup;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Data
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull(groups = ValidGroup.Crud.Update.class, message = "uid cannot be null when update.")
    private int uid;

    @NotNull(groups = ValidGroup.Crud.Create.class, message = "name cannot be null when create.")
    @Length(min = 6, max = 12, message = "name length must be 6 to 12.")
    private String name;

    @EnumString(value = {"F", "M"}, message = "Only M or F")
    private String sex;

    private String address;
}
