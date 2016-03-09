package library;

//import classes
import javax.swing.*;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import java.math.*;

/**
 * Created by Mike Plucker
 * Date: 3/8/2016
 * Class: CSCI 1933-12
 */

/**
 * This class generates the main GUI for the program as well as runs the program.
 *
 * @author Mike Plucker, Billy Lam, Xavier Porter
 * Class: CSCI 2001-51
 * Due Date: 04/30/14
 *
 * Version: 1.00
 *
 */

public class Librarian extends javax.swing.JFrame {

    private AudioVisualMaterial AV = new AudioVisualMaterial(); //create objects

    //create subclass objects
    //create book objects
    Book SelectBook = new Book(); //uses default constructor
    Book TexasHomeownersAssociationLaw = new Book("Gregory S. Cagle", "Texas Homeowners Association Law", new BigDecimal("37.74"), 2013, "Paperback", 2, 822, AV.IMAGES[0]);
    Book MotivationalInterviewing = new Book("William R. Miller and Stephen Rollnick", "Motivational Interviewing", new BigDecimal("51.00"), 2012, "Hardcover", 3, 482, AV.IMAGES[1]);
    Book PsionicPower = new Book("Mike Mearls", "Psionic Power", new BigDecimal("20.79"), 2010, "Hardcover", 4, 160, AV.IMAGES[2]);
    Book GameOfThrones = new Book("George R.R. Martin", "A Game of Thrones", new BigDecimal("19.77"), 1996, "Hardcover", 1, 704, AV.IMAGES[3]);
    Book Divergent = new Book("Veronica Roth", "Divergent", new BigDecimal("10.18"), 2011, "Hardcover", 1, 496, AV.IMAGES[4]);
    Book FaultInOurStars = new Book("John Green", "The Fault in our Stars", new BigDecimal("10.00"), 2012, 1, AV.IMAGES[5]); //uses 1rst Edition constructor
    //Book FaultInOurStars = new Book("John Green", "The Fault in our Stars", new BigDecimal("10.00"), 2012, "Hardcover", 1, 318, AV.IMAGES[5]); //saving this line to keep the book's info

    //create audio objects
    AudioVisualMaterial SelectAudio = new AudioVisualMaterial(); //uses default constructor
    AudioVisualMaterial TheBeatles = new AudioVisualMaterial("The Beatles", "On Air - Live At The BBC Volume 2 ", new BigDecimal("15.07"), 2013, "CD", AV.IMAGES[6], AV.SOUND[0]);
    AudioVisualMaterial Marley = new AudioVisualMaterial("Bob Marley", "Legend: The Best Of Bob Marley And The Wailers", new BigDecimal("11.45"), 2002, "CD", AV.IMAGES[7], AV.SOUND[1]);
    AudioVisualMaterial Sade = new AudioVisualMaterial("Sade", "The Best of Sade", new BigDecimal("9.99"), 2001, "CD", AV.IMAGES[8], AV.SOUND[2]);
    AudioVisualMaterial CharlieBrown = new AudioVisualMaterial("Fantasy", "Charlie Brown Christmas", new BigDecimal("5.99"), 2000, "Audio Cassette", AV.IMAGES[9], AV.SOUND[3]);
    AudioVisualMaterial EarthWindFire = new AudioVisualMaterial("Earth Wind and Fire", "Earth Wind and Fire: Greatest Hits", new BigDecimal("10.00"), 1998, "Audio Cassette", AV.IMAGES[10], AV.SOUND[4]);
    AudioVisualMaterial Rick = new AudioVisualMaterial("Rick Astley", "Whenever You Need Somebody", new BigDecimal("7.95"), 1990, "Audio Cassette", AV.IMAGES[11], AV.SOUND[5]);

