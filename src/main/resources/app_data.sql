-- cloud name: drdtpudrn
-- api key: 463489942646594
-- API Secret : Lbm7-UGjhdISFpoyCWTPwpbgIIs

INSERT INTO categories (category_name, created_at, created_by)
VALUES ('vegetables', CURDATE(), 'freshshop'),
       ('fruits', CURDATE(), 'freshshop'),
       ('nuts', CURDATE(), 'freshshop'),
       ('root vegetables', CURDATE(), 'freshshop');

INSERT INTO roles (role_name, created_at, created_by) VALUES ('ADMIN', CURDATE(), 'freshshop');
INSERT INTO roles (role_name, created_at, created_by) VALUES ('USER', CURDATE(), 'freshshop');

-- create a customer with admin role
INSERT INTO customer (customer_name, phone_number, email, pwd, role_id, created_at, created_by, status)
VALUES ('Admin', '0947269045', 'admin@gmail.com', '$2a$12$T7/7gDQcqxckpQn/mTitReQN.UGlsPqz1yYzSTD1fBOJNlF6BxpGi', 1, CURDATE(), 'freshshop', 'Open');

-- Thêm 20 bản ghi dữ liệu vào bảng address
INSERT INTO `address` (`address1`, `address2`, `zip_code`, `created_at`, `created_by`)
VALUES
('123 Đường A, Quận 1', '456 Đường B, Quận 2', 700000, NOW(), 'Admin'),
('789 Đường C, Quận 3', '101 Đường D, Quận 4', 700001, NOW(), 'Admin'),
('222 Đường E, Quận 5', '333 Đường F, Quận 6', 700002, NOW(), 'Admin'),
('444 Đường G, Quận 7', '555 Đường H, Quận 8', 700003, NOW(), 'Admin'),
('666 Đường I, Quận 9', '777 Đường J, Quận 10', 700004, NOW(), 'Admin'),
('888 Đường K, Quận 11', '999 Đường L, Quận 12', 700005, NOW(), 'Admin'),
('111 Đường M, Quận Bình Thạnh', '222 Đường N, Quận Phú Nhuận', 700006, NOW(), 'Admin'),
('333 Đường O, Quận Tân Bình', '444 Đường P, Quận Tân Phú', 700007, NOW(), 'Admin'),
('555 Đường Q, Quận Gò Vấp', '666 Đường R, Quận Thủ Đức', 700008, NOW(), 'Admin'),
('777 Đường S, Quận Bình Tân', '888 Đường T, Quận Cần Giờ', 700009, NOW(), 'Admin'),
('999 Đường U, Quận Hóc Môn', '101 Đường V, Quận Nhà Bè', 700010, NOW(), 'Admin'),
('121 Đường W, Quận Củ Chi', '131 Đường X, Quận 7', 700011, NOW(), 'Admin'),
('141 Đường Y, Quận 6', '151 Đường Z, Quận 5', 700012, NOW(), 'Admin'),
('161 Đường A1, Quận 4', '171 Đường B1, Quận 3', 700013, NOW(), 'Admin'),
('181 Đường C1, Quận 2', '191 Đường D1, Quận 1', 700014, NOW(), 'Admin'),
('201 Đường E1, Quận 1', '211 Đường F1, Quận 2', 700015, NOW(), 'Admin'),
('221 Đường G1, Quận 3', '231 Đường H1, Quận 4', 700016, NOW(), 'Admin'),
('241 Đường I1, Quận 5', '251 Đường J1, Quận 6', 700017, NOW(), 'Admin'),
('261 Đường K1, Quận 7', '271 Đường L1, Quận 8', 700018, NOW(), 'Admin'),
('281 Đường M1, Quận 9', '291 Đường N1, Quận 10', 700019, NOW(), 'Admin');



INSERT INTO `customer` (`customer_name`, `phone_number`, `email`, `pwd`, `role_id`, `status`, `address_id`, `created_at`, `created_by`)
VALUES
('ThanhLuan', '1234567890', 'user@gmail.com', '$2a$10$aWwDHNuEokHATx.68lO2EO/mZUv4CYcgyoqyPilffp.9MSx4BemDm', 2, 'Open', 1, CURRENT_TIMESTAMP, 'admin'),
('Jane Smith', '2345678901', 'jane.smith@example.com', '$2a$10$aWwDHNuEokHATx.68lO2EO/mZUv4CYcgyoqyPilffp.9MSx4BemDm', 2, 'Open', 2, CURRENT_TIMESTAMP, 'admin'),
('David Johnson', '3456789012', 'david.johnson@example.com', '$2a$10$aWwDHNuEokHATx.68lO2EO/mZUv4CYcgyoqyPilffp.9MSx4BemDm', 2, 'Open', 3, CURRENT_TIMESTAMP, 'admin'),
('Emily Brown', '4567890123', 'emily.brown@example.com', '$2a$10$aWwDHNuEokHATx.68lO2EO/mZUv4CYcgyoqyPilffp.9MSx4BemDm', 2, 'Open', 4, CURRENT_TIMESTAMP, 'admin'),
('Michael Wilson', '5678901234', 'michael.wilson@example.com', '$2a$10$aWwDHNuEokHATx.68lO2EO/mZUv4CYcgyoqyPilffp.9MSx4BemDm', 2, 'Open', 5, CURRENT_TIMESTAMP, 'admin'),
('Sophia Miller', '6789012345', 'sophia.miller@example.com', '$2a$10$aWwDHNuEokHATx.68lO2EO/mZUv4CYcgyoqyPilffp.9MSx4BemDm', 2, 'Open', 6, CURRENT_TIMESTAMP, 'admin'),
('Matthew Davis', '7890123456', 'matthew.davis@example.com', '$2a$10$aWwDHNuEokHATx.68lO2EO/mZUv4CYcgyoqyPilffp.9MSx4BemDm', 2, 'Open', 7, CURRENT_TIMESTAMP, 'admin'),
('Olivia Garcia', '8901234567', 'olivia.garcia@example.com', '$2a$10$aWwDHNuEokHATx.68lO2EO/mZUv4CYcgyoqyPilffp.9MSx4BemDm', 2, 'Open', 8, CURRENT_TIMESTAMP, 'admin'),
('Ethan Martinez', '9012345678', 'ethan.martinez@example.com', '$2a$10$aWwDHNuEokHATx.68lO2EO/mZUv4CYcgyoqyPilffp.9MSx4BemDm', 2, 'Open', 9, CURRENT_TIMESTAMP, 'admin'),
('Ava Robinson', '0123456789', 'ava.robinson@example.com', '$2a$10$aWwDHNuEokHATx.68lO2EO/mZUv4CYcgyoqyPilffp.9MSx4BemDm', 2, 'Open', 10, CURRENT_TIMESTAMP, 'admin'),
('Liam Taylor', '9876543210', 'liam.taylor@example.com', '$2a$10$aWwDHNuEokHATx.68lO2EO/mZUv4CYcgyoqyPilffp.9MSx4BemDm', 2, 'Open', 11, CURRENT_TIMESTAMP, 'admin'),
('Emma White', '8765432109', 'emma.white@example.com', '$2a$10$aWwDHNuEokHATx.68lO2EO/mZUv4CYcgyoqyPilffp.9MSx4BemDm', 2, 'Open', 12, CURRENT_TIMESTAMP, 'admin'),
('Noah Anderson', '7654321098', 'noah.anderson@example.com', '$2a$10$aWwDHNuEokHATx.68lO2EO/mZUv4CYcgyoqyPilffp.9MSx4BemDm', 2, 'Open', 13, CURRENT_TIMESTAMP, 'admin'),
('Isabella Jackson', '6543210987', 'isabella.jackson@example.com', '$2a$10$aWwDHNuEokHATx.68lO2EO/mZUv4CYcgyoqyPilffp.9MSx4BemDm', 2, 'Open', 14, CURRENT_TIMESTAMP, 'admin'),
('Lucas Harris', '5432109876', 'lucas.harris@example.com', '$2a$10$aWwDHNuEokHATx.68lO2EO/mZUv4CYcgyoqyPilffp.9MSx4BemDm', 2, 'Open', 15, CURRENT_TIMESTAMP, 'admin'),
('Mia Garcia', '4321098765', 'mia.garcia@example.com', '$2a$10$aWwDHNuEokHATx.68lO2EO/mZUv4CYcgyoqyPilffp.9MSx4BemDm', 2, 'Open', 16, CURRENT_TIMESTAMP, 'admin'),
('Aiden Davis', '3210987654', 'aiden.davis@example.com', '$2a$10$aWwDHNuEokHATx.68lO2EO/mZUv4CYcgyoqyPilffp.9MSx4BemDm', 2, 'Open', 17, CURRENT_TIMESTAMP, 'admin'),
('Amelia Wilson', '2109876543', 'amelia.wilson@example.com', '$2a$10$aWwDHNuEokHATx.68lO2EO/mZUv4CYcgyoqyPilffp.9MSx4BemDm', 2, 'Open', 18, CURRENT_TIMESTAMP, 'admin'),
('Carter Taylor', '1098765432', 'carter.taylor@example.com', '$2a$10$aWwDHNuEokHATx.68lO2EO/mZUv4CYcgyoqyPilffp.9MSx4BemDm', 2, 'Open', 19, CURRENT_TIMESTAMP, 'admin'),
('Harper Robinson', '0987654321', 'harper.robinson@example.com', '$2a$10$aWwDHNuEokHATx.68lO2EO/mZUv4CYcgyoqyPilffp.9MSx4BemDm', 2, 'Open', 20, CURRENT_TIMESTAMP, 'admin');


