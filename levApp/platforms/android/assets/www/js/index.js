//Applicazione smartphone
var app = {
		// Application Constructor
		initialize : function() {
			// local.useBrowser();
			this.bindEvents();
		},
		// Bind Event Listeners
		//
		// Bind any events that are required on startup. Common events are:
		// 'load', 'deviceready', 'offline', and 'online'.
		bindEvents : function() {
			document.addEventListener('deviceready', this.onDeviceReady, false);
		},
		// deviceready Event Handler
		//
		// The scope of 'this' is the event. In order to call the 'receivedEvent'
		// function, we must explicity call 'app.receivedEvent(...);'
		onDeviceReady : function() {
			app.receivedEvent('deviceready');
		},
		// Update DOM on a Received Event
		receivedEvent : function(id) {

			//Permette le chiamate Cross Domain
			$.support.cors = true;
			console.log('Applicazione pronta!');

		},

		beaconColorStyles : [ 'style-color-unknown style-color-unknown-text',
		                      'style-color-mint style-color-mint-text',
		                      'style-color-ice style-color-ice-text',
		                      'style-color-blueberry-dark style-color-blueberry-dark-text',
		                      'style-color-white style-color-white-text',
		                      'style-color-transparent style-color-transparent-text' ],

		                      beaconColorStyle : function(color) {
		                    	  if (!color) {
		                    		  color = 0;
		                    	  }

		                    	  // Eliminate bad values (just in case).
		                    	  color = Math.max(0, color);
		                    	  color = Math.min(5, color);

		                    	  // Return style class for color.
		                    	  return this.beaconColorStyles[color];
		                      }

};

var ipServer = "192.168.173.1";
var portServer = "8080";

/** ************************************************************************** */
/** *************** Server Functionality fn ***************** */
/** ************************************************************************** */

var fnServer = {


		getTags : function () {

			$.mobile.loading('show');

			$.ajax({
				type: "POST",
				url: "http://"+ipServer+":"+portServer+"/MuseoWeb/GetTags",
				dataType: "json",
				data: {identity: "armellini", password: "password"},
				success: function(data) {
					$.mobile.loading('hide');
				},
				error: function(e) {
					$.mobile.loading('hide');
					alert('Error: ' + e.message);
				}
			});

		},
		getItemByBeacon : function (idBeacon) {

			$.mobile.loading('show');

			$.ajax({
				type: "POST",
				url: "http://"+ipServer+":"+portServer+"/MuseoWeb/GetItemByBeacon?req={idBeacon:"+idBeacon+"}",
				dataType: "json",
				data: {identity: "armellini", password: "password"},
				success: function(data) {
					$.mobile.loading('hide');
				},
				error: function(e) {
					$.mobile.loading('hide');
					alert('Error: ' + e.message);
				}
			});

		},

		getRoomsByBeacon : function (idBeacon){

			$.ajax({
				type: "POST",
				url: "http://"+ipServer+":"+portServer+"/MuseoWeb/GetRoomByBeacon?req={idBeacon:"+idBeacon+"}",
				dataType: "json",
				data: {identity: "armellini", password: "password"},
				success: function(data) {
					$.mobile.loading('hide');
					sala = data.room;
					items = fnServer.getItemsByCodSala(sala.id);

					griglia = fnServer.creaGriglia(sala.lunghezza, sala.altezza, window.innerWidth, window.innerHeight);
					pallini="";
					for(var i = 0; i < griglia.vert.length; i++){
						
						for(var j = 0; j < griglia.vert[i].length; j++){
													
							alert('<div class="pallino" style="left : '+griglia.vert[i][j].x+' px; top: '+griglia.vert[i][j].y+' px;" ></div>');
							
							pallini += '<div class="pallino" style="left : '+griglia.vert[i][j].x+' px; top: '+griglia.vert[i][j].y+' px;" ></div>';
						}
					}
					$("#generatedMap").empty();
					$("#generatedMap").html(pallini);
				},
				error: function(e) {
					$.mobile.loading('hide');
					alert(e.message+" 1");
				}
			});

		},

		getItemsByCodSala : function(codSala)
		{
			// Prendiamo tutti gli oggetti associati a quella sala

			$.ajax({
				type: "POST",
				url: "http://"+ipServer+":"+portServer+"/MuseoWeb/GetItemsByCodiceSala?req={codiceRoom:'"+codSala+"'}",
				dataType: "json",
				data: {identity: "armellini", password: "password"},
				success: function(data) {
					$.mobile.loading('hide');
				},
				error: function(e) {
					$.mobile.loading('hide');
					alert(e.message+" 2");

				}
			});
		},

		generateMap : function (idBeacon) {
			fnServer.getRoomsByBeacon(idBeacon);
		},

		//Restituisce coordinate dell' oggetto
		coOggetto : function (x, y, Umx, Umy) {
			xOgg= Math.floor(x/Umx);
			yOgg= Math.floor(y/Umy);
			posOgg = {
				"xOgg":xOgg,
				"yOgg":yOgg
			};
			return posOgg;
		},

		creaGriglia : function (lungMetri, altezzaMetri, lungPixel, altezzaPixel){

			unit = 10;
			vertici = [];
			unitMeterX = lungMetri/unit;
			unitMeterY = altezzaMetri/unit;
			unitPixelX = lungPixel/unit;
			unitPixelY = altezzaPixel/unit;
			somUnitPixelX = 0;
			somUnitPixelY = 0;
			//Inizializzazione
			for(var i=0; i<unit; i++){
				vertici[i] = [{x: 0, y: 0}];
				for (var j=0; j<unit; j++){
					vertici[i][j] = {x: 0, y: 0};
				}
			}
			for (var i=0; i<unit; i++) {
				//Riga X torna a 0
				somUnitPixelX = 0;
				//Incremento righe
				for (var j=1; j<unit; j++){
					somUnitPixelX += unitPixelX;
					vertici[i][j].x = Math.round(somUnitPixelX);
					vertici[i][j].y = Math.round(somUnitPixelY);
				}
				//Incremento colonne
				somUnitPixelY += unitPixelY;
			}
			griglia = {umx: unitMeterX,umy: unitMeterY,upx: unitPixelX,upy: unitPixelY,vert: vertici};
			return griglia;
		}

}



/** ************************************************************************** */
/** ********************* MODELLO ************************* */
/** ************************************************************************** */

//Il passaggio a pagina 2 fa partire il ranging
$('#page2').on('pageinit', function() {
	app.startScanningBeacons();
});

$('#page3').on('pageinit', function() {
	app.startMonitoringRegions();
});