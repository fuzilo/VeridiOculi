create database veridi_oculi;
use veridi_oculi;

create table usuario(
id_usuario int auto_increment not null primary key,
nome_usuario varchar(150),
login_usuario varchar(100),
senha_usuario varchar(100),
cpf varchar(15),
email varchar(100),
telefone int (14),
dt_nasc date,
dt_criacao timestamp default current_timestamp,
dt_val_licenca datetime
);

create table img_upload(
id_img_upload int auto_increment not null primary key,
id_usuario int,
nome_imagem varchar(100),
sirgas varchar(50),
dt_upload timestamp default current_timestamp,
dt_geracao date,
tamanho_imagem double,
constraint fk_usuario foreign key (id_usuario) references usuario(id_usuario)
);

create table classificacao(
id_classificacao int auto_increment not null primary key,
sigla varchar(4),
descricao varchar(200),
escala int
);

create table especie(
id_especie int auto_increment not null primary key,
id_classificacao int,
nome_especie varchar(150),
nome_familia varchar(150),
constraint fk_classificacao foreign key (id_classificacao) references classificacao(id_classificacao)
);

create table img_banco(
id_img_banco int auto_increment not null primary key,
id_especie int,
nome_imagem varchar(100),
dt_geracao timestamp default current_timestamp,
tamanho_imagem double,
constraint fk_especie foreign key (id_especie) references especie(id_especie)
);

create table comparacao(
id_comparacao int auto_increment not null primary key,
id_img_upload int,
id_img_banco int,
dt_comparacao timestamp default current_timestamp,
acuracia double,
coord_x double,
coord_y double,
constraint fk_img_upload foreign key (id_img_upload) references img_upload(id_img_upload),
constraint fk_img_banco foreign key (id_img_banco) references img_banco(id_img_banco)
);

create table diagnostico(
id_diagnostico int auto_increment not null primary key,
id_comparacao int,
nome_especie varchar(150),
acuracia double,
coord_x double,
coord_y double,
sigla varchar(4),
constraint fk_comparacao foreign key (id_comparacao) references comparacao(id_comparacao)
);

create table relatorio(
id_relatorio int auto_increment not null primary key,
id_diagnostico int,
constraint fk_diagnostico foreign key (id_diagnostico) references diagnostico(id_diagnostico)
);


INSERT INTO usuario (nome_usuario, login_usuario, senha_usuario, cpf, email, telefone, dt_nasc, dt_val_licenca)
VALUES
    ('João Silva', 'joaosilva', '123456', '111.111.111-11', 'joao@example.com', 234567890, '1990-01-01', '2023-12-31'),
    ('Maria Souza', 'mariasouza', 'abcdef', '222.222.222-22', 'maria@example.com', 876543210, '1985-05-10', '2024-06-30'),
    ('Pedro Santos', 'pedrosantos', 'qwerty', '333.333.333-33', 'pedro@example.com', 876543210, '1992-11-15', '2023-10-15'),
    ('Ana Lima', 'anacarvalho', 'zxcvbn', '444.444.444-44', 'ana@example.com', 234567890, '1988-07-20', '2023-12-31'),
    ('Lucas Oliveira', 'lucasoliveira', 'password', '555.555.555-55', 'lucas@example.com', 876543210, '1995-02-28', '2024-03-31'),
    ('Juliana Costa', 'julianacosta', 'abcdef', '666.666.666-66', 'juliana@example.com', 234567890, '1993-09-05', '2023-08-31'),
    ('Ricardo Santos', 'ricardosantos', 'qwerty', '777.777.777-77', 'ricardo@example.com', 876543210, '1987-12-12', '2023-12-31'),
    ('Fernanda Pereira', 'fernandapereira', 'zxcvbn', '888.888.888-88', 'fernanda@example.com', 234567890, '1991-04-25', '2024-02-28'),
    ('Gustavo Rodrigues', 'gustavorodrigues', 'password', '999.999.999-99', 'gustavo@example.com', 876543210, '1989-08-30', '2023-09-30'),
    ('Carolina Costa', 'carolinacosta', 'abcdef', '123.456.789-00', 'carolina@example.com', 234567890, '1994-03-15', '2023-12-31'),
    ('Paulo Fernandes', 'paulofernandes', 'qwerty', '234.567.890-11', 'paulo@example.com', 976543210, '1986-06-18', '2024-01-31'),
    ('Mariana Oliveira', 'marianaoliveira', 'zxcvbn', '345.678.901-22', 'mariana@example.com', 134567890, '1997-10-23', '2023-11-30'),
    ('Roberto Santos', 'robertosantos', 'password', '456.789.012-33', 'roberto@example.com', 986543210, '1984-03-08', '2023-12-31');
