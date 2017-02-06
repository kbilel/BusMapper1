
   var map;
		var locations = [
      ['Terminus Châtelet' , 48.85817486368521,2.348021339773368],
      ['Arrêt Pont-Neuf - Quai du Louvre', 48.8593057,2.3433173],
      ['Arrêt Pont-Neuf - Quai des Grands Augustins', 48.856297,2.3396298],
      ['Arrêt Mazarine',48.8550773,2.3378256, 2],
      ['Arrêt Saint-Germain - Odéon', 48.8527205876594,2.3387769146359005],
	   ['Arrêt Sénat', 48.8492603,2.3361593],
	    ['Arrêt Musée du Luxembourg- Vavin', 48.8481816,2.3325079],
		 ['Arrêt Guynemer - Vavin', 48.844595,2.3323805],
		 ['Arrêt Bréa - Notre-Dame-des-Champs ', 48.8437829,2.3303028],
		  ['Arrêt Vavin', 48.8422412,2.3288727],
		   ['Arrêt Place du 18 juin 1940', 48.8436218,2.3246146],
		    ['Arrêt Place du 18 juin 1940  Rue du Départ,Rue du Départ',48.8430031,2.323783],
			 ['Arrêt Gare Montparnasse,Avenue du Maine', 48.8408839,2.3215889],
			  ['Arrêt Gaîté,Avenuedu Maine' , 48.8379992,2.3226362],
			   ['Arrêt Losserand - Maine,Avenue du Maine',48.8365618,2.3233518],
			    ['Arrêt Château - Mairie du XIVème, Avenue du Maine' ,48.8336031,2.3245415],
				 ['Arrêt Rue Bénard,Rue des Plantes',48.8311087,2.3240705],
				  ['Arrêt Alésia - Les Plantes,Rue des plante',48.8296042,2.3229087],
				   ['Arrêt Hôpitaux Notre-Dame-de-Bon-Secours - Antoine Chantin',48.8270306,2.3204316],
				   ['Arrêt Jean Moulin',48.825048,2.3185319],
				    ['Arrêt Porte de Châtillon,Rue Maurice docagne',48.8238098,2.3168645],
					 ['Arrêt Porte Didot - Lycée Raspail,Avenue Marc Sangier' , 48.8252646,2.3107424],
					  ['Arrêt Porte de Vanves,Avenue Marc Sangier',48.826634,2.305111],
					   ['Arrêt Pont de la Vallée',48.825642,2.3014307],
					      ['Arrêt Jean Jaurès - Jean Bleuzen',48.8238584,2.2974993],
						     ['Arrêt Carrefour Albert Legris, Rue Jean Jaurès' ,48.8252577,2.2931478],
							    ['Terminus Vanves - Lycée Michelet, Avenue Victor Hugo', 48.823376,2.2885405]
					   
    ];
		var centerMap={lat:48.8408839, lng: 2.3215889};
		var centerV={lat:48.8408839, lng: 2.3215889};
		var contentString ;
		var contentInfoWindow='</b></br>';
		
	//initialize
			
			function initialize() {
	//mapStyler
			var myStyles =[
    {
        featureType: "poi",
        elementType: "labels",
        stylers: [
              { visibility: "off" }
        ]
    },
	 {
        featureType: "road",
        elementType: "labels.text",
        stylers: [
              { saturation: -100 }	
			  
      
        ]
    }
];
		
	//Map BUS	
				 map = new google.maps.Map(document.getElementById("map"), {
				  center: centerMap,
				  zoom: 13,
				  styles: myStyles,
				  mapTypeId: google.maps.MapTypeId.ROADMAP
				});
				
				
				
	//StreetView ************************************************
	
	
		
				autoRefresh(map);
			}

			
			
    //moveMarker
		
			function moveMarker(map, marker, latlng) {
				
				marker.setPosition(latlng);
				
				infowindow.open(map,marker);
				map.panTo(latlng);
				
				
			}

				 
			
			
	//autoRefresh
			function autoRefresh(map) {
				var i, route, marker;
	
	//Marker
				marker=new google.maps.Marker({map:map,icon:"resources/images/bus50x50.png"});
				google.maps.event.addListener(marker, "dblclick", function (e) { 
             
            });
	//InfoWindow

			    infowindow = new google.maps.InfoWindow({});
				
	//Polyline
				route = new google.maps.Polyline({
					path: pathCoords,
					geodesic : true,
					strokeColor: '#FF0000',
					strokeOpacity: 1.0,
					strokeWeight: 2,
					editable: false,
					map:map
				});
				
			
	//Stations
			
			 


    var infowindowStation = new google.maps.InfoWindow();

    var markerStation, j;


    for (j = 0; j < locations.length; j++) {  
      markerStation = new google.maps.Marker({
        position: new google.maps.LatLng(locations[j][1], locations[j][2]),
		icon:"resources/images/station45.png",
		 animation: google.maps.Animation.DROP,
        map: map
      });

	  
	  
	  
	//InfoWindow Station
      google.maps.event.addListener(markerStation, 'click', (function(markerStation, j) {
        return function() {
          infowindowStation.setContent('<b>'+locations[j][0]+contentInfoWindow);
          infowindowStation.open(map, markerStation);
        }
      })(markerStation, j));
    }
			
			
			
				
				
				               // ici il faut que j'utilise le backslash pour afficher l'icon du bus sinon ca fonctionne pa 

				
    

			
				for (i = 0; i < pathCoords.length; i++) {
					
    //Script Moving
	
	
					setTimeout(function (coords)
					{   var d = new Date();
						var latlng = new google.maps.LatLng(coords.lat, coords.lng);
						//route.getPath().push(latlng);
						moveMarker(map, marker, latlng);
						
						
											 function sleep(miliseconds) {
   var currentTime = new Date().getTime();

   while (currentTime + miliseconds >= new Date().getTime()) {
   }
}
					
				
					 t = d.toLocaleTimeString();
					
					 contentString =  '<b>'+'Next Station : </b></br>'+coords.nextStop;	
					 infowindow.setContent(contentString); 
					 
					 centerV=latlng;
					 console.log(coords.stationHere==1);
					 if (coords.lat==48.859905){
					 
					 sleep(15000);
					 
					 }
					 
					 
					 

					 		var panorama = new google.maps.StreetViewPanorama(
      document.getElementById('pano'), {
        position: centerV,
        pov: {
          heading: 34,
          pitch: 10
        }
      });
				map.setStreetView(panorama);
					 console.log(contentString);
						console.log(t);
					
						
						
					}, 5000 * i, pathCoords[i]);  //le 3 eme parametre de la fct setTimeout is Optional. Additional parameters to pass to the function cela dit  coords va recevoir pathCoords[de i ] chaque fois 
				}
			}

			
			

			google.maps.event.addDomListener(window, 'load', initialize);

			var pathCoords = [
				  				{lat:48.858316,lng:2.348121,nextStop:"Arrêt Pont-Neuf - Quai du Louvre"},
				  {lat:48.858512,lng:2.348231,nextStop:"Arrêt Pont-Neuf - Quai du Louvre" },
				  {lat:48.858529,lng:2.348240,nextStop:"Arrêt Pont-Neuf - Quai du Louvre"},
				  {lat:48.858570,lng:2.348120,nextStop:"Arrêt Pont-Neuf - Quai du Louvre"},
				  {lat:48.858641,lng:2.347894,nextStop:"Arrêt Pont-Neuf - Quai du Louvre"},
				  {lat:48.858715,lng:2.347672,nextStop:"Arrêt Pont-Neuf - Quai du Louvre"},
				  {lat:48.858787,lng:2.347447,nextStop:"Arrêt Pont-Neuf - Quai du Louvre"},
				  {lat:48.858863,lng:2.347221,nextStop:"Arrêt Pont-Neuf - Quai du Louvre"},
				  {lat:48.858931,lng:2.347000,nextStop:"Arrêt Pont-Neuf - Quai du Louvre"},
				  {lat:48.859005,lng:2.346775,nextStop:"Arrêt Pont-Neuf - Quai du Louvre"},
				  {lat:48.859040,lng:2.346665,nextStop:"Arrêt Pont-Neuf - Quai du Louvre"},
				  {lat:48.859128,lng:2.346402,nextStop:"Arrêt Pont-Neuf - Quai du Louvre"},
				  {lat:48.859190,lng:2.346214,nextStop:"Arrêt Pont-Neuf - Quai du Louvre"},
				  {lat:48.859335,lng:2.345769,nextStop:"Arrêt Pont-Neuf - Quai du Louvre"},
				  {lat:48.859478,lng:2.345321,nextStop:"Arrêt Pont-Neuf - Quai du Louvre"},
				  {lat:48.859617,lng:2.344870,nextStop:"Arrêt Pont-Neuf - Quai du Louvre"},
				  {lat:48.859765,lng:2.344420,nextStop:"Arrêt Pont-Neuf - Quai du Louvre"},
				  {lat:48.859905,lng:2.343977,nextStop:"Arrêt Pont-Neuf - Quai du Louvre"},
				  {lat:48.860048,lng:2.343513,nextStop:"Arrêt Pont-Neuf - Quai du Louvre"},
				  {lat:48.860074,lng:2.343406,nextStop:"Arrêt Pont-Neuf - Quai du Louvre"},
				  {lat:48.859965,lng:2.343333,nextStop:"Arrêt Pont-Neuf - Quai du Louvre"},
				  {lat:48.859866,lng:2.343282,nextStop:"Arrêt Pont-Neuf - Quai du Louvre"},
				  {lat:48.859791,lng:2.343242,nextStop:"Arrêt Pont-Neuf - Quai du Louvre"},
				  {lat:48.859700,lng:2.343193,nextStop:"Arrêt Pont-Neuf - Quai du Louvre"},
				  {lat:48.859486,lng:2.343066,nextStop:"Arrêt Pont-Neuf - Quai du Louvre"},
				  {lat:48.859347,lng:2.342978,nextStop:"Arrêt Pont-Neuf - Quai du Louvre"},
				  {lat:48.859204,lng:2.342892,nextStop:"Arrêt Pont-Neuf - Quai du Louvre",stationHere:"1"},
				  {lat:48.859066,lng:2.342810,nextStop:"Arrêt Pont-Neuf - Quai des Grands Augustins"},
				  {lat:48.858922,lng:2.342718,nextStop:"Arrêt Pont-Neuf - Quai des Grands Augustins"},
				  {lat:48.858789,lng:2.342611,nextStop:"Arrêt Pont-Neuf - Quai des Grands Augustins"},
				  {lat:48.858737,lng:2.342566,nextStop:"Arrêt Pont-Neuf - Quai des Grands Augustins"},
				  {lat:48.858616,lng:2.342483,nextStop:"Arrêt Pont-Neuf - Quai des Grands Augustins"},
				  {lat:48.858543,lng:2.342454,nextStop:"Arrêt Pont-Neuf - Quai des Grands Augustins"},
				  {lat:48.858513,lng:2.342431,nextStop:"Arrêt Pont-Neuf - Quai des Grands Augustins"},
				  {lat:48.858410,lng:2.342374,nextStop:"Arrêt Pont-Neuf - Quai des Grands Augustins"},
				  {lat:48.858322,lng:2.342311,nextStop:"Arrêt Pont-Neuf - Quai des Grands Augustins"},
				  {lat:48.858251,lng:2.342251,nextStop:"Arrêt Pont-Neuf - Quai des Grands Augustins"},
				  {lat:48.858154,lng:2.342167,nextStop:"Arrêt Pont-Neuf - Quai des Grands Augustins"},
				  {lat:48.858083,lng:2.342112,nextStop:"Arrêt Pont-Neuf - Quai des Grands Augustins"},
				  {lat:48.858010,lng:2.342050,nextStop:"Arrêt Pont-Neuf - Quai des Grands Augustins"},
				  {lat:48.857917,lng:2.341969,nextStop:"Arrêt Pont-Neuf - Quai des Grands Augustins"},
				  {lat:48.857823,lng:2.341900,nextStop:"Arrêt Pont-Neuf - Quai des Grands Augustins"},
				  {lat:48.857749,lng:2.341838,nextStop:"Arrêt Pont-Neuf - Quai des Grands Augustins"},
				  {lat:48.857699,lng:2.341798,nextStop:"Arrêt Pont-Neuf - Quai des Grands Augustins"},
				  {lat:48.857579,lng:2.341699,nextStop:"Arrêt Pont-Neuf - Quai des Grands Augustins"},
				  {lat:48.857508,lng:2.341646,nextStop:"Arrêt Pont-Neuf - Quai des Grands Augustins"},
				  {lat:48.857416,lng:2.341563,nextStop:"Arrêt Pont-Neuf - Quai des Grands Augustins"},
				  {lat:48.857300,lng:2.341445,nextStop:"Arrêt Pont-Neuf - Quai des Grands Augustins"},
				  {lat:48.857194,lng:2.341343,nextStop:"Arrêt Pont-Neuf - Quai des Grands Augustins"},
				  {lat:48.857035,lng:2.341196,nextStop:"Arrêt Pont-Neuf - Quai des Grands Augustins"},
				  {lat:48.856935,lng:2.341099,nextStop:"Arrêt Pont-Neuf - Quai des Grands Augustins"},
				  {lat:48.856813,lng:2.340978,nextStop:"Arrêt Pont-Neuf - Quai des Grands Augustins"},
				  {lat:48.856728,lng:2.340933,nextStop:"Arrêt Pont-Neuf - Quai des Grands Augustins"},
				  {lat:48.856516,lng:2.340783,nextStop:"Arrêt Pont-Neuf - Quai des Grands Augustins"},
				  {lat:48.856400,lng:2.340689,nextStop:"Arrêt Pont-Neuf - Quai des Grands Augustins"},
				  {lat:48.856268,lng:2.340584,nextStop:"Arrêt Pont-Neuf - Quai des Grands Augustins"},
				  {lat:48.856144,lng:2.340474,nextStop:"Arrêt Pont-Neuf - Quai des Grands Augustins"},
				  {lat:48.856091,lng:2.340426,nextStop:"Arrêt Pont-Neuf - Quai des Grands Augustins"},
				  {lat:48.856137,lng:2.340332,nextStop:"Arrêt Pont-Neuf - Quai des Grands Augustins"},
				  {lat:48.856264,lng:2.340171,nextStop:"Arrêt Pont-Neuf - Quai des Grands Augustins"},
				  {lat:48.856442,lng:2.339946,nextStop:"Arrêt Pont-Neuf - Quai des Grands Augustins"},
				  {lat:48.856389,lng:2.339793,nextStop:"Arrêt Pont-Neuf - Quai des Grands Augustins"},
				  {lat:48.856158,lng:2.339332,nextStop:"Arrêt Pont-Neuf - Quai des Grands Augustins",},
				  {lat:48.856015,lng:2.339077,nextStop:"Arrêt Mazarine"},
				  {lat:48.855724,lng:2.338559,nextStop:"Arrêt Mazarine"},
				  {lat:48.855412,lng:2.337980,nextStop:"Arrêt Mazarine"},
				  {lat:48.855279,lng:2.337728,nextStop:"Arrêt Mazarine"},
				  {lat:48.854875,lng:2.337864,nextStop:"Arrêt Mazarine"},
				  {lat:48.854697,lng:2.337929,nextStop:"Arrêt Mazarine"},
				  {lat:48.854326,lng:2.338074,nextStop:"Arrêt Mazarine"},
				  {lat:48.853874,lng:2.338256,nextStop:"Arrêt Mazarine"},
				  {lat:48.853414,lng:2.338446,nextStop:"Arrêt Saint-Germain - Odéon"},
				  {lat:48.852923,lng:2.338664,nextStop:"Arrêt Saint-Germain - Odéon"},
				  {lat:48.852689,lng:2.338758,nextStop:"Arrêt Saint-Germain - Odéon"},
				  {lat:48.852553,lng:2.338758,nextStop:"Arrêt Saint-Germain - Odéon",stationHere:"1"},
				  {lat:48.852108,lng:2.338653,nextStop:"Arrêt Sénat"},
				  {lat:48.851933,lng:2.338508,nextStop:"Arrêt Sénat"},
				  {lat:48.851707,lng:2.338358,nextStop:"Arrêt Sénat"},
				  {lat:48.851529,lng:2.338245,nextStop:"Arrêt Sénat"},
				  {lat:48.851310,lng:2.338154,nextStop:"Arrêt Sénat"},
				  {lat:48.850996,lng:2.338076,nextStop:"Arrêt Sénat",stationHere:"1"},
				  {lat:48.850684,lng:2.338023,},
				  {lat:48.850368,lng:2.337982},
				  {lat:48.850050,lng:2.337942},
				  {lat:48.849743,lng:2.337902},
				  {lat:48.849291,lng:2.337811},
				  {lat:48.849300,lng:2.337183},
				  {lat:48.849282,lng:2.336191},
				  {lat:48.849252,lng:2.335528},
				  {lat:48.849196,lng:2.335161},
				  {lat:48.849136,lng:2.334868},
				  {lat:48.849010,lng:2.334158},
				  {lat:48.848883,lng:2.333530},
				  {lat:48.848751,lng:2.332833},
				  {lat:48.848675,lng:2.332492},
				  {lat:48.848350,lng:2.332484},
				  {lat:48.847914,lng:2.332468},
				  {lat:48.847658,lng:2.332449},
				  {lat:48.847198,lng:2.332433},
				  {lat:48.846746,lng:2.332414},
				  {lat:48.846289,lng:2.332398},
				  {lat:48.845835,lng:2.332374},
				  {lat:48.845567,lng:2.332358},
				  {lat:48.845286,lng:2.332342},
				  {lat:48.845064,lng:2.332301},
				  {lat:48.845014,lng:2.332269},
				  {lat:48.844857,lng:2.332385},
				  {lat:48.844751,lng:2.332154},
				  {lat:48.844546,lng:2.331738},
				  {lat:48.844329,lng:2.331293},
				  {lat:48.844116,lng:2.330866},
				  {lat:48.843923,lng:2.330515},
				  {lat:48.843689,lng:2.330137},
				  {lat:48.843411,lng:2.329748},
				  {lat:48.843166,lng:2.329386},
				  {lat:48.843002,lng:2.329166},
				  {lat:48.842693,lng:2.329273},
				  {lat:48.842292,lng:2.329415},
				  {lat:48.842123,lng:2.329477},
				  {lat:48.842393,lng:2.328697},
				  {lat:48.842587,lng:2.328106},
				  {lat:48.842753,lng:2.327608},
				  {lat:48.842864,lng:2.327259},
				  {lat:48.843002,lng:2.326846},
				  {lat:48.843120,lng:2.326484},
				  {lat:48.843277,lng:2.326030},
				  {lat:48.843373,lng:2.325746},
				  {lat:48.843489,lng:2.325387},
				  {lat:48.843577,lng:2.325102},
				  {lat:48.843692,lng:2.324738},
				  {lat:48.843777,lng:2.324445},
				  {lat:48.843844,lng:2.324217},
				  {lat:48.843470,lng:2.324236},
				  {lat:48.843464,lng:2.324070},
				  {lat:48.843313,lng:2.324043},
				  {lat:48.843233,lng:2.324013},
				  {lat:48.843094,lng:2.323866},
				  {lat:48.842926,lng:2.323665},
				  {lat:48.842732,lng:2.323434},
				  {lat:48.842557,lng:2.323219},
				  {lat:48.842276,lng:2.322876},
				  {lat:48.842123,lng:2.322694},
				  {lat:48.841784,lng:2.322275},
				  {lat:48.841572,lng:2.322021},
				  {lat:48.841332,lng:2.321720},
				  {lat:48.841110,lng:2.321452},
				  {lat:48.841014,lng:2.321347},
				  {lat:48.840864,lng:2.321371},
				  {lat:48.840723,lng:2.321428},
				  {lat:48.840446,lng:2.321538},
				  {lat:48.840195,lng:2.321634},
				  {lat:48.839678,lng:2.321784},
				  {lat:48.839224,lng:2.321962},
				  {lat:48.839032,lng:2.322055},
				  {lat:48.838206,lng:2.322471},
				  {lat:48.837513,lng:2.322847},
				  {lat:48.836828,lng:2.323179},
				  {lat:48.836278,lng:2.323437},
				  {lat:48.835833,lng:2.323598},
				  {lat:48.835338,lng:2.323796},
				  {lat:48.834756,lng:2.324054},
				  {lat:48.834357,lng:2.324204},
				  {lat:48.834025,lng:2.324359},
				  {lat:48.833509,lng:2.324553},
				  {lat:48.833167,lng:2.324681},
				  {lat:48.833029,lng:2.324649},
				  {lat:48.832715,lng:2.324789},
				  {lat:48.832376,lng:2.324928},
				  {lat:48.832062,lng:2.324703},
				  {lat:48.831680,lng:2.324435},
				  {lat:48.831189,lng:2.324107},
				  {lat:48.830702,lng:2.323759},
				  {lat:48.830204,lng:2.323415},
				  {lat:48.829890,lng:2.323126},
				  {lat:48.829794,lng:2.323045},
				  {lat:48.829639,lng:2.322906},
				  {lat:48.829265,lng:2.322589},
				  {lat:48.828784,lng:2.322192},
				  {lat:48.828368,lng:2.321779},
				  {lat:48.828064,lng:2.321457},
				  {lat:48.827718,lng:2.321092},
				  {lat:48.827255,lng:2.320623},
				  {lat:48.826978,lng:2.320358},
				  {lat:48.826699,lng:2.320084},
				  {lat:48.826429,lng:2.319821},
				  {lat:48.826152,lng:2.319548},
				  {lat:48.825878,lng:2.319279},
				  {lat:48.825601,lng:2.319011},
				  {lat:48.825322,lng:2.318764},
				  {lat:48.824879,lng:2.318367},
				  {lat:48.824725,lng:2.318279},
				  {lat:48.824594,lng:2.318290},
				  {lat:48.824411,lng:2.318408},
				  {lat:48.824273,lng:2.318587},
				  {lat:48.824126,lng:2.318252},
				  {lat:48.823927,lng:2.317761},
				  {lat:48.823736,lng:2.317195},
				  {lat:48.823720,lng:2.317107},
				  {lat:48.823764,lng:2.317056},
				  {lat:48.823900,lng:2.316578},
				  {lat:48.824006,lng:2.316187},
				  {lat:48.824119,lng:2.315825},
				  {lat:48.824225,lng:2.315465},
				  {lat:48.824324,lng:2.315151},
				  {lat:48.824402,lng:2.314886},
				  {lat:48.824494,lng:2.314577},
				  {lat:48.824538,lng:2.314411},
				  {lat:48.824617,lng:2.313979},
				  {lat:48.824672,lng:2.313633},
				  {lat:48.824727,lng:2.313226},
				  {lat:48.824769,lng:2.312963},
				  {lat:48.824831,lng:2.312550},
				  {lat:48.824900,lng:2.312032},
				  {lat:48.825015,lng:2.311619},
				  {lat:48.825119,lng:2.311243},
				  {lat:48.825294,lng:2.310677},
				  {lat:48.825438,lng:2.310238},
				  {lat:48.825542,lng:2.309918},
				  {lat:48.825650,lng:2.309393},
				  {lat:48.825726,lng:2.308837},
				  {lat:48.825809,lng:2.308274},
				  {lat:48.825871,lng:2.307775},
				  {lat:48.825954,lng:2.307325},
				  {lat:48.826070,lng:2.306890},
				  {lat:48.826263,lng:2.306257},
				  {lat:48.826376,lng:2.305914},
				  {lat:48.826588,lng:2.305273},
				  {lat:48.826710,lng:2.304924},
				  {lat:48.826930,lng:2.304801},
				  {lat:48.827211,lng:2.304677},
				  {lat:48.827118,lng:2.304409},
				  {lat:48.826883,lng:2.303940},
				  {lat:48.826607,lng:2.303484},
				  {lat:48.826270,lng:2.302961},
				  {lat:48.825973,lng:2.302553},
				  {lat:48.825666,lng:2.302408},
				  {lat:48.825456,lng:2.302312},
				  {lat:48.825564,lng:2.301869},
				  {lat:48.825703,lng:2.301217},
				  {lat:48.825791,lng:2.300796},
				  {lat:48.825878,lng:2.300203},
				  {lat:48.825576,lng:2.300182},
				  {lat:48.825339,lng:2.300257},
				  {lat:48.825202,lng:2.300238},
				  {lat:48.825099,lng:2.300123},
				  {lat:48.824928,lng:2.299785},
				  {lat:48.824651,lng:2.299224},
				  {lat:48.824414,lng:2.298656},
				  {lat:48.824144,lng:2.298109},
				  {lat:48.823893,lng:2.297545},
				  {lat:48.823770,lng:2.297224},
				  {lat:48.823886,lng:2.297028},
				  {lat:48.824147,lng:2.296599},
				  {lat:48.824423,lng:2.296167},
				  {lat:48.824773,lng:2.295598},
				  {lat:48.824852,lng:2.295418},
				  {lat:48.824909,lng:2.295166},
				  {lat:48.824958,lng:2.294788},
				  {lat:48.825080,lng:2.294131},
				  {lat:48.825186,lng:2.293594},
				  {lat:48.825278,lng:2.293096},
				  {lat:48.825378,lng:2.292615},
				  {lat:48.825470,lng:2.292554},
				  {lat:48.825490,lng:2.292436},
				  {lat:48.825461,lng:2.292347},
				  {lat:48.825394,lng:2.292331},
				  {lat:48.825352,lng:2.292363},
				  {lat:48.825297,lng:2.292235},
				  {lat:48.825101,lng:2.291851},
				  {lat:48.824891,lng:2.291438},
				  {lat:48.824626,lng:2.290931},
				  {lat:48.824414,lng:2.290510},
				  {lat:48.824225,lng:2.290140},
				  {lat:48.824036,lng:2.289770},
				  {lat:48.823867,lng:2.289453},
				  {lat:48.823662,lng:2.289056},
				  {lat:48.823499,lng:2.288737},
				  {lat:48.823392,lng:2.288509},
				  {lat:48.823455,lng:2.288410}
				  			];
			
			function toggle() {
	var eleMap = document.getElementById("map");
	var elePano = document.getElementById("pano");
	
	
	if(elePano.style.display == "block") {
	        elePano.style.width = "40px";
    		elePano.style.display = "none";
			eleMap.style.width="100%";
		
  	}
	else {
	    eleMap.style.width="40%";
		elePano.style.display = "block";
		;
	}
} 
	