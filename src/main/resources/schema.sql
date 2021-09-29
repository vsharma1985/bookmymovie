CREATE TABLE `city` (
  `city_id` INT NOT NULL,
  `city` varchar DEFAULT NULL,
  PRIMARY KEY (`city_id`)
);


CREATE TABLE `theatre`(
  `theatre_id` INT NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `city_id` INT NOT NULL,
  PRIMARY KEY (`theatre_id`),
  FOREIGN KEY (`city_id`) REFERENCES city(city_id)
  
);


CREATE TABLE `movie` (
  `movie_id` INT NOT NULL,
  `title` varchar(255) DEFAULT NULL,
  `genre` varchar(255) DEFAULT NULL,
  `duration` INT DEFAULT NULL, 
  PRIMARY KEY (`movie_id`)
) ;



CREATE TABLE `auditorium` (
  `auditorium_id` INT NOT NULL,
  `seat_count` INT DEFAULT NULL,
  `theatre_id` INT DEFAULT NULL,
  PRIMARY KEY (`auditorium_id`),
  FOREIGN KEY (theatre_id) REFERENCES theatre(theatre_id)
);

CREATE TABLE `screening` (
  `screening_id` INT NOT NULL,
  `movie_date` DATE,
  `end_time`  timestamp,
  `start_time` timestamp  ,
  `auditorium_id` INT DEFAULT NULL,
  `movie_id` INT DEFAULT NULL,
  `is_full` boolean DEFAULT FALSE,
  `price` DOUBLE DEFAULT NULL,
  PRIMARY KEY (`screening_id`),
  FOREIGN KEY  (`auditorium_id`) REFERENCES auditorium(auditorium_id),
  FOREIGN KEY  (`movie_id`) REFERENCES movie(movie_id)
);



CREATE TABLE `booking` (
  `booking_id` INT NOT NULL,
  `booking_time` timestamp,
  `is_active` boolean DEFAULT FALSE,
  `is_booked` boolean DEFAULT FALSE,
  `screening_id` INT DEFAULT NULL,
  PRIMARY KEY (`booking_id`),
  FOREIGN KEY  (`screening_id`) REFERENCES screening(screening_id)
) ;

CREATE TABLE `seat` (
  `seat_id` INT NOT NULL,
  `seat_number` INT DEFAULT NULL,
  `auditorium_id` INT DEFAULT NULL,
  PRIMARY KEY (`seat_id`),
  FOREIGN KEY (`auditorium_id`) REFERENCES auditorium(auditorium_id)
);


CREATE TABLE `seat_booked` (
  `seat_booked_id` INT NOT NULL,
  `booking_id` INT DEFAULT NULL,
  `screening_id` INT DEFAULT NULL,
  `seat_id` INT DEFAULT NULL,
  PRIMARY KEY (`seat_booked_id`),
  FOREIGN KEY  (`booking_id`) REFERENCES booking(booking_id),
  FOREIGN KEY  (`screening_id`) REFERENCES screening(screening_id),
  FOREIGN KEY  (`seat_id`) REFERENCES seat(seat_id)
) ;







