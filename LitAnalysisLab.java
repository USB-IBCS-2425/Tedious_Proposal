import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.io.FileWriter;
import java.io.IOException;

class LitAnalysisLab {
	public JFrame mainframe;
	public JPanel output;
    public JButton readB;
    public JButton avgB;
    public JButton writeB;

	public static JTextField toRead;
	public static JTextArea resultT;
	public static ArrayList<String> textTokens;
    public static ArrayList<String> allwords;
    public static HashMap<String, Integer> wordFrequencies = new HashMap<>();


	public LitAnalysisLab() {

		textTokens = new ArrayList<String>();
        allwords = new ArrayList<String>();
        wordFrequencies = new HashMap<String, Integer>();

		mainframe = new JFrame("Literature Analysis");
		mainframe.setSize(800, 600);

		mainframe.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent){
                System.exit(0);
            }        
        });

		toRead = new JTextField("MarkTwain.txt");
		toRead.setBounds(300, 50, 200, 40);
        mainframe.setLayout(null);
        mainframe.add(toRead);

        output = new JPanel();
        output.setBounds(200, 250, 100, 40);
        mainframe.add(output);

        readB = new JButton("Read File");
        readB.setActionCommand("READ");
        readB.addActionListener(new ButtonClickListener());
        readB.setBounds(100, 100, 200, 50);
        mainframe.add(readB);

        avgB = new JButton("Average Word");
        avgB.setActionCommand("AVG");
        avgB.addActionListener(new ButtonClickListener());
        avgB.setBounds(300, 100, 200, 50);
        mainframe.add(avgB);

        writeB = new JButton("Write File");
        writeB.setActionCommand("WRITE");
        writeB.addActionListener(new ButtonClickListener());
        writeB.setBounds(500, 100, 200, 50);
        mainframe.add(writeB);

        resultT = new JTextArea("");
        resultT.setBounds(200, 350, 400, 240);
        mainframe.add(resultT);

        JButton longB = new JButton("Longest Word");
        longB.setActionCommand("LONGEST");
        longB.addActionListener(new ButtonClickListener());
        longB.setBounds(100, 150, 200, 50);
        mainframe.add(longB);

        JButton shortB = new JButton("Shortest Word");
        shortB.setActionCommand("SHORTEST");
        shortB.addActionListener(new ButtonClickListener());
        shortB.setBounds(300, 150, 200, 50);
        mainframe.add(shortB);


        JButton sentLenB = new JButton("Sentence Length");
        sentLenB.setActionCommand("SENTLEN");
        sentLenB.addActionListener(new ButtonClickListener());
        sentLenB.setBounds(500, 150, 200, 50);
        mainframe.add(sentLenB);

        JButton uniqueSentB = new JButton("Unique Sentence");
        uniqueSentB.setActionCommand("UNIQUESENT");
        uniqueSentB.addActionListener(new ButtonClickListener());
        uniqueSentB.setBounds(100, 200, 200, 50);
        mainframe.add(uniqueSentB);

        JButton maxVowelB = new JButton("Most Vowels");
        maxVowelB.setActionCommand("MAXVOWEL");
        maxVowelB.addActionListener(new ButtonClickListener());
        maxVowelB.setBounds(300, 200, 200, 50);
        mainframe.add(maxVowelB);

        JButton minVowelB = new JButton("Least Vowels");
        minVowelB.setActionCommand("MINVOWEL");
        minVowelB.addActionListener(new ButtonClickListener());
        minVowelB.setBounds(500, 200, 200, 50);
        mainframe.add(minVowelB);


        mainframe.setVisible(true);
	}

	public static void main(String[] args) {
		LitAnalysisLab fo = new LitAnalysisLab();
	}

    public static double round(double x, int places) {
        int mult = (int)Math.pow(10, places);
        int y = (int)(x*mult);
        double rounded = y / (double) mult;
        return rounded;
    }

    public static void readFile() {
        String fname = toRead.getText();
        textTokens.clear();

        try {
            File f = new File(fname);
            Scanner s = new Scanner(f);
            while (s.hasNext()) {
                String data = s.next();
                textTokens.add(data);
            }
            s.close();
        }
        catch (FileNotFoundException err) {
            System.out.println("An error occurred.");
            err.printStackTrace();
        }

        resultT.setText("File Read\nFile has " + textTokens.size() + " tokens");
    }

    public static void parseWords() {
        allwords.clear();
        for (int i = 0; i < textTokens.size(); i++) {
            String[] tempWords = textTokens.get(i).split("\\s|--");
            for (String s : tempWords) {
                s = s.replaceAll("[\\p{P}_]", "");
                s = s.toLowerCase();
                allwords.add(s);
            }
        }
    }




    public static void showAvg() {
        double totLen = 0;
        for (String w : allwords) {
            totLen = totLen + w.length();
        }
        double avgLen = totLen / allwords.size();
        avgLen = round(avgLen, 2);
        String res = "The average word length is:\n";
        res = res + avgLen + " characters";
        resultT.setText(res);
    }



    public static void buildWordFrequencyMap() {

      wordFrequencies.clear();
     

     for (String word : allwords) {

            if (word.trim().isEmpty()) {
             continue;
           }
        

           if (wordFrequencies.containsKey(word)) {

              int currentCount = wordFrequencies.get(word);
              wordFrequencies.put(word, currentCount + 1);
          } else {

                wordFrequencies.put(word, 1);
          }
       }
    

      int uniqueWords = wordFrequencies.size();
      int totalWords = allwords.size();
      
      resultT.setText("Word Frequency\n");
      resultT.append("Total words: " + totalWords + "\n");
      resultT.append("Unique words: " + uniqueWords + "\n\n");

      String mostCommonWord = "";
      int highestFreq = 0;
      String leastCommonWord = "";
      int lowestFreq = Integer.MAX_VALUE;

    for (Map.Entry<String, Integer> entry : wordFrequencies.entrySet()) {
        String word = entry.getKey();
        int freq = entry.getValue();

        if (freq > highestFreq) {
            mostCommonWord = word;
            highestFreq = freq;
        }

        if (freq < lowestFreq) {
            leastCommonWord = word;
            lowestFreq = freq;
        }

    }

        resultT.setText("Word Frequency Analysis:\n");
        resultT.append("Total unique words: " + wordFrequencies.size() + "\n\n");
        resultT.append("Most common word: \"" + mostCommonWord + 
         "\" appears " + highestFreq + " times\n");
        resultT.append("Least common word: \"" + leastCommonWord + 
            "\" appears " + lowestFreq + " times\n");
 }


    
    public static void writeFile() {
        // NEED TO CHECK WITH USER FIRST!
        String fname = toRead.getText();
        String toWrite = resultT.getText();

        try {
            FileWriter w = new FileWriter(fname);
            w.write(toWrite);
            w.close();
        }
        catch (IOException er) {
            System.out.println("Error message:");
            er.printStackTrace();
        }
    }

    public static void findLongestWord() {
        String longestWord = "";
    
        for (String word : allwords) {
            if (word.length() > longestWord.length() && countVowels(word) > 0 && word.matches("[a-z]+") && !word.contains("gutenberg")) {

            longestWord = word;
            }
        }
    
        resultT.setText("The longest word is \"" + longestWord);
    }

    public static void findShortestWord() {

    
        String shortestWord = allwords.get(0);
    
        for (String word : allwords) {
            if (word.length() < shortestWord.length() && word.length() > 0 && word.matches("[a-z]+")) {
                shortestWord = word;
            }
        }
    
        resultT.setText("The shortest word is \"" + shortestWord);
    }



    public static void averageSentenceLength() {
    
        ArrayList<String> sentences = new ArrayList<>();
        StringBuilder currentSentence = new StringBuilder();
    
        for (String token : textTokens) {
            currentSentence.append(token).append(" ");
        
    
            if (token.endsWith(".") || token.endsWith("!") || token.endsWith("?")) {
                sentences.add(currentSentence.toString().trim());
                currentSentence = new StringBuilder();
        }
    }
    
        if (currentSentence.length() > 0) {
            sentences.add(currentSentence.toString().trim());
    }

        int totalWords = 0;
        for (String sentence : sentences) {
            String[] words = sentence.split("\\s+");
            totalWords += words.length;
    }

        double avgLength = (double) totalWords / sentences.size();
        avgLength = round(avgLength, 2);
    
        resultT.setText("Average sentence length: " + avgLength + " words\n");
    }


    public static void findMostUniqueSentence() {

        if (wordFrequencies == null || wordFrequencies.isEmpty()) {
            buildWordFrequencyMap();
        }
    

        ArrayList<String> sentences = new ArrayList<>();
        StringBuilder currentSentence = new StringBuilder();
    
        for (String token : textTokens) {
            currentSentence.append(token).append(" ");
        
            if (token.endsWith(".") || token.endsWith("!") || token.endsWith("?")) {

                String completedSentence = currentSentence.toString().trim();

                if (!completedSentence.toLowerCase().contains("gutenberg")) {
                    sentences.add(completedSentence);
                }

                currentSentence = new StringBuilder();
            }
        }
    

        if (currentSentence.length() > 0) {

            sentences.add(currentSentence.toString().trim());
            String finalSentence = currentSentence.toString().trim();

            if (!finalSentence.toLowerCase().contains("gutenberg")) {
            sentences.add(finalSentence);

        }


        }
    

        String mostUniqueSentence = "";
        double lowestAvgFrequency = 99999.99;
    
        for (String sentence : sentences) {

            String[] words = sentence.split("\\s+");
        

            if (words.length < 8) {
            continue;
            }
        

            double totalFrequency = 0;
            int wordCount = 0;
        
            for (String word : words) {

                String cleanWord = word.replaceAll("[\\p{P}_]", "").toLowerCase();
            
                if (!cleanWord.isEmpty()) {
                    int freq;
                if (wordFrequencies.containsKey(cleanWord)) {
                    freq = wordFrequencies.get(cleanWord);
                } else {
                    freq = 1;
                }
                totalFrequency += freq;
                wordCount++;
            }
        }
        
         double avgFrequency = totalFrequency / wordCount;
        

             if (avgFrequency < lowestAvgFrequency) {
                lowestAvgFrequency = avgFrequency;
                mostUniqueSentence = sentence;
            }
        }
    

        resultT.setText(mostUniqueSentence);
    
    }

    public static void findWordWithMostVowels() {
        String wordWithMostVowels = "";
        int maxVowelCount = 0;
    
        for (String word : allwords) {
            int vowelCount = countVowels(word);
            if (vowelCount > maxVowelCount) {
                maxVowelCount = vowelCount;
                wordWithMostVowels = word;
            }
        }
    
        resultT.setText("The word with the most vowels is: \"" + wordWithMostVowels +  "\" with " + maxVowelCount + " vowels");
        }

    public static void findWordWithLeastVowels() {

        String wordWithLeastVowels = "";
        int minVowelCount = 999999;
    
        for (String word : allwords) {
       
            if (word.length() >= 2 && word.matches("[a-z]+")) {
                int vowelCount = countVowels(word);
                if (vowelCount < minVowelCount && vowelCount > 0) {
                    minVowelCount = vowelCount;
                    wordWithLeastVowels = word;
                }
            }
        }
    
        resultT.setText(wordWithLeastVowels);
    }   

    public static int countVowels(String word) {
        int count = 0;
        for (char c : word.toLowerCase().toCharArray()) {
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                count++;
            }
        }
        return count;
    }

    public static void allwords() {
        boolean foundStart = false;
        int startIndex = -1;
        int endIndex = -1;
        int asteriskCount = 0;
        
        for (int i = 0; i < allwords.size(); i++) {
            if (allwords.get(i).equals("*")) {
                asteriskCount++;
                

                if (asteriskCount >= 6 && !foundStart) {
                    foundStart = true;
                    startIndex = i + 1; 
                    asteriskCount = 0;  
                }

                else if (foundStart && asteriskCount >= 1) {
                    endIndex = i - asteriskCount; 
                    break;
                }
            } else {

                asteriskCount = 0;
            }
        }
        

        if (startIndex >= 0 && endIndex > startIndex) {
            ArrayList<String> mainText = new ArrayList<>(allwords.subList(startIndex, endIndex));
            allwords.clear();
            allwords.addAll(mainText);
            resultT.setText("Main text extracted.\n" + 
                           "Removed header and footer text.\n" +
                           "Remaining words: " + allwords.size());
        } else {
            resultT.setText("Could not identify book boundaries.");
        }
    }
        



	private class ButtonClickListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();

            if (command.equals("WRITE")) {
                writeFile();
            }

            if (command.equals("READ")) {
                allwords();
                readFile();
                parseWords();
                buildWordFrequencyMap();;
            }

            if (command.equals("AVG")) {
                allwords();
                parseWords();
                showAvg();
            }

            if (command.equals("LONGEST")) {
                parseWords();
                allwords();
                findLongestWord();
            }
        
            if (command.equals("SHORTEST")) {
                allwords();
                parseWords();
                findShortestWord();

            }

            if (command.equals("SENTLEN")) {
                allwords();
                averageSentenceLength();
            }
        
            if (command.equals("UNIQUESENT")) {
                allwords();
                parseWords(); 
                findMostUniqueSentence();
            }

            if (command.equals("MAXVOWEL")) {
                allwords();
                parseWords();
                findWordWithMostVowels();
            }

            if (command.equals("MINVOWEL")) {
                allwords();
                parseWords();
                findWordWithLeastVowels();
            }

        }
    }
}