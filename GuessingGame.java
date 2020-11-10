import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;

public class GuessingGame implements ActionListener {
  JTextField userGuess; 
  JButton guessButton; 
  JButton playAgainButton; 
  JLabel theGuess;
  JLabel highLow;
  JLabel lastGuess;
  Random r = new Random();
  int randomNum= r.nextInt(100);

  GuessingGame(){
    int randomNum= r.nextInt(100);
    // Create a new JFrame container. 
    JFrame frame = new JFrame("Guessing Game"); 
    //Specify FlowLayout for the layout manager. 
    frame.setLayout(new FlowLayout()); 
    // Give the frame an initial size. 
    frame.setSize(240, 120); 
    // Create a text field. 
    userGuess = new JTextField(10); 
    userGuess.setActionCommand("myTF"); 

    //Buttons
    guessButton = new JButton("Guess");
    playAgainButton = new JButton("Play Again");
    // Add action listeners. 
    userGuess.addActionListener(this); 
    guessButton.addActionListener(this);
    playAgainButton.addActionListener(this);
    //Labels
    theGuess = new JLabel("Enter your guess: "); 
    highLow = new JLabel(""); 
    lastGuess = new JLabel(""); 
    //add to frame
    frame.add(theGuess); 
    frame.add(userGuess); 
    frame.add(guessButton); 
    frame.add(highLow);
    frame.add(lastGuess);
    frame.add(playAgainButton);
    //Display frame
    frame.setVisible(true);
  }

  public void actionPerformed(ActionEvent ae) {
    if(ae.getActionCommand().equals("Guess")){
      int guess = Integer.parseInt(userGuess.getText());
      if(guess<randomNum){
        highLow.setText("Too Low");
        lastGuess.setText("Last guess was: "+guess);
      }
      else if (guess>randomNum) {
        highLow.setText("Too High");
        lastGuess.setText("Last guess was: "+guess);
      }
      else {
        highLow.setText("You got it");
        lastGuess.setText("Last guess was: "+guess);
      }
       
      
    }
    else if (ae.getActionCommand().equals("Play Again")){
      int randomNum= r.nextInt(100);
      theGuess.setText("Enter your guess: "); 
      highLow.setText(""); 
      lastGuess.setText(""); 
      userGuess.setText(""); 

    }
    else {
      highLow.setText("You pressed Enter. Please press the Guess Button.");
    }
  }
}