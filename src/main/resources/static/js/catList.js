/**
 * 
 */

$(document).ready(function(){
	// create new user or edit one
	$('.nBtn, .table .eBtn').on('click', function(event){
		event.preventDefault();	
		var href = $(this).attr('href');
		var text = $(this).text();
		if(text=='Edit') {
			$.get(href, function(data4cat, status){
				$('.myForm #petId').val(data4cat.petId);
				$('.myForm #name').val(data4cat.name);
				$('.myForm #type').val(data4cat.type);
				$('.myForm #ownerName').val(data4cat.ownerName);
				$('.myForm #address').val(data4cat.address);
				$('.myForm #age').val(data4cat.age);
				$('.myForm #isSpayed').val(data4cat.isSpayed);
				$('.myForm #updatedOn').val(data4cat.updatedOn);
			});
			$('.myForm #exampleModal').modal();	// modal(), modal('show'), modal('toggle')
		} else {
			$('.myForm #petId').prop("disabled", true); 
			$('.myForm #petId').prop("type", "hidden"); 
			$('.myForm #petId').parent().hide();	
			// initialize the fields of modal
			$('.myForm #petId').val('');	
			$('.myForm #name').val('');
			$('.myForm #type').val('');
			$('.myForm #ownerName').val('');
			$('.myForm #address').val('');
			$('.myForm #age').val('');
			$('.myForm #isSpayed').val('');
			$('.myForm #updatedOn').val('');
			// let Bootstrap modal popup via below jQuery call
			$('.myForm #exampleModal').modal();	// modal(), modal('show'), modal('toggle')			
		}
	});
	
	$('.table .dBtn').on('click', function(event){
		event.preventDefault();	
		var href = $(this).attr('href');
		$('#exampleModal4delete #dConfBtn').attr('href', href);
		// let Bootstrap modal popup via below jQuery call
		$('#exampleModal4delete').modal();	// modal(), modal('show'), modal('toggle')			
		

	});
		
});