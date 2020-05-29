-- phpMyAdmin SQL Dump
-- version 4.9.2
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le :  mer. 27 mai 2020 à 10:49
-- Version du serveur :  10.4.10-MariaDB
-- Version de PHP :  7.3.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `planning`
--

-- --------------------------------------------------------

--
-- Structure de la table `cours`
--

DROP TABLE IF EXISTS `cours`;
CREATE TABLE IF NOT EXISTS `cours` (
  `ID` int(255) NOT NULL AUTO_INCREMENT,
  `NOM` varchar(32) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `cours`
--

INSERT INTO `cours` (`ID`, `NOM`) VALUES
(1, 'Java');

-- --------------------------------------------------------

--
-- Structure de la table `ensignant`
--

DROP TABLE IF EXISTS `ensignant`;
CREATE TABLE IF NOT EXISTS `ensignant` (
  `ID_UTILISATEUR` int(255) NOT NULL,
  `ID_SEANCE` int(255) NOT NULL,
  PRIMARY KEY (`ID_UTILISATEUR`,`ID_SEANCE`),
  KEY `ID_SEANCE` (`ID_SEANCE`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `ensignant`
--

INSERT INTO `ensignant` (`ID_UTILISATEUR`, `ID_SEANCE`) VALUES
(2, 1);

-- --------------------------------------------------------

--
-- Structure de la table `etudiant`
--

DROP TABLE IF EXISTS `etudiant`;
CREATE TABLE IF NOT EXISTS `etudiant` (
  `ID_UTILISATEUR` int(255) NOT NULL,
  `NUMERO` int(255) NOT NULL,
  `ID_GROUPE` int(255) NOT NULL,
  PRIMARY KEY (`ID_UTILISATEUR`),
  KEY `ID_GROUPE` (`ID_GROUPE`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `etudiant`
--

INSERT INTO `etudiant` (`ID_UTILISATEUR`, `NUMERO`, `ID_GROUPE`) VALUES
(1, 1, 8);

-- --------------------------------------------------------

--
-- Structure de la table `groupe`
--

DROP TABLE IF EXISTS `groupe`;
CREATE TABLE IF NOT EXISTS `groupe` (
  `ID` int(255) NOT NULL AUTO_INCREMENT,
  `NOM` varchar(32) NOT NULL,
  `ID_PROMOTION` int(255) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `ID_PROMOTION` (`ID_PROMOTION`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `groupe`
--

INSERT INTO `groupe` (`ID`, `NOM`, `ID_PROMOTION`) VALUES
(8, 'TD8', 1);

-- --------------------------------------------------------

--
-- Structure de la table `promotion`
--

DROP TABLE IF EXISTS `promotion`;
CREATE TABLE IF NOT EXISTS `promotion` (
  `ID` int(255) NOT NULL AUTO_INCREMENT,
  `NOM` varchar(32) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `promotion`
--

INSERT INTO `promotion` (`ID`, `NOM`) VALUES
(1, '2022');

-- --------------------------------------------------------

--
-- Structure de la table `salle`
--

DROP TABLE IF EXISTS `salle`;
CREATE TABLE IF NOT EXISTS `salle` (
  `ID` int(255) NOT NULL AUTO_INCREMENT,
  `NOM` varchar(32) NOT NULL,
  `CAPACITE` int(255) NOT NULL,
  `ID_SITE` int(255) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `ID_SITE` (`ID_SITE`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `salle`
--

INSERT INTO `salle` (`ID`, `NOM`, `CAPACITE`, `ID_SITE`) VALUES
(1, 'em101', 300, 1);

-- --------------------------------------------------------

--
-- Structure de la table `seance`
--

DROP TABLE IF EXISTS `seance`;
CREATE TABLE IF NOT EXISTS `seance` (
  `ID` int(255) NOT NULL AUTO_INCREMENT,
  `SEMAINE` int(11) NOT NULL,
  `DATE` date NOT NULL,
  `HEURE_DEBUT` time NOT NULL,
  `HEURE_FIN` time NOT NULL,
  `ETAT` tinyint(1) NOT NULL,
  `ID_COURS` int(255) NOT NULL,
  `ID_TYPE` int(255) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `ID_COURS` (`ID_COURS`),
  KEY `ID_TYPE` (`ID_TYPE`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `seance`
--

INSERT INTO `seance` (`ID`, `SEMAINE`, `DATE`, `HEURE_DEBUT`, `HEURE_FIN`, `ETAT`, `ID_COURS`, `ID_TYPE`) VALUES
(1, 21, '2020-05-19', '13:45:00', '15:15:00', 0, 1, 3);

-- --------------------------------------------------------

--
-- Structure de la table `seance_ensignants`
--

DROP TABLE IF EXISTS `seance_ensignants`;
CREATE TABLE IF NOT EXISTS `seance_ensignants` (
  `ID_SEANCE` int(255) NOT NULL,
  `ID_ENSEIGNANT` int(255) NOT NULL,
  PRIMARY KEY (`ID_SEANCE`,`ID_ENSEIGNANT`),
  KEY `ID_ENSEIGNANT` (`ID_ENSEIGNANT`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `seance_ensignants`
--

INSERT INTO `seance_ensignants` (`ID_SEANCE`, `ID_ENSEIGNANT`) VALUES
(1, 2);

-- --------------------------------------------------------

--
-- Structure de la table `seance_groupe`
--

DROP TABLE IF EXISTS `seance_groupe`;
CREATE TABLE IF NOT EXISTS `seance_groupe` (
  `ID_SEANCE` int(255) NOT NULL,
  `ID_GROUPE` int(255) NOT NULL,
  PRIMARY KEY (`ID_SEANCE`,`ID_GROUPE`),
  KEY `ID_GROUPE` (`ID_GROUPE`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `seance_groupe`
--

INSERT INTO `seance_groupe` (`ID_SEANCE`, `ID_GROUPE`) VALUES
(1, 8);

-- --------------------------------------------------------

--
-- Structure de la table `seance_salle`
--

DROP TABLE IF EXISTS `seance_salle`;
CREATE TABLE IF NOT EXISTS `seance_salle` (
  `ID_SEANCE` int(255) NOT NULL,
  `ID_SALLE` int(255) NOT NULL,
  PRIMARY KEY (`ID_SEANCE`,`ID_SALLE`),
  KEY `ID_SALLE` (`ID_SALLE`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `seance_salle`
--

INSERT INTO `seance_salle` (`ID_SEANCE`, `ID_SALLE`) VALUES
(1, 1);

-- --------------------------------------------------------

--
-- Structure de la table `site`
--

DROP TABLE IF EXISTS `site`;
CREATE TABLE IF NOT EXISTS `site` (
  `ID` int(255) NOT NULL AUTO_INCREMENT,
  `NOM` varchar(32) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `site`
--

INSERT INTO `site` (`ID`, `NOM`) VALUES
(1, 'EFFEIL_1');

-- --------------------------------------------------------

--
-- Structure de la table `type_cours`
--

DROP TABLE IF EXISTS `type_cours`;
CREATE TABLE IF NOT EXISTS `type_cours` (
  `ID` int(255) NOT NULL AUTO_INCREMENT,
  `NOM` varchar(32) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `type_cours`
--

INSERT INTO `type_cours` (`ID`, `NOM`) VALUES
(1, 'COURS'),
(2, 'TD'),
(3, 'TP'),
(4, 'EXAMEN');

-- --------------------------------------------------------

--
-- Structure de la table `utilisateur`
--

DROP TABLE IF EXISTS `utilisateur`;
CREATE TABLE IF NOT EXISTS `utilisateur` (
  `ID` int(255) NOT NULL AUTO_INCREMENT,
  `EMAIL` varchar(32) NOT NULL,
  `PASSWD` varchar(32) NOT NULL,
  `NOM` varchar(32) NOT NULL,
  `PREMON` varchar(32) NOT NULL,
  `DROIT` int(5) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `utilisateur`
--

INSERT INTO `utilisateur` (`ID`, `EMAIL`, `PASSWD`, `NOM`, `PREMON`, `DROIT`) VALUES
(1, 'mat.brionne@gmail.com', '1234', 'Brionne', 'Mathis', 4),
(2, 'JDOUDI@edu.ece.fr', '1234', 'Jdoudi', 'Joudi', 3);

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `ensignant`
--
ALTER TABLE `ensignant`
  ADD CONSTRAINT `ensignant_ibfk_1` FOREIGN KEY (`ID_SEANCE`) REFERENCES `seance` (`ID`),
  ADD CONSTRAINT `ensignant_ibfk_2` FOREIGN KEY (`ID_UTILISATEUR`) REFERENCES `utilisateur` (`ID`);

--
-- Contraintes pour la table `etudiant`
--
ALTER TABLE `etudiant`
  ADD CONSTRAINT `etudiant_ibfk_1` FOREIGN KEY (`ID_UTILISATEUR`) REFERENCES `utilisateur` (`ID`),
  ADD CONSTRAINT `etudiant_ibfk_2` FOREIGN KEY (`ID_GROUPE`) REFERENCES `groupe` (`ID`);

--
-- Contraintes pour la table `groupe`
--
ALTER TABLE `groupe`
  ADD CONSTRAINT `groupe_ibfk_1` FOREIGN KEY (`ID_PROMOTION`) REFERENCES `promotion` (`ID`);

--
-- Contraintes pour la table `salle`
--
ALTER TABLE `salle`
  ADD CONSTRAINT `salle_ibfk_1` FOREIGN KEY (`ID_SITE`) REFERENCES `site` (`ID`);

--
-- Contraintes pour la table `seance`
--
ALTER TABLE `seance`
  ADD CONSTRAINT `seance_ibfk_1` FOREIGN KEY (`ID_COURS`) REFERENCES `cours` (`ID`),
  ADD CONSTRAINT `seance_ibfk_2` FOREIGN KEY (`ID_TYPE`) REFERENCES `type_cours` (`ID`);

--
-- Contraintes pour la table `seance_ensignants`
--
ALTER TABLE `seance_ensignants`
  ADD CONSTRAINT `seance_ensignants_ibfk_1` FOREIGN KEY (`ID_SEANCE`) REFERENCES `seance` (`ID`),
  ADD CONSTRAINT `seance_ensignants_ibfk_2` FOREIGN KEY (`ID_ENSEIGNANT`) REFERENCES `ensignant` (`ID_UTILISATEUR`);

--
-- Contraintes pour la table `seance_groupe`
--
ALTER TABLE `seance_groupe`
  ADD CONSTRAINT `seance_groupe_ibfk_1` FOREIGN KEY (`ID_GROUPE`) REFERENCES `groupe` (`ID`),
  ADD CONSTRAINT `seance_groupe_ibfk_2` FOREIGN KEY (`ID_SEANCE`) REFERENCES `seance` (`ID`);

--
-- Contraintes pour la table `seance_salle`
--
ALTER TABLE `seance_salle`
  ADD CONSTRAINT `seance_salle_ibfk_1` FOREIGN KEY (`ID_SALLE`) REFERENCES `salle` (`ID`),
  ADD CONSTRAINT `seance_salle_ibfk_2` FOREIGN KEY (`ID_SEANCE`) REFERENCES `seance` (`ID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
