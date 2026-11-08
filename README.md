# 🛒 Sistema de tienda

Sistema en Java para registrar usuarios de una tienda y sus compras, calcular el promedio de compra de cada uno y guardar la información en un archivo de texto. Toda la información se maneja con una **lista doblemente enlazada implementada desde cero**.

Proyecto del curso **Estructura de Datos** (Ingeniería de Sistemas, ITM), desarrollado en equipo con [Samuel Mejía](https://github.com/smejiadev05).

## ✨ Funcionalidades

- Registrar usuarios (nombre, cédula y teléfono) sin permitir cédulas repetidas.
- Buscar y eliminar usuarios por cédula.
- Agregar compras a cada usuario y calcular su **promedio de compra**.
- Guardar los usuarios en `historial_compras.txt` y volver a leerlos desde el archivo.

## 🧱 Estructura de datos

`ListaDoble<T>` es una lista doblemente enlazada genérica con referencias a `head` y `tail`:

| Operación | Complejidad |
|---|---|
| `addFirst`, `addLast` | O(1) |
| `removeFirst`, `removeLast` | O(1) |
| `remove(nodo)`, `addAfter`, `addBefore` | O(1) |
| Buscar usuario por cédula | O(n) |

Se usa en dos niveles: la lista de **usuarios** del sistema y, dentro de cada usuario, su lista de **compras**.

## 📂 Clases

| Clase | Responsabilidad |
|---|---|
| `NodoDoble<T>` | Nodo con referencias al anterior y al siguiente |
| `ListaDoble<T>` | Lista doblemente enlazada genérica |
| `Usuario` | Datos del usuario y su lista de compras |
| `Compra` | Valor pagado en una compra |
| `Sistema` | Operaciones del negocio y lectura/escritura del archivo |
| `Main` | Ejemplo de uso con datos de prueba |

## ▶️ Cómo ejecutarlo

Requiere Java 17 o superior.

```bash
javac -d out src/*.java
java -cp out Main
```

El programa crea `historial_compras.txt` en la carpeta desde donde se ejecuta.
