package application;

import java.sql.*;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Locale;

import pojo.*;

public class DBOperations {
	
	private DBConnection DBConn = null;
	private Statement stmt = null;
	private ResultSet rs = null;
	
	public DBOperations() {
		
		this.DBConn = new DBConnection();
		this.stmt = DBConn.getStmt();
	}
	
	public ArrayList<BookList> getInfo() throws SQLException {
		
		ArrayList<BookList> list = new ArrayList<BookList>();
		
		String sql = "select b.title, b.isbn, b.pages, a.first_name, "
				+ "a.last_name, group_concat(s.name separator \", \"), p.name "
				+ "from books b inner join books_authors ba on b.book_id = ba.book_id "
				+ "inner join books_subjects bs on b.book_id = bs.book_id "
				+ "inner join authors a on ba.author_id = a.author_id "
				+ "inner join subjects s on bs.subject_id = s.subject_id "
				+ "inner join publishers p on b.publisher_id = p.publisher_id "
				+ "group by b.book_id";
		rs = stmt.executeQuery(sql);
		
		while(rs.next()) {
			
			list.add(new BookList(rs.getString("b.title"), rs.getString("b.isbn"), rs.getInt("b.pages"), rs.getString("a.first_name"),
					rs.getString("a.last_name"), rs.getString("group_concat(s.name separator \", \")"), rs.getString("p.name")));
			
			System.out.println(rs.getString("b.title") + rs.getString("b.isbn") + rs.getInt("b.pages") + rs.getString("a.first_name") +
					rs.getString("a.last_name") + rs.getString("group_concat(s.name separator \", \")") + rs.getString("p.name"));
		}
		
		return list;
	}
	
	public ArrayList<BookList> getInfoByTitle() throws SQLException {
		
		ArrayList<BookList> list = new ArrayList<BookList>();
		
		String sql = "select b.title, b.isbn, b.pages, a.first_name, "
				+ "a.last_name, group_concat(s.name separator \", \"), p.name "
				+ "from books b inner join books_authors ba on b.book_id = ba.book_id "
				+ "inner join books_subjects bs on b.book_id = bs.book_id "
				+ "inner join authors a on ba.author_id = a.author_id "
				+ "inner join subjects s on bs.subject_id = s.subject_id "
				+ "inner join publishers p on b.publisher_id = p.publisher_id "
				+ "group by b.title "
				+ "order by b.title"; 
		rs = stmt.executeQuery(sql);
		
		while(rs.next()) {
			
			list.add(new BookList(rs.getString("b.title"), rs.getString("b.isbn"), rs.getInt("b.pages"), rs.getString("a.first_name"),
					rs.getString("a.last_name"), rs.getString("group_concat(s.name separator \", \")"), rs.getString("p.name")));
			
			System.out.println(rs.getString("b.title") + rs.getString("b.isbn") + rs.getInt("b.pages") + rs.getString("a.first_name") +
					rs.getString("a.last_name") + rs.getString("group_concat(s.name separator \", \")") + rs.getString("p.name"));
		}
		
		return list;
	}
	
	public ArrayList<BookListEdit> getInfoEdit() throws SQLException {
		
		ArrayList<BookListEdit> list = new ArrayList<BookListEdit>();
		
		String sql = "select b.title, b.isbn, b.pages, a.first_name, "
				+ "a.last_name, group_concat(s.name separator \", \"), p.name "
				+ "from books b inner join books_authors ba on b.book_id = ba.book_id "
				+ "inner join books_subjects bs on b.book_id = bs.book_id "
				+ "inner join authors a on ba.author_id = a.author_id "
				+ "inner join subjects s on bs.subject_id = s.subject_id "
				+ "inner join publishers p on b.publisher_id = p.publisher_id "
				+ "group by b.title "
				+ "order by b.title"; 
		rs = stmt.executeQuery(sql);
		
		while(rs.next()) {
			
			list.add(new BookListEdit(rs.getString("b.title"), rs.getString("b.isbn"), rs.getInt("b.pages"), rs.getString("a.first_name"),
					rs.getString("a.last_name"), rs.getString("group_concat(s.name separator \", \")"), rs.getString("p.name")));
			
			System.out.println(rs.getString("b.title") + rs.getString("b.isbn") + rs.getInt("b.pages") + rs.getString("a.first_name") +
					rs.getString("a.last_name") + rs.getString("group_concat(s.name separator \", \")") + rs.getString("p.name"));
		}
		
		return list;
	}
	