    //create video objects
    AudioVisualMaterial SelectVideo = new AudioVisualMaterial(); //uses defualt constructor
    AudioVisualMaterial Frozen = new AudioVisualMaterial("Walt Disney Studios Home Entertainment", "Frozen", new BigDecimal("26.96"), 2013, "DVD", AV.IMAGES[12], AV.SOUND[6]);
    AudioVisualMaterial MonstersUniversity = new AudioVisualMaterial("Walt Disney Studios Home Entertainment","Monster's University", new BigDecimal("15.96"), 2013, "DVD", AV.IMAGES[13], AV.SOUND[7]);
    AudioVisualMaterial ToyStory = new AudioVisualMaterial("Disney Pixar", "Toy Story 3", new BigDecimal("18.27"), 2010, "DVD", AV.IMAGES[14], AV.SOUND[8]);
    AudioVisualMaterial AttackOnTitan = new AudioVisualMaterial("Funimation", "Attack On Titan", new BigDecimal("76.48"), 2014, "Blu-Ray/DVD", AV.IMAGES[15], AV.SOUND[9]);
    AudioVisualMaterial Toradora = new AudioVisualMaterial("NIS America", "Toradora!", new BigDecimal("29.99"), 2010, "DVD", AV.IMAGES[16], AV.SOUND[10]);
    AudioVisualMaterial AdventChildren = new AudioVisualMaterial("Sony Pictures Home Entertainment", "Final Fantasy VII: Advent Children", new BigDecimal("14.98"), 2006, "Blu-Ray", AV.IMAGES[17], AV.SOUND[11]);

    //create object arrays
    LibraryMaterial[] materials = {SelectBook, TexasHomeownersAssociationLaw, MotivationalInterviewing, PsionicPower, GameOfThrones, Divergent, FaultInOurStars,
            SelectVideo, Frozen, MonstersUniversity, ToyStory, AttackOnTitan, SelectAudio, TheBeatles, Marley, Sade, CharlieBrown, EarthWindFire, Rick}; //array of all library materials
    Book[] books = {SelectBook, TexasHomeownersAssociationLaw, MotivationalInterviewing, PsionicPower, GameOfThrones, Divergent, FaultInOurStars}; //array of books
    AudioVisualMaterial[] audio = {SelectAudio, TheBeatles, Marley, Sade, CharlieBrown, EarthWindFire, Rick}; //array of audio materials
    AudioVisualMaterial[] video = {SelectVideo, Frozen, MonstersUniversity, ToyStory, AttackOnTitan, Toradora, AdventChildren}; //array of video materials


    //declare field variables
    private AudioVisualMaterial currentMaterial = SelectAudio; //Initialize to use default sound


    /**
     * Creates new form Librarian
     */
    public Librarian() {
        initComponents();

        //set TextAreas to be uneditable
        bookText.setEditable(false);
        audioText.setEditable(false);
        videoText.setEditable(false);

        setupComboBox(); //setup all comboBoxes

        //add listener to tabs
        jTabbedPane1.addChangeListener(new ChangeListener(){ //create a change listener

            @Override
            public void stateChanged(ChangeEvent e){ //create a method StateChanged
                JTabbedPane jTabbedPane1 = (JTabbedPane)e.getSource(); //Add change Listener to JTabbed Pane

                int tab = jTabbedPane1.getSelectedIndex(); //gets current selected tab and stores into variable tab

                //reset comboBoxes to default title/author when tab is switched
                bookCB.setSelectedItem(SelectBook.getTitle());
                audioCB.setSelectedItem(SelectAudio.getAuthor());
                videoCB.setSelectedItem(SelectVideo.getTitle());

                //enhanced for loop that stops audio soundClips when switched to different tab
                for(AudioVisualMaterial currentAudio : audio){ //iterates through audio array
                    if(tab != 2){ //if audio tab is not selected
                        currentAudio.setupSoundClip();
                        //currentAudio.stopSoundClip(); //stop music
                    }
                }

                //enhanced for loop that stops video soundClips when switched to different tab
                for(AudioVisualMaterial currentVideo : video){ //iterates through video array
                    if(tab != 3){ //if video tab is not selected
                        currentVideo.setupSoundClip();
                        //currentVideo.stopSoundClip(); //stop music
                    }
                }
            }
        });
    }

