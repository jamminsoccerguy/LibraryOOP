package library;

//import classes
import java.io.*;
import javax.sound.sampled.*;
import java.net.URL;
import javax.swing.ImageIcon;
import java.math.*;

/**
 * Created by Mike Plucker
 * Date: 3/8/2016
 * Class: CSCI 1933-12
 */

/**
 * This class is a sub-class of LibraryMaterial.
 *
 * @author Xavier Porter
 * Class: CSCI 2001-51
 * Due Date: 04/30/14
 *
 * Version: 1.00
 *
 */

/**AudioVisualMaterial class extends LibraryMaterial */
/** Concept #3 Inheritance */
public class AudioVisualMaterial extends LibraryMaterial {

    /** Concept #1 Encapsulation/Data Hiding*/
    //Declare field variables as private
    private String audioType;
    private ImageIcon coverImage;
    private URL soundClip;
    private Clip clip;

    //create audio sound clips
    private final URL BEATLESCLIP = this.getClass().getResource("Sound/Beatles.wav");
    private final URL BOBCLIP = this.getClass().getResource("Sound/Bob.wav");
    private final URL SADECLIP = this.getClass().getResource("Sound/SadeClip.wav");
    private final URL CHARLIECLIP = this.getClass().getResource("Sound/charlie.wav");
    private final URL EARTHCLIP = this.getClass().getResource("Sound/earthwind.wav");
    private final URL RICKCLIP = this.getClass().getResource("Sound/rickAstley.wav");

    //create video sound clips
    private final URL FROZENCLIP = this.getClass().getResource("Sound/Let it Go - Frozen.wav");
    private final URL MONSTERClIP = this.getClass().getResource("Sound/MonstersUniversity.wav");
    private final URL TOYCLIP = this.getClass().getResource("Sound/Friend in Me.wav");
    private final URL ATTACKCLIP = this.getClass().getResource("Sound/AttackOnTitan.wav");
    private final URL TORADORACLIP = this.getClass().getResource("Sound/Toradora.wav");
    private final URL ADVENTCLIP = this.getClass().getResource("Sound/AdventChildren.wav");

    //create default sound clip
    private final URL BLANK = this.getClass().getResource("Sound/Blank.wav");

    //create soundClip array
    final URL[] SOUND = {BEATLESCLIP, BOBCLIP, SADECLIP, CHARLIECLIP, EARTHCLIP, RICKCLIP, FROZENCLIP, MONSTERClIP, TOYCLIP, ATTACKCLIP, TORADORACLIP, ADVENTCLIP, BLANK,};

    //create book image files
    private final ImageIcon TEXASIMG = new ImageIcon(getClass().getResource("images/TexasHomeownersAssociationLaw2.jpg"));
    private final ImageIcon MOTIVATIONIMG = new ImageIcon(getClass().getResource("images/MotivationalInterviewing2.jpg"));
    private final ImageIcon PSIONICIMG = new ImageIcon(getClass().getResource("images/PsionicPower2.jpg"));
    private final ImageIcon GAMEIMG = new ImageIcon(getClass().getResource("images/AGameOfThrones2.jpg"));
    private final ImageIcon DIVERGENTIMG = new ImageIcon(getClass().getResource("images/Divergent2.jpg"));
    private final ImageIcon FAULTIMG = new ImageIcon(getClass().getResource("images/TheFaultInOurStars2.jpg"));

    //create audio image files
    private final ImageIcon BEATLESIMG = new ImageIcon(getClass().getResource("images/beatlesImg2.jpg"));
    private final ImageIcon BOBIMG = new ImageIcon(getClass().getResource("images/marleyImg2.jpg"));
    private final ImageIcon SADEIMG = new ImageIcon(getClass().getResource("images/sadeImg2.jpg"));
    private final ImageIcon CHARLIEIMG = new ImageIcon(getClass().getResource("images/charlieImg2.jpg"));
    private final ImageIcon EARTHIMG = new ImageIcon(getClass().getResource("images/earthImg2.jpg"));
    private final ImageIcon RICKIMG = new ImageIcon(getClass().getResource("images/rickAstleyImg2.jpg"));

