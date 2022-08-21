import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.event.*;
import java.io.File;

public class GUI {

    private static JFrame frame;
    private static JLabel playLabel;

    // The constructor
    public GUI(){
        // New Frame
        frame = new JFrame();
        // New button
        JButton button = new JButton("Start!");

        //Load the starting image background
        ImageIcon backgroundImg = new ImageIcon("bingobingobackground/start.png");
        frame.setSize(1280, 720);
        JLabel startLabel = new JLabel(backgroundImg);
        startLabel.setBounds(0, 0, 1280, 720);
        frame.add(startLabel);

        startLabel.add(button);
        button.setBounds(900, 800, 100, 50);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Title name is Bingo Bingo
        frame.setTitle("Bingo Bingo");
        frame.pack();
        frame.setVisible(true);

        // When the button is clicked then we use this
        button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                startLabel.setIcon(null);
                button.setVisible(false);
                //Load the second image background
                ImageIcon backgroundImg2 = new ImageIcon("bingobingobackground/background.png");
                playLabel = new JLabel(backgroundImg2);
                playLabel.setBounds(0, 0, 1280, 720);
                frame.add(playLabel);

                start();
            }
        });
    }

    // After we press the start button we play the game
    public static void start() {
        JLabel label1 = new JLabel();
        JLabel label2 = new JLabel();
        label1.setVisible(false);
        label2.setVisible(false);

        //Make a new button so that we can swap animals
        JButton swapButton = new JButton("Swap!");
        playLabel.add(swapButton);
        swapButton.setBounds(900, 450, 100, 50);

        JButton correctButton = new JButton("Correct!");
        playLabel.add(correctButton);
        correctButton.setBounds(900, 300, 100, 50);

        JButton wrongButton = new JButton("Wrong!");
        playLabel.add(wrongButton);
        wrongButton.setBounds(900, 375, 100, 50);

        //Choose colors given numbers
        String firstColor = setColorFromNum(randNumGenerator());
        String secondColor = setColorFromNum(randNumGenerator());

        // We make two animal arrays because they could be the same color if it's in the same array all together
        Animal[] firstAnimalArray = {new Crab(firstColor), new Rabbit(firstColor), new Giraffe(firstColor), new Gorilla(firstColor)};
        Animal[] secondAnimalArray = {new Crab(secondColor), new Rabbit(secondColor), new Giraffe(secondColor), new Gorilla(secondColor)};

        //Initialize the two random animals
        Animal firstAnimal = randomAnimal(firstAnimalArray);
        Animal secondAnimal = randomAnimal(secondAnimalArray);

        //Initialize the two images of the animals
        String firstPicture = firstAnimal.getImagePath();
        String secondPicture = secondAnimal.getImagePath();

        //Display the first image
        label1.setIcon(new ImageIcon(firstPicture));
        playLabel.add(label1);
        label1.setBounds(0, 300, 600, 600);

        //Display the second image
        label2.setIcon(new ImageIcon(secondPicture));
        playLabel.add(label2);
        label2.setBounds(1300, 300, 600, 600);

        label1.setVisible(true);
        label2.setVisible(true);

        //When we click the button it should reset so that we get new animals.
        swapButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                label1.setVisible(false);
                label2.setVisible(false);
                swapButton.setVisible(false);
                correctButton.setVisible(false);
                wrongButton.setVisible(false);
                start();
            }
        });

        correctButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playSound("sounds/correct.wav");
            }
        });

        wrongButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playSound("sounds/wrong.mp3");
            }
        });

    }

    //We use this method to get a random animal from an Animal array and return the random index of an animal.
    public static Animal randomAnimal(Animal[] arr) {
        int maxIndex = arr.length - 1;
        int minIndex = 0;
        int range = maxIndex - minIndex + 1;
        int randNum = (int)(Math.random() * range) + minIndex;
        return arr[randNum];
    }
    // We use this method to select a specific color given a random number
    public static String setColorFromNum(int num) {
        if (num == 1) {
            return "red";
        } else if (num == 2) {
            return "white";
        } else if (num == 3) {
            return "yellow";
        } else {
            return "black";
        }
    }
    // We use this method to choose a random number from 1-4 and return it
    public static int randNumGenerator() {
        int max = 4;
        int min = 1;
        int range = max - min + 1;
        return (int)(Math.random() * range) + min;
    }
    //This is how we play sounds from a specific file
    public static void playSound(String soundName) {
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(soundName).getAbsoluteFile());
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
        }
        catch(Exception ex) {
            System.out.println("Error with playing sound.");
            ex.printStackTrace( );
        }
    }
}