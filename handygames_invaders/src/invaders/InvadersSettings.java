/*
 * Created on 10.08.2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package invaders;

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
	public static final int S_TANKMOVE = 0;
	public static final int S_TANKSHOOT = 1;
	public static final int S_TANKEXPL = 2;

	public static String DESC_INVADER_A [] = {"inv_move.wav","inv_fire.wav","inv_explosion.wav"};
	public static String DESC_INVADER_B [] = {"inv_move.wav","inv_fire.wav","inv_explosion.wav"};
	public static String DESC_TANK [] = {"tan_move","tan_fire.wav","tan_explosion.wav"};
	
	
//	public static Object [][] DESC_SOUNDSET_L1tmp = {{new Integer(S_INVADERSOUNDSET_A),DESC_INVADER_A},{new Integer(S_TANKSOUNDSET),DESC_TANK}};
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
	

	/** Für den Invadertyp A */
	public static String DESC_INVADER_A_IMAGESET  [][] = {{"inv_expl1.png","inv_expl2.png","inv_expl3.png"},{"inv_move1.png","inv_move2.png"}};

	/** Für den Invadertyp B */
	public static String DESC_INVADER_B_IMAGESET  [][] = {{"inv_expl1.png","inv_expl2.png"},{"inv_move1.png","inv_move2.png"}};
	/** Der Tank*/
	public static String DESC_TANKIMAGESET [][] = {{"tan_expl1.png","tan_expl2.png"},{"tan_move1.png","tan_move2.png"}};
	
	/**
	 * Imagesets für level 1
	 */
	public static Object [] IMAGESETS_L1  = {DESC_INVADER_A_IMAGESET,null,DESC_TANKIMAGESET};
	
	/**
	 * Imagesets für level 2
	 */
	public static Object [] IMAGESETS_L2  = {null,DESC_INVADER_B_IMAGESET,DESC_TANKIMAGESET};
	
	/**
	 * Imagesets für level 3
	 */
	public static Object [] IMAGESETS_L3  = {DESC_INVADER_A_IMAGESET,DESC_INVADER_B_IMAGESET,DESC_TANKIMAGESET};
	
	
}