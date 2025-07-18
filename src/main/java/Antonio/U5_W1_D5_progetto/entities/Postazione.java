package Antonio.U5_W1_D5_progetto.entities;

import jakarta.persistence.*;

@Entity
public class Postazione {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String codice;

    private String descrizione;

    @Enumerated(EnumType.STRING)
    private TipoPostazione tipo;

    private int occupanti;

    @ManyToOne
    private Edificio edificio;


    public Postazione(){}

    public Postazione(Long id, String codice, String descrizione, TipoPostazione tipo, int occupanti, Edificio edificio) {
        this.id = id;
        this.codice = codice;
        this.descrizione = descrizione;
        this.tipo = tipo;
        this.occupanti = occupanti;
        this.edificio = edificio;
    }

    public Long getId() {
        return id;
    }

    public String getCodice() {
        return codice;
    }

    public void setCodice(String codice) {
        this.codice = codice;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public TipoPostazione getTipo() {
        return tipo;
    }

    public void setTipo(TipoPostazione tipo) {
        this.tipo = tipo;
    }

    public int getOccupanti() {
        return occupanti;
    }

    public void setOccupanti(int occupanti) {
        this.occupanti = occupanti;
    }
}
