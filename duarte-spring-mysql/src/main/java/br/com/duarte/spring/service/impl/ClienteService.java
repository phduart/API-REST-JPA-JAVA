package br.com.duarte.spring.service.impl;

import br.com.duarte.spring.dto.Response;
import br.com.duarte.spring.dto.cliente.ClienteAddDTO;
import br.com.duarte.spring.dto.cliente.ClienteResquest;
import br.com.duarte.spring.entity.ClienteEntity;
import br.com.duarte.spring.entity.ContactEntity;
import br.com.duarte.spring.dto.cliente.ClienteContatosResponse;
import br.com.duarte.spring.model.ContatoModel;
import br.com.duarte.spring.repository.ClientRepository;
import br.com.duarte.spring.repository.ContactRepository;
import br.com.duarte.spring.service.ClientesServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Service
public class ClienteService implements ClientesServiceInterface {

    private static final Logger logger = Logger.getLogger(String.valueOf(ClienteService.class));

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private ContactRepository contactRepository;

    @Override
    public List<ClienteEntity> getClientes() {
        return clientRepository.findAll();
    }

    @Override
    public ClienteContatosResponse getCliente(Long id) {

        Optional<ClienteEntity> clienteResponse = clientRepository.findById(Math.toIntExact(id));
        ClienteEntity cliente = clienteResponse.get();
        List<ContactEntity> contatos = contactRepository.getContactsByClient(id);
        List<ContatoModel> listContatos = new ArrayList();


        for (ContactEntity contactEntity : contatos){
            ContatoModel contatoModel = ContatoModel.builder().contact_number(contactEntity.getContact_number()).build();
            listContatos.add(contatoModel);

        }

        ClienteContatosResponse clienteContatos = ClienteContatosResponse.builder()
                .id_client(cliente.getId_client())
                .name_client(cliente.getName_client())
                .cpf_cnpj(cliente.getCpf_cnpj())
                .rg_ie(cliente.getRg_ie())
                .dt_create(cliente.getDt_create())
                .active(cliente.getActive())
                .contacts(listContatos)
                .build();

        return clienteContatos;
    }

    @Override
    public Response addCliente(ClienteResquest clienteResquest) {
        ClienteEntity clienteExistente = clientRepository.getClienteByCpfCnpj(clienteResquest.getCpf_cnpj());
        if(clienteExistente != null){
            logger.info("CPF existente!");
            return Response.builder().status("Error").message("CPF/CNPJ Existente!").build();
        }

        ClienteEntity entity = new ClienteEntity();
        entity.setName_client(clienteResquest.getName_client());
        entity.setCpf_cnpj(clienteResquest.getCpf_cnpj());
        entity.setRg_ie(clienteResquest.getRg_ie());
        entity.setDt_create(clienteResquest.getDt_create());
        entity.setActive(clienteResquest.getActive());

        try {
            clientRepository.saveAndFlush(entity);
            logger.info("Cliente inserido!");
            return Response.builder().status("Success").message("Cliente inserido").body(ClienteAddDTO.builder().id_client(entity.getId_client())).build();
        } catch (Exception e) {
            logger.info("Erro ao inserir - Erro : " + e.getLocalizedMessage());
        }
        return Response.builder().status("Error").message("Erro ao inserir").build();

    }

    @Override
    public int editCliente(ClienteEntity clienteEntity) {
        try{
            Optional<ClienteEntity> oldCliente = clientRepository.findById(clienteEntity.getId_client());
            if(oldCliente.isPresent()){
                ClienteEntity cliente = oldCliente.get();
                cliente.setName_client(clienteEntity.getName_client());
                cliente.setCpf_cnpj(clienteEntity.getCpf_cnpj());
                cliente.setRg_ie(clienteEntity.getRg_ie());
                cliente.setDt_create(clienteEntity.getDt_create());
                cliente.setActive(clienteEntity.getActive());
                clientRepository.save(cliente);
                return 1;
            }
            logger.info("Erro ao editar cliente | Cliente não encontrado");
            return 0;
        } catch (Exception e) {
            logger.info("Erro ao editar cliente");
            return 0;
        }
    }

    @Override
    public int deleteCliente(Long id) {
        try {
            Optional<ClienteEntity> cliente = clientRepository.findById(Math.toIntExact(id));
            if(cliente.isPresent()) {
                clientRepository.delete(cliente.get());
                return 1;
            }
            logger.info("Erro ao deletar cliente | Cliente não encontrado");
            return 0;
        } catch (Exception e){
            logger.info("Erro ao deletar cliente");
            return 0;
        }

    }


}
