package com.example.effob.projetandroid;

import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

/**
 * Created by effob on 05/04/2018.
 */

//Classe permettant de remplir la base de données lors de sa création
public class Enregistrements {
    private SQLiteDatabase database;
    private PokedexOpenHelper helper;

    //Pokémons de la première Génération
    private Pokemon[] Generation1 = {
            new Pokemon("Bulbasaur",  "Bulbizarre", 1),
            new Pokemon("Ivysaur",    "Herbizarre", 2),
            new Pokemon("Venusaur",   "Florizarre", 3),
            new Pokemon("Charmander", "Salamèche",  4),
            new Pokemon("Charmeleon", "Reptincel",  5),
            new Pokemon("Charizard",  "Dracaufeu",  6),
            new Pokemon("Squirtle",   "Carapuce",   7),
            new Pokemon("Wartortle",  "Carabaffe",  8),
            new Pokemon("Blastoise",  "Tortank",    9),
            new Pokemon("Caterpie",   "Chenipan",   10),
            new Pokemon("Metapod",    "Chrysacier", 11),
            new Pokemon("Butterfree", "Papilusion", 12),
            new Pokemon("Weedle",     "Aspicot",    13),
            new Pokemon("Kakuna",     "Coconfort",  14),
            new Pokemon("Beedrill",   "Dardargnan", 15),
            new Pokemon("Pidgey",     "Roucool",    16),
            new Pokemon("Pidgeotto",  "Roucoops",   17),
            new Pokemon("Pidgeot",    "Roucarnage", 18),
            new Pokemon("Rattata",    "Rattata",    19),
            new Pokemon("Raticate",   "Rattatac",   20),
            new Pokemon("Spearow",    "Piafabec",   21),
            new Pokemon("Fearow",     "Rapasdepic", 22),
            new Pokemon("Ekans",      "Abo",        23),
            new Pokemon("Arbok",      "Arbok",      24),
            new Pokemon("Pikachu",    "Pikachu",    25),
            new Pokemon("Raichu",     "Raichu",     26),
            new Pokemon("Sandshrew",  "Sabelette",  27),
            new Pokemon("Sandslash",  "Sablaireau", 28),
            new Pokemon("Nidoran♀",   "Nidoran♀",   29),
            new Pokemon("Nidorina",   "Nidorina",   30),
            new Pokemon("Nidoqueen",  "Nidoqueen",  31),
            new Pokemon("Nidoran♂",   "Nidoran♂",   32),
            new Pokemon("Nidorino",   "Nidorino",   33),
            new Pokemon("Nidoking",   "Nidoking",   34),
            new Pokemon("Clefairy",   "Mélofée",    35),
            new Pokemon("Clefable",   "Mélodelfe",  36),
            new Pokemon("Vulpix",     "Goupix",     37),
            new Pokemon("Ninetales",  "Feunard",    38),
            new Pokemon("Jigglypuff", "Rondoudou",  39),
            new Pokemon("Wigglytuff", "Grodoudou",  40),
            new Pokemon("Zubat",      "Nosferapti", 41),
            new Pokemon("Golbat",     "Nosferalto", 42),
            new Pokemon("Oddish",     "Mystherbe",  43),
            new Pokemon("Gloom",      "Ortide",     44),
            new Pokemon("Vileplume",  "Rafflesia",  45),
            new Pokemon("Paras",      "Paras",      46),
            new Pokemon("Parasect",   "Parasect",   47),
            new Pokemon("Venonat",    "Mimitoss",   48),
            new Pokemon("Venomoth",   "Aéromite",   49),
            new Pokemon("Diglett",    "Taupiqueur", 50),
            new Pokemon("Dugtrio",    "Triopikeur", 51),
            new Pokemon("Meowth",     "Miaouss",    52),
            new Pokemon("Persian",    "Persian",    53),
            new Pokemon("Psyduck",    "Psykokwak",  54),
            new Pokemon("Golduck",    "Akwakwak",   55),
            new Pokemon("Mankey",     "Férosinge",  56),
            new Pokemon("Primeape",   "Colossinge", 57),
            new Pokemon("Growlithe",  "Caninos",    58),
            new Pokemon("Arcanine",   "Arcanin",    59),
            new Pokemon("Poliwag",    "Ptitard",    60),
            new Pokemon("Poliwhirl",  "Têtarte",    61),
            new Pokemon("Poliwrath",  "Tartard",    62),
            new Pokemon("Abra",       "Abra",       63),
            new Pokemon("Kadabra",    "Kadabra",    64),
            new Pokemon("Simsala",    "Alakazam",   65),
            new Pokemon("Machop",     "Machoc",     66),
            new Pokemon("Machoke",    "Machopeur",  67),
            new Pokemon("Machamp",    "Mackogneur", 68),
            new Pokemon("Bellsprout", "Chétiflor",  69),
            new Pokemon("Weepinbell", "Boustiflor", 70),
            new Pokemon("Victreebel", "Empiflor",   71),
            new Pokemon("Tentacool",  "Tentacool",  72),
            new Pokemon("Tentacruel", "Tentacruel", 73),
            new Pokemon("Geodude",    "Racaillou",  74),
            new Pokemon("Graveler",   "Gravalanch", 75),
            new Pokemon("Golem",      "Grolem",     76),
            new Pokemon("Ponyta",     "Ponyta",     77),
            new Pokemon("Rapidash",   "Galopa",     78),
            new Pokemon("Slowpoke",   "Ramoloss",   79),
            new Pokemon("Slowbro",    "Flagadoss",  80),
            new Pokemon("Magnemite",  "Magnéti",    81),
            new Pokemon("Magneton",   "Magnéton",   82),
            new Pokemon("Farfetch\'d","Canarticho", 83),
            new Pokemon("Doduo",      "Doduo",      84),
            new Pokemon("Dodrio",     "Dodrio",     85),
            new Pokemon("Seel",       "Otaria",     86),
            new Pokemon("Dewgong",    "Lamantine",  87),
            new Pokemon("Grimer",     "Tadmorv",    88),
            new Pokemon("Muk",        "Grotadmorv", 89),
            new Pokemon("Shellder",   "Kokiyas",    90),
            new Pokemon("Cloyster",   "Crustabri",  91),
            new Pokemon("Gastly",     "Fantominus", 92),
            new Pokemon("Haunter",    "Spectrum",   93),
            new Pokemon("Gengar",     "Ectoplasma", 94),
            new Pokemon("Onix",       "Onix",       95),
            new Pokemon("Drowzee",    "Soporifik",  96),
            new Pokemon("Hypno",      "Hypnomade",  97),
            new Pokemon("Krabby",     "Krabby",     98),
            new Pokemon("Kingler",    "Krabboss",   99),
            new Pokemon("Voltorb",    "Voltorbe",  100),
            new Pokemon("Electrode",  "Electrode", 101),
            new Pokemon("Exeggcute",  "Noeunoeuf", 102),
            new Pokemon("Exeggutor",  "Noadkoko",  103),
            new Pokemon("Cubone",     "Osselait",  104),
            new Pokemon("Marowak",    "Ossatueur", 105),
            new Pokemon("Hitmonlee",  "Kicklee",   106),
            new Pokemon("Hitmonchan", "Tygnon",    107),
            new Pokemon("Lickitung",  "Excelangue",108),
            new Pokemon("Koffing",    "Smogo",     109),
            new Pokemon("Weezing",    "Smogogo",   110),
            new Pokemon("Rhyhorn",    "Rhinocorne",111),
            new Pokemon("Rhydon",     "Rhinoféros",112),
            new Pokemon("Chansey",    "Leveinard", 113),
            new Pokemon("Tangela",    "Saquedeneu",114),
            new Pokemon("Kangaskhan", "Kangourex", 115),
            new Pokemon("Horsea",     "Hypotrempe",116),
            new Pokemon("Seadra",     "Hypocéan",  117),
            new Pokemon("Goldeen",    "Poissirène",118),
            new Pokemon("Seaking",    "Poissoroy", 119),
            new Pokemon("Staryu",     "Stari",     120),
            new Pokemon("Starmie",    "Staross",   121),
            new Pokemon("M.Mime",     "M.Mime",    122),
            new Pokemon("Scyther",    "Insécateur",123),
            new Pokemon("Jynx",       "Lippoutou", 124),
            new Pokemon("Elektek",    "Electabuzz",125),
            new Pokemon("Magmar",     "Magmar",    126),
            new Pokemon("Pinsir",     "Scarabrute",127),
            new Pokemon("Tauros",     "Tauros",    128),
            new Pokemon("Magikarp",   "Magicarpe", 129),
            new Pokemon("Gyarados",   "Léviator",  130),
            new Pokemon("Lapras",     "Lokhlass",  131),
            new Pokemon("Ditto",      "Métamorph", 132),
            new Pokemon("Eevee",      "Evoli",     133),
            new Pokemon("Vaporeon",   "Aquali",    134),
            new Pokemon("Jolteon",    "Voltali",   135),
            new Pokemon("Flareon",    "Pyroli",    136),
            new Pokemon("Porygon",    "Porygon",   137),
            new Pokemon("Omanyte",    "Amonita",   138),
            new Pokemon("Omastar",    "Amonistar", 139),
            new Pokemon("Kabuto",     "Kabuto",    140),
            new Pokemon("Kabutops",   "Kabutops",  141),
            new Pokemon("Aerodactyl", "Ptéra",     142),
            new Pokemon("Snorlax",    "Ronflex",   143),
            new Pokemon("Articuno",   "Artikodin", 144),
            new Pokemon("Zapdos",     "Electhor",  145),
            new Pokemon("Moltres",    "Sulfura",   146),
            new Pokemon("Dratini",    "Minidraco", 147),
            new Pokemon("Dragonair",  "Draco",     148),
            new Pokemon("Dragonite",  "Dracolosse",149),
            new Pokemon("Mewtwo",     "Mewtwo",    150),
            new Pokemon("Mew",        "Mew",       151)
    };

