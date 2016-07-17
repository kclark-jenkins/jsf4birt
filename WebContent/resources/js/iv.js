$ = jQuery;
$(document).ready(function() {
	
	$.getScript( "http://192.168.1.91:8700/iportal/jsapi" )
	  .done(function( script, textStatus ) {
	    console.log( textStatus );
	    function myInit() {
			var parameterNames  = [];
			var parameterValues = [];
			
			$('.parameter_value').each(function() {parameterValues.push($(this).val());});
			$('.parameter_name').each(function()  {parameterNames.push($(this).text());});
			
			var parameterMap = {};
			
			for(i=0; i<parameterNames.length; i++) {
				parameterMap[parameterNames[i]] = parameterValues[i];
			}	    	
	    	
	        viewer1 = new actuate.Viewer('container1');
	        viewer1.setReportDesign($('.reportdesign').val());
	        var options = new actuate.viewer.UIOptions();
	        viewer1.setUIOptions(options);
	        viewer1.setParameterValues(parameterMap);
	        viewer1.submit();
	    }
		$('.render').on('click', function() {
			var parameterNames  = [];
			var parameterValues = [];
			
			$('.parameter_value').each(function() {parameterValues.push($(this).val());});
			$('.parameter_name').each(function()  {parameterNames.push($(this).text());});
			
			var parameterMap = {};
			
			for(i=0; i<parameterNames.length; i++) {
				parameterMap[parameterNames[i]] = parameterValues[i];
			}
			
		    actuate.load('viewer');
		    var reqOps = new actuate.RequestOptions();
		    reqOps.setRepositoryType('Enterprise');
		    reqOps.setVolume('Default Volume');
		    reqOps.setCustomParameters({});
		    actuate.initialize('http://192.168.1.91:8700/iportal/', reqOps == undefined ? null : reqOps, null, null, myInit);			
		});	    
	  })
	  .fail(function( jqxhr, settings, exception ) {
	    console.log( "Triggered ajaxError handler." );
	});	
});