# Guia de Estudos — Aula 05 (DESB)
### Exercícios 1 a 5: Herança, Polimorfismo e Coleções em Java

> Pasta do projeto: `C:\Users\Instrutor\Aula05_EX1a5_DESB`
> Aluno: Raphael Gouvêa Reche — Prof. Me. Daniel Vieira

---

## 1. Mapa do projeto

Cada exercício vive no seu próprio **pacote**, dentro de `Exercicios/`:

```
Aula05_EX1a5_DESB/
└── Exercicios/
    ├── Ex1Aula05DESB/   Filme, FilmeAcao, FilmeDocumentario, Ex1
    ├── Ex2Aula05DESB/   Funcionario, Operador, Supervisor, Ex2
    ├── Ex3Aula05DESB/   Produto, ProdutoFisico, ProdutoDigital, Ex3
    ├── Ex4Aula05DESB/   Maquina, Esteira, RoboIndustrial, Prensa, Ex4
    └── Ex5Aula05DESB/   Pagamento, PagamentoPix, PagamentoCartao, PagamentoBoleto, Ex5
```

A primeira linha de todo arquivo declara o pacote, por exemplo:

```java
package Exercicios.Ex2Aula05DESB;
```

> **Regra de ouro:** o `package` tem que ser igual ao caminho de pastas. Por isso a
> compilação e a execução são **sempre feitas da raiz** `Aula05_EX1a5_DESB`, nunca de
> dentro da pasta do exercício.

| Exercício | Cenário | Conceito que ele treina |
|-----------|---------|-------------------------|
| Ex1 | Catálogo de streaming | Herança + `@Override` de um método de exibição |
| Ex2 | Folha de pagamento | `@Override` de um método que **retorna** valor |
| Ex3 | Frete de e-commerce | Upcasting: por que `Produto p = new ProdutoFisico(...)` funciona |
| Ex4 | Linha de produção | `List<Maquina>` + laço `for` com objetos de tipos diferentes |
| Ex5 | Formas de pagamento | Três subclasses, duas sobrescritas, `List` + for-each |

---

## 2. Os conceitos, um a um

### 2.1 A estrutura que se repete nos cinco exercícios

Todos seguem o mesmo esqueleto. Reconhecer esse padrão é metade da matéria:

1. Uma **superclasse** com atributos `private`, construtor, getters e um método "genérico".
2. Duas ou três **subclasses** com `extends`, um atributo próprio e o método sobrescrito.
3. Uma classe `ExN` com o `main`, criando objetos das subclasses em **referências da superclasse**.

### 2.2 Herança: `extends` e `super(...)`

A subclasse não repete os atributos da superclasse — ela os herda e passa os valores
para cima com `super(...)`:

```java
public class Supervisor extends Funcionario {

    private double bonus;

    public Supervisor(String nome, String matricula, double salarioBase, double bonus){
        super(nome, matricula, salarioBase);   // 1ª linha, obrigatoriamente
        this.bonus = bonus;                    // o que é só da subclasse
    }
}
```

> `super(...)` **precisa ser a primeira instrução** do construtor. Se você puser
> qualquer linha antes, o compilador reclama: `call to super must be first statement`.

Como `nome`, `matricula` e `salarioBase` são `private` na superclasse, a subclasse
**não** os acessa direto — usa os getters (`getSalarioBase()`). Isso é encapsulamento
funcionando junto com herança.

### 2.3 Polimorfismo — o coração da aula

Polimorfismo é: **a variável é de um tipo, o objeto é de outro, e quem decide o
comportamento é o objeto**.

```java
Funcionario funcionario1 = new Operador("Carlos Silva", "OP-1001", 2500.00, 12, 25.50);
Funcionario funcionario2 = new Supervisor("Marina Souza", "SU-2002", 4800.00, 1200.00);

funcionario1.calcularSalario();   // roda a versão do Operador   → 2806.0
funcionario2.calcularSalario();   // roda a versão do Supervisor → 6000.0
```

A mesma linha de código produz resultados diferentes. São dois momentos distintos:

| Momento | Quem manda | O que decide |
|---------|-----------|--------------|
| Compilação | o **tipo da variável** (`Funcionario`) | quais métodos você **pode chamar** |
| Execução | o **objeto real** (`Operador`) | qual versão do método **roda de fato** |

É exatamente a resposta pedida no **Ex3**: um `ProdutoFisico` cabe numa variável
`Produto` porque todo ProdutoFisico **é um** Produto (relação "é-um" criada pelo
`extends`). Isso se chama *upcasting* e é automático.

