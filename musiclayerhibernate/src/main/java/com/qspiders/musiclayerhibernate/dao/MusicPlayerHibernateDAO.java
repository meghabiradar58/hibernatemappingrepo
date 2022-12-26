package com.qspiders.musiclayerhibernate.dao;

import java.util.List;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.hibernate.TransactionException;

import com.qspiders.musiclayerhibernate.dto.MusicPlayerHibernateDTO;

public class MusicPlayerHibernateDAO  {
	static boolean loop = true;
	private static EntityManagerFactory factory;
	private static EntityManager manager;
	private static EntityTransaction transaction;
	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		openConnections();

		System.out.println("*****WELCOME TO VIBE MUSIC PLAYER*****");

		while (loop) {
			System.out.println("Please select a option from the menu given below."
					+ "\n1.Play Songs \n2.Add/Remove Songs \n3.Edit Song \n4.View Song list \n5.Exit");

			Scanner sc = new Scanner(System.in);
			int choice = sc.nextInt();

			switch (choice) {
			case 1:
				System.out.println("Please select from the given option \n1.Choose Song to Play \n2.Play All Songs"
						+ "\n3.Play Randon Song");
				int choice1 = sc.nextInt();

				switch (choice1) {
				case 1:
					try {
						chooseSongToPlay();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					break;
				case 2:
					playAllSong();

					break;
				case 3:
					playRandomSong();
					break;
				default:
					System.out.println("Invalid Input. \nPlease provide a Valid Input");
					break;
				}
				break;

			case 2:
				System.out.println("Please select from the given option \n1.Add Songs \n2.Remove Song");
				int choice2 = sc.nextInt();

				switch (choice2) {
				case 1:
					addSongs();
					break;
				case 2:
					removeSong();
					break;
				default:
					System.out.println("Invalid Input. \nPlease provide a Valid Input");
					break;
				}
				break;

			case 3:
				System.out.println("Please select from the given option \n1.Update Song");
				int choice3 = sc.nextInt();

				switch (choice3) {
				case 1:
					updateSongDetails();
					break;

				default:
					System.out.println("Invalid Input. \nPlease provide a Valid Input");
					break;
				}
				break;

			case 4:
				System.out.println("Songs Available");
				displayAllSongs();
				break;

			case 5:
				closeConnections();
				System.out.println("See You Soon");
				break;
			default:
				System.out.println("Invalid Input. \nPlease provide a Valid Input");
				loop = false;
				break;
			}
		}

	}

	private static void addSongs() {
		System.out.println("Please enter the number of songs you want of ADD");
		int noOfSongs = sc.nextInt();

		transaction.begin();

		for (int i = 0; i < noOfSongs; i++) {

			MusicPlayerHibernateDTO song = new MusicPlayerHibernateDTO();

			System.out.println("Enter Song ID");
			song.setId(sc.nextInt());
			sc.nextLine();
			System.out.println("Enter Song Name");
			song.setSongName(sc.nextLine());
			System.out.println("Enter Singer Name");
			song.setSingerName(sc.nextLine());
			System.out.println("Enter Movie Name");
			song.setMovieName(sc.nextLine());
			System.out.println("Enter Composer Name");
			song.setComposer(sc.nextLine());
			System.out.println("Enter Lyricist");
			song.setLyricist(sc.nextLine());
			System.out.println("Enter Song Length");
			song.setLength(sc.nextDouble());

			manager.persist(song);
			System.out.println(song.toString());
			System.out.println("--------------------------------------------------");
		}

		transaction.commit();

	}

	
	private static void removeSong() {
		transaction.begin();

		String jpql = "delete from  MusicPlayerHibernateDTO where id = 1 ";
		Query query = manager.createQuery(jpql);
		int update2 = query.executeUpdate();
		System.out.println(update2 + "row(s) deleted");
	
		transaction.commit();
	}

	private static void chooseSongToPlay() {
		transaction.begin();

		for (int i = 1; i <= 10; i++) {
			System.out.println("\n" + manager.find(MusicPlayerHibernateDTO.class, i)+"\n");
		}

		System.out.println("Enter the Song ID that you want to play");
		int songChoice = sc.nextInt();

		System.out.println(manager.find(MusicPlayerHibernateDTO.class, songChoice).getSongName() + " is now playing");

		transaction.commit();

	}

	private static void playAllSong() {
		transaction.begin();

		String jpql = "select songName from MusicPlayerHibernateDTO";
		Query query = manager.createQuery(jpql);
		List songList = query.getResultList();
		for (Object song : songList) {
			System.out.println(song + " is now playing");
		}
		transaction.commit();
	}

	private static void playRandomSong() {
		int randomSong = (int) (Math.random() * 10) + 1;
		System.out
				.println(manager.find(MusicPlayerHibernateDTO.class, randomSong).getSongName() + " is now playing...");
	}

	private static void updateSongDetails() {
		
		transaction.begin();
		
		String jpql = "update MusicPlayerHibernateDTO set composer ='Pritam' where id = 5";
		Query query = manager.createQuery(jpql);
		int update = query.executeUpdate();
		System.out.println(update + "row(s) updated");
		
		transaction.commit();
	}

	private static void displayAllSongs() {

		transaction.begin();

		String jpql = "select songName from MusicPlayerHibernateDTO";
		Query query = manager.createQuery(jpql);
		List songList = query.getResultList();
		for (Object song : songList) {
			System.out.println(song);
		}

		transaction.commit();

	}

	private static void openConnections() {
		factory = Persistence.createEntityManagerFactory("musicplayerhibernate");
		manager = factory.createEntityManager();
		transaction = manager.getTransaction();
	}

	private static void closeConnections() {
		factory.close();
		manager.close();
		try {
			transaction.rollback();
		} catch (TransactionException e) {
			System.out.println("Transaction cannot be rolledback");
		}
	}

}
