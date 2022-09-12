package gebaeude;

import berechnungen.Rohstoffe;

public class GebaeudeDaten {
    private final Rohstoffe[] bkAdelshof = new Rohstoffe[1], bkBauernhof = new Rohstoffe[30], bkEisenmine = new Rohstoffe[30], bkHauptgebaeude = new Rohstoffe[30],
            bkHolzfaeller = new Rohstoffe[30], bkKaserne = new Rohstoffe[25], bkLehmgrube = new Rohstoffe[30], bkMarktplatz = new Rohstoffe[25],
            bkSchmiede = new Rohstoffe[20], bkStall = new Rohstoffe[20], bkStatue = new Rohstoffe[1], bkVersammlungsplatz = new Rohstoffe[1],
            bkVersteck = new Rohstoffe[10], bkWall = new Rohstoffe[20], bkWerkstatt = new Rohstoffe[15], bkSpeicher = new Rohstoffe[30];

    public GebaeudeDaten() {
        fuelleBkAdelshof();
        fuelleBkBauernhof();
        fuelleBkEisenmine();
        fuelleBkHauptgebaeude();
        fuelleBkHolzfaeller();
        fuelleBkKaserne();
        fuelleBkLehmgrube();
        fuelleBkMarktplatz();
        fuelleBkSchmiede();
        fuelleBkStall();
        fuelleBkStatue();
        fuelleBkVersammlungsplatz();
        fuelleBkVersteck();
        fuelleBkWall();
        fuelleBkWerkstatt();
        fuelleBkSpeicher();
    }

    public Rohstoffe getBaukosten(GebaeudeTypen gebaeudeTyp, int stufe) {
        if (stufe == 0) {
            return new Rohstoffe();
        } else {
            //Verringern um 1 da Array bei 0 und nicht 1 startet
            stufe -= 1;
            switch (gebaeudeTyp) {
                case HAUPTGEBAEUDE -> {
                    return bkHauptgebaeude[stufe];
                }
                case KASERNE -> {
                    return bkKaserne[stufe];
                }
                case STALL -> {
                    return bkStall[stufe];
                }
                case WERKSTATT -> {
                    return bkWerkstatt[stufe];
                }
                case ADELSHOF -> {
                    return bkAdelshof[stufe];
                }
                case SCHMIEDE -> {
                    return bkSchmiede[stufe];
                }
                case VERSAMMLUNGSPLATZ -> {
                    return bkVersammlungsplatz[stufe];
                }
                case STATUE -> {
                    return bkStatue[stufe];
                }
                case MARKTPLATZ -> {
                    return bkMarktplatz[stufe];
                }
                case HOLZFAELLER -> {
                    return bkHolzfaeller[stufe];
                }
                case LEHMGRUBE -> {
                    return bkLehmgrube[stufe];
                }
                case EISENMINE -> {
                    return bkEisenmine[stufe];
                }
                case BAUERNHOF -> {
                    return bkBauernhof[stufe];
                }
                case SPEICHER -> {
                    return bkSpeicher[stufe];
                }
                case VERSTECK -> {
                    return bkVersteck[stufe];
                }
                case WALL -> {
                    return bkWall[stufe];
                }
                default -> throw new IllegalArgumentException("Falscher Gebaeudetyp bei Baukostenabruf uebergeben!");
            }
        }
    }

