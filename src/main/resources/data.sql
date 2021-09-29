
INSERT INTO `city` VALUES (1,'DELHI'),(2,'Gurgaon');
INSERT INTO `theatre` VALUES (1,'PVR',1),(2,'INOX',1);
INSERT INTO `auditorium` 
VALUES (1,5,1),(2,5,1),(3,5,1),(4,5,2),(5,5,2),(6,5,2);
INSERT INTO `movie` 
VALUES 
(1,'Movie1','Action',110),
(2,'Movie2','Action',120),
(3,'Movie3','Romance',130),
(4,'Movie4','Action',140),
(5,'Movie5','Sci Fi',150);

INSERT INTO `screening` VALUES 
(1,'2019-08-16','2020-01-02 12:00:00','2020-01-02 10:00:00',1,5,'TRUE','250.00'),
(2,'2019-08-16','2020-01-02 12:00:00','2020-01-02 10:00:00',1,5,'TRUE','250.00');;


INSERT INTO `seat` 
VALUES 
(1,1,1),(2,2,1),(3,3,1),
(4,4,1),(5,5,1),(6,1,2),
(7,2,2),(8,3,2),(9,4,2),
(10,5,2);

 INSERT INTO `booking` 
VALUES (1,'2020-01-02 10:00:00','TRUE','TRUE',1);


 INSERT INTO `seat_booked` 
VALUES (1,1,1,1);















