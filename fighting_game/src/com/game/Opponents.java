package com.game;

import java.util.ArrayList;

public class Opponents {
	private String sType;
	private Integer nHP;
	private Integer nAtk;
	private Integer nDef;
	private Integer nSpd;
	private String sAI;
	
	private ArrayList<Opponents> OpponentsList = new ArrayList<Opponents>();
	public ArrayList<Opponents> getOpponentsList() {
		return OpponentsList;
	}

	public Opponents(int index) {
		OpponentsList.clear();
		OpponentsList.add(new Opponents("Thief",150,20,10,40,""));
		OpponentsList.add(new Opponents("Viking",250,30,20,30,""));
		OpponentsList.add(new Opponents("Minotaur",350,40,30,20,""));
		
		this.sType = OpponentsList.get(index).getsType();
		this.nHP = OpponentsList.get(index).getnHP();
		this.nAtk = OpponentsList.get(index).getnAtk();
		this.nDef = OpponentsList.get(index).getnDef();
		this.nSpd = OpponentsList.get(index).getnSpd();
		this.sAI = OpponentsList.get(index).getsAI();
	}
	
	public Opponents(String sType,int nHP,int nAtk,int nDef,int nSpd,String sAI) {
		this.sType = sType;
		this.nHP = nHP;
		this.nAtk = nAtk;
		this.nDef = nDef;
		this.nSpd = nSpd;
		this.sAI = sAI;
	}
	
	public String getsType() {
		return sType;
	}
	public void setsType(String sType) {
		this.sType = sType;
	}
	public Integer getnHP() {
		return nHP;
	}
	public void setnHP(int nHP) {
		this.nHP = nHP;
	}
	public Integer getnAtk() {
		return nAtk;
	}
	public void setnAtk(int nAtk) {
		this.nAtk = nAtk;
	}
	public Integer getnDef() {
		return nDef;
	}
	public void setnDef(int nDef) {
		this.nDef = nDef;
	}
	public Integer getnSpd() {
		return nSpd;
	}
	public void setnSpd(int nSpd) {
		this.nSpd = nSpd;
	}
	public String getsAI() {
		return sAI;
	}
	public void setsAI(String sAI) {
		this.sAI = sAI;
	}
	


}
