package com.game;

import java.util.ArrayList;

public class Character {
	private Integer HP;
	private Integer Atk=1;
	private Integer Def=1;
	private Integer Spd=50;
	
	private ArrayList<Armor> ArmorList = new ArrayList<Armor>();
	private ArrayList<Weapon> WeaponList = new ArrayList<Weapon>();
	
	public ArrayList<Armor> getArmorList() {
		return ArmorList;
	}
	public ArrayList<Weapon> getWeaponList() {
		return WeaponList;
	}
	
	public Character(int nArmor,int nWeapon) {
		ArmorList.clear();
		WeaponList.clear();
		ArmorList.add(new Armor("Light",15,-5));
		ArmorList.add(new Armor("Medium",25,-15));
		ArmorList.add(new Armor("Heavy",35,-25));
		
		WeaponList.add(new Weapon("Dagger",20,0));
		WeaponList.add(new Weapon("Sword",30,-10));
		WeaponList.add(new Weapon("Battle Axe",40,-20));
		
		this.HP=100;
		this.Def=this.Def+ArmorList.get(nArmor).getnDef();
		this.Atk=this.Atk+WeaponList.get(nWeapon).getnAtk();
		this.Spd=this.Spd+ArmorList.get(nArmor).getnSpdPlt()+WeaponList.get(nWeapon).getnSpdPlt();
		
	}
	public Integer getHP() {
		return HP;
	}
	public void setHP(Integer hP) {
		HP = hP;
	}
	public Integer getAtk() {
		return Atk;
	}
	public void setAtk(Integer atk) {
		Atk = atk;
	}
	public Integer getDef() {
		return Def;
	}
	public void setDef(Integer def) {
		Def = def;
	}
	public Integer getSpd() {
		return Spd;
	}
	public void setSpd(Integer spd) {
		Spd = spd;
	}
	/** 
	 * @uml.property name="appWindow"
	 * @uml.associationEnd inverse="character:com.game.ApplicationWindow"
	 */
	private ApplicationWindow applicationWindow;

	/** 
	 * @uml.property name="weapon"
	 * @uml.associationEnd aggregation="composite" inverse="character:com.game.Weapon"
	 */
	private Weapon weapon;

	/** 
	 * Getter of the property <tt>weapon</tt>
	 * @return  Returns the weapon.
	 * @uml.property  name="weapon"
	 */
	public Weapon getWeapon() {
		return weapon;
	}
	/** 
	 * Setter of the property <tt>weapon</tt>
	 * @param weapon  The weapon to set.
	 * @uml.property  name="weapon"
	 */
	public void setWeapon(Weapon weapon) {
		this.weapon = weapon;
	}
	/**
	 * @uml.property  name="armor"
	 * @uml.associationEnd  aggregation="composite" inverse="character:com.game.Armor"
	 */
	private Armor armor;

	/**
	 * Getter of the property <tt>armor</tt>
	 * @return  Returns the armor.
	 * @uml.property  name="armor"
	 */
	public Armor getArmor() {
		return armor;
	}
	/**
	 * Setter of the property <tt>armor</tt>
	 * @param armor  The armor to set.
	 * @uml.property  name="armor"
	 */
	public void setArmor(Armor armor) {
		this.armor = armor;
	}
	/**
	 * Getter of the property <tt>appWindow</tt>
	 * @return  Returns the applicationWindow.
	 * @uml.property  name="appWindow"
	 */
	public ApplicationWindow getAppWindow() {
		return applicationWindow;
	}
	/**
	 * Setter of the property <tt>appWindow</tt>
	 * @param appWindow  The applicationWindow to set.
	 * @uml.property  name="appWindow"
	 */
	public void setAppWindow(ApplicationWindow appWindow) {
		applicationWindow = appWindow;
	}
	/**
	 * @uml.property  name="envt"
	 * @uml.associationEnd  inverse="character:com.game.Envt"
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
	 * @uml.property name="opponents"
	 * @uml.associationEnd inverse="character:com.game.Opponents"
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


}
