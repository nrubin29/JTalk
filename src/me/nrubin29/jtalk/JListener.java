package me.nrubin29.jtalk;

public abstract class JListener {

    private final String regex;

    public JListener(String regex) {
        this.regex = regex;

        JDispatcher.getInstance().registerListener(this);
    }

    public final String getRegex() {
        return regex;
    }

    public abstract void onSpeak(String[] args);
}