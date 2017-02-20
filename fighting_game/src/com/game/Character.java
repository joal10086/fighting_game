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
	
	public Character(int indexArmor,int indexWeapon) {
		ArmorList.clear();
		WeaponList.clear();
		ArmorList.add(new Armor("Light",15,-5));
		ArmorList.add(new Armor("Medium",25,-15));
		ArmorList.add(new Armor("Heavy",35,-25));
		
		WeaponList.add(new Weapon("Dagger",20,0));
		WeaponList.add(new Weapon("Sword",30,-10));
		WeaponList.add(new Weapon("Battle Axe",40,-20));
		
		this.HP=100;
		this.Def=this.Def+ArmorList.get(indexArmor).getnDef();
		this.Atk=this.Atk+WeaponList.get(indexWeapon).getnAtk();
		this.Spd=this.Spd+ArmorList.get(indexArmor).getnSpdPlt()+WeaponList.get(indexWeapon).getnSpdPlt();
		
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


}
