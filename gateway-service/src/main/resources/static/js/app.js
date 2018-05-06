var app = angular.module('myApp', ["ngResource", "ui.router"]);

app.run(function($state){ $state.go('main'); });

app.config(function($stateProvider) {
    $stateProvider
        .state('main', {
            url: '/main',
            controller:'mainCtrl',
            templateUrl: 'views/main.html'
        })
        .state('task', {
            url: '/task/{imageId}',
            controller:'mainCtrl',
            templateUrl: 'views/result.html',
            params : {
                id:null,
                ipAddress:null,
                host:null,
                nodes:null,
                iterations:null,
                startTime:null,
                endTime:null,
                totalTime:null
            }
        })
        .state('history', {
            url: '/history',
            controller:'mainCtrl',
            templateUrl: 'views/history.html'
        });
});

app.controller('mainCtrl', function($scope, $resource, $state, $stateParams) {
    $scope.history = [];
    $scope.iterations = 1;
    $scope.nodes = 1;
    $scope.params = $stateParams;
    $scope.search = "";
    $scope.pageSize = 100;

    $scope.appResource = $resource("/worker-service/app/:operation/:image", {}, {
        getImage: {method: 'GET'},
        getImages: {method: 'GET', isArray: true},
        pwd: {method: 'GET'},
        processImage: {method: 'GET'}
    });

    $scope.getImage = function(){
        $scope.appResource.getImage({operation: 'image'}, function(response) { console.log(response); });
    };

    $scope.getImages = function(image){
        $scope.appResource.getImages({operation: 'image', image: image}, function(response) { console.log(response); });
    };

    $scope.processImage = function(image){
        $scope.appResource.processImage({operation: 'process', imageId: image, iterations: $scope.iterations, nodes: $scope.nodes
        }).$promise.then( function(response) {
            $state.go('task', {
                id:response.id,
                ipAddress:response.ipAddress,
                host:response.host,
                nodes:response.nodes,
                iterations:response.iterations,
                startTime:response.startTime,
                endTime:response.endTime,
                totalTime:response.totalTime,
                imageId: image
            });
        });
    };

    $scope.pwd = function(){
        $scope.appResource.pwd({operation: 'pwd'}, function(response) { console.log(response); });
    };

    $scope.gatewayResource = $resource("/gateway/:operation", {}, {
        getBenchmarkHistory: {method: 'GET', isArray: true},
        getHistory: {method: 'GET', isArray: true},
        searchList: {method: 'GET', isArray: true}
    });

    $scope.getHistory = function(){
        $scope.gatewayResource.getHistory({operation: 'history'}, function(response) {
            $scope.history = response; });
    };

    $scope.searchList = function(){
        $scope.gatewayResource.searchList({operation: 'searchList', userInput: $scope.search}, function(response) {
            $scope.history = response; });
    };

    $scope.getBenchmarkHistory = function(){
        $scope.gatewayResource.getBenchmarkHistory({operation: 'benchmark', size: $scope.pageSize}, function(response) {
            $scope.benchmarkHistory = response; });
    };
});