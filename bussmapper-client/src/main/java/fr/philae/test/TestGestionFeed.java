//package fr.philae.test;
//import java.util.List;
//
//import javax.naming.Context;
//import javax.naming.InitialContext;
//import javax.naming.NamingException;
//
//import fr.philae.busmapper.domain.Feed;
//import fr.philae.busmapper.services.gestion.feed.FeedServicesRemote;
//
//
//
//
//
//
//
//
//
//
//
//
//public class TestGestionFeed {
//	static FeedServicesRemote remote;
//	public static void doAddFeed(FeedServicesRemote remote){
//
//		Feed feed3=new Feed();
//	feed3.setNotification("hi");
//		
//
//		
////		if(remote.addFeed(feed) && remote.addFeed(feed1) && remote.addFeed(feed2) && remote.addFeed(feed3) ){
////			System.out.println("OK");
//			if(remote.addFeed(feed3)  ){
//				System.out.println("OK");
//		}
//		else
//			System.out.println("Erreur ...add");
//		
//	}
//	public static void doUpdateFeed(FeedServicesRemote remote){
//
//		Feed feed=remote.findFeedById(1);
//		
//		if(remote.updateFeed(feed)){
//			System.out.println("OK");
//		}
//		else
//			System.out.println("Erreur ...");
//
//	}
//	public static void doDeleteFeed(FeedServicesRemote remote){
//
//		Feed feed=remote.findFeedById(1);
//		if (feed ==null)
//System.out.println("feed null");
//		if(remote.deleteFeed(feed)){
//			System.out.println("OK");
//		}
//		else
//			System.out.println("Erreur ...delete");
//
//	}
//	
//	public static void doAuthentifFeed(FeedServicesRemote remote){
//
////Feed feed= remote.authentificate("bilel", "bilel");
//		
//		
//			
//		
//	if(feed!=null)
//	{
//		System.out.println("OK authentification");
//		
//	}
//	else
//		System.out.println("ouupssss erreur authentification");
//
//	}
//	
//	
//	public static void doFindAllFeed(FeedServicesRemote remote){
//		List<Feed> feeds=remote.findAllFeeds();
//		//Configuration configuration=new Configuration();
//
//		if(feeds!=null){
//			System.out.println("OK find"+feeds);
//		}
//		else
//			System.out.println("Erreur ...find Config");
//
//	}
//	//find by STATION
//	
//	public static void doFindAllFeedByStation(FeedServicesRemote remote){
//		List<Feed> feeds=remote.findFeedsByStation("Rome");
//		//Configuration configuration=new Configuration();
//
//		if(feeds!=null){
//			System.out.println("OK find"+feeds);
//		}
//		else
//			System.out.println("Erreur ...find Config");
//
//	}
//	public static void dofindParticipateOrNot(FeedServicesRemote remote){
//		List<Feed> feeds=remote.findParticipateOrNot("Rome");
//		//Integer numberoffalse= remote.findParticipateOrNot("a");
//		
//		if (feeds!=null)
//			System.out.println("liste non  bull"+feeds);
//		else
//			System.out.println("entrer else liste null");
//	}
//	
//	
//	public static void doFindNumberfeedByStation(FeedServicesRemote remote){
//		Integer feeds=remote.findNumberFeedByStation("London");
//		//Configuration configuration=new Configuration();
//
//		if(feeds!=null){
//			System.out.println("OK find number is"+feeds);
//		}
//		else
//			System.out.println("Erreur ...find Config");
//
//	}
//	
//	public static void doFindNumberfeedByGender(FeedServicesRemote remote){
//		Integer feeds=remote.findNumberFeedByGender("Female");
//		//Configuration configuration=new Configuration();
//
//		if(feeds!=null){
//			System.out.println("OK find number is"+feeds);
//		}
//		else
//			System.out.println("Erreur ...find Config");
//
//	}
//	
//	public static void doFindNumberfeedByAge(FeedServicesRemote remote){
//		Integer feeds=remote.findNumberFeedByAge(18);
//		//Configuration configuration=new Configuration();
//
//		if(feeds!=null){
//			System.out.println("OK find number is"+feeds);
//		}
//		else
//			System.out.println("Erreur ...find Config");
//
//	}
//	
//	
//	public static void doFindNumberfeedByFeedType(FeedServicesRemote remote){
//		Integer feeds=remote.findNumberFeedByFeedType("student");
//		//Configuration configuration=new Configuration();
//
//		if(feeds!=null){
//			System.out.println("OK find number is"+feeds);
//		}
//		else
//			System.out.println("Erreur ...find Config");
//
//	}
//	
//	
//	
//	
//	
//	public static void main(String[] args) {
//		
//		
//		try {
//			Context context=new InitialContext();
//			remote=(FeedServicesRemote) context.lookup("busmapper-ejb/FeedServices!fr.philae.busmapper.services.gestion.feed.FeedServicesRemote");
//				} catch (NamingException e) {
//		System.out.println("erreur jndi ... ");
//			e.printStackTrace();
//		}
//	//doAddFeed(remote);	
//	//dofindParticipateOrNot(remote);
////doFindAllFeed(remote);
//	//doFindAllFeedByStation(remote);
//	//doUpdateFeed(remote);
//	//doDeleteFeed(remote);
//	//doAuthentifFeed(remote);
//	
//
//	//doFindNumberfeedByStation(remote);
//	//doFindNumberfeedByGender(remote);
//	//doFindNumberfeedByAge(remote);
//	//doFindNumberfeedByFeedType(remote);
//	}
//}
