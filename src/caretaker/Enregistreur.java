package caretaker;

import memento.Memento;

public interface Enregistreur {

    public void arreter();
    public void demarrerEnregistrement();
    public Memento rejouer(int index);
}