INSERT INTO products(product_name, category_id, description, price, product_img, created_at, created_by)
VALUES
('Cà chua beef', 1, 'Công dụng: Cà chua có kích thước và màu sắc hấp dẫn, hương vị ngon ngọt và hàm lượng dinh dưỡng phong phú. Cà chua mang một số lợi ích tuyệt vời đối với sức khỏe như: tăng cường sức khỏe tim mạch, ngăn ngừa ung thư, tốt cho chăm sóc tóc và da.', 55000, 'https://res.cloudinary.com/drdtpudrn/image/upload/v1701956406/Fruit_Vegetables14_om7jc4.jpg', '2023-03-01', 'freshshop'),
('Cà chua bi cherry', 1, 'Xuất xứ: Trang trại tại Xuân Thành, Lâm Đồng, Việt Nam.', 58000, 'https://res.cloudinary.com/drdtpudrn/image/upload/v1701957803/Fruit_Vegetables13_uhddyh.jpg', '2023-03-02', 'freshshop'),
('Cà chua bi socola', 1, 'Công dụng: Cà chua có kích thước và màu sắc hấp dẫn, hương vị ngon ngọt và hàm lượng dinh dưỡng phong phú. Cà chua mang một số lợi ích tuyệt vời đối với sức khỏe như: tăng cường sức khỏe tim mạch, ngăn ngừa ung thư, tốt cho chăm sóc tóc và da.', 60000, 'https://res.cloudinary.com/drdtpudrn/image/upload/v1701956454/Fruit_Vegetables12_yohnyh.jpg', '2023-03-03', 'freshshop'),
('Dưa leo hữu cơ', 1, 'Xuất xứ: Trang trại tại Long Thành, Đồng Nai, Việt Nam.', 62000, 'https://res.cloudinary.com/drdtpudrn/image/upload/v1701956463/Fruit_Vegetables11_rqqukj.jpg', '2023-04-01', 'freshshop'),
('Bầu hữu cơ', 1, 'Xuất xứ: Trang trại tại Long Thành, Đồng Nai, Việt Nam.', 59000, 'https://res.cloudinary.com/drdtpudrn/image/upload/v1701956486/Fruit_Vegetables10_ktrpxj.png', '2023-04-02', 'freshshop'),
('Khổ qua hữu cơ', 1, 'Công dụng: Lượng vitamin C trong khổ qua giúp tăng sức đề kháng cho cơ thể, kháng viêm tốt, ngăn ngừa và có tác dụng tiêu diệt tế bào ung thư. Kali trong khổ qua chứa có tác dụng giảm huyết áp, beta-carotene giúp sáng mắt, giúp điều trị chứng trào ngược axit và chứng khó tiêu.', 45000, 'https://res.cloudinary.com/drdtpudrn/image/upload/v1701956560/Fruit_Vegetables09_sir1h1.png', '2023-04-03', 'freshshop'),
('Cà chua Hà Lan', 1, 'Công dụng: Cà chua có kích thước và màu sắc hấp dẫn, hương vị ngon ngọt và hàm lượng dinh dưỡng phong phú. Cà chua mang một số lợi ích tuyệt vời đối với sức khỏe như: tăng cường sức khỏe tim mạch, ngăn ngừa ung thư, tốt cho chăm sóc tóc và da.', 55000, 'https://res.cloudinary.com/drdtpudrn/image/upload/v1701956559/Fruit_Vegetables08_we19x1.jpg', '2023-05-01', 'freshshop'),
('Dưa leo hữu cơ', 1, 'Công dụng: Dưa leo chứa hàm lượng calo thấp nhưng lại rất giàu dưỡng chất quan trọng cho cơ thể. Ngoài hàm lượng nước cao thì dưa leo chứa rất nhiều vitamin, khoáng chất đa dạng như vitamin C, K, magie, kali, mangan… Do đó, bạn có thể cung cấp vitamin và khoáng chất hiệu quả bằng cách ăn dưa leo mỗi ngày.', 62000, 'https://res.cloudinary.com/drdtpudrn/image/upload/v1701956560/Fruit_Vegetables07_qhwogm.jpg', '2023-05-02', 'freshshop'),
('Bí ngòi', 1, 'Hướng dẫn sử dụng: Bí xanh có thể ăn sống hoặc chế biến thành nhiều món ăn khác nhau như bí xanh nấu tôm, bí om cá, bí xào nấm hay bí xanh hấp, bí nướng ... Ngoài ra, loại bí này còn được nhiều mẹ đưa vào khẩu phần ăn cho bé bởi những dưỡng chất cần thiết giúp ngăn ngừa táo bón hiệu quả.', 47000, 'https://res.cloudinary.com/drdtpudrn/image/upload/v1701956561/Fruit_Vegetables06_vprj3i.png', '2023-05-03', 'freshshop'),
('Ớt chuông', 1, 'Ớt chuông là một loại quả có hình dạng giống chuông, thường có màu đỏ, vàng hoặc xanh lá cây. Nó có vị ngọt, mềm mại và không quá cay, là một thành phần phổ biến trong nhiều món ăn, từ món salad cho đến món nướng.', 54000, 'https://res.cloudinary.com/drdtpudrn/image/upload/v1701956561/Fruit_Vegetables05_epobo6.jpg', '2023-05-04', 'freshshop'),
('Đậu cove', 1, 'Xuất xứ: Trang trại tại MaxOrganic, Đà Lạt, Lâm Đồng.', 55000, 'https://res.cloudinary.com/drdtpudrn/image/upload/v1701956562/Fruit_Vegetables04_memzer.jpg', '2023-05-05', 'freshshop');

