package controller;
import java.util.Scanner;

import dao.curd;

public class driver {
	public static void main(String[] args) {
		curd c = new curd();
		Scanner sc = new Scanner(System.in);
		boolean f = true;
		while(f){
			System.out.println("1.add \n 2.update \n 3.fetch \n 4.remove");
			switch (sc.nextInt()) {
			
			case 1:{
				String name = sc.next();
				String address = sc.next();
				long number = sc.nextLong();
				c.add(name, address, number);
			}break;
			case 2:{
				int id = sc.nextInt();
				String newname = sc.next();
				c.update(id, newname);
			}break;
			case 3:{
				int id = sc.nextInt();
				c.fetch(id);
			}break;
			case 4:{
				int id = sc.nextInt();
				c.remove(id);
			}break;

			default:{
				System.out.println("invalid option");
			}break;
			}
		}
		
	}

}
