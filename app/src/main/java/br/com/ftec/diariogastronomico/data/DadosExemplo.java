package br.com.ftec.diariogastronomico.data;

import java.util.ArrayList;
import java.util.List;

import br.com.ftec.diariogastronomico.R;
import br.com.ftec.diariogastronomico.model.Avaliacao;
import br.com.ftec.diariogastronomico.model.Cliente;
import br.com.ftec.diariogastronomico.model.Foto;
import br.com.ftec.diariogastronomico.model.Prato;
import br.com.ftec.diariogastronomico.model.Restaurante;
import br.com.ftec.diariogastronomico.model.TipoAvaliacao;

public final class DadosExemplo {

    private static List<Restaurante> restaurantes;
    private static List<Avaliacao> diario;
    private static Cliente clienteLogado;

    private DadosExemplo() {}

    public static List<Restaurante> getRestaurantes() {
        if (restaurantes == null) montar();
        return restaurantes;
    }

    public static Restaurante getRestaurante(String id) {
        for (Restaurante r : getRestaurantes()) {
            if (r.getId().equals(id)) return r;
        }
        return getRestaurantes().get(0);
    }

    public static Prato getPrato(String id) {
        for (Restaurante r : getRestaurantes()) {
            for (Prato p : r.getPratos()) {
                if (p.getId().equals(id)) return p;
            }
        }
        return getRestaurantes().get(0).getPratos().get(0);
    }

    public static Restaurante getRestauranteLogado() {
        return getRestaurante("r1");
    }

    public static List<Avaliacao> getAvaliacoesRecebidas() {
        return getRestauranteLogado().getAvaliacoes();
    }

    public static List<Avaliacao> getDiario() {
        if (diario == null) montar();
        return diario;
    }

    public static Cliente getClienteLogado() {
        if (clienteLogado == null) montar();
        return clienteLogado;
    }

