package br.com.duarte.spring.dto.cliente;

import lombok.Builder;
import lombok.Getter;

import java.sql.Date;

@Getter
@Builder
public class ClienteResquest {

    private String name_client;
    private String cpf_cnpj;
    private String rg_ie;
    private Date dt_create;
    private String active;
}
