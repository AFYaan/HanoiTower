import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.logging.Logger;

public class HanoiTower {
    private List<Disc> A = new CopyOnWriteArrayList<>();
    private List<Disc> B = new CopyOnWriteArrayList<>();
    private List<Disc> C = new CopyOnWriteArrayList<>();
    private int size;
    public long combinations;
    public long AtoB_comb = 0;
    public long BtoA_comb = 0;

    public long AtoC_comb = 0;
    public long CtoA_comb = 0;

    public long BtoC_comb = 0;
    public long CtoB_comb = 0;

    public HanoiTower(int size){
        this.size = size;
        this.combinations = (long)Math.pow(2, size) - 1;

        for(int i = size; i --> 0;){
            A.add(new Disc(i));
        }
        System.out.println("Added " + size + " elements to A");
        System.out.println("Min combinations: " + combinations);

    }

    public void view(){
        System.out.println("  A  B  C");
        for(int i = size; i --> 0;){
            String a;
            String b;
            String c;
            if(i >= A.size()){
                a = "|";
            }else{
                a = String.valueOf(A.get(i).getSize());
            }
            if(i >= B.size()){
                b = "|";
            }else{
                b = String.valueOf(B.get(i).getSize());
            }
            if(i >= C.size()){
                c = "|";
            }else{
                c = String.valueOf(C.get(i).getSize());
            }
            System.out.println("- " + a + "  " + b + "  " + c);
        }
    }

    //

    public long getSizeA(){
        for(int i = A.size(); i --> 0;){
            Disc d = A.get(i);

            return d.getSize();
        }
        return combinations+1;
    }

    public long getSizeB(){
        for(int i = B.size(); i --> 0;){
            Disc d = B.get(i);

            return d.getSize();
        }
        return combinations+1;
    }

    public long getSizeC(){
        for(int i = C.size(); i --> 0;){
            Disc d = C.get(i);

            return d.getSize();
        }
        return combinations+1;
    }

    public void moveAtoB(){
        for(int i = A.size(); i --> 0;){
            Disc d = A.get(i);
            B.add(d);
            A.remove(d);
            this.AtoB_comb++;
            return;
        }
    }

    public void moveBtoA(){
        for(int i = B.size(); i --> 0;){
            Disc d = B.get(i);
            A.add(d);
            B.remove(d);
            this.BtoA_comb++;
            return;
        }
    }
    public void moveAtoC(){
        for (int i = A.size(); i-- > 0; ) {
            Disc d = A.get(i);
            C.add(d);
            A.remove(d);
            AtoC_comb++;
            return;
        }
    }

    public void moveCtoA(){
        for(int i = C.size(); i --> 0;){
            Disc d = C.get(i);
            A.add(d);
            C.remove(d);
            CtoA_comb++;
            return;
        }
    }

    public void moveBtoC(){
        for (int i = B.size(); i-- > 0; ) {
            Disc d = B.get(i);
            C.add(d);
            B.remove(d);
            BtoC_comb++;
            return;
        }
    }

    public void moveCtoB(){
        for(int i = C.size(); i --> 0;){
            Disc d = C.get(i);
            B.add(d);
            C.remove(d);
            CtoB_comb++;
            return;
        }
    }

    public long getCombinations(){
        return AtoB_comb + BtoA_comb + AtoC_comb + CtoA_comb + BtoC_comb + CtoB_comb;
    }


    public void run(){
        int stepCount = 0;
        if((this.size & 1) == 0){
            while(getCombinations() < combinations){
                stepCount++;
                if(getSizeA() < getSizeB()){
                    moveAtoB();
                }else {
                    moveBtoA();
                }

                if(getSizeA() < getSizeC()){
                    moveAtoC();
                }else {
                    moveCtoA();
                }

                if(getSizeB() < getSizeC()){
                    moveBtoC();
                }else{
                    moveCtoB();
                }
                System.out.println("\nStep: " + stepCount);
                view();
            }
        }else{
            while(getCombinations() < combinations){
                if(getSizeA() < getSizeC()){
                    moveAtoC();
                }else {
                    moveCtoA();
                }

                if(getSizeA() < getSizeB()){
                    moveAtoB();
                }else {
                    moveBtoA();
                }

                if(getSizeB() < getSizeC()){
                    moveBtoC();
                }else{
                    if(getCombinations() != combinations)
                        moveCtoB();
                }
                System.out.println("\nStep: " + stepCount);
                view();
            }
        }


    }


}