    //Trainers présents dans le set de base
    private Pokemon[] trainers = {
            new Pokemon("Clefairy Doll",         "Peluche Mélofée"),
            new Pokemon("Computer Search",       "Recherche informatique"),
            new Pokemon("Devolution Spray",      "Vaporisateur rétrograde"),
            new Pokemon("Imposter Professor Oak","Faux Professeur Chen"),
            new Pokemon("Item Finder",           "Récupérateur"),
            new Pokemon("Lass",                  "Fillette"),
            new Pokemon("Pokémon Breeder",       "Éleveur de Pokémon"),
            new Pokemon("Pokémon Trader",        "Marchand de Pokémon"),
            new Pokemon("Scoop Up",              "Rappel"),
            new Pokemon("Super Energy Removal",  "Double Suppression d'Énergie"),
            new Pokemon("Defender",              "Defender"),
            new Pokemon("Energy Retrieval",      "Sauvegarde d'Énergie"),
            new Pokemon("Full Heal",             "Guérison Totale"),
            new Pokemon("Maintenance",           "Entretien"),
            new Pokemon("PlusPower",             "PlusPower"),
            new Pokemon("Pokémon Center",        "Centre Pokémon"),
            new Pokemon("Pokémon Flute",         "Flûte Pokémon"),
            new Pokemon("Pokédex",               "Pokédex"),
            new Pokemon("Professor Oak",         "Professeur Chen"),
            new Pokemon("Revive",                "Réanimation"),
            new Pokemon("Super Potion",          "Super Potion"),
            new Pokemon("Bill",                  "Léo"),
            new Pokemon("Energy Removal",        "Suppression d'Énergie"),
            new Pokemon("Gust of Wind",          "Rafale de vent"),
            new Pokemon("Potion",                "Potion"),
            new Pokemon("Switch",                "Transfert"),
    };

