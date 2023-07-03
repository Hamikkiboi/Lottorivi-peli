package lottorivi.peli;

public class LottoriviPeli {

    private int[] luvut;

    public void arvottuRivi() {

        luvut = new int[7];

        for (int merkki = 0; merkki < luvut.length; merkki++) {
            boolean numeroJoArvottu = false;
            do {
            
           numeroJoArvottu = false;
           luvut[merkki] = (int) (Math.random() * 32) + 1;
           
                for (int arvottu = 0; arvottu < merkki; arvottu++) {
                    
                    if (luvut[arvottu] == luvut[merkki]) {
                        numeroJoArvottu = true;
                    }
                }
            } while (numeroJoArvottu);
        }
    }

    public int tarkistaRivi(int[] numerot) {
        int samojenLukumaara = 0;
        
        for (int merkki = 0; merkki < numerot.length; merkki++) {
            for (int arvottu = 0; arvottu < luvut.length; arvottu++) {
                
                if (luvut[arvottu] == numerot[merkki]) {
                    samojenLukumaara++;
                }
            }
        }
        return samojenLukumaara;
    }

    @Override
    public String toString() {
        String teksti = "Rivi: ";
        
        for (int merkki = 0; merkki < luvut.length; merkki++) {
            if (merkki == 0) {
                teksti += "" + luvut[merkki];
                
            } else {
                teksti += ", " + luvut[merkki];
            }
        }
        return teksti;
    }

    public static void main(String[] args) {
        
        LottoriviPeli rivi = new LottoriviPeli();
        rivi.arvottuRivi();
        System.out.println("Arvottu " + rivi);
        
        int[] vertailuRivi = {28, 13, 9, 26, 1, 20, 17};
        System.out.println("Samoja lukuja rivin 28, 13, 9, 26, 1, 20, 17 kanssa: " + rivi.tarkistaRivi(vertailuRivi));
                
    }
}
