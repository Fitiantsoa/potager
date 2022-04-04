package Vgarden.demo.model;

import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.Embeddable;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class CommandeProduitKey implements Serializable {

    @ManyToOne
    @JoinColumn(name = "commande_produit_commande_id", foreignKey = @ForeignKey(name = "commande_produit_commande_id_fk"))
    private Commande commande;

    @ManyToOne
    @JoinColumn(name = "commande_produit_produit_id", foreignKey = @ForeignKey(name = "commande_produit_produit_id_fk"))
    @JsonView(Views.Common.class)
    private Produit produit;

    public CommandeProduitKey() {

    }

    public CommandeProduitKey(Commande commande, Produit produit) {
        this.commande = commande;
        this.produit = produit;
    }

    public Commande getCommande() {
        return commande;
    }

    public void setCommande(Commande commande) {
        this.commande = commande;
    }

    public Produit getProduit() {
        return produit;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CommandeProduitKey that = (CommandeProduitKey) o;
        return commande.equals(that.commande) && produit.equals(that.produit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(commande, produit);
    }
}
