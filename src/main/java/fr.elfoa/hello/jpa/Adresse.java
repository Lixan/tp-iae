package fr.elfoa.hello.jpa;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Adresse
{
    // ============================================
    // ATTRIBUTS

    @Id
    @GeneratedValue
    private Integer id;

    private String codePostal;
    private Integer numeroVoie;
    private String pays;
    private String voie;
    private String typeVoie;

    // ============================================
    // CONSTRUCTORS

    public Adresse()
    {

    }

    public Adresse(String codePostal, Integer numeroVoie, String pays, String voie, String typeVoie)
    {
        this.codePostal = codePostal;
        this.numeroVoie = numeroVoie;
        this.pays = pays;
        this.voie = voie;
        this.typeVoie = typeVoie;
    }

    // ============================================
    // GETTERS / SETTERS

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public String getCodePostal() {
        return codePostal;
    }
    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }

    public Integer getNumeroVoie() {
        return numeroVoie;
    }
    public void setNumeroVoie(Integer numeroVoie) {
        this.numeroVoie = numeroVoie;
    }

    public String getPays() { return pays; }
    public void setPays(String pays) { this.pays = pays; }

    public String getVoie() {
        return voie;
    }
    public void setVoie(String voie) {
        this.voie = voie;
    }

    public String getTypeVoie() {
        return typeVoie;
    }
    public void setTypeVoie(String typeVoie) {
        this.typeVoie = typeVoie;
    }

    // ============================================
    // PUBLIC METHODS

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("Id : ").append(getId()).append("\n");
        sb.append("Code postal : ").append(getCodePostal()).append("\n");
        sb.append("Numero voie : ").append(getNumeroVoie()).append("\n");
        sb.append("Pays : ").append(getPays()).append("\n");
        sb.append("Voie : ").append(getVoie()).append("\n");
        sb.append("Type voie : ").append(getTypeVoie()).append("\n");
        return sb.toString();
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o)
            return true;
        if (!(o instanceof Adresse))
            return false;

        Adresse adresse = (Adresse) o;

        return Objects.equals(id, adresse.getId())
                && Objects.equals(codePostal, adresse.getCodePostal())
                && Objects.equals(numeroVoie, adresse.getNumeroVoie())
                && Objects.equals(pays, adresse.getPays())
                && Objects.equals(voie, adresse.getVoie())
                && Objects.equals(typeVoie, adresse.getTypeVoie());
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(id)
                + Objects.hash(codePostal)
                + Objects.hash(numeroVoie)
                + Objects.hash(pays)
                + Objects.hash(voie)
                + Objects.hash(typeVoie);
    }
}
