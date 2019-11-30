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
    private static DataLine.Info datainfo;
    private static JFrame frame;
    private static JPanel panel;
    private static JButton BP_Beginning;
    private static JButton BP_Unending;
    private static JButton BP_Moo;
    private static JButton BP_Growl;
    private static JButton BP_Reason;
    private static JButton BP_Rejected;
    private static JButton BP_Exotic;
    private static JButton BP_Under_Pressure;
    private static JButton NB_Breaking;
    private static JButton NB_Fun;
    private static JButton NB_Remind_Me;
    private static JButton NB_SO_BAD;
    private static JButton NB_YEAH;
    private static int currFunX = 185;


    public static void main(String[] args) {

        Mixer.Info[] mixInfos = AudioSystem.getMixerInfo();
        mixer = AudioSystem.getMixer(mixInfos[0]);

        datainfo = new DataLine.Info(Clip.class, null);

        frame = new JFrame("BPNickelback");
        frame.setVisible(true);
        frame.setSize(800, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new JPanel();
        panel.setBackground(Color.CYAN);

        panel.setLayout(null);

        BP_Beginning = new JButton();
        initializeButton(BP_Beginning, "BP_Beginning.wav");
        BP_Beginning.setBounds(25, 600, 50, 150);

        NB_Fun = new JButton("NB_Fun");
        initializeButton(NB_Fun, "NB_FUN.wav");
        NB_Fun.setBounds(currFunX, 430, 35, 125);
        NB_Fun.setBackground(Color.BLACK);
        NB_Fun.setOpaque(true);
        NB_Fun.setBorderPainted(false);


        BP_Exotic = new JButton("BP_Exotic");
        initializeButton(BP_Exotic, "BP_EXOTIC.wav");
        BP_Exotic.setBounds(125, 600, 50, 150);

        NB_Breaking = new JButton("NB_Breaking");
        initializeButton(NB_Breaking, "NB_BREAKING.wav");
        NB_Breaking.setBounds(currFunX + 100, 430, 35, 125);
        NB_Breaking.setBackground(Color.BLACK);
        NB_Breaking.setOpaque(true);
        NB_Breaking.setBorderPainted(false);


        BP_Growl = new JButton("BP_Growl");
        initializeButton(BP_Growl, "BP_EXOTIC.wav");
        BP_Growl.setBounds(225, 600, 50, 150);

        NB_Remind_Me = new JButton("NB_Remind_Me");
        initializeButton(NB_Remind_Me, "NB_Remind_Me.wav");
        NB_Remind_Me.setBounds(currFunX + 200, 430, 35, 125);
        NB_Remind_Me.setBackground(Color.BLACK);
        NB_Remind_Me.setOpaque(true);
        NB_Remind_Me.setBorderPainted(false);

        BP_Moo = new JButton("BP_Moo");
        initializeButton(BP_Moo, "BP_Moo.wav");
        BP_Moo.setBounds(325, 600, 50, 150);


        BP_Reason = new JButton("BP_Reason");
        initializeButton(BP_Moo, "BP_REASON.wav");
        BP_Reason.setBounds(425, 600, 50, 150);


        BP_Under_Pressure = new JButton("BP_Under_Pressure");
        initializeButton(BP_Under_Pressure, "BP_Rejected.wav");
        BP_Under_Pressure.setBounds(525, 600, 50, 150);

        BP_Rejected = new JButton("BP_Rejected");
        initializeButton(BP_Rejected, "BP_Under_Pressure.wav");
        BP_Rejected.setBounds(625, 600, 50, 150);

        BP_Unending = new JButton("BP_Unending");
        initializeButton(BP_Unending, "BP_Under_Pressure.wav");
        BP_Unending.setBounds(725, 600, 50, 150);


        NB_SO_BAD = new JButton("NB_SO_BAD");
        initializeButton(NB_SO_BAD, "NB_SO_BAD.wav");
        NB_SO_BAD.setBounds(currFunX + 300, 430, 35, 125);
        NB_SO_BAD.setBackground(Color.BLACK);
        NB_SO_BAD.setOpaque(true);
        NB_SO_BAD.setBorderPainted(false);

        NB_YEAH = new JButton("NB_YEAH");
        initializeButton(NB_YEAH, "NB_YEAH.wav");
        NB_YEAH.setBounds(currFunX + 400, 430, 35, 125);
        NB_YEAH.setBackground(Color.BLACK);
        NB_YEAH.setOpaque(true);
        NB_YEAH.setBorderPainted(false);

        panel.add(BP_Beginning);
        panel.add(BP_Exotic);
        panel.add(BP_Growl);
        panel.add(BP_Moo);
        panel.add(BP_Reason);
        panel.add(BP_Rejected);
        panel.add(BP_Under_Pressure);
        panel.add(BP_Unending);
        panel.add(NB_Breaking);
        panel.add(NB_Fun);
        panel.add(NB_Remind_Me);
        panel.add(NB_SO_BAD);
        panel.add(NB_YEAH);



        frame.add(panel);

    }

    private static void initializeButton(JButton jButton, String clipPath) {

        int status = 0;
        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                    try {
                        clip = (Clip) mixer.getLine(datainfo);
                    } catch (Exception e1) {
                        e1.printStackTrace();
                    }


                    try {
                        URL soundURL = Main.class.getResource(clipPath);
                        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(soundURL);
                        clip.open(audioInputStream);
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }

                    clip.start();

//                do {
//                    try {
//                        Thread.sleep(50);
//                    }
//                    catch (Exception e3) {
//                        e3.printStackTrace();
//                    }
//
//                }
//
//                while (clip.isActive());

            }

        });
    }



}
