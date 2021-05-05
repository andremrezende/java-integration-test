# Ambiente completo para testes integrados ou comportamento

Para testes de de integração utilizaremos Cucumber, Rest Assured e TestContainers, 
tornando mais fácil montar o ambiente e testar o comportamento de uma aplicação.
Não será considerado simulações de chamadas por browsers (ex. Chrome, IE, Edge, Firefox, ...), para isso
é interessante utilizar ferramentas como Selenium ou TestCafe.

## Requisitos
Abaixo é necessário ter instalado localmente:
  * Java 11+
  * Gradle
  * Docker
  * IDEA
  * Plugin Gradle IDEA

**Antes de iniciar o projeto baixar a images do ruyk: docker pull testcontainersofficial/ryuk:0.3.0**

## Próximos
Além de testar código de retorno de requisições, é importante
validar o corpo da resposta e também o tempo de resposta e até um
cenário de timeout.

## Conclusão
O que vai garantir a qualidade é os scenarios de testes e não o Cucumber por si só.
Entender o cenário é extramamente importante, podendo até ser utilizado como aceite
de entrega em um projeto que utiliza alguma metodologia Ágil como aceite de um
Product Owner.
