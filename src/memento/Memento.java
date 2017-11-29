package memento;

import Model.CommandeEnregistrable;
import commandes.Commande;

public interface Memento {

    public void setCommande(CommandeEnregistrable commandeEnregistrable);
    public CommandeEnregistrable getSaveCommande();

}
