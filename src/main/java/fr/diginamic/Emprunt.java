package fr.diginamic;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "Emprunt")
public class Emprunt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @GenericGenerator(name = "seqEmprunt", strategy = "increment")
    private Integer id;

    @Column(name = "DATE_DEBUT", columnDefinition = "TIMESTAMP")
    private LocalDateTime dateDebut;

    @Column(name = "DATE_FIN", columnDefinition = "TIMESTAMP")
    private LocalDateTime dateFin;

    @Column(name = "DELAI")
    private int delai;

    @ManyToOne
    @JoinColumn(name = "ID_CLIENT")
    private Client client;

    @ManyToMany
    @JoinTable(name = "COMPO",
            joinColumns = @JoinColumn(name = "ID_EMP", referencedColumnName = "ID"),
            inverseJoinColumns = @JoinColumn(name = "ID_LIV", referencedColumnName = "ID"))
    private List<Livre> livres;

    public Emprunt() {
    }

    public Emprunt(LocalDateTime dateDebut, LocalDateTime dateFin, int delai, Client client) {
        this.setDateDebut(dateDebut);
        this.setDateFin(dateFin);
        this.setDelai(delai);
        this.setClient(client);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDateTime getDateDebutt() {
        return dateDebut;
    }

    public void setDateDebut(LocalDateTime dateDebut) {
        this.dateDebut = dateDebut;
    }

    public LocalDateTime getDateFin() {
        return dateFin;
    }

    public void setDateFin(LocalDateTime dateFin) {
        this.dateFin = dateFin;
    }

    public int getDelai() {
        return delai;
    }

    public void setDelai(int delai) {
        this.delai = delai;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<Livre> getLivres() {
        return livres;
    }

    public void setLivres(List<Livre> livres) {
        this.livres = livres;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Emprunt{");
        sb.append("id=").append(id);
        sb.append(", dateDebut=").append(dateDebut);
        sb.append(", dateFin=").append(dateFin);
        sb.append(", delai=").append(delai);
        sb.append(", client=").append(client);
        sb.append(", livres=").append(livres);
        sb.append('}');
        return sb.toString();
    }
}
