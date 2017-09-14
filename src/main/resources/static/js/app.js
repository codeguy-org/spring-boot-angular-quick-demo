"use strict";

angular.module('courseApp', []);

angular.module('courseApp').service('AppModel', function($http) {
	this.courses = [];
	
	this.loadCourses = function() {
		$http.get(baseuri + 'list')
		  .then(function(response) {
			  this.courses = response.data;
		  }.bind(this), function(response) {
			 console.log(response.data); 
		  });
	};
	
	this.addCourse = function(course) {
		course.courseId = parseInt(course.courseId);
		
		$http.post(baseuri + 'add', null, {params:course})
			.then(function(response) {
				this.courses = response.data.courses
			}.bind(this), function(response) {
				console.log(JSON.stringify(response));
			});
	};
});

angular.module('courseApp').controller('MainController', ['AppModel', function(AppModel) {
	this.model = AppModel;
	
	this.model.loadCourses();
}]);