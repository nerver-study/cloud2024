package com.atguigu.designmethods.Memento;

public class Originator {
    private String state;

    public void setState(String state) {
        this.state = state;
        System.out.println("Current State: " + this.state);
    }

    public Memento saveStateToMemento() {
        System.out.println("Saving to Memento.");
        return new Memento(state);
    }

    public void getStateFromMemento(Memento memento) {
        state = memento.getState();
        System.out.println("Restored State: " + state);
    }
}
