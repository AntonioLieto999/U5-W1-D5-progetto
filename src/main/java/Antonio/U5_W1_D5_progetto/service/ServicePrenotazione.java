package Antonio.U5_W1_D5_progetto.service;

import Antonio.U5_W1_D5_progetto.entities.Postazione;
import Antonio.U5_W1_D5_progetto.entities.Prenotazione;
import Antonio.U5_W1_D5_progetto.entities.Utente;
import Antonio.U5_W1_D5_progetto.repository.PrenotazioneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ServicePrenotazione {
    @Autowired
    private PrenotazioneRepository prenotazioneRepository;

    public static void saveAll(List<Postazione> p1) {

    }

    public Prenotazione prenotaPostazione(Utente utente, Postazione postazione, LocalDate data) {
        return null;
    }

    public List<Postazione> getPostazioniOccupateOggi(){
        return prenotazioneRepository.findAll().stream()
                .filter(prenotazione -> prenotazione.getData().isEqual(LocalDate.now()))
                .map(Prenotazione::getPostazione).distinct().toList();
    }
    public Map<LocalDate, List<Prenotazione>> getNumeroPrenotazionePerUtente(){
        return prenotazioneRepository.findAll().stream().collect(Collectors.groupingBy(Prenotazione::getData));
    }

    public void prenotazione(Utente u, Postazione p, LocalDate data) {
    }
}
