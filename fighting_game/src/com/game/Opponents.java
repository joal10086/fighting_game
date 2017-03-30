package com.game;


public class Opponents extends OpponentP{
	
	

	public Opponents(int index) {
		if (index==0){
			this.createOpponent("Thief",150,20,10,40,"000");
		}else if (index == 1){
			this.createOpponent("Viking",250,30,20,30,"010");
		}else if (index ==2){
			this.createOpponent("Minotaur",350,40,30,20,"020");
		}
		
	}
	
	@Override
	public String think() {
		String action = this.getsAI().substring(0, 1);
		this.setsAI(this.getsAI().substring(1, 3)+action);
		System.out.println(this.getsAI());
		return action;
	}
	
	
	/** 
	 * @uml.property name="app"
	 * @uml.associationEnd inverse="o:com.game.ApplicationWindow"
	 */
	private ApplicationWindow applicationWindow;
	/**
	 * Getter of the property <tt>app</tt>
	 * @return  Returns the applicationWindow.
	 * @uml.property  name="app"
	 */
	public ApplicationWindow getApp() {
		return applicationWindow;
	}

	/**
	 * Setter of the property <tt>app</tt>
	 * @param app  The applicationWindow to set.
	 * @uml.property  name="app"
	 */
	public void setApp(ApplicationWindow app) {
		applicationWindow = app;
	}
	/**
	 * @uml.property  name="envt"
	 * @uml.associationEnd  inverse="opponents:com.game.Envt"
	 */
	private Envt envt;
	/**
	 * Getter of the property <tt>envt</tt>
	 * @return  Returns the envt.
	 * @uml.property  name="envt"
	 */
	public Envt getEnvt() {
		return envt;
	}

	/**
	 * Setter of the property <tt>envt</tt>
	 * @param envt  The envt to set.
	 * @uml.property  name="envt"
	 */
	public void setEnvt(Envt envt) {
		this.envt = envt;
	}
	/** 
	 * @uml.property name="character"
	 * @uml.associationEnd inverse="opponents:com.game.Character"
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

	
	


}
