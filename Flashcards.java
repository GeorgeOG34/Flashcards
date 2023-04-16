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
 * @version 2
 */
public class Flashcards
{
    private JFrame frame;
    private int index = 0;
    private JTextArea qnaLabel;
    private List<String> content = null;
    public static void main(String[] args){
        Flashcards fc = new Flashcards();
    }
    public Flashcards()
    {
        frame = new JFrame("Flashcards");
        frame.setSize(800,450);
        
        JButton loadCS = new JButton("Computer Systems");
        loadCS.setBounds(600, 50, 160, 40);
        loadCS.addActionListener(ev -> loadCS());
        frame.add(loadCS);
        
        JButton introToAI = new JButton("IntroToAI");
        introToAI.setBounds(600, 100, 160, 40);
        introToAI.addActionListener(ev -> introToAI());
        frame.add(introToAI);
        
        JButton theoryOfComputing = new JButton("TheoryOfComputing");
        theoryOfComputing.setBounds(600, 150, 160, 40);
        theoryOfComputing.addActionListener(ev -> theoryOfComputing());
        frame.add(theoryOfComputing);

        JButton webDevBtn = new JButton("WebDev");
        webDevBtn.setBounds(600, 200, 160, 40);
        webDevBtn.addActionListener(ev -> webDev());
        frame.add(webDevBtn);

        JButton softBtn = new JButton("Software Dev");
        softBtn.setBounds(600, 250, 160, 40);
        softBtn.addActionListener(ev -> SoftwareDev());
        frame.add(softBtn);
        
        
        JButton forward = new JButton("Forward");
        forward.setBounds(600, 0, 160, 40);
        forward.addActionListener(ev -> forward());
        frame.add(forward);
        
        JButton backward = new JButton("Backward");
        backward.setBounds(400, 0 , 160, 40);
        backward.addActionListener(ev -> backward());
        frame.add(backward);
        
        JButton randomIndex = new JButton("randomIndex");
        randomIndex.setBounds(200, 0 , 160, 40);
        randomIndex.addActionListener(ev -> randomIndex());
        frame.add(randomIndex);
        
        
        qnaLabel = new JTextArea("Please select a topic");
        qnaLabel.setLineWrap(true);
        //qnaLabel.
        qnaLabel.setBounds(10, 50,550, 400);
        qnaLabel.setFont(new Font("Comic Sans", Font.BOLD, 20));
        frame.add(qnaLabel);
        
        
        frame.setLayout(null);
        frame.setVisible(true);
    }
    public static List readFile(String path, Charset encoding) throws IOException
    {
        List<String> lines = Files.readAllLines(Paths.get(path), encoding);
        return lines;
    }

    public ArrayList<String> format(List<String> rawInput){
        String all =  "";
        for (String x : rawInput){
            all = all + x;
        }
        String[] allSplit = all.split("<break>");

        rawInput.clear();
        for (String x : allSplit){
            rawInput.add(x);
        }
        ArrayList<String> lineContent = new ArrayList<String>();
        for( String x : rawInput){
            if (x.contains("<line>")){
                x = x.replace("<line>", "\n");
            }
            lineContent.add(x);
        }
        return lineContent;

    }
    
    public void loadCS(){
        ArrayList<String> qna = new ArrayList<String>();
        String filePath = "ComputerSystems.txt";       
        try {
            content = readFile(filePath, StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
        index = 0;

        ArrayList<String> lineContent = format(content);
        content.clear();
        for (String x: lineContent){
            content.add(x);
        }

        qnaLabel.setText(content.get(index));
    }
    public void introToAI(){
        ArrayList<String> qna = new ArrayList<String>();
        String filePath = "IntroToAI.txt";       
        try {
            content = readFile(filePath, StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
        index = 0;
        ArrayList<String> lineContent = format(content);
        content.clear();
        for (String x: lineContent){
            content.add(x);
        }
        qnaLabel.setText(content.get(index));
    }
    public void theoryOfComputing(){
        ArrayList<String> qna = new ArrayList<String>();
        String filePath = "TheoryOfComputing.txt";       
        try {
            content = readFile(filePath, StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
        index = 0;
        ArrayList<String> lineContent = format(content);
        content.clear();
        for (String x: lineContent){
            content.add(x);
        }
        qnaLabel.setText(content.get(index));
    }

    public void SoftwareDev(){
        ArrayList<String> qna = new ArrayList<String>();
        String filePath = "SoftwareDev.txt";       
        try {
            content = readFile(filePath, StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
        index = 0;

        ArrayList<String> lineContent = format(content);
        content.clear();
        for (String x: lineContent){
            content.add(x);
        }
        qnaLabel.setText(content.get(index));
    }

    public void webDev(){
        ArrayList<String> qna = new ArrayList<String>();
        String filePath = "webdev.txt";       
        try {
            content = readFile(filePath, StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
        index = 0;
        ArrayList<String> lineContent = format(content);
        content.clear();
        for (String x: lineContent){
            content.add(x);
        }
        qnaLabel.setText(content.get(index));
    }
    
    public void randomIndex(){
        Random rand = new Random();
        index = rand.nextInt(content.size());
        qnaLabel.setText(content.get(index));
    }
    
    public void forward(){
        if ((index + 1) > content.size() -1){
            qnaLabel.setText("End of flash cards");
        } else{
            index++;
            qnaLabel.setText(content.get(index));
        }
    }
    public void backward(){
        if ((index - 1) < 0){
            qnaLabel.setText("End of flash cards");
        } else{
            index--;
            qnaLabel.setText(content.get(index));
        }
    }
}
