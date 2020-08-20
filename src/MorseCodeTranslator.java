/*CS211 SPRING 2020, Created: 6/17/20, Lee Janzen 
This executes programming project 2, chapter 17.
It is an exercise on binary search trees.
It is designed as a morse code translator.
GUI built from this framework: https://www.javatpoint.com/word-count-in-java*/

import java.awt.event.*;   
import javax.swing.*;  
public class MorseCodeTranslator extends JFrame implements ActionListener{  
JLabel l; 
JTextArea ta;  
JButton b1,b2,b3;  
MorseCodeTranslator(){  
    super("Morse Code Translator");   
       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
       l=new JLabel("Type English text or Morse code for translation:");  
       l.setBounds(50,50,300,30);  
       ta=new JTextArea();  
       ta.setBounds(50,100,300,180);  
       ta.setLineWrap(true);
         
       b1=new JButton("Translate English");  
       b1.setBounds(50,300,135,30);   
       
       b2=new JButton("Translate Morse");  
       b2.setBounds(215,300,135,30);  
       
       b3=new JButton("Sample Tests");  
       b3.setBounds(50,20,300,20);
         
       b1.addActionListener(this);  
       b2.addActionListener(this);  
       b3.addActionListener(this); 
       add(l);add(b1);add(b2);add(b3);add(ta);  
       setSize(400,400);  
       setLayout(null);  
       setVisible(true);  
   }  
public void actionPerformed(ActionEvent e){   
    String text=ta.getText();
    MorseTree function = new MorseTree();
    //first button, runs our English translator
    if(e.getSource()==b1){  
        String encoding = function.encode(text);
        JOptionPane.showMessageDialog(this,"The translation is: "+ encoding);
    }  
    //second button, runs our morse translator
    if(e.getSource()==b2){  
        String decoding = function.decode(text);
        JOptionPane.showMessageDialog(this,"The translation is: "+ decoding);
    }  
    //third button, provides suggested tests for ease of use
    if(e.getSource()==b3){  
        String[] tests = {"Hello World!", "CS211 Final", "abcdefghijklmnopqrstuvwxyz", ".... . .-.. .-.. ---  .-- --- .-. .-.. -..", "-.-. ... ..--- .---- .----  ..-. .. -. .- .-..", ".- -... -.-. -.. . ..-. --. .... .. .--- -.- .-.. -- -. --- .--. --.- .-. ... - ..- ...- .-- -..- -.-- --.."};
        String input = (String) JOptionPane.showInputDialog(null,"Select a test:", "Suggested tests", JOptionPane.QUESTION_MESSAGE, null, tests, tests[0]);  
        ta.setText(input);
    } 
}  
public static void main(String[] args) {  
    new MorseCodeTranslator();  
}  
}  