	public ArrayList<BookList> getInfoByAuthor() throws SQLException {
		
		ArrayList<BookList> list = new ArrayList<BookList>();
		
		String sql = "select b.title, b.isbn, b.pages, a.first_name, "
				+ "a.last_name, group_concat(s.name separator \", \"), p.name "
				+ "from books b inner join books_authors ba on b.book_id = ba.book_id "
				+ "inner join books_subjects bs on b.book_id = bs.book_id "
				+ "inner join authors a on ba.author_id = a.author_id "
				+ "inner join subjects s on bs.subject_id = s.subject_id "
				+ "inner join publishers p on b.publisher_id = p.publisher_id "
				+ "group by b.title "
				+ "order by a.last_name, a.first_name";
		rs = stmt.executeQuery(sql);
		
		while(rs.next()) {
			
			list.add(new BookList(rs.getString("b.title"), rs.getString("b.isbn"), rs.getInt("b.pages"), rs.getString("a.first_name"),
					rs.getString("a.last_name"), rs.getString("group_concat(s.name separator \", \")"), rs.getString("p.name")));
			
			System.out.println(rs.getString("b.title") + rs.getString("b.isbn") + rs.getInt("b.pages") + rs.getString("a.first_name") +
					rs.getString("a.last_name") + rs.getString("group_concat(s.name separator \", \")") + rs.getString("p.name"));
		}
		
		return list;
	}
	
	public ArrayList<BookList> getInfoByGenre() throws SQLException {
		
		ArrayList<BookList> list = new ArrayList<BookList>();
		
		String sql = "select b.title, b.isbn, b.pages, a.first_name, "
				+ "a.last_name, group_concat(s.name separator \", \"), p.name "
				+ "from books b inner join books_authors ba on b.book_id = ba.book_id "
				+ "inner join books_subjects bs on b.book_id = bs.book_id "
				+ "inner join authors a on ba.author_id = a.author_id "
				+ "inner join subjects s on bs.subject_id = s.subject_id "
				+ "inner join publishers p on b.publisher_id = p.publisher_id "
				+ "group by b.title "
				+ "order by group_concat(s.name separator \", \")";
		rs = stmt.executeQuery(sql);
		
		while(rs.next()) {
			
			list.add(new BookList(rs.getString("b.title"), rs.getString("b.isbn"), rs.getInt("b.pages"), rs.getString("a.first_name"),
					rs.getString("a.last_name"), rs.getString("group_concat(s.name separator \", \")"), rs.getString("p.name")));
			
			System.out.println(rs.getString("b.title") + rs.getString("b.isbn") + rs.getInt("b.pages") + rs.getString("a.first_name") +
					rs.getString("a.last_name") + rs.getString("group_concat(s.name separator \", \")") + rs.getString("p.name"));
		}
		
		return list;
	}
	
	public void bookReserved(String firstName, String lastName, String cnp, String address, String city, String phone, String isbn) throws SQLException {
		
		String sql = "select *"
				+ " from clients"
				+ " where cnp = '" + cnp + "'";
		rs = stmt.executeQuery(sql);
		
		if(rs.next() == false) {
			
			sql = "insert into clients (first_name, last_name, cnp, address, city, phone) " +
					"values ('" + firstName + "', '" + lastName + "', '" + cnp + "', '" + address + "', '" + city + "', '" + phone + "')";
			stmt.executeUpdate(sql);
		}
		
		sql = "select book_id"
				+ " from books"
				+ " where isbn = '" + isbn + "'";
		rs = stmt.executeQuery(sql);
		int book = 0;
		while(rs.next()) {
			
			book = rs.getInt("book_id");
		}
		System.out.println(book);
		
		sql = "select client_id"
				+ " from clients"
				+ " where cnp = '" + cnp + "'";
		rs = stmt.executeQuery(sql);
		int client = 0;
		while(rs.next()) {
			
			client = rs.getInt("client_id");
		}
		System.out.println(client);
		
		sql = "select client_id, book_id"
				+ " from borrow"
				+ " where client_id = '" + client + "' and book_id = '" + book + "'";
		rs = stmt.executeQuery(sql);
		
		if(rs.next() == false) {
		
			LocalDate date = LocalDate.now(ZoneId.of("GMT+2")).plusDays(5);
			
			sql = "insert into borrow (client_id, book_id, due_date)"
					+ " values ('" + client + "', '" + book + "', '" + java.sql.Date.valueOf(date) + "')";
			stmt.executeUpdate(sql);
			
			System.out.println("reservation insert done");
		}
	}
	
