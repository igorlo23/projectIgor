import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import javax.swing.JButton;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


public class OpenFile extends JFrame {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                try {
                    OpenFile window = new OpenFile();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private JButton btnmaxtp; // Declare a Button component
    private JButton btnrain;
    private JButton btnmean; // Declare a Button component
    private JButton btnsun;
    private JButton btnsave;



    public OpenFile() {

        // some row and column values for our JTextArea
        final int TXT_AREA_ROWS = 25;
        final int TXT_AREA_COLS = 80;
        setBounds(600, 600, 600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);



        JTextArea jTextArea1 = new JTextArea(TXT_AREA_ROWS,TXT_AREA_COLS);
        jTextArea1.setText("Text is here");

        JScrollPane scrollBar = new JScrollPane(jTextArea1); // put textarea into the scrollpane
        scrollBar.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollBar.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        //add(scrollBar);
        scrollBar.setBounds(100, 100, 413, 214);


        JButton btnNewButton = new JButton("Read text");
        btnNewButton.setBounds(10, 10, 100, 21);
        add(btnNewButton);
        btnmaxtp = new JButton("Display maxtp"); // Declare a Button component
        //add(btnmaxtp);
        btnrain = new JButton("Display rain");
        //add(btnrain);
        btnmean = new JButton("Display Mean Wind Speed"); // Declare a Button component
        //add(btnmean);
        btnsun = new JButton("Display sun");
        //add(btnsun);
        btnsave = new JButton("Save");
        //add(btnsave);

        JPanel p1 = new JPanel(new GridLayout(1,0,5,0)); // button panel

        p1.add(btnNewButton);
        p1.add(btnmaxtp);
        p1.add(btnsave);
        p1.add(btnmean);
        p1.add(btnrain);
        p1.add(btnsun);
        p1.add(btnNewButton);

        JLabel title = new JLabel("This is my application",SwingConstants.CENTER);
        title.setFont(title.getFont().deriveFont(Font.BOLD, 24));


        JPanel p2 = new JPanel(new GridLayout(1,0,5,0));
        
        p2.add(scrollBar);

        JFrame f = new JFrame();
        f. setLayout(new BorderLayout(5, 5));
        //setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        f.setSize(500, 500);
        f.add(p1, BorderLayout.PAGE_END);
        f.add(p2,BorderLayout.CENTER);
        f.add(title,BorderLayout.PAGE_START);
        f.setVisible(true);




        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0){
                JFileChooser chooser = new JFileChooser();
                chooser.showOpenDialog(null);
                File f = chooser.getSelectedFile();
                String nameFile = f.getAbsolutePath();

                try{
                    FileReader reader = new FileReader(nameFile);
                    BufferedReader br = new BufferedReader(reader);
                    jTextArea1.read(br,null);
                    br.close();
                    jTextArea1.requestFocus();
                    // filling the arraylist
                    String path = "C:\\Users\\igorl\\OneDrive\\Desktop\\project.csv";
                    String line = "";

                    try{
                        BufferedReader br1 = new BufferedReader(new FileReader(path));

                        while((line =br1.readLine()) != null){
                            String[] recordings = line.split(",");
                            System.out.println(line);
                        }

                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }catch (IOException e) {
                        e.printStackTrace();
                    }

                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null,e);
                }
            }
        });


        // Button to display the maxtp
        btnmaxtp.addActionListener(new ActionListener() {
            // when this button is pressed again generate the project list and sort the list and display it
            // fill in the array list first
            //ArrayList<Recordings> recordings = new ArrayList<>();

            // then sort the list
            // then display it.
            public void actionPerformed(ActionEvent arg0){

                try {
                    BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\igorl\\OneDrive\\Desktop\\project.csv"));

                    String currentLine;
                    while((currentLine = br.readLine())!=null)
                    {
                        String[] detailed = currentLine.split(",");
                        String year = detailed[1];
                        int month = Integer.parseInt(detailed[2]);
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }



              /*  String path1 = "C:\\Users\\igorl\\OneDrive\\Desktop\\project.csv";
                String line ="";
                BufferedReader br;
                    try {
                        br = new BufferedReader(new FileReader(path1));
                        while((line = br.readLine()) != null){
                            String[] maxtplist = line.split(",");
                        }
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                    catch(IOException e){
                        e.printStackTrace();
                    }
                Collections.sort(recordings);
                StringBuffer sb = new StringBuffer();

                for(Recordings recordings : recordings){
                    System.out.println(line);
                    sb.append("\n");
                    sb.append(recordings.toString());
                }
                jTextArea1.setText(sb.toString());
                */
            }
        });
    }
}
