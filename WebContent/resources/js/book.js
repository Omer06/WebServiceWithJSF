$(document).ready(function(){
	
	{
		// .bookTable ' ye yeni bir kitab eklendiği zaman , onun sil ve update butonu için çalışıyor bu blok. Yeni davranışlar ekliyor.
		$(document).on("newBookRow",function(){
			$(".deleteBook").last().click(function(){
				var bookId = $(this).attr('bookid');
				deleteBook(bookId , $(".sendDeleteMessage"));
			});
			$(".updateBook").last().click(function(){
				var bookId = $(this).attr("bookId");
				
				// $('#' + bookId) = update edilecek kitab bilgilerinin satırı <tr>
				
				$('.register-book .name').val( $('#' + bookId + " .name label").html().trim() );
				$('.register-book .author').val( $('#' + bookId + " .author label").html().trim() );
				$('.register-book .page').val( $('#' + bookId + " .page label").html().trim() );
				$('.register-book .hasDatepicker').val( $('#' + bookId + " .releaseDate label").html().trim() );
				$('.register-book .category').val($(this).attr("categoryId"));
				$('.register-book .id').val(bookId);
				
				$(".sendUpdateMessage").click();
				
			});
		});
		
	}
	
	{
		// Ajax methodları bu blokta yer alıyor.
		
		getCategory();
		function getCategory(){
			$.ajax({
				method : "GET" , 
				url : "http://localhost:8080/12-WebServiceWithJSF/resources/category" ,
				contentType: "application/json;charset=utf-8",
				dataType : "json" ,
				async : false ,
				success : function(category) {
					for(var i = 0; i<category.length; i++) {
						$(".category").append(new Option(category[i].name , category[i].id));
					}
				}
			});
		}
		
		
		getBookList();
		function getBookList() {
			$.ajax({
				method : "GET" , 
				url : "http://localhost:8080/12-WebServiceWithJSF/resources/boo" ,
				contentType: "application/json;charset=utf-8",
				dataType : "json" ,
				async : false ,
				success : function(book) {
					$(".bookTable tbody").html("");
					for(var i =0;i<book.length;i++) {
						var date = "";
						if(book[i].releaseDate != null){
							date =  $.datepicker.formatDate('yy-mm-dd', new Date(book[i].releaseDate));
						}
						$(".bookTable tbody").append("<tr data-ri='"+ i +"' class='ui-widget-content ui-datatable-even' role='row' id='" + book[i].id + "' > <td role='gridcell' class='category'><label class='ui-outputlabel ui-widget'> " + book[i].category.name + "  </label></td> <td role='gridcell' class='name'><label class='ui-outputlabel ui-widget'> " + book[i].name + "  </label></td> <td role='gridcell' class='author'><label class='ui-outputlabel ui-widget'> " + book[i].author + "  </label></td> <td role='gridcell' class='page'><label class='ui-outputlabel ui-widget'> " + book[i].page + "  </label></td> <td role='gridcell' class='releaseDate'><label class='ui-outputlabel ui-widget'> " + date  + "  </label></td> <td role='gridcell'><label class='ui-outputlabel ui-widget'> <input type='button' class='btn btn-outline-warning deleteBook' bookId='" + book[i].id + "' value='Sil' style='margin-left:5px;' />  </label></td> <td role='gridcell'><label class='ui-outputlabel ui-widget'> <input type='button' class='btn btn-outline-info updateBook' value='Güncelle' style='margin-left:5px;' bookId='" + book[i].id + "' categoryId='" + book[i].category.id + "'/>  </label></td> </tr>");
						$(document).trigger("newBookRow");
					}
				}
			});
		}
		
		function sendBook() {
			$.ajax({
				method : "POST" , 
				url : "http://localhost:8080/12-WebServiceWithJSF/resources/boo" ,
				contentType: "application/json;charset=utf-8",
				dataType : "json" ,
				async: false,
				data : formToJSON() ,
				success : function (response) {
					if(response.result) {
						$(".sendSaveMessage").click();
						$(".refresh").click();
						$(".resetForm").click();
					}
					else {
						$(".sendErrorMessage").click();
					}
				}
			});
		}
		
		function deleteBook(bookId,messageButton) {
			$.ajax({
				type : "delete" , 
				url : "http://localhost:8080/12-WebServiceWithJSF/resources/boo/" + bookId ,
				success : function(response) {
					if(response.result) {
						messageButton.click();
						$(".refresh").click();
					}
				}
			});
		}
	}
	
	{
		// Front-end Olayları bu blokta yer alıyor.
		
		// .register-book formu submit olduğunda , ajax yolu ile kitabı webserviceye gönderir
		$(".register-book").submit(function(){
			if(validate()) {
				sendBook();
			}
			return false;
		});
		
		// .resetForm butonuna basıldığında , inputların arka plan rengini tekrar beyaz yapar.
		$(".resetForm").click(function(){
			$('.register-book input , .register-book select').each(function() {
				changeBackGround($(this),"#ffffff");
			});
		});
		
		// .refresh butonuna tıklandığında , kitap listesini getirir
		$(".refresh").click(function() {
			getBookList();
		});
		
	}
	
	{
		// yardımcı fonksiyonlar bu methodda yer alıyor.
		
		// .register-book formunun verilerini json'a çevirir
		function formToJSON() {
		    return JSON.stringify({
		        "name": $('.name').val() ,
		        "author": $('.author').val() ,
		        "page": $('.page').val() ,
		        "category": { "id" : $(".category").val() , "name": "unKnow" , "bookList": [] } ,
		        "releaseDate": new Date($(".releaseDate input").val()) ,
		        "id" : $(".id").val() ,
		        });
		}
		
		// .register-book formunu validate eder
		function validate() {
			var result = true;
			$(".register-book input[type='text'] , .register-book select").each(function(){
				if($(this).val() == "") {
					changeBackGround($(this),"#e06161");
					result = false;
				}
				else {
					changeBackGround($(this),"#81e094");
				}
			});
			return result;
		}
		
		// aldığı elementin arka planını değiştirir
		function changeBackGround(element,color) {
			element.animate({
				backgroundColor : color ,
			} , 200);
		}
	}
	
});