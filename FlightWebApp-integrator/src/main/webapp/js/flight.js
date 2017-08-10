var app = angular.module("mainApp", []);

app.controller('FlightController', function($scope, $http) {
	
    $http.get('http://localhost:8000/flight/getAllByOrderByNumberAsc').
        then(function(response) {
            $scope.flight = response.data;
            console.log(response.data);
        });
    
    $scope.searchFlight = function (searchfield, searchValue) {
    	console.log(searchfield);
    	
    	var URL = "http://localhost:8000/flight/";
    	
    	if(searchfield == 'number'){
    		URL = URL + "getAllByNumber/"+searchValue;
    	}
    	else if(searchfield == 'from'){
    		URL = URL + "getAllByFrom/"+searchValue;
    	}
    	
    	$http.get(URL).
        
    	then(function(response) {
            $scope.flight = response.data;
            console.log(response.data);
        });

    };
});