package com.museum;


import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Scanner;

import com.museum.entity.Category;
import com.museum.exception.ResourceAlreadyExistException;
import com.museum.exception.ResourceNotFoundException;
import com.museum.service.ArticleService;

public class ArticleMain {

	public static void main(String[] args) {
		ArticleService service = null;
		Scanner sc = new Scanner(System.in);
		try {
			service = new ArticleService();
		} 
		catch (Exception e) {
			System.err.println(e.getMessage());
		}
		
		boolean exit = true;
		while(exit) {
			System.out.println("--------Menu--------"
					+ "\n1.Add Article"
					+ "\n2.Display All Articles"
					+ "\n3.Display Details of Article"
					+ "\n0.Exit");
			System.out.println("Enter your Choice");
			int ch = sc.nextInt();
			switch(ch) {
			case 1:{
				System.out.println("Enter Article name, category (PAINTING, SCULPTURE, ARTIFACT), created date, creator name");
				String name = sc.next();
				Category category = Category.valueOf(sc.next());
				LocalDate date = LocalDate.parse(sc.next());
				String creatorName = sc.next();
				try {
					service.addArticle(name, category, date, creatorName);
				} catch (SQLException |ResourceAlreadyExistException e) {
					e.printStackTrace();
				}
			}
				break;
			case 2:{
				try {
					service.displayAllArticles();
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
			}
				break;
			case 3:{
				System.out.println("Enter article Id : ");
				try {
					service.displayArticleDetails(sc.nextInt());
				} catch (SQLException | ResourceNotFoundException e) {
					e.printStackTrace();
				}
			}
				break;
			case 4: {
				System.out.println("enter id");
				try {
					service.deleteArticle(sc.nextInt());
				} catch (Exception e) {
					System.err.println(e.getMessage());
				}
				break;
			}
			case 5: {
				System.out.println("enter id, name, category(PAINTING,SCULPTURE, ARTIFACT),date, creator name");
				try {
					service.updateArticle(sc.nextInt(), sc.next(), Category.valueOf(sc.next()), LocalDate.parse(sc.next()), sc.next());
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
			}

			case 0:
				exit = false;
				System.out.println("Thankyou !!!");
				break;
			default:
				System.out.println("Invalid choice!! try again later");
			}
		}
	
  }
}
