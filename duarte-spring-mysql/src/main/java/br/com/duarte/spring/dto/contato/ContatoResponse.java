package br.com.duarte.spring.dto.contato;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ContatoResponse {

    private long id_cliente;
    private long contact_number;
}