	public void addBook(String title, String isbn, String pages, String authorFN, String authorLN, String genre, String publisher) throws SQLException {
		
		String sql = "select *"
				+ " from publishers"
				+ " where name = '" + publisher + "'";
		rs = stmt.executeQuery(sql);
		
		if(rs.next() == false) {
			
			sql = "insert into publishers (name)"
					+ " values ('" + publisher + "')";
			stmt.executeUpdate(sql);
		}
		
		sql = "select *"
				+ " from books"
				+ " where isbn = '" + isbn + "'";
		rs = stmt.executeQuery(sql);
		
		if(rs.next() == false) {
			
			sql = "select publisher_id"
					+ " from publishers"
					+ " where name = '" + publisher + "'";
			rs = stmt.executeQuery(sql);
			int pubID = 0;
			while(rs.next()) {
				
				pubID = rs.getInt("publisher_id"); 
			}
			
			sql = "insert into books (isbn, title, pages, publisher_id)"
					+ " values ('" + isbn + "', '" + title + "', '" + Integer.parseInt(pages) + "', '" + pubID + "')";
			stmt.executeUpdate(sql);
		}
		
		sql = "select *"
				+ " from authors"
				+ " where first_name = '" + authorFN + "' and last_name = '" + authorLN + "'";
		rs = stmt.executeQuery(sql);
		
		if(rs.next() == false) {
			
			sql = "insert into authors (first_name, last_name)"
					+ " values ('" + authorFN + "', '" + authorLN + "')";
			stmt.executeUpdate(sql);
		}
		
		sql  = "select author_id"
				+ " from authors"
				+ " where first_name = '" + authorFN + "' and last_name = '" + authorLN + "'";
		rs = stmt.executeQuery(sql);
		int aID = 0;
		while(rs.next()) {
			
			aID = rs.getInt("author_id");
		}
		
		sql = "select book_id"
				+ " from books"
				+ " where isbn = '" + isbn + "'";
		rs = stmt.executeQuery(sql);
		int bID = 0;
		while(rs.next()) {
			
			bID = rs.getInt("book_id");
		}
		
		sql = "select *"
				+ " from books_authors"
				+ " where author_id = '" + aID + "' and book_id = '" + bID + "'";
		rs = stmt.executeQuery(sql);
		
		if(rs.next() == false) {
			
			sql = "insert into books_authors (author_id, book_id)"
					+ " values ('" + aID + "', '" + bID + "')";
			stmt.executeUpdate(sql);
		}
		
		sql = "select *"
				+ " from subjects"
				+ " where name = '" + genre + "'";
		rs = stmt.executeQuery(sql);
		
		if(rs.next() == false) {
			
			sql = "insert into subjects (name)"
					+ " values ('" + genre + "')";
			stmt.executeUpdate(sql);
		}
		
		sql = "select subject_id"
				+ " from subjects"
				+ " where name = '" + genre + "'";
		rs = stmt.executeQuery(sql);
		int sID = 0;
		while(rs.next()) {
			
			sID = rs.getInt("subject_id");
		}
		
		sql = "select *"
				+ " from books_subjects"
				+ " where subject_id = '" + sID + "' and book_id = '" + bID + "'";
		rs = stmt.executeQuery(sql);
		
		if(rs.next() == false) {
			
			sql = "insert into books_subjects (subject_id, book_id)"
					+ " values ('" + sID + "', '" + bID + "')";
			stmt.executeUpdate(sql);
			
			System.out.println("book insert done");
		}
	}
	
