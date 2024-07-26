class ExemplosA {
    String username = new String("abc");
    String password = new String("xyz");

    ExemplosA() {

        if (username.equals("abc") == true && password.equals("xyp") == true) {
            System.out.println("Username e Pass Correctas!");

        } else {
            System.out.println("Alguma coisa falhou!");
        }


        if (6 > 9 || 4 == 3 && (9 <= 0 || 3 >= 1) || retornoBool() == true) {
            System.out.println("Aprendizagem sobre precedência do &&!");
        }

        int notaAvaliacao = 3;

        switch (notaAvaliacao) {
            case 1:
                System.out.println("A sua nota foi Basatante Insuficiente");
                break;
            case 2:
                System.out.println("A sua nota foi Insuficiente");
                break;
            case 3:
                System.out.println("A sua nota foi Suficiente");
                break;
            case 4:
                System.out.println("A sua nota foi Muito Bom");
                break;
            case 5:
                System.out.println("A sua nota foi Execelente");
                break;
            default:
                System.out.println("A sua nota não e valida - não pertence á escala!");
                break;
        }

        int notaUniversidade = 10;

        switch (notaUniversidade) {
            case 1:
            case 2:
            case 3:
                System.out.println("A sua nota foi muito ruim");
                break;
            case 4:
            case 5:
            case 6:
                System.out.println("A sua nota negativa");
            case 7:
            case 8:
            case 9:
                System.out.println("A sua nota quase positiva");
                break;
            case 10:
                System.out.println("A sua nota positiva");
            case 11:
                System.out.println("A sua nota positiva");
            case 12:
                System.out.println("A sua nota positiva");
            case 13:
                System.out.println("A sua nota positiva");
                break;
            case 14:
            case 15:
            case 16:
            case 17:
                System.out.println("A sua nota foi Muito Boa");
                break;
            case 18:
            case 19:
                System.out.println("A sua nota Extraodinaria");
                break;
            case 20:
                System.out.println("Você fez batota!");
                break;
            default:
                System.out.println("Não é valida a nota");
                break;
        }

        String diaSemana = "quarta";

        switch (diaSemana) {
            case "domingo":
            case "segunda":
            case "terca":
                System.out.println("A sua nota foi muito ruim");
                break;
            case "quarta":
            case "quinta":
            case "sexta":
                System.out.println("A sua nota negativa");
            case "sabado":
            default:
                System.out.println("Não é valida a nota");
                break;
        }

    }

    boolean retornoBool() {
        return true;
    }


}