package br.com.duarte.spring.dto.cliente;

import br.com.duarte.spring.entity.ContactEntity;
import br.com.duarte.spring.model.ContatoModel;
import lombok.Builder;
import lombok.Getter;

import java.sql.Date;
import java.util.List;

@Getter
@Builder
public class ClienteContatosResponse {

    private long id_client;
    private String name_client;
    private String cpf_cnpj;
    private String rg_ie;
    private Date dt_create;
    private String active;
    private List<ContatoModel> contacts;

}
