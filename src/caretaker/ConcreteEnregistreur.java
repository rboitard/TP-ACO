package caretaker;

import memento.ConcreteMemento;
import memento.Memento;

import java.util.ArrayList;

public class ConcreteEnregistreur implements Enregistreur {

    private boolean startLoading;

    private ArrayList<ConcreteMemento> saveCommandes;

    public ConcreteEnregistreur()
    {
        this.saveCommandes = new ArrayList<>();
        this.startLoading = false;
    }

    public void enregistrer(ConcreteMemento memento) {
        if(memento != null)
        {
            this.saveCommandes.add(memento);
        }
        else {
            System.out.println(this.getClass().getName()+" : the command is nul");
        }
    }

    @Override
    public void arreter() {
        this.startLoading = false;
    }

    @Override
    public void demarrerEnregistrement() {
        this.startLoading = true;
    }

    @Override
    public Memento rejouer(int index) {
        return this.saveCommandes.get(index);
    }

    public boolean isStartLoading() {
        return startLoading;
    }

    public void afficheContenuListe()
    {
        for (int i = 0; i< saveCommandes.size(); i++)
        {
            ConcreteMemento concreteMemento = saveCommandes.get(i);
            System.out.println("Contenu "+i+": "+concreteMemento.getCommandeEnregistrable().toString());
        }
    }

}
