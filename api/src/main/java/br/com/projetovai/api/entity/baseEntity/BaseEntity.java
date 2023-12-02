package br.com.projetovai.api.entity.baseEntity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.*;
import lombok.experimental.SuperBuilder;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Getter
@SuperBuilder
@MappedSuperclass
public class BaseEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

}
