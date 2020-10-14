/**
 * 
 */
 
 function sendAjaxRequest1() {
		    var teams1 = $("#teams1").val();
		    jQuery.get("/players?teams="+teams1, function( data ) {
		    	
		        jQuery("#player1").empty();
		        $.each(data , function( key, value ) {
		        	 var option = "<option value = " + value + ">" + key +  "</option>";
		             jQuery("#player1").append(option);
		         });
		       
		    });
		};
		
		
		jQuery(document).ready(function() {
			jQuery("#teams1").change(function() {
		        sendAjaxRequest1();
		    });
		});
		
		 
 function sendAjaxRequest2() {
		    var teams2 = $("#teams2").val();
		    jQuery.get("/players?teams="+teams2, function( data ) {
		    	
		        jQuery("#player2").empty();
		        $.each(data , function( key, value ) {
		        	 var option = "<option value = " + value + ">" + key +  "</option>";
		             jQuery("#player2").append(option);
		         });
		       
		    });
		};
		
		
		jQuery(document).ready(function() {
			jQuery("#teams2").change(function() {
		        sendAjaxRequest2();
		    });
		});
		
		 function sendAjaxRequest3() {
		    var teams3 = $("#teams3").val();
		    jQuery.get("/players?teams="+teams3, function( data ) {
		    	
		        jQuery("#player3").empty();
		        $.each(data , function( key, value ) {
		        	 var option = "<option value = " + value + ">" + key +  "</option>";
		             jQuery("#player3").append(option);
		         });
		       
		    });
		};
		
		
		jQuery(document).ready(function() {
			jQuery("#teams3").change(function() {
		        sendAjaxRequest3();
		    });
		});
		
		 function sendAjaxRequest4() {
		    var teams4 = $("#teams4").val();
		    jQuery.get("/players?teams="+teams4, function( data ) {
		    	
		        jQuery("#player4").empty();
		        $.each(data , function( key, value ) {
		        	 var option = "<option value = " + value + ">" + key +  "</option>";
		             jQuery("#player4").append(option);
		         });
		       
		    });
		};
		
		
		jQuery(document).ready(function() {
			jQuery("#teams4").change(function() {
		        sendAjaxRequest4();
		    });
		});
		
		 function sendAjaxRequest5() {
		    var teams5 = $("#teams5").val();
		    jQuery.get("/players?teams="+teams5, function( data ) {
		    	
		        jQuery("#player5").empty();
		        $.each(data , function( key, value ) {
		        	 var option = "<option value = " + value + ">" + key +  "</option>";
		             jQuery("#player5").append(option);
		         });
		       
		    });
		};
		
		
		jQuery(document).ready(function() {
			jQuery("#teams5").change(function() {
		        sendAjaxRequest5();
		    });
		});
		
		
		function sendAjaxRequest6() {
		    var teams6 = $("#teams6").val();
		    jQuery.get("/players?teams="+teams6, function( data ) {
		    	
		        jQuery("#player6").empty();
		        $.each(data , function( key, value ) {
		        	 var option = "<option value = " + value + ">" + key +  "</option>";
		             jQuery("#player6").append(option);
		         });
		       
		    });
		};
		
		
		jQuery(document).ready(function() {
			jQuery("#teams6").change(function() {
		        sendAjaxRequest6();
		    });
		});
		
		function sendAjaxRequest7() {
		    var teams7 = $("#teams7").val();
		    jQuery.get("/players?teams="+teams7, function( data ) {
		    	
		        jQuery("#player7").empty();
		        $.each(data , function( key, value ) {
		        	 var option = "<option value = " + value + ">" + key +  "</option>";
		             jQuery("#player7").append(option);
		         });
		       
		    });
		};
		
		jQuery(document).ready(function() {
			jQuery("#teams7").change(function() {
		        sendAjaxRequest7();
		    });
		});
		
			function sendAjaxRequest8() {
		    var teams8 = $("#teams8").val();
		    jQuery.get("/players?teams="+teams8, function( data ) {
		    	
		        jQuery("#player8").empty();
		        $.each(data , function( key, value ) {
		        	 var option = "<option value = " + value + ">" + key +  "</option>";
		             jQuery("#player8").append(option);
		         });
		       
		    });
		};
		
		
		jQuery(document).ready(function() {
			jQuery("#teams8").change(function() {
		        sendAjaxRequest8();
		    });
		});
		
		function sendAjaxRequest9() {
		    var teams9 = $("#teams9").val();
		    jQuery.get("/players?teams="+teams9, function( data ) {
		    	
		        jQuery("#player9").empty();
		        $.each(data , function( key, value ) {
		        	 var option = "<option value = " + value + ">" + key +  "</option>";
		             jQuery("#player9").append(option);
		         });
		       
		    });
		};
		
		
		jQuery(document).ready(function() {
			jQuery("#teams9").change(function() {
		        sendAjaxRequest9();
		    });
		});
		
		
		function sendAjaxRequest10() {
		    var teams10 = $("#teams10").val();
		    jQuery.get("/players?teams="+teams10, function( data ) {
		    	
		        jQuery("#player10").empty();
		        $.each(data , function( key, value ) {
		        	 var option = "<option value = " + value + ">" + key +  "</option>";
		             jQuery("#player10").append(option);
		         });
		       
		    });
		};
		
		
		jQuery(document).ready(function() {
			jQuery("#teams10").change(function() {
		        sendAjaxRequest10();
		    });
		});
		
		
		function sendAjaxRequest11() {
		    var teams11 = $("#teams11").val();
		    jQuery.get("/players?teams="+teams11, function( data ) {
		    	
		        jQuery("#player11").empty();
		        $.each(data , function( key, value ) {
		        	 var option = "<option value = " + value + ">" + key +  "</option>";
		             jQuery("#player11").append(option);
		         });
		       
		    });
		};
		
		
		jQuery(document).ready(function() {
			jQuery("#teams11").change(function() {
		        sendAjaxRequest11();
		    });
		});
		
		function sendAjaxRequest12() {
		    var teams12 = $("#teams12").val();
		    jQuery.get("/players?teams="+teams12, function( data ) {
		    	
		        jQuery("#player12").empty();
		        $.each(data , function( key, value ) {
		        	 var option = "<option value = " + value + ">" + key +  "</option>";
		             jQuery("#player12").append(option);
		         });
		       
		    });
		};
		
		
		jQuery(document).ready(function() {
			jQuery("#teams12").change(function() {
		        sendAjaxRequest12();
		    });
		});
		
		
		function sendAjaxRequest13() {
		    var teams13 = $("#teams13").val();
		    jQuery.get("/players?teams="+teams13, function( data ) {
		    	
		        jQuery("#player13").empty();
		        $.each(data , function( key, value ) {
		        	 var option = "<option value = " + value + ">" + key +  "</option>";
		             jQuery("#player13").append(option);
		         });
		       
		    });
		};
		
		
		jQuery(document).ready(function() {
			jQuery("#teams13").change(function() {
		        sendAjaxRequest13();
		    });
		});
		
		function sendAjaxRequest14() {
		    var teams14 = $("#teams14").val();
		    jQuery.get("/players?teams="+teams14, function( data ) {
		    	
		        jQuery("#player14").empty();
		        $.each(data , function( key, value ) {
		        	 var option = "<option value = " + value + ">" + key +  "</option>";
		             jQuery("#player14").append(option);
		         });
		       
		    });
		};
		
		
		jQuery(document).ready(function() {
			jQuery("#teams14").change(function() {
		        sendAjaxRequest14();
		    });
		});
		
		function sendAjaxRequest15() {
		    var teams15 = $("#teams15").val();
		    jQuery.get("/players?teams="+teams15, function( data ) {
		    	
		        jQuery("#player15").empty();
		        $.each(data , function( key, value ) {
		        	 var option = "<option value = " + value + ">" + key +  "</option>";
		             jQuery("#player15").append(option);
		         });
		       
		    });
		};
		
		
		jQuery(document).ready(function() {
			jQuery("#teams15").change(function() {
		        sendAjaxRequest15();
		    });
		});
		
		
		