package margarita_bobrovitskaya.mail.ru.sketchbook2;

public class Memento {
    private final DrawView state;

    public Memento(DrawView state) {
        this.state = state;
    }

    public DrawView getState() {
        return state;
    }
}

class Caretaker {
    private Memento memento;

    public Memento getMemento() {
        return memento;
    }

    public void setMemento(Memento memento) {
        this.memento = memento;
    }
}

class Originator {
    private DrawView state;

    public void setState(DrawView state) {
        this.state = state;
    }

    public DrawView getState() {
        return state;
    }

    public Memento saveState() {
        return new Memento(state);
    }

    public void restoreState(Memento memento) {
        this.state = memento.getState();
    }
}


