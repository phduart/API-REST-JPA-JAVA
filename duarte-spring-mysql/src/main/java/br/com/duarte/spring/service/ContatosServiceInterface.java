package br.com.duarte.spring.service;

import br.com.duarte.spring.dto.Response;
import br.com.duarte.spring.dto.cliente.ClienteContatosResponse;
import br.com.duarte.spring.dto.cliente.ClienteResquest;
import br.com.duarte.spring.dto.contato.ContatoResponse;
import br.com.duarte.spring.dto.contato.ContatoResquest;
import br.com.duarte.spring.entity.ClienteEntity;
import br.com.duarte.spring.entity.ContactEntity;
import br.com.duarte.spring.service.impl.ContatoService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface ContatosServiceInterface {

    List<ContactEntity> getContatos(Long id);

    Response addContato(ContatoResquest contatoResquest);

    int editContato(ContactEntity contactEntity);

    int deleteContato(Long id);
}