INSERT INTO products(`product_name`, `category_id`, `description`, `price`, `product_img`, `created_at`, `created_by`)
VALUES
('Dưa leo gai', 1, 'Công dụng: Dưa leo chứa hàm lượng calo thấp nhưng lại rất giàu dưỡng chất quan trọng cho cơ thể. Ngoài hàm lượng nước cao thì dưa leo chứa rất nhiều vitamin, khoáng chất đa dạng như vitamin C, K, magie, kali, mangan… Do đó, bạn có thể cung cấp vitamin và khoáng chất hiệu quả bằng cách ăn dưa leo mỗi ngày.', 58000, 'https://res.cloudinary.com/drdtpudrn/image/upload/v1701957978/Fruit_Vegetables03_plftbt.jpg', CURDATE(), 'freshshop'),
('Dưa leo baby', 1, 'Công dụng: Dưa leo Baby chứa hàm lượng calo thấp nhưng lại rất giàu dưỡng chất quan trọng cho cơ thể. Ngoài hàm lượng nước cao thì dưa leo chứa rất nhiều vitamin, khoáng chất đa dạng như Vitamin C, K, Magie, Kali, Mangan… Do đó, bạn có thể cung cấp Vitamin và khoáng chất hiệu quả bằng cách ăn dưa leo mỗi ngày.', 50000, 'https://res.cloudinary.com/drdtpudrn/image/upload/v1701957979/Fruit_Vegetables02_jaumna.jpg', CURDATE(), 'freshshop'),
('Bí đỏ hữu cơ', 1, 'Công dụng: Bí đỏ là thực phẩm chứa nhiều chất xơ có tác dụng làm chậm tốc độ hấp thụ đường vào máu, cũng như thúc đẩy nhu động ruột thường xuyên và tiêu hóa trơn tru hơn. Với hàm lượng vitamin, khoáng chất và chất chống oxy hóa cao, bí đỏ hỗ trợ tăng cường hệ thống miễn dịch, bảo vệ thị lực, giảm nguy cơ mắc một số bệnh ung thư và tăng cường sức khỏe của trái tim và làn da.', 95000, 'https://res.cloudinary.com/drdtpudrn/image/upload/v1701957980/Fruit_Vegetables01_dasbj2.jpg', CURDATE(), 'freshshop'),
('Xà lách romanie', 1, 'Công dụng: Xà lách Romaine giàu Vitamin A, Vitamin K, Vitamin C, Magiê, chất xơ và ít protein. Xà lách Romaine có tác dụng hỗ trợ tiêu hóa và tốt cho gan, giảm nguy cơ mắc bệnh tim mạch, các cơn nhồi máu cơ tim, ung thư, nứt cột sống, thiếu máu, chứng mất ngủ do căng thẳng. Ngoài ra Vitamin C và Beta – Carotene kết hợp với nhau để phòng chống sự oxy hóa.', 32250, 'https://res.cloudinary.com/drdtpudrn/image/upload/v1701958084/Leafy_Vegetables15_zsnuua.png', CURDATE(), 'freshshop'),
('Cải xoăn kale', 1, 'Công dụng: Kale được ví là siêu thực phẩm với những công dụng tuyệt vời của nó: ít calo - giúp kiểm soát cân nặng, có đặc tính thanh lọc, giàu vitamin A, K - giúp giảm xơ vữa động mạch, giàu folate - giúp phát triển não bộ, giàu chất xơ, giàu sắt nên có thể thay thế nguồn thịt bò.', 63000,'https://res.cloudinary.com/drdtpudrn/image/upload/v1701958083/Leafy_Vegetables14_hawyua.jpg', CURDATE(), 'freshshop'),
('Cần tây', 1, 'Công dụng: Không chỉ là loại rau dễ dàng kết hợp với nhiều món ăn, cần tây còn được ví như “cây thuốc quý” đa năng có thể phòng chống nhiều chứng bệnh nguy hiểm, kể cả ung thư. Trong cần tây có lượng canxi, sắt, phốt pho, protid nhiều gấp đôi so với các loại rau khác. Các axít amin tự do, tinh dầu, mannitol, inositol, các loại vitamin trong cần tây hỗ trợ tuần hoàn máu, tăng cường khả năng miễn dịch và bổ não. Những người mắc bệnh thiếu máu, bệnh Hodgkin (Bệnh Hodgkin là một loại ung thư hạch, bệnh ung thư máu bắt đầu trong hệ bạch huyết), các chứng xuất huyết uống nước ép cần tây sẽ rất hiệu quả trong điều trị bệnh, do cần tây chứa nhiều magnesium và sắt. Các chất xơ trong cần tây giúp loại bỏ cholesterol trong máu, cải thiện sức khỏe tim mạch.', 97500,'https://res.cloudinary.com/drdtpudrn/image/upload/v1701958088/Leafy_Vegetables12_aytkmf.png', CURDATE(), 'freshshop'),
('Cải ngồng hữu cơ', 1, 'Công dụng: Cải ngồng rất tốt cho phụ nữ bởi nó chứa nhiều dinh dưỡng thiết yếu giúp ngăn ngừa hàm lượng estrogen dư thừa trong cơ thể có thể dẫn đến ung thư. Chất folate và chất xơ trong cải ngồng đều cần thiết cho sức khỏe của phụ nữ.', 25500,'https://res.cloudinary.com/drdtpudrn/image/upload/v1701958086/Leafy_Vegetables11_ckvguc.png', CURDATE(), 'freshshop'),
('Cải thìa hữu cơ', 1, 'Công dụng: Cải thìa là loại rau rất gần gũi với các món ăn của người Việt Nam và Trung Hoa. Rau giòn, vị ngon, ngọt. Cải thìa có chứa folate, kali và canxi giúp xương chắc khỏe. Các chất thuộc nhóm carotenoid trong cải thìa có tác dụng như chất làm chậm quá trình oxi hóa và giảm việc hình thành những nguồn gốc có hại trong cơ thể.', 25500,'https://res.cloudinary.com/drdtpudrn/image/upload/v1701958090/Leafy_Vegetables10_epotse.png', CURDATE(), 'freshshop'),
('Đọt bí đỏ hữu cơ', 1, 'Công dụng: Đọt bí đỏ chứa một lượng vitamin phong phú như vitamin A, vitamin C, vitamin B6.., mang đến nhiều lợi ích cho da. Chất xơ hoà tan trong đọt bí giúp giảm sự hấp thụ cholesterol và axit mật từ ruột non, từ đó làm giảm lượng cholesterol trong máu. Ngoài ra, lượng folate dồi dào có trong rau bí đỏ cũng rất cần thiết cho việc sản xuất các tế bào hồng cầu.', 28500, 'https://res.cloudinary.com/drdtpudrn/image/upload/v1701958091/Leafy_Vegetables09_tank0l.jpg', CURDATE(), 'freshshop'),
('Rau muống hữu cơ', 1, 'Công dụng: Đến 99% người Việt Nam biết về rau muống là một loại rau ăn, quen thuộc và rất gần gũi, gần như tuần nào các gia đình cũng có nó trong bữa ăn. Tuy nhiên, ít ai biết rau muống có nhiều tác dụng tốt như giảm cholesterol, trị vàng da, chữa khó tiêu, táo bón, thiếu máu, phòng chống bệnh tiểu đường, bảo vệ tim mạch,…', 25500,'https://res.cloudinary.com/drdtpudrn/image/upload/v1701958096/Leafy_Vegetables08_pfotr3.jpg', CURDATE(), 'freshshop'),
('Rau dền hữu cơ', 1, 'Công dụng: Ngoài việc là một món ăn ngon, vị ngọt thanh mát, giàu sắt, rau dền còn là vị thuốc tốt giúp điều trị nhiều bệnh thường gặp. Theo y học cổ truyền, rau dền đỏ có vị ngọt, tính mát, tác dụng thanh nhiệt, làm mát máu, lợi tiểu, sát trùng, trị nhiệt lỵ, huyết nhiệt sinh mụn nhọt,... Rau dền đỏ chứa nhiều protid, glucid, nhiều vitamin và chất khoáng.', 25500, 'https://res.cloudinary.com/drdtpudrn/image/upload/v1701958097/Leafy_Vegetables07_fbiyf8.jpg', CURDATE(), 'freshshop'),
('Mồng tơi hữu cơ', 1, 'Công dụng: Mồng tơi không chỉ là món rau thông thường, trong dân gian rau mồng tơi còn các tác dụng chữa bệnh. Theo đông y, rau mồng tơi có tính hàn, vị chua, tán nhiệt, mất máu, lợi tiểu, giải độc, đẹp da, trị rôm sảy mụn nhọt hiệu quả… rất thích hợp trong mùa nóng. Theo các nghiên cứu cho thấy, trong mồng tơi chứa chất nhầy pectin rất quý để phòng chữa nhiều bệnh, làm cho rau mồng tơi có tác dụng nhuận tràng, thải chất béo chống béo phì, thích hợp cho người có mỡ và đường cao trong máu.', 25500,  'https://res.cloudinary.com/drdtpudrn/image/upload/v1701958099/Leafy_Vegetables06_qwa2a0.jpg', CURDATE(), 'freshshop'),
('Cải nhún hữu cơ', 1, 'Xuất xứ: Trang trại tại Long Thành, Đồng Nai, Việt Nam.', 25500,'https://res.cloudinary.com/drdtpudrn/image/upload/v1701958094/Leafy_Vegetables05_knkvup.jpg', CURDATE(), 'freshshop'),
('Cải ngọt hữu cơ', 1, 'Công dụng: Cải ngọt có hơn 10 loại vitamin cần thiết cho cơ thể, trong đó, hàm lượng canxi, vitamin A và vitamin K rất dồi dào, với một lượng đáng kể vitamin B9 và vitamin E. Chính vì thế, rau cải ngọt còn có tác dụng nâng cao sức đề kháng, bảo vệ cơ thể khỏi các tác nhân gây bệnh.', 25500, 'https://res.cloudinary.com/drdtpudrn/image/upload/v1701958101/Leafy_Vegetables04_zej3gv.png', CURDATE(), 'freshshop'),
('Rau đay Hữu cơ', 1, 'Công dụng: Rau đay chứa nhiều dưỡng chất có lợi cho hệ tiêu hóa. Đặc biệt, chất nhớt trong rau đay là một phương thuốc tự nhiên chống lại các triệu chứng táo bón, và có nhiều axit hữu cơ chống kháng viêm. Ngoài ra, rau đay có tính hàn nên thường được dùng vào những ngày nắng nóng, oi bức.', 25500, 'https://res.cloudinary.com/drdtpudrn/image/upload/v1701958104/Leafy_Vegetables03_ja1qnu.jpg', CURDATE(), 'freshshop'),
('Cải bẹ xanh hữu cơ', 1, 'Công dụng: Cải bẹ xanh có lượng calorie thấp nhưng lại nhiều chất xơ cùng các vitamin và khoáng chất thiết yếu. Đặc biệt, chúng là nguồn cung cấp vitamin C và K dồi dào. Theo y học cổ truyền, cải bẹ xanh có vị cay, tính ôn với tác dụng thanh nhiệt, giải độc, giải cảm hàn, thông đàm, lợi khí và lợi tiểu.', 25500, 'https://res.cloudinary.com/drdtpudrn/image/upload/v1701958106/Leafy_Vegetables02_ukjbww.png', CURDATE(), 'freshshop'),
('Cải bẹ hữu cơ (Trắng)', 1, 'Gợi ý sử dụng: Có thể luộc, xào hay nấu canh cùng mọc heo, thịt xay, cá thác lác...', 25500,'https://res.cloudinary.com/drdtpudrn/image/upload/v1701958108/Leafy_Vegetables01_cdotyu.jpg', CURDATE(), 'freshshop');