	public void removeBook(String isbn, String aFN, String aLN, String publisher) throws SQLException {
		
		String sql = "select book_id"
				+ " from books"
				+ " where isbn = '" + isbn + "'";
		rs = stmt.executeQuery(sql);
		int bID = 0;
		while(rs.next()) {
			
			bID = rs.getInt("book_id");
		}
		
		sql = "delete from books_authors"
				+ " where book_id = '" + bID + "'";
		stmt.executeUpdate(sql);
		
		sql = "delete from books_subjects"
				+ " where book_id = '" + bID + "'";
		stmt.executeUpdate(sql);
		
		sql = "delete from books"
				+ " where book_id = '" + bID + "'";
		stmt.executeUpdate(sql);		
		
		sql = "select author_id"
				+ " from authors"
				+ " where first_name = '" + aFN + "' and last_name = '" + aLN + "'";
		rs = stmt.executeQuery(sql);
		int aID = 0;
		while(rs.next()) {
			
			aID = rs.getInt("author_id");
		}
		
		sql = "select *"
				+ " from authors a join books_authors ba on a.author_id = ba.author_id"
				+ " where a.author_id = '" + aID + "'";
		rs = stmt.executeQuery(sql);
		
		if(rs.next() == false) {
			
			sql = "delete from authors"
					+ " where author_id = '" + aID + "'";
			stmt.executeUpdate(sql);
		}
		
		sql = "select publisher_id"
				+ " from publishers"
				+ " where name = '" + publisher + "'";
		rs = stmt.executeQuery(sql);
		int pID = 0;
		while(rs.next()) {
			
			pID = rs.getInt("publisher_id");
		}
		
		sql = "select *"
				+ " from books"
				+ " where publisher_id = '" + pID + "'";
		rs = stmt.executeQuery(sql);
		
		if(rs.next() == false) {
			
			sql = "delete from publishers"
					+ " where publisher_id = '" + pID + "'";
			stmt.executeUpdate(sql);
		}
		
		System.out.println("delete done");
	}
	
	public ArrayList<BookList> searchDB(String term) throws SQLException {
		
		ArrayList<BookList> list = new ArrayList<BookList>();
		
		String sql = "select b.book_id"
				+ " from books b inner join books_authors ba on b.book_id = ba.book_id"
				+ " inner join authors a on a.author_id = ba.author_id"
				+ " where b.title like '%" + term + "%' or a.first_name like '%" + term + "%' or a.last_name like '%" + term + "%'";
		rs = stmt.executeQuery(sql);
		int bID = 0;
		while(rs.next()) {
			
			bID = rs.getInt("book_id");
		}
		
		sql = "select b.title, b.isbn, b.pages, a.first_name, "
				+ "a.last_name, group_concat(s.name separator \", \"), p.name "
				+ "from books b inner join books_authors ba on b.book_id = ba.book_id "
				+ "inner join books_subjects bs on b.book_id = bs.book_id "
				+ "inner join authors a on ba.author_id = a.author_id "
				+ "inner join subjects s on bs.subject_id = s.subject_id "
				+ "inner join publishers p on b.publisher_id = p.publisher_id "
				+ "where b.book_id = '" + bID + "' "
				+ "group by b.title "
				+ "order by b.title"; 
		rs = stmt.executeQuery(sql);
		while(rs.next()) {
			
			list.add(new BookList(rs.getString("b.title"), rs.getString("b.isbn"), rs.getInt("b.pages"), rs.getString("a.first_name"),
					rs.getString("a.last_name"), rs.getString("group_concat(s.name separator \", \")"), rs.getString("p.name")));
			
			System.out.println(rs.getString("b.title") + rs.getString("b.isbn") + rs.getInt("b.pages") + rs.getString("a.first_name") +
					rs.getString("a.last_name") + rs.getString("group_concat(s.name separator \", \")") + rs.getString("p.name"));
		}
		
		return list;
	}
	
