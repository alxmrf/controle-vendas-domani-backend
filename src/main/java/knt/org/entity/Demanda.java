package knt.org.entity;


import jakarta.persistence.*;
import knt.org.dto.DemandaInputDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="demandas")
public class Demanda {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    Long demandaId;

    String descricao;

    @Column(name = "data_criacao")
    Timestamp dataCriacao;

    String status;



    @ManyToOne(fetch = FetchType.LAZY)
            @JoinColumn(name = "consultor_id")
    Consultor dono;

    public Demanda(DemandaInputDto dto,Consultor dono){
        this.descricao = dto.getDescricao();
        this.dataCriacao =Timestamp.valueOf(LocalDateTime.now());
        this.status = dto.getStatus();
        this.dono = dono;
    }
}
