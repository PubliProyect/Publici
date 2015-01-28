//Creación del módulo
var padyuApp = angular.module('padyuApp', ['ngRoute','vsInternalizacionMod','ngResource']);

//Configuración de las rutas
padyuApp.config(function($routeProvider)
    {
        $routeProvider
                .when('/',
                {
                    templateUrl	: 'partial/home.html',
                    controller 	: 'homeController'
                })
                .when('/login',
                {
                    templateUrl	: 'partial/LoginUsuarios.html',
                    controller 	: 'loginController'
                })
                .when('/perfil',
                {
                    templateUrl	: 'partial/PerfilUsuario.html',
                    controller 	: 'perfilController'
                })
                .when('/registro',
                {
                    templateUrl	: 'partial/RegistroUsuarios.html',
                    controller 	: 'registroUsuariosController'
                })
                .otherwise({
                    redirectTo: '/'
                });
    });
    
    padyuApp.controller('homeController',function ($scope,vsInternalizacion)
    {
        $scope.message="Hola desde homeController: ";
    });
    
    padyuApp.controller('loginController',function ($scope)
    {
        $scope.message="Hola desde loginController" +urlServer;
    });
    
    padyuApp.controller('perfilController',function ($scope)
    {
        $scope.message="Hola desde perfilController";
    });