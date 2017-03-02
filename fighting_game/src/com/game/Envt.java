package com.game;

import java.util.ArrayList;

public class Envt {
	private String sName;
	private int cPenalty;
	private int oPenalty;
	private ArrayList<Envt> EnvtList= new ArrayList<Envt>();
	
	public Envt(int index) {
		EnvtList.clear();
		EnvtList.add(new Envt("Arena",0,0));
		EnvtList.add(new Envt("Swamp",-1,1));
		EnvtList.add(new Envt("Colosseum",1,-1));
		
		this.sName=EnvtList.get(index).sName;
		this.cPenalty=EnvtList.get(index).cPenalty;
		this.oPenalty=EnvtList.get(index).oPenalty;
	}
	public Envt(String n,int x, int y){
			this.sName=n;
			this.cPenalty=x;
			this.oPenalty=y;
	}
	
	public String getsName() {
		return sName;
	}
	public int getcPenalty() {
		return cPenalty;
	}
	public int getoPenalty() {
		return oPenalty;
	}
	public ArrayList<Envt> getEnvtList() {
		return EnvtList;
	}
	/**
	 * @uml.property  name="character"
	 * @uml.associationEnd  aggregation="shared" inverse="envt:com.game.Character"
	 */
	private Character character;

	/**
	 * Getter of the property <tt>character</tt>
	 * @return  Returns the character.
	 * @uml.property  name="character"
	 */
	public Character getCharacter() {
		return character;
	}
	/**
	 * Setter of the property <tt>character</tt>
	 * @param character  The character to set.
	 * @uml.property  name="character"
	 */
	public void setCharacter(Character character) {
		this.character = character;
	}
	/**
	 * @uml.property  name="opponents"
	 * @uml.associationEnd  aggregation="shared" inverse="envt:com.game.Opponents"
	 */
	private Opponents opponents;

	/**
	 * Getter of the property <tt>opponents</tt>
	 * @return  Returns the opponents.
	 * @uml.property  name="opponents"
	 */
	public Opponents getOpponents() {
		return opponents;
	}
	/**
	 * Setter of the property <tt>opponents</tt>
	 * @param opponents  The opponents to set.
	 * @uml.property  name="opponents"
	 */
	public void setOpponents(Opponents opponents) {
		this.opponents = opponents;
	}
	/** 
	 * @uml.property name="applicationWindow"
	 * @uml.associationEnd inverse="envt1:com.game.ApplicationWindow"
	 */
	private ApplicationWindow applicationWindow;

	/** 
	 * Getter of the property <tt>applicationWindow</tt>
	 * @return  Returns the applicationWindow.
	 * @uml.property  name="applicationWindow"
	 */
	public ApplicationWindow getApplicationWindow() {
		return applicationWindow;
	}
	/** 
	 * Setter of the property <tt>applicationWindow</tt>
	 * @param applicationWindow  The applicationWindow to set.
	 * @uml.property  name="applicationWindow"
	 */
	public void setApplicationWindow(ApplicationWindow applicationWindow) {
		this.applicationWindow = applicationWindow;
	}

}