-- fruit
INSERT INTO products(`product_name`, `category_id`, `description`, `price`, `product_img`, `created_at`, `created_by`)
VALUES
('Nho Đen Nam Phi', '2', 'Nhập khẩu trực tiếp từ Nam Phi. Không dùng chất bảo quản. Cuống tươi, xanh, trái giòn và ngọt đậm vịHàm lượng dinh dưỡng cao. 100% nói không với chất bảo quản & trái cây Trung Quốc. Đổi trả sản phẩm trong vòng 24h', '329000',  'https://res.cloudinary.com/drdtpudrn/image/upload/v1701958527/fruit17_sb5rko.png', CURDATE(), 'freshshop'),
('Kiwi Vàng New Zealand', '2', 'Kiwi vàng New Zealand là loại quả ngon nhất thế giới. Quy trình từ trồng, chăm bón đến thu, hái, vận chuyển được chính phủ New Zealand kiểm soát rất chặt chẽ. Kiwi vàng có vị ngọt mát, chua dịu rất đặc trưng. Chứa nhiều chất dinh dưỡng bổ ích cho cơ thể. 100% nói không với chất bảo quản & nói không với trái cây Trung Quốc. Đổi trả sản phẩm trong vòng 24h', '329000','https://res.cloudinary.com/drdtpudrn/image/upload/v1701958523/fruit16_jtvyvl.jpg', CURDATE(), 'freshshop'),
('Táo Đỏ Sekai Ichi Nhật', '2', 'Nhập khẩu trực tiếp từ Nhật Bản. Được đánh giá là loại táo khủng nhất và có giá thành cao trên thế giới. Vỏ màu đỏ, thơm mùi đặc trưng, giòn và ngọt nước. Được trồng 100% bằng thủ công, đảm bảo an toàn tuyệt đối cho sức khỏe 100% nói không với chất bảo quản & nói không với trái cây Trung Quốc. Đổi trả sản phẩm trong vòng 24h', '349000', 'https://res.cloudinary.com/drdtpudrn/image/upload/v1701958544/fruit15_spicxd.jpg', CURDATE(), 'freshshop'),
('Chà Là Khô Natural Delights Organic Medjool Dates (Hộp Xanh)', '2', 'Chà là Natural Delights Organic Medjool Dates có thành phần 100% chà là tự nhiên. Được thiết kế trong hộp nhựa gọn nhẹ, có thể làm quà tặng Natural Delights có vị ngọt nhẹ, không cho thêm chất làm ngọt, bùi và mùi hương dịu nhẹ', '350000', 'https://res.cloudinary.com/drdtpudrn/image/upload/v1701958531/fruit14_uxewf9.png', CURDATE(), 'freshshop'),
('Táo Envy Size 24 Mỹ', '2', 'Nhập khẩu trực tiếp từ Mỹ. Táo Envy Mỹ là giống táo ngon nhất thế giới. Khi ăn, táo có mùi thơm đậm, ăn cảm giác rất ngọt và thanh mát. Chứa nhiều chất dinh dưỡng như B1, B2, Vitamin C, Canxi,…Táo giúp nạp ít lượng calo, phù hợp để giảm cân. 100% nói không với chất bảo quản & nói không với trái cây Trung Quốc. Đổi trả sản phẩm trong vòng 24h', '380000', 'https://res.cloudinary.com/drdtpudrn/image/upload/v1701958536/fruit13_l91cqz.png', CURDATE(), 'freshshop'),
('Hồng Mật Sấy Dẻo Hàn Quốc', '2', 'Món quà sang trọng, truyền thống của người Hàn Quốc. Hương vị rất lạ, mềm, dẻo. Giữ nguyên được hương vị tự nhiên của hồng tươi. Đóng gói sang trọng. Hàng nhập khẩu trực tiếp từ Hàn Quốc', '155000','https://res.cloudinary.com/drdtpudrn/image/upload/v1701958546/fruit12_knt2lu.png', CURDATE(), 'freshshop'),
('Dâu Tây 330g Hàn Quốc (Hộp)', '2', 'Trái có kích thước lớn, màu sắc đỏ tươi, cuống tươi xanh. Mùi vị rất thơm, có vị ngọt thanh tự nhiên. Trái cây mọng, không bị dập nát. Trọng lượng là 330gr/hộp. Nhập khẩu trực tiếp từ Hàn Quốc. 100% nói không với chất bảo quản & trái cây Trung Quốc. Đổi trả sản phẩm trong vòng 24h', '399000',  'https://res.cloudinary.com/drdtpudrn/image/upload/v1701958537/fruit11_xrbg9a.jpg', CURDATE(), 'freshshop'),
('Lựu Peru', '2', 'Trái có kích thước lớn, màu sắc đỏ tươi, cuống tươi xanh. Mùi vị rất thơm, có vị ngọt thanh tự nhiên. Trái cây mọng, không bị dập nátTrọng lượng là 330gr/hộp. Nhập khẩu trực ', '399000',  'https://res.cloudinary.com/drdtpudrn/image/upload/v1701958541/fruit10_fpmglk.jpg', CURDATE(), 'freshshop'),
('Dưa Lưới Fuji Giống Nhật', '2', 'Loại dưa được trồng, chăm sóc trực tiếp bởi người Nhật, là loại dưa ngon THỨ 2 ở Nhật. Tiêu chuẩn xuất khẩu đi các thị trường EU, Hong Kong và Mỹ. Độ ngọt (brix) từ 19. Trái tiêu chuẩn 1.26kg/ trái. Canh tác 100% theo hướng hữu cơ, an toàn tuyệt đối. Thích hợp để ăn và để biếu rất sang trọng. 100% nói không với chất bảo quản & trái cây Trung Quốc. Đổi trả sản phẩm trong vòng 24h', '399000',  'https://res.cloudinary.com/drdtpudrn/image/upload/v1701958882/fruit09_p5ar2l.png', CURDATE(), 'freshshop'),
('Mận Đỏ Chile', '2', 'Nhập khẩu trực tiếp từ Chile. Trái mận lớn, vỏ bóng đẹp màu đỏ đen hoặc màu hổ phách. Vị giòn ngọt xen kẽ chua đặc trưng, không có vị đắng hay chat. Chứa nhiều chất dinh dưỡng bổ ích cho cơ thể. 100% nói không với chất bảo quản & nói không với trái cây Trung Quốc. Đổi trả sản phẩm trong vòng 24h', '399000', 'https://res.cloudinary.com/drdtpudrn/image/upload/v1701958883/fruit08_wzdwo6.jpg', CURDATE(), 'freshshop'),
('Nho Xanh Úc', '2', 'Chủng Thompson Seedless, quả to, thuôn dài. Màu xanh hổ phách, vị ngọt mát, rất giòn, không hạt. Nhập khẩu trực tiếp từ Úc', '439000', 'https://res.cloudinary.com/drdtpudrn/image/upload/v1701958958/fruit07_edhhqn.png', CURDATE(), 'freshshop'),
('Táo Vàng Kinsei Nhật', '2', 'Nhập khẩu trực tiếp từ Nhật. Lớp vỏ vàng căng bóng, có lấm tấm đốm đen. Vị ngọt mát dịu, giòn xốp, mọng nước và thơm nhẹ. Chứa nhiều chất dinh dưỡng như B1, B2, Vitamin C, Canxi,…Táo giúp nạp ít lượng calo, phù hợp để giảm cân. 100% nói không với chất bảo quản & nói không với trái cây Trung Quốc. Đổi trả sản phẩm trong vòng 24h ', '439000','https://res.cloudinary.com/drdtpudrn/image/upload/v1701958898/fruit06_qrucjr.jpg', CURDATE(), 'freshshop'),
('Dưa Lê Hàn Quốc', '2', 'Dưa lê là sự pha trộn đặc biệt giữa dưa ngọt và dưa chuột. Phần thịt trắng, ngon ngọt, hạt nhỏ màu trắng. Chưa nhiều dưỡng chất và rất tốt cho phụ nữ mang thai. 100% nói không với chất bảo quản & trái cây Trung Quốc. Đổi trả sản phẩm trong vòng 24h ', '499000', 'https://res.cloudinary.com/drdtpudrn/image/upload/v1701958908/fruit05_oihnzq.jpg', CURDATE(), 'freshshop'),
('Hồng New Zealand', '2', 'Hồng giòn New Zealand được trồng ở Walkato, Northland thuộc phía bắc thành phố Auckland, New Zealand. Trái Hồng New Zealand to, màu vàng sẫm, trọng lượng từ 200 đến gần 400gram/trái. Hồng giòn New Zealand có vị ngọt đậm và giòn tan, có mùi thơm dịu nhẹ, đặc trưng. Chứa nhiều chất dinh dưỡng bổ ích cho cơ thể. 100% nói không với chất bảo quản & nói không với trái cây Trung Quốc. Đổi trả sản phẩm trong vòng 24h ', '599000',  'https://res.cloudinary.com/drdtpudrn/image/upload/v1701958913/fruit04_f1tfs3.jpg', CURDATE(), 'freshshop'),
('Lựu Ấn Độ', '2', 'Nhập khẩu trực tiếp từ Ấn Độ. Được đánh giá là loại lựu ngon nhất thế giới. Vỏ mỏng, ăn có vị ngọt thanh, ít chua. Hạt lựu màu đỏ thẫm, nhiều nước. Chứa nhiều chất dinh dưỡng bổ ích cho cơ thể. 100% nói không với chất bảo quản & nói không với trái cây Trung Quốc. Đổi trả sản phẩm trong vòng 24h ', '599000',  'https://res.cloudinary.com/drdtpudrn/image/upload/v1701958891/fruit03_st1vip.png', CURDATE(), 'freshshop'),
('Sầu riêng Musang King Malaysia', '2', 'Sầu riêng Musan King loại sầu riêng thuộc hàng ngon nhất, múi to còn hạt thì cực lép. Không quá ngọt nhưng độ béo vượt trội. Múi màu vàng nghệ và mịn màng. Đóng gói quy chuẩn: hộp 400gSầu riêng chuẩn Musang King (giống D197). Nhập khẩu trực tiếp từ Malaysia. Không bán SẦU RIÊNG GIẢ Musang Malaysia khác. 100% nói không với chất bảo quản & trái cây Trung Quốc. Đổi trả sản phẩm trong vòng 24h ', '669000', 'https://res.cloudinary.com/drdtpudrn/image/upload/v1701958926/fruit02_i9xcuv.jpg', CURDATE(), 'freshshop'),
('Cherry Đỏ Mỹ', '2', 'Màu đỏ sẫm, cuống tươi xanh. Vị ngọt, xen lẫn vị chua nhẹ. Trái cứng, giòn. Nhập khẩu trực tiếp từ Mỹ ', '790000', 'https://res.cloudinary.com/drdtpudrn/image/upload/v1701958920/fruit01_cu7kzv.jpg', CURDATE(), 'freshshop');