    //Différentes énergies présentes dans le set de base
    private Pokemon[] Energies = {
            new Pokemon("Double Colorless Energy","Double Energie Incolore"),
            new Pokemon("Fighting Energy",        "Energie Combat"),
            new Pokemon("Fire Energy",            "Energie Feu"),
            new Pokemon("Grass Energy",           "Energie Plante"),
            new Pokemon("Lightning Energy",       "Energie Electrik"),
            new Pokemon("Psychic Energy",         "Energie Psy"),
            new Pokemon("Water Energy",           "Energie Eau")
    };

    //Différents types présents dans la 1ère génération
    private Type[] types = {
            new Type("Normal",   "Normal"),
            new Type("Fire",     "Feu"),
            new Type("Fighting", "Combat"),
            new Type("Grass",    "Plante"),
            new Type("Lightning","Electrik"),
            new Type("Psychic",  "Psy"),
            new Type("Water",    "Eau"),
            new Type( "Trainer","Dresseur"),
            new Type("Energy","Energie")
    };

    //Formats de cartes existant dans le set de base
    private Format[] formats = {
            new Format("Edition 1","Edition 1"),
            new Format("Normal",   "Normal")
    };

    //Différentes raretées existantes
    private Rarity[] rarities = {
            new Rarity("Common", "Commun"),
            new Rarity("Uncommon", "Peu Commun"),
            new Rarity("Rare", "Rare"),
            new Rarity("Holo", "Holo")
    };

