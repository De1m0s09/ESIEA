select titre from film order by titre asc;
select nom, annee_naissance from artiste where annee_naissance < 1950 order by nom asc;
select nom_cinema from cinema where arrondissement = 12;

select * from artiste where nom like 'H%';
select * from artiste where annee_naissance is null;
select count(*) from role where nom_acteur = 'Willis';
select nom,prenom from artiste where nom in ( select nom_acteur from role where nom_role = 'Tarzan' );
select nom, prenom from artiste where nom in (select nom_acteur from role where id_film in (select id_film from film where titre = 'Vertigo'));
select film.titre, seance.heure_debut from film, seance where seance.nom_cinema = 'Rex' and seance.id_film = film.id_film;
select film.titre, role.nom_role from film, role where role.id_film = film.id_film and role.nom_acteur = 'Allen';
select titre, nom_realisateur from film where film.nom_realisateur in (select nom_acteur from role);
select nom_cinema, adresse from cinema where cinema.nom_cinema in (select nom_cinema from seance where seance.id_film in (select id_film from film where titre = 'Shining'));
