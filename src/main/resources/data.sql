INSERT INTO Endereco (logradouro, numero, cidade, estado, cep) VALUES ('Rua de Tal', 123, 'Campinas', 'São Paulo', 12123000);
INSERT INTO Client (cpf, name, data_nasc, id_endereco, client_category) VALUES (12345678900, 'Irineu', '2000-06-18', 1, 'SUPER');
INSERT INTO Conta (id_client, agencia, conta, saldo) VALUES (1, 1234, 654321, 100.0);
INSERT INTO Card (password, tax, active, id_conta) VALUES ('123456ab', 12.0, true, 1);
INSERT INTO Credit_Card(id_card, credit_limit, fatura) VALUES (1, 1000.0, 250.0);
INSERT INTO Conta_Corrente(id_conta, taxa_mensal, date_cobranca) VALUES (1, 11.0, '2021-05-11');
