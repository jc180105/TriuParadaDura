 static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        String[] Estoque = new String[50];

        preencherEstoque(Estoque);

        exibirEstoque(Estoque);

        comprarCarro(Estoque);

        exibirEstoque(Estoque);

        System.out.println("Fim...");
    }

    public static void comprarCarro(String[] Estoque) {

        do {

            String carroDesejado = perguntarCarroDesejado();

            if (isCarroExistente(Estoque, carroDesejado)) {

                if (processarCompra()) {
                    realizarCompra(Estoque, carroDesejado);
                    break;
                } else {
                    break;
                }
            } else {

                if (!desejaContinuarBusca()) {
                    break;
                }
            }

        } while (true);
        System.out.println("este carro n existe");
    }

    public static void realizarCompra(String[] estoque, String carro) {

        int posicaoCarro = buscarCarro(estoque, carro);
        System.out.print("Deseja dar seu carro na troca? (S/N): ");
        String resposta = sc.next();

        if (resposta.equalsIgnoreCase("S")) {
            System.out.println("Escreva o nome do seu carro: ");
            String carroTroca = sc.next();
            estoque[posicaoCarro] = carroTroca;
            System.out.println("Seu carro " + carroTroca + " foi dado na troca.");
        } else {
            estoque[posicaoCarro] = null;
        }

    }

    public static String perguntarCarroDesejado() {
        System.out.print("Qual carro você deseja? ");
        return sc.next().toUpperCase();
    }

    public static boolean processarCompra() {

        System.out.print("Carro encontrado. Deseja comprar o carro? (S/N): ");
        String resposta = sc.next();
        if (resposta.equalsIgnoreCase("S")) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean desejaContinuarBusca() {
        System.out.println("Este carro não existe");
        System.out.print("Deseja continuar procurando? (S/N): ");
        String resposta = sc.next().toUpperCase();
        return resposta.equalsIgnoreCase("S");
    }

    public static void preencherEstoque(String[] estoque) {

        for (int i = 0; i < estoque.length; i++) {

            System.out.print("Informe o nome do carro: ");
            estoque[i] = sc.next().toUpperCase();

            if (i >= 5) {
                if (!desejaContinuar()) {
                    break;
                }
            }

        }

    }

    public static boolean desejaContinuar() {
        System.out.print("Deseja continuar cadastrando carros? (S/N): ");
        String resposta = sc.next().toUpperCase();
        return resposta.equalsIgnoreCase("S");
    }

    public static void exibirEstoque(String[] estoque) {
        System.out.println("--------------------");
        System.out.println("Estoque de carros:");
        for (int i = 0; i < estoque.length; i++) {
            if (estoque[i] != null) {
                System.out.println(estoque[i]);
            }
        }
        System.out.println("--------------------");
    }

    public static int buscarCarro(String[] estoque, String carro) {
        for (int i = 0; i < estoque.length; i++) {
            if (carro.equalsIgnoreCase(estoque[i])) {
                return i;
            }
        }
        return -1;
    }

    public static boolean isCarroExistente(String[] estoque, String carro) {
        for (int i = 0; i < estoque.length; i++) {
            if (carro.equalsIgnoreCase(estoque[i])) {
                return true;
            }
        }
        return false;
    }