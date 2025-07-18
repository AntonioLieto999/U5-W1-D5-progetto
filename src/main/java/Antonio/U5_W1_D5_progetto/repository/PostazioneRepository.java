package Antonio.U5_W1_D5_progetto.repository;

import Antonio.U5_W1_D5_progetto.entities.Postazione;
import Antonio.U5_W1_D5_progetto.entities.TipoPostazione;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostazioneRepository extends JpaRepository<Postazione, Long> {
    List<Postazione> findByTipoAndEdificioECitta(TipoPostazione tipo, String citta);
}
