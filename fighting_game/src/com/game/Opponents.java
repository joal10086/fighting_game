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
	
	

	
	


}
