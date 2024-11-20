Superclases (Clases Padres)

1\. Producto: Representa todos los productos que ofrece la heladería, proporcionando atributos comunes, como nombre, precio y descripción. Sirve de base para los productos específicos (helados, toppings y combos).

2\. Pedido: Representa un pedido general realizado por el cliente, ya sea en la tienda, para entrega a domicilio, o un pedido con un combo especial. Incluye atributos básicos como número de pedido, fecha y detalles de los productos pedidos.

3\. Empleado: Representa a los trabajadores de la heladería en general, proporcionando atributos comunes, como nombre, ID de empleado y salario. Esta clase permite gestionar de forma general los empleados, sin importar su rol específico.

Subclases (Clases Hijas)

Producto (Subclases de Producto):

Helado: Representa los helados de la heladería, que pueden tener varios sabores y tamaños. Esta clase permite diferenciar entre los sabores y gestionar las características específicas de cada helado, como el tipo de crema o sabor.

Topping: Representa los toppings que los clientes pueden añadir a sus helados, como chocolate, nueces, y coco. Permite a los clientes personalizar sus helados al agregar diferentes sabores o texturas.

Combo: Representa una oferta especial que combina un helado con uno o más toppings por un precio reducido. Facilita la promoción de productos y permite ahorrar tiempo y costo al cliente al comprar un combo en lugar de productos individuales.

Pedido (Subclases de Pedido):

PedidoEnTienda: Representa los pedidos realizados en el local y generalmente no está asociado con un cliente registrado, ya que puede ser una compra directa.

PedidoDelivery: Representa los pedidos que deben ser entregados a domicilio, incluyendo información adicional para la entrega, como dirección y horario de entrega.

PedidoConCombo: Representa los pedidos que incluyen un combo especial. Permite ofrecer precios especiales y gestionar los combos de manera específica en los pedidos.

Empleado (Subclases de Empleado):

Vendedor: Representa a los empleados responsables de atender a los clientes en el local y gestionar las ventas. Esta clase puede incluir funciones para realizar pedidos en la tienda y manejar el cobro.

Repartidor: Representa a los empleados que entregan los pedidos a domicilio. Esta clase permite almacenar información específica para la entrega de pedidos y rastrear la efectividad de las entregas.

Administrador: Se encarga de añadir y mostrar los empleados.

Clase Independiente

Cliente: Representa a los clientes de la heladería. Aunque no es una subclase de ninguna de las anteriores, permite gestionar la información del cliente, como nombre, teléfono y dirección, así como su historial de pedidos.

