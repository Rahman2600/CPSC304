create table rent (
    rent_id integer not null PRIMARY KEY,
    vehicle_id integer not null,
    cellphone integer,
    fromDate date not null,
    fromTime timestamp not null,
    toDate date not null,
    toTime timestamp not null,
    odometer integer not null,
    cardName varchar(20) not null,
    cardNo integer not null,
    expDate date not null,
    confNo integer not null
);

insert into rent values
(1, 1, 1, '01/01/17', '13:00', '01/01/17', '14:00', 1, 'test', 1, '01/01/17', 1);