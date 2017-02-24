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

}
