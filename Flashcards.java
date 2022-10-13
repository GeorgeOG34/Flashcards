import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.File;
import java.util.Scanner;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;
/**
 * Flashcards
 *
 * @author George
 * @version 1
 */
public class Flashcards
{
    private JFrame frame;
    private int index = 0;//This contain the current index in the List of flashcard questions and answer. Even numbers = question, Odd = answer
    private JTextArea qnaLabel; //This is the textarea where the flashcards will be displayed
    //This was originally a label, hence the name qnaLabel.
    private List<String> content = null; //This will contain all the questions and answers
    public static void main(String[] args){
        Flashcards fc = new Flashcards();
    }
    public Flashcards()
    {
        frame = new JFrame("Flashcards");
        frame.setSize(800,450);
        
        //This button will load questions for the Computer Systems topic
        JButton loadCS = new JButton("Computer Systems");
        loadCS.setBounds(600, 50, 160, 40);
        loadCS.addActionListener(ev -> loadCS());
        frame.add(loadCS);
        //This button will load questions for the Introduction to AI module
        JButton introToAI = new JButton("IntroToAI");
        introToAI.setBounds(600, 100, 160, 40);
        introToAI.addActionListener(ev -> introToAI());
        frame.add(introToAI);
        //This button will load questions for the Introduction to Theory of Computing module
        JButton theoryOfComputing = new JButton("TheoryOfComputing");
        theoryOfComputing.setBounds(600, 150, 160, 40);
        theoryOfComputing.addActionListener(ev -> theoryOfComputing());
        frame.add(theoryOfComputing);
        
        //This button will increase the index by 1, effectively turning over the flashcard, or moving on to the next one.
        JButton forward = new JButton("Forward");
        forward.setBounds(600, 0, 160, 40);
        forward.addActionListener(ev -> forward());
        frame.add(forward);
        
        //This button will decrease the index by 1, effectively the reverse of the forward button
        JButton backward = new JButton("Backward");
        backward.setBounds(400, 0 , 160, 40);
        backward.addActionListener(ev -> backward());
        frame.add(backward);
        
        //This will load up a random flashcard from the list, could be the answer or the question
        JButton randomIndex = new JButton("randomIndex");
        randomIndex.setBounds(200, 0 , 160, 40);
        randomIndex.addActionListener(ev -> randomIndex());
        frame.add(randomIndex);
        
        //Label here
        qnaLabel = new JTextArea("Please select a topic");
        qnaLabel.setBounds(10, 50,550, 400);
        qnaLabel.setFont(new Font("Comic Sans", Font.BOLD, 20));
        qnaLabel.setLineWrap(true);
        qnaLabel.setWrapStyleWord(true);
        frame.add(qnaLabel);
        
        
        frame.setLayout(null);
        frame.setVisible(true);
    }
    /*
     * This function loads the given file to the list, where each line is a question/answer
     */
    public static List readFile(String path, Charset encoding) throws IOException
    {
        List<String> lines = Files.readAllLines(Paths.get(path), encoding);
        return lines;
    }
    /*
     * This load the Computer System Flashcards
     * Which are stored in ComputerSystems.txt
     */
    public void loadCS(){
        ArrayList<String> qna = new ArrayList<String>();
        String filePath = "ComputerSystems.txt";       
        try {
            content = readFile(filePath, StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
        index = 0;
        qnaLabel.setText(content.get(index));
    }
    /*
     * This load the Introduction to AI Flashcards
     * Which are stored in IntroToAI.txt
     */
    public void introToAI(){
        ArrayList<String> qna = new ArrayList<String>();
        String filePath = "IntroToAI.txt";       
        try {
            content = readFile(filePath, StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
        index = 0;
        qnaLabel.setText(content.get(index));
    }
    /*
     * This load the Theory of Computing Flashcards
     * Which are stored in TheoryOfComputing.txt
     */
    public void theoryOfComputing(){
        ArrayList<String> qna = new ArrayList<String>();
        String filePath = "TheoryOfComputing.txt";       
        try {
            content = readFile(filePath, StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
        index = 0;
        qnaLabel.setText(content.get(index));
    }
    /*
     * This set the index to a random number from 0 to the length of the list - 1
     * Which is the total number of questions and answers.
     * It then loads that question or answer into the textArea
     */
    public void randomIndex(){
        Random rand = new Random();
        index = rand.nextInt(content.size());
        qnaLabel.setText(content.get(index));
    }
    /*
     * This increases index and loads the next item in the list to the text area. Unless there are no more flash cards
     */    
    public void forward(){
        if ((index + 1) > content.size() -1){
            qnaLabel.setText("End of flash cards");
        } else{
            index++;
            qnaLabel.setText(content.get(index));
        }
    }
    /*
     * This decreases the  index and loads the previous item in the list to the text area. Unless there are no previous flash cards
     */  
    public void backward(){
        if ((index - 1) < 0){
            qnaLabel.setText("End of flash cards");
        } else{
            index--;
            qnaLabel.setText(content.get(index));
        }
    }
}
