# Franquicias

Para la ejecución de este proyecto es necesario crear una base de datos en mysql, una vez se cree esta base de datos setear los datos de la conexion con esta misma en el archivo application.properties del proyecto java.

### 🌟 Ejecución

#####  Via IntelliJ IDEA

1. Clona este repositorio
```
$ git clone https://github.com/XimenaLargo/franquicias-test.git
```
2. Abre la carpeta franquicias con IntelliJ IDEA
3. Una vez abierta debería verse con la siguiente estructura
```
   franquicias
   │   .mvn
   │   .gitignore
   │   avisos.log
   │   mvnw
   │   mvnw.cmd
   │   pom.xml
   └───src
```
4. Primero sustituye los valores del archivo application.properties por los valores de la base de datos local
```
DB_HOST
DB_PORT
DB_NAME
DB_USER
DB_PASSWORD
```
A continuacion iremos a la siguiente rua > main > java > com.test.franquicias and run the FranquiciasApplication

5. Una vez e haga correr el programa, debería verse la siguiente estructura y generarse la carpeta target
```
   ClinicaDentalApp
   │   .mvn
   │   .gitignore
   │   avisos.log
   │   mvnw
   │   mvnw.cmd
   │   pom.xml
   └───src
   └───target
```
#####  Desde la terminal

1. Clona este repositorio
```
$ git clone https://github.com/XimenaLargo/franquicias-test.git
```
2. Muévete a la carpeta franquicias con el siguiente comando
```
$ cd franquicias
```
3. Con el comando ls veras la siguiente estructura
```
   Franquicias
   │   .mvn
   │   .gitignore
   │   avisos.log
   │   mvnw
   │   mvnw.cmd
   │   pom.xml
   └───src
```
4. IMPORTANTE !!! Debes tener instalado Maven sigue el enlace para la intalacion  [here](https://maven.apache.org/install.html)

Primero sustituye los valores del archivo application.properties por los valores de la base de datos local
```
DB_HOST
DB_PORT
DB_NAME
DB_USER
DB_PASSWORD
```
Una vez te asegures que tienes maven instalado y cambies los valores de la base de datos en el application.properties  ejecutamos el siguiente comando:
```
$ mvn package
```
6. De nuevo ejecutaremos el comando ls y la estructura del proyecto tendrá una carpeta target
```
   Franquicias
   │   .mvn
   │   .gitignore
   │   avisos.log
   │   mvnw
   │   mvnw.cmd
   │   pom.xml
   └───src
   └───target
```
7. Ejecutaremos el siguiente comando y en la terminal se empezará a ejecutar nuestra aplicación
```
$ java -jar target/franquicias-0.0.1-SNAPSHOT.jar
```

## Pruebas en Postman


#### 1.Endpoint para agregar una franquicia
POST:
```
http://localhost:8080/api/v1/franchises/newFranchise
```
body:
```
{
    "name":"franquicia"
}
```
#### 2. Endpoint para agregar una nueva sucursal a una franquicia.
POST:
```
http://localhost:8080/api/v1/franchises/branches/newBranch
```
body:
```
{
    "name":"El rio",
    "franchise":{
    "idFranchise":1
}
```
#### 3. Endpoint para agregar un nuevo producto a una sucursal
POST:
```
http://localhost:8080/api/v1/branches/newProduct
```
body:
```
{
    "name":"nombre",
    "stock": 5000,
    "branch":{
        "idBranch":1
    }
}
```
#### 4. Endpoint para eliminar un producto de la sucursal
DELETE:
```
http://localhost:8080/api/v1/branches/products/{idProduct}
```

#### 5. Endpoint para modificar el stock de un producto
PUT:
```
http://localhost:8080/api/v1/products/changeStock/{idProduct}?stock={nuevoStock}
```

#### 6. Endpoint para mostrar cual es el producto que más stock tiene por sucursal para una franquicia puntual.
GET:
```
http://localhost:8080/api/v1/products/top-stock/{idFranchise}
```
#### 7. Endpoint que permite actualizar el nombre de una franquicia
PUT:
```
http://localhost:8080/api/v1/franchises/changeName/{idFranchise}?name={nuevoNombre}
```
#### 8. Endpoint que permite actualizar el nombre de una sucursal
PUT:
```
http://localhost:8080/api/v1/branches/changeName/{idBranch}?name={nuevoNombre}
```
#### 9. Endpoint que permite actualizar el nombre de un producto
PUT:
```
http://localhost:8080/api/v1/products/changeName/{idProduct}?name={nuevoNombre}
```
