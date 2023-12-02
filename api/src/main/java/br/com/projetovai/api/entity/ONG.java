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
public class ONG extends BaseEntity {

    private String nome;
    private String CNPJ;
    private String Segmentacao;
    private String enedreco;
    private String telefone;
    @OneToOne
    private Projeto projeto;
}
