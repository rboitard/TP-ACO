package originator;

import Model.CommandeEnregistrable;
import memento.ConcreteMemento;
import memento.Memento;

public class ConcreteEnregistrable implements Enregistrable {

    private CommandeEnregistrable commandeEnregistrable;

    public ConcreteEnregistrable() {
        this.commandeEnregistrable = new CommandeEnregistrable();
    }

    @Override
    public ConcreteMemento storInMemento() {
        ConcreteMemento concreteMemento =  new ConcreteMemento();
        concreteMemento.setCommande(this.commandeEnregistrable);
        return  concreteMemento;
    }

    @Override
    public void restoreFromMemento(Memento memento) {
        if(memento != null)
        {
            this.commandeEnregistrable = memento.getSaveCommande();
        }
        else
        {
            System.out.println( this.getClass().getName()+" : memento is nul");
        }
    }

    public void setCommandeEnregistrable(CommandeEnregistrable commandeEnregistrable) {
        this.commandeEnregistrable = commandeEnregistrable;
    }
}
