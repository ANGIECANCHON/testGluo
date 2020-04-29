Comandos para compilar el proyecto
```bash
$ gradle clean assemble
$ gradle compileJava
```
"Nota: El comando gradle clean assemble ejecuta el compileJava por defecto."

Comandos para ejecutar los test

Para test login error
```bash
 gradle test --tests DportenisRunner
```
Para test error al agregar al carrito
```bash
 gradle test --tests SelectProductsRunner
```
Para test agregar al carrito y quitar producto
```bash
 gradle test --tests ShoppingCart
```

