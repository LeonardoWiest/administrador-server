INSERT
	INTO
		tb_usuario (id_usuario,
		tx_nome,
		tx_login,
		tx_senha,
		fl_superusuario,
		dt_cadastro,
		dt_manutencao,
		dt_exclusao)
	VALUES(1,
	'LEONARDO WIEST',
	'leonardo',
	'123456',
	'S',
	now(),
	now(),
	NULL);
