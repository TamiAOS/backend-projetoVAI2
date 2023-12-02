package br.com.projetovai.api.entity;

import br.com.projetovai.api.entity.baseEntity.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import lombok.*;
import lombok.experimental.SuperBuilder;


@Entity
@Getter @Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Projeto extends BaseEntity {
    private String demanda;
    private String responsavel;
    private String telefone;
    @OneToOne
    private ONG ong;
    @OneToOne
    private Aluno aluno;

}
