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
public class Instituicao extends BaseEntity {
    private String nome;
    private String telefone;
    private String CNPJ;
    private String cidade;
    @OneToOne
    private Aluno aluno;
}
