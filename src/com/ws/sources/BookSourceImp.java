package com.ws.sources;

import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import com.entities.Book;
import com.entities.Category;
import com.entities.OperationResult;
import com.imp.services.BookServiceImp;
import com.interfaces.services.BookService;
import com.supplier.SpringBeanSupplier;

@Path("/boo")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class BookSourceImp implements EntitySource<Book> {

	private static final BookService bookService = getBookService();
	
	
	@GET
	@Override
	public List<Book> getList() {
		// TODO Auto-generated method stub
		System.out.println("liste çekiliyor");
		List<Book> list =  bookService.getList();
		System.out.println(list);
		return list;
	}

	
	@GET
	@Path("/{bookId}")
	@Override
	public Book getBy(@PathParam("bookId") int bookId) {
		// TODO Auto-generated method stub
		Book book = bookService.getBy(bookId);
		System.out.println("Kitap çekildi.");
		book.getMemberList().forEach(argMember -> System.out.println("Member ID : " + argMember.getId()));
		
		return book;
	}

	@POST
	@Override
	public OperationResult save(Book book) {
		// TODO Auto-generated method stub
		System.out.println(book);
		try{
			bookService.saveOrUpdate(book);
		}catch (Exception e) { e.printStackTrace(); return new OperationResult(false); }
		
		return new OperationResult(true);
		
	}
	
	@DELETE
	@Path("/{bookId}")
	@Override
	public OperationResult delete(@PathParam("bookId") int bookId) {
		// TODO Auto-generated method stub
		try{
			Book theBook = bookService.getBy(bookId);
			bookService.delete(theBook);
		}catch(Throwable e) { System.err.println("Hata oluþtu"); e.printStackTrace(); return new OperationResult(false); }
		return new OperationResult(true);
	}

	
	@PUT
	@Override
	public OperationResult update(Book book) {
		// TODO Auto-generated method stub
		try {
			bookService.update(book);
		}catch(Exception e) { e.printStackTrace(); return new OperationResult(false); }
		return new OperationResult(true);
	}
	
	
	@POST
	@Path("/populate")
	public void populate() {
		for (int i = 0; i < 10; i++) {
			Book book = new Book("name-" + i , "author-" + i , (i*50) + 50 , new Date() , new Category(new Random().nextInt(4) + 1));
			
			bookService.save(book);
		}
	}
	
	public void removeMemberBy(Book book , int memberId) {
		book.getMemberList().removeIf( argMember -> argMember.getId() == memberId );
		bookService.save(book);
	}

	private static BookService getBookService() {
		return SpringBeanSupplier.supply(BookServiceImp.class);
	}

}
