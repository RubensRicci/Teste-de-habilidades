DROP TABLE IF EXISTS tb_Clientes;

CREATE TABLE tb_Clientes(
	id_cli serial PRIMARY KEY,
	nome_cli VARCHAR(15) NOT NULL,
	sobrenome_cli VARCHAR (30) NOT NULL,
	categoria_cli VARCHAR (50) NOT NULL
);

INSERT INTO tb_Clientes (nome_cli, sobrenome_cli, categoria_cli) 
VALUES ('John', 'Doe', 'Vendedor'), 
	   ('Marge', 'Bouvier', 'Comprador'),
	   ('Matt', 'Daemon', 'Vendedor'),
	   ('Canjica', 'Nunes', 'Vendedor,Comprador'),
	   ('Kevin ', 'Morrison', 'Vendedor'),
	   ('Nicole ', 'Fuller', 'Comprador'),
	   ('Jael', 'Filho', 'Comprador'),
	   ('Cajá', 'Mendes', 'Vendedor'),
	   ('Noah', 'Santos', 'Comprador'),
	   ('Maria', 'Cardoso', 'Comprador'),
	   ('Jaqueline', 'Naum', 'Vendedor,Comprador'),
	   ('Jacira', 'Teixeira', 'Comprador'),
	   ('Jessica', 'Vargas', 'Vendedor,Comprador'),
	   ('Jânides', 'Smith', 'Vendedor,Comprador'),
	   ('João', 'Johnson', 'Vendedor,Comprador'),
	   ('Marija', 'Mendes', 'Vendedor,Comprador');
							   
SELECT nome_cli,sobrenome_cli,categoria_cli 
FROM tb_Clientes 
WHERE categoria_cli LIKE 'Vendedor,Comprador'AND nome_cli ~ '[Jj]' ORDER BY sobrenome_cli LIMIT 10;


