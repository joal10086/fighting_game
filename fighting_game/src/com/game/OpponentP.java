package com.game;

public abstract class OpponentP {
	public abstract String think();
	private String sType;
	private Integer nHP;
	private Integer nAtk;
	private Integer nDef;
	private Integer nSpd;
	private String sAI;
	
	
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
	public void createOpponent(String type, int i, int j, int k, int l, String sAI) {
		this.sType = type;
		this.nHP = i;
		this.nAtk = j;
		this.nDef = k;
		this.nSpd = l;
		this.sAI = sAI;
		
	}

}