> ⚠️ O outro lado da moeda: declarado como `Funcionario`, `funcionario1.getHorasExtras()`
> **não compila** — `Funcionario` não conhece esse método. Você precisaria declarar
> `Operador funcionario1 = ...` ou fazer um *cast*: `((Operador) funcionario1).getHorasExtras()`.

### 2.4 `@Override` — por que sempre escrever

`@Override` não muda o funcionamento; ele **pede ao compilador que confira** se você
está mesmo sobrescrevendo algo. Se errar o nome (`calcularSalarios()`) ou os
parâmetros, dá erro na hora, em vez de o programa rodar chamando silenciosamente o
método errado da superclasse.

### 2.5 `super.metodo()` — estender em vez de substituir

Sobrescrever não obriga a jogar fora o que a superclasse fazia. Nos Ex1, Ex2 e Ex5 a
subclasse acrescenta a sua parte e delega o resto:

```java
@Override
public void exibirDados(){
    System.out.println("--- Operador ---");
    super.exibirDados();                    // reaproveita nome, matricula, salario
    System.out.println("Horas extras: " + horasExtras);
}
```

Sem o `super.exibirDados()` você teria que copiar e colar três `println` em cada
subclasse — e corrigir em três lugares quando mudasse o formato.

**Detalhe fino do Ex5:** `processarPagamento()` na superclasse chama `calcularTaxa()`.
Como `calcularTaxa()` é sobrescrito, o `PagamentoCartao` cobra 3% mesmo o cálculo
sendo disparado por um código que está lá na classe `Pagamento`. Um método da
superclasse chamando a versão sobrescrita da subclasse: isso é polimorfismo trabalhando
para você.

### 2.6 Sobrescrever método que retorna valor

Nos Ex1 e Ex4 o método sobrescrito é `void` (só imprime). Nos Ex2, Ex3 e Ex5 ele
**devolve um número**, e a fórmula muda em cada subclasse:

| Exercício | Método | Superclasse | Subclasse A | Subclasse B |
|-----------|--------|-------------|-------------|-------------|
| Ex2 | `calcularSalario()` | `salarioBase` | Operador: `+ (horasExtras * valorHoraExtra)` | Supervisor: `+ bonus` |
| Ex3 | `calcularFrete()` | `0` | Físico: `peso * 8.0` | Digital: `0` |
| Ex5 | `calcularTaxa()` | `0` | Cartão: `valor * 0.03` | Boleto: `valor * 0.01` / Pix: `0` |

### 2.7 Coleções: `List` e `ArrayList`

Nos Ex4 e Ex5 a lista guarda a **superclasse** e aceita qualquer subclasse:

```java
import java.util.ArrayList;
import java.util.List;

List<Maquina> maquinas = new ArrayList<>();
maquinas.add(new Esteira("MQ-01", "Esteira Principal", "Ativa", 1.2));
maquinas.add(new RoboIndustrial("MQ-02", "Robo de Montagem", "Ativa", 6));
maquinas.add(new Prensa("MQ-03", "Prensa Hidraulica", "Manutencao", 150.0));
```

Repare em `List<Maquina> maquinas = new ArrayList<>();` — declara-se pela **interface**
`List` e instancia-se a **classe** `ArrayList`. Trocar por `LinkedList` depois não
quebraria o resto do código.

Duas formas de percorrer, as duas usadas nos exercícios:

```java
// for indexado (Ex4 — como o enunciado pede)
for (int i = 0; i < maquinas.size(); i++){
    maquinas.get(i).operar();
}

// for-each (Ex5 — mais limpo quando não precisa do índice)
for (Pagamento pagamento : pagamentos){
    pagamento.processarPagamento();
}
```

**O ponto que o enunciado do Ex4 quer que você observe:** o laço tem uma única linha
de chamada, `operar()`, e mesmo assim a saída é diferente para cada máquina. Se um dia
entrar uma `Injetora extends Maquina`, o laço **não muda nada** — só o `add`.

---

## 3. Comandos essenciais no Terminal

> Abra o terminal **na raiz do projeto**. No VS Code o atalho é `Ctrl` + crase.
> ```powershell
> cd C:\Users\Instrutor\Aula05_EX1a5_DESB
> ```

### 3.1 Conferir o ambiente

```powershell
java -version      # versão da JVM (executa)
javac -version     # versão do compilador
git --version      # versão do Git
```

### 3.2 Compilar e executar — o ciclo do dia a dia

Como as classes estão em pacotes, o caminho entra no comando:

