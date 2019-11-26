import oracle.jvm.hotspot.jfr.JFR;

import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

public class Main {


    private static Mixer mixer;
    private static Clip clip;
    private static JFrame frame;
    private static JPanel panel;
    private static JButton BP_Beginning;
    private static JButton BP_Unending;
    private static JButton BP_Moo;
    private static JButton BP_Growl;
    private static JButton BP_Reason;
    private static JButton BP_Rejected;


    public static void main(String[] args) {

        Mixer.Info[] mixInfos = AudioSystem.getMixerInfo();
        mixer = AudioSystem.getMixer(mixInfos[0]);

        DataLine.Info datainfo = new DataLine.Info(Clip.class, null);

        frame = new JFrame("BPNickelback");
        frame.setVisible(true);
        frame.setSize(800, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new JPanel();
        panel.setBackground(Color.CYAN);

        BP_Beginning = new JButton("BP BEGINNING");


        BP_Beginning.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    clip = (Clip) mixer.getLine(datainfo);
                }
                catch (Exception e1) {
                    e1.printStackTrace();
                }

                try {
                    URL soundURL = Main.class.getResource("BP_Beginning.wav");
                    AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(soundURL);
                    clip.open(audioInputStream);
                }
                catch (Exception e2) {
                    e2.printStackTrace();
                }

                clip.start();

                do {
                    try {
                        Thread.sleep(50);
                    }
                    catch (Exception e3) {
                        e3.printStackTrace();
                    }

                }

                while (clip.isActive());
            }
        });
//        try {
//            clip = (Clip) mixer.getLine(datainfo);
//        }
//        catch (Exception e) {
//                e.printStackTrace();
//        }
//
//        try {
//            URL soundURL = Main.class.getResource("BP_Beginning.wav");
//            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(soundURL);
//            clip.open(audioInputStream);
//        }
//        catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        clip.start();
//
//        do {
//            try {
//                Thread.sleep(50);
//            }
//            catch (Exception e) {
//                e.printStackTrace();
//            }
//
//        }
//
//        while (clip.isActive());

        panel.add(BP_Beginning);

        frame.add(panel);

    }



}
