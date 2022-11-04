
public class Main {

    public static void main(String[] args) {
        for(int i = 0; i < 1; i++){
            HanoiTower hanoiTower = new HanoiTower(20);
            hanoiTower.view();
            long startTime = System.currentTimeMillis();
            hanoiTower.run();
            long endTime = System.currentTimeMillis();
            long duration = (endTime - startTime);
          //  hanoiTower.view();
            System.out.println("Used combinations: " + hanoiTower.getCombinations());
        /*System.out.println("AB: " + hanoiTower.AtoB_comb);
        System.out.println("BA: " + hanoiTower.BtoA_comb);

        System.out.println("AC: " + hanoiTower.AtoC_comb);
        System.out.println("CA: " + hanoiTower.CtoA_comb);

        System.out.println("BC: " + hanoiTower.BtoC_comb);
        System.out.println("CB: " + hanoiTower.CtoB_comb);*/
            System.out.println("Duration: " + duration + "ms");
        }

    }
}
