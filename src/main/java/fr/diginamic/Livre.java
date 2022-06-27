package fr.diginamic;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="Livre")
public class Livre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @Column(name="TITRE", length = 255, nullable = false, unique = false)
    private String Titre;

    @Column(name = "AUTEUR", length = 50, nullable = false, unique = false)
    private String Auteur;


    public Livre() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitre() {
        return Titre;
    }

    public void setTitre(String titre) {
        Titre = titre;
    }

    public String getAuteur() {
        return Auteur;
    }

    public void setAuteur(String auteur) {
        Auteur = auteur;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Livre{");
        sb.append("id=").append(id);
        sb.append(", Titre='").append(Titre).append('\'');
        sb.append(", Auteur='").append(Auteur).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