    //method to set-up all comboBoxes
    private void setupComboBox(){

        //enhanced for loop populates book comboBox with books
        for(Book currentBook : books){ //iterates through books array
            bookCB.addItem(currentBook.getTitle()); //adds book titles to comboBox
        }

        //enhanced for loop populates audio comboBox with audio materials
        for(AudioVisualMaterial currentAudio : audio){ //iterates through audio array
            audioCB.addItem(currentAudio.getAuthor()); //adds audio authors to comboBox
        }

        //enhanced for loop populates video comboBox with video materials
        for(AudioVisualMaterial currentVideo : video){ //iterates through video array
            videoCB.addItem(currentVideo.getTitle()); //adds video titles to comboBox
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        playButton = new javax.swing.JButton();
        stopButton = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        homeTab = new javax.swing.JPanel();
        homePanel = new javax.swing.JPanel();
        libraryName = new javax.swing.JLabel();
        libraryInfo = new javax.swing.JLabel();
        createdBy = new javax.swing.JLabel();
        turtlebeach = new javax.swing.JLabel();
        homeBackground = new javax.swing.JLabel();
        bookTab = new javax.swing.JPanel();
        bookPanel = new javax.swing.JPanel();
        bookCB = new javax.swing.JComboBox();
        bookImage = new javax.swing.JLabel();
        bookInfo = new javax.swing.JScrollPane();
        bookText = new javax.swing.JTextArea();
        bookBackgound = new javax.swing.JLabel();
        audioTab = new javax.swing.JPanel();
        audioPanel = new javax.swing.JPanel();
        audioCB = new javax.swing.JComboBox();
        audioImage = new javax.swing.JLabel();
        audioInfo = new javax.swing.JScrollPane();
        audioText = new javax.swing.JTextArea();
        audioBackground = new javax.swing.JLabel();
        videoTab = new javax.swing.JPanel();
        videoPanel = new javax.swing.JPanel();
        videoCB = new javax.swing.JComboBox();
        videoImage = new javax.swing.JLabel();
        videoInfo = new javax.swing.JScrollPane();
        videoText = new javax.swing.JTextArea();
        videoBackground = new javax.swing.JLabel();
        topBookBackground = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Library OOM");
        setMinimumSize(new java.awt.Dimension(1080, 730));
        getContentPane().setLayout(null);

        playButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Library/Images/PlayButton.jpg"))); // NOI18N
        playButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                playButtonActionPerformed(evt);
            }
        });
        getContentPane().add(playButton);
        playButton.setBounds(658, 8, 180, 45);

        stopButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Library/Images/StopButton.jpg"))); // NOI18N
        stopButton.setPreferredSize(new java.awt.Dimension(180, 45));
        stopButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stopButtonActionPerformed(evt);
            }
        });
        getContentPane().add(stopButton);
        stopButton.setBounds(858, 8, 180, 45);

        jTabbedPane1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTabbedPane1.setFocusable(false);
        jTabbedPane1.setFont(new java.awt.Font("Serif", 1, 24)); // NOI18N

        homeTab.setLayout(null);

        homePanel.setLayout(null);

        libraryName.setFont(new java.awt.Font("Serif", 1, 56)); // NOI18N
        libraryName.setForeground(new java.awt.Color(102, 255, 102));
        libraryName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        libraryName.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Library/Images/Welcome.png"))); // NOI18N
        homePanel.add(libraryName);
        libraryName.setBounds(106, 2, 470, 278);

        libraryInfo.setFont(new java.awt.Font("Serif", 1, 48)); // NOI18N
        libraryInfo.setForeground(new java.awt.Color(255, 255, 153));
        libraryInfo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Library/Images/Info.png"))); // NOI18N
        homePanel.add(libraryInfo);
        libraryInfo.setBounds(462, 168, 384, 288);

        createdBy.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Library/Images/Creators.png"))); // NOI18N
        homePanel.add(createdBy);
        createdBy.setBounds(-18, 456, 428, 176);

        turtlebeach.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Library/Images/TurtleBeach.png"))); // NOI18N
        homePanel.add(turtlebeach);
        turtlebeach.setBounds(710, 294, 412, 386);

        homeBackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Library/Images/BookshelfHome.jpg"))); // NOI18N
        homeBackground.setText("jLabel1");
        homePanel.add(homeBackground);
        homeBackground.setBounds(-4, 2, 1094, 666);

        homeTab.add(homePanel);
        homePanel.setBounds(2, -2, 1084, 644);

        jTabbedPane1.addTab("   Home   ", homeTab);

        bookTab.setLayout(null);

        bookPanel.setLayout(null);

        bookCB.setFont(new java.awt.Font("Serif", 1, 14)); // NOI18N
        bookCB.setMaximumRowCount(7);
        bookCB.setToolTipText("");
        bookCB.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                bookCBItemStateChanged(evt);
            }
        });
        bookPanel.add(bookCB);
        bookCB.setBounds(36, 42, 260, 40);

        bookImage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        bookPanel.add(bookImage);
        bookImage.setBounds(344, 34, 330, 490);

        bookText.setColumns(20);
        bookText.setFont(new java.awt.Font("Serif", 1, 14)); // NOI18N
        bookText.setRows(5);
        bookInfo.setViewportView(bookText);

        bookPanel.add(bookInfo);
        bookInfo.setBounds(726, 190, 320, 170);

        bookBackgound.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Library/Images/Bookshelf1.jpg"))); // NOI18N
        bookPanel.add(bookBackgound);
        bookBackgound.setBounds(0, -2, 1092, 688);

        bookTab.add(bookPanel);
        bookPanel.setBounds(2, 2, 1088, 678);

        jTabbedPane1.addTab("   Books   ", bookTab);

        audioTab.setLayout(null);

        audioPanel.setLayout(null);

        audioCB.setFont(new java.awt.Font("Serif", 1, 14)); // NOI18N
        audioCB.setMaximumRowCount(7);
        audioCB.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                audioCBItemStateChanged(evt);
            }
        });
        audioPanel.add(audioCB);
        audioCB.setBounds(38, 64, 190, 40);
        audioPanel.add(audioImage);
        audioImage.setBounds(244, 52, 420, 490);

        audioText.setColumns(20);
        audioText.setFont(new java.awt.Font("Serif", 1, 14)); // NOI18N
        audioText.setRows(5);
        audioInfo.setViewportView(audioText);

        audioPanel.add(audioInfo);
        audioInfo.setBounds(674, 228, 368, 134);

        audioBackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Library/Images/Bookshelf4.jpg"))); // NOI18N
        audioPanel.add(audioBackground);
        audioBackground.setBounds(2, 0, 1092, 668);

        audioTab.add(audioPanel);
        audioPanel.setBounds(0, 0, 1094, 658);

        jTabbedPane1.addTab("    Audio    ", audioTab);

        videoTab.setLayout(null);

        videoPanel.setLayout(null);

        videoCB.setFont(new java.awt.Font("Serif", 1, 14)); // NOI18N
        videoCB.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                videoCBItemStateChanged(evt);
            }
        });
        videoPanel.add(videoCB);
        videoCB.setBounds(34, 56, 234, 40);
        videoPanel.add(videoImage);
        videoImage.setBounds(300, 68, 360, 500);

        videoText.setColumns(20);
        videoText.setFont(new java.awt.Font("Serif", 1, 14)); // NOI18N
        videoText.setRows(5);
        videoInfo.setViewportView(videoText);

        videoPanel.add(videoInfo);
        videoInfo.setBounds(698, 252, 350, 132);

        videoBackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Library/Images/Bookshelf3.jpg"))); // NOI18N
        videoPanel.add(videoBackground);
        videoBackground.setBounds(0, 0, 1088, 666);

        videoTab.add(videoPanel);
        videoPanel.setBounds(0, -2, 1092, 664);

        jTabbedPane1.addTab("   Video   ", videoTab);

        getContentPane().add(jTabbedPane1);
        jTabbedPane1.setBounds(-4, 22, 1354, 692);

        topBookBackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Library/Images/PileOfBooks2.jpg"))); // NOI18N
        getContentPane().add(topBookBackground);
        topBookBackground.setBounds(-2, -120, 1080, 200);

        pack();
    }// </editor-fold>

    private void bookCBItemStateChanged(java.awt.event.ItemEvent evt) {

        //enhanced for loop checks if any book is selected in comboBox
        for(Book currentBook : books){ //iterates through books array
            if(bookCB.getSelectedItem() == currentBook.getTitle()){ //if comboBox selection matches a book's title
                bookText.setText(currentBook.displayInfo()); //display that book's info in TextArea
                bookImage.setIcon(currentBook.getCoverImage()); //display that book's image
            }
            if(bookCB.getSelectedItem() == SelectBook.getTitle()){ //if comboBox selection matches default title
                bookText.setText(""); //clear text
            }
        }
    }

    private void audioCBItemStateChanged(java.awt.event.ItemEvent evt) {

        //enhanced for loop checks if any audio material is selected in comboBox
        for(AudioVisualMaterial currentAudio : audio){ //iterates through audio array
            currentMaterial = currentAudio; //passes local variable into class variable
            if(audioCB.getSelectedItem() == currentMaterial.getAuthor()){ //if comboBox selection matches an audio material's author
                audioText.setText(currentMaterial.displayInfo()); //display that audio's info in TextArea
                audioImage.setIcon(currentMaterial.getCoverImage()); //display that audio's image
                currentMaterial.setupSoundClip(); //set up sound clip
                currentMaterial.playSoundClip(); //play that audio's soundClip
            }
            if(audioCB.getSelectedItem() != currentMaterial.getAuthor()){ //if comboBox selection does not match an audio material's author
                currentMaterial.setupSoundClip(); //set up sound clip
                //currentMaterial.stopSoundClip(); //stop sound clip
            }
            if(audioCB.getSelectedItem() == SelectAudio.getAuthor()){ //if comboBox selection matches default author
                audioText.setText(""); //clear text
            }
        }
    }

    private void videoCBItemStateChanged(java.awt.event.ItemEvent evt) {

        //enhanced for loop checks if any video material is selected in comboBox
        for(AudioVisualMaterial currentVideo : video){ //iterates through video array
            currentMaterial = currentVideo; //passes local variable into class variable
            if(videoCB.getSelectedItem() == currentMaterial.getTitle()){ //if comboBox selection matches a video's title
                videoText.setText(currentMaterial.displayInfo()); //display that video's info in TextArea
                videoImage.setIcon(currentMaterial.getCoverImage()); //display that video's image
                currentMaterial.setupSoundClip(); //set up sound clip
                currentMaterial.playSoundClip(); //play that video's soundClip
            }
            if(videoCB.getSelectedItem() != currentMaterial.getTitle()){ //if combobox selection does not match a video's title
                currentMaterial.setupSoundClip(); //set up sound clip
                //currentMaterial.stopSoundClip(); //stop sound clip
            }
            if(videoCB.getSelectedItem() == SelectVideo.getTitle()){ //if combobox selection matches default title
                videoText.setText(""); //clear text
            }
        }
    }

    private void stopButtonActionPerformed(java.awt.event.ActionEvent evt) {

        //enhanced for loop stops any audio soundClip playing
        for(AudioVisualMaterial currentAudio : audio){ //iterates through audio array
            currentAudio.setupSoundClip(); //sets up sound clip
            //currentAudio.stopSoundClip(); //stops audio sound clip
        }

        //enhanced for loop stops any video soundClip playing
        for(AudioVisualMaterial currentVideo : video){ //iterates through video array
            currentVideo.setupSoundClip(); //sets up sound clip
            //currentVideo.stopSoundClip(); //stops video sound clip
        }
    }

    private void playButtonActionPerformed(java.awt.event.ActionEvent evt) {

        //enhanced for loop that plays an audio soundClip if selected when play button is pressed
        for(AudioVisualMaterial currentAudio : audio){ //iterates through audio array
            currentMaterial = currentAudio; //passes local variable into class variable
            if(audioCB.getSelectedItem() == currentMaterial.getAuthor()){ //if comboBox selection matches an audio material's author
                currentMaterial.setupSoundClip();
                currentMaterial.playSoundClip(); //play audio sound clip
            }
        }

        //enhanced for loop that plays a video soundClip if selected when play button is pressed
        for(AudioVisualMaterial currentVideo : video){ //iterates through video array
            currentMaterial = currentVideo; //passes local variable into class variable
            if(videoCB.getSelectedItem() == currentMaterial.getTitle()){ //if comboBox selection matches a video's title
                currentMaterial.setupSoundClip();
                currentMaterial.playSoundClip(); //play video sound clip
            }
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Librarian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Librarian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Librarian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Librarian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Librarian().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify
    private javax.swing.JLabel audioBackground;
    private javax.swing.JComboBox audioCB;
    private javax.swing.JLabel audioImage;
    private javax.swing.JScrollPane audioInfo;
    private javax.swing.JPanel audioPanel;
    private javax.swing.JPanel audioTab;
    private javax.swing.JTextArea audioText;
    private javax.swing.JLabel bookBackgound;
    private javax.swing.JComboBox bookCB;
    private javax.swing.JLabel bookImage;
    private javax.swing.JScrollPane bookInfo;
    private javax.swing.JPanel bookPanel;
    private javax.swing.JPanel bookTab;
    private javax.swing.JTextArea bookText;
    private javax.swing.JLabel createdBy;
    private javax.swing.JLabel homeBackground;
    private javax.swing.JPanel homePanel;
    private javax.swing.JPanel homeTab;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel libraryInfo;
    private javax.swing.JLabel libraryName;
    private javax.swing.JButton playButton;
    private javax.swing.JButton stopButton;
    private javax.swing.JLabel topBookBackground;
    private javax.swing.JLabel turtlebeach;
    private javax.swing.JLabel videoBackground;
    private javax.swing.JComboBox videoCB;
    private javax.swing.JLabel videoImage;
    private javax.swing.JScrollPane videoInfo;
    private javax.swing.JPanel videoPanel;
    private javax.swing.JPanel videoTab;
    private javax.swing.JTextArea videoText;
    // End of variables declaration
}
