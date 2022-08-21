package br.com.duarte.spring.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "contacts")
@Getter
@Setter
public class ContactEntity {
    @Id
    @Column(name = "ID_CONTACT")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id_contact;
    @Column(name = "ID_CLIENT")
    private Integer id_client;
    @Column(name = "CONTACT_NUMBER")
    private Long contact_number;
}
