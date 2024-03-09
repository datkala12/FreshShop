// File: shoppingCart.js

// Tạo một ứng dụng AngularJS
var app = angular.module('shoppingApp', []);

// Định nghĩa controller cho giỏ hàng
app.controller('CartController', function($scope) {
	// Khởi tạo giỏ hàng từ localStorage hoặc mảng rỗng nếu không có dữ liệu
	$scope.cartItems = JSON.parse(localStorage.getItem('cartItems')) || [];

	// Hàm thêm sản phẩm vào giỏ hàng
	$scope.addToCart = function(product) {
		// Kiểm tra xem sản phẩm đã có trong giỏ hàng chưa
		var existingItem = findCartItem(product);

		// Nếu sản phẩm đã tồn tại, tăng số lượng, ngược lại, thêm mới vào giỏ hàng
		if (existingItem) {
			existingItem.quantity++;
		} else {
			$scope.cartItems.push({ product: product, quantity: 1 });
		}

		// Lưu giỏ hàng vào localStorage
		saveToLocalStorage();
		// Display a success toast message
		toastr.success(message, "Success", {
			positionClass: "toast-top-right"
		}).click(function() {
			window.location.href = "/viewCart";
		});
		
	};

	// Hàm tăng số lượng sản phẩm trong giỏ hàng
	$scope.increaseQuantity = function(item) {
		item.quantity++;
		saveToLocalStorage();
	};

	// Hàm giảm số lượng sản phẩm trong giỏ hàng
	$scope.decreaseQuantity = function(item) {
		// Đảm bảo số lượng không nhỏ hơn 1
		if (item.quantity > 1) {
			item.quantity--;
			saveToLocalStorage();
		}
	};

	// Hàm xóa sản phẩm khỏi giỏ hàng
	$scope.removeFromCart = function(item) {
		var index = $scope.cartItems.indexOf(item);
		if (index !== -1) {
			$scope.cartItems.splice(index, 1);
			saveToLocalStorage();
		}
	};

	// Hàm tìm kiếm sản phẩm trong giỏ hàng dựa trên ID
	function findCartItem(product) {
		for (var i = 0; i < $scope.cartItems.length; i++) {
			if ($scope.cartItems[i].product.id === product.id) {
				return $scope.cartItems[i];
			}
		}
		return null;
	}

	// Hàm lưu giỏ hàng vào localStorage
	function saveToLocalStorage() {
		localStorage.setItem('cartItems', JSON.stringify($scope.cartItems));
	}
});
