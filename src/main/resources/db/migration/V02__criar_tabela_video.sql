CREATE TABLE video(
id BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
categoria_id BIGINT(20),
titulo VARCHAR(100),
url VARCHAR(100),
foreign key(categoria_id) references categoria(id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;