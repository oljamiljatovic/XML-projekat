INSERT INTO BANKA (NAZIV, KOD) VALUES('BANKA_C',123);
INSERT INTO BANKA (NAZIV, KOD) VALUES('BANKA_D',456);
INSERT INTO BANKA (NAZIV, KOD) VALUES('CENTRALNA_BANKA',111);
INSERT INTO FIRMA (NAZIV, ADRESA,PIB,URI) VALUES('FIRMA_A','Sime Milosevica 8','11111111111','http://localhost:8080/RESTApi/FIRMA_A');
INSERT INTO FIRMA (NAZIV, ADRESA,PIB,URI) VALUES('FIRMA_B','Dositejeva 12','22222222222','http://localhost:8080/RESTApi/FIRMA_B');
INSERT INTO POSLOVNI_SARADNICI (FIRMA1_ID,FIRMA2_ID) VALUES(1,2);
INSERT INTO POSLOVNI_SARADNICI (FIRMA1_ID,FIRMA2_ID) VALUES(2,1);

INSERT INTO ADMIN (MAIL, PASSWORD,USER_TYPE,BANKA_ID,FIRMA_ID) VALUES('1',1,'A',null,1);
INSERT INTO ADMIN (MAIL, PASSWORD,USER_TYPE,BANKA_ID,FIRMA_ID) VALUES('2',2,'A',null,2);




