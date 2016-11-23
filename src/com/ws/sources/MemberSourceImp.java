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
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import com.entities.Book;
import com.entities.BookHistory;
import com.entities.Category;
import com.entities.Member;
import com.entities.OperationResult;
import com.interfaces.services.BookService;
import com.interfaces.services.MemberService;
import com.supplier.SpringBeanSupplier;

@Path("/member")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class MemberSourceImp implements EntitySource<Member>{
	
	private static final MemberService memberService = getMemberService();

	
	@GET
	@Override
	public List<Member> getList() {
		// TODO Auto-generated method stub
		return memberService.getList();
	}

	
	@GET
	@Path("/{memberId}")
	@Override
	public Member getBy(@PathParam("memberId") int memberId) {
		// TODO Auto-generated method stub
		return memberService.getBy(memberId);
	}



	
	@POST
	@Override
	public OperationResult save(Member entity) {
		// TODO Auto-generated method stub
		try{
			memberService.save(entity);
		}catch (Exception e) { e.printStackTrace(); return new OperationResult(false); }
		return new OperationResult(true);
	}



	
	@DELETE
	@Path("/{memberId}")
	@Override
	public OperationResult delete(@PathParam("memberId") int memberId) {
		System.out.println("Siliniyor : " + memberId);
		// TODO Auto-generated method stub
		try {
			Member member = memberService.getBy(memberId);
			member.getMemberHistory().getBookList().forEach(argBookList -> { new BookSourceImp().removeMemberBy(argBookList.getBook() , memberId); });
			
			System.out.println(member);
			memberService.delete(member);
		}catch (Exception e) { e.printStackTrace(); return new OperationResult(false); }
		return new OperationResult(true);
	}



	
	@PUT
	@Override
	public OperationResult update(Member member) {
		// TODO Auto-generated method stub
		try {
			memberService.update(member);
		}catch (Exception e) { e.printStackTrace(); return new OperationResult(false); }
		return new OperationResult(true);
	}
	
	
	@PUT
	@Path("/{memberId}")
	public OperationResult receive(@PathParam("memberId") int memberId , @QueryParam("bookId") int bookId) {
		try {
			Member theMember = memberService.getBy(memberId);
			Book theBook = SpringBeanSupplier.supply(BookService.class).getBy(bookId);
			theMember.getMemberHistory().getBookList().add(new BookHistory(theBook, new Date(), false));
			theBook.getMemberList().add(theMember);
			
			memberService.update(theMember);
			SpringBeanSupplier.supply(BookService.class).update(theBook); // memberListesi için güncelliyoruz.
		}catch (Exception e) { e.printStackTrace(); return new OperationResult(false); }
		return new OperationResult(true);
	}
	
	@POST
	@Path("/populate")
	public void populate() {
		for(int i =0 ; i<10;i++) {
			Member member = new Member("tc-" + i , "name-" + i , "surname-" + i , "number-" + i , new Date()); 
			
			for(int j = 0; j<new Random().nextInt(5) ; j ++) 
				member.getMemberHistory().getBookList().add(new BookHistory(new Book("sub-name" + i, "sub-author" + i, (50 * i) + 50, new Date() , new Category(new Random().nextInt(3) + 1)), new Date(), true));
			
			memberService.save(member);
		}
	}
	
	private static MemberService getMemberService() {
		return SpringBeanSupplier.supply(MemberService.class);
	}

}
