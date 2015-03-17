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

var ipServer = "192.168.20.81";
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
				     alert(JSON.stringify(data));
				   },
				   error: function(e) {
					 $.mobile.loading('hide');
				     alert('Error: ' + e.message);
				   }
				});
			
	}
	

}

/** ************************************************************************** */
/** ********************* MODELLO ************************* */
/** ************************************************************************** */

// Il passaggio a pagina 2 fa partire il ranging
$('#page2').on('pageinit', function() {
	app.startScanningBeacons();
});

$('#page3').on('pageinit', function() {
	app.startMonitoringRegions();
});