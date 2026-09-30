<h1 align="center">🍽️ Diário Gastronômico</h1>

<p align="center">
  Aplicativo mobile Android que conecta <strong>restaurantes</strong> e <strong>consumidores</strong> em torno de experiências gastronômicas.
  Restaurantes divulgam seu cardápio e pratos; consumidores pesquisam locais, avaliam e registram suas experiências em um diário pessoal.
</p>

<p align="center">
  <img src="https://img.shields.io/badge/Android-App-3DDC84?logo=android&logoColor=white" />
  <img src="https://img.shields.io/badge/Java-Language-orange?logo=openjdk&logoColor=white" />
  <img src="https://img.shields.io/badge/Material%20Design-3-blue?logo=materialdesign&logoColor=white" />
  <img src="https://img.shields.io/badge/XML-Layouts-red?logo=xml&logoColor=white" />
  <img src="https://img.shields.io/badge/Firebase-Auth-yellow?logo=firebase&logoColor=black" />
  <img src="https://img.shields.io/badge/Cloud%20Firestore-Database-orange?logo=firebase&logoColor=black" />
  <img src="https://img.shields.io/badge/Firebase-Storage-ffca28?logo=firebase&logoColor=black" />
  <img src="https://img.shields.io/badge/Gradle-Build-02303A?logo=gradle&logoColor=white" />
</p>

<hr/>

## 📖 Sobre o projeto

O **Diário Gastronômico** é um trabalho da disciplina de **Programação Mobile** (Uniftec). O app possui dois tipos de usuário — **consumidor** e **restaurante** — definidos no momento do cadastro. Os consumidores exploram estabelecimentos, consultam avaliações da comunidade e registram suas próprias experiências com nota, comentário e fotos, formando um diário pessoal. Os restaurantes mantêm o perfil do estabelecimento e do cardápio, e acompanham as avaliações recebidas.

## ✨ Funcionalidades

### 👤 Consumidor
- Cadastro e login com escolha do tipo de perfil
- Pesquisa de restaurantes por nome, tipo de culinária e localização
- Visualização do restaurante: cardápio, fotos, nota média e avaliações
- Avaliação de restaurantes e pratos (nota de 1 a 5, comentário e fotos)
- Diário pessoal com o histórico das avaliações, em ordem cronológica
- Edição e exclusão das próprias avaliações

### 🍴 Restaurante
- Cadastro e manutenção do estabelecimento (nome, descrição, culinária, endereço, telefone, horário e capa)
- Cadastro, edição e remoção de pratos (nome, descrição, preço, categoria e fotos)
- Gerenciamento do cardápio com disponibilidade dos pratos
- Painel com nota média, total de avaliações e avaliações recebidas

## 📱 Telas
Boas-vindas · Login · Cadastro · Explorar · Detalhe do restaurante · Detalhe do prato · Avaliar · Diário · Perfil · Painel do restaurante · Cadastro de estabelecimento · Cadastro de prato · Gerenciar cardápio · Avaliações recebidas

## 🛠️ Tecnologias
- **Android** (Java)
- **Layouts em XML** com **Material Design 3**
- **Firebase** (Authentication, Cloud Firestore e Storage)
- **Gradle**

## 🔥 Integrações Firebase
- **Authentication** — cadastro, login e controle de sessão
- **Cloud Firestore** — dados de usuários, restaurantes, pratos e avaliações
- **Storage** — imagens de perfis, pratos e avaliações

## 🚀 Como executar
```bash
# clone o repositório
git clone https://github.com/<usuario>/DiarioGastronomico.git
```
1. Abra o projeto no **Android Studio**
2. Adicione o arquivo `google-services.json` (Firebase) em `app/`
3. Sincronize o Gradle e execute em um emulador ou dispositivo

## 👥 Autores
- Gustavo Longo
- Leonardo Trevisol
- Viktor Rogalski

<p align="center">🎓 Centro Universitário Uniftec — Programação Mobile</p>
