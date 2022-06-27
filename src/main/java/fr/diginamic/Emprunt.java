package fr.diginamic;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "Emprunt")
public class Emprunt {

    @Id
    private Integer id;

    @Column
    private LocalDateTime date_debut;

    @Column
    private LocalDateTime date_fin;

    @Column
    private int delai;

    @ManyToOne
    @JoinColumn(name = "ID")
    private Client client;

    public Emprunt() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDateTime getDate_debut() {
        return date_debut;
    }

    public void setDate_debut(LocalDateTime date_debut) {
        this.date_debut = date_debut;
    }

    public LocalDateTime getDate_fin() {
        return date_fin;
    }

    public void setDate_fin(LocalDateTime date_fin) {
        this.date_fin = date_fin;
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

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Emprunt{");
        sb.append("id=").append(id);
        sb.append(", date_debut=").append(date_debut);
        sb.append(", date_fin=").append(date_fin);
        sb.append(", delai=").append(delai);
        sb.append(", id_client=").append(client);
        sb.append('}');
        return sb.toString();
    }
}
