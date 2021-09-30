marketApp.controller('ordersController',
    function ordersController($scope, $http) {
        const contextPath = 'http://localhost/api';
        $scope.ordersPage = null;

        $scope.getItems = function () {
            $http({
                method: 'GET',
                url: contextPath + '/orders'
            })
                .then(function (response) {
                    $scope.ordersPage = response.data;
                });
        };

        $scope.getItems();
    }
)
