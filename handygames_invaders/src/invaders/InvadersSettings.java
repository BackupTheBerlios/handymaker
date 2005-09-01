/*
 * Created on 10.08.2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package invaders;

import gamemachine.ResourceLoader;

/**
 * @author Star
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class InvadersSettings {

	public static final int INVADERWIDTH = 14;
	public static final int INVADERHEIGHT = 14;
	
	public static final int TANKWIDTH = 23;
	public static final int TANKHEIGHT = 12;
	
	public static final int S_INVADERSOUNDSET_A = 0;
	public static final int S_INVADERSHOOT_A = 0;
	public static final int S_INVADEREXPL_A = 1;
	public static final int S_INVADERMOVE_A = 2;
	
	public static final int S_INVADERSOUNDSET_B = 1;
	public static final int S_INVADERSHOOT_B = 0;
	public static final int S_INVADEREXPL_B = 1;
	public static final int S_INVADERMOVE_B = 2;
	
	public static final int S_TANKSOUNDSET = 2;
	public static final int S_TANKSHOOT = 0;
	public static final int S_TANKEXPL = 1;
	public static final int S_TANKMOVE = 2;
	
	

	public static String DESC_INVADER_A [][]= {{"inv_fire.wav"},{"inv_explosion.wav"},{"inv_move.wav"}};
	public static String DESC_INVADER_B [][]= {{"inv_fire.wav"},{"inv_explosion.wav"},{"inv_move.wav"}};
	public static String DESC_TANK [][]= {{"tan_fire.wav"},{"tan_explosion.wav"},{"tan_move"}};
	
	
	public static Object [][] DESC_SOUNDSET_L1tmp = {{new Integer(S_INVADERSOUNDSET_A),DESC_INVADER_A},{new Integer(S_TANKSOUNDSET),DESC_TANK}};
	public static Object [][] DESC_SOUNDSET_L2tmp = {{new Integer(S_INVADERSOUNDSET_B),DESC_INVADER_B},{new Integer(S_TANKSOUNDSET),DESC_TANK}};
	public static Object [][] DESC_SOUNDSET_L3tmp = {{new Integer(S_INVADERSOUNDSET_A),DESC_INVADER_A},{new Integer(S_INVADERSOUNDSET_B),DESC_INVADER_B},{new Integer(S_TANKSOUNDSET),DESC_TANK}};
	public static Object [] DESC_SOUNDSET_L1 = {DESC_INVADER_A,null,DESC_TANK};
	public static Object [] DESC_SOUNDSET_L2 = {null,DESC_INVADER_B,DESC_TANK};
	public static Object [] DESC_SOUNDSET_L3 = {DESC_INVADER_A,DESC_INVADER_B,DESC_TANK};
	

	
	public static final int I_INVADER_A_IMAGESET = 0;
	public static final int I_INVADER_A_EXPL = 0;
	public static final int I_INVADER_A_MOVE = 1;

	public static final int I_INVADER_B_IMAGESET = 1;
	public static final int I_INVADER_B_EXPL = 0;
	public static final int I_INVADER_B_MOVE = 1;

	public static final int I_TANKIMAGESET = 2;
	public static final int I_TANKEXPL = 0;
	public static final int I_TANKMOVE = 1;
	
	
	public static final int I_STARTSCREENIMAGESET = 3;
	public static final int I_START = 0;
	public static final int I_HIGHSCORE = 1;
	public static final int I_QUIT = 2;

	public static final String DESC_BACKGROUND = "3.PNG";
	
	public static String DESC_INVADER_STARTSCREEN_OPTIONS []= {"start.PNG","highscore.PNG","quit.PNG"};	

	/** F�r den Invadertyp A */
	public static String DESC_INVADER_A_IMAGESET  [][] = {{"1.PNG","2.PNG","3.PNG","4.PNG","5.PNG","6.PNG"},{"inv_move1.png","inv_move2.png"}};

	/** F�r den Invadertyp B */
	public static String DESC_INVADER_B_IMAGESET  [][] = {{"inv_expl1.png","inv_expl2.png"},{"inv_move1.png","inv_move2.png"}};
	/** Der Tank*/
	public static String DESC_TANKIMAGESET [][] = {{"tan_expl1.png","tan_expl2.png"},{"tan_move1.png","tan_move2.png"}};

	/**
	 * Imagesets f�r level 1
	 */
	public static Object [][] IMAGESETS_L1  = {{new Integer(I_INVADER_A_IMAGESET),DESC_INVADER_A_IMAGESET},{new Integer(I_TANKIMAGESET),DESC_TANKIMAGESET}};
	
	/**
	 * Imagesets f�r level 2
	 */
	public static Object [][] IMAGESETS_L2  = {{new Integer(I_INVADER_B_IMAGESET),DESC_INVADER_B_IMAGESET},{new Integer(I_TANKIMAGESET),DESC_TANKIMAGESET}};
	
	/**
	 * Imagesets f�r level 3
	 */
	public static Object [][] IMAGESETS_L3  = {{new Integer(I_INVADER_A_IMAGESET),DESC_INVADER_A_IMAGESET},{new Integer(I_INVADER_B_IMAGESET),DESC_INVADER_B_IMAGESET},{new Integer(I_TANKIMAGESET),DESC_TANKIMAGESET}};
	
	
	public static int START = 0;
	public static int HIGHSCORE = 1;
	public static int QUIT = 2;
	public static String OPTIONS [] = {"Start","Highscore","Quit"};
	public static String background = ResourceLoader.IMAGEROOT+"3.PNG";
	
	
}