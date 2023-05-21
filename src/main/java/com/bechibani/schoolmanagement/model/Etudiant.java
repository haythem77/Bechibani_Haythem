package com.bechibani.schoolmanagement.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Etudiant {
    @Id
    @GeneratedValue
    private  Integer id;
    private String nom;
    private String prenom;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="id_classe")
    private Classe calsse;
}
