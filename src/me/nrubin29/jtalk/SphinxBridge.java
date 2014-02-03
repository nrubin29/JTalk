package me.nrubin29.jtalk;

import edu.cmu.sphinx.frontend.util.Microphone;
import edu.cmu.sphinx.recognizer.Recognizer;
import edu.cmu.sphinx.result.Result;
import edu.cmu.sphinx.util.props.ConfigurationManager;

public class SphinxBridge {
	
	private ConfigurationManager cm;
    private Recognizer recognizer;
    private Microphone microphone;
    private boolean using = false;

	public SphinxBridge() {
        this.cm = new ConfigurationManager(SphinxBridge.class.getResource("input.config.xml"));
    	this.recognizer = (Recognizer) cm.lookup("recognizer");
    	this.microphone = (Microphone) cm.lookup("microphone");

        recognizer.allocate();
	}
	
	public void getInput() {
        if (using) return;

        using = true;

        microphone.clear();

        if (!microphone.startRecording()) {
            JTalk.speak("Cannot start microphone.");
            return;
        }

        JTalk.speak("Speak now.");

        Result result = recognizer.recognize();

        if (result != null) {
            String resultText = result.getBestFinalResultNoFiller();

            JDispatcher.getInstance().matchInput(resultText);
        }

        else {
            JTalk.speak("Try again.");
        }

        microphone.stopRecording();

        using = false;
	}
}