INSERT INTO products(`product_name`, `category_id`, `description`, `price`, `product_img`, `created_at`, `created_by`)
VALUES
('Nho Khô Raisins Sunview Mix Mỹ', '2', 'Nho Khô Đen Không Hạt Sunview là một trong những loại nho khô được nhập khẩu trực tiếp từ Mỹ. Sấy khô trên công nghệ hiện đại, hoàn toàn không thêm chất phụ gia và đường hóa học. Phần thịt mềm, dày thịt và có vị ngọt vừa phải', '155000', 'https://res.cloudinary.com/drdtpudrn/image/upload/v1701958416/fruit29_dtldfx.jpg', '2023-03-01', 'freshshop'),
('Táo Ambrosia size 88 Mỹ', '2', 'Táo có những trái táo màu đỏ tươi trên nền vàng kem. Hương vị ngọt ngào, giòn, nhiều nước và thơm. Cung cấp nhiều Vitamin, khoáng chất, nâng cao sức đề khángNhập khẩu trực tiếp từ Mỹ 100% nói không với chất bảo quản & trái cây Trung Quốc. Đổi trả sản phẩm trong vòng 24h', '169000', 'https://res.cloudinary.com/drdtpudrn/image/upload/v1701958419/fruit28_grabti.png', '2023-03-02', 'freshshop'),
('Dưa Lưới Đài Loan', '2', 'Trái dưa to đều, thon dài, căng mọng, vỏ dưa màu xanh tươi mát, không quá đậm hoặc quá nhạt. Trên da quả có những đường gân đặc trưng của dòng dưa lưới bắt mắt. Ruột có màu vàng nhạt, khi chín sẽ có màu vàng đậm hơn. Dưa mang hương vị tươi ngon, thanh mát, giòn tan và ngọt ngào. 100% nói không với chất bảo quản & nói không với trái cây Trung Quốc. Đổi trả sản phẩm trong vòng 24h', '169000', 'https://res.cloudinary.com/drdtpudrn/image/upload/v1701958419/fruit27_yz4rrt.jpg', '2023-03-03', 'freshshop'),
('Chà Là Khô Nguyên Cành 500g Israel', '2', 'Chà là nguyên cành Deglet Nour Israel 500g được nhập khẩu trực tiếp tại Israel. Đảm bảo vị ngọt dẻo tự nhiên, không chứa đường, hương vị nhân tạo phẩm màu, an toàn tuyệt đối cho sức khỏe. Là món quà biếu được nhiều người chọn lựa vừa thể hiện được sự sang trọng mà đây còn là thức quả đầy bổ dưỡng. 100% nói không với chất bảo quản & nói không với trái cây Trung Quốc. Đổi trả sản phẩm trong vòng 24h', '169000', 'https://res.cloudinary.com/drdtpudrn/image/upload/v1701958424/fruit26_gkgoek.png', '2023-04-01', 'freshshop'),
('Táo Juliet Organic 88 Pháp', '2', 'Táo Juliet Organic là táo hữu cơ, thơm, vị đặc trưng riêng, ngọt và thơm.', '189000', 'https://res.cloudinary.com/drdtpudrn/image/upload/v1701958425/fruit25_dhnqgw.jpg', '2023-04-02', 'freshshop'),
('Cam vàng Navel Mỹ', '2', 'Nhập khẩu trực tiếp từ Mỹ. Quả to, ngoài vỏ màu vàng tươi. Vị ngọt, không hạt, mọng nước, tép dày. Ăn trực tiếp hoặc ép lấy nước đều ngon. 100% nói không với chất bảo quản & trái cây Trung Quốc. Đổi trả sản phẩm trong vòng 24h', '189000', 'https://res.cloudinary.com/drdtpudrn/image/upload/v1701958428/fruit24_prpgzk.jpg', '2023-05-01', 'freshshop'),
('Lê Hàn Quốc', '2','Hàng loại 1, khối lượng trung bình từ 650g – 700g/ trái. Lê chuẩn gốc Hàn Quốc, quả to, tươi ngon, đi biếu tặng rất sang. Lê nhiều nước, giòn và ngọt, vỏ mỏng, màu nâu hấp dẫn. 100% nói không với chất bảo quản & trái cây Trung Quốc. Đổi trả sản phẩm trong vòng 24h', '199000', 'https://res.cloudinary.com/drdtpudrn/image/upload/v1701958434/fruit23_j1j9pp.jpg', '2023-05-02', 'freshshop'),
('Quýt Úc', '2', 'Trồng và nhập khẩu trực tiếp từ Úc. Vỏ màu vàng tươi, vị ngọt xen chút chua nhẹTép thịt mọng nước và không bị sượngTrái có hạt và dễ bóc vỏ. Chứa nhiều vitamin C tốt cho da, giúp tăng cường sức đề kháng và hồi phục sức khỏe nhanh. Khối lượng trung bình khoảng 5 – 6 trái/ kg100% nói không với chất bảo quản & trái cây Trung Quốc. Đổi trả sản phẩm trong vòng 24h', '199000','https://res.cloudinary.com/drdtpudrn/image/upload/v1701958438/fruit22_izqywh.jpg', '2023-05-03', 'freshshop'),
('Táo Rockit New Zealand', '2', 'Táo Rockit là dòng táo có nguồn gốc xuất xứ từ vịnh Hawke của New Zealand với hình dáng nhỏ, vỏ ngoài màu hồng đậm pha chút sắc vàng; có tác dụng giảm cân, đẹp da, rất được nhiều chị em phụ nữ ưa chuộng', '250000', 'https://res.cloudinary.com/drdtpudrn/image/upload/v1701958431/fruit21_qgjxyn.jpg', '2023-05-04', 'freshshop'),
('Táo Envy Size 88 Mỹ', '2', 'Nhập khẩu trực tiếp từ Mỹ. Táo Envy Mỹ là giống táo ngon nhất thế giới. Khi ăn, táo có mùi thơm đậm, ăn cảm giác rất ngọt và thanh mát. Chứa nhiều chất dinh dưỡng như B1, B2, Vitamin C, Canxi,…Táo giúp nạp ít lượng calo, phù hợp để giảm cân. 100% nói không với chất bảo quản & nói không với trái cây Trung Quốc. Đổi trả sản phẩm trong vòng 24h', '299000', 'https://res.cloudinary.com/drdtpudrn/image/upload/v1701958441/fruit20_bpqb0r.jpg', '2023-05-05', 'freshshop'),
('Chà Là Khô Natural Delights Whole 340g Mỹ (Hộp Đỏ)', '2', 'Chà là Natural delights có thành phần 100% chà là tự nhiên. Được thiết kế trong hộp nhựa gọn nhẹ, có thể làm quà tặngNatural Delights có vị ngọt nhẹ, không cho thêm chất làm ngọt, bùi và mùi hương dịu nhẹ', '299000', 'https://res.cloudinary.com/drdtpudrn/image/upload/v1701958519/fruit19_jffjpr.png', '2023-05-06', 'freshshop'),
('Dâu Tây 200g Hàn Quốc (Hộp)', '2', 'Trái có kích thước lớn, màu sắc đỏ tươi, cuống tươi xanh. Mùi vị rất thơm, có vị ngọt thanh tự nhiênTrái cây mọng, không bị dập nát. Trọng lượng là 200gr/hộp. Nhập khẩu trực tiếp từ Hàn Quốc100% nói không với chất bảo quản & trái cây Trung Quốc. Đổi trả sản phẩm trong vòng 24h', '300000',  'https://res.cloudinary.com/drdtpudrn/image/upload/v1701958525/fruit18_ml9ib0.png', '2023-05-07', 'freshshop');

--
-- nuts
INSERT INTO products(`product_name`, `category_id`, `description`, `price`, `product_img`, `created_at`, `created_by`)
VALUES
('Hạt chia', 3, 'Hạt chia hữu cơ 100g', 139000, 'https://res.cloudinary.com/drdtpudrn/image/upload/v1701959236/chia_kebq3h.jpg', '2023-03-01', 'freshshop'),
('Hạt mắc ca', 3, 'Hạt mắc ca rang muối 200g', 229000, 'https://res.cloudinary.com/drdtpudrn/image/upload/v1701959256/macca_uskng0.jpg', '2023-03-02', 'freshshop'),
('Hạt hướng dương', 3, 'Hạt hướng dương không vỏ 500g', 91900, 'https://res.cloudinary.com/drdtpudrn/image/upload/v1701959251/huongduong_c1uwxu.jpg', '2023-03-03', 'freshshop'),
('Hạt điều', 3, 'Hạt điều rang muối 300g', 160900, 'https://res.cloudinary.com/drdtpudrn/image/upload/v1701959241/dieu_nmqian.jpg', '2023-04-01', 'freshshop'),
('Hạt hạnh nhân', 3, 'Hạt hạnh nhân hữu cơ 150g', 229900, 'https://res.cloudinary.com/drdtpudrn/image/upload/v1701959246/hanhnhanhuuco_nrjrvc.jpg', '2023-05-01', 'freshshop');

-- root vegetables
INSERT INTO products(`product_name`, `category_id`, `description`, `price`, `product_img`, `created_at`, `created_by`)
VALUES
('Cà rốt', '4', 'Xuất xứ: Đơn Dương, Lâm Đồng, Việt Nam', '44000', 'https://res.cloudinary.com/drdtpudrn/image/upload/v1701959404/Root_Vegetables15_xj2w14.png', '2023-03-01', 'freshshop'),
('Khoai lang', '4', 'Công dụng: Khoai lang giàu tinh bột, đường, chất xơ, Vitamin A dưới dạng beta-caroten và vitamin C, protein độc đáo có khả năng chống oxy hóa (antioxidant), vitamin B6, kali, sắt,… Do thành phần dinh dưỡng phong phú mà khoai lang có tác dụng rất tốt trong việc chống oxy hóa, kháng viêm cực công hiệu, tốt cho hệ tim mạch, ngăn chặn sự phát triển và hình thành các tế bào ung từ các gốc tự do.', '55000','https://res.cloudinary.com/drdtpudrn/image/upload/v1701959409/Root_Vegetables14_vpumza.jpg', '2023-03-15', 'freshshop'),
('Củ cải đỏ', '4', 'Công dụng: Trong củ cải đỏ chứa nhiều vitamin như vitamin A, B9, C (có nhiều nhất trong lá củ cải đỏ) và các khoáng chất cần thiết khác như: sắt, axit folic, kali, magie,... Màu củ cải đỏ là do chứa chất beta cyanin. Chất này có khả năng loại bỏ các độc tố có trong gan, giúp giải độc gan và ngăn chặn sự thành của các lớp mô mỡ trong cơ thể. Đồng thời, beta cyanin có trong củ cải đỏ còn rất tốt đối với bệnh tim mạch.', '63000','https://res.cloudinary.com/drdtpudrn/image/upload/v1701959414/Root_Vegetables13_vig0zj.jpg', '2023-04-02', 'freshshop'),
('Khoai tây', '4', 'Công dụng: Ngoài hàm lượng nước cao, khoai tây còn rất giàu carbohydrate và hàm lượng cao protein cũng như chất xơ giúp tiêu hoá dễ. Các vitamin C, vitamin B6, kali, magie, kẽm và photpho có trong khoai tây tốt cho da cũng như cần thiết hằng ngày cho cơ thể, giúp phòng chống cảm lạnh...', '52000', 'https://res.cloudinary.com/drdtpudrn/image/upload/v1701959420/Root_Vegetables12_mgdi6a.jpg', '2023-04-15', 'freshshop'),
('Tỏi hữu cơ', '4', 'Xuất xứ: Sản xuất tại trang trại Cổ Loa, Hà Nội.', '61000', 'https://res.cloudinary.com/drdtpudrn/image/upload/v1701959430/Root_Vegetables11_ooo06o.jpg', '2023-05-01', 'freshshop'),
('Hành tím hữu cơ', '4', 'Công dụng: Bổ sung các dưỡng chất thiết yếu cho cơ thể như vitamin C, vitamin B6, biotin, axit folic, chromium, canxi và chất xơ,...', '61000', 'https://res.cloudinary.com/drdtpudrn/image/upload/v1701959425/Root_Vegetables10_f33v3x.png', '2023-05-15', 'freshshop'),
('Hành tây khô', '4', 'Công dụng: Hành tây cung cấp một nguồn vitamin C, B6, sắt, kali và mangan để bảo vệ cơ thể khỏi cái lạnh và cảm cúm. Ngoài ra còn giàu Organosulfurs và các Flavonoid có thể giúp ngăn ngừa bệnh tim và tăng cường sức khỏe tim mạch. Nhờ chứa nhiều vitamin A, E và C mà hành tây có thể hỗ trợ tăng cường sức khỏe và bảo vệ da.', '60000',  'https://res.cloudinary.com/drdtpudrn/image/upload/v1701959468/Root_Vegetables09_plcuxo.png', '2023-05-30', 'freshshop'),
('Củ dền', '4', 'Xuất xứ: Trang trại tại Xuân Thành, Lâm Đồng, Việt Nam.', '31000',  'https://res.cloudinary.com/drdtpudrn/image/upload/v1701959461/Root_Vegetables08_fnnipp.jpg', '2023-03-10', 'freshshop'),
('Củ sắn', '4', 'Xuất xứ: Trang trại tại Xuân Thành, Lâm Đồng, Việt Nam.', '44000',  'https://res.cloudinary.com/drdtpudrn/image/upload/v1701959478/Root_Vegetables07_wqygp5.png', '2023-03-25', 'freshshop'),
('Su hào', '4', 'Xuất xứ: Trang trại tại Xuân Thành, Lâm Đồng, Việt Nam.', '42000', 'https://res.cloudinary.com/drdtpudrn/image/upload/v1701959500/Root_Vegetables06_phbxfj.jpg', '2023-04-10', 'freshshop'),
('Củ nghệ', '4', 'Công dụng: Nghệ là một trong những gia vị quen thuộc trong nấu ăn. Nghệ có chứa nhiều dưỡng chất, đặc biệt là curcumin – có khả năng kháng viêm, hỗ trợ người bị viêm loét dạ dày và hội chứng ruột kích thích. Chất curcumin có trong nghệ còn ngừa ung thư.', '37000', 'https://res.cloudinary.com/drdtpudrn/image/upload/v1701959485/Root_Vegetables05_p1itgi.jpg', '2023-04-20', 'freshshop'),
('Củ gừng', '4', 'Công dụng: Củ gừng có vị cay và hương thơm đặc biệt, có thể dùng để điều vị thêm hương, là thứ gia vị vô cùng hấp dẫn và không thể thiếu trong cuộc sống.', '25000', 'https://res.cloudinary.com/drdtpudrn/image/upload/v1701959506/Root_Vegetables04_wfyzne.png', '2023-04-30', 'freshshop'),
('Hành tây', '4', 'Công dụng: Hành tây cung cấp một nguồn vitamin C, B6, sắt, kali và mangan để bảo vệ cơ thể khỏi cái lạnh và cảm cúm. Ngoài ra còn giàu Organosulfurs và các Flavonoid có thể giúp ngăn ngừa bệnh tim và tăng cường sức khỏe tim mạch. Nhờ chứa nhiều vitamin A, E và C mà hành tây có thể hỗ trợ tăng cường sức khỏe và bảo vệ da.', '60000',  'https://res.cloudinary.com/drdtpudrn/image/upload/v1701959529/Root_Vegetables03_wkfbu3.png', '2023-05-05', 'freshshop'),
('Khoai sọ', '4', 'Công dụng: Một trong những lợi ích to lớn nhất của khoai sọ là kích thích hoạt động tiêu hóa trong cơ thể. Ngăn ngừa các loại bệnh ung thư. Ngăn ngừa bệnh tiểu đường. Có lợi cho huyết áp và giúp tim khỏe mạnh', '75000','https://res.cloudinary.com/drdtpudrn/image/upload/v1701959541/Root_Vegetables02_pfetm7.jpg', '2023-03-15', 'freshshop'),
('Hành tây tươi', '4', 'Công dụng: Hành tây tươi dùng sống hoặc nấu chín đều được cơ thể dung nạp tốt và mang lại nhiều lợi ích cho sức khỏe. Hành tây cung cấp một nguồn vitamin C, B6, sắt, kali và mangan để bảo vệ cơ thể khỏi cái lạnh và cảm cúm. Ngoài ra còn giàu Organosulfurs và các Flavonoid có thể giúp ngăn ngừa bệnh tim và tăng cường sức khỏe tim mạch. Nhờ chứa nhiều vitamin A, E và C mà hành tây có thể hỗ trợ tăng cường sức khỏe và bảo vệ da. Hành tây tươi có vị ngọt, tươi mát, có thể dùng cả lá hành và chỉ thu được vài tuần đầu mùa.', '40000', 'https://res.cloudinary.com/drdtpudrn/image/upload/v1701959557/Root_Vegetables01_x6iccr.jpg', '2023-05-10', 'freshshop');

