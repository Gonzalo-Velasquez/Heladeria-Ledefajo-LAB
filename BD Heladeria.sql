create database Heladeria;
use Heladeria;

create table Cliente(
ClienteID int primary key,
Nombre varchar(50)
);

create table Inventario(
InventarioID int primary key,
Productos varchar(50),
Cantidad int,
Precio_Unidad decimal
);

create table Helado(
HeladoID int primary key,
Sabor_Helado varchar(50),
Nombre_Helado varchar(50),
Kilo decimal
);

create table Pizza(
PizzaID int primary key,
Nombre_Pizza varchar(50),
Tamanio_Pizza varchar(50)
);

create table Batido(
BatidoID int primary key,
Sabor_Batido varchar(50),
Tamanio_batido varchar(50),
Nombre_Batido varchar(50)
);

create table Descuento(
VentaID int primary key,
Descuento_Pizza varchar(50),
Descuento_Helado varchar(50),
Descuento_Batido varchar(50)
);

create table Productos_Comprados(
Productos_CompradosID int primary key,
Nombre_Producto varchar(50),
HeladoID int,
PizzaID int,
BatidoID int,
foreign key(HeladoID) references Helado(HeladoID),
foreign key(PizzaID) references Pizza(PizzaID),
foreign key(BatidoID) references Batido(BatidoID)
);

create table Venta(
VentaID int primary key,
ClienteID int,
Productos_CompradosID int,
Cantidad int,
Total decimal,
Fecha_venta date,
foreign key (ClienteID) references Cliente(ClienteID),
foreign key(Productos_CompradosID) references Productos_Comprados(Productos_CompradosID)
);

-- Insertar Clientes
INSERT INTO Cliente (ClienteID, Nombre) VALUES
(1, 'Juan Pérez'),
(2, 'María López'),
(3, 'Carlos García'),
(4, 'Ana Torres');

-- Insertar Inventario
INSERT INTO Inventario (InventarioID, Productos, Cantidad, Precio_Unidad) VALUES
(1, 'Helado de Vainilla', 50, 1.50),
(2, 'Helado de Chocolate', 30, 1.75),
(3, 'Pizza Margarita', 20, 8.00),
(4, 'Batido de Fresa', 25, 3.00);

-- Insertar Helados
INSERT INTO Helado (HeladoID, Sabor_Helado, Nombre_Helado, Kilo) VALUES
(1, 'Vainilla', 'Helado Vainilla Clásico', 1.0),
(2, 'Chocolate', 'Helado de Chocolate Rico', 1.2),
(3, 'Fresa', 'Helado de Fresa Fresco', 0.8);

-- Insertar Pizzas
INSERT INTO Pizza (PizzaID, Nombre_Pizza, Tamanio_Pizza) VALUES
(1, 'Margarita', 'Grande'),
(2, 'Pepperoni', 'Mediana'),
(3, 'Cuatro Quesos', 'Pequeña');

-- Insertar Batidos
INSERT INTO Batido (BatidoID, Sabor_Batido, Tamanio_batido, Nombre_Batido) VALUES
(1, 'Fresa', 'Grande', 'Batido Fresa Delicioso'),
(2, 'Chocolate', 'Mediano', 'Batido Chocolate Crema'),
(3, 'Banana', 'Pequeño', 'Batido Banana Natural');

-- Insertar Descuentos
INSERT INTO Descuento (VentaID, Descuento_Pizza, Descuento_Helado, Descuento_Batido) VALUES
(1, '10%', '5%', '15%'),
(2, '15%', '10%', '20%');

-- Insertar Productos Comprados
INSERT INTO Productos_Comprados (Productos_CompradosID, Nombre_Producto, HeladoID, PizzaID, BatidoID) VALUES
(1, 'Helado de Vainilla', 1, NULL, NULL),
(2, 'Pizza Margarita', NULL, 1, NULL),
(3, 'Batido de Fresa', NULL, NULL, 1),
(4, 'Combo Familiar', 2, 2, 2);

-- Insertar Ventas
INSERT INTO Venta (VentaID, ClienteID, Productos_CompradosID, Cantidad, Total, Fecha_venta) VALUES
(1, 1, 1, 2, 3.00, '2024-10-01'),
(2, 2, 2, 1, 8.00, '2024-10-02'),
(3, 3, 3, 3, 9.00, '2024-10-03'),
(4, 4, 4, 1, 17.50, '2024-10-04');
