package com.tfg.apirest.entity;

import lombok.*;
import javax.persistence.*;
import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "d_farmaco")
public class Farmaco implements Serializable {
    @Id
    @GeneratedValue
    @Column(name = "id_farmaco", nullable = false)
    private UUID id;

    @Column(name = "ds_nombre", nullable = false, length = 100)
    private String nombre;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cd_hospital")
    private Hospital hospital;

    @OneToMany(mappedBy = "farmaco")
    private Set<Propiedad> propiedades = new LinkedHashSet<>();

}