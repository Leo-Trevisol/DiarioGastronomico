<h1 align="center">🍽️ Diário Gastronômico</h1>

<p align="center">
  Aplicativo mobile <strong>Android</strong> que conecta <strong>restaurantes</strong> e <strong>consumidores</strong> em torno de experiências gastronômicas.
  Restaurantes divulgam seu cardápio e pratos; consumidores pesquisam locais, avaliam e registram suas experiências em um diário pessoal.
</p>

<p align="center">
  <img src="https://img.shields.io/badge/Android-App-3DDC84?logo=android&logoColor=white" />
  <img src="https://img.shields.io/badge/Java-11-orange?logo=openjdk&logoColor=white" />
  <img src="https://img.shields.io/badge/Material%20Design-3-blue?logo=materialdesign&logoColor=white" />
  <img src="https://img.shields.io/badge/Fragments-Navigation-6200EE?logo=android&logoColor=white" />
  <img src="https://img.shields.io/badge/RecyclerView-Listas-009688?logo=android&logoColor=white" />
  <img src="https://img.shields.io/badge/minSdk-24-yellow" />
  <img src="https://img.shields.io/badge/Gradle-KTS-02303A?logo=gradle&logoColor=white" />
</p>

<hr/>

## 📖 Sobre o projeto

O **Diário Gastronômico** é um trabalho da disciplina de **Programação Mobile** (Uniftec). O sistema possui dois tipos de usuário — **consumidor** e **restaurante** — definidos no cadastro. O consumidor explora estabelecimentos, consulta avaliações da comunidade e registra as próprias experiências com nota, comentário e fotos, formando um diário pessoal. O restaurante mantém o perfil do estabelecimento e do cardápio e acompanha as avaliações recebidas.

Esta entrega corresponde ao **Desenvolvimento do Layout das Telas** e à **navegação** entre elas (Activity, Intent e Fragment). Os dados ainda não vêm do backend: são servidos por uma **camada de dados de exemplo em memória**, pronta para ser substituída pelo Firebase na etapa seguinte.

## ✨ Funcionalidades

### 👤 Consumidor
- Cadastro e login com escolha do tipo de perfil
- Pesquisa de restaurantes (busca e filtros por tipo de culinária)
- Perfil do restaurante: cardápio, fotos, nota média e avaliações
- Detalhe do prato com fotos e avaliações
- Registro de avaliação (nota de 1 a 5, comentário e fotos)
- Diário pessoal com o histórico das avaliações (editar / excluir)
- Perfil do consumidor com estatísticas

### 🍴 Restaurante
- Painel do estabelecimento com indicadores (nota, avaliações, pratos)
- Cadastro / edição do estabelecimento
- Cadastro, edição e remoção de pratos (com disponibilidade)
- Avaliações recebidas com distribuição de notas

## 📱 Telas
Boas-vindas · Login · Cadastro · Explorar · Detalhe do restaurante · Detalhe do prato · Avaliar · Diário · Perfil · Painel do restaurante · Gerenciar cardápio · Cadastro de estabelecimento · Cadastro de prato · Avaliações recebidas

## 🏗️ Arquitetura

O código é organizado em camadas, separando interface, dados e regras:

- **`model/`** — entidades do domínio conforme o diagrama de classes: `Usuario` (abstrata) → `Cliente` / `Restaurante`, `Prato`, `Avaliacao`, `Foto` e o enum `TipoAvaliacao`.
- **`data/`** — `DadosExemplo`, fonte de dados em memória que simula o backend (será trocada pelo Firebase).
- **`ui/adapter/`** — adapters de `RecyclerView` que renderizam as listas a partir do modelo.
- **`ui/fragment/`** — os Fragments de cada aba.
- **`util/`** — utilitários de UI (ex.: renderização de estrelas).

### 🧭 Navegação (Activity, Intent e Fragment)
- **Fragment + BottomNavigationView:** duas *host activities* (`ConsumidorHostActivity` e `RestauranteHostActivity`) trocam Fragments pela barra inferior, via `FragmentManager` — abas Explorar/Diário/Perfil e Painel/Cardápio/Avaliações.
- **Intent:** telas de detalhe e formulário são abertas por `Intent`, passando dados por *extras* (ex.: `restauranteId`, `pratoId`, `tipo`).
- **Activity:** telas de fluxo (boas-vindas, login, cadastro, detalhes e formulários).

## 📂 Estrutura do projeto

```
app/src/main/
├── java/br/com/ftec/diariogastronomico/
│   ├── model/           # Usuario, Cliente, Restaurante, Prato, Avaliacao, Foto, TipoAvaliacao
│   ├── data/            # DadosExemplo (dados em memória)
│   ├── ui/adapter/      # RecyclerView adapters
│   ├── ui/fragment/     # Fragments das abas
│   ├── util/            # Ui (helpers)
│   ├── BaseActivity.java
│   ├── MainActivity.java            # Boas-vindas
│   ├── LoginActivity.java / CadastroActivity.java
│   ├── ConsumidorHostActivity.java  # BottomNav (consumidor)
│   ├── RestauranteHostActivity.java # BottomNav (restaurante)
│   ├── RestauranteDetalheActivity.java / PratoDetalheActivity.java
│   ├── AvaliarActivity.java
│   └── CadastroEstabelecimentoActivity.java / CadastroPratoActivity.java
└── res/
    ├── layout/          # activity_*, fragment_*, item_*
    ├── drawable/        # ícones, placeholders e shapes
    ├── menu/            # menus do BottomNavigation
    └── values(+night)/  # cores, tema (claro/escuro), estilos
```

## 🛠️ Tecnologias
- **Android** com **Java 11** (minSdk 24, targetSdk 36)
- **Material Design 3** (Material Components)
- **Fragments** + **BottomNavigationView** para navegação
- **RecyclerView** para as listagens
- Layouts em **XML** com tema claro/escuro
- **Gradle (Kotlin DSL)**

## 🔥 Próxima etapa — Firebase
Integração planejada para a próxima entrega:
- **Authentication** — cadastro, login e sessão
- **Cloud Firestore** — usuários, restaurantes, pratos e avaliações
- **Storage** — imagens de perfis, pratos e avaliações

## 🚀 Como executar
```bash
git clone https://github.com/SEU_USUARIO/DiarioGastronomico.git
```
1. Abra o projeto no **Android Studio**
2. Sincronize o Gradle
3. Execute em um emulador ou dispositivo (Android 7.0+/API 24)

## 🌿 Branches
- **`main`** — telas com dados mockados (versão inicial do layout)
- **`feature/telas-sem-mock`** — telas com arquitetura em camadas, dados de exemplo em memória e navegação com Fragments/Intents

## 👥 Integrantes
- Gustavo Longo
- Leonardo Trevisol
- Viktor Rogalski

<p align="center">🎓 Centro Universitário Uniftec — Programação Mobile</p>