    //create video image files
    private final ImageIcon FROZENIMG = new ImageIcon(getClass().getResource("images/frozenImg2.jpg"));
    private final ImageIcon MONSTERIMG = new ImageIcon(getClass().getResource("images/monsterImg.jpg"));
    private final ImageIcon TOYIMG = new ImageIcon(getClass().getResource("images/toyStoryImg.jpg"));
    private final ImageIcon ATTACKIMG = new ImageIcon(getClass().getResource("images/AttackOnTitan.jpg"));
    private final ImageIcon TORADORAIMG = new ImageIcon(getClass().getResource("images/Toradora.jpg"));
    private final ImageIcon ADVENTIMG = new ImageIcon(getClass().getResource("images/AdventChildren.jpg"));

    //create images array
    final ImageIcon[] IMAGES = {TEXASIMG, MOTIVATIONIMG, PSIONICIMG, GAMEIMG, DIVERGENTIMG, FAULTIMG, BEATLESIMG, BOBIMG, SADEIMG, CHARLIEIMG,
            EARTHIMG, RICKIMG, FROZENIMG, MONSTERIMG, TOYIMG, ATTACKIMG, TORADORAIMG, ADVENTIMG};


    /** Concept #2 Default Constructor */
    // no argument constructor acts as a default
    public AudioVisualMaterial(){
        this("Select an Artist", "Select a Movie", new BigDecimal("0.00"), 0, "Unknown", null, null); //sets default values
        soundClip = SOUND[12]; //set the soundClip to the default "blank" sound
    }

    /** Concept #7 Method overloading
     * @param author
     * @param audioType
     * @param price
     * @param pubYear
     * @param title
     * @param coverImage
     * @param soundClip
     *  constructor to initialize all field variables (including super class field variables)
     */
    public AudioVisualMaterial(String author, String title, BigDecimal price, int pubYear, String audioType, ImageIcon coverImage, URL soundClip) {

        /** Concept #5 super reference */
        //Initialize variables
        super(author, title, price, pubYear); //pass to LibraryMaterial constructor
        this.audioType = audioType;
        this.coverImage = coverImage;
        this.soundClip = soundClip;
    }

    /**
     * get AudioType
     * @return audioType
     */
    public String getAudioType() {
        return audioType;
    }

    /**
     * set AudioType
     * @param audioType
     */
    public void setAudioType(String audioType) {
        this.audioType = audioType;
    }

    /**
     * get coverImage
     * @return coverImage
     */
    public ImageIcon getCoverImage() {
        return coverImage;
    }

    /**
     * set coverImage
     * @param coverImage
     */
    public void setCoverImage(ImageIcon coverImage) {
        this.coverImage = coverImage;
    }

    /**
     * get soundClip
     * @return soundClip
     */
    public URL getSoundClip() {
        return soundClip;
    }

    /**
     *  set soundClip
     * @param soundClip
     */
    public void setSoundClip(URL soundClip) {
        this.soundClip = soundClip;
    }

    /**
     * Method to setup sound clip
     */
    public void setupSoundClip(){
        if(clip != null && clip.isRunning()){ //if the player is still running
            //System.out.println("Stopping audio"); //test print
            clip.stop(); //stop sound
            clip.close();//close the sound file
            //clip.flush();
        }
        try{
            AudioInputStream audio = AudioSystem.getAudioInputStream(soundClip); //open an audio input stream
            clip = AudioSystem.getClip(); //get a sound clip resource
            clip.open(audio); //open audio clip and load samples from the audio input stream
        }catch(  UnsupportedAudioFileException | IOException | LineUnavailableException uae){
            System.out.println(uae);
        }
    }

    /**
     * Method to play sound clip
     */
    public void playSoundClip(){
//        if(clip != null && clip.isRunning()){ //if the player is still running
//            System.out.println("Stop audio"); //test print
//            clip.stop(); //stop sound
//            clip.close(); //close the sound file //wasnt doing anything
//        }
        //clip.setFramePosition(0); //rewind soundClip to the beginning //wasnt doing anything
        clip.start(); //start playing soundClip
    }

    /**
     * Method to stop sound clip
     */
    public void stopSoundClip(){
//        if(clip != null && clip.isRunning()){ //if the player is still running
//            System.out.println("Stopped the audio"); //test print
//            clip.stop(); //stop sound
//            clip.close(); //close the sound file //wasnt doing anything
//        }
    }

    /** Concept #6 Method Overriding
     * @return toString
     * overrides abstract method displayInfo in LibraryMaterial parent class
     */
    @Override
    public String displayInfo(){
        return String.format("%s\nAudioType: %s\n", super.toString(), getAudioType()); //display audio or video material's info
    }
}
