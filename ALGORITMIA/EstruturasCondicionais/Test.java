public class Test {
    int val;
    boolean estado;

    Test() {
        val = 3;
        estado = true;

        System.out.println(val + 6);

        if (val < 1 || estado == true) {
            val += operacao(estado);
            System.out.println(estado);
        }
        System.out.println(val + 6);
    }

    public static void main(String[] args) {
        Test t = new Test();
    }

    int operacao(boolean res) {
        int mand = 4;

        if (res != false && val >= 2) {
            val++;
            estado = false;
        }
        mand = mand + val;
        return mand;
    }
}
