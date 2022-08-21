package br.com.duarte.spring.service.impl;

import br.com.duarte.spring.dto.Response;
import br.com.duarte.spring.dto.contato.ContatoResponse;
import br.com.duarte.spring.dto.contato.ContatoResquest;
import br.com.duarte.spring.entity.ContactEntity;
import br.com.duarte.spring.repository.ContactRepository;
import br.com.duarte.spring.service.ContatosServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Service
public class ContatoService implements ContatosServiceInterface {

    private static final Logger logger = Logger.getLogger(String.valueOf(ContatoService.class));

    @Autowired
    private ContactRepository contactRepository;

    @Override
    public List<ContactEntity> getContatos(Long id) {
        return contactRepository.getContactsByClient(id);
    }

    @Override
    public Response addContato(ContatoResquest contatoResquest) {
        try {
            ContactEntity contato = new ContactEntity();
            contato.setContact_number(contatoResquest.getContact_number());
            contato.setId_client((int) contatoResquest.getId_client());
            contactRepository.save(contato);
            logger.info("Inserido com sucesso!");
            return Response.builder().status("Success").message("Contato inserido com sucesso.").build();
        } catch (Exception e) {
            logger.info("Erro ao inserir | Erro - " + e.getLocalizedMessage());
            return Response.builder().status("Error").message("Erro ao inserir Contato.").build();
        }
    }

    @Override
    public int editContato(ContactEntity contactEntity) {
        try {
            contactRepository.editContactsByClient(contactEntity.getContact_number(), contactEntity.getId_client());
            logger.info("Contato alterado com sucesso!");
            return 1;
        } catch (Exception e) {
            logger.info("Erro ao alterar contato | Erro - " + e.getLocalizedMessage());
            return 0;
        }
    }

    @Override
    public int deleteContato(Long id) {
        try {
            Optional<ContactEntity> contato = contactRepository.findById(Math.toIntExact(id));
            if(contato.isPresent()) {
                contactRepository.delete(contato.get());
                return 1;
            }
            logger.info("Erro ao deletar contato | Contato não encontrado");
            return 0;
        } catch (Exception e) {
            logger.info("Erro ao deletar contato");
        }
        return 0;
    }
}
