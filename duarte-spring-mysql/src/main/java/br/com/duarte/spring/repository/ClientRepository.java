package br.com.duarte.spring.repository;

import br.com.duarte.spring.entity.ClienteEntity;
import ch.qos.logback.core.net.server.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientRepository extends JpaRepository<ClienteEntity, Integer> {

    @Query(value="SELECT * FROM clients INNER JOIN contacts on clients.ID_CLIENT = contacts.ID_CLIENT", nativeQuery=true)
    List<ClienteEntity> getClients( );

    @Query(value="SELECT * FROM clients WHERE CPF_CNPJ = :cpfCnpj ", nativeQuery=true)
    ClienteEntity getClienteByCpfCnpj(@Param("cpfCnpj") String cpfCnpj);
}