```powershell
# 1) Compilar TODOS os exercícios de uma vez
javac -encoding UTF-8 Exercicios/*/*.java

# 2) Executar um exercício (nome COMPLETO: pacote.Classe, com pontos)
java Exercicios.Ex1Aula05DESB.Ex1
java Exercicios.Ex2Aula05DESB.Ex2
java Exercicios.Ex3Aula05DESB.Ex3
java Exercicios.Ex4Aula05DESB.Ex4
java Exercicios.Ex5Aula05DESB.Ex5
```

**Compilar só um exercício** (quando você mexeu em uma pasta só):

```powershell
javac -encoding UTF-8 Exercicios/Ex2Aula05DESB/*.java
```

**Tudo em um comando só** (compila e, se der certo, executa):

```powershell
javac -encoding UTF-8 Exercicios/*/*.java; if ($?) { java Exercicios.Ex5Aula05DESB.Ex5 }
```

> No PowerShell **não** existe `&&`. Use `; if ($?) { ... }` para "só execute se o
> anterior deu certo".

### 3.3 Separar os `.class` dos `.java` (opcional, deixa a pasta limpa)

```powershell
javac -encoding UTF-8 -d bin Exercicios/*/*.java
java -cp bin Exercicios.Ex4Aula05DESB.Ex4
```

O `-d bin` manda os compilados para `bin/`, e o `-cp bin` diz à JVM onde procurá-los.

### 3.4 Acentuação correta no terminal Windows

Os códigos deste projeto foram escritos **sem acentos de propósito**, justamente para
não depender disso. Se um dia usar acentos:

```powershell
chcp 65001                          # muda o terminal para UTF-8
javac -encoding UTF-8 Exercicios/*/*.java
```

### 3.5 Limpeza

```powershell
Get-ChildItem -Recurse -Filter *.class | Remove-Item
```

### 3.6 Git — salvando seu progresso

```powershell
git init                                  # só na primeira vez
git status                                # o que mudou
git add .                                 # marca tudo para o commit
git commit -m "Exercicios 1 a 5 da Aula 05"
git log --oneline                         # histórico resumido
```

Um `.gitignore` evita subir os compilados — crie o arquivo com duas linhas,
`*.class` e `bin/`.

### 3.7 Saída esperada dos programas

```
> java Exercicios.Ex1Aula05DESB.Ex1
--- Filme de Acao ---
Titulo: Velocidade Maxima
Duracao: 118 minutos
Classificacao: 16 anos
Nivel de violencia: Alto

--- Documentario ---
Titulo: Oceanos Profundos
Duracao: 95 minutos
Classificacao: Livre
Tema: Vida marinha
```

```
> java Exercicios.Ex2Aula05DESB.Ex2
--- Operador ---
Nome: Carlos Silva
Matricula: OP-1001
Salario base: R$ 2500.0
Horas extras: 12
Valor da hora extra: R$ 25.5
Salario final: R$ 2806.0          <- 2500 + (12 x 25,50)

--- Supervisor ---
Nome: Marina Souza
Matricula: SU-2002
Salario base: R$ 4800.0
Bonus: R$ 1200.0
Salario final: R$ 6000.0          <- 4800 + 1200
```

```
> java Exercicios.Ex3Aula05DESB.Ex3
--- Produto Fisico ---
Codigo: PF-100
Nome: Teclado Mecanico
Preco: R$ 320.0
Peso: 1.5 kg
Frete: R$ 12.0                    <- 1,5 x 8,0

--- Produto Digital ---
Codigo: PD-200
Nome: Curso de Java
Preco: R$ 149.9
Formato: Video online
Frete: R$ 0.0
(+ a explicação sobre upcasting, impressa ao final)
```

```
> java Exercicios.Ex4Aula05DESB.Ex4
[MQ-01] Esteira Principal (Ativa)
Transportando materiais a 1.2 m/s.

[MQ-02] Robo de Montagem (Ativa)
Realizando operacao de montagem com 6 eixos.

[MQ-03] Prensa Hidraulica (Manutencao)
Executando processo de conformacao com 150.0 toneladas de forca.
```

```
> java Exercicios.Ex5Aula05DESB.Ex5
--- Pagamento via PIX ---
Chave PIX: raphael@email.com
Processando pagamento de R$ 250.0 em 05/09/2026
Taxa: R$ 0.0
Total: R$ 250.0

--- Pagamento via Cartao ---
Cartao: **** **** **** 1234
Parcelas: 3x
Processando pagamento de R$ 400.0 em 05/09/2026
Taxa: R$ 12.0                     <- 3% de 400
Total: R$ 412.0

--- Pagamento via Boleto ---
Codigo de barras: 34191.79001 01043.510047
Processando pagamento de R$ 180.0 em 05/09/2026
Taxa: R$ 1.8                      <- 1% de 180
Total: R$ 181.8
```

