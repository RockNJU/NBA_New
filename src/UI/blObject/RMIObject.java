package UI.blObject;

import businessService.blservice.*;
import businesslogic.bl.*;
import businesslogic.bl.matchbl.MatchController;
import businesslogic.bl.playerbl.PlayerController;
import businesslogic.bl.teambl.TeamController;



public class RMIObject {
		String ip;
		String adress;
		public RMIObject(){
			ip="localhost";  
			adress="rmi://"+ip;
		}
		
		
		public MatchBLService getMatchRMI(){
			MatchBLService  mat= new MatchController();  
			return mat;
		}
		
		
		public PlayerBLService getPlayerRMI () {
			
			PlayerBLService  pla;
		
			
			pla= new PlayerController();  
			return pla;
		}
		
		public TeamBLService getTeamRMI (){
			
			TeamBLService  tea= new TeamController() ;
			return tea;
		}
		
		public static void main(String args[]){
			
			RMIObject c=new RMIObject();
			TeamBLService t=c.getTeamRMI();
			PlayerBLService p=c.getPlayerRMI();
			
			System.out.println("--------------");
		}
		
}
