drop database if exists Heladeria;

create database Heladeria;

use Heladeria;

-- Tabla de Productos
CREATE TABLE productos (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(100) NOT NULL,
    precio DECIMAL(10, 2) NOT NULL,
    tipo VARCHAR(50) NOT NULL
);

-- Tabla de Clientes 
CREATE TABLE clientes (
    id_cliente INT PRIMARY KEY AUTO_INCREMENT,
    nombre_cliente VARCHAR(100) NOT NULL,
    direccion_cliente VARCHAR(255) NOT NULL
);

-- Tabla de Pedidos
CREATE TABLE pedidos (
    id INT PRIMARY KEY AUTO_INCREMENT,
    fecha_pedido DATE NOT NULL,
    estado enum('Pendiente','En Proceso', 'Entregado','Listo') DEFAULT 'Pendiente',
    tipo_pedido Enum('En Tienda','Delivery') NOT NULL,
    id_cliente INT, -- Solo para pedidos de tipo 'Delivery'
    direccion VARCHAR(255), -- Solo si es delivery
    total DECIMAL(10, 2)not null,
    FOREIGN KEY (id_cliente) REFERENCES clientes(id_cliente) 
);


-- Tabla de Relación Pedido-Producto (Productos en cada pedido)
CREATE TABLE pedido_producto (
    id INT PRIMARY KEY AUTO_INCREMENT,
    id_pedido INT,
    id_producto INT,
    cantidad INT NOT NULL,
    FOREIGN KEY (id_pedido) REFERENCES pedidos(id),
    FOREIGN KEY (id_producto) REFERENCES productos(id)
);

-- Tabla de Empleados
CREATE TABLE empleados (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(100) NOT NULL,
    rol enum('Vendedor', 'Repartidor','Administrador')
);

-- Tabla de Repartidores (específicos para los empleados que entregan pedidos)
CREATE TABLE repartidores (
    id INT PRIMARY KEY AUTO_INCREMENT,
    id_empleado INT,
    vehiculo VARCHAR(50), -- Tipo de vehículo usado para las entregas
    FOREIGN KEY (id_empleado) REFERENCES empleados(id)
);

-- Tabla de Relación Pedido-Repartidor (para asignar pedidos de delivery a repartidores)
CREATE TABLE delivery (
    id INT PRIMARY KEY AUTO_INCREMENT,
    id_pedido INT,
    id_repartidor INT,
    fecha_asignacion DATE,
    estado_entrega enum('Pendiente', 'Entregado') DEFAULT 'Pendiente',
    FOREIGN KEY (id_pedido) REFERENCES pedidos(id),
    FOREIGN KEY (id_repartidor) REFERENCES repartidores(id)
);

INSERT INTO clientes (nombre_cliente, direccion_cliente)
VALUES ('Carlos López', 'Calle Ejemplo 456');


INSERT INTO productos (nombre, precio, tipo) VALUES ('Helado de Chocolate', 100.0, 'Helado');
INSERT INTO productos (nombre, precio, tipo) VALUES ('Helado de Fresa', 90.0, 'Helado');
INSERT INTO productos (nombre, precio, tipo) VALUES ('Chispas de Chocolate', 20.0, 'Topping');
INSERT INTO productos (nombre, precio, tipo) VALUES ('Combo Familiar', 300.0, 'Combo');

INSERT INTO empleados (nombre, rol) 
VALUES ('Juan Pérez', 'Vendedor');
INSERT INTO empleados (nombre, rol)
VALUES ('Carlos Rodríguez', 'Repartidor');

INSERT INTO repartidores (id_empleado, vehiculo) 
VALUES (2, 'Motocicleta');

-- Pedido delivery
INSERT INTO pedidos (fecha_pedido, estado, tipo_pedido, id_cliente, direccion, total)
VALUES ('2024-11-10', 'Pendiente', 'Delivery', 1, 'Calle Ejemplo 456', 350.0);

-- Pedido tienda
INSERT INTO pedidos (fecha_pedido, estado, tipo_pedido, total)
VALUES ('2024-11-10', 'Entregado', 'En tienda', 200.0);


INSERT INTO pedido_producto (id_pedido, id_producto, cantidad) 
VALUES (1, 1, 2); -- Dos helados de chocolate en el pedido
INSERT INTO pedido_producto (id_pedido, id_producto, cantidad) 
VALUES (1, 3, 1); -- Un topping de chispas de chocolate en el pedido

INSERT INTO delivery (id_pedido, id_repartidor, fecha_asignacion, estado_entrega) 
VALUES (1, 1, '2024-11-10', 'Pendiente');