-- Chèn dữ liệu mẫu cho bảng `orders` với `created_at` là các ngày từ tháng 1 đến tháng 12 trong năm 2023
INSERT INTO `orders` (
  `customer_id`,
  `total_amount`,
  `full_name`,
  `phone_number`,
  `address`,
  `status`,
  `created_at`,
  `created_by`
) VALUES
(2, 550000.25, 'Nguyễn Văn A', '0942579924', 'Số 12 Nguyễn Trãi, Quận 1, TP.Hồ Chí Minh', 'Waiting', '2023-01-01', 'Admin'),
(3, 757000.50, 'Trần Thị Bình', '0923415789', 'Số 34 Lê Lai, Quận 3, TP.Hồ Chí Minh', 'Delivery', '2023-02-02', 'Admin'),
(4, 100100.75, 'Phạm Minh Đức', '0941225226', 'Số 56 Bà Triệu, Quận 5, TP.Hồ Chí Minh', 'Delivered', '2023-03-03', 'Admin'),
(5, 120200.00, 'Lê Thị Mai', '0947258159', 'Số 78 Nguyễn Du, Quận 10, TP.Hồ Chí Minh', 'Cancelled', '2023-04-04', 'Admin'),
(6, 907000.00, 'Nguyễn Văn B', '0323141516', 'Số 23 Lý Tự Trọng, Quận Bình Thạnh, TP.Hồ Chí Minh', 'Waiting', '2023-05-05', 'Admin'),
(7, 110600.50, 'Trần Văn C', '0874559668', 'Số 45 Cách Mạng Tháng 8, Quận 3, TP.Hồ Chí Minh', 'Delivery', '2023-06-06', 'Admin'),
(8, 800700.75, 'Lê Thị Dung', '0974125123', 'Số 67 Huỳnh Thúc Kháng, Quận 1, TP.Hồ Chí Minh', 'Delivered', '2023-07-07', 'Admin'),
(9, 954000.20, 'Nguyễn Văn Hải', '0958741236', 'Số 89 Lê Quang Định, Quận Bình Thạnh, TP.Hồ Chí Minh', 'Cancelled', '2023-08-08', 'Admin'),
(10, 60200.00, 'Hoàng Thị Lan', '0985524136', 'Số 112 Điện Biên Phủ, Quận 10, TP.Hồ Chí Minh', 'Waiting', '2023-09-09', 'Admin'),
(11, 70700.30, 'Đỗ Văn Hiếu', '0985963124', 'Số 56 Nguyễn Huệ, Quận 1, TP.Hồ Chí Minh', 'Delivery', '2023-10-10', 'Admin'),
(12, 85100.45, 'Vũ Thị Hương', '0941123146', 'Số 34 Trần Hưng Đạo, Quận 5, TP.Hồ Chí Minh', 'Delivered', '2023-11-11', 'Admin'),
(13, 13030.00, 'Nguyễn Quốc Khánh', '0963323363', 'Số 78 Lê Lai, Quận Bình Thạnh, TP.Hồ Chí Minh', 'Cancelled', '2023-12-12', 'Admin'),
(14, 40970.20, 'Phạm Minh Khoa', '0974582164', 'Số 23 Đinh Công Tráng, Quận 1, TP.Hồ Chí Minh', 'Waiting', '2023-01-13', 'Admin'),
(15, 95123.60, 'Nguyễn Thị Linh', '0935147123', 'Số 45 Đinh Bộ Lĩnh, Quận Bình Thạnh, TP.Hồ Chí Minh', 'Delivery', '2023-02-14', 'Admin'),
(16, 11045.75, 'Trần Thanh Lợi', '0985147123', 'Số 56 Trần Hưng Đạo, Quận 3, TP.Hồ Chí Minh', 'Delivered', '2023-03-15', 'Admin'),
(17, 75789.90, 'Lê Thị Hồng Nga', '0952147456', 'Số 78 Điện Biên Phủ, Quận 10, TP.Hồ Chí Minh', 'Cancelled', '2023-04-16', 'Admin'),
(18, 12014.40, 'Nguyễn Văn Oanh', '0985556514', 'Số 34 Nguyễn Huệ, Quận 1, TP.Hồ Chí Minh', 'Waiting', '2023-05-17', 'Admin'),
(19, 55258.25, 'Lê Văn Phú', '0963332148', 'Số 56 Lý Tự Trọng, Quận Bình Thạnh, TP.Hồ Chí Minh', 'Delivery', '2023-06-18', 'Admin'),
(20, 88369.15, 'Trần Thị Quỳnh', '0844478964', 'Số 23 Huỳnh Thúc Kháng, Quận 5, TP.Hồ Chí Minh', 'Delivered', '2023-07-19', 'Admin');


