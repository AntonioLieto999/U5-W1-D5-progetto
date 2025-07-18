package Antonio.U5_W1_D5_progetto.runner;


import Antonio.U5_W1_D5_progetto.entities.Edificio;
import Antonio.U5_W1_D5_progetto.entities.Postazione;
import Antonio.U5_W1_D5_progetto.entities.TipoPostazione;
import Antonio.U5_W1_D5_progetto.entities.Utente;
import Antonio.U5_W1_D5_progetto.repository.EdificioRepository;
import Antonio.U5_W1_D5_progetto.repository.PostazioneRepository;
import Antonio.U5_W1_D5_progetto.repository.PrenotazioneRepository;
import Antonio.U5_W1_D5_progetto.repository.UtenteRepository;
import Antonio.U5_W1_D5_progetto.service.ServicePostazione;
import Antonio.U5_W1_D5_progetto.service.ServicePrenotazione;
import Antonio.U5_W1_D5_progetto.service.ServiceUtente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
public class RunnerApplication implements CommandLineRunner {

    @Autowired
    private EdificioRepository edificioRepository;
    @Autowired
    private ServicePostazione servicePostazione;
    @Autowired
    private ServiceUtente serviceUtente;
    @Autowired
    private PrenotazioneRepository prenotazioneRepository;
    @Autowired
    private ServicePrenotazione servicePrenotazione;
    @Override
    public void run(String... args) throws Exception {
        System.out.println("Caricamento dei dati");

        Edificio edificio = new Edificio(null, "Edificio Peffò", "Via del puzzo 69", "Aquila");
        edificio = edificioRepository.save(edificio);

        Postazione p1 = new Postazione(null, "POS001", "Open Space 1", TipoPostazione.OPENSPACE, 10 ,edificio);
        Postazione p2 = new Postazione(null, "POS002", "Sala VIP", TipoPostazione.PRIVATO,5,edificio);
        ServicePrenotazione.saveAll(List.of(p1,p2));

        Utente u1 = new Utente(null, "Giova201","Giovanni Storti","Giovanni.storti2001@gmail.com");
        Utente u2 = new Utente(null, "Lavica09","Lavica Ombroni","Lavica.ombroni1999@gmail.com");
        ServiceUtente.saveAll(List.of(u1, u2));

        LocalDate oggi = LocalDate.now();
        LocalDate domani = oggi.plusDays(1);


    }
    private void eseguiPrenotazione(ServicePrenotazione service, Utente u, Postazione p, LocalDate data) {
        try {
            service.prenotazione(u, p, data);
            System.out.println("Prenotazione eseguita: " + u.getUsername() + " → " + p.getCodice() + " per il " + data);
        } catch (Exception e) {
            System.out.println("Prenotazione fallita per " + u.getUsername() + ": " + e.getMessage());
        }
    }
}
