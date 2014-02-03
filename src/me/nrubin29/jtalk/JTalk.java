package me.nrubin29.jtalk;

import me.nrubin29.jtalk.sample.SampleListener;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

public class JTalk {

    private SphinxBridge sphinxBridge;

    private JTalk() {
        try {
            PopupMenu menu = new PopupMenu("JTalk");

            BufferedImage image = ImageIO.read(JTalk.class.getClassLoader().getResource("res/trayicon.png"));

            TrayIcon icon = new TrayIcon(image, "JTalk", menu);

            icon.addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    if (e.isAltDown()) System.exit(0);
                    else sphinxBridge.getInput();
                }
            });

            sphinxBridge = new SphinxBridge();

            new SampleListener();

            SystemTray.getSystemTray().add(icon);
        }
        catch (Exception e) { e.printStackTrace(); }
    }

    public static void speak(String text) {
        try { Runtime.getRuntime().exec("say " + text); }
        catch (Exception e) { e.printStackTrace(); }
    }

    public static void main(String[] args) {
        new JTalk();
    }
}