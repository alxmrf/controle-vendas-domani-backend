package knt.org.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import knt.org.entity.Consultor;
@ApplicationScoped
public class ConsultorRepository implements PanacheRepository<Consultor> {
}
