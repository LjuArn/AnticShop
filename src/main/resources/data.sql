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
VALUES ('Орден „За гражданска заслуга“', 'Bulgarian royal orders', 50.00, CURRENT_TIMESTAMP,
        'https://images.drive.com.au/driveau/image/upload/t_wp-default/v1/cms/uploads/ipbwdw9jxtiewinmhsdr', 1881, 1, 1),
       ('Орден „За гражданска з“', 'Bulgarian royal orders', 50.00, CURRENT_TIMESTAMP,
        'https://images.drive.com.au/driveau/image/upload/t_wp-default/v1/cms/uploads/ipbwdw9jxtiewinmhsdr', 1886, 1, 1),
       ('Медал Храброст „За гражданска за“', 'Bulgarian royal orders', 50.00, CURRENT_TIMESTAMP,
        'https://images.drive.com.au/driveau/image/upload/t_wp-default/v1/cms/uploads/ipbwdw9jxtiewinmhsdr', 1887, 2, 1),
       ('Медал Храброст 4 степен', 'Bulgarian royal orders', 50.00, CURRENT_TIMESTAMP,
        'https://images.drive.com.au/driveau/image/upload/t_wp-default/v1/cms/uploads/ipbwdw9jxtiewinmhsdr', 1888, 2, 1),
       ('Монета', 'Bulgarian монета сребро', 50.00, CURRENT_TIMESTAMP,
        'https://images.drive.com.au/driveau/image/upload/t_wp-default/v1/cms/uploads/ipbwdw9jxtiewinmhsdr', 1900, 3, 1);;


