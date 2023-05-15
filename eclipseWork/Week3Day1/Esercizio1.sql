CREATE TABLE IF NOT EXISTS clienti(
	NumeroCliente SERIAL PRIMARY KEY,
	nome varchar NOT NULL,
	Cognome varchar NOT NULL,
	DataNascita DATE NOT NULL,
	regioneResidenza varchar NOT NULL
);

DROP TABLE clienti;

INSERT INTO clienti(nome, Cognome, DataNascita, regioneResidenza ) 
		VALUES 	('Mario', 'Rossi', '1/8/1999', 'Lazio'),
				('Giuseppe', 'Verdi', '15/10/2000', 'Lombardia'),
				('Francesca', 'Neri', '24/4/2003', 'Campania'),
				('Antonio', 'Gialli', '29/5/1999', 'Sicilia');

SELECT * FROM clienti;

DROP TABLE fatture;

CREATE TABLE IF NOT EXISTS  fatture(
	numeroFattura SERIAL PRIMARY KEY,
	tipologia varchar NOT NULL,
	importo float NOT NULL,
	iva VARCHAR NOT NULL DEFAULT '20%',
	idCliente int NOT NULL,
	dataDiFattura DATE NOT NULL,
	numeroFornitore int NOT NULL,
	FOREIGN KEY(idCliente) REFERENCES clienti(NumeroCliente),
	FOREIGN KEY(numeroFornitore) REFERENCES fornitori(numeroFornitore)
);

INSERT INTO fatture(tipologia, importo, iva, idCliente, dataDiFattura, numeroFornitore) 
		VALUES 	('A', '145.12', '10%', 2, '2/2/2022', 1),
				('B', '533.99', '20%', 1, '29/4/2022', 2),
				('A', '145.12', '20%', 3, '12/1/2023', 1),
				('A', '188.00', '15%', 2, '2/2/2023', 1);

SELECT * FROM fatture;

CREATE TABLE IF NOT EXISTS prodotti(
	idProdotto SERIAL PRIMARY KEY,
	descrizione varchar NOT NULL,
	inProduzione boolean NOT NULL DEFAULT 'false',
	inCommercio boolean NOT NULL DEFAULT 'false',
	dataAttivazione DATE NOT NULL,
	dataDisattivazione DATE
);

INSERT INTO prodotti (descrizione, inProduzione, inCommercio,  dataAttivazione, dataDisattivazione)
		VALUES 	('Prodotto x', true, false, '29/4/2017', '29/4/2023'),
				('Prodotto z', true, true, '15/9/2016', '15/9/2024'),
				('Prodotto q', false, false, '12/12/2017', '12/9/2022');

DROP TABLE prodotti;

DROP TABLE fornitori;



CREATE TABLE IF NOT EXISTS fornitori(
	numeroFornitore SERIAL PRIMARY KEY,
	denominazione varchar NOT NULL,
	regioneResidenza varchar NOT NULL
);

INSERT INTO fornitori(denominazione, regioneResidenza ) 
		VALUES 	('Epicode SRL', 'Lazio'),
				('JavaSchool SPA', 'Piemonte');
				
SELECT * FROM clienti;
SELECT * FROM fornitori;
SELECT * FROM fatture;
SELECT * FROM prodotti;	

SELECT nome,cognome FROM clienti WHERE EXTRACT(YEAR FROM DataNascita)=1999;
SELECT count(*) AS numero_fatture FROM fatture WHERE iva='20%'; 

SELECT EXTRACT(YEAR FROM dataDiFattura ) AS anno,
COUNT(*) as numero_fatture,
SUM(importo) AS importo FROM fatture GROUP BY EXTRACT(YEAR FROM dataDiFattura);

SELECT * FROM prodotti WHERE EXTRACT(YEAR FROM dataAttivazione) =2017 AND (inProduzione=true OR inCommercio=true );

SELECT EXTRACT (YEAR FROM dataDiFattura) AS anno, COUNT(*) AS numero_fatture_20 FROM fatture WHERE iva='20%' GROUP BY EXTRACT(YEAR FROM dataDiFattura);

SELECT EXTRACT(YEAR FROM dataDiFattura) AS anno,COUNT(*) AS numero_fatture_A FROM fatture WHERE tipologia='A' GROUP BY EXTRACT(YEAR FROM dataDiFattura) HAVING COUNT(*)>1;

SELECT numeroFattura,importo,iva,dataDiFattura,denominazione FROM fatture AS fa INNER JOIN fornitori AS fo ON fa.numeroFornitore = fo.numeroFornitore;

SELECT * FROM fatture AS fa INNER JOIN clienti as cl ON fa.idCliente=cl.NumeroCliente;