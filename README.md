# api-cadastro

API para cadastro de estabelecimentos. Objetivo dessa API é permitir que estabelecimentos comerciais sejam cadastrados e habilitados para transacionar.

# Detalhes:

# Cadastro/Criação:

POST http://localhost:8080/estabelecimentos 

{
		"nome_fantasia": "Restaurante da Lola",
		"cnpj": "63.149.524/0001-69",
	  "ramo_atividade": "Restaurante",
	  "status": "Pendente de Confirmação",
	  "adquirente": "Stone"
}

# Atualização de Status: 

PATCH http://localhost:8080/estabelecimentos/{id_stab}

{
	  "status": "Confirmado"
}

# Consulta Status:

GET http://localhost:8080/estabelecimentos/{id_stab}
