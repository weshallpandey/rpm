package com.crossasyst.rpm.model;

import com.crossasyst.rpm.model.base.Base;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Validated
public class Enterprise extends Base {
    @Size(max = 100, message = "EnterpriseService name maximum 100 character")
    private String name;

}
