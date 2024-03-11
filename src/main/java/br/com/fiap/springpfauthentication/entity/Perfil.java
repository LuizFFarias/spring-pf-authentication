package br.com.fiap.springpfauthentication.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Table(name = "TB_Perfil")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Perfil {

    @Id
    @GeneratedValue( strategy = GenerationType.SEQUENCE, generator = "SQ_Perfil")
    @SequenceGenerator(
            name = "SQ_Perfil",
            sequenceName = "SQ_Perfil",
            initialValue = 1,
            allocationSize = 1
    )

    @Column(name = "ID_Perfil")
    private Long id;

    @Column(name = "NM_Perfil")
    private String nome;

    private Set<Permissao> permissoes;
}
