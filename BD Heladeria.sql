drop database if exists Heladeria;
create database Heladeria;
use Heladeria;

create table Cliente(
ClienteID int primary key auto_increment,
Nombre varchar(50)
);

create table Inventario(
InventarioID int primary key auto_increment,
Productos varchar(50),
Cantidad int,
Precio_Unidad decimal
);

create table Helado(
HeladoID int primary key auto_increment,
Sabor_Helado varchar(50),
Nombre_Helado varchar(50),
Kilo enum("1/4","1/2","1K","2K")
);

create table Pizza(
PizzaID int primary key auto_increment,
Nombre_Pizza varchar(50),
Tamanio_Pizza enum("Pequeño","Mediano","Grande")
);

create table Batido(
BatidoID int primary key auto_increment,
Sabor_Batido varchar(50),
Tamanio_batido enum("Pequeño","Mediano","Grande"),
Nombre_Batido varchar(50)
);

create table Descuento(
VentaID int primary key auto_increment,
Descuento_Pizza varchar(50),
Descuento_Helado varchar(50),
Descuento_Batido varchar(50)
);

create table Productos_Comprados(
Productos_CompradosID int primary key auto_increment,
Nombre_Producto varchar(50),
HeladoID int,
PizzaID int,
BatidoID int,
foreign key(HeladoID) references Helado(HeladoID),
foreign key(PizzaID) references Pizza(PizzaID),
foreign key(BatidoID) references Batido(BatidoID)
);

create table Venta(
VentaID int primary key auto_increment,
ClienteID int,
Productos_CompradosID int,
Cantidad int,
Total decimal,
Fecha_venta date,
foreign key (ClienteID) references Cliente(ClienteID),
foreign key(Productos_CompradosID) references Productos_Comprados(Productos_CompradosID)
);

-- Insert en la tabla Cliente
INSERT INTO Cliente (Nombre) VALUES ('Juan Perez');
INSERT INTO Cliente (Nombre) VALUES ('Maria Lopez');
INSERT INTO Cliente (Nombre) VALUES ('Carlos Gomez');
INSERT INTO Cliente (Nombre) VALUES ('Ana Martinez');

-- Insert en la tabla Inventario
INSERT INTO Inventario (Productos, Cantidad, Precio_Unidad) VALUES ('Helado de Vainilla', 20, 2.50);
INSERT INTO Inventario (Productos, Cantidad, Precio_Unidad) VALUES ('Pizza Margherita', 10, 7.50);
INSERT INTO Inventario (Productos, Cantidad, Precio_Unidad) VALUES ('Batido de Fresa', 15, 3.00);
INSERT INTO Inventario (Productos, Cantidad, Precio_Unidad) VALUES ('Helado de Chocolate', 25, 2.75);

-- Insert en la tabla Helado
INSERT INTO Helado (Sabor_Helado, Nombre_Helado, Kilo) VALUES ('Vainilla', 'Helado Clásico de Vainilla', '1/2');
INSERT INTO Helado (Sabor_Helado, Nombre_Helado, Kilo) VALUES ('Chocolate', 'Helado Intenso de Chocolate', '1K');
INSERT INTO Helado (Sabor_Helado, Nombre_Helado, Kilo) VALUES ('Fresa', 'Helado Suave de Fresa', '1/4');
INSERT INTO Helado (Sabor_Helado, Nombre_Helado, Kilo) VALUES ('Limón', 'Helado Refrescante de Limón', '2K');

-- Insert en la tabla Pizza
INSERT INTO Pizza (Nombre_Pizza, Tamanio_Pizza) VALUES ('Pizza Margherita', 'Mediano');
INSERT INTO Pizza (Nombre_Pizza, Tamanio_Pizza) VALUES ('Pizza Pepperoni', 'Grande');
INSERT INTO Pizza (Nombre_Pizza, Tamanio_Pizza) VALUES ('Pizza Hawaiana', 'Pequeño');
INSERT INTO Pizza (Nombre_Pizza, Tamanio_Pizza) VALUES ('Pizza Cuatro Quesos', 'Grande');

-- Insert en la tabla Batido
INSERT INTO Batido (Sabor_Batido, Tamanio_batido, Nombre_Batido) VALUES ('Fresa', 'Mediano', 'Batido Refrescante de Fresa');
INSERT INTO Batido (Sabor_Batido, Tamanio_batido, Nombre_Batido) VALUES ('Chocolate', 'Grande', 'Batido Intenso de Chocolate');
INSERT INTO Batido (Sabor_Batido, Tamanio_batido, Nombre_Batido) VALUES ('Vainilla', 'Pequeño', 'Batido Clásico de Vainilla');
INSERT INTO Batido (Sabor_Batido, Tamanio_batido, Nombre_Batido) VALUES ('Plátano', 'Grande', 'Batido Nutritivo de Plátano');

-- Insert en la tabla Descuento
INSERT INTO Descuento (Descuento_Pizza, Descuento_Helado, Descuento_Batido) VALUES ('10%', '15%', '5%');
INSERT INTO Descuento (Descuento_Pizza, Descuento_Helado, Descuento_Batido) VALUES ('20%', '10%', '0%');
INSERT INTO Descuento (Descuento_Pizza, Descuento_Helado, Descuento_Batido) VALUES ('5%', '20%', '10%');
INSERT INTO Descuento (Descuento_Pizza, Descuento_Helado, Descuento_Batido) VALUES ('0%', '0%', '0%');

-- Insert en la tabla Productos_Comprados
INSERT INTO Productos_Comprados (Nombre_Producto, HeladoID, PizzaID, BatidoID) VALUES ('Combo Helado y Pizza', 1, 2, NULL);
INSERT INTO Productos_Comprados (Nombre_Producto, HeladoID, PizzaID, BatidoID) VALUES ('Helado de Chocolate y Batido de Fresa', 2, NULL, 1);
INSERT INTO Productos_Comprados (Nombre_Producto, HeladoID, PizzaID, BatidoID) VALUES ('Pizza Margherita y Batido de Chocolate', NULL, 1, 2);
INSERT INTO Productos_Comprados (Nombre_Producto, HeladoID, PizzaID, BatidoID) VALUES ('Combo Familiar', 3, 3, 4);

-- Insert en la tabla Venta
INSERT INTO Venta (ClienteID, Productos_CompradosID, Cantidad, Total, Fecha_venta) VALUES (1, 1, 2, 15.00, '2024-10-23');
INSERT INTO Venta (ClienteID, Productos_CompradosID, Cantidad, Total, Fecha_venta) VALUES (2, 2, 1, 5.50, '2024-10-23');
INSERT INTO Venta (ClienteID, Productos_CompradosID, Cantidad, Total, Fecha_venta) VALUES (3, 3, 3, 20.00, '2024-10-23');
INSERT INTO Venta (ClienteID, Productos_CompradosID, Cantidad, Total, Fecha_venta) VALUES (4, 4, 4, 50.00, '2024-10-23');


