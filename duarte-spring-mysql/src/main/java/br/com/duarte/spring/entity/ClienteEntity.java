package br.com.duarte.spring.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "clients")
@Getter
@Setter
public class ClienteEntity {

    @Id
    @Column(name = "ID_CLIENT")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id_client;
    @Column(name = "NAME_CLIENT")
    private String name_client;
    @Column(name = "CPF_CNPJ")
    private String cpf_cnpj;
    @Column(name = "RG_IE")
    private String rg_ie;
    @Column(name = "DT_CREATE")
    private Date dt_create;
    @Column(name = "ACTIVE")
    private String active;
}
