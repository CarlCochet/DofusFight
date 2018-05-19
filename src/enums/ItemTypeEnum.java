package enums;

import java.util.HashMap;
import java.util.Map;

public enum ItemTypeEnum {

    AMULETTE(0),
    ARC(1),
    BAGUETTE(2),
    BÂTON(3),
    DAGUE(4),
    ÉPÉE(5),
    MARTEAU(6),
    PELLE(7),
    ANNEAU(8),
    CEINTURE(9),
    BOTTES(10),
    POTION(11),
    PARCHEMIN_D_EXPÉRIENCE(12),
    OBJET_DE_DONS(13),
    RESSOURCES_DIVERSES(14),
    CHAPEAU(15),
    CAPE(16),
    FAMILIER(17),
    HACHE(18),
    OUTIL(19),
    PIOCHE(20),
    FAUX(21),
    DOFUS(22),
    DIVERS(23),
    DOCUMENT(24),
    POTION_DE_FORGEMAGIE(25),
    OBJET_DE_MUTATION(26),
    NOURRITURE_BOOST(27),
    BÉNÉDICTION(28),
    MALÉDICTION(29),
    ROLEPLAY_BUFFS(30),
    PERSONNAGE_SUIVEUR(31),
    OEUF_DE_FAMILIER(32),
    MAÎTRISE(33),
    PARCHEMIN_DE_SORTILÈGE(34),
    PARCHEMIN_DE_CARACTÉRISTIQUE(35),
    CERTIFICAT_DE_FAMILIER(36),
    RUNE_DE_FORGEMAGIE(37),
    SAC_À_DOS(38),
    BOUCLIER(39),
    PIERRE_D_ÂME(40),
    CLEF(41),
    PIERRE_D_ÂME_PLEINE(42),
    FANTÔME_DE_FAMILIER(43),
    DRAGODINDE(44),
    BOUFTOU(45),
    CERTIFICAT_DE_DRAGODINDE(46),
    FILET_DE_CAPTURE(47),
    ARBALÈTE(48),
    OBJET_VIVANT (49),
    ARME_MAGIQUE (50),
    OBJETS_D_ÉQUIPEMENT(51),
    MONTILIER(52),
    CERTIFICAT_DE_MONTILIER(53),
    FANTÔME_DE_MONTILIER(54),
    ALIGNEMENT(55),
    ÉVÉNEMENTS(56),
    JETONS(57),
    TROPHÉE(58),
    RABMABLAGUE_CARAMEL(59),
    RABMABLAGUE_FRAISE(60),
    RABMABLAGUE_CITRON(61),
    RABMABLAGUE_ORANGE(62),
    RABMABLAGUE_KOLA(63),
    RABMABLAGUE_NOUGAT(64),
    VÊTEMENT(65),
    MIMIBIOTE(66),
    JUSTICIERS(67),
    COMPAGNON(68),
    COFFRE(69),
    CARTE(70),
    OBJET_D_APPARAT(71),
    IDOLE(72),
    PRÉPARATION(73),
    ORBE_DE_FORGEMAGIE(74),
    HARNACHEMENT(75),
    IDOLE_DÉFENSIVE(76),
    CERTIFICAT_DE_MULDO(77),
    CAUTION(78),
    SAHARACH(79),
    COSTUME(80);


    private static final Map<Integer, ItemTypeEnum> lookup = new HashMap();

    static{
        for(ItemTypeEnum itemType : ItemTypeEnum.values()){
            lookup.put(itemType.getItemValue(), itemType);
        }
    }

    private int itemValue;
    ItemTypeEnum(int itemValue){
        this.itemValue = itemValue;
    }

    public int getItemValue(){
        return itemValue;
    }

    public static ItemTypeEnum get(int itemValue){
        return lookup.get(itemValue);
    }

}
