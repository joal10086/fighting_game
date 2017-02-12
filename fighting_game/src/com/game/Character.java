package com.game;

public class Character {
	private Integer HP;
	private Integer Atk=1;
	private Integer Def=1;
	private Integer Spd=50;
	
	public Character(Armor a,Weapon w) {
		this.HP=100;
		this.Def=this.Def+a.getnDef();
		this.Atk=this.Atk+w.getnAtk();
		this.Spd=this.Atk+a.getnSpdPlt()+w.getnSpdPlt();
		
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
