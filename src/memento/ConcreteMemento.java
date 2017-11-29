package memento;

import Model.CommandeEnregistrable;
import commandes.Commande;

public class ConcreteMemento implements  Memento {

    private CommandeEnregistrable commandeEnregistrable;


    @Override
    public void setCommande(CommandeEnregistrable commandeEnregistrable) {
        this.commandeEnregistrable = commandeEnregistrable;
    }

    public CommandeEnregistrable getCommandeEnregistrable() {
        return commandeEnregistrable;
    }

    @Override
    public CommandeEnregistrable getSaveCommande() {
        return this.commandeEnregistrable;
    }
}
