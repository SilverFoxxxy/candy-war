package board.squads;

public interface SquadFactory {
	
	//public Factory() {}
	
	public default Squad BearSquad() {return new Squad();}
	
	public default Squad DragonSquad() {return new Squad();}
	
}