-- Chèn dữ liệu mẫu cho bảng `order_details`
INSERT INTO `order_details` (
  `order_id`,
  `product_id`,
  `quantity`,
  `amount`,
  `created_at`,
  `created_by`
) VALUES
-- Đơn hàng 2
(2, 1, 3, 30.99, NOW(), 'Admin'),
(2, 2, 2, 20.50, NOW(), 'Admin'),
(2, 3, 1, 15.75, NOW(), 'Admin'),
-- Đơn hàng 3
(3, 4, 4, 40.00, NOW(), 'Admin'),
(3, 5, 1, 10.99, NOW(), 'Admin'),
(3, 6, 2, 25.00, NOW(), 'Admin'),
-- Đơn hàng 4
(4, 7, 1, 12.99, NOW(), 'Admin'),
(4, 8, 3, 35.25, NOW(), 'Admin'),
(4, 9, 2, 22.50, NOW(), 'Admin'),
-- Đơn hàng 5
(5, 10, 2, 25.99, NOW(), 'Admin'),
(5, 11, 1, 12.50, NOW(), 'Admin'),
(5, 12, 3, 35.75, NOW(), 'Admin'),
-- Đơn hàng 6
(6, 13, 4, 45.00, NOW(), 'Admin'),
(6, 14, 1, 11.99, NOW(), 'Admin'),
(6, 15, 2, 27.50, NOW(), 'Admin'),
-- Đơn hàng 7
(7, 16, 1, 14.99, NOW(), 'Admin'),
(7, 17, 3, 39.25, NOW(), 'Admin'),
(7, 18, 2, 24.50, NOW(), 'Admin'),
-- Đơn hàng 8
(8, 19, 2, 20.99, NOW(), 'Admin'),
(8, 20, 1, 17.50, NOW(), 'Admin'),
(8, 21, 3, 32.75, NOW(), 'Admin'),
-- Đơn hàng 9
(9, 22, 4, 50.00, NOW(), 'Admin'),
(9, 23, 1, 15.99, NOW(), 'Admin'),
(9, 24, 2, 29.50, NOW(), 'Admin'),
-- Đơn hàng 10
(10, 25, 1, 18.99, NOW(), 'Admin'),
(10, 26, 3, 42.25, NOW(), 'Admin'),
(10, 27, 2, 27.50, NOW(), 'Admin'),
-- Đơn hàng 11
(11, 28, 3, 30.99, NOW(), 'Admin'),
(11, 29, 2, 20.50, NOW(), 'Admin'),
(11, 30, 1, 15.75, NOW(), 'Admin'),
-- Đơn hàng 12
(12, 31, 4, 40.00, NOW(), 'Admin'),
(12, 32, 1, 10.99, NOW(), 'Admin'),
(12, 33, 2, 25.00, NOW(), 'Admin'),
-- Đơn hàng 13
(13, 34, 1, 12.99, NOW(), 'Admin'),
(13, 35, 3, 35.25, NOW(), 'Admin'),
(13, 36, 2, 22.50, NOW(), 'Admin'),
-- Đơn hàng 14
(14, 37, 2, 25.99, NOW(), 'Admin'),
(14, 38, 1, 12.50, NOW(), 'Admin'),
(14, 39, 3, 35.75, NOW(), 'Admin'),
-- Đơn hàng 15
(15, 40, 4, 45.00, NOW(), 'Admin'),
(15, 41, 1, 11.99, NOW(), 'Admin'),
(15, 42, 2, 27.50, NOW(), 'Admin'),
-- Đơn hàng 16
(16, 43, 1, 14.99, NOW(), 'Admin'),
(16, 44, 3, 39.25, NOW(), 'Admin'),
(16, 45, 2, 24.50, NOW(), 'Admin'),
-- Đơn hàng 17
(17, 46, 2, 20.99, NOW(), 'Admin'),
(17, 47, 1, 17.50, NOW(), 'Admin'),
(17, 48, 3, 32.75, NOW(), 'Admin'),
-- Đơn hàng 18
(18, 49, 4, 50.00, NOW(), 'Admin'),
(18, 50, 1, 15.99, NOW(), 'Admin'),
(18, 51, 2, 29.50, NOW(), 'Admin'),
-- Đơn hàng 19
(19, 52, 1, 18.99, NOW(), 'Admin'),
(19, 53, 3, 42.25, NOW(), 'Admin'),
(19, 54, 2, 27.50, NOW(), 'Admin');


INSERT INTO `contact_msg` (`name`, `mobile_num`, `email`, `subject`, `message`, `status`, `created_at`, `created_by`)
VALUES
    ('John Doe', '1234567890', 'john.doe@example.com', 'General Inquiry', 'This is a test message.', 'Open', NOW(), 'Admin'),
    ('Jane Smith', '9876543210', 'jane.smith@example.com', 'Product Support', 'I need help with a technical issue.', 'Open', NOW(), 'Admin'),
    ('David Johnson', '5551234567', 'david.johnson@example.com', 'Order Inquiry', 'I would like to know the status of my order.', 'Open', NOW(), 'Admin'),
    ('Sarah Adams', '9998887777', 'sarah.adams@example.com', 'Feedback', 'I wanted to share my positive experience with your service.', 'Open', NOW(), 'Admin'),
    ('Michael Brown', '1112223333', 'michael.brown@example.com', 'Complaint', 'I am extremely dissatisfied with your product.', 'Open', NOW(), 'Admin'),
    ('Emily Wilson', '4445556666', 'emily.wilson@example.com', 'Partnership Proposal', 'I have a business opportunity I would like to discuss with you.', 'Open', NOW(), 'Admin'),
    ('Daniel Thompson', '7778889999', 'daniel.thompson@example.com', 'Support Request', 'I need assistance with setting up my account.', 'Open', NOW(), 'Admin'),
    ('Sophia Lee', '2223334444', 'sophia.lee@example.com', 'Question about Pricing', 'Could you please provide information about your pricing plans?', 'Open', NOW(), 'Admin'),
    ('Oliver Wilson', '6667778888', 'oliver.wilson@example.com', 'Job Application', 'I am interested in applying for a position at your company.', 'Open', NOW(), 'Admin'),
    ('Ava Miller', '5556667777', 'ava.miller@example.com', 'Product Inquiry', 'I would like more information about your new product.', 'Open', NOW(), 'Admin'),
    ('William Turner', '4445556666', 'william.turner@example.com', 'Feedback', 'Your service has exceeded my expectations. Thank you!', 'Open', NOW(), 'Admin'),
('Emma Johnson', '9998887777', 'emma.johnson@example.com', 'Support Request', 'I am having trouble accessing my account.', 'Open', NOW(), 'Admin'),
    ('Noah Wilson', '1112223333', 'noah.wilson@example.com', 'General Inquiry', 'I have a question about your company.', 'Open', NOW(), 'Admin'),
    ('Isabella Davis', '7778889999', 'isabella.davis@example.com', 'Product Support', 'My product arrived damaged. What should I do?', 'Open', NOW(), 'Admin');

INSERT INTO `contact_msg` (`name`, `mobile_num`, `email`, `subject`, `message`, `status`, `created_at`, `created_by`)
VALUES
    ('John Doe', '1234567890', 'john.doe@example.com', 'General Inquiry', 'This is a test message.', 'Open', '2023-03-01', 'Admin'),
    ('Jane Smith', '9876543210', 'jane.smith@example.com', 'Product Support', 'I need help with a technical issue.', 'Open', '2023-03-05', 'Admin'),
    ('David Johnson', '5551234567', 'david.johnson@example.com', 'Order Inquiry', 'I would like to know the status of my order.', 'Open', '2023-03-10', 'Admin'),
    ('Sarah Adams', '9998887777', 'sarah.adams@example.com', 'Feedback', 'I wanted to share my positive experience with your service.', 'Open', '2023-03-15', 'Admin'),
    ('Michael Brown', '1112223333', 'michael.brown@example.com', 'Complaint', 'I am extremely dissatisfied with your product.', 'Open', '2023-03-20', 'Admin'),
    ('Emily Wilson', '4445556666', 'emily.wilson@example.com', 'Partnership Proposal', 'I have a business opportunity I would like to discuss with you.', 'Open', '2023-03-25', 'Admin'),
    ('Daniel Thompson', '7778889999', 'daniel.thompson@example.com', 'Support Request', 'I need assistance with setting up my account.', 'Open', '2023-03-30', 'Admin'),
    ('Sophia Lee', '2223334444', 'sophia.lee@example.com', 'Question about Pricing', 'Could you please provide information about your pricing plans?', 'Open', '2023-04-01', 'Admin'),
    ('Oliver Wilson', '6667778888', 'oliver.wilson@example.com', 'Job Application', 'I am interested in applying for a position at your company.', 'Open', '2023-04-05', 'Admin'),
    ('Ava Miller', '5556667777', 'ava.miller@example.com', 'Product Inquiry', 'I would like more information about your new product.', 'Open', '2023-04-10', 'Admin'),
    ('William Turner', '4445556666', 'william.turner@example.com', 'Feedback', 'Your service has exceeded my expectations. Thank you!', 'Open', '2023-04-15', 'Admin'),
    ('Emma Johnson', '9998887777', 'emma.johnson@example.com', 'Support Request', 'I am having trouble accessing my account.', 'Open', '2023-04-20', 'Admin'),
    ('Noah Wilson', '1112223333', 'noah.wilson@example.com', 'General Inquiry', 'I have a question about your company.', 'Open', '2023-04-25', 'Admin'),
    ('Isabella Davis', '7778889999', 'isabella.davis@example.com', 'Product Support', 'My product arrived damaged. What should I do?', 'Open', '2023-04-30', 'Admin'),
('Sophia Brown', '2223334444', 'sophia.brown@example.com', 'Partnership Inquiry', 'I would like to discuss a potential partnership opportunity.', 'Open', '2023-05-01', 'Admin'),
    ('Oliver Johnson', '6667778888', 'oliver.johnson@example.com', 'Job Application', 'I am interested in applying for a job at your company.', 'Open', '2023-05-05', 'Admin'),
    ('Liam Davis', '5556667777', 'liam.davis@example.com', 'Product Inquiry', 'I have a question about your product.', 'Open', '2023-05-10', 'Admin'),
    ('Emma Wilson', '9998887777', 'emma.wilson@example.com', 'Support Request', 'I need assistance with my account.', 'Open', '2023-05-15', 'Admin'),
    ('Noah Brown', '1112223333', 'noah.brown@example.com', 'General Inquiry', 'I have a general question.', 'Open', '2023-05-20', 'Admin'),
    ('Isabella Johnson', '7778889999', 'isabella.johnson@example.com', 'Product Support', 'I need support for my product.', 'Open', '2023-05-25', 'Admin');