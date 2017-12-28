CREATE TABLE USUARIO(
id_usuario SERIAL primary key,
nombre varchar(20) not null,
correo varchar(20) not null,
fecha date not null,
contrasenia varchar(20),
nickname varchar(20),
karma int(20)
)

CREATE TABLE HABILIDAD(
id_habilidad SERIAL primary key,
nombre varchar(20),
descripcion varchar(20)
)

CREATE TABLE LISTA_CONTACTO(
id_lista SERIAL primary key,
numero_contactos int
)

CREATE TABLE CHAT(
id_chat SERIAL primary key,
nombre varchar(30)
)

CREATE TABLE ASOCIACION(
id_asociacion SERIAL primary key,
nombre varchar(30),
resumen varchar(40)
)

CREATE TABLE TAREA(
id_tarea SERIAL primary key,
nombre varchar(30) not null,
descripcion varchar(100),
fecha date
)

CREATE TABLE MENSAJE(
id_mensaje SERIAL primary key,
descripcion varchar(100),
id_chat bigint(20) unsigned,
foreign key (id_chat) REFERENCES CHAT(id_chat)
)

CREATE TABLE USUARIO_CHAT(
id_usuario_chat SERIAL primary key,
id_usuario bigint(20) unsigned,
id_chat bigint(20) unsigned,
foreign key (id_usuario) references USUARIO(id_usuario),
foreign key (id_chat) references CHAT(id_chat)
)

CREATE TABLE ASOCIACION_USUARIO(
id_asociacion_usuario SERIAL primary key,
id_asociacion bigint(20) unsigned,
id_usuario bigint(20) unsigned,
foreign key (id_asociacion) references ASOCIACION(id_asociacion),
foreign key (id_usuario) references USUARIO(id_usuario)
)

CREATE TABLE USUARIO_LISTA(
id_usuario_lista SERIAL primary key,
id_usuario bigint(20) unsigned,
id_lista bigint(20) unsigned,
foreign key (id_usuario) references USUARIO(id_usuario),
foreign key (id_lista) references LISTA_CONTACTO(id_lista)
)

CREATE TABLE PROYECTO(
id_proyecto SERIAL primary key,
nombre varchar(40),
fecha date,
id_tarea bigint(20) unsigned,
foreign key (id_tarea) references TAREA(id_tarea)
)

CREATE TABLE PROYECTO_USUARIO(
id_proyecto_usuario SERIAL primary key,
id_proyecto bigint(20) unsigned,
id_usuario bigint(20) unsigned,
foreign key (id_proyecto) references PROYECTO(id_proyecto),
foreign key (id_usuario) references USUARIO(id_usuario)
)

CREATE TABLE CONOCIMIENTO(
id_conocimiento SERIAL primary key,
nombre varchar(30),
id_habilidad bigint(20) unsigned,
foreign key (id_habilidad) references habilidad(id_habilidad)
)

CREATE TABLE USUARIO_CONOCIMIENTO(
id_usuario_conocimiento SERIAL primary key,
id_usuario bigint(20) unsigned,
id_conocimiento bigint(20) unsigned,
foreign key (id_usuario) references USUARIO(id_usuario),
foreign key (id_conocimiento) references CONOCIMIENTO(id_conocimiento)
)

CREATE TABLE TAREA_CONOCIMIENTO(
id_tarea_conocmiento SERIAL primary key,
id_conocimiento bigint(20) unsigned,
id_tarea bigint(20) unsigned,
foreign key (id_conocimiento) references CONOCIMIENTO(id_conocimiento),
foreign key (id_tarea) references TAREA(id_tarea)
)





