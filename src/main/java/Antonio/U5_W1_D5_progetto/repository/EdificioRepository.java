package Antonio.U5_W1_D5_progetto.repository;

import Antonio.U5_W1_D5_progetto.entities.Edificio;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EdificioRepository extends JpaRepository<Edificio, Long> {
    boolean existsByNomeEdificio(String nomeEdificio);
    List<Edificio> findByNomeEdificio(String nomeEdificio);
}
