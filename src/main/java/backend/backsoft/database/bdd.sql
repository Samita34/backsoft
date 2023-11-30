-- Table: Usuarios
CREATE TABLE Usuarios (
    UserID INT AUTO_INCREMENT PRIMARY KEY,
    Nombre VARCHAR(100) NOT NULL,
    Apellido VARCHAR(100) NOT NULL,
    NombreUsuario VARCHAR(50) NOT NULL,
    Correo VARCHAR(255) NOT NULL,
    FotoPerfil BLOB NULL,
    CONSTRAINT AK_0 UNIQUE (NombreUsuario)
);

-- Table: Categoria
CREATE TABLE Categoria (
    CategoriaID INT AUTO_INCREMENT PRIMARY KEY,
    NombreCategoria VARCHAR(50) NOT NULL
);

-- Table: Ingredientes
CREATE TABLE Ingredientes (
    IngredienteID INT AUTO_INCREMENT PRIMARY KEY,
    Nombre VARCHAR(100) NOT NULL,
    Tipo VARCHAR(50) NULL,
    Cantidad INT NOT NULL
);

-- Table: Recetas
CREATE TABLE Recetas (
    RecetaID INT AUTO_INCREMENT PRIMARY KEY,
    UserID INT NOT NULL,
    NombreReceta VARCHAR(255) NOT NULL,
    Procedimiento TEXT NOT NULL,
    TiempoPreparacion INT NOT NULL,
    Porciones INT NOT NULL,
    DescripcionCorta TEXT NOT NULL,
    ImagenReceta BLOB NOT NULL,
    Categoria_CategoriaID INT NOT NULL,
    FOREIGN KEY (UserID) REFERENCES Usuarios (UserID),
    FOREIGN KEY (Categoria_CategoriaID) REFERENCES Categoria (CategoriaID)
);

-- Table: Calificaciones
CREATE TABLE Calificaciones (
    CalificacionID INT AUTO_INCREMENT PRIMARY KEY,
    RecetaID INT NOT NULL,
    UserID INT NOT NULL,
    Puntuacion INT NULL,
    FechaHora TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
    CHECK (Puntuacion BETWEEN 1 AND 5),
    FOREIGN KEY (RecetaID) REFERENCES Recetas (RecetaID),
    FOREIGN KEY (UserID) REFERENCES Usuarios (UserID)
);

-- Table: Comentarios
CREATE TABLE Comentarios (
    ComentarioID INT AUTO_INCREMENT PRIMARY KEY,
    RecetaID INT NOT NULL,
    UserID INT NOT NULL,
    TextoComentario TEXT NOT NULL,
    FechaHora TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (RecetaID) REFERENCES Recetas (RecetaID),
    FOREIGN KEY (UserID) REFERENCES Usuarios (UserID)
);

-- Table: ListasDeCompras
CREATE TABLE ListasDeCompras (
    ListaID INT AUTO_INCREMENT PRIMARY KEY,
    UserID INT NOT NULL,
    NombreLista VARCHAR(255) NULL,
    FOREIGN KEY (UserID) REFERENCES Usuarios (UserID)
);

-- Table: ListasDeCompras_Ingredientes
CREATE TABLE ListasDeCompras_Ingredientes (
    LisComprasIngredientesID INT AUTO_INCREMENT PRIMARY KEY,
    ListaID INT NOT NULL,
    IngredienteID INT NOT NULL,
    FOREIGN KEY (ListaID) REFERENCES ListasDeCompras (ListaID),
    FOREIGN KEY (IngredienteID) REFERENCES Ingredientes (IngredienteID)
);

-- Table: RecetasGuardadas
CREATE TABLE RecetasGuardadas (
    RecetasGuardadasID INT AUTO_INCREMENT PRIMARY KEY,
    UserID INT NOT NULL,
    RecetaID INT NOT NULL,
    FechaHora TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (UserID) REFERENCES Usuarios (UserID),
    FOREIGN KEY (RecetaID) REFERENCES Recetas (RecetaID)
);

-- Table: Recetas_Ingredientes
CREATE TABLE Recetas_Ingredientes (
    ReceIngreID INT AUTO_INCREMENT PRIMARY KEY,
    RecetaID INT NOT NULL,
    IngredienteID INT NOT NULL,
    FOREIGN KEY (RecetaID) REFERENCES Recetas (RecetaID),
    FOREIGN KEY (IngredienteID) REFERENCES Ingredientes (IngredienteID)
);
