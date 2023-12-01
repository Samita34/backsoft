-- Table: usuarios
CREATE TABLE usuarios (
    userid INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    apellido VARCHAR(100) NOT NULL,
    nombreusuario VARCHAR(50) NOT NULL,
    correo VARCHAR(255) NOT NULL,
    fotoperfil BLOB NULL,
    CONSTRAINT ak_0 UNIQUE (nombreusuario)
);

-- Table: categoria
CREATE TABLE categoria (
    categoriaid INT AUTO_INCREMENT PRIMARY KEY,
    nombrecategoria VARCHAR(50) NOT NULL
);

-- Table: ingredientes
CREATE TABLE ingredientes (
    ingredienteid INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    tipo VARCHAR(50) NULL,
    cantidad INT NOT NULL
);

-- Table: recetas
CREATE TABLE recetas (
    recetaid INT AUTO_INCREMENT PRIMARY KEY,
    userid INT NOT NULL,
    nombrereceta VARCHAR(255) NOT NULL,
    procedimiento TEXT NOT NULL,
    tiempopreparacion INT NOT NULL,
    porciones INT NOT NULL,
    descripcioncorta TEXT NOT NULL,
    imagenreceta BLOB NOT NULL,
    categoria_categoriaid INT NOT NULL,
    FOREIGN KEY (userid) REFERENCES usuarios (userid),
    FOREIGN KEY (categoria_categoriaid) REFERENCES categoria (categoriaid)
);

-- Table: calificaciones
CREATE TABLE calificaciones (
    calificacionid INT AUTO_INCREMENT PRIMARY KEY,
    recetaid INT NOT NULL,
    userid INT NOT NULL,
    puntuacion INT NULL,
    fechahora TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
    CHECK (puntuacion BETWEEN 1 AND 5),
    FOREIGN KEY (recetaid) REFERENCES recetas (recetaid),
    FOREIGN KEY (userid) REFERENCES usuarios (userid)
);

-- Table: comentarios
CREATE TABLE comentarios (
    comentarioid INT AUTO_INCREMENT PRIMARY KEY,
    recetaid INT NOT NULL,
    userid INT NOT NULL,
    textocomentario TEXT NOT NULL,
    fechahora TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (recetaid) REFERENCES recetas (recetaid),
    FOREIGN KEY (userid) REFERENCES usuarios (userid)
);

-- Table: listasdecompras
CREATE TABLE listasdecompras (
    listaid INT AUTO_INCREMENT PRIMARY KEY,
    userid INT NOT NULL,
    nombrelista VARCHAR(255) NULL,
    FOREIGN KEY (userid) REFERENCES usuarios (userid)
);

-- Table: listasdecompras_ingredientes
CREATE TABLE listasdecompras_ingredientes (
    liscomprasingredientesid INT AUTO_INCREMENT PRIMARY KEY,
    listaid INT NOT NULL,
    ingredienteid INT NOT NULL,
    FOREIGN KEY (listaid) REFERENCES listasdecompras (listaid),
    FOREIGN KEY (ingredienteid) REFERENCES ingredientes (ingredienteid)
);

-- Table: recetasguardadas
CREATE TABLE recetasguardadas (
    recetasguardadasid INT AUTO_INCREMENT PRIMARY KEY,
    userid INT NOT NULL,
    recetaid INT NOT NULL,
    fechahora TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (userid) REFERENCES usuarios (userid),
    FOREIGN KEY (recetaid) REFERENCES recetas (recetaid)
);

-- Table: recetas_ingredientes
CREATE TABLE recetas_ingredientes (
    receingreid INT AUTO_INCREMENT PRIMARY KEY,
    recetaid INT NOT NULL,
    ingredienteid INT NOT NULL,
    FOREIGN KEY (recetaid) REFERENCES recetas (recetaid),
    FOREIGN KEY (ingredienteid) REFERENCES ingredientes (ingredienteid)
);
