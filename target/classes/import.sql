/*populate tabla clientes*/
INSERT INTO clientes (id,nombre, apellido, create_at) VALUES (1,'Héctor','Granja','2019-11-29');
INSERT INTO clientes (id,nombre, apellido, create_at) VALUES (2,'Bárbara','Granja','2019-10-27');
INSERT INTO clientes (id,nombre, apellido, create_at) VALUES (3,'Pepe','Granja','2019-09-20');

INSERT INTO usuario (id,nombre, password, idcliente) VALUES (1,'hgc','1234',1);
INSERT INTO usuario (id,nombre, password, idcliente) VALUES (2,'pep','1234',3);


INSERT INTO mail (id,mail, idusuario) VALUES (1,'pepep@sdfs.com',1);
INSERT INTO mail (id,mail, idusuario) VALUES (2,'sfsdfs@sdfs.com',1);
INSERT INTO mail (id,mail, idusuario) VALUES (3,'tertet@sdfs.com',2);



INSERT INTO productos (descripcion, precio, fecha_alta, disponibilidad) VALUES ('Producto 1',10,'2019-11-30',false);
INSERT INTO productos (descripcion, precio, fecha_alta, disponibilidad) VALUES ('Producto 2',12,'2019-09-30',true);
INSERT INTO productos (descripcion, precio, fecha_alta, disponibilidad) VALUES ('Producto 3',15,'2012-12-31',true);