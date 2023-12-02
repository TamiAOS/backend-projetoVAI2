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
public class Aluno extends BaseEntity {
    private String nome;
    private String cpf;
    private String sexo;
    private String curso;
    @OneToOne
    private Projeto projetos;
    @OneToOne
    private Instituicao instituicao;
}
