package knt.org.entity;

import jakarta.persistence.*;
import knt.org.dto.ConsultorInputDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="consultores")
public class Consultor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(unique = true)
    String username;

    String cargo;

    String area;

    String nome;

    @Transient
    @OneToMany(
            mappedBy = "dono",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.LAZY
    )
    Set<Demanda> demandas;



    public Consultor(ConsultorInputDto dto){

        this.username = dto.getUsername();
        this.cargo = dto.getCargo();
        this.area = dto.getArea();
        this.nome = dto.getNome();
    }

}
