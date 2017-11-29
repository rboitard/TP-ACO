package originator;

import memento.Memento;

public interface Enregistrable {

    public Memento storInMemento();
    public void restoreFromMemento(Memento memento);
}
