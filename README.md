# Android-Study-Activity-Intent-Bundle-2016

Projeto Android utilizado em sala de aula para demonstrar a **navegação entre Activities** e o **envio de informações entre telas** com `Intent.putExtra()` e `Bundle`.

O exemplo acompanha um fluxo simples de cadastro: a primeira tela abre um formulário, o usuário informa seus dados e uma terceira tela recebe e apresenta as informações enviadas.

## Contexto acadêmico

Material preparado para aulas dos cursos de:

- **Sistemas de Informação — FACOL**, em Lençóis Paulista/SP;
- **Técnico em Informática — ETEC Rodrigues de Abreu**, em Bauru/SP — Centro Paula Souza.

O objetivo da atividade é exercitar conceitos básicos de navegação no Android, criação de telas, uso de `Intent` e transferência de valores entre `Activity`.

## Conteúdo trabalhado

- criação e registro de múltiplas `Activity`;
- abertura de uma nova tela com `Intent`;
- campos de entrada com `EditText`;
- eventos de botão definidos por `android:onClick`;
- envio de `String` com `Intent.putExtra()`;
- recuperação de extras com `getIntent().getExtras()`;
- leitura de valores com `Bundle.getString()`;
- apresentação de informações em `TextView`.

## Fluxo do aplicativo

```text
MainActivity
    |
    |  abrirNovaJanela()
    v
CadastroActivity
    |
    |  nome
    |  endereco
    |  email
    |
    |  Intent.putExtra(...)
    v
VisualizaActivity
    |
    |  getIntent().getExtras()
    |  Bundle.getString(...)
    v
TextView
```

## Telas

### 1. Tela inicial

`MainActivity` apresenta o botão **Abrir nova janela**. Ao acioná-lo, um `Intent` é criado apontando para `CadastroActivity`:

```java
public void abrirNovaJanela(View v){
    Intent i = new Intent(MainActivity.this, CadastroActivity.class);
    startActivity(i);
}
```

### 2. Cadastro

`CadastroActivity` possui três campos:

- nome;
- endereço;
- e-mail.

Ao pressionar **Salvar**, os valores são adicionados ao `Intent`:

```java
Intent i = new Intent(CadastroActivity.this, VisualizaActivity.class);
i.putExtra("nome", nome.getText().toString());
i.putExtra("endereco", endereco.getText().toString());
i.putExtra("email", email.getText().toString());
startActivity(i);
```

As chaves utilizadas no envio são:

| Chave | Conteúdo |
| --- | --- |
| `nome` | Nome informado no formulário |
| `endereco` | Endereço informado no formulário |
| `email` | E-mail informado no formulário |

### 3. Visualização

Na `VisualizaActivity`, os valores enviados pela tela anterior são obtidos através do `Bundle`:

```java
Bundle extras = getIntent().getExtras();
nome = extras.getString("nome");
endereco = extras.getString("endereco");
email = extras.getString("email");
```

Depois, cada valor é apresentado em seu respectivo `TextView`:

```java
txtNome.setText(nome);
txtEndereco.setText(endereco);
txtEmail.setText(email);
```

## Estrutura principal

```text
app/src/main/
├── AndroidManifest.xml
├── java/br/fabio/professor/janelasconversando/
│   ├── MainActivity.java
│   ├── CadastroActivity.java
│   └── VisualizaActivity.java
└── res/
    ├── layout/
    │   ├── activity_main.xml
    │   ├── activity_cadastro.xml
    │   └── activity_visualiza.xml
    └── values/
```

## Registro das Activities

As três telas fazem parte da mesma aplicação e são declaradas no `AndroidManifest.xml`:

```xml
<activity android:name=".MainActivity">
    <intent-filter>
        <action android:name="android.intent.action.MAIN" />
        <category android:name="android.intent.category.LAUNCHER" />
    </intent-filter>
</activity>
<activity android:name=".CadastroActivity" />
<activity android:name=".VisualizaActivity" />
```

`MainActivity` é a tela inicial da aplicação. `CadastroActivity` e `VisualizaActivity` são abertas durante o fluxo do exercício.

## Ambiente do projeto

O projeto está configurado com:

- Java;
- Android SDK 24;
- `minSdkVersion 15`;
- `targetSdkVersion 24`;
- Android Gradle Plugin 2.2.0;
- Gradle 2.14.1;
- AppCompat 24.2.1.

## Executando

1. Abra o projeto no Android Studio.
2. Aguarde a sincronização do Gradle.
3. Selecione um dispositivo ou emulador compatível.
4. Execute o módulo `app`.
5. Na tela inicial, pressione **Abrir nova janela**.
6. Informe nome, endereço e e-mail.
7. Pressione **Salvar** para visualizar os dados na próxima `Activity`.

## Exercícios

A partir deste exemplo, podem ser realizadas algumas alterações para praticar o conteúdo:

- adicionar novos campos ao formulário;
- enviar valores numéricos com os métodos correspondentes de `putExtra()`;
- validar os campos antes de abrir a próxima tela;
- incluir um botão para retornar ao cadastro;
- alterar os nomes das chaves e observar a relação entre envio e leitura;
- testar o envio de diferentes tipos de dados no `Bundle`.

---

Material acadêmico desenvolvido por **Fábio Eduardo dos Santos** em 2016.  