    private static void montar() {
        clienteLogado = new Cliente("c1", "Leonardo Trevisol", "leo@email.com",
                R.drawable.ph_avatar, 27, 12, 14, 4.6);

        restaurantes = new ArrayList<>();

        Restaurante r1 = new Restaurante("r1", "Cantina della Nonna", "contato@cantina.com",
                "Cantina de família com receitas tradicionais italianas, massas artesanais feitas na "
                        + "hora e um ambiente aconchegante no coração da cidade.",
                "Italiana", "Rua Sinimbu, 1450 · Centro, Caxias do Sul", "(54) 3333-1450",
                "Seg a Sáb · 11h às 23h", "1,2 km", R.drawable.ph_cover_1, 4.8, 128, true);
        r1.addPrato(new Prato("r1p1", "Nhoque ao Sugo",
                "Nhoque de batata artesanal com molho de tomate italiano e manjericão fresco.",
                42.90, "Massas", true, 4.9, 47, R.drawable.ph_food_1)
                .addFoto(new Foto(R.drawable.ph_food_1)).addFoto(new Foto(R.drawable.ph_food_5))
                .addFoto(new Foto(R.drawable.ph_food_6)));
        r1.addPrato(new Prato("r1p2", "Parmegiana da Casa",
                "Filé empanado, molho pomodoro, muçarela gratinada e arroz.",
                58.00, "Carnes", true, 4.7, 31, R.drawable.ph_food_4));
        r1.addPrato(new Prato("r1p3", "Risoto de Funghi",
                "Risoto cremoso com mix de cogumelos e parmesão.",
                49.90, "Massas", true, 4.8, 22, R.drawable.ph_food_5));
        r1.addPrato(new Prato("r1p4", "Tiramisù",
                "Sobremesa italiana com café, mascarpone e cacau.",
                24.90, "Sobremesas", false, 4.6, 18, R.drawable.ph_food_6));
        r1.addFoto(new Foto(R.drawable.ph_food_1)).addFoto(new Foto(R.drawable.ph_food_4))
                .addFoto(new Foto(R.drawable.ph_food_5)).addFoto(new Foto(R.drawable.ph_food_2));
        r1.addAvaliacao(new Avaliacao("a1", TipoAvaliacao.PRATO, 5,
                "Massa perfeita, o nhoque derrete na boca. Já virou meu favorito no centro!",
                "12 set 2026", "Mariana Souza", R.drawable.ph_avatar_a, "Nhoque ao Sugo", R.drawable.ph_food_1)
                .addFoto(new Foto(R.drawable.ph_food_1)).addFoto(new Foto(R.drawable.ph_food_5)));
        r1.addAvaliacao(new Avaliacao("a2", TipoAvaliacao.RESTAURANTE, 4,
                "Ambiente super aconchegante e porções generosas. Só o tempo de espera que foi um pouco longo.",
                "08 set 2026", "Rafael Lima", R.drawable.ph_avatar_b, "Cantina della Nonna", R.drawable.ph_cover_1));
        r1.addAvaliacao(new Avaliacao("a3", TipoAvaliacao.PRATO, 5,
                "Risoto cremoso e muito saboroso. Atendimento nota 10, voltarei com certeza.",
                "05 set 2026", "Camila Reis", R.drawable.ph_avatar_c, "Risoto de Funghi", R.drawable.ph_food_5));
        restaurantes.add(r1);

        Restaurante r2 = new Restaurante("r2", "Verde & Sabor", "ola@verdesabor.com",
                "Restaurante vegano com pratos frescos, orgânicos e muito sabor.",
                "Vegana", "Av. Júlio de Castilhos, 320 · Exposição", "(54) 3222-0320",
                "Ter a Dom · 11h às 22h", "2,4 km", R.drawable.ph_cover_3, 4.6, 74, true);
        r2.addPrato(new Prato("r2p1", "Buddha Bowl",
                "Mix de folhas, grãos, legumes assados e molho tahine.",
                36.00, "Saladas", true, 4.6, 20, R.drawable.ph_food_3));
        r2.addPrato(new Prato("r2p2", "Burger Vegano",
                "Hambúrguer de grão-de-bico, salada e pão australiano.",
                39.90, "Lanches", true, 4.5, 15, R.drawable.ph_food_2));
        r2.addFoto(new Foto(R.drawable.ph_food_3)).addFoto(new Foto(R.drawable.ph_food_2));
        r2.addAvaliacao(new Avaliacao("a4", TipoAvaliacao.PRATO, 4,
                "Fresca e bem servida. Ótima opção leve para o almoço.",
                "28 ago 2026", "Leonardo Trevisol", R.drawable.ph_avatar, "Buddha Bowl", R.drawable.ph_food_3));
        restaurantes.add(r2);

        Restaurante r3 = new Restaurante("r3", "Brasa Burger House", "fala@brasaburger.com",
                "Hambúrgueres artesanais na brasa, batatas crocantes e cervejas geladas.",
                "Hambúrguer", "Rua Os Dezoito, 88 · São Pelegrino", "(54) 3555-0088",
                "Todos os dias · 18h às 23h", "3,1 km", R.drawable.ph_cover_2, 4.9, 212, true);
        r3.addPrato(new Prato("r3p1", "Classic Burger",
                "Pão brioche, blend 160g, cheddar, alface e tomate.",
                32.00, "Lanches", true, 4.9, 88, R.drawable.ph_food_2));
        r3.addPrato(new Prato("r3p2", "Bacon Duplo",
                "Dois blends, bacon crocante e molho da casa.",
                38.00, "Lanches", true, 4.8, 64, R.drawable.ph_food_6));
        r3.addFoto(new Foto(R.drawable.ph_food_2)).addFoto(new Foto(R.drawable.ph_food_6));
        r3.addAvaliacao(new Avaliacao("a5", TipoAvaliacao.RESTAURANTE, 5,
                "Melhor hambúrguer da cidade! Suculento e bem servido.",
                "02 set 2026", "Rafael Lima", R.drawable.ph_avatar_b, "Brasa Burger House", R.drawable.ph_cover_2));
        restaurantes.add(r3);

        diario = new ArrayList<>();
        diario.add(new Avaliacao("d1", TipoAvaliacao.PRATO, 5,
                "Massa perfeita, o nhoque derrete na boca. Melhor que já comi na cidade.",
                "12 set 2026", "Leonardo Trevisol", R.drawable.ph_avatar, "Nhoque ao Sugo", R.drawable.ph_food_1));
        diario.add(new Avaliacao("d2", TipoAvaliacao.RESTAURANTE, 5,
                "Ambiente aconchegante e atendimento impecável. Voltarei com certeza!",
                "12 set 2026", "Leonardo Trevisol", R.drawable.ph_avatar, "Cantina della Nonna", R.drawable.ph_cover_1));
        diario.add(new Avaliacao("d3", TipoAvaliacao.RESTAURANTE, 4,
                "Hambúrguer suculento e batatas crocantes. Só a fila que estava grande.",
                "06 set 2026", "Leonardo Trevisol", R.drawable.ph_avatar, "Brasa Burger House", R.drawable.ph_cover_2));
        diario.add(new Avaliacao("d4", TipoAvaliacao.PRATO, 4,
                "Fresca e bem servida. Ótima opção leve para o almoço.",
                "28 ago 2026", "Leonardo Trevisol", R.drawable.ph_avatar, "Buddha Bowl", R.drawable.ph_food_3));
    }
}