	public ArrayList<BookListEdit> searchDBEdit(String term) throws SQLException {
		
		ArrayList<BookListEdit> list = new ArrayList<BookListEdit>();
		
		String sql = "select b.book_id"
				+ " from books b inner join books_authors ba on b.book_id = ba.book_id"
				+ " inner join authors a on a.author_id = ba.author_id"
				+ " where b.title like '%" + term + "%' or a.first_name like '%" + term + "%' or a.last_name like '%" + term + "%'";
		rs = stmt.executeQuery(sql);
		int bID = 0;
		while(rs.next()) {
			
			bID = rs.getInt("book_id");
		}
		
		sql = "select b.title, b.isbn, b.pages, a.first_name, "
				+ "a.last_name, group_concat(s.name separator \", \"), p.name "
				+ "from books b inner join books_authors ba on b.book_id = ba.book_id "
				+ "inner join books_subjects bs on b.book_id = bs.book_id "
				+ "inner join authors a on ba.author_id = a.author_id "
				+ "inner join subjects s on bs.subject_id = s.subject_id "
				+ "inner join publishers p on b.publisher_id = p.publisher_id "
				+ "where b.book_id = '" + bID + "' "
				+ "group by b.title "
				+ "order by b.title"; 
		rs = stmt.executeQuery(sql);
		while(rs.next()) {
			
			list.add(new BookListEdit(rs.getString("b.title"), rs.getString("b.isbn"), rs.getInt("b.pages"), rs.getString("a.first_name"),
					rs.getString("a.last_name"), rs.getString("group_concat(s.name separator \", \")"), rs.getString("p.name")));
			
			System.out.println(rs.getString("b.title") + rs.getString("b.isbn") + rs.getInt("b.pages") + rs.getString("a.first_name") +
					rs.getString("a.last_name") + rs.getString("group_concat(s.name separator \", \")") + rs.getString("p.name"));
		}
		
		return list;
	}
	
	public void editBook(String title, String isbn, String pages, String authorFN, String authorLN, String genre, String publisher,
			String origTitle, String origAFN, String origALN, String origGenre, String origPub) throws SQLException {
		
		String sql = "update books"
				+ " set title = '" + title + "', isbn = '" + isbn + "', pages = '" + Integer.parseInt(pages) + "'"
						+ " where title = '" + origTitle + "'";
		stmt.executeUpdate(sql);
		
		sql = "update authors"
				+ " set first_name = '" + authorFN + "', last_name = '" + authorLN + "'"
						+ " where first_name = '" + origAFN + "' and last_name = '" + origALN + "'";
		stmt.executeUpdate(sql);
		
		sql = "update publishers"
				+ " set name = '" + publisher + "'"
						+ " where name = '" + origPub + "'";
		stmt.executeUpdate(sql);
		
		sql = "update subjects"
				+ " set name = '" + genre + "'"
						+ " where name = '" + origGenre + "'";
		stmt.executeUpdate(sql);
	}
	
	public ArrayList<SQuery1> getGTThree() throws SQLException {
		
		ArrayList<SQuery1> list = new ArrayList<SQuery1>();
		
		String sql = "select c.first_name, c.last_name, count(b.client_id)"
				+ " from clients c inner join borrow b on c.client_id = b.client_id"
				+ " group by c.client_id"
				+ " having count(b.client_id) > 2";
				
		rs = stmt.executeQuery(sql);
		while(rs.next()) {
			
			list.add(new SQuery1(rs.getString("c.first_name"), rs.getString("c.last_name"), rs.getInt("count(b.client_id)")));
		}
		
		return list;
	}
	
	public ArrayList<Books150> getGT150() throws SQLException {
		
		ArrayList<Books150> list = new ArrayList<Books150>();
		
		String sql = "select b.title, a.first_name, a.last_name, b.pages"
				+ " from books b inner join books_authors ba on b.book_id = ba.book_id"
				+ " inner join authors a on a.author_id = ba.author_id"
				+ " where b.pages > 300";
		rs = stmt.executeQuery(sql);
		while(rs.next()) {
			
			list.add(new Books150(rs.getString("b.title"), rs.getString("a.first_name"), rs.getString("a.last_name"), rs.getInt("b.pages")));
		}
		
		return list;
	}
	
	public ArrayList<SQuery3> getGenreNumbers() throws SQLException {
		
		ArrayList<SQuery3> list = new ArrayList<SQuery3>();
		
		String sql = "select s.name, count(bs.book_id)"
				+ " from books b inner join books_subjects bs on b.book_id = bs.book_id"
				+ " inner join subjects s on s.subject_id = bs.subject_id"
				+ " group by s.name";
		rs = stmt.executeQuery(sql);
		while(rs.next()) {
			
			list.add(new SQuery3(rs.getString("s.name"), rs.getInt("count(bs.book_id)")));
		}
		
		return list;
	}
	
