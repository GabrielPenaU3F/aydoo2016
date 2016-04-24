Informe sobre la extensión de la librería:

Acerca del código original:

-Los tests corren bien.
-El diseño está, a mi parecer, bastante bien. No hay mucha lógica rara, y no veo un enorme acoplamiento entre las clases.
-Pocos tests (solamente 11). 

Smells:

-No esta modelada la clase Suscripcion.
-Hay una clase Program que no hace absolutamente nada.
-La clase Producto no es abstracta.
-La librería tiene una lista de clientes pero jamás realiza una validación, con lo cual esa lista no hace nada.

Problemas:

-Sobre los tests
	
	-Hay solamente tres clases de tests, y los tests de integración estan entremezclados con los test unitarios.
	-De estas tres clases, la clase ClienteTest tiene un UNICO test unitario, el cual testea que el cliente tenga una compra que esta realizando.
	-Los tests de la clase Compra son malos. Testea muchas veces lo mismo, cambiando levemente los parametros. Los cuatro test que contiene la clase testean unicamente que al ir agregando distintos productos, el tamaño de la lista de productos que contiene aumente, pero en ningun momento verifica que se agreguen de forma correcta. No se testea tampoco ninguna condicion excepcional.
	-Los test de la librería, excepto el primero, son de integración, no unitarios.
	-Algunos tests están levemente hardcodeados. Por ejemplo, agrega algo a una lista y en lugar de iterar la lista y buscar una coincidencia, pide el valor en la posición 0. Los tests funcionan todos, pero a mi parecer no se debería testear así.

-Sobre el código

	-El metodo calcularMontoTotal para obtener el monto a cobrarle a un cliente, está ubicado en la librería y viola el encapsulamiento de varias clases (le pide al cliente todas sus compras y a cada compra todos sus productos, y la misma clase librería se encarga de sumar. Aquí se pudieron distribuír mejor las responsabilidades.
	-No se lanzan excepciones en ningun caso, porque no hay validaciones.

Mi trabajo:

Primero, agrego espaciado en el código. 
Luego refactorizo el método calcularMontoACobrar(Cliente cliente) para que ya no viole el encapsulamiento. 
También elimino la lista de clientes de la librería y los métodos para accederla, ya que jamás los usa (no valida), y el test que probaba ese método (inútil, ya que de nuevo, no realiza ninguna validación en el código), y quito las líneas sobrantes de todos los tests en las cuales agregaban el cliente a la librería.
Elimino la clase Program. 
Hago abstracta la clase Producto, no tiene sentido instanciar un Producto.

Implementación de la extensión:

Creo la clase abstracta Alquiler, con tres clases que heredan de ella: AlquilerMensual, AlquilerCuatrimestral y AlquilerDIario.
El alquiler tiene un periodo, medido en unidades de tiempo. Cada alquiler concreto conoce en que unidades de tiempo lo medirá.
El alquiler tiene también el precio del alquiler diario, el precio del alquiler mensual y el precio del alquiler cuatrimestral. Cuando las clases AlquilerDiario, AlquilerMensual y AlquilerCuatrimestral son creadas, se setean automaticamente ese precio llamando al metodo setPrecio de la clase Producto. De esta forma puedo modificar los precios de los alquileres en cualquier momento sin tener que tocar las clases concretas.
La clase AlquilerCuatrimestral ademas, al setear su precio, le descuenta el monto correspondiente.

