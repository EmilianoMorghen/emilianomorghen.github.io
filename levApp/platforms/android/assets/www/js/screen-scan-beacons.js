// Scan beacons screen.
;(function(app)
{
	app.startScanningBeacons = function()
	{
		
		function onScan(beaconInfo)
		{
			
			displayBeconInfo(beaconInfo);        
		}

		function onError(errorMessage)
		{
			console.log('Scan error: ' + errorMessage);
		}

		function displayBeconInfo(beaconInfo)
		{
			// Clear beacon HTML items.
			$('#rangeIdPage').empty();

			// Sort beacons by signal strength.
//			beaconInfo.beacons.sort(function(beacon1, beacon2) {
//				return beacon1.rssi > beacon2.rssi; });

			// Generate HTML for beacons.
			var html = '';
			$.each(beaconInfo.beacons, function(key, beacon)
			{
				// jQuery doesn't work.
				var element = $(createBeaconHTML(beacon));
				$('#rangeIdPage').append(element);
			});
		};

		function createBeaconHTML(beacon)
		{
				var colorClasses = app.beaconColorStyle(beacon.color);
				var htm = '<div class="' + colorClasses + '">'
					+ '<table><tr><td>proximityUUID</td><td>' + beacon.proximityUUID
					+ '<td><tr><td>Name</td><td>' + beacon.name
					+ '<td><tr><td>Major</td><td>' + beacon.major
					+ '</td></tr><tr><td>Minor</td><td>' + beacon.minor
					+ '</td></tr><tr><td>RSSI</td><td>' + beacon.rssi
					+ '</td></tr><tr><td>Measured power</td><td>' + beacon.measuredPower
					+ '</td></tr><tr><td>Measured distance</td><td>' + beacon.distance
					+ '</td></tr><tr><td>MAC address</td><td>' + beacon.macAddress
					+ '</td></tr></table></div>' + '<br></br>';
				return htm;
		};


		// Start scanning.
		estimote.beacons.startRangingBeaconsInRegion(
			{}, // Empty region matches all beacons.
			onScan,
			onError);
	};

	app.stopScanningBeacons = function()
	{
		function onStop(beaconInfo)
		{
			console.log('stop scanning beacons!');
		}
		
		function onError(errorMessage)
		{
			console.log('Scan error: ' + errorMessage);
		}
		
		estimote.beacons.stopRangingBeaconsInRegion(
			    {},
			    onStop,
				onError);
	};

})(app);
