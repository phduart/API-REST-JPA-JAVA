package br.com.duarte.spring.controller;

import br.com.duarte.spring.api.ContatosAPI;
import br.com.duarte.spring.dto.Response;
import br.com.duarte.spring.dto.cliente.ClienteResquest;
import br.com.duarte.spring.dto.contato.ContatoResquest;
import br.com.duarte.spring.entity.ClienteEntity;
import br.com.duarte.spring.entity.ContactEntity;
import br.com.duarte.spring.service.impl.ContatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ContatoController implements ContatosAPI {


    @Autowired
    ContatoService contatoService;

    @Override
    public Response getContatos(Long id) {
        List<ContactEntity> retorno = contatoService.getContatos(id);
        return (!retorno.isEmpty()) ? Response.builder().status("Success").body(retorno).build() : Response.builder().status("Error").message("Erro ao buscar").build();
    }

    @Override
    public Response addContato(ContatoResquest contatoResquest) {
        return contatoService.addContato(contatoResquest);
    }

    @Override
    public Response editContato(ContactEntity contactEntity) {
        int retorno = contatoService.editContato(contactEntity);
        return (retorno == 1) ? Response.builder().status("Success").build() : Response.builder().status("Error").message("Erro ao editar contato").build();
    }

    @Override
    public Response deleteContato(Long id) {
        int retorno = contatoService.deleteContato(id);
        return (retorno == 1) ? Response.builder().status("Success").build() : Response.builder().status("Error").message("Erro ao deletar contato").build();
    }
}
