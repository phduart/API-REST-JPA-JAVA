package br.com.duarte.spring.api;

import br.com.duarte.spring.dto.Response;
import br.com.duarte.spring.dto.cliente.ClienteResquest;
import br.com.duarte.spring.dto.contato.ContatoResquest;
import br.com.duarte.spring.entity.ClienteEntity;
import br.com.duarte.spring.entity.ContactEntity;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RequestMapping(path = { "/api/contatos" }, produces = { MediaType.APPLICATION_JSON_VALUE })
public interface ContatosAPI {

    @RequestMapping(method = RequestMethod.GET, path="/getContatos")
    @ResponseBody
    Response getContatos(@RequestParam Long id);

    @RequestMapping(method = RequestMethod.POST, path="/addContato")
    @ResponseBody
    Response addContato(@RequestBody ContatoResquest contatoResquest);

    @RequestMapping(method = RequestMethod.PUT, path="/editContato")
    @ResponseBody
    Response editContato(@RequestBody ContactEntity contactEntity);

    @RequestMapping(method = RequestMethod.DELETE, path="/deleteContato")
    @ResponseBody
    Response deleteContato(@RequestParam Long id);
}
