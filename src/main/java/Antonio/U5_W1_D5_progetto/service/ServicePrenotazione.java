package Antonio.U5_W1_D5_progetto.service;

import Antonio.U5_W1_D5_progetto.entities.Postazione;
import Antonio.U5_W1_D5_progetto.entities.Prenotazione;
import Antonio.U5_W1_D5_progetto.entities.Utente;
import Antonio.U5_W1_D5_progetto.repository.PrenotazioneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class ServicePrenotazione {
    @Autowired
    private PrenotazioneRepository prenotazioneRepository;

    public Prenotazione prenotaPostazione(Utente utente, Postazione postazione, LocalDate data){
        if (prenotazioneRepository.existsByUtenteAndData(utente,data)){
            throw new IllegalStateException("L'utente ha gia prenotato in questa data.");
        }
        if (prenotazioneRepository.existsByPostazioneAndData(postazione,data)){
            throw new IllegalStateException("La postazione è gia prenotata per la data corrente.");
        }
        Prenotazione prenotazione = new Prenotazione();
        prenotazione.setUtente(utente);
        prenotazione.setPostazione(postazione);
        prenotazione.setData(data);

        return prenotazioneRepository.save(prenotazione);
    }
}
