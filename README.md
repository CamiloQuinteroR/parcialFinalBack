Camilo Andres Quintero Rdoriguez
Grupo 2


Diagrama de arquitectura:
Primero se crea el modelo de datos:
![image](https://github.com/user-attachments/assets/33c87e3c-9954-418d-ab63-8f9b9a1d9ca4)

Instrucciones para ejecutar:
Nos dirigimos al directorio donde se encuentra el pom.xml y allí ejecutamos el comando mvn clean package:

![image](https://github.com/user-attachments/assets/e65dca05-aa0b-4ab6-8948-5df2454a20d6)

Se ejecutarán las pruebas se compilará el proyecto:

![image](https://github.com/user-attachments/assets/c452132b-9c7d-4ab1-bc8d-726882f3c6a3)

Pruebas con postman:

![image](https://github.com/user-attachments/assets/bfb44841-0765-469e-9c07-9fc751d9a130)

![image](https://github.com/user-attachments/assets/8290f505-37d4-4e8a-b464-f39de8717375)


Lista de enpoitns para Citas:

@PostMapping
/Cita/create/

@GetMapping
/Cita/getAll
/Cita/getCita/{id}

@DeleteMapping
/Cita/deleteCita/{id}
/Cita/deleteAll


Lista de enpoitns para User:

@PutMapping
/Especialidad/create

@GetMapping
/Especialidad/getAll
/Especialidad/getEspecialidad/{id}

@DeleteMappin
/Especialidad/deleteAll
/Especialidad/deleteEspecialidad/{id}

Lista de enpoitns para Especialidad:

@PostMapping
/User/create

@GetMapping
/User/getAll
/User/getUser/{id}

@DeleteMapping
/User/deleteUser/{id}


Como se puede evidenciar se logró un 60% en covertura:

![image](https://github.com/user-attachments/assets/a8ed8ef1-ab75-4f77-9b57-a2018dca00d9)

