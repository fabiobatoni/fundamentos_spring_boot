![image](https://github.com/fabiobatoni/fundamentos_spring_boot/assets/57717982/4d1215fe-e96c-4a10-8255-63c36dbff265)


------------------
## Fundamentos SpringBoot


O Spring Boot é um projeto dentro do ecossistema do Spring Framework que facilita o desenvolvimento de aplicações Java. Antes, era necessário fazer várias configurações e escrever arquivos XML, mas com o Spring Boot, isso não é mais necessário. Além disso, o Spring Boot integra-se facilmente com outras bibliotecas, como o Spring Data, que permite trabalhar com bancos de dados de forma rápida e fácil. O Spring Boot se tornou popular devido à sua facilidade de uso, flexibilidade e desempenho.

------------------

## Criando Projeto

Ao acessar o Spring Initializer, podemos selecionar o tipo de projeto (Maven ou Gradle), a linguagem (Java, Kotlin ou Groovy) e a versão do Spring Boot que desejamos utilizar. É importante escolher uma versão estável para garantir que nossa aplicação esteja pronta para produção.

Também podemos definir as informações do projeto, como o grupo, o nome e a descrição. Além disso, podemos adicionar as dependências necessárias para nossa aplicação. No exemplo dado, foram adicionadas as dependências do Spring Web e do Spring Boot DevTools.

Após configurar todas as opções, podemos gerar o projeto e baixar o arquivo ZIP contendo a estrutura básica do projeto. Em seguida, podemos importar o projeto em nossa IDE de preferência, como o Visual Studio Code, e começar a desenvolver nossa aplicação Spring Boot.

É importante destacar que o Spring Boot oferece a opção de empacotamento em formato JAR ou WAR. O formato JAR é utilizado para aplicações standalone, enquanto o formato WAR é utilizado para aplicações web que precisam ser implantadas em um servidor de aplicação.

---------------------

## Conceitos API REST

Uma API REST é uma forma de comunicação entre um cliente e um servidor, onde o cliente envia requisições para o servidor e recebe respostas com base nas operações desejadas. As requisições são feitas através de URLs, que contêm recursos identificados.

Além disso, as requisições podem ter diferentes tipos de operações, como busca, cadastro, atualização e remoção, que são definidas pelos métodos HTTP, como GET, POST, PUT e DELETE. Também é possível enviar parâmetros de consulta, que podem ser obrigatórios (Path Params) ou opcionais (Query Params). Os parâmetros também podem ser enviados no corpo da requisição (Body Params) ou nos cabeçalhos (Header Params).

É importante entender que as requisições em uma API REST são independentes e não possuem estado, ou seja, todas as informações necessárias para processar a requisição devem ser enviadas a cada solicitação.

![image](https://github.com/fabiobatoni/fundamentos_spring_boot/assets/57717982/87f3bb2e-6b0b-4746-a094-f3928c4e0c8e)


--------------------- 

## Response Entity 

ResponseEntity, que nos permite definir o status e o corpo da resposta. Podemos retornar diferentes tipos de objetos, adaptando a resposta de acordo com o objeto que estamos tratando. Também vamos explorar os diferentes códigos de status HTTP, como os de sucesso (200, 201, 202) e os de erro (400, 500). O ResponseEntity é uma entidade de retorno que nos permite trabalhar com diferentes formas de resposta em uma API REST.

```
@GetMapping("/metodoResponseEntity/{id}")
  public ResponseEntity<Object> metodoResponseEntity(@PathVariable Long id){
    var usuario = new Usuario("fabiobatoni");
    if(id > 5){
      return ResponseEntity.status(HttpStatus.CREATED).body(usuario);
    }
    return ResponseEntity.badRequest().body("Numero menor que 5");
  }

```

----------------------

## Ioc DI

Um bin é um objeto gerenciado pelo container IOC, ou seja, é criado e configurado pelo container e pode ser injetado em outros bins. Para indicar que uma classe será gerenciada pelo Spring, utilizamos annotations como @Component ou @Service. O Spring utiliza o conceito de IOC (Inversão de Controle) para gerenciar os componentes da aplicação e a injeção de dependência para conectar os componentes. 

## Component: 
```
package br.com.fabiobatoni.ioc_di;
import org.springframework.stereotype.Service;

@Service
public class MeuComponent {
  
  public String chamarMeuComponent() {
    return "chamando meu component";
  }
}
```

```
package br.com.fabiobatoni.ioc_di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/component")
public class MeuControllerComponent {

  @Autowired
  MeuComponent meuComponent;
  
  @GetMapping()
  public String chamandoComponent() {
    var resultado = meuComponent.chamarMeuComponent();
    return resultado;
  }
}
```
