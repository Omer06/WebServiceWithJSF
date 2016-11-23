$(document).ready(function(){
	
	getCategoryList();
	function getCategoryList() {
		$.ajax({
			method : "GET" , 
			url : "http://localhost:8080/12-WebServiceWithJSF/resources/category/" ,
			async: false ,
			success : function(categoryList) {
				$(".categoryTable tbody").html("");
				for(var i = 0; i<categoryList.length; i++) {
					$(".categoryTable tbody").append("<tr data-ri='"+ i +"' class='ui-widget-content ui-datatable-even' role='row' > <td role='gridcell'><label class='ui-outputlabel ui-widget'> " + categoryList[i].name + "  </label></td>  </tr>");
				}
			}
		});
	}
	
	$(".refresh").click(function(e){
		getCategoryList();
	}); 
	
	$(".register-category").submit(function(){

		if(validate()) {
			sendCategory();
			resetFormElements();
		}
		
		return false;
	});
	
	function sendCategory() {
		$.ajax({
			method : "POST" , 
			url : "http://localhost:8080/12-WebServiceWithJSF/resources/category/" ,
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
	
	function validate() {
		result = true;
		if($(".name").val() == "") {
			$(".name").animate({
				backgroundColor : "#e06161" ,
			} , 300);
			result = false;
		}
		return result;
	}
	
	function formToJSON() {
	    return JSON.stringify({
	        "name": $('.name').val() ,
	        });
	}
	
	function resetFormElements() {
		$(".name").val("");
		$(".name").css("background-color","#fff");
	}
	
});