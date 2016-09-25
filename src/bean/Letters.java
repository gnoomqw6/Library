package bean;

public class Letters {
    private static char[] letters = new char[30];

    static {                //these letters are for searching books by the first letter (under search form on pages)
        letters[0] = 'А';
        letters[1] = 'Б';
        letters[2] = 'В';
        letters[3] = 'Г';
        letters[4] = 'Д';
        letters[5] = 'Е';
        letters[6] = 'Ж';
        letters[7] = 'З';
        letters[8] = 'И';
        letters[9] = 'Й';
        letters[10] = 'К';
        letters[11] = 'Л';
        letters[12] = 'М';
        letters[13] = 'Н';
        letters[14] = 'О';
        letters[15] = 'П';
        letters[16] = 'Р';
        letters[17] = 'С';
        letters[18] = 'Т';
        letters[19] = 'У';
        letters[20] = 'Ф';
        letters[21] = 'Х';
        letters[22] = 'Ц';
        letters[23] = 'Ч';
        letters[24] = 'Ш';
        letters[25] = 'Щ';
        letters[26] = 'Ы';
        letters[27] = 'Э';
        letters[28] = 'Ю';
        letters[29] = 'Я';
    }

    public static char[] getLetters() {
        return letters;
    }
}
