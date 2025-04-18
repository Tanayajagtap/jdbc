package com.museum.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


import com.museum.entity.Article;
import com.museum.entity.Category;
import com.museum.util.JdbcUtils;

public class ArticleDao implements JdbcDao<Article, Integer>{
	
	private Connection con;
	private String query;
	private PreparedStatement pstmt;
	private Statement stm;
	
	public ArticleDao() throws SQLException{
		con = JdbcUtils.getdbConnection();
	}
	
	@Override
	public Boolean save(Article article) throws SQLException {
		query = "insert into article values(?,?,?,?,?)";
		pstmt = con.prepareStatement(query);
		pstmt.setInt(1, 0);
		pstmt.setString(2, article.getName());
		pstmt.setString(3, article.getCategory().toString());
		pstmt.setDate(4, Date.valueOf(article.getCreatedDate()));
		pstmt.setString(5, article.getCreatorName());
		
	 int count = pstmt.executeUpdate();
	 	if(count > 0) {
	 		System.out.println(count + " row inserted");
	 		return true;
	 	}else
		return false;
	}

	@Override
	public Collection<Article> findAll() throws SQLException {
		List<Article> articles = new ArrayList<>();
		query = "select * from article";
		stm = con.createStatement();
		ResultSet rs = stm.executeQuery(query);
		while(rs.next()) {
					int id = rs.getInt("id");
				    String name = rs.getString("name");
				    Category category =Category.valueOf(rs.getString("category")); 
					LocalDate date =rs.getDate("date_created").toLocalDate();
					String creatorName =rs.getString("creator_name");
			
					Article article = new Article(id, name, category, date, creatorName);
					articles.add(article);
		}
		return articles;
	}

	@Override
	public Article findById(Integer key) throws SQLException {
		Article foundArticle = null;
		query = "select * from article where id = ?";
		pstmt = con.prepareStatement(query);
		pstmt.setInt(1, key);
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()) {
			int id = rs.getInt("id");
		    String name = rs.getString("name");
		    Category category =Category.valueOf(rs.getString("category")); 
			LocalDate date =rs.getDate("date_created").toLocalDate();
			String creatorName =rs.getString("creator_name");
			foundArticle = new Article(id, name, category, date, creatorName);
		}
		return foundArticle;
	}
	@Override
	public Boolean update(Article article) throws SQLException {
		query = "update article set name = ?, category = ?,date_created  = ?,creator_name = ? where  id  = ?";
		pstmt = con.prepareStatement(query);
		pstmt.setString(1, article.getName());
		pstmt.setString(2, article.getCategory().toString());
		pstmt.setDate(3, Date.valueOf(article.getCreatedDate()));
		pstmt.setString(4, article.getCreatorName());
		pstmt.setInt(5, article.getId());
		int count = pstmt.executeUpdate();
	
		if (count > 0) {
			System.out.println(count + " rows affected!");
			return true;
		}
		return false;
	}


		@Override
		public Boolean delete(Integer id) throws SQLException {
			query = "Delete from article where id=?";
			
			pstmt.setInt(1, id);
			int deleteCount = pstmt.executeUpdate();
			if(deleteCount == 0)
				System.out.println("Article woth given Id does not exist");
			else
				System.out.println(deleteCount+ " record deleted");
			return false;
		}

		
	
}
