package be.technifutur.DataType;

import java.io.Serializable;

public class Subs implements Serializable {
    private String nom;
    private String prenom;

    public Subs(String nom, String prenom) {
        this.nom = nom;
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Subs subs = (Subs) o;

        if (nom != null ? !nom.equals(subs.nom) : subs.nom != null) return false;
        return prenom != null ? prenom.equals(subs.prenom) : subs.prenom == null;
    }

    @Override
    public int hashCode() {
        int result = nom != null ? nom.hashCode() : 0;
        result = 31 * result + (prenom != null ? prenom.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return
                "nom = " + nom +
                "  prenom = " + prenom;
    }
}
