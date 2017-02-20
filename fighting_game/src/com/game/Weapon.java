package com.game;

public class Weapon {
	private String sType;
	private Integer nAtk;
	private Integer nSpdPlt;
	public String getsType() {
		return sType;
	}
	public void setsType(String sType) {
		this.sType = sType;
	}
	public Integer getnAtk() {
		return nAtk;
	}
	public void setnAtk(Integer nAtk) {
		this.nAtk = nAtk;
	}
	public Integer getnSpdPlt() {
		return nSpdPlt;
	}
	public void setnSpdPlt(Integer nSpdPlt) {
		this.nSpdPlt = nSpdPlt;
	}
	public Weapon(String sType,Integer nAtk,Integer nSpdPlt) {
		this.sType = sType;
		this.nAtk = nAtk;
		this.nSpdPlt = nSpdPlt;
	}
	/** 
	 * @uml.property name="character"
	 * @uml.associationEnd inverse="weapon:com.game.Character"
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
