package bean;

public class Letters {
    private static char[] letters = new char[31];

    static {                //these letters are for searching books by the first letter (under search form on pages)
        letters[0] = '#';
        letters[1] = 'А';
        letters[2] = 'Б';
        letters[3] = 'В';
        letters[4] = 'Г';
        letters[5] = 'Д';
        letters[6] = 'Е';
        letters[7] = 'Ж';
        letters[8] = 'З';
        letters[9] = 'И';
        letters[10] = 'Й';
        letters[11] = 'К';
        letters[12] = 'Л';
        letters[13] = 'М';
        letters[14] = 'Н';
        letters[15] = 'О';
        letters[16] = 'П';
        letters[17] = 'Р';
        letters[18] = 'С';
        letters[19] = 'Т';
        letters[20] = 'У';
        letters[21] = 'Ф';
        letters[22] = 'Х';
        letters[23] = 'Ц';
        letters[24] = 'Ч';
        letters[25] = 'Ш';
        letters[26] = 'Щ';
        letters[27] = 'Ы';
        letters[28] = 'Э';
        letters[29] = 'Ю';
        letters[30] = 'Я';
    }

    public static char[] getLetters() {
        return letters;
    }
}
