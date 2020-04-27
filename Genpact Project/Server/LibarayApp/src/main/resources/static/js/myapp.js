var app = angular.module("Library", ['ui.bootstrap']).controller("LibraryControler", function($scope, $http) {
    $scope.books = "getBooks";
    $scope.rounds = 5;
    $scope.getBooks = "Search all Book Details";
    $scope.count = "No of Books";
    $scope.addBook = "Add New Book";
    $scope.delBook = "Delete Existing Book";
    
    
}