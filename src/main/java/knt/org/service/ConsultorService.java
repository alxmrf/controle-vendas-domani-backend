package knt.org.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.Id;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Path;
import knt.org.dto.ConsultorInputDto;
import knt.org.entity.Consultor;
import knt.org.repository.ConsultorRepository;

import java.util.List;
@ApplicationScoped
public class ConsultorService {

    @Inject
    ConsultorRepository repo;

    public List<Consultor> listAll(){
        return  repo.listAll();
    }

    @Transactional
    public Consultor addConsultor(ConsultorInputDto consultorDto) throws Exception{
        try {
            var newConsultor = new Consultor(consultorDto);
            repo.persist(newConsultor);
            return newConsultor;
        }
        catch (Exception e){
            System.out.println(e);
            throw e;
        }
    }
}
