marketApp.controller('cartController',
    function cartController($scope, $http) {
        const contextPath = 'http://localhost/api';
        $scope.cartObject = null;

        $scope.getCart = function () {
            $http({
                method: 'GET',
                url: contextPath + '/cart'
            })
                .then(function (response) {
                    $scope.cartObject = response.data;
                });
        };

        $scope.order = function(id) {
            $http({
                method: 'POST',
                url: contextPath + '/orders/' + id
            })
                .then(function (response) {
                    $scope.getCart();
                });
        };

        $scope.getCart();
    }
)
