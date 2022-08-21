package br.com.duarte.spring.controller;


import br.com.duarte.spring.api.ClientesAPI;
import br.com.duarte.spring.dto.cliente.ClienteAddDTO;
import br.com.duarte.spring.dto.cliente.ClienteResquest;
import br.com.duarte.spring.dto.Response;
import br.com.duarte.spring.entity.ClienteEntity;
import br.com.duarte.spring.dto.cliente.ClienteContatosResponse;
import br.com.duarte.spring.service.impl.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.logging.Logger;

@RestController
public class ClienteController implements ClientesAPI {

    @Autowired
    ClienteService clienteService;

    private static final Logger logger = Logger.getLogger(String.valueOf(ClienteController.class));

    @Override
    public Response getClientes() {
        List<ClienteEntity> retorno = clienteService.getClientes();
        return (!retorno.isEmpty()) ? Response.builder().status("Success").body(retorno).build() : Response.builder().status("Error").message("Erro ao buscar").build();
    }

    @Override
    public Response getCliente(Long id) {
        ClienteContatosResponse retorno = clienteService.getCliente(id);
        return !(retorno == null) ? Response.builder().status("Success").body(retorno).build() : Response.builder().status("Error").message("Erro ao buscar").build();
    }

    @Override
    public Response addCliente(ClienteResquest clienteResquest) {
        return clienteService.addCliente(clienteResquest);

    }

    @Override
    public Response editCliente(ClienteEntity clienteEntity) {
        int retorno = clienteService.editCliente(clienteEntity);
        return (retorno == 1) ? Response.builder().status("Success").build() : Response.builder().status("Error").message("Erro ao editar cliente").build();
    }

    @Override
    public Response deleteCliente(Long id) {
        int retorno = clienteService.deleteCliente(id);
        return (retorno == 1) ? Response.builder().status("Success").build() : Response.builder().status("Error").message("Erro ao deletar cliente").build();
    }

}