	public ArrayList<SQuery4> getAuthorPublisher() throws SQLException {
		
		ArrayList<SQuery4> list = new ArrayList<SQuery4>();
		
		String sql = "select a.first_name, a.last_name, p.name"
				+ " from authors a inner join books_authors ba on a.author_id = ba.author_id"
				+ " inner join books b on b.book_id = ba.book_id"
				+ " inner join publishers p on b.publisher_id = p.publisher_id"
				+ " group by a.author_id";
		rs = stmt.executeQuery(sql);
		while(rs.next()) {
			
			list.add(new SQuery4(rs.getString("a.first_name"), rs.getString("a.last_name"), rs.getString("p.name")));
		}
		
		return list;
	}
	
	public ArrayList<SQuery5> getAuthorNumbers() throws SQLException {
		
		ArrayList<SQuery5> list = new ArrayList<SQuery5>();
		
		String sql = "select a.first_name, a.last_name, count(ba.book_id)"
				+ " from authors a inner join books_authors ba on a.author_id = ba.author_id"
				+ " group by a.author_id"
				+ " having count(ba.book_id) > 1";
		rs = stmt.executeQuery(sql);
		while(rs.next()) {
			
			list.add(new SQuery5(rs.getString("a.first_name"), rs.getString("a.last_name"), rs.getInt("count(ba.book_id)")));
		}
		
		return list;
	}
	
	public ArrayList<CQuery1> getACName() throws SQLException {
		
		ArrayList<CQuery1> list = new ArrayList<CQuery1>();
		
		String sql = "select c.first_name, c.last_name, a.first_name, a.last_name"
				+ " from clients c inner join borrow bo on c.client_id = bo.client_id"
				+ " inner join books b on bo.book_id = b.book_id"
				+ " inner join books_authors ba on b.book_id = ba.book_id"
				+ " inner join authors a on a.author_id = ba.author_id"
				+ " where c.last_name in"
				+ " (select asb.last_name"
				+ " from authors asb inner join books_authors basb on asb.author_id = basb.author_id"
				+ " inner join books bsb on bsb.book_id = basb.book_id"
				+ " inner join borrow bosb on bosb.book_id = bsb.book_id"
				+ " where bosb.client_id = c.client_id)";
		rs = stmt.executeQuery(sql);
		while(rs.next()) {
			
			list.add(new CQuery1(rs.getString("c.first_name"), rs.getString("c.last_name"), rs.getString("a.first_name"), rs.getString("a.last_name")));
		}
		
		return list;
	}
	
	public ArrayList<CQuery2> getAuthorCurr(String term) throws SQLException {
		
		ArrayList<CQuery2> list = new ArrayList<CQuery2>();
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.ENGLISH);
		System.out.println(term);
		LocalDate date = LocalDate.parse(term, formatter);
		
		String sql = "select a.first_name, a.last_name"
				+ " from authors a inner join books_authors ba on a.author_id = ba.author_id"
				+ " inner join books b on ba.book_id = b.book_id"
				+ " where b.book_id in (select bsb.book_id"
				+ " from books bsb inner join borrow bosb on bsb.book_id = bosb.book_id"
				+ " where due_date = curdate()";
		rs = stmt.executeQuery(sql);
		while(rs.next()) {
			
			list.add(new CQuery2(rs.getString("a.first_name"), rs.getString("a.last_name")));
		}
		
		System.out.println(java.sql.Date.valueOf(date));
		
		return list;
	}
	
	public ArrayList<CQuery3> getPagesAvg() throws SQLException {
		
		ArrayList<CQuery3> list = new ArrayList<CQuery3>();
		
		String sql = "select b.title, b.pages, a.first_name, a.last_name"
				+ " from books b inner join books_authors ba on b.book_id = ba.book_id"
				+ " inner join authors a on ba.author_id = a.author_id"
				+ " where b.pages > (select avg(pages) from books)";
		rs = stmt.executeQuery(sql);
		while(rs.next()) {
			
			list.add(new CQuery3(rs.getString("b.title"), rs.getInt("b.pages"), rs.getString("a.first_name"), rs.getString("a.last_name")));
		}
		
		return list;
	}
}