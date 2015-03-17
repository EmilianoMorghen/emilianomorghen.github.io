// Monitor regions screen.
;(function(app)
{
	app.startMonitoringRegions = function()
	{
		function onMonitor(regionState)
		{
			displayRegionInfo(regionState);
		}

		function onError(errorMessage)
		{
			console.log('Monitor error: ' + errorMessage);
		}

		// TODO: Handle multiple regions. Currently only
		// one region will be displayed.
		function displayRegionInfo(regionState)
		{
			$('#monitorIdPage').empty();

			var element = $(createRegionStateHTML(regionState));
			$('#monitorIdPage').append(element);
		};

		function createRegionStateHTML(regionState)
		{
			
			console.log(JSON.stringify(regionState));
			
			var color = 'style-color-pink';
			var htm = '<div class="' + color + '">'
				+ '<table><tr><td>State</td><td>' + regionState.state
				+ '</td></tr><tr><td>Identifier</td><td>' + regionState.identifier
				+ '</td></tr><tr><td>UUID</td><td>' + regionState.uuid
				+ '</td></tr></table></div>';
			return htm;
		};

		// Request authorisation.
		estimote.beacons.requestAlwaysAuthorization();

		// Start monitoring.
		estimote.beacons.startMonitoringForRegion(
			{}, // Empty region matches all beacons.
			onMonitor,
			onError);
	};

	app.stopMonitoringRegions = function()
	{
		estimote.beacons.stopMonitoringForRegion({
			
		});
	};

})(app);
