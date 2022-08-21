package br.com.duarte.spring.service;

import br.com.duarte.spring.dto.Response;
import br.com.duarte.spring.dto.cliente.ClienteResquest;
import br.com.duarte.spring.entity.ClienteEntity;
import br.com.duarte.spring.dto.cliente.ClienteContatosResponse;

import java.util.List;

public interface ClientesServiceInterface {

     List<ClienteEntity> getClientes();

     ClienteContatosResponse getCliente(Long id);

     Response addCliente(ClienteResquest clienteResquest);

     int editCliente(ClienteEntity clienteEntity);

     int deleteCliente(Long id);
}