---

## 4. Erros comuns nesta matéria

| Mensagem | Causa provável | Como resolver |
|----------|----------------|---------------|
| `Could not find or load main class Exercicios.Ex2...` | rodou de dentro da pasta do exercício | volte para `Aula05_EX1a5_DESB` e use o nome completo do pacote |
| `class Ex2 is public, should be declared in a file named Ex2.java` | nome do arquivo ≠ nome da classe | renomeie o arquivo (maiúsculas contam) |
| `call to super must be first statement in constructor` | `super(...)` não é a primeira linha | mova o `super(...)` para o topo do construtor |
| `cannot find symbol: method getHorasExtras()` | chamou método da subclasse por variável da superclasse | declare como `Operador` ou faça o *cast* |
| `constructor Funcionario in class Funcionario cannot be applied to given types` | número/ordem de parâmetros no `super(...)` não bate | confira a assinatura do construtor da superclasse |
| `method does not override or implement a method from a supertype` | `@Override` num método com nome/parâmetros diferentes | corrija a assinatura — o `@Override` acabou de te salvar |
| `NullPointerException` | usou um objeto que é `null` | verifique se esqueceu o `new` ou o `this.` |
| `cannot find symbol: class List` | faltou o import | `import java.util.List;` e `import java.util.ArrayList;` |
| `error: ';' expected` | falta ponto e vírgula | olhe a **linha anterior** à indicada |
| Acentos saem como `?` ou `Ã©` | terminal em outra codificação | `chcp 65001` e compile com `-encoding UTF-8` |

---

## 5. Perguntas de revisão (responda sem olhar o código)

1. Por que `Produto produto = new ProdutoDigital(...)` compila, mas
   `ProdutoDigital pd = new Produto(...)` não?
2. No Ex5, `processarPagamento()` está escrito **uma vez só** na classe `Pagamento`.
   Como ele consegue imprimir taxas diferentes para PIX, cartão e boleto?
3. O que aconteceria no Ex4 se você **removesse** o `@Override` do `operar()` da
   `Prensa` mas mantivesse o método igual? E se errasse o nome para `operarr()`?
4. Por que `Operador` precisa chamar `getSalarioBase()` em vez de usar `salarioBase`
   direto?
5. No Ex2, o que muda no `main` se amanhã surgir um `Gerente extends Funcionario`?
6. Qual a diferença entre **sobrescrever** (`@Override`) e **sobrecarregar**
   (dois métodos com o mesmo nome e parâmetros diferentes)?

---

## 6. Glossário rápido

| Termo | O que é |
|-------|---------|
| **Classe** | a fôrma: define atributos e métodos |
| **Objeto** | o que sai da fôrma, criado com `new` |
| **Construtor** | método sem retorno, com o nome da classe, que inicializa o objeto |
| **`this`** | "o objeto atual" — separa o atributo do parâmetro de mesmo nome |
| **Encapsulamento** | atributos `private`, acesso por getters/setters |
| **Herança (`extends`)** | a subclasse ganha atributos e métodos da superclasse |
| **`super(...)`** | chama o construtor da superclasse |
| **`super.metodo()`** | chama a versão da superclasse do método sobrescrito |
| **Sobrescrita (`@Override`)** | subclasse redefine um método herdado, mesma assinatura |
| **Polimorfismo** | mesma chamada, comportamentos diferentes conforme o objeto |
| **Upcasting** | guardar um objeto da subclasse numa variável da superclasse |
| **`List` / `ArrayList`** | interface e implementação da lista que cresce sozinha |
| **Pacote (`package`)** | pasta lógica das classes; precisa espelhar a pasta física |

---

## 7. Checklist antes de entregar a atividade

- [ ] `javac -encoding UTF-8 Exercicios/*/*.java` compila **sem nenhum erro**
- [ ] Os cinco `main` rodam e imprimem a saída da seção 3.7
- [ ] Toda subclasse usa `@Override` nos métodos sobrescritos
- [ ] Todo atributo é `private`, com getter quando precisa ser lido de fora
- [ ] No `main`, os objetos estão em referências da **superclasse** (é o que prova o polimorfismo)
- [ ] Ex4 e Ex5 usam `List` percorrida por laço, sem `if` para diferenciar o tipo
- [ ] Ex2 tem também o `exibirDados()` sobrescrito (o desafio do enunciado)
- [ ] Ex3 traz a explicação do upcasting pedida no enunciado
- [ ] Arquivos `.class` fora do commit (`.gitignore`)
- [ ] `git log --oneline` mostra o commit da entrega
