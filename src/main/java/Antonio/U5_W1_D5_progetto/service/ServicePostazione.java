package Antonio.U5_W1_D5_progetto.service;

import Antonio.U5_W1_D5_progetto.entities.Postazione;
import Antonio.U5_W1_D5_progetto.entities.Utente;
import Antonio.U5_W1_D5_progetto.exception.ValidationException;
import Antonio.U5_W1_D5_progetto.repository.PostazioneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServicePostazione {
    @Autowired
    private PostazioneRepository postazioneRepository;

    public void savePostazione(Postazione postazione) {
        if(postazione.getTipo() == null) throw new ValidationException("Aggiungi il tipo di postazione");
    }

}
