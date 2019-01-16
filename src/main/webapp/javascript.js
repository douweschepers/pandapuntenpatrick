function names(){
	
	var btn = document.createElement("BUTTON");
	  
	console.log("joe");
	$.getJSON("http://localhost:8081/pandanew/restservices/gebruikers", function(data) {
		$(data).each(function( index_user , value_user ) {
			console.log(value_user.lasttime);
			$('#names').append('<tr id="rows'+index_user+'">' +
					'<td>' + value_user.name + '</td>'+ 
					'<td>' + value_user.lasttime + '</td>'+
					'<td>' + '<form><input type="button" class="button" id="rowName'+index_user+'" value="reset" /></form>' + '</td>'+
					'</tr>');
			$('#rowName'+index_user).click(function(){
				reset(value_user.name);
			})
			
		});
	});
};

function reset(name){
	console.log(name);
		
		var uri = "http://localhost:8081/pandanew/restservices/gebruikers/" + name;
		
		$.ajax(uri, {
			type: "put",
			data: name,
			success: function(response) {
				alert(name + " has been updated!");
			},
			error: function(response) {
				alert(name + " has NOT been updated!");
			}
		})
	
};

names();