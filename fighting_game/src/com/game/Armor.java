package com.game;

public class Armor {
	private String sType;
	private Integer nDef;
	private Integer nSpdPlt;
	public String getsType() {
		return sType;
	}
	public void setsType(String sType) {
		this.sType = sType;
	}
	public Integer getnDef() {
		return nDef;
	}
	public void setnDef(Integer nDef) {
		this.nDef = nDef;
	}
	public Integer getnSpdPlt() {
		return nSpdPlt;
	}
	public void setnSpdPlt(Integer nSpdPlt) {
		this.nSpdPlt = nSpdPlt;
	}
	public Armor(String sType,Integer nDef,Integer nSpdPlt) {
		this.sType = sType;
		this.nDef = nDef;
		this.nSpdPlt = nSpdPlt;
	}
	/**
	 * @uml.property  name="character"
	 * @uml.associationEnd  inverse="armor:com.game.Character"
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
