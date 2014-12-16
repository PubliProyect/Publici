padyuApp.controller('registroUsuariosController', function($scope,$resource)
{
    $scope.errorRegistro=false;
    
    //Funcion de registro
    $scope.crearCuenta = function() {
        $scope.$broadcast('show-errors-check-validity');

        if ($scope.formCrearUsuario.$valid) {
        $resource("/prueba/");
//            if ($scope.formCrearUsuario.$valid) {}
            $scope.errorRegistro=true; //de momento
            alert('Me iría a la página del perfil');
        }
    };

});

//Declaro la directiva
padyuApp.directive('showErroresRegistroUsuarios', function($timeout) {
    return {
        restrict: 'A',
        require: '^form',
        link: function(scope, el, attrs, formCtrl) {
            // find the text box element, which has the 'name' attribute
            var inputEl = el[0].querySelector("[name]");
            // convert the native text box element to an angular element
            var inputNgEl = angular.element(inputEl);
            // get the name on the text box
            var inputName = inputNgEl.attr('name');

            // only apply the has-error class after the user leaves the text box
            var blurred = false;
            inputNgEl.bind('blur', function() {
                blurred = true;
                el.toggleClass('has-error', formCtrl[inputName].$invalid);
            });

            scope.$watch(function() {
                return formCtrl[inputName].$invalid
            }, function(invalid) {
                // we only want to toggle the has-error class after the blur
                // event or if the control becomes valid
                if (!blurred && invalid) {return}
                el.toggleClass('has-error', invalid);
            });

            scope.$on('show-errors-check-validity', function() {
                el.toggleClass('has-error', formCtrl[inputName].$invalid);
            });
        }
    }
});
