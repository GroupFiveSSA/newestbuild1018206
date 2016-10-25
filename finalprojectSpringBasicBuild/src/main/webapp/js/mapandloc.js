//Start of getdisplay.js
(function($){

  
  
  //Main Function (GET & Display)
	$(function(){
		
		function mapYo(){
			
			if ( $.fn.DataTable.isDataTable( '#example' ) ) {
	    		   $('#example').DataTable().clear().destroy();//End of promise(delay) function
	    			 
	    		 }
	    	   
			
			//Variables for both HUD and Google Maps API calls
			var map;
		    var lat = "";
		    var long = "";
		    var hudLatLong = lat, long;
		    var agency = "";
		    var city = "";
		    var usercity = $("#userCity").html();
		    var state = $("#hudstate").val();
		    var rowlimit = "";
		    var services = "";
		    var language = "";
		    var index = 0;
		    var marker;
		    var map;
		    var userzip = $("#userZip").html();
		    var userstate = $("#userState").html(); 
		    var useraddress = $("#userAddress").html();
		    //Variables for div injection
		    var divdis = '" border: 1px solid; border-radius: 5px; margin-left: 10px; margin-top: 0px; background-color: white;"';
		    var classname = '"locationItem"';
		    
		    console.log(state);
		    console.log(useraddress);
		    console.log(usercity);
		    console.log(userstate);
		    console.log(userzip);

	      //Google Maps options and call
	      var mapOptions = {
	        mapTypeId: google.maps.MapTypeId.ROADMAP,
	        mapTypeControl: false
	      };
	      
	      //Google Maps inititation linked to localmap div 
	        map = new google.maps.Map(document.getElementById('localmap'), mapOptions); 

	        //Zoom limit       
	        var bounds = new google.maps.LatLngBounds();      

	       //GET call for HUD API with promise(delay) to allow time for DataTable to format results
	       var promise = $.get( "https://cors-anywhere.herokuapp.com/http://data.hud.gov/Housing_Counselor/search?AgencyName="+ agency +"&City="+ city +"&State="+ state +"&RowLimit="+ rowlimit +"&Services="+ services +"&Languages="+ language, 
	        
	        //Start of display function
	         function( data ) {
	    	   $("#tableContainer").delegate("table", "click", function(){
             newlocation = new google.maps.LatLng($(this).data("lat"), $(this).data("lng"));
             //console.log(newlocation);
             map.setCenter(newlocation);
             map.setZoom(16);
          });
	          //Start of array loop (for each returned JSON array object)
	          $.each(data, function(index, value){

	            //Variables used to parse and format JSON objects returned from HUD Api utilizing JSON Array index assignments            
	            var lat = data[index].agc_ADDR_LATITUDE;
	            var long = data[index].agc_ADDR_LONGITUDE;
	            
	            if (lat != null && long != null){//for 1 (Removes any locations that return null values for Lat and Long from map)
	              if (lat != 0 && long != 0){//for 2 (Removes any locations that return values of 0 for Lat and Long from map)

	                //Set both lat and long values to single variable for each location
	                var hudLatLong = new google.maps.LatLng(lat, long);

	                //Sets Map zoom to include all locations returned
	                bounds.extend(hudLatLong);
	                
	                //Creates individual DIV containers for each formatted JSON array object returned from HUD Api. .container routs each new DIV to Container #1 above.
	                $('#tableContainer').append("<tr><td><div id=" + index + " style=" + divdis + " class=" + classname + "></div></td></tr>");                            
	                    
	                    //display all info from the above GET statement in DataTable
	                  
	                    
	                    //Format instructions for DataTable entries
	                    $("#"+index).html("<table data-lat='"+lat+"' data-lng='"+long+"'><tr><td><br><strong>" + data[index].nme + 
	                                      "</strong><br>Location ID: " + data[index].agcid + "<br>" +
	                                       data[index].adr1 + " " + 
	                                       data[index].adr2 + "<br>" + 
	                                       data[index].city + " " + 
	                                       data[index].state_NME + ", " + 
	                                       data[index].mailingzipcd + "<br>" + 
	                                       "Phone Number: " + data[index].phone1 + "<br>" + 
	                                       "Fax Number" + data[index].fax + "<br></td><td>" + 
	                                       "E-Mail: " + data[index].email + "<br>" + 
	                                       "Web Address: " + data[index].weburl + "<br><br></td></tr></table>");
	                        
	                     //embeded map function that needs user location data and HUD service MDation data   
                    var clickloc = data[index].adr1 + ' ' + data[index].adr2 + ' ' + data[index].city + ' ' + data[index].state_NME + ', ' + data[index].mailingzipcd;
                    console.log(clickloc);
                    var contentString =  "<table data-lat='"+lat+"' data-lng='"+long+"'><tr><td><br><strong>" + data[index].nme + 
                                      "</strong><br>Location ID: " + data[index].agcid + "<br>" +
                                       data[index].adr1 + " " + 
                                       data[index].adr2 + "<br>" + 
                                       data[index].city + " " + 
                                       data[index].state_NME + ", " + 
                                       data[index].mailingzipcd + "<br>" + 
                                       "Phone Number: " + data[index].phone1 + "<br>" + 
                                       "Fax Number" + data[index].fax + "<br></td><td>" + 
                                       "E-Mail: " + data[index].email + "<br>" + 
                                       "Web Address: " + data[index].weburl + '<br><br>' +
                                       '<button><a style="text-decoration: none; color: black;" href="https://www.google.com/maps/dir/'+ useraddress +' '+ usercity +' '+ userstate +' '+ userzip + '/' + clickloc +'" target="_blank">Get Directions</a></button></td></tr></table>';



	                     var infowindow = new google.maps.InfoWindow({
                         content: contentString
                    	});

	                    //Start of Google maps markers
	                    var marker = new google.maps.Marker({
	                     position: hudLatLong,

	                      //Displyed results when hovering on marker(InfoWindow does not like to live here)
	                       title: "Location ID: " + data[index].agcid + "\n" +
	                          data[index].nme + "\n" +
	                          data[index].adr1 + "\n" + 
	                          data[index].adr2 + "\n" + 
	                          data[index].city + " " + data[index].state_NME + ", " + data[index].mailingzipcd + "\n" +
	                          "Phone Number: " + data[index].phone1 + "\n" +
	                          "Fax Number" + data[index].fax + "\n" +
	                          "E-Mail: " + data[index].email + "\n" +
	                          "Web Address: " + data[index].weburl,
	                      map: map                 
	                    });//End of Google maps markers


	                   marker.addListener('click', function() {
                      		infowindow.open(map, marker);
                    	}); //infowindow click 

	              };//End of for 2 
	            };//End of for 1
	          });//End of Array loop

	          //Google Maps zoom control call
	          map.fitBounds(bounds);    

	        }, "json")//End of Display function  

	        //Promise(delay) statement and function to allow DataTable to load properly
	       $.when(promise).then(function(){
	    	   
	    	   
	    	   $('#example').DataTable({

 		          //DataTable feature controls
 		          "bLengthChange": false,
 		          "iDisplayLength": 4

 		        });//End of promise(delay) function
	       })//End of promise(delay) statement
			
		}
		
		$("#lookupButton").click(function(){
			mapYo();
		})
		
		mapYo();
        
      })//End of Main function (GET & Display) 

}(jQuery));//End of getdisplay.js