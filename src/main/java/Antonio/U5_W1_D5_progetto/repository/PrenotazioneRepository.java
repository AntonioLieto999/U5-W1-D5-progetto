package Antonio.U5_W1_D5_progetto.repository;

import Antonio.U5_W1_D5_progetto.entities.Postazione;
import Antonio.U5_W1_D5_progetto.entities.Prenotazione;
import Antonio.U5_W1_D5_progetto.entities.Utente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface PrenotazioneRepository extends JpaRepository<Prenotazione, Long> {
    boolean existsByPostazioneAndData(Postazione postazione, LocalDate data);
    boolean existsByUtenteAndData(Utente utente, LocalDate data);
    List<Prenotazione> findByUtente(Utente utente);
}
