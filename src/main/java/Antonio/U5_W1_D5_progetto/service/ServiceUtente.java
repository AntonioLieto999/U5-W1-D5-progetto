package Antonio.U5_W1_D5_progetto.service;

import Antonio.U5_W1_D5_progetto.entities.Utente;
import Antonio.U5_W1_D5_progetto.exception.ValidationException;
import Antonio.U5_W1_D5_progetto.repository.UtenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceUtente {

    @Autowired
    private UtenteRepository utenteRepository;

    public static void saveAll(List<Utente> u1) {
    }

    public void saveUtente(Utente newUtente){
        if (utenteRepository.existsByEmail(newUtente.getEmail())) throw new ValidationException("Email " + newUtente.getEmail() + " già in uso");
        if (utenteRepository.existsByUsername(newUtente.getUsername())) throw new ValidationException("Username già utilizzato");
        utenteRepository.save(newUtente);
        System.out.println("L'utente è stato creato");
    }
}