    public int[] getGebaeudeVoraussetzung(GebaeudeTypen gebaeudeTyp) {
        switch (gebaeudeTyp) {
            case HAUPTGEBAEUDE, VERSAMMLUNGSPLATZ, STATUE, HOLZFAELLER, LEHMGRUBE, EISENMINE, BAUERNHOF, SPEICHER, VERSTECK -> {
                return new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
            }
            case KASERNE -> {
                return new int[]{3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
            }
            case STALL -> {
                return new int[]{10, 5, 0, 0, 0, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
            }
            case WERKSTATT -> {
                return new int[]{10, 0, 0, 0, 0, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
            }
            case ADELSHOF -> {
                return new int[]{20, 0, 0, 0, 0, 20, 0, 0, 10, 0, 0, 0, 0, 0, 0, 0};
            }
            case SCHMIEDE -> {
                return new int[]{5, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
            }
            case MARKTPLATZ -> {
                return new int[]{3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0};
            }
            case WALL -> {
                return new int[]{0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
            }
            default -> throw new IllegalArgumentException("Falscher Gebaeudetyp bei Voraussetzung-Abruf uebergeben!");
        }
    }

    private void fuelleBkAdelshof() {
        bkAdelshof[0] = new Rohstoffe(15000, 25000, 10000);
    }

    private void fuelleBkBauernhof() {
        bkBauernhof[0] = new Rohstoffe(45, 40, 30);
        bkBauernhof[1] = new Rohstoffe(59, 53, 39);
        bkBauernhof[2] = new Rohstoffe(76, 70, 50);
        bkBauernhof[3] = new Rohstoffe(99, 92, 64);
        bkBauernhof[4] = new Rohstoffe(129, 121, 83);
        bkBauernhof[5] = new Rohstoffe(167, 160, 107);
        bkBauernhof[6] = new Rohstoffe(217, 212, 138);
        bkBauernhof[7] = new Rohstoffe(282, 279, 178);
        bkBauernhof[8] = new Rohstoffe(367, 369, 230);
        bkBauernhof[9] = new Rohstoffe(477, 487, 297);
        bkBauernhof[10] = new Rohstoffe(620, 642, 383);
        bkBauernhof[11] = new Rohstoffe(806, 848, 494);
        bkBauernhof[12] = new Rohstoffe(1048, 1119, 637);
        bkBauernhof[13] = new Rohstoffe(1363, 1477, 822);
        bkBauernhof[14] = new Rohstoffe(1772, 1950, 1060);
        bkBauernhof[15] = new Rohstoffe(2303, 2574, 1368);
        bkBauernhof[16] = new Rohstoffe(2994, 3398, 1764);
        bkBauernhof[17] = new Rohstoffe(3893, 4486, 2276);
        bkBauernhof[18] = new Rohstoffe(5060, 5921, 2936);
        bkBauernhof[19] = new Rohstoffe(6579, 7816, 3787);
        bkBauernhof[20] = new Rohstoffe(8552, 10317, 4886);
        bkBauernhof[21] = new Rohstoffe(11118, 13618, 6302);
        bkBauernhof[22] = new Rohstoffe(14453, 17976, 8130);
        bkBauernhof[23] = new Rohstoffe(18789, 23728, 10488);
        bkBauernhof[24] = new Rohstoffe(24426, 31321, 13529);
        bkBauernhof[25] = new Rohstoffe(31754, 41344, 17453);
        bkBauernhof[26] = new Rohstoffe(41280, 54574, 22514);
        bkBauernhof[27] = new Rohstoffe(53664, 72037, 29043);
        bkBauernhof[28] = new Rohstoffe(69763, 95089, 37466);
        bkBauernhof[29] = new Rohstoffe(90692, 125517, 48331);
    }

    private void fuelleBkHauptgebaeude() {
        bkHauptgebaeude[0] = new Rohstoffe(90, 80, 70);
        bkHauptgebaeude[1] = new Rohstoffe(113, 102, 88);
        bkHauptgebaeude[2] = new Rohstoffe(143, 130, 111);
        bkHauptgebaeude[3] = new Rohstoffe(180, 166, 140);
        bkHauptgebaeude[4] = new Rohstoffe(227, 211, 176);
        bkHauptgebaeude[5] = new Rohstoffe(286, 270, 222);
        bkHauptgebaeude[6] = new Rohstoffe(360, 344, 280);
        bkHauptgebaeude[7] = new Rohstoffe(454, 438, 353);
        bkHauptgebaeude[8] = new Rohstoffe(572, 559, 445);
        bkHauptgebaeude[9] = new Rohstoffe(720, 712, 560);
        bkHauptgebaeude[10] = new Rohstoffe(908, 908, 706);
        bkHauptgebaeude[11] = new Rohstoffe(1144, 1158, 890);
        bkHauptgebaeude[12] = new Rohstoffe(1441, 1476, 1121);
        bkHauptgebaeude[13] = new Rohstoffe(1816, 1882, 1412);
        bkHauptgebaeude[14] = new Rohstoffe(2288, 2400, 1779);
        bkHauptgebaeude[15] = new Rohstoffe(2883, 3060, 2242);
        bkHauptgebaeude[16] = new Rohstoffe(3632, 3902, 2825);
        bkHauptgebaeude[17] = new Rohstoffe(4577, 4975, 3560);
        bkHauptgebaeude[18] = new Rohstoffe(5767, 6343, 4485);
        bkHauptgebaeude[19] = new Rohstoffe(7266, 8087, 5651);
        bkHauptgebaeude[20] = new Rohstoffe(9155, 10311, 7120);
        bkHauptgebaeude[21] = new Rohstoffe(11535, 13146, 8972);
        bkHauptgebaeude[22] = new Rohstoffe(14534, 16762, 11304);
        bkHauptgebaeude[23] = new Rohstoffe(18313, 21371, 14244);
        bkHauptgebaeude[24] = new Rohstoffe(23075, 27248, 17947);
        bkHauptgebaeude[25] = new Rohstoffe(29074, 34741, 22613);
        bkHauptgebaeude[26] = new Rohstoffe(36633, 44295, 28493);
        bkHauptgebaeude[27] = new Rohstoffe(46158, 56476, 35901);
        bkHauptgebaeude[28] = new Rohstoffe(58159, 72007, 45235);
        bkHauptgebaeude[29] = new Rohstoffe(73280, 91809, 56996);
    }

    private void fuelleBkEisenmine() {
        bkEisenmine[0] = new Rohstoffe(75, 65, 70);
        bkEisenmine[1] = new Rohstoffe(94, 83, 87);
        bkEisenmine[2] = new Rohstoffe(118, 106, 108);
        bkEisenmine[3] = new Rohstoffe(147, 135, 133);
        bkEisenmine[4] = new Rohstoffe(184, 172, 165);
        bkEisenmine[5] = new Rohstoffe(231, 219, 205);
        bkEisenmine[6] = new Rohstoffe(289, 279, 254);
        bkEisenmine[7] = new Rohstoffe(362, 356, 316);
        bkEisenmine[8] = new Rohstoffe(453, 454, 391);
        bkEisenmine[9] = new Rohstoffe(567, 579, 485);
        bkEisenmine[10] = new Rohstoffe(710, 738, 602);
        bkEisenmine[11] = new Rohstoffe(889, 941, 746);
        bkEisenmine[12] = new Rohstoffe(1113, 1200, 925);
        bkEisenmine[13] = new Rohstoffe(1393, 1529, 1147);
        bkEisenmine[14] = new Rohstoffe(1744, 1950, 1422);
        bkEisenmine[15] = new Rohstoffe(2183, 2486, 1764);
        bkEisenmine[16] = new Rohstoffe(2734, 3170, 2187);
        bkEisenmine[17] = new Rohstoffe(3422, 4042, 2712);
        bkEisenmine[18] = new Rohstoffe(4285, 5153, 3363);
        bkEisenmine[19] = new Rohstoffe(5365, 6571, 4170);
        bkEisenmine[20] = new Rohstoffe(6717, 8378, 5170);
        bkEisenmine[21] = new Rohstoffe(8409, 10681, 6411);
        bkEisenmine[22] = new Rohstoffe(10528, 13619, 7950);
        bkEisenmine[23] = new Rohstoffe(13181, 17346, 9858);
        bkEisenmine[24] = new Rohstoffe(16503, 22139, 12224);
        bkEisenmine[25] = new Rohstoffe(20662, 28227, 15158);
        bkEisenmine[26] = new Rohstoffe(25869, 35990, 18796);
        bkEisenmine[27] = new Rohstoffe(32388, 45887, 23307);
        bkEisenmine[28] = new Rohstoffe(40549, 58506, 28900);
        bkEisenmine[29] = new Rohstoffe(50768, 74595, 35837);
    }

    private void fuelleBkHolzfaeller() {
        bkHolzfaeller[0] = new Rohstoffe(50, 60, 40);
        bkHolzfaeller[1] = new Rohstoffe(63, 77, 50);
        bkHolzfaeller[2] = new Rohstoffe(78, 98, 62);
        bkHolzfaeller[3] = new Rohstoffe(98, 124, 77);
        bkHolzfaeller[4] = new Rohstoffe(122, 159, 96);
        bkHolzfaeller[5] = new Rohstoffe(153, 202, 120);
        bkHolzfaeller[6] = new Rohstoffe(191, 258, 149);
        bkHolzfaeller[7] = new Rohstoffe(238, 329, 185);
        bkHolzfaeller[8] = new Rohstoffe(298, 419, 231);
        bkHolzfaeller[9] = new Rohstoffe(373, 534, 287);
        bkHolzfaeller[10] = new Rohstoffe(466, 681, 358);
        bkHolzfaeller[11] = new Rohstoffe(582, 868, 446);
        bkHolzfaeller[12] = new Rohstoffe(728, 1107, 555);
        bkHolzfaeller[13] = new Rohstoffe(909, 1412, 691);
        bkHolzfaeller[14] = new Rohstoffe(1137, 1800, 860);
        bkHolzfaeller[15] = new Rohstoffe(1421, 2295, 1071);
        bkHolzfaeller[16] = new Rohstoffe(1776, 2926, 1333);
        bkHolzfaeller[17] = new Rohstoffe(2220, 3731, 1659);
        bkHolzfaeller[18] = new Rohstoffe(2776, 4757, 2066);
        bkHolzfaeller[19] = new Rohstoffe(3469, 6065, 2572);
        bkHolzfaeller[20] = new Rohstoffe(4337, 7733, 3202);
        bkHolzfaeller[21] = new Rohstoffe(5421, 9860, 3987);
        bkHolzfaeller[22] = new Rohstoffe(6776, 12571, 4963);
        bkHolzfaeller[23] = new Rohstoffe(8470, 16028, 6180);
        bkHolzfaeller[24] = new Rohstoffe(10588, 20436, 7694);
        bkHolzfaeller[25] = new Rohstoffe(13235, 26056, 9578);
        bkHolzfaeller[26] = new Rohstoffe(16544, 33221, 11925);
        bkHolzfaeller[27] = new Rohstoffe(20680, 42357, 14847);
        bkHolzfaeller[28] = new Rohstoffe(25849, 54005, 18484);
        bkHolzfaeller[29] = new Rohstoffe(32312, 68857, 23013);
    }

    private void fuelleBkKaserne() {
        bkKaserne[0] = new Rohstoffe(200, 170, 90);
        bkKaserne[1] = new Rohstoffe(252, 218, 113);
        bkKaserne[2] = new Rohstoffe(318, 279, 143);
        bkKaserne[3] = new Rohstoffe(400, 357, 180);
        bkKaserne[4] = new Rohstoffe(504, 456, 227);
        bkKaserne[5] = new Rohstoffe(635, 584, 286);
        bkKaserne[6] = new Rohstoffe(800, 748, 360);
        bkKaserne[7] = new Rohstoffe(1008, 957, 454);
        bkKaserne[8] = new Rohstoffe(1271, 1225, 572);
        bkKaserne[9] = new Rohstoffe(1601, 1568, 720);
        bkKaserne[10] = new Rohstoffe(2017, 2007, 908);
        bkKaserne[11] = new Rohstoffe(2542, 2569, 1144);
        bkKaserne[12] = new Rohstoffe(3202, 3288, 1441);
        bkKaserne[13] = new Rohstoffe(4035, 4209, 1816);
        bkKaserne[14] = new Rohstoffe(5084, 5388, 2288);
        bkKaserne[15] = new Rohstoffe(6406, 6896, 2883);
        bkKaserne[16] = new Rohstoffe(8072, 8827, 3632);
        bkKaserne[17] = new Rohstoffe(10170, 11298, 4577);
        bkKaserne[18] = new Rohstoffe(12814, 14462, 5767);
        bkKaserne[19] = new Rohstoffe(16146, 18511, 7266);
        bkKaserne[20] = new Rohstoffe(20344, 23695, 9155);
        bkKaserne[21] = new Rohstoffe(25634, 30329, 11535);
        bkKaserne[22] = new Rohstoffe(32298, 38821, 14534);
        bkKaserne[23] = new Rohstoffe(40696, 49691, 18313);
        bkKaserne[24] = new Rohstoffe(51277, 63605, 23075);
    }

    private void fuelleBkLehmgrube() {
        bkLehmgrube[0] = new Rohstoffe(65, 50, 40);
        bkLehmgrube[1] = new Rohstoffe(83, 63, 50);
        bkLehmgrube[2] = new Rohstoffe(105, 80, 60);
        bkLehmgrube[3] = new Rohstoffe(133, 101, 76);
        bkLehmgrube[4] = new Rohstoffe(169, 128, 95);
        bkLehmgrube[5] = new Rohstoffe(215, 162, 117);
        bkLehmgrube[6] = new Rohstoffe(273, 205, 145);
        bkLehmgrube[7] = new Rohstoffe(346, 259, 180);
        bkLehmgrube[8] = new Rohstoffe(440, 328, 224);
        bkLehmgrube[9] = new Rohstoffe(559, 415, 277);
        bkLehmgrube[10] = new Rohstoffe(709, 525, 344);
        bkLehmgrube[11] = new Rohstoffe(901, 664, 426);
        bkLehmgrube[12] = new Rohstoffe(1144, 840, 529);
        bkLehmgrube[13] = new Rohstoffe(1453, 1062, 655);
        bkLehmgrube[14] = new Rohstoffe(1846, 1343, 813);
        bkLehmgrube[15] = new Rohstoffe(2344, 1700, 1008);
        bkLehmgrube[16] = new Rohstoffe(2977, 2150, 1250);
        bkLehmgrube[17] = new Rohstoffe(3781, 2720, 1550);
        bkLehmgrube[18] = new Rohstoffe(4802, 3440, 1922);
        bkLehmgrube[19] = new Rohstoffe(6098, 4352, 2383);
        bkLehmgrube[20] = new Rohstoffe(7744, 5505, 2955);
        bkLehmgrube[21] = new Rohstoffe(9835, 6964, 3664);
        bkLehmgrube[22] = new Rohstoffe(12491, 8810, 4543);
        bkLehmgrube[23] = new Rohstoffe(15863, 11144, 5633);
        bkLehmgrube[24] = new Rohstoffe(20147, 14098, 6985);
        bkLehmgrube[25] = new Rohstoffe(25586, 17833, 8662);
        bkLehmgrube[26] = new Rohstoffe(32495, 22559, 10740);
        bkLehmgrube[27] = new Rohstoffe(41268, 28537, 13318);
        bkLehmgrube[28] = new Rohstoffe(52410, 36100, 16515);
        bkLehmgrube[29] = new Rohstoffe(66561, 45666, 20478);
    }

    private void fuelleBkMarktplatz() {
        bkMarktplatz[0] = new Rohstoffe(100, 100, 100);
        bkMarktplatz[1] = new Rohstoffe(126, 128, 126);
        bkMarktplatz[2] = new Rohstoffe(159, 163, 159);
        bkMarktplatz[3] = new Rohstoffe(200, 207, 200);
        bkMarktplatz[4] = new Rohstoffe(252, 264, 252);
        bkMarktplatz[5] = new Rohstoffe(318, 337, 318);
        bkMarktplatz[6] = new Rohstoffe(400, 430, 400);
        bkMarktplatz[7] = new Rohstoffe(504, 548, 504);
        bkMarktplatz[8] = new Rohstoffe(635, 698, 635);
        bkMarktplatz[9] = new Rohstoffe(800, 890, 800);
        bkMarktplatz[10] = new Rohstoffe(1009, 1135, 1009);
        bkMarktplatz[11] = new Rohstoffe(1271, 1447, 1271);
        bkMarktplatz[12] = new Rohstoffe(1601, 1846, 1601);
        bkMarktplatz[13] = new Rohstoffe(2018, 2353, 2018);
        bkMarktplatz[14] = new Rohstoffe(2542, 3000, 2542);
        bkMarktplatz[15] = new Rohstoffe(3203, 3825, 3203);
        bkMarktplatz[16] = new Rohstoffe(4036, 4877, 4036);
        bkMarktplatz[17] = new Rohstoffe(5085, 6218, 5085);
        bkMarktplatz[18] = new Rohstoffe(6407, 7928, 6407);
        bkMarktplatz[19] = new Rohstoffe(8073, 10109, 8073);
        bkMarktplatz[20] = new Rohstoffe(10172, 12889, 10172);
        bkMarktplatz[21] = new Rohstoffe(12817, 16433, 12817);
        bkMarktplatz[22] = new Rohstoffe(16149, 20952, 16149);
        bkMarktplatz[23] = new Rohstoffe(20348, 26714, 20348);
        bkMarktplatz[24] = new Rohstoffe(25639, 34060, 25639);
    }

    private void fuelleBkSchmiede() {
        bkSchmiede[0] = new Rohstoffe(220, 180, 240);
        bkSchmiede[1] = new Rohstoffe(277, 230, 302);
        bkSchmiede[2] = new Rohstoffe(349, 293, 381);
        bkSchmiede[3] = new Rohstoffe(440, 373, 480);
        bkSchmiede[4] = new Rohstoffe(555, 476, 650);
        bkSchmiede[5] = new Rohstoffe(699, 606, 762);
        bkSchmiede[6] = new Rohstoffe(880, 773, 960);
        bkSchmiede[7] = new Rohstoffe(1109, 986, 1210);
        bkSchmiede[8] = new Rohstoffe(1398, 1257, 1525);
        bkSchmiede[9] = new Rohstoffe(1761, 1603, 1921);
        bkSchmiede[10] = new Rohstoffe(2219, 2043, 2421);
        bkSchmiede[11] = new Rohstoffe(2796, 2605, 3050);
        bkSchmiede[12] = new Rohstoffe(3523, 3322, 3843);
        bkSchmiede[13] = new Rohstoffe(4439, 4236, 4842);
        bkSchmiede[14] = new Rohstoffe(5593, 5400, 6101);
        bkSchmiede[15] = new Rohstoffe(7047, 6885, 7687);
        bkSchmiede[16] = new Rohstoffe(8879, 8779, 9686);
        bkSchmiede[17] = new Rohstoffe(11187, 11193, 12204);
        bkSchmiede[18] = new Rohstoffe(14096, 14271, 15377);
        bkSchmiede[19] = new Rohstoffe(17761, 18196, 19375);
    }

    private void fuelleBkStall() {
        bkStall[0] = new Rohstoffe(270, 240, 260);
        bkStall[1] = new Rohstoffe(340, 307, 328);
        bkStall[2] = new Rohstoffe(429, 393, 413);
        bkStall[3] = new Rohstoffe(540, 503, 520);
        bkStall[4] = new Rohstoffe(681, 644, 655);
        bkStall[5] = new Rohstoffe(857, 825, 826);
        bkStall[6] = new Rohstoffe(1080, 1056, 1040);
        bkStall[7] = new Rohstoffe(1361, 1351, 1311);
        bkStall[8] = new Rohstoffe(1715, 1729, 1652);
        bkStall[9] = new Rohstoffe(2161, 2214, 2081);
        bkStall[10] = new Rohstoffe(2723, 2833, 2622);
        bkStall[11] = new Rohstoffe(3431, 3627, 3304);
        bkStall[12] = new Rohstoffe(4323, 4642, 4163);
        bkStall[13] = new Rohstoffe(5447, 5942, 5246);
        bkStall[14] = new Rohstoffe(6864, 7606, 6609);
        bkStall[15] = new Rohstoffe(8648, 9736, 8328);
        bkStall[16] = new Rohstoffe(10897, 12462, 10493);
        bkStall[17] = new Rohstoffe(13730, 15951, 13221);
        bkStall[18] = new Rohstoffe(17300, 20417, 16659);
        bkStall[19] = new Rohstoffe(21797, 26134, 20990);
    }

    private void fuelleBkStatue() {
        bkStatue[0] = new Rohstoffe(220, 220, 220);
    }

    private void fuelleBkVersammlungsplatz() {
        bkVersammlungsplatz[0] = new Rohstoffe(10, 40, 30);
    }

    private void fuelleBkVersteck() {
        bkVersteck[0] = new Rohstoffe(50, 60, 50);
        bkVersteck[1] = new Rohstoffe(63, 75, 63);
        bkVersteck[2] = new Rohstoffe(78, 94, 78);
        bkVersteck[3] = new Rohstoffe(98, 117, 98);
        bkVersteck[4] = new Rohstoffe(122, 146, 122);
        bkVersteck[5] = new Rohstoffe(153, 183, 153);
        bkVersteck[6] = new Rohstoffe(191, 229, 191);
        bkVersteck[7] = new Rohstoffe(238, 286, 238);
        bkVersteck[8] = new Rohstoffe(298, 358, 298);
        bkVersteck[9] = new Rohstoffe(373, 447, 373);
    }

    private void fuelleBkWall() {
        bkWall[0] = new Rohstoffe(50, 100, 20);
        bkWall[1] = new Rohstoffe(63, 128, 25);
        bkWall[2] = new Rohstoffe(79, 163, 32);
        bkWall[3] = new Rohstoffe(100, 207, 40);
        bkWall[4] = new Rohstoffe(126, 264, 50);
        bkWall[5] = new Rohstoffe(159, 337, 64);
        bkWall[6] = new Rohstoffe(200, 430, 80);
        bkWall[7] = new Rohstoffe(252, 548, 101);
        bkWall[8] = new Rohstoffe(318, 698, 127);
        bkWall[9] = new Rohstoffe(400, 890, 160);
        bkWall[10] = new Rohstoffe(504, 1135, 202);
        bkWall[11] = new Rohstoffe(635, 1447, 254);
        bkWall[12] = new Rohstoffe(801, 1846, 320);
        bkWall[13] = new Rohstoffe(1009, 2353, 404);
        bkWall[14] = new Rohstoffe(1271, 3000, 508);
        bkWall[15] = new Rohstoffe(1602, 3825, 641);
        bkWall[16] = new Rohstoffe(2018, 4877, 807);
        bkWall[17] = new Rohstoffe(2543, 6218, 1017);
        bkWall[18] = new Rohstoffe(3204, 7928, 1281);
        bkWall[19] = new Rohstoffe(4037, 10109, 1615);
    }

    private void fuelleBkWerkstatt() {
        bkWerkstatt[0] = new Rohstoffe(300, 240, 260);
        bkWerkstatt[1] = new Rohstoffe(378, 307, 328);
        bkWerkstatt[2] = new Rohstoffe(476, 393, 413);
        bkWerkstatt[3] = new Rohstoffe(600, 503, 520);
        bkWerkstatt[4] = new Rohstoffe(756, 644, 655);
        bkWerkstatt[5] = new Rohstoffe(953, 825, 826);
        bkWerkstatt[6] = new Rohstoffe(1200, 1056, 1040);
        bkWerkstatt[7] = new Rohstoffe(1513, 1351, 1311);
        bkWerkstatt[8] = new Rohstoffe(1906, 1729, 1652);
        bkWerkstatt[9] = new Rohstoffe(2401, 2214, 2081);
        bkWerkstatt[10] = new Rohstoffe(3026, 2833, 2622);
        bkWerkstatt[11] = new Rohstoffe(3812, 3627, 3304);
        bkWerkstatt[12] = new Rohstoffe(4804, 4642, 4163);
        bkWerkstatt[13] = new Rohstoffe(6053, 5942, 5246);
        bkWerkstatt[14] = new Rohstoffe(7626, 7606, 6609);
    }

    private void fuelleBkSpeicher() {
        bkSpeicher[0] = new Rohstoffe(60, 50, 40);
        bkSpeicher[1] = new Rohstoffe(76, 64, 50);
        bkSpeicher[2] = new Rohstoffe(96, 81, 62);
        bkSpeicher[3] = new Rohstoffe(121, 102, 77);
        bkSpeicher[4] = new Rohstoffe(154, 130, 96);
        bkSpeicher[5] = new Rohstoffe(194, 165, 120);
        bkSpeicher[6] = new Rohstoffe(246, 210, 149);
        bkSpeicher[7] = new Rohstoffe(311, 266, 185);
        bkSpeicher[8] = new Rohstoffe(393, 338, 231);
        bkSpeicher[9] = new Rohstoffe(498, 430, 287);
        bkSpeicher[10] = new Rohstoffe(630, 546, 358);
        bkSpeicher[11] = new Rohstoffe(796, 693, 446);
        bkSpeicher[12] = new Rohstoffe(1007, 880, 555);
        bkSpeicher[13] = new Rohstoffe(1274, 1118, 691);
        bkSpeicher[14] = new Rohstoffe(1612, 1420, 860);
        bkSpeicher[15] = new Rohstoffe(2039, 1803, 1071);
        bkSpeicher[16] = new Rohstoffe(2580, 2290, 1333);
        bkSpeicher[17] = new Rohstoffe(3264, 2908, 1659);
        bkSpeicher[18] = new Rohstoffe(4128, 3693, 2066);
        bkSpeicher[19] = new Rohstoffe(5222, 4691, 2572);
        bkSpeicher[20] = new Rohstoffe(6606, 5957, 3202);
        bkSpeicher[21] = new Rohstoffe(8357, 7566, 3987);
        bkSpeicher[22] = new Rohstoffe(10572, 9608, 4963);
        bkSpeicher[23] = new Rohstoffe(13373, 12203, 6180);
        bkSpeicher[24] = new Rohstoffe(16917, 15497, 7694);
        bkSpeicher[25] = new Rohstoffe(21400, 19682, 9578);
        bkSpeicher[26] = new Rohstoffe(27071, 24996, 11925);
        bkSpeicher[27] = new Rohstoffe(34245, 31745, 14847);
        bkSpeicher[28] = new Rohstoffe(43320, 40316, 18484);
        bkSpeicher[29] = new Rohstoffe(54799, 51201, 23013);
    }
}
