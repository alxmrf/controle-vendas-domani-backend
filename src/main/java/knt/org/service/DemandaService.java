package knt.org.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.NoResultException;
import jakarta.persistence.NonUniqueResultException;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.NotFoundException;
import knt.org.dto.DemandaInputDto;
import knt.org.entity.Consultor;
import knt.org.entity.Demanda;
import knt.org.repository.ConsultorRepository;
import knt.org.repository.DemandaRepository;
import org.hibernate.annotations.NotFound;

import java.util.List;
@ApplicationScoped
public class DemandaService {

    @Inject
    DemandaRepository repo;

    @Inject
    ConsultorRepository consultorRepo;



    public List<Demanda> getAll(){
        return this.repo.findAll().stream().toList();
    }

    @Transactional
    public Demanda createDemanda(DemandaInputDto dto) throws NonUniqueResultException, NoResultException{
        Consultor consultor;
        try {
             consultor = this.consultorRepo.find("username=?1",dto.getUsernameDono())
                    .singleResult();
        }catch (NonUniqueResultException | NoResultException e){
            System.err.println("error on finding a suitable owner:"+ e);
            throw e;
        }
        var new_demanda =  new Demanda(dto,consultor);
        repo.persist(new_demanda);
        return new_demanda;



    }




}
