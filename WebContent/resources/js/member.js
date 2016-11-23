$(document).ready(function(){

	getMemberList();
	function getMemberList() {
		$.ajax({
			method : "GET" , 
			url : "http://localhost:8080/12-WebServiceWithJSF/resources/member/" ,
			contentType: "application/json;charset=utf-8",
			dataType : "json" ,
			async : false ,
			success : function(member) {
				$(".memberTable tbody").html("");
				for(var i =0;i<member.length;i++) {
					var date = "";
					if(member[i].registerDate != null){
						date =  $.datepicker.formatDate('yy-mm-dd', new Date(book[i].registerDate));
					}
					$(".memberTable tbody").append("<tr data-ri='"+ i +"' class='ui-widget-content ui-datatable-even' role='row' > <td role='gridcell'><label class='ui-outputlabel ui-widget'> " + member[i].tc + "  </label></td> <td role='gridcell'><label class='ui-outputlabel ui-widget'> " + member[i].name + "  </label></td> <td role='gridcell'><label class='ui-outputlabel ui-widget'> " + member[i].surname + "  </label></td> <td role='gridcell'><label class='ui-outputlabel ui-widget'> " + member[i].number + "  </label></td> <td role='gridcell'><label class='ui-outputlabel ui-widget'> " + date  + "  </label></td></tr>");
				}
			}
		});
	}
	
	$('.register-member').submit(function(e) {
		e.preventDefault();
		if(validate()) { sendMember(); }
	});
	
	function validate() {
		result = true ;
		$('.register-member input').each(function(){
			
			if($(this).val().trim() == "") {
				changeBackground($(this) , "#e06161");
				result  = false;
			} else {
				changeBackground($(this) , "#81e094");
			}
		});
		return result;
	}
	
	
	function sendMember() {
		$.ajax({
			method : "POST" , 
			url : "http://localhost:8080/12-WebServiceWithJSF/resources/member/" ,
			contentType: "application/json;charset=utf-8",
			dataType : "json" ,
			async: false,
			data : formToJSON() ,
			success : function (response) {
				if(response.result) {
					$(".getSuccessMessage").click();
				}
				else {
					$(".getErrorMessage").click();
				}
			}
		});
	}
	
	function formToJSON() {
	    return JSON.stringify({
	        "tc": $('.tc').val() ,
	        "name": $('.name').val() ,
	        "surname": $('.surname').val() ,
	        "number": $('.phone').val() ,
	        "registerDate": new Date($(".hasDatepicker").val()) ,
	       	});
	}
	
	$(".reset").click(function(){
		$('.register-member input').each(function(){ changeBackground($(this) , "#ffffff");  });
	});
	
	$(".refresh").click(function(e){
		getMemberList();
	});
	
	function changeBackground(element , color) {
		element.animate({
			backgroundColor : color ,
		} , 200);
	}
	
});