package br.com.duarte.spring.dto.contato;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ContatoResquest {

    private long id_client;
    private long contact_number;
}
