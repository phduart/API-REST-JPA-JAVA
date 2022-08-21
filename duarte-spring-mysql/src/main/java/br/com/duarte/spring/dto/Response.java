package br.com.duarte.spring.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Response {

    private String status;
    private String message;
    private Object body;
}