    //Constructeur et donc remplissage de la bd
    public Enregistrements(PokedexOpenHelper helper, SQLiteDatabase database){
        this.database = database;
        this.helper   = helper;

        for (int i = 0; i < Generation1.length; i++){
            Pokemon pokemon = Generation1[i];
            pokemon.set_id(i);
            this.helper.addPokemon(this.database, pokemon);
        }

        for (int i = 0; i < trainers.length; i++){
            Pokemon trainer = trainers[i];
            trainer.set_id(i+1000);
            this.helper.addPokemon(this.database, trainer);
        }

        for (int i = 0; i < Energies.length; i++){
            Pokemon energie = Energies[i];
            energie.set_id(i+2000);
            this.helper.addPokemon(this.database, energie);
        }

        for (int i = 0; i < types.length; i++){
            Type type = types[i];
            type.set_id(i);
            this.helper.addType(this.database, type);
        }

        for (int i = 0; i < formats.length; i++){
            Format format = formats[i];
            format.set_id(i);
            this.helper.addFormat(this.database, format);
        }

        for (int i = 0; i < rarities.length; i++){
            Rarity rarity = rarities[i];
            rarity.set_id(i);
            this.helper.addRarity(this.database, rarity);
        }

        Extension setDeBase = new Extension(0,"BaseSet","Set de Base", 102);
        this.helper.addExtension(this.database, setDeBase);

        //Ensemble des cartes du set de base
        Card[] cards = {
                new Card(setDeBase, "1", Generation1[64],
                        rarities[3], types[5]),
                new Card(setDeBase, "2", Generation1[8],
                        rarities[3], types[6]),
                new Card(setDeBase, "3", Generation1[112],
                        rarities[3], types[0]),
                new Card(setDeBase, "4", Generation1[5],
                        rarities[3], types[1]),
                new Card(setDeBase, "5", Generation1[34],
                        rarities[3], types[0]),
                new Card(setDeBase, "6", Generation1[129],
                        rarities[3], types[6]),
                new Card(setDeBase, "7", Generation1[106],
                        rarities[3], types[2]),
                new Card(setDeBase, "8", Generation1[67],
                        rarities[3], types[2]),
                new Card(setDeBase, "9", Generation1[81],
                        rarities[3], types[4]),
                new Card(setDeBase, "10", Generation1[149],
                        rarities[3], types[5]),
                new Card(setDeBase, "11", Generation1[33],
                        rarities[3], types[3]),
                new Card(setDeBase, "12", Generation1[37],
                        rarities[3], types[1]),
                new Card(setDeBase, "13", Generation1[61],
                        rarities[3], types[6]),
                new Card(setDeBase, "14", Generation1[25],
                        rarities[3], types[4]),
                new Card(setDeBase, "15", Generation1[2],
                        rarities[3], types[3]),
                new Card(setDeBase, "16", Generation1[144],
                        rarities[3], types[4]),
                new Card(setDeBase, "17", Generation1[14],
                        rarities[2], types[3]),
                new Card(setDeBase, "18", Generation1[147],
                        rarities[2], types[0]),
                new Card(setDeBase, "19", Generation1[50],
                        rarities[2], types[2]),
                new Card(setDeBase, "20", Generation1[124],
                        rarities[2], types[4]),
                new Card(setDeBase, "21", Generation1[100],
                        rarities[2], types[4]),
                new Card(setDeBase, "22", Generation1[16],
                        rarities[2], types[0]),
                new Card(setDeBase, "23", Generation1[58],
                        rarities[1], types[1]),
                new Card(setDeBase, "24", Generation1[4],
                        rarities[1], types[1]),
                new Card(setDeBase, "25", Generation1[86],
                        rarities[1], types[6]),
                new Card(setDeBase, "26", Generation1[146],
                        rarities[1], types[0]),
                new Card(setDeBase, "27", Generation1[82],
                        rarities[1], types[0]),
                new Card(setDeBase, "28", Generation1[57],
                        rarities[1], types[1]),
                new Card(setDeBase, "29", Generation1[92],
                        rarities[1], types[5]),
                new Card(setDeBase, "30", Generation1[1],
                        rarities[1], types[3]),
                new Card(setDeBase, "31", Generation1[123],
                        rarities[1], types[5]),
                new Card(setDeBase, "32", Generation1[63],
                        rarities[1], types[5]),
                new Card(setDeBase, "33", Generation1[13],
                        rarities[1], types[3]),
                new Card(setDeBase, "34", Generation1[66],
                        rarities[1], types[2]),
                new Card(setDeBase, "35", Generation1[128],
                        rarities[1], types[6]),
                new Card(setDeBase, "36", Generation1[125],
                        rarities[1], types[1]),
                new Card(setDeBase, "37", Generation1[32],
                        rarities[1], types[3]),
                new Card(setDeBase, "38", Generation1[60],
                        rarities[1], types[6]),
                new Card(setDeBase, "39", Generation1[136],
                        rarities[1], types[0]),
                new Card(setDeBase, "40", Generation1[19],
                        rarities[1], types[0]),
                new Card(setDeBase, "41", Generation1[85],
                        rarities[1], types[6]),
                new Card(setDeBase, "42", Generation1[7],
                        rarities[1], types[6]),
                new Card(setDeBase, "43", Generation1[62],
                        rarities[0], types[5]),
                new Card(setDeBase, "44", Generation1[0],
                        rarities[0], types[3]),
                new Card(setDeBase, "45", Generation1[9],
                        rarities[0], types[3]),
                new Card(setDeBase, "46", Generation1[3],
                        rarities[0], types[1]),
                new Card(setDeBase, "47", Generation1[49],
                        rarities[0], types[2]),
                new Card(setDeBase, "48", Generation1[83],
                        rarities[0], types[0]),
                new Card(setDeBase, "49", Generation1[95],
                        rarities[0], types[5]),
                new Card(setDeBase, "50", Generation1[91],
                        rarities[0], types[5]),
                new Card(setDeBase, "51", Generation1[108],
                        rarities[0], types[3]),
                new Card(setDeBase, "52", Generation1[65],
                        rarities[0], types[2]),
                new Card(setDeBase, "53", Generation1[80],
                        rarities[0], types[4]),
                new Card(setDeBase, "54", Generation1[11],
                        rarities[0], types[3]),
                new Card(setDeBase, "55", Generation1[31],
                        rarities[0], types[3]),
                new Card(setDeBase, "56", Generation1[94],
                        rarities[0], types[2]),
                new Card(setDeBase, "57", Generation1[15],
                        rarities[0], types[0]),
                new Card(setDeBase, "58", Generation1[24],
                        rarities[0], types[4]),
                new Card(setDeBase, "59", Generation1[59],
                        rarities[0], types[6]),
                new Card(setDeBase, "60", Generation1[76],
                        rarities[0], types[1]),
                new Card(setDeBase, "61", Generation1[18],
                        rarities[0], types[0]),
                new Card(setDeBase, "62", Generation1[26],
                        rarities[0], types[2]),
                new Card(setDeBase, "63", Generation1[6],
                        rarities[0], types[6]),
                new Card(setDeBase, "64", Generation1[120],
                        rarities[0], types[6]),
                new Card(setDeBase, "65", Generation1[119],
                        rarities[0], types[6]),
                new Card(setDeBase, "66", Generation1[113],
                        rarities[0], types[3]),
                new Card(setDeBase, "67", Generation1[99],
                        rarities[0], types[4]),
                new Card(setDeBase, "68", Generation1[36],
                        rarities[0], types[1]),
                new Card(setDeBase, "69", Generation1[12],
                        rarities[0], types[3]),
                new Card(setDeBase, "70", trainers[0],
                        rarities[2], types[7]),
                new Card(setDeBase, "71", trainers[1],
                        rarities[2], types[7]),
                new Card(setDeBase, "72", trainers[2],
                        rarities[2], types[7]),
                new Card(setDeBase, "73", trainers[3],
                        rarities[2], types[7]),
                new Card(setDeBase, "74", trainers[4],
                        rarities[2], types[7]),
                new Card(setDeBase, "75", trainers[5],
                        rarities[2], types[7]),
                new Card(setDeBase, "76", trainers[6],
                        rarities[2], types[7]),
                new Card(setDeBase, "77", trainers[7],
                        rarities[2], types[7]),
                new Card(setDeBase, "78", trainers[8],
                        rarities[2], types[7]),
                new Card(setDeBase, "79", trainers[9],
                        rarities[2], types[7]),
                new Card(setDeBase, "80", trainers[10],
                        rarities[1], types[7]),
                new Card(setDeBase, "81", trainers[11],
                        rarities[1], types[7]),
                new Card(setDeBase, "82", trainers[12],
                        rarities[1], types[7]),
                new Card(setDeBase, "83", trainers[13],
                        rarities[1], types[7]),
                new Card(setDeBase, "84", trainers[14],
                        rarities[1], types[7]),
                new Card(setDeBase, "85", trainers[15],
                        rarities[1], types[7]),
                new Card(setDeBase, "86", trainers[16],
                        rarities[1], types[7]),
                new Card(setDeBase, "87", trainers[17],
                        rarities[1], types[7]),
                new Card(setDeBase, "88", trainers[18],
                        rarities[1], types[7]),
                new Card(setDeBase, "89", trainers[19],
                        rarities[1], types[7]),
                new Card(setDeBase, "90", trainers[20],
                        rarities[0], types[7]),
                new Card(setDeBase, "91", trainers[21],
                        rarities[0], types[7]),
                new Card(setDeBase, "92", trainers[22],
                        rarities[0], types[7]),
                new Card(setDeBase, "93", trainers[23],
                        rarities[0], types[7]),
                new Card(setDeBase, "94", trainers[24],
                        rarities[0], types[7]),
                new Card(setDeBase, "95", trainers[25],
                        rarities[0], types[7]),
                new Card(setDeBase, "96", Energies[0],
                        rarities[1], types[8]),
                new Card(setDeBase, "97", Energies[1],
                        rarities[0], types[8]),
                new Card(setDeBase, "98", Energies[2],
                        rarities[0], types[8]),
                new Card(setDeBase, "99", Energies[3],
                        rarities[0], types[8]),
                new Card(setDeBase, "100", Energies[4],
                        rarities[0], types[8]),
                new Card(setDeBase, "101", Energies[5],
                        rarities[0], types[8]),
                new Card(setDeBase, "102", Energies[6],
                        rarities[0], types[8])
        };


        for (Card carte : cards){
            this.helper.addCard(database, carte);
            this.helper.addRelation(database, new RelationCardFormat(carte, formats[0]));
            this.helper.addRelation(database, new RelationCardFormat(carte, formats[1]));
            Log.d("cartes", carte.get_id()+" : "+carte.get_pokemon().getName_french());
        }
    }




}
