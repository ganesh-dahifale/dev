CREATE table `users`(
	`username` varchar(50) Not null,
    `password` varchar(50) not null,
    `enabled` tinyint not null,
    primary key(`username`)
)