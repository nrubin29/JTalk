package me.nrubin29.jtalk.sample;

import me.nrubin29.jtalk.JListener;
import me.nrubin29.jtalk.JTalk;

public class SampleListener extends JListener {

    public SampleListener() {
        super("(hello|goodbye|testing)");
    }

    public void onSpeak(String[] args) {
        if (args[0].equals("hello")) JTalk.speak("Hello there!");
        else if (args[0].equals("goodbye")) JTalk.speak("See you later!");
    }
}