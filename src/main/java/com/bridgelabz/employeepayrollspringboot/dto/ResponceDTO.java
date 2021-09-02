package com.bridgelabz.employeepayrollspringboot.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ResponceDTO {
    private String message;
    private Object data;

    public ResponceDTO(String message, Object data){
        this.message = message;
        this.data = data;
    }
}
