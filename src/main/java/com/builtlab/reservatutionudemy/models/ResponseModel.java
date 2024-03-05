package com.builtlab.reservatutionudemy.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ResponseModel<T> {
     private int statusCode;
     private String message;
     private T response;
}
