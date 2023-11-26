/*Adding roles*/

INSERT INTO roles (id, user_role)
VALUES (1, 'ADMIN'),
       (2, 'USER');


/*Adding admin user*/

INSERT INTO users (username, password, full_name, email, is_active)
VALUES ('ADMIN', 'b21f1a72fa7e195abcaacb93b60004daf166c0707fb427afe4e4354852eabfde63a8653be2b22e38365d709e01f3a97c',
        'Admin Admin', 'admin@test.bg', true),
       ('niki', 'fe1bc8fbdb468d590bea86fc6257ec238499745738f2a3affb6478f0e3050d53ebcdcc8c0cac8c7cc445975bc87a9bb7',
        'Nikolai Nik', 'nik@test.bg', true),
       ('zaza', '79b9a214662b7d7bd2f3f5fb527478a8c0c871341131e37da3521f7c1303ac9a325573ae247cff045e3a113ff043e44e',
        'Zara Zara', 'zaz@test.bg', true);



INSERT INTO users_roles (user_entity_id, roles_id)
VALUES (1, 1),
       (1, 2),
       (2, 2),
       (3, 2);

/*Populating categories table*/


INSERT INTO categories (name, description)
VALUES ('ORDERS', 'Some Bulgarian royal orders from 1887 to 1943'),
       ('MEDALS', 'Some Bulgarian royal medals from 1887 to 1943'),
       ('COINS', 'Some Bulgarian coins from 1887 to 1943');


INSERT INTO items (name, description, price, published_on, image_url, year, category_id, user_id)
VALUES ('Орден „За Гражданска Заслуга“ I ст. 1908-18 г.', 'Bulgarian royal orders', 150.00, CURRENT_TIMESTAMP,
        'https://upload.wikimedia.org/wikipedia/commons/6/69/%D0%9E%D1%80%D0%B4%D0%B5%D0%BD_%E2%80%9E%D0%97%D0%B0_%D0%93%D1%80%D0%B0%D0%B6%D0%B4%D0%B0%D0%BD%D1%81%D0%BA%D0%B0_%D0%97%D0%B0%D1%81%D0%BB%D1%83%D0%B3%D0%B0%E2%80%9C_I_%D1%81%D1%82._1908-18_%D0%B3..gif', 1908, 1, 1),
       ('Орден „За Военна Заслуга“ III степен', 'Bulgarian royal orders', 160.00, CURRENT_TIMESTAMP,
        'https://upload.wikimedia.org/wikipedia/commons/a/a4/Order_For_Military_Merit%2C_3rd_Class.jpg', 1910, 1, 1),
       ('Медал "Храброст 2 степен“', 'Bulgarian royal medals', 50.00, CURRENT_TIMESTAMP,
        'https://upload.wikimedia.org/wikipedia/commons/c/c7/%D0%9E%D1%80%D0%B4%D0%B5%D0%BD_%C2%AB%D0%97%D0%B0_%D1%85%D1%80%D0%B0%D0%B1%D1%80%D0%BE%D1%81%D1%82%C2%BB_I_%D1%81%D1%82%D0%B5%D0%BF%D0%B5%D0%BD_%D1%81_%D0%BC%D0%B5%D1%87%D0%BE%D0%B2%D0%B5.gif', 1912, 2, 1),
       ('Медал "Войнишки кръст За храброст IV степен" ', 'Bulgarian royal medals', 40.00, CURRENT_TIMESTAMP,
        'https://www.nmogabrovo.com/uploads/acho/thumbs/details/1276ni2.jpg', 1910, 2, 1),
       ('Монета', 'Bulgarian монета сребро', 100.00, CURRENT_TIMESTAMP,
        'https://images.drive.com.au/driveau/image/upload/t_wp-default/v1/cms/uploads/ipbwdw9jxtiewinmhsdr', 1900, 3, 1);;


