package gr.scify.icsee.sounds;

import android.content.Context;
import android.media.AudioManager;
import android.media.SoundPool;
import java.util.HashMap;
import gr.scify.icsee.R;

/**
 * How to add new sounds:
 * 1. Add a new public static final int variable for the sound in the beginning of the class
 * 2. Add it to the hashmap in initSounds()
 * 3. ???
 * 4. PROFIT!
 */
public class SoundPlayer {
    // Static sound variables (STEP 1)
    public static final int S1 = R.raw.alienxxxbeep;
    public static final int S2 = R.raw.greencouchbeeps;
    public static final int S3 = R.raw.keykrushermicrowavebeep;
    public static final int S4 = R.raw.kodackbeepbeep;
    public static final int S5 = R.raw.emptybellbeep;
    public static final int S6 = R.raw.pan14tonebeep;
    public static final int Stutorial = R.raw.tutorial;


    private static SoundPool sp;                    // SoundPool to play the sounds
    private static HashMap<Integer, Integer> spMap; // Keeps the ID of each sound
    private static float volume = 1f;

    public static void initSounds(Context context) {
        // Init soundpool
        sp = new SoundPool(2, AudioManager.STREAM_MUSIC, 0);

        // Init hashmap (STEP 2)
        spMap = new HashMap<Integer, Integer>();
        spMap.put(S1, sp.load(context, S1, 1));
        spMap.put(S2, sp.load(context, S2, 1));
        spMap.put(S3, sp.load(context, S3, 1));
        spMap.put(S4, sp.load(context, S4, 1));
        spMap.put(S5, sp.load(context, S5, 1));
        spMap.put(S6, sp.load(context, S6, 1));
        spMap.put(Stutorial, sp.load(context, Stutorial, 1));
    }

    public static void playSound(Context context, int soundID) {
        if (sp == null || spMap == null) {
            initSounds(context);
        }
        if(soundID == SoundPlayer.Stutorial) {


        } else {
            sp.play(spMap.get(soundID), volume, volume, 1, 0, 1f);
        }

    }
}
