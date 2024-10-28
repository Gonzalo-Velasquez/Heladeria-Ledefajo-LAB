CREATE TABLE Cliente (
    ClienteID INT AUTO_INCREMENT PRIMARY KEY,
    Nombre VARCHAR(100) NOT NULL
);

CREATE TABLE Venta (
    VentaID INT AUTO_INCREMENT PRIMARY KEY,
    Fecha_venta DATE NOT NULL,
    ClienteID INT,
    Total DECIMAL(10, 2) NOT NULL,
    FOREIGN KEY (ClienteID) REFERENCES Cliente(ClienteID)
);

CREATE TABLE Pizza (
    PizzaID INT AUTO_INCREMENT PRIMARY KEY,
    Nombre_Pizza VARCHAR(100) NOT NULL,
    Precio DECIMAL(10, 2) NOT NULL
);

CREATE TABLE Batido (
    BatidoID INT AUTO_INCREMENT PRIMARY KEY,
    Nombre_Batido VARCHAR(100) NOT NULL,
    Precio DECIMAL(10, 2) NOT NULL,
    Sabor_Batido VARCHAR(50) NOT NULL,
    Tamaño_Batido VARCHAR(50) NOT NULL
);

CREATE TABLE Helado (
    HeladoID INT AUTO_INCREMENT PRIMARY KEY,
    Nombre_Helado VARCHAR(100) NOT NULL,
    Precio DECIMAL(10, 2) NOT NULL,
    Sabor_Helado VARCHAR(50) NOT NULL,
    Kilo DECIMAL(5, 2) NOT NULL
);

CREATE TABLE Inventario (
    InventarioID INT AUTO_INCREMENT PRIMARY KEY,
    PizzaID INT,
    BatidoID INT,
    HeladoID INT,
    Cantidad INT NOT NULL,
    FOREIGN KEY (PizzaID) REFERENCES Pizza(PizzaID),
    FOREIGN KEY (BatidoID) REFERENCES Batido(BatidoID),
    FOREIGN KEY (HeladoID) REFERENCES Helado(HeladoID)
);

CREATE TABLE Descuento (
    DescuentoID INT AUTO_INCREMENT PRIMARY KEY,
    Descuento_Pizza DECIMAL(5, 2),
    Descuento_Batido DECIMAL(5, 2),
    Descuento_Helado DECIMAL(5, 2)
);

CREATE TABLE Productos_Comprados (
    Productos_Comprados_ID INT AUTO_INCREMENT PRIMARY KEY,
    VentaID INT,
    PizzaID INT,
    BatidoID INT,
    HeladoID INT,
    Cantidad INT NOT NULL,
    FOREIGN KEY (VentaID) REFERENCES Venta(VentaID),
    FOREIGN KEY (PizzaID) REFERENCES Pizza(PizzaID),
    FOREIGN KEY (BatidoID) REFERENCES Batido(BatidoID),
    FOREIGN KEY (HeladoID) REFERENCES Helado(HeladoID)
);


INSERT INTO Cliente (Nombre) VALUES ('Juan Pérez');
INSERT INTO Cliente (Nombre) VALUES ('María García');
INSERT INTO Cliente (Nombre) VALUES ('Carlos Sánchez');


INSERT INTO Batido (Nombre_Batido, Precio, Sabor_Batido, Tamaño_Batido) VALUES ('Chocolate', 4.99, 'Chocolate', 'Grande');
INSERT INTO Batido (Nombre_Batido, Precio, Sabor_Batido, Tamaño_Batido) VALUES ('Fresa', 4.50, 'Fresa', 'Mediano');
INSERT INTO Batido (Nombre_Batido, Precio, Sabor_Batido, Tamaño_Batido) VALUES ('Vainilla', 5.25, 'Vainilla', 'Grande');


INSERT INTO Pizza (Nombre_Pizza, Precio) VALUES ('Margarita', 8.99);
INSERT INTO Pizza (Nombre_Pizza, Precio) VALUES ('Pepperoni', 10.99);
INSERT INTO Pizza (Nombre_Pizza, Precio) VALUES ('Cuatro Quesos', 12.99);


INSERT INTO Helado (Nombre_Helado, Precio, Sabor_Helado, Kilo) VALUES ('Helado de Chocolate', 15.99, 'Chocolate', 1.0);
INSERT INTO Helado (Nombre_Helado, Precio, Sabor_Helado, Kilo) VALUES ('Helado de Vainilla', 13.99, 'Vainilla', 0.5);
INSERT INTO Helado (Nombre_Helado, Precio, Sabor_Helado, Kilo) VALUES ('Helado de Fresa', 14.99, 'Fresa', 0.75);


INSERT INTO Inventario (PizzaID, BatidoID, HeladoID, Cantidad) VALUES (1, NULL, NULL, 20);
INSERT INTO Inventario (PizzaID, BatidoID, HeladoID, Cantidad) VALUES (NULL, 1, NULL, 30);
INSERT INTO Inventario (PizzaID, BatidoID, HeladoID, Cantidad) VALUES (NULL, NULL, 1, 25);


INSERT INTO Descuento (Descuento_Pizza, Descuento_Batido, Descuento_Helado) VALUES (10.00, 5.00, 15.00);


INSERT INTO Venta (Fecha_venta, ClienteID, Total) VALUES ('2024-10-28', 1, 20.99);
INSERT INTO Venta (Fecha_venta, ClienteID, Total) VALUES ('2024-10-28', 2, 15.50);
INSERT INTO Venta (Fecha_venta, ClienteID, Total) VALUES ('2024-10-28', 3, 18.75);


INSERT INTO Productos_Comprados (VentaID, PizzaID, BatidoID, HeladoID, Cantidad) VALUES (1, 1, NULL, NULL, 2);
INSERT INTO Productos_Comprados (VentaID, PizzaID, BatidoID, HeladoID, Cantidad) VALUES (1, NULL, 1, NULL, 1);
INSERT INTO Productos_Comprados (VentaID, PizzaID, BatidoID, HeladoID, Cantidad) VALUES (2, NULL, NULL, 1, 3);
INSERT INTO Productos_Comprados (VentaID, PizzaID, BatidoID, HeladoID, Cantidad) VALUES (3, 2, NULL, NULL, 1);
