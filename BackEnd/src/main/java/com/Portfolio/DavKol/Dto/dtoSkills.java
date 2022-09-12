package com.Portfolio.DavKol.Dto;

import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class dtoSkills {
    @NotBlank
    private String nombreS;
    @NotBlank
    private Integer percent;
}
