var vsInternalizacionA = angular.module('vsInternalizacionMod', []);

vsInternalizacionA.factory('vsInternalizacion', [function()
{
    var lenguaje;

    setlenguale =function(valor)
    {
        lenguaje=valor;
    };
    
    getlenguale =function()
    {
        return lenguaje;
    };
    
}]);
