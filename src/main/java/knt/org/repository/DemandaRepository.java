package knt.org.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import knt.org.entity.Demanda;
@ApplicationScoped

public class DemandaRepository implements PanacheRepository<Demanda> {
}
