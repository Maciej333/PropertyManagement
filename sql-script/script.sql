DROP TABLE IF EXISTS property;
CREATE TABLE property (
	id INT PRIMARY KEY AUTO_INCREMENT,
	property_name VARCHAR(45),
    address VARCHAR(120)   
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS announcement;
CREATE TABLE announcement (
	id INT PRIMARY KEY AUTO_INCREMENT,
	property_id INT,
	title VARCHAR(45),
    date_from DATE,
    date_to DATE,
    announcement_text VARCHAR(2000),
	FOREIGN KEY (property_id) REFERENCES property(id) ON DELETE CASCADE   
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS user;
CREATE TABLE user (
	username VARCHAR(45) PRIMARY KEY,
    user_password VARCHAR(68) NOT NULL,
	first_name varchar(45),
	last_name varchar(45),
    phone_number INT,
	property_id INT,
	apartment_number SMALLINT,
	user_property_role varchar(45),
    enabled TINYINT(1),
	FOREIGN KEY (property_id) REFERENCES property(id) ON DELETE CASCADE 
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS role;
CREATE TABLE role (
	username VARCHAR(45),
	user_role VARCHAR(20),
    PRIMARY KEY (username, user_role),
    FOREIGN KEY (username) REFERENCES user(username) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS notification;
CREATE TABLE notification (
	id INT PRIMARY KEY AUTO_INCREMENT,
	title VARCHAR(45),
    send_date DATE,
    sender VARCHAR(45),
	receiver VARCHAR(45),
	new_to VARCHAR(45),
    notification_text VARCHAR(2000),
    response_to_id INT,
    FOREIGN KEY (sender) REFERENCES user(username) ON DELETE CASCADE,
    FOREIGN KEY (receiver) REFERENCES user(username) ON DELETE CASCADE,
	FOREIGN KEY (response_to_id) REFERENCES notification(id) ON DELETE CASCADE	
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;




INSERT INTO property VALUES(1, "Stokrotka","Warszawa ul. Pawła 5");
INSERT INTO property VALUES(2, "Rivian","Warszawa ul. Kasi Morge 3");

INSERT INTO announcement VALUES(1,1,"Przegląd instalacji sanitarnej",CURDATE(),CURDATE(),"Przegląd odbędzie się 19.10.2020 w godzinach 11:00 do 19:00. Przegląd wykona firma 'Mario i przyjaciele'. Przypominamy o obowiązku wykonania przeglądu.");
INSERT INTO announcement VALUES(2,1,"Przegląd instalacji kominowej",DATE("2020-10-02"),DATE("2020-10-05"),"Przegląd odbędzie się 05.10.2020 w godzinach od 15:00 do 20:00. Obecność w lokalach obowiązkowa. Przegląd wykona firma 'Czyste Kominy'.");
INSERT INTO announcement VALUES(3,1,"Pomiar wodomierzy",DATE("2020-12-01"),DATE("2020-12-05"),"Z uwagi na planowaną wymianę wodomierzy, należy wykonać odczyt wszystkich wodomierzy we wspólnocie. Pomiary wykona gospodarz nieruchomości p. Bożydar Brzęczyszczykiewicz. Prosimy o obecność w lokalach.");
INSERT INTO announcement VALUES(4,1,"Zebranie wspólnoty",DATE("2020-10-19"),DATE("2020-10-25"),"Zapraszamy wszystkich właścicieli lokali na zebranie wspólnoty, które odbędzie się 25.10.2020 o godz. 20:00 w piwnicy lokalu 3. Poruszymy kwestie wykonania muralu na szczytowej ścianie obiektu.");
INSERT INTO announcement VALUES(5,1,"Wymiana wodomierzy",DATE("2020-12-04"),DATE("2020-12-10"),"W dniu 10.12.2020 odbędzie się obowiązkowa wymiana wodomierzy. W godzinach od 8:00 do 20:00 firma 'Miłość do hydrauliki' dokona wymiany wodomierzy w lokalach budynku.");
INSERT INTO announcement VALUES(6,1,"Zebranie wspólnoty",DATE("2020-11-15"),DATE("2020-11-21"),"Zapraszamy wszystkich właścicieli lokali w dniu 21.11.2020 o godz. 20 do piwnicy lokalu 3, na zebranie podsumowujące. Na zebraniu poruszymy też temat nadchodzącego roku.");
INSERT INTO announcement VALUES(7,1,"Przeglad instalacji gazowej",DATE("2020-11-17"),DATE("2020-11-19"),"W dniu 19.11.2020 w godzinach 16:00 do 20:00 odbędzie się przegląd instalacji gazowej. Przegląd wykona firma 'Bezpieczny dom'. Prosimy o obecność w lokalach.");
INSERT INTO announcement VALUES(8,2,"Głosowanie w sprawie zmiany zarządu",DATE("2020-10-19"),DATE("2020-10-25"),"W dniu 25.10.2020 o godz. 20:00 na dziedzińcu środkowym, zapraszamy wszystkich lokatorów do uczestnictwa w zebraniu. Poruszymy temat zmiany dotychczasowego zarządu. Coraz częściej pojawiają się skargi na obecnego przewodniczącego, który podobno swym śpiewem odstrasza nawet dostawców pizzy.");

INSERT INTO user VALUES("Stokrotka1","{bcrypt}$2a$04$eFytJDGtjbThXa80FyOOBuFdK2IwjyWefYkMpiBEFlpBwDH.5PM0K","Jan","Kowalski",111222333,1,1,"zarząd",1);
INSERT INTO role VALUES("Stokrotka1","ROLE_INHABITANT");
INSERT INTO user VALUES("Stokrotka2","{bcrypt}$2a$04$eFytJDGtjbThXa80FyOOBuFdK2IwjyWefYkMpiBEFlpBwDH.5PM0K","Mieszko","Gniazdowski",111222333,1,2,"mieszkaniec",1);
INSERT INTO role VALUES("Stokrotka2","ROLE_INHABITANT");
INSERT INTO user VALUES("Stokrotka3","{bcrypt}$2a$04$eFytJDGtjbThXa80FyOOBuFdK2IwjyWefYkMpiBEFlpBwDH.5PM0K","Janko","Muzykant",111222333,1,3,"zarząd",1);
INSERT INTO role VALUES("Stokrotka3","ROLE_INHABITANT");
INSERT INTO user VALUES("Stokrotka4","{bcrypt}$2a$04$eFytJDGtjbThXa80FyOOBuFdK2IwjyWefYkMpiBEFlpBwDH.5PM0K","Jan","Kosik",111222333,1,4,"mieszkaniec",1);
INSERT INTO role VALUES("Stokrotka4","ROLE_INHABITANT");

INSERT INTO user VALUES("Rivia1","{bcrypt}$2a$04$eFytJDGtjbThXa80FyOOBuFdK2IwjyWefYkMpiBEFlpBwDH.5PM0K","Yenna","Venger",111222333,2,1,"mieszkaniec",1);
INSERT INTO role VALUES("Rivia1","ROLE_INHABITANT");
INSERT INTO user VALUES("Rivia2","{bcrypt}$2a$04$eFytJDGtjbThXa80FyOOBuFdK2IwjyWefYkMpiBEFlpBwDH.5PM0K","Gerwant","Rybia",111222333,2,1,"mieszkaniec",1);
INSERT INTO role VALUES("Rivia2","ROLE_INHABITANT");
INSERT INTO user VALUES("Rivia3","{bcrypt}$2a$04$eFytJDGtjbThXa80FyOOBuFdK2IwjyWefYkMpiBEFlpBwDH.5PM0K","Jaskier","Bardyński",111222333,2,2,"zarząd",1);
INSERT INTO role VALUES("Rivia3","ROLE_INHABITANT");

INSERT INTO user VALUES("admin1","{bcrypt}$2a$04$eFytJDGtjbThXa80FyOOBuFdK2IwjyWefYkMpiBEFlpBwDH.5PM0K","Zarzadca","Nieruchomości",999999999,null,0,"zarząd",1);
INSERT INTO role VALUES("admin1","ROLE_MANAGER");

INSERT INTO notification VALUES(1,"Kontakt telefoniczny",CURDATE(),"Stokrotka1","admin1","admin1","Dzień dobry, bardzo proszę o kontakt telefoniczny, planuję wykonać remont generalny i chciałbym ustalić nośność ścian.",null);
INSERT INTO notification VALUES(2,"Naruszenie części wspólnej",CURDATE(),"Stokrotka1","admin1","admin1","Dzień dobry, od ponad 2 tygodni, na spoczniku pięter 2 i 3, zalegają odpady poremontowe, utrudnia to komunikację i bardzo proszę o ich usunięcie.",null);
INSERT INTO notification VALUES(3,"Naruszenie części wspólnej",CURDATE(),"admin1","Stokrotka1",null,"Dzień dobry, bardzo dziękuję za informację. Już poinformowałem osobę odpowiedzialną na zajęcie spocznika, która zobowiązała się do usunięcia odpadów w przeciągu 2 dni.",2);
INSERT INTO notification VALUES(4,"Naruszenie części wspólnej",CURDATE(),"Stokrotka1","admin1",null,"Dziękuję bardzo za interwencję, odpady zniknęły.",2);
INSERT INTO notification VALUES(5,"Remont generalny",CURDATE(),"Stokrotka1","admin1","Stokrotka1","Dzień dobry zgodnie z ustaleniami podjąłem remont generalny. 21.10.2020 planowany jest termin usunięcia ściany działowej, w razie kontaktu mieszkańców wspólnoty dotyczących hałasu, proszę o ich poinformowanie, że najcięższe prace potrwają najdłużej 3 dni.",null);
INSERT INTO notification VALUES(6,"Remont generalny",CURDATE(),"admin1","Stokrotka1",null,"Dzień dobry, dziękuję bardzo za informację.",5);
INSERT INTO notification VALUES(7,"Zmiana zarządu",CURDATE(),"Rivia1","admin1","admin1","Zgłaszam się z prośbą o zorganizowanie zebrania w sprawie zmiany zarządu, nasz 'ukochany' przewodniczący całymi nocami przesiaduje na balkonie z gitarą i wyśpiewuje miłośne ballady, przez co uniemożliwia sen innym lokatorom. Przez pełniony przez siebie rolę czuję się bezkarnie, dlatego apeluję o interwencję!",null);

#zbieżność imion i nazwisk przypadkowa 