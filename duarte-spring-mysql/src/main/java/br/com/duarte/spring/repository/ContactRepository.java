package br.com.duarte.spring.repository;

import br.com.duarte.spring.entity.ClienteEntity;
import br.com.duarte.spring.entity.ContactEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface ContactRepository extends JpaRepository<ContactEntity, Integer> {

    @Query(value="SELECT * FROM contacts WHERE id_client = :idCliente", nativeQuery=true)
    List<ContactEntity> getContactsByClient(@Param("idCliente") Long idCliente);

    @Transactional
    @Modifying
    @Query(value="UPDATE contacts SET CONTACT_NUMBER = :contactNumber WHERE ID_CLIENT = :idCliente", nativeQuery=true)
    void editContactsByClient(@Param("contactNumber") Long contactNumber, @Param("idCliente") Integer idCliente);



}
