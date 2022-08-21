package br.com.duarte.spring.api;

import br.com.duarte.spring.dto.cliente.ClienteResquest;
import br.com.duarte.spring.dto.Response;
import br.com.duarte.spring.entity.ClienteEntity;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RequestMapping(path = { "/api/clientes" }, produces = { MediaType.APPLICATION_JSON_VALUE })
public interface ClientesAPI {

    @RequestMapping(method = RequestMethod.GET, path="/getClientes")
    @ResponseBody
    Response getClientes();

    @RequestMapping(method = RequestMethod.GET, path="/getCliente")
    @ResponseBody
    Response getCliente(@RequestParam Long id);

    @RequestMapping(method = RequestMethod.POST, path="/addCliente")
    @ResponseBody
    Response addCliente(@RequestBody ClienteResquest clienteResquest);

    @RequestMapping(method = RequestMethod.PUT, path="/editCliente")
    @ResponseBody
    Response editCliente(@RequestBody ClienteEntity clienteEntity);

    @RequestMapping(method = RequestMethod.DELETE, path="/deleteCliente")
    @ResponseBody
    Response deleteCliente(@RequestParam Long id);







}
