import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class GUI {
    JFrame jf;
    JButton kayitEtme,listeleme;
    JLabel l1,l2;
    JTextArea t1;

    
    public GUI() throws IOException{
       
        File f = new File("metin.txt");
        FileWriter fw = new FileWriter(f);
        
        
        jf = new JFrame("Ödev: ");
        
        l1 = new JLabel("Kaydetmek istediginiz veri");
        l1.setBounds(10, 20, 250, 20);
        
        t1 = new JTextArea();
        t1.setBounds(10, 40, 400, 100);
        
        kayitEtme = new JButton("Kaydet");
        kayitEtme.setBounds(10, 200, 100, 30);
        
        l2 = new JLabel();
        l2.setBounds(10, 200, 400, 400);
        
        
        listeleme = new JButton("Listele");
        listeleme.setBounds(150, 200, 100, 30);
        
        kayitEtme.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    fw.write(t1.getText());
                    fw.flush();
                    
                } catch (IOException ex) {
                    Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                
            }
        });
        
        
        listeleme.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                try {
                    Scanner scan = new Scanner(f);
                    String listelenecekVeri = "";
                    while(scan.hasNextLine()){
                      listelenecekVeri += scan.nextLine();
                      l2.setText(listelenecekVeri);
                     }
                    
                    
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
        
        jf.add(listeleme);
        jf.add(l2);
        jf.add(l1);
        jf.add(t1);
        jf.add(kayitEtme);
        jf.setLayout(null);
        jf.setSize(500,700);
        jf.setDefaultCloseOperation(jf.EXIT_ON_CLOSE);
        jf.setVisible(true);
        
    }
    
    
}




