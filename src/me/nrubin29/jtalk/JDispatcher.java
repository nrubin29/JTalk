package me.nrubin29.jtalk;

import java.util.ArrayList;

public class JDispatcher {

    private JDispatcher() { }

    private static JDispatcher instance = new JDispatcher();

    protected static JDispatcher getInstance() {
        return instance;
    }

    private ArrayList<JListener> listeners = new ArrayList<JListener>();

    public void registerListener(JListener listener) {
        listeners.add(listener);
    }

    public void matchInput(String input) {
        for (JListener listener : listeners) {
            if (input.matches(listener.getRegex())) listener.onSpeak(input.split(" "));
        }
    }
}