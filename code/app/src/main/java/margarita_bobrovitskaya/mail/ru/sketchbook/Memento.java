package margarita_bobrovitskaya.mail.ru.sketchbook;


public class Memento {
    private final WorkingActivity.DrawView state;

    public Memento(WorkingActivity.DrawView state) {
        this.state = state;
    }

    public WorkingActivity.DrawView getState() {
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
    private WorkingActivity.DrawView state;

    public void setState(WorkingActivity.DrawView state) {
        this.state = state;
    }

    public WorkingActivity.DrawView getState() {
        return state;
    }

    public Memento saveState() {
        return new Memento(state);
    }

    public void restoreState(Memento memento) {
        this.state = memento.getState();
    }
}
/*
public class Application {
    public static void main(String[] args) {
        Originator originator = new Originator();
        Caretaker caretaker = new Caretaker();

        originator.setState("on");
        System.out.printf("State is %s\n", originator.getState());
        caretaker.setMemento(originator.saveState());

        originator.setState("off");
        System.out.printf("State is %s\n", originator.getState());

        originator.restoreState(caretaker.getMemento());
        System.out.printf("State is %s\n", originator.getState());
    }
